package main.domain.classes.functions;

import main.domain.classes.types.PairFrequency;

import java.util.*;

public class QAP {
    private char[][] teclado; // La matriz del teclado
    private int filas;
    private int columnas;

    /**Esto simula las frecuencias que nos entran, nose muy bien que estructura debería ser*/
    private HashMap<Character, Integer> letraAIndice;
    private int[][] matrizFrecuencias;
    private int[][] matrizDistancias;
    private ArrayList<Character> teclasOrdenadas;
    private List<Character> teclas;
    private List<PairFrequency> frecuenciasPares;

    private int glBound;


    public QAP(int filas, int columnas, List<Character> tecles, List<PairFrequency> paresFrecuencias) {
        this.filas = filas;
        this.columnas = columnas;

        this.teclado = new char[filas][columnas];

        this.teclas = tecles;
        this.frecuenciasPares = paresFrecuencias;
        this.letraAIndice = new HashMap<>();

        this.matrizFrecuencias = new int[filas * columnas][filas * columnas];
        Matrices.generarMatrizDeFrecuencias(frecuenciasPares, teclas, letraAIndice, matrizFrecuencias);

        this.matrizDistancias = new int[filas * columnas][filas * columnas];
        Matrices.generarMatrizDistancias(filas, columnas, matrizDistancias);

        this.teclasOrdenadas = new ArrayList<>();
        ordenarTeclas(teclas);
    }

    public int getFilas() {
        return this.filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return this.columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getGlBound() {
        return this.glBound;
    }

    public void setGlBound(int glBound) {
        this.glBound = glBound;
    }

    public int[][] getMatrizFrecuencias() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.matrizFrecuencias)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    public void setMatrizFrecuencias(int[][] matrizFrecuencias) {
        this.matrizFrecuencias = matrizFrecuencias;
    }

    public int[][] getMatrizDistancias() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.matrizDistancias)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    public void setMatrizDistancias(int[][] matrizDistancias) {
        this.matrizDistancias = matrizDistancias;
    }


    /**Assignació aleatòria de m tecles a m posicions; de moment l'omplim tot sencer (12 posicions = 12 lletres)*/
    public void calcularAsignacionAleatoria(List<Character> teclas) {
        System.out.println("Asignación de las teclas aleatoria: ");
        System.out.println();
        if(teclas.size() != filas * columnas) {
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
    /**Algoritme greedy per la sol ini*/
    public void calcularAsignacionGreedy(List<PairFrequency> frecuenciasPares, List<Character> teclas) {
        System.out.println("Asignación de las teclas greedy: ");
        System.out.println();
        //generarMatrizDeFrecuencias(frecuenciasPares, teclas); ja es calcula a la creadora

        // Genera una lista de índices basada en la frecuencia total de cada tecla
        List<Integer> indicesPorFrecuencia = new ArrayList<>();
        for (int i = 0; i < matrizFrecuencias.length; i++) {
            int frecuenciaTotal = 0;
            for (int j = 0; j < matrizFrecuencias[i].length; j++) {
                frecuenciaTotal += matrizFrecuencias[i][j];
            }
            indicesPorFrecuencia.add(frecuenciaTotal);
        }

        // Ordena los caracteres basándose en su frecuencia total
        teclas.sort(Comparator.comparingInt(letra -> -indicesPorFrecuencia.get(letraAIndice.get(letra))));

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

    /**Per millor la eficiencia haurem de mirar de iterar només sobre les frequencies != 0*/
    public int calcularPuntuacionTeclado() {
        int puntuacion = 0;

        // Itera sobre todos los pares de teclas en el teclado
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                /** Índex 1 és per si fem servir la funció de matriuDistancies. */
                //int indice1 = letraAIndice.get(teclado[i][j]);
                for (int k = 0; k < filas; k++) {
                    for (int l = 0; l < columnas; l++) {
                        // Calcula la distancia Manhattan entre las teclas (i, j) y (k, l)
                        int distancia = Manhattan.calcularDistancia(i, j, k, l);
                        int frecuencia = matrizFrecuencias[letraAIndice.get(teclado[i][j])][letraAIndice.get(teclado[k][l])];
                        puntuacion += distancia * frecuencia;
                        /** Índex 2 i puntuació igual, per si fem servir la funció, ja ho mirarem. */
                        //int indice2 = letraAIndice.get(teclado[k][l]);
                        //puntuacion += matrizDistancias[indice1][indice2] * matrizFrecuencias[indice1][indice2];
                    }
                }
            }
        }
        System.out.println("La puntuación es: " + puntuacion);
        System.out.println();

        return puntuacion;
    }

    public int calculoPuntuacion() {
        int puntuacion = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int indice1 = letraAIndice.get(teclado[i][j]);

                for (int k = 0; k < filas; k++) {
                    for (int l = 0; l < columnas; l++) {
                        int indice2 = letraAIndice.get(teclado[k][l]);
                        int distancia = Manhattan.calcularDistancia(i, j, k, l);
                        int frecuencia = matrizFrecuencias[indice1][indice2];

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

    public void ordenarTeclas(List<Character> teclas) {

    }
}
