package main.domain.classes.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/** Clase que implementa el algoritmo Húngaro, para calcular de manera más exacta la cota de Gilmore-Lawler
 * y tener una asignación óptima. Recibe la matriz de contribución C1+C2
 * @author Oriol i Victor
 */
public class HungarianAlgorithm {
    int[][] costMatrix;
    int max;
    HashMap maxsol;

    /**
     * Implementa el algoritmo de asignación húngaro para encontrar la asignación óptima en un problema de asignación.
     *
     * @param c1c2 La matriz bidimensional de costos.
     * @return El costo total de la asignación óptima.
     */
    public int Hungarian(int[][] c1c2) {
        int[][] copiaC1C2 = copiarMatriz(c1c2); // Crear una copia de la matriz de costos

        reducirFilas(copiaC1C2); // Reducir cada fila sustrayendo el mínimo de la fila
        reducirColumnas(copiaC1C2); // Reducir cada columna sustrayendo el mínimo de la columna

        boolean[] filasCubiertas = new boolean[c1c2.length];
        boolean[] columnasCubiertas = new boolean[c1c2[0].length];

        HashMap filassol = new HashMap<>();
        boolean[] colusadas = new boolean[c1c2[0].length];
        Arrays.fill(colusadas, false);
        maxsol = new HashMap<>();
        max = 0;
        while (!cadaFilaYColumnaTieneCero(copiaC1C2, 0, filassol, colusadas)) {
            System.out.println("HE ENTRADO");
            // Recubrir los ceros con el mínimo número de líneas.
            int nlineas = calcularlineas(copiaC1C2, maxsol, filasCubiertas, columnasCubiertas);
            if (nlineas == copiaC1C2.length) {
                // Tenemos una línea para cada fila y columna, por lo que se ha terminado.
                break;
            }
            // Añadir y sustraer valores según las reglas del algoritmo.
            ajustarMatrizSegunHungaro(copiaC1C2, filasCubiertas, columnasCubiertas);
            filassol = new HashMap<>();
            Arrays.fill(colusadas, false);
            maxsol = new HashMap<>();
        }
        return calcularCostoAsignacion(filassol, c1c2);
    }

    /**
     * Realiza una copia profunda de una matriz bidimensional de enteros.
     *
     * @param original La matriz original que se va a copiar.
     * @return Una nueva matriz que es una copia profunda de la matriz original.
     */
    public static int[][] copiarMatriz(int[][] original) {
        int[][] copia = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copia[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copia;
    }


    /**
     * Realiza la reducción en cada fila de una matriz bidimensional de enteros.
     *
     * @param c1c2 La matriz bidimensional en la cual se realizará la reducción.
     */
    public static void reducirFilas(int[][] c1c2) {
        //int min = Integer.MAX_VALUE;
        for (int i = 0; i < c1c2.length; i++) {
            // min en fila i
            int minFila = Arrays.stream(c1c2[i]).min().getAsInt();
            // Resta min en cada fila
            for (int j = 0; j < c1c2[i].length; j++) {
                c1c2[i][j] -= minFila;
            }
        }
    }

    /**
     * Realiza la reducción en cada columna de una matriz bidimensional de enteros.
     *
     * @param c1c2 La matriz bidimensional en la cual se realizará la reducción.
     */
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

    /**
     * Verifica recursivamente si es posible cubrir todas las filas y columnas de una matriz con ceros.
     *
     * @param matriz      La matriz bidimensional en la cual se realiza la verificación.
     * @param fila        La fila actual en la verificación.
     * @param solfilas    Un HashMap que almacena las asignaciones de filas y columnas.
     * @param colusadas   Un array que indica qué columnas han sido cubiertas.
     * @return true si es posible cubrir todas las filas y columnas, false de lo contrario.
     */
    public boolean cadaFilaYColumnaTieneCero(int[][] matriz, int fila, HashMap solfilas, boolean[] colusadas) {
        if (fila == matriz.length) {
            if (solfilas.size() == matriz.length) {
                maxsol = new HashMap<>(solfilas);
                max = maxsol.size();
                return true;
            }
            if (solfilas.size() > max) {
                System.out.println("hola");
                maxsol = new HashMap<>(solfilas);
                max = maxsol.size();
            }
            return false;
        }
        else if (fila < matriz.length){
            for (int j = 0; j < colusadas.length; ++j) {
                if (matriz[fila][j] == 0 && !colusadas[j]) {
                    colusadas[j] = true;
                    solfilas.put(fila, j);
                    if (cadaFilaYColumnaTieneCero(matriz, fila + 1, solfilas, colusadas)) return true;
                    colusadas[j] = false;
                    solfilas.remove(fila);
                }

            }
            return cadaFilaYColumnaTieneCero(matriz, fila + 1, solfilas, colusadas);
        }
        return false;
    }

    /**
     * Calcula el número de líneas necesarias para cubrir todos los ceros de una matriz,
     * excluyendo las filas y columnas ya cubiertas por una solución dada.
     *
     * @param matriz            La matriz bidimensional en la cual se realiza el cálculo.
     * @param sol               Un HashMap que contiene las asignaciones de filas y columnas.
     * @param filasCubiertas    Un array que indica qué filas están cubiertas por una solución.
     * @param columnasCubiertas Un array que indica qué columnas están cubiertas por una solución.
     * @return El número de líneas necesarias para cubrir todos los ceros excluyendo las filas y columnas ya cubiertas.
     */
    public static int calcularlineas(int[][] matriz, HashMap<Integer, Integer> sol, boolean[] filasCubiertas, boolean[] columnasCubiertas) {
        // Variables para mantener el seguimiento de las filas y columnas cubiertas
        Arrays.fill(filasCubiertas, true);
        //c)
        for (HashMap.Entry<Integer,Integer> entry : sol.entrySet()) {
            int fila = entry.getKey();
            filasCubiertas[fila] = false;
        }

        Arrays.fill(columnasCubiertas, false);
         //d)
        for (int i = 0; i < filasCubiertas.length; ++i) {
            if (filasCubiertas[i]) {
                for (int j = 0; j< columnasCubiertas.length; ++j) {
                    if (matriz[i][j] == 0) {
                       for (Map.Entry<Integer, Integer> entry : sol.entrySet())  {
                           int col = entry.getValue();
                           if (col == j) {
                               columnasCubiertas[j] = true;
                               break;
                           }
                       }
                    }
                }
            }
        }
        //e)
         for (int i = 0; i < columnasCubiertas.length; ++i) {
             if (columnasCubiertas[i]) {
                for (Map.Entry<Integer, Integer> entry : sol.entrySet())  {
                    int col = entry.getValue();
                    if (col == i) {
                        int fila = entry.getKey();
                        filasCubiertas[fila] = true;
                        break;
                    }
                }
             }
         }
         //f)
        // Contar el número de líneas necesarias para cubrir todos los ceros.
        int numLineas = 0;
        for (boolean filaCubierta : filasCubiertas) {
            if (!filaCubierta) numLineas++;
        }
        for (boolean columnaCubierta : columnasCubiertas) {
            if (columnaCubierta) numLineas++;
        }

        return numLineas; // Retorna el número de líneas usadas.
    }

    /**
     * Ajusta la matriz según el algoritmo húngaro para facilitar la identificación de asignaciones óptimas.
     *
     * @param matriz            La matriz bidimensional que se ajustará.
     * @param filasCubiertas    Un array que indica qué filas están cubiertas por una solución.
     * @param columnasCubiertas Un array que indica qué columnas están cubiertas por una solución.
     */
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
                if (filasCubiertas[i]) matriz[i][j] += minValorNoCubierto;
                if (columnasCubiertas[j]) matriz[i][j] += minValorNoCubierto;
                matriz[i][j] -= minValorNoCubierto;
                // Si el elemento está cubierto solo por una línea, no se cambia.
            }
        }
    }

    /**
     * Calcula el costo total de una asignación dada en una matriz de costos originales.
     *
     * @param asignacion      Un HashMap que contiene las asignaciones de filas y columnas.
     * @param costesOriginales La matriz bidimensional de costos originales.
     * @return El costo total de la asignación.
     */
    public static int calcularCostoAsignacion(HashMap<Integer,Integer> asignacion, int[][] costesOriginales) {
        int costoTotal = 0;
        for (Map.Entry<Integer, Integer> entry : asignacion.entrySet())  {
            int fila = entry.getKey();
            int col = entry.getValue();
            costoTotal += costesOriginales[fila][col];
        }
        return costoTotal;
    }
}