package main.domain.classes.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/** Clase que implementa el algoritmo Húngaro, para calcular de manera más exacta la cota de Gilmore-Lawler
 * y tener una asignación óptima. Recibe la matriz de contribución C1+C2
 * @author X (X@estudiantat.upc.edu)
 */
public class HungarianAlgorithm {
    int[][] costMatrix;
    int max;
    HashMap maxsol;

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

    public static int[][] copiarMatriz(int[][] original) {
        int[][] copia = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copia[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copia;
    }


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