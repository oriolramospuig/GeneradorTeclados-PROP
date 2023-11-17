package main.domain.classes.functions;

import main.domain.classes.types.PairFrequency;

import java.util.*;

/** Clase que a partir de las matrices de frecuencias y de distancias calcula una solución inicial y
 * llama al algoritmo de gilmore-lawler con una cota inicial
 * @author X (X@estudiantat.upc.edu)
 */
public class QAP {
    private char[][] teclado; // La matriz del teclado
    private int filas;
    private int columnas;
    private int n;
    private HashMap<Character, Integer> letraAIndice;
    private int[][] matrizFrecuencias;
    private int[][] matrizDistancias;
    private ArrayList<Character> teclasOrdenadas;
    private List<Character> teclas;
    private List<PairFrequency> frecuenciasPares;
    private int glBound;


    /*Creadora antiga*/
    public QAP(int filas, int columnas, List<Character> tecles, List<PairFrequency> paresFrecuencias) {
        this.filas = filas;
        this.columnas = columnas;
        this.n = filas*columnas;

        this.teclado = new char[filas][columnas];

        this.teclas = tecles;
        this.frecuenciasPares = paresFrecuencias;
        this.letraAIndice = new HashMap<>();
        for (int i = 0; i < teclas.size(); i++) {
            letraAIndice.put(teclas.get(i), i);
        }

        this.matrizFrecuencias = new int[filas * columnas][filas * columnas];
        Matrices.generarMatrizDeFrecuencias(frecuenciasPares, teclas, letraAIndice, matrizFrecuencias);

        this.matrizDistancias = new int[filas * columnas][filas * columnas];
        Matrices.generarMatrizDistancias(filas, columnas, matrizDistancias);

        this.teclasOrdenadas = new ArrayList<>(teclas);
        ordenarTeclas();

        calculo();
    }
    /*Creadora nova, la que volem fer servir*/
    public QAP(int n, int[][] matrizFrecuencias, int [][] matrizDistancias) {
        this.n = n;

        double raizCuadradaDouble = Math.sqrt(n);
        this.filas = (int) Math.round(raizCuadradaDouble);
        this.columnas = (int) Math.round(raizCuadradaDouble);

        this.matrizFrecuencias = matrizFrecuencias;
        this.matrizDistancias = matrizDistancias;

        int [][] indices = calcularAsignacionAleatoriaIndices();
        this.glBound = calculoPuntuacionIndices(indices);

        calculo();
    }
    /*getter que potser no calen pero abans els feia servir*/
    public int getFilas() {
        return this.filas;
    }
    public int getColumnas() {
        return this.columnas;
    }
    public int getGlBound() {
        return this.glBound;
    }
    public int[][] getMatrizFrecuencias() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.matrizFrecuencias)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }
    public int[][] getMatrizDistancias() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.matrizDistancias)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }
    public HashMap<Character, Integer> getLetraAIndice() {
        return new HashMap<>(this.letraAIndice);
    }

    public List<Character> getTeclasOrdenadas() {
        return new ArrayList<>(this.teclasOrdenadas);
    }

    /*Assignació aleatòria de m tecles a m posicions; de moment l'omplim tot sencer (12 posicions = 12 lletres)*/
    public void calcularAsignacionAleatoria(List<Character> teclas) {
        System.out.println("Asignación de las teclas aleatoria: ");
        System.out.println();
        if(teclas.size() != n) {
            throw new IllegalArgumentException("El número de teclas debe coincidir con el número de posiciones en el teclado.");
        }

        // Mezcla la lista de teclas
        Collections.shuffle(teclas);

        // Asigna las teclas aleatorizadas a la matriz del teclado
        int index = 0;
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                teclado[i][j] = teclas.get(index);
                index++;
            }
        }
    }

    public int[][] calcularAsignacionAleatoriaIndices() {
        System.out.println("Asignación aleatoria: ");
        System.out.println();

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i); // Añadir índices del 0 al n-1.
        }

        // Mezcla la lista de índices
        Collections.shuffle(indices);

        // Asigna los índices aleatorizados a la matriz del teclado
        int[][] tecladoIndices = new int[filas][columnas]; // Usando índices en lugar de caracteres.
        int index = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tecladoIndices[i][j] = indices.get(index);
                index++;
            }
        }

        // Imprime la matriz del teclado con los índices asignados
        imprimirTeclado(tecladoIndices);
        return tecladoIndices;
    }

    /*Algoritme per la sol ini. Aquest el canviarem segur, pero de moment funciona*/
    public void calcularAsignacionGreedy(List<PairFrequency> frecuenciasPares, List<Character> teclas) {
        System.out.println("Asignación de las teclas greedy: ");
        System.out.println();
        //generarMatrizDeFrecuencias(frecuenciasPares, teclas); ja es calcula a la creadora

        // Asigna las teclas más frecuentes al centro del teclado
        int centroFila = filas / 2;
        int centroColumna = columnas / 2;
        int indiceTecla = 0;

        // Determina el punto de partida para la asignación, cerca del centro
        int inicioFila = centroFila - filas / 2;
        int inicioColumna = centroColumna - columnas / 2;

        for (int i = inicioFila; i < inicioFila + filas; i++) {
            for (int j = inicioColumna; j < inicioColumna + columnas; j++) {
                // Verifica los límites del array
                if (i >= 0 && i < filas && j >= 0 && j < columnas) {
                    // Asigna la tecla a la posición actual del teclado
                    teclado[i][j] = teclas.get(indiceTecla);
                    indiceTecla++;

                    // Verifica si ya se han asignado todas las teclas
                    if (indiceTecla >= teclas.size()) {
                        return;
                    }
                }
            }
        }
    }

    public int calculoPuntuacion() {
        int puntuacion = 0;

        // Recorrer todas las combinaciones de pares de teclas.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Obtener el índice de la tecla en la posición [i][j]
                int indice1 = letraAIndice.get(teclado[i][j]);

                for (int k = i; k < filas; k++) { // Comienza con 'k = i' para evitar duplicados.
                    for (int l = (k == i) ? j + 1 : 0; l < columnas; l++) { // Si 'k == i', empieza desde 'j + 1' para evitar calcular dos veces la misma combinación
                        // Obtener el índice de la tecla en la posición [k][l]
                        int indice2 = letraAIndice.get(teclado[k][l]);

                        // Calcular la distancia Manhattan entre las dos posiciones de teclas.
                        int distancia = Manhattan.calcularDistancia(i, j, k, l);

                        // Obtener la frecuencia del par de teclas desde la matriz de frecuencias.
                        int frecuencia = matrizFrecuencias[indice1][indice2];

                        // Actualizar la puntuación sumando el producto de la distancia por la frecuencia del par de teclas.
                        // Si 'i == k' y 'j == l', es la misma tecla, por lo que la frecuencia es cero y no contribuye a la puntuación.
                        puntuacion += distancia * frecuencia;
                    }
                }
            }
        }
        System.out.println("La puntuación es: " + puntuacion);
        System.out.println();

        return puntuacion;
    }
    /*la mateixa que la de sobre pero adaptada a la estructura nova*/
    public int calculoPuntuacionIndices(int[][] tecladoIndices) {
        int puntuacion = 0;

        // Recorrer todas las combinaciones de pares de índices.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int indice1 = tecladoIndices[i][j]; // Índice en la posición [i][j]

                for (int k = i; k < filas; k++) {
                    for (int l = (k == i) ? j + 1 : 0; l < columnas; l++) {
                        int indice2 = tecladoIndices[k][l]; // Índice en la posición [k][l]

                        // Calcular la distancia Manhattan entre las dos posiciones de teclas.
                        int distancia = Manhattan.calcularDistancia(i, j, k, l);

                        // Obtener la frecuencia del par de teclas desde la matriz de frecuencias.
                        int frecuencia = matrizFrecuencias[indice1][indice2];

                        // Actualizar la puntuación sumando el producto de la distancia por la frecuencia del par de teclas.
                        puntuacion += distancia * frecuencia;
                    }
                }
            }
        }

        System.out.println("La puntuación es: " + puntuacion);
        System.out.println();

        return puntuacion;
    }



    public void imprimirTeclado() {
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                System.out.print(teclado[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void imprimirTeclado(int[][] tecladoIndices) {
        for (int i = 0; i < tecladoIndices.length; i++) {
            for (int j = 0; j < tecladoIndices[i].length; j++) {
                System.out.print(tecladoIndices[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void imprimirMatrices() {
        System.out.println("Imprimiendo matriz frecuencias: ");
        System.out.println();
        for (int i = 0; i < matrizFrecuencias.length; i++) {
            for (int j = 0; j < matrizFrecuencias[i].length; j++) {
                System.out.print(matrizFrecuencias[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Imprimiendo matriz distancias: ");
        System.out.println();
        for (int i = 0; i < matrizDistancias.length; i++) {
            for (int j = 0; j < matrizDistancias[i].length; j++) {
                System.out.print(matrizDistancias[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void ordenarTeclas() {
        List<Integer> indicesPorFrecuencia = new ArrayList<>();
        for (int i = 0; i < matrizFrecuencias.length; i++) {
            int frecuenciaTotal = 0;
            for (int j = 0; j < matrizFrecuencias[i].length; j++) {
                frecuenciaTotal += matrizFrecuencias[i][j];
            }
            indicesPorFrecuencia.add(frecuenciaTotal);
        }

        // Ordena los caracteres basándose en su frecuencia total
        teclasOrdenadas.sort(Comparator.comparingInt(letra -> -indicesPorFrecuencia.get(letraAIndice.get(letra))));
        System.out.println("Teclas ordenadas: ");
        System.out.println();
        for (int i = 0; i < teclasOrdenadas.size(); ++i) {
            System.out.println(teclasOrdenadas.get(i));
        }
    }

    public void calculo() {
        imprimirMatrices();

        //calcularAsignacionAleatoria(teclas);
        //imprimirTeclado();

        //int puntuacion = calculoPuntuacion();


        // List<Character> teclasOrdenadas = getTeclasOrdenadas();

        //calcularAsignacionGreedy(frecuenciasPares, teclasOrdenadas);
        //imprimirTeclado();

        // int puntuacionGreedy = calculoPuntuacion();


        //GilmoreLawler gilmoreLawler = new GilmoreLawler(filas, columnas, glBound, matrizFrecuencias, matrizDistancias, letraAIndice);
        //gilmoreLawler.gilmore_lawler(teclasOrdenadas, puntuacionGreedy);

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }

        GilmoreLawler gilmoreLawler = new GilmoreLawler(filas, columnas, glBound, matrizFrecuencias, matrizDistancias, letraAIndice);
        gilmoreLawler.gilmore_lawler(indices, glBound);
    }
}
