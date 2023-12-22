package main.domain.classes.functions;

import main.domain.classes.Alfabeto;
import main.domain.classes.AsociacionTextos;
import main.domain.classes.Teclado;
import main.domain.classes.types.PairInt;

import java.util.*;

/**
 * Implementa el algoritmo de recocido simulado (Simulated Annealing) para encontrar una solución aproximada
 * al problema de asignación de teclas en un teclado.
 * Este algoritmo utiliza una combinación de búsqueda aleatoria y una heurística de enfriamiento
 * para explorar el espacio de soluciones y encontrar una configuración óptima de teclas.
 */
public class SimulatedAnnealing implements IAlgoritmo {
    private static final double TEMPERATURA_INICIAL = 100000;
    private static final double FACTOR_ENFRIAMIENTO = 0.999;
    private static final int MAX_ITERACIONES = 100000;
    private static int[][] matrizFrecuencias;
    private static int[][] matrizDistancias;
    private static int filas;
    private static int columnas;
    private static int puntuacionFinal;
    private static int[][] tecFinal;

    /**
     * Obtiene la puntuación final del teclado calculada por el algoritmo.
     *
     * @return La puntuación final.
     */
    public int getPuntuacionFinal() {return puntuacionFinal;}

    /**
     * Obtiene la configuración final del teclado encontrada por el algoritmo.
     *
     * @return Matriz que representa la configuración final del teclado.
     */
    public int[][] getTecFinal() {return tecFinal;}

    /**
     * Constructor de la clase SimulatedAnnealing.
     *
     * @param filas Número de filas del teclado.
     * @param columnas Número de columnas del teclado.
     * @param mf Matriz de frecuencias.
     * @param md Matriz de distancias.
     */
    public SimulatedAnnealing(int filas, int columnas, int[][] mf, int[][] md) {
        SimulatedAnnealing.filas = filas;
        SimulatedAnnealing.columnas = columnas;
        SimulatedAnnealing.matrizFrecuencias = mf;
        SimulatedAnnealing.matrizDistancias = md;
    }

    /**
     * Constructor de la clase SimulatedAnnealing(para el driver interactivo).
     *
     * @param n filas*columnas.
     * @param filas Número de filas del teclado.
     * @param columnas Número de columnas del teclado.
     * @param mf Matriz de frecuencias.
     * @param md Matriz de distancias.
     */
    public SimulatedAnnealing(int n, int filas, int columnas, int[][] mf, int[][] md) {
        SimulatedAnnealing.filas = filas;
        SimulatedAnnealing.columnas = columnas;
        SimulatedAnnealing.matrizFrecuencias = mf;
        SimulatedAnnealing.matrizDistancias = md;

        calculo();
    }

    /**
     * Ejecuta el algoritmo de recocido simulado para encontrar una configuración de teclado.
     *
     * @param tecladoInicial Configuración inicial del teclado.
     * @return Configuración óptima del teclado encontrada por el algoritmo.
     */
    public static int[][] simulatedAnnealing(int[][] tecladoInicial) {
        Random random = new Random();
        int[][] tecladoActual = copiarMatriz(tecladoInicial);
        int costeActual = calculoPuntuacion(tecladoActual);

        double temperatura = TEMPERATURA_INICIAL;

        for (int i = 0; i < MAX_ITERACIONES; i++) {
            if (temperatura < 1) {
                break;
            }

            int[][] sucesor = generarTecladoVecino(copiarMatriz(tecladoActual), random);
            int costeSucesor = calculoPuntuacion(sucesor);

            if (aceptarMovimiento(costeActual, costeSucesor, temperatura, random)) {
                tecladoActual = sucesor;
                costeActual = costeSucesor;
            }

            temperatura *= FACTOR_ENFRIAMIENTO;
        }

        return tecladoActual;
    }

    /**
     * Determina si un movimiento en el espacio de soluciones debe ser aceptado basado en la temperatura actual
     * y la diferencia de costos entre la solución actual y la vecina.
     *
     * @param costeActual Coste de la solución actual.
     * @param costeVecino Coste de la solución vecina.
     * @param temperatura Temperatura actual del sistema.
     * @param random Objeto Random para generar valores aleatorios.
     * @return Verdadero si el movimiento debe ser aceptado; falso en caso contrario.
     */
    private static boolean aceptarMovimiento(int costeActual, int costeVecino, double temperatura, Random random) {
        if (costeVecino < costeActual) {
            return true;
        }
        double probabilidad = Math.exp((costeActual - costeVecino) / temperatura);
        return probabilidad > random.nextDouble();
    }

    /**
     * Crea una copia de una matriz.
     *
     * @param original Matriz original a copiar.
     * @return Una copia de la matriz original.
     */
    private static int[][] copiarMatriz(int[][] original) {
        int[][] copia = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i].clone();
        }
        return copia;
    }

    /**
     * Genera una configuración de teclado vecina mediante el intercambio aleatorio de dos teclas.
     *
     * @param teclado Configuración actual del teclado.
     * @param random Objeto Random para generar índices aleatorios.
     * @return Nueva configuración de teclado vecina.
     */
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

    /**
     * Calcula la puntuación de un teclado según las matrices de distancias y frecuencias.
     *
     * @param teclado Matriz que representa el teclado.
     * @return Puntuación del teclado.
     */
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

    /**
     * Genera una solución inicial aleatoria para el algoritmo.
     *
     * @param matrizFrecuencias Matriz de frecuencias de teclas.
     * @return Una solución inicial para el algoritmo de recocido simulado.
     */
    public static int[][] generarSolucionInicial(int[][] matrizFrecuencias) {
        int n = filas * columnas;
        int[][] solucion = new int[filas][columnas];
        boolean[] letrasAsignadas = new boolean[n];

        int actual = 0;
        int filaActual = 0;
        int columnaActual = 0;

        solucion[filaActual][columnaActual] = actual;
        letrasAsignadas[actual] = true;

        for (int i = 1; i < n; i++) {
            int siguienteLetra = -1;
            int maxFrecuencia = -1;

            for (int j = 0; j < n; j++) {
                if (!letrasAsignadas[j] && matrizFrecuencias[actual][j] > maxFrecuencia) {
                    siguienteLetra = j;
                    maxFrecuencia = matrizFrecuencias[actual][j];
                }
            }

            actual = siguienteLetra;
            letrasAsignadas[actual] = true;

            columnaActual++;
            if (columnaActual == columnas) {
                columnaActual = 0;
                filaActual++;
            }

            solucion[filaActual][columnaActual] = actual;
        }

        return solucion;
    }

    /**
     * Calcula la mejor asignación aleatoria de teclas entre N generadas.
     * Este método explora N configuraciones aleatorias del teclado y selecciona la que tiene la menor puntuación,
     * la cual se calcula basándose en las matrices de frecuencias y distancias.
     *
     * @param teclas Lista de teclas a asignar aleatoriamente. Debe tener un tamaño igual al número de posiciones en el teclado.
     * @param N Número de asignaciones aleatorias a generar y evaluar.
     * @return La mejor asignación aleatoria de teclas encontrada en términos de puntuación.
     * @throws IllegalArgumentException Si el número de teclas no coincide con el número de posiciones en el teclado.
     */
    private static int[][] calcularMejorAsignacionAleatoria(List<Integer> teclas, int N) {
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

        return mejorTeclado;
    }

    /**
     * Realiza el cálculo y la lógica del algoritmo de recocido simulado.
     */
    private static void calculo() {
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < filas*columnas; ++i) {
            ind.add(i);
        }

        int[][] tecIni = calcularMejorAsignacionAleatoria(ind, 1000);
        int[][] tecAux = generarSolucionInicial(matrizFrecuencias); // greedy
        tecFinal = simulatedAnnealing(tecIni);
        int[][] tecFinalAux = simulatedAnnealing(tecAux);
        int puntFinal = calculoPuntuacion(tecFinal);
        int puntAux = calculoPuntuacion(tecFinalAux); // greedy
        puntuacionFinal = puntFinal;
    }

    /**
     * Crea un objeto Teclado mediante Simulated Annealing y actualiza la puntuación final y contenido del Teclado.
     * @param nomT nombre del Teclado a crear.
     * @param asociacionTextos objeto AsociacionTextos para vincular al Teclado.
     * @param alfabeto objeto Alfabeto para vincular al Teclado.
     * @param dim dimensiones (ancho y alto) del Teclado.
     * @param letraAIndice HashMap que asigna cada letra a su índice correspondiente.
     * @return objeto Teclado.
     */
    @Override
    public Teclado crearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, PairInt dim, HashMap<Character, Integer> letraAIndice) {
        calculo();

        int paux;
        for (int i = 1; i < 10; ++i) {
            SimulatedAnnealing simulatedAnnealing2 = new SimulatedAnnealing(filas, columnas, matrizFrecuencias, matrizDistancias);
            paux = simulatedAnnealing2.getPuntuacionFinal();
            if (paux < puntuacionFinal) {
                puntuacionFinal = paux;
                tecFinal = simulatedAnnealing2.getTecFinal();
            }
        }

        char[][] contenido = new char[tecFinal.length][tecFinal[0].length];
        for (int i = 0; i < tecFinal.length; i++) {
            for (int j = 0; j < tecFinal[i].length; j++) {
                for (Map.Entry<Character, Integer> entry : letraAIndice.entrySet()) {
                    if (entry.getValue().equals(tecFinal[i][j])) {
                        contenido[i][j] = entry.getKey();
                        break;
                    }
                }
            }
        }
        Teclado tecladoSA = new Teclado(nomT, asociacionTextos, alfabeto, dim, contenido, puntuacionFinal);

        return tecladoSA;
    }
}

