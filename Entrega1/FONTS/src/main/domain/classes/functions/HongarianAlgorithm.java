package main.domain.classes.functions;

import java.util.*;
import java.util.Arrays;

/*
public class HungarianAlgorithm {

    public static void main(String[] args) {
        //esborrany de com seria l'entrada
        int[][] costMatrix = {
                {5, 9, 1},
                {10, 3, 2},
                {8, 7, 4}
        };

        int[][] result = hungarianAlgorithm(costMatrix);

        // Imprime la asignación óptima
        for (int i = 0; i < result.length; i++) {
            System.out.println("Asignar caracter " + i + " a tecla " + result[i][1]);
        }
    }

    public static int[][] hungarianAlgorithm(int[][] costMatrix) {
        // Implementa el algoritmo húngaro aquí

        // Paso 1: Restar el mínimo de cada fila.
        for (int i = 0; i < costMatrix.length; i++) {
            int minRowValue = Arrays.stream(costMatrix[i]).min().getAsInt();
            for (int j = 0; j < costMatrix[i].length; j++) {
                costMatrix[i][j] -= minRowValue;
            }
        }

        // Paso 2: Restar el mínimo de cada columna.
        for (int j = 0; j < costMatrix[0].length; j++) {
            int minColValue = Integer.MAX_VALUE;
            for (int i = 0; i < costMatrix.length; i++) {
                minColValue = Math.min(minColValue, costMatrix[i][j]);
            }
            for (int i = 0; i < costMatrix.length; i++) {
                costMatrix[i][j] -= minColValue;
            }
        }
        // Resto de la implementación del algoritmo húngaro...
        public static int[][] hungarianAlgorithm(int[][] costMatrix) {
            // Paso 1 y 2: Restar el mínimo de cada fila y columna.
            reduceMatrix(costMatrix);

            // Paso 3 y 4: Implementación de selección óptima de ceros y ajuste de valores restados.
            int[][] assignment = new int[costMatrix.length][2];
            while (!isComplete(assignment)) {
                boolean[][] markedZeros = new boolean[costMatrix.length][costMatrix[0].length];
                boolean[] coveredRows = new boolean[costMatrix.length];
                boolean[] coveredCols = new boolean[costMatrix[0].length];

                // Implementa la selección óptima de ceros.
                markZeros(costMatrix, markedZeros, coveredRows, coveredCols);

                // Ajusta los valores restados.
                adjustValues(costMatrix, markedZeros, coveredRows, coveredCols);
            }

            // Paso 5: Asignación óptima obtenida.

            // Devuelve la asignación óptima
            return assignment;
        }

        private static void reduceMatrix(int[][] matrix) {
            // Implementa la reducción de la matriz (Paso 1 y 2) aquí
        }

        private static boolean isComplete(int[][] assignment) {
            // Implementa la verificación de la completitud de la asignación (Paso 5) aquí
            return false;
        }

        private static void markZeros(int[][] matrix, boolean[][] markedZeros, boolean[] coveredRows, boolean[] coveredCols) {
            // Implementa la selección óptima de ceros (Paso 3) aquí
        }

        private static void adjustValues(int[][] matrix, boolean[][] markedZeros, boolean[] coveredRows, boolean[] coveredCols) {
            // Implementa el ajuste de valores restados (Paso 4) aquí
        }
    }

        // Devuelve la asignación óptima (por ahora, solo devuelve la matriz original)
        return costMatrix;
    }
}

 */


