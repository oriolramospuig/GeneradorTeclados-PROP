package main.domain.classes.functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimulatedAnnealing {
    private static final double TEMPERATURA_INICIAL = 1000;
    private static final double FACTOR_ENFRIAMIENTO = 0.95;
    private static final int MAX_ITERACIONES = 1000;
    private static int[][] matrizFrecuencias;
    private static int[][] matrizDistancias;
    private static int filas;
    private static int columnas;

    public SimulatedAnnealing(int filas, int columnas, int[][] mf, int[][] md) {
        SimulatedAnnealing.filas = filas;
        SimulatedAnnealing.columnas = columnas;
        SimulatedAnnealing.matrizFrecuencias = mf;
        SimulatedAnnealing.matrizDistancias = md;

        calculo();
    }

    public static int[][] simulatedAnnealing(int[][] tecladoInicial) {
        Random random = new Random();
        int[][] tecladoActual = copiarMatriz(tecladoInicial);
        int costoActual = calculoPuntuacion(tecladoActual);

        double temperatura = TEMPERATURA_INICIAL;

        for (int i = 0; i < MAX_ITERACIONES; i++) {
            if (temperatura < 1) {
                break;
            }

            int[][] tecladoVecino = generarTecladoVecino(copiarMatriz(tecladoActual), random);
            int costoVecino = calculoPuntuacion(tecladoVecino);

            if (aceptarMovimiento(costoActual, costoVecino, temperatura, random)) {
                tecladoActual = tecladoVecino;
                costoActual = costoVecino;
            }

            temperatura *= FACTOR_ENFRIAMIENTO;
        }

        return tecladoActual;
    }

    private static boolean aceptarMovimiento(int costoActual, int costoVecino, double temperatura, Random random) {
        if (costoVecino < costoActual) {
            return true;
        }
        double probabilidad = Math.exp((costoActual - costoVecino) / temperatura);
        return probabilidad > random.nextDouble();
    }

    private static int[][] copiarMatriz(int[][] original) {
        int[][] copia = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i].clone();
        }
        return copia;
    }

    private static int[][] generarTecladoVecino(int[][] teclado, Random random) {
        int fila1 = random.nextInt(teclado.length);
        int columna1 = random.nextInt(teclado[0].length);

        int fila2 = random.nextInt(teclado.length);
        int columna2 = random.nextInt(teclado[0].length);

        // Intercambiar teclas
        int temp = teclado[fila1][columna1];
        teclado[fila1][columna1] = teclado[fila2][columna2];
        teclado[fila2][columna2] = temp;

        return teclado;
    }

    private static int calculoPuntuacion(int[][] teclado) {
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

    private static int[][] calcularMejorAsignacionAleatoria(List<Integer> teclas, int N) {
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
        // teclado = mejorTeclado; // Asignar la mejor asignación al teclado principal
        return mejorTeclado;
    }

    private static void calculo() {
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < filas*columnas; ++i) {
            ind.add(i);
        }

        int[][] tecIni = calcularMejorAsignacionAleatoria(ind, 100);
        int punt = calculoPuntuacion(tecIni);
        int[][] tecFinal = simulatedAnnealing(tecIni);
        int puntFinal = calculoPuntuacion(tecFinal);
        System.out.println("Puntuacion final = " + puntFinal);
    }
    // falta puntuacion y sol ini, generadas en QAP
}

