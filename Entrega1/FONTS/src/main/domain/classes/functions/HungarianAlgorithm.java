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
        //return costMatrix;