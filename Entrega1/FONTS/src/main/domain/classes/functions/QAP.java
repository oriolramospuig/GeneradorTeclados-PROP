package main.domain.classes.functions;

import main.domain.classes.types.PairFrequency;

import java.util.*;

/**
 * Clase que a partir de las matrices de frecuencias y de distancias calcula una solución inicial y
 * llama al algoritmo de gilmore-lawler con una cota inicial
<<<<<<< Entrega1/FONTS/src/main/domain/classes/functions/QAP.java
 * @author Oriol i Victor
=======
>>>>>>> Entrega1/FONTS/src/main/domain/classes/functions/QAP.java
 */
public class QAP {
    private int[][] teclado; // La matriz del teclado
    private int filas;
    private int columnas;
    private int n;
    private int[][] matrizFrecuencias;
    private int[][] matrizDistancias;
    private List<Integer> sol;
    private int[][] tec;
    private int glBound;


    /**
     * Constructor de la clase QAP (Quadratic Assignment Problem).
     *
     * @param nf                Número de filas.
     * @param nc                Número de columnas.
     * @param matrizFrecuencias Matriz de frecuencias.
     * @param matrizDistancias  Matriz de distancias.
     */
    public QAP(int nf, int nc, int[][] matrizFrecuencias, int [][] matrizDistancias) {
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
        this.sol = new ArrayList<>();
        this.tec = indices;
        this.glBound = calculoPuntuacion(indices);
        imprimirTeclado();
        System.out.println("Puntuacion inicial = " + glBound);

        calculo();
    }

    /**
     * Obtiene el número de filas de la instancia actual.
     *
     * @return El número de filas.
     */
    public int getFilas() {
        return this.filas;
    }

    /**
     * Obtiene el número de columna de la instancia actual.
     *
     * @return El número de columnas.
     */
    public int getColumnas() {
        return this.columnas;
    }

    /**
     * Obtiene el número de filas*columnas de la instancia actual.
     *
     * @return El número de filas*columnas.
     */
    public int getN() {
        return this.n;
    }

    /**
     * Obtiene la cota mínima de la instancia actual.
     *
     * @return La cota mínima.
     */
    public int getGlBound() {
        return this.glBound;
    }

    /**
     * Obtiene una copia de la matriz de frecuencias de la instancia actual.
     *
     * @return Una copia de la matriz de frecuencias.
     */
    public int[][] getMatrizFrecuencias() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.matrizFrecuencias)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    /**
     * Obtiene una copia de la matriz de distancias de la instancia actual.
     *
     * @return Una copia de la matriz de distancias.
     */
    public int[][] getMatrizDistancias() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.matrizDistancias)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    /**
     * Obtiene una copia de tec de la instancia actual.
     *
     * @return Una copia de tec.
     */
    public int[][] getTec() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.tec)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    /**
     * Calcula la mejor asignación aleatoria de teclas entre las N generadas.
     *
     * @param teclas Lista de teclas a asignar aleatoriamente.
     * @param N Número de asignaciones aleatorias a generar y evaluar.
     * @return La mejor asignación aleatoria de teclas.
     * @throws IllegalArgumentException Si el número de teclas no coincide con el tamaño del teclado.
     */
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

    /**
     * Calcula la puntuación de un teclado según distancias y frecuencias.
     *
     * @param teclado Matriz que representa el teclado con asignaciones de teclas.
     * @return Puntuación del teclado.
     */
    private int calculoPuntuacion(int[][] teclado) {
        int puntuacion = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int indice1 = teclado[i][j];
                int i1 = i*columnas+j;

                for (int k = 0; k < filas; k++) {
                    for (int l = 0; l < columnas; l++) {
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

    /**
     * Imprime en la consola la disposición actual de las teclas en el teclado.
     */
    private void imprimirTeclado() {
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                System.out.print(teclado[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Imprime en la consola la disposición de índices de teclas proporcionada.
     *
     * @param tecladoIndices Matriz de índices de teclas a imprimir.
     */
    private void imprimirTeclado(int[][] tecladoIndices) {
        for (int i = 0; i < tecladoIndices.length; i++) {
            for (int j = 0; j < tecladoIndices[i].length; j++) {
                System.out.print(tecladoIndices[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Imprime en la consola las matrices de frecuencias y distancias.
     */
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

    /**
     * Realiza el cálculo utilizando el algoritmo de Gilmore-Lawler.
     * Imprime las matrices de frecuencias y distancias, y luego utiliza el algoritmo
     * para encontrar la mejor asignación de teclas en el teclado.
     */
    private void calculo() {
        // imprimirMatrices();

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
