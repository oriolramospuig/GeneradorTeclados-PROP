package main.domain.classes.functions;

import main.domain.classes.types.PairFrequency;

import java.util.HashMap;
import java.util.List;

/** Clase que calcula las diferentes matrices y operaciones (suma) necesarias para el algoritmo
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class Matrices {
    /**
     * Genera una matriz de distancias Manhattan para un conjunto de posiciones.
     *
     * @param filas Número de filas de la cuadrícula.
     * @param columnas Número de columnas de la cuadrícula.
     * @return Matriz de distancias Manhattan para todas las combinaciones de posiciones en la matriz.
     */
    public static int[][] generarMatrizDistancias(int filas, int columnas) {
        int[][] md = new int[filas*columnas][filas*columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int k = 0; k < filas; k++) {
                    for (int l = 0; l < columnas; l++) {
                        int indice1 = i * columnas + j;
                        int indice2 = k * columnas + l;
                        md[indice1][indice2] = Manhattan.calcularDistancia(i, j, k, l);
                    }
                }
            }
        }
        return md;
    }

    /**
     * Genera una matriz de frecuencias a partir de una lista de frecuencias de pares y un mapeo de teclas a índices.
     *
     * @param n Número de teclas.
     * @param frecuenciasPares Lista de pares de letras con sus frecuencias.
     * @param teclas Lista de teclas.
     * @param letraAIndice Mapeo de cada letra a su índice correspondiente en la matriz.
     * @return Matriz de frecuencias basada en las frecuencias de los pares de letras y la disposición de las teclas.
     */
    public static int[][] generarMatrizDeFrecuencias(int n, List<PairFrequency> frecuenciasPares, List<Character> teclas, HashMap<Character, Integer> letraAIndice) {
        // Primero, mapear cada letra a su índice en la matriz del teclado
        int index = 0;
        int[][] mf = new int[n][n];
        for (Character c : teclas) {
            letraAIndice.put(c, index++);
        }

        // Inicializa la matriz de frecuencias a cero
        for (int i = 0; i < mf.length; i++) {
            for (int j = 0; j < mf[i].length; j++) {
                mf[i][j] = 0;
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
                mf[indice1][indice2] = frecuencia;
                mf[indice2][indice1] = frecuencia;
            }
        }
        return mf;
    }

    /**
     * Suma dos matrices y devuelve el resultado.
     *
     * @param m1 La primera matriz a sumar.
     * @param m2 La segunda matriz a sumar.
     * @return Una nueva matriz que es la suma de m1 y m2.
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
