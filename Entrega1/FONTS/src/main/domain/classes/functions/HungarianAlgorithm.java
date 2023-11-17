package main.domain.classes.functions;

import java.util.Arrays;


/** Clase que implementa el algoritmo Húngaro, para calcular de manera más exacta la cota de Gilmore-Lawler
 * y tener una asignación óptima. Recibe la matriz de contribución C1+C2
 * @author X (X@estudiantat.upc.edu)
 */
public class HungarianAlgorithm {
    int[][] costMatrix;

    public static int Hungarian(int[][] c1c2) {
        int[][] copiaC1C2 = copiarMatriz(c1c2); // Crear una copia de la matriz de costos
        /*System.out.println("C1C2");
        for (int i = 0; i < c1c2.length; ++i) {
            for (int j = 0; j < c1c2.length; ++j) {
                System.out.println(c1c2[i][j]);
            }
            System.out.println();
        }
        System.out.println("Copia C1C2");
        for (int i = 0; i < copiaC1C2.length; ++i) {
            for (int j = 0; j < copiaC1C2.length; ++j) {
                System.out.println(c1c2[i][j]);
            }
            System.out.println();
        }
         */
        reducirFilas(copiaC1C2); // Reducir cada fila sustrayendo el mínimo de la fila
        reducirColumnas(copiaC1C2); // Reducir cada columna sustrayendo el mínimo de la columna

        boolean[] filasCubiertas = new boolean[c1c2.length];
        boolean[] columnasCubiertas = new boolean[c1c2[0].length];

        while (!cadaFilaYColumnaTieneCero(copiaC1C2)) {
            // Recubrir los ceros con el mínimo número de líneas.
            int nlineas = recubrirCeros(copiaC1C2);
            if (nlineas == copiaC1C2.length) {
                // Tenemos una línea para cada fila y columna, por lo que se ha terminado.
                break;
            }
            // Añadir y sustraer valores según las reglas del algoritmo.
            ajustarMatrizSegunHungaro(copiaC1C2, filasCubiertas, columnasCubiertas);

            Arrays.fill(filasCubiertas, false);
            Arrays.fill(columnasCubiertas, false);
        }
        return calcularCostoAsignacion(copiaC1C2, c1c2);
    }

    public static int[][] copiarMatriz(int[][] original) {
        int[][] copia = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copia[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copia;
    }


    public static void reducirFilas(int[][] c1c2) {
        for (int i = 0; i < c1c2.length; i++) {
            // min en fila i
            int minFila = Arrays.stream(c1c2[i]).min().getAsInt();
            // Resta min en cada fila
            for (int j = 0; j < c1c2[i].length; j++) {
                c1c2[i][j] -= minFila;
            }
        }
    }

    public static void reducirColumnas(int[][] c1c2) {
        for (int j = 0; j < c1c2[0].length; j++) {
            int minColumna = Integer.MAX_VALUE;
            for (int[] ints : c1c2) {
                if (ints[j] < minColumna) {
                    minColumna = ints[j];
                }
            }
            for (int[] ints : c1c2) {
                ints[j] -= minColumna;
            }
        }
    }

    public static boolean cadaFilaYColumnaTieneCero(int[][] matriz) {
        boolean[] filaTieneCero = new boolean[matriz.length];
        boolean[] columnaTieneCero = new boolean[matriz[0].length];

        // busca ceros en las filas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    filaTieneCero[i] = true;
                    break;
                }
            }
        }

        // Buscar ceros en las columnas
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[i][j] == 0) {
                    columnaTieneCero[j] = true;
                    break; // Un cero por columna es suficiente, no es necesario buscar más.
                }
            }
        }

        // Verificar que todas las filas y columnas tienen al menos un cero
        for (boolean tieneCero : filaTieneCero) {
            if (!tieneCero) {
                return false; // Si alguna fila no tiene un cero, devuelve falso
            }
        }
        for (boolean tieneCero : columnaTieneCero) {
            if (!tieneCero) {
                return false; // Si alguna columna no tiene un cero, devuelve falso
            }
        }

        return true; // Si todas las filas y columnas tienen al menos un cero, devuelve verdadero
    }

    public static int recubrirCeros(int[][] matriz) {
        // Variables para mantener el seguimiento de las filas y columnas cubiertas
        boolean[] filasCubiertas = new boolean[matriz.length];
        boolean[] columnasCubiertas = new boolean[matriz[0].length];

        // Inicializar las asignaciones para filas y columnas.
        int[] asignacionFilas = new int[matriz.length];
        int[] asignacionColumnas = new int[matriz[0].length];
        Arrays.fill(asignacionFilas, -1);
        Arrays.fill(asignacionColumnas, -1);

        // Paso 1: Asignación inicial basada en ceros.
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[0].length; columna++) {
                if (matriz[fila][columna] == 0 && asignacionFilas[fila] == -1 && asignacionColumnas[columna] == -1) {
                    asignacionFilas[fila] = columna; // Asigna esta columna a esta fila.
                    asignacionColumnas[columna] = fila; // Asigna esta fila a esta columna.
                    break;
                }
            }
        }

        // Marcar filas que no tienen asignaciones
        for (int fila = 0; fila < asignacionFilas.length; fila++) {
            if (asignacionFilas[fila] == -1) {
                filasCubiertas[fila] = true;
            }
        }

        boolean cambios;
        do {
            cambios = false;
            // Marcar columnas que tienen ceros en filas marcadas
            for (int fila = 0; fila < matriz.length; fila++) {
                if (filasCubiertas[fila]) {
                    for (int columna = 0; columna < matriz[0].length; columna++) {
                        if (matriz[fila][columna] == 0 && !columnasCubiertas[columna]) {
                            columnasCubiertas[columna] = true;
                            cambios = true;
                        }
                    }
                }
            }

            // Marcar filas que tienen asignaciones en columnas marcadas
            for (int columna = 0; columna < matriz[0].length; columna++) {
                if (columnasCubiertas[columna] && asignacionColumnas[columna] != -1) {
                    int filaAsignada = asignacionColumnas[columna];
                    if (!filasCubiertas[filaAsignada]) {
                        filasCubiertas[filaAsignada] = true;
                        cambios = true;
                    }
                }
            }
        } while (cambios); // Repetir hasta que no haya más cambios.

        // Contar el número de líneas necesarias para cubrir todos los ceros.
        int numLineas = 0;
        for (boolean filaCubierta : filasCubiertas) {
            if (filaCubierta) numLineas++;
        }
        for (boolean columnaCubierta : columnasCubiertas) {
            if (columnaCubierta) numLineas++;
        }

        return numLineas; // Retorna el número de líneas usadas.
    }


    public static void ajustarMatrizSegunHungaro(int[][] matriz, boolean[] filasCubiertas, boolean[] columnasCubiertas) {
        // Encuentra el valor mínimo no cubierto por ninguna línea.
        int minValorNoCubierto = Integer.MAX_VALUE;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (!filasCubiertas[i] && !columnasCubiertas[j] && matriz[i][j] < minValorNoCubierto) {
                    minValorNoCubierto = matriz[i][j];
                }
            }
        }

        // Añade el valor mínimo a cada elemento cubierto por dos líneas y resta de los no cubiertos.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (filasCubiertas[i] && columnasCubiertas[j]) {
                    // El elemento está cubierto por dos líneas.
                    matriz[i][j] += minValorNoCubierto;
                } else if (!filasCubiertas[i] && !columnasCubiertas[j]) {
                    // El elemento no está cubierto por ninguna línea.
                    matriz[i][j] -= minValorNoCubierto;
                }
                // Si el elemento está cubierto solo por una línea, no se cambia.
            }
        }
    }

    public static int calcularCostoAsignacion(int[][] asignacion, int[][] costesOriginales) {
        int costoTotal = 0;
        boolean[] asignacionRealizada = new boolean[asignacion.length]; // Rastrea si la asignación ya se ha realizado para una fila.

        for (int i = 0; i < asignacion.length; i++) {
            for (int j = 0; j < asignacion[0].length; j++) {
                // Encuentra un cero en la matriz reducida y ajustada para el cual no se ha hecho una asignación.
                if (asignacion[i][j] == 0 && !asignacionRealizada[j]) {
                    costoTotal += costesOriginales[i][j]; // Suma el costo original correspondiente a este cero.
                    asignacionRealizada[j] = true;
                    break;
                }
            }
        }

        return costoTotal;
    }




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