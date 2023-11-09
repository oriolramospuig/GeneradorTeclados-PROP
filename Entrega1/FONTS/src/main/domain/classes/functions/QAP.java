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


    public QAP(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        teclado = new char[filas][columnas];
        matrizFrecuencias = new int[filas * columnas][filas * columnas];
        letraAIndice = new HashMap<>();
        this.matrizDistancias = new int[filas * columnas][filas * columnas];
        generarMatrizDistancias();
    }

    // ASSIGNACIÓN ALEATORIA DE M TECLAS A M POSICIONES; DE MOMENTO NECESITAMOS QUE HAYA N*N TELAS (LLENARLO ENTERO)
    public void calcularAsignacionAleatoria(List<Character> teclas) {
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

    public void generarMatrizDeFrecuencias(List<PairFrequency> frecuenciasPares, List<Character> teclas) {
        // Primero, mapear cada letra a su índice en la matriz del teclado
        int index = 0;
        for (Character c : teclas) {
            letraAIndice.put(c, index++);
        }

        // Inicializa la matriz de frecuencias a cero
        for (int i = 0; i < matrizFrecuencias.length; i++) {
            for (int j = 0; j < matrizFrecuencias[i].length; j++) {
                matrizFrecuencias[i][j] = 0;
            }
        }

        // Llena la matriz de frecuencias usando la lista de frecuencias de pares
        for (PairFrequency pf : frecuenciasPares) {
            char letra1 = pf.getPair().charAt(0);
            char letra2 = pf.getPair().charAt(1);
            int frecuencia = pf.getFrequency();

            Integer indice1 = letraAIndice.get(letra1);
            Integer indice2 = letraAIndice.get(letra2);

            if (indice1 != null && indice2 != null) {
                matrizFrecuencias[indice1][indice2] = frecuencia;
                matrizFrecuencias[indice2][indice1] = frecuencia; // Asumiendo que la relación es bidireccional y simétrica
            }
        }
    }

    public void calcularAsignacionGreedy(List<PairFrequency> frecuenciasPares, List<Character> teclas) {
        // Llama a generarMatrizDeFrecuencias antes de generar la solución codiciosa
        generarMatrizDeFrecuencias(frecuenciasPares, teclas);

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
                // Verifica si el índice está dentro de los límites del array
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
                //int indice1 = letraAIndice.get(teclado[i][j]);
                for (int k = 0; k < filas; k++) {
                    for (int l = 0; l < columnas; l++) {
                        // Calcula la distancia Manhattan entre las teclas (i, j) y (k, l)
                        int distancia = Manhattan.calcularDistancia(i, j, k, l);
                        int frecuencia = matrizFrecuencias[letraAIndice.get(teclado[i][j])][letraAIndice.get(teclado[k][l])];
                        puntuacion += distancia * frecuencia;
                        //int indice2 = letraAIndice.get(teclado[k][l]);
                        //puntuacion += matrizDistancias[indice1][indice2] * matrizFrecuencias[indice1][indice2];
                    }
                }
            }
        }

        return puntuacion;
    }

    private void generarMatrizDistancias() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int k = 0; k < filas; k++) {
                    for (int l = 0; l < columnas; l++) {
                        int indice1 = i * columnas + j;
                        int indice2 = k * columnas + l;
                        matrizDistancias[indice1][indice2] = Manhattan.calcularDistancia(i, j, k, l);
                    }
                }
            }
        }
    }


    public void imprimirTeclado() {
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                System.out.print(teclado[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void imprimirMatrizFrecuencias() {
        for (int i = 0; i < matrizFrecuencias.length; i++) {
            for (int j = 0; j < matrizFrecuencias[i].length; j++) {
                System.out.print(matrizFrecuencias[i][j] + " ");
            }
            System.out.println();
        }
    }
}
