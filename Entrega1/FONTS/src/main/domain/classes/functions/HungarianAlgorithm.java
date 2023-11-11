package main.domain.classes.functions;

import java.util.Arrays;


public class HungarianAlgorithm {
    int[][] costMatrix;
    //QAP qapInstance = new QAP();
    //Això ho descomentarem quan tinguem la classe QAP ja feta i la matriu de costos reduits com a parametre de sortida
    //int[][] reducedCostMatrix = qapInstance.getReducedCostMatrix();

    //HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm(reducedCostMatrix);
    int[][] result = HungarianAlgorithm(costMatrix);
    // Imprime la asignación óptima
        /*for(int i = 0; i < result.length; i++) {
            System.out.println("Asignar caracter " + i + " a tecla " + result[i][1]);
        }*/
    public static int[][] HungarianAlgorithm(int[][] costMatrix) {
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
        // Paso 1: Restar el mínimo de cada fila.
        for (int i = 0; i < matrix.length; i++) {
            int minRowValue = Arrays.stream(matrix[i]).min().orElse(0);
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] -= minRowValue;
            }
        }
        // Paso 2: Restar el mínimo de cada columna.
        for (int j = 0; j < matrix[0].length; j++) {
            int minColValue = Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                minColValue = Math.min(minColValue, matrix[i][j]);
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] -= minColValue;
            }
        }
    }


    private static boolean isComplete(int[][] assignment) {
        // Per assegurar-nos que hi ha UN 0 marcat a fila i columna

        // Verifica que cada fila tenga exactamente un cero marcado
        for (int i = 0; i < assignment.length; i++) {
            int count = 0;
            for (int j = 0; j < assignment[i].length; j++) {
                if (assignment[i][j] == 0) {
                    count++;
                }
            }
            if (count != 1) {
                return false;
            }
        }

        // Verifica que cada columna tenga exactamente un cero marcado
        for (int j = 0; j < assignment[0].length; j++) {
            int count = 0;
            for (int i = 0; i < assignment.length; i++) {
                if (assignment[i][j] == 0) {
                    count++;
                }
            }
            if (count != 1) {
                return false;
            }
        }
        // Si todas las filas y columnas tienen exactamente un cero marcado, la asignación es completa
        return true;
    }

    private static void markZeros(int[][] matrix, boolean[][] markedZeros, boolean[] coveredRows, boolean[] coveredCols) {
        // Implementa la selección óptima de ceros (Paso 3) aquí
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0 && !coveredRows[i] && !coveredCols[j]) {
                    markedZeros[i][j] = true;
                    coveredRows[i] = true;
                    coveredCols[j] = true;
                    break;  // Sale del bucle interior después de marcar un cero en esta fila
                }
            }
        }
    }

    private static void adjustValues(int[][] matrix, boolean[][] markedZeros, boolean[] coveredRows, boolean[] coveredCols) {
        // Implementa el ajuste de valores restados (Paso 4) aquí
        int minUncoveredValue = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!coveredRows[i] && !coveredCols[j] && matrix[i][j] < minUncoveredValue) {
                    minUncoveredValue = matrix[i][j];
                }
            }
        }
// Ajusta los valores restados
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (coveredRows[i]) {
                    matrix[i][j] += minUncoveredValue;
                }
                if (!coveredCols[j]) {
                    matrix[i][j] -= minUncoveredValue;
                }
            }
        }
    }
}