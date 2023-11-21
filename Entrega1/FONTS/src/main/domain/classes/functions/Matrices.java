package main.domain.classes.functions;

import main.domain.classes.types.PairFrequency;

import java.util.HashMap;
import java.util.List;

/**
 * Clase que calcula las diferentes matrices y operaciones (suma) necesarias para el algoritmo
 */
public class Matrices {
    /**Genera la matriz de distancias de Manhattan*/
    public static void generarMatrizDistancias(int filas, int columnas, int[][] matrizDistancias) {
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

    /**
     * Genera matriz de frecuencias, le pasamos la lista de pares de letras con las frecuencias ordenadas
     * y la lista de teclas.
     */
    public static void generarMatrizDeFrecuencias(List<PairFrequency> frecuenciasPares, List<Character> teclas, HashMap<Character, Integer> letraAIndice, int[][] matrizFrecuencias) {
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
                matrizFrecuencias[indice2][indice1] = frecuencia;
            }
        }
    }

    /**
     * Función que suma el contenido de dos matrices
     */
    public static int [][] sumaMatrices(int [][] m1, int [][] m2) {
        int [][] m3 = new int[m1.length][m1.length];
        for (int i = 0; i < m1.length; ++i) {
            for (int j = 0; j < m1.length; ++j) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m3;
    }

}
