package main.domain.classes.functions;

import main.domain.classes.types.PairFrequency;

import java.util.*;

/** Clase que a partir de las matrices de frecuencias y de distancias calcula una solución inicial y
 * llama al algoritmo de gilmore-lawler con una cota inicial
 * @author Oriol i Victor
 */
public class QAP {
    private int[][] teclado; // La matriz del teclado
    private int filas;
    private int columnas;
    private int n;
    private int[][] matrizFrecuencias;
    private int[][] matrizDistancias;
    private List<Integer> sol;
    private int [][] tec;
    private int glBound;


    /*Creadora nova, la que volem fer servir*/
    public QAP(int nf, int nc, int[][] matrizFrecuencias, int [][] matrizDistancias, List<Integer> sol, int [][] tec) {
        this.filas = nf;
        this.columnas = nc;
        this.n = nf*nc;

        this.matrizFrecuencias = matrizFrecuencias;
        this.matrizDistancias = matrizDistancias;

        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < nf*nc; ++i) {
            ind.add(i);
        }

        int [][] indices = calcularMejorAsignacionAleatoria(ind, 100);
        this.teclado = indices;
        this.sol = sol;
        this.tec = new int [filas][columnas];
        this.glBound = calculoPuntuacion(indices);
        imprimirTeclado();
        System.out.println("Puntuacion inicial = " + glBound);

        calculo();
    }
    /*getter que potser no calen pero abans els feia servir*/
    public int getFilas() {
        return this.filas;
    }
    public int getColumnas() {
        return this.columnas;
    }

    public int getN() {
        return this.n;
    }
    public int getGlBound() {
        return this.glBound;
    }
    public int[][] getMatrizFrecuencias() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.matrizFrecuencias)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }
    public int[][] getMatrizDistancias() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.matrizDistancias)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    public int[][] getTec() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.tec)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    private int[][] calcularMejorAsignacionAleatoria(List<Integer> teclas, int N) {
        System.out.println("La mejor de N asignaciones de las teclas aleatorias: ");
        System.out.println();
        if (teclas.size() != filas * columnas) {
            throw new IllegalArgumentException("El número de teclas debe coincidir con el número de posiciones en el teclado.");
        }

        int[][] mejorTeclado = new int[filas][columnas];
        int mejorPuntuacion = Integer.MAX_VALUE;

        for (int n = 0; n < N; n++) {
            Collections.shuffle(teclas);
            int[][] tecladoTemporal = new int[filas][columnas];
            int index = 0;
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    tecladoTemporal[i][j] = teclas.get(index++);
                }
            }

            int puntuacionActual = calculoPuntuacion(tecladoTemporal);
            if (puntuacionActual < mejorPuntuacion) {
                mejorPuntuacion = puntuacionActual;
                mejorTeclado = tecladoTemporal; // Aquí se guarda la mejor asignación
            }
        }

        // Al final del bucle, mejorTeclado contiene la asignación con la mejor puntuación
        teclado = mejorTeclado; // Asignar la mejor asignación al teclado principal
        tec = mejorTeclado;
        return mejorTeclado;
    }

    private int calculoPuntuacion(int[][] teclado) {
        int puntuacion = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int indice1 = teclado[i][j];
                int i1 = i*columnas+j;

                for (int k = i; k < filas; k++) {
                    for (int l = (k == i) ? j + 1 : 0; l < columnas; l++) {
                        int indice2 = teclado[k][l];
                        int i2 = k*columnas+l;

                        //int distancia = Manhattan.calcularDistancia(i, j, k, l);
                        int distancia = matrizDistancias[i1][i2];

                        int frecuencia = matrizFrecuencias[indice1][indice2];

                        puntuacion += distancia * frecuencia;
                    }
                }
            }
        }
        return puntuacion;
    }

    private void imprimirTeclado() {
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                System.out.print(teclado[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void imprimirTeclado(int[][] tecladoIndices) {
        for (int i = 0; i < tecladoIndices.length; i++) {
            for (int j = 0; j < tecladoIndices[i].length; j++) {
                System.out.print(tecladoIndices[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void imprimirMatrices() {
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

    private void calculo() {
        //imprimirMatrices();

        GilmoreLawler gilmoreLawler = new GilmoreLawler(filas, columnas, glBound, matrizFrecuencias, matrizDistancias);
        gilmoreLawler.gilmore_lawler();
        sol = gilmoreLawler.getMejorSolucionParcial();

        if (!sol.isEmpty()) {
            // Recorrer la lista de soluciones parciales y asignar cada valor a su posición en el arreglo
            for (int i = 0; i < sol.size(); i++) {
                int fila = i / columnas;
                int columna = i % columnas;

                tec[fila][columna] = sol.get(i);
            }
        }

    }
}
