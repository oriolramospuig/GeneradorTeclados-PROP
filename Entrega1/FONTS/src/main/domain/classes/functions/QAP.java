package main.domain.classes.functions;

import main.domain.classes.types.PairFrequency;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class QAP {
    private char[][] teclado; // La matriz del teclado
    private int filas;
    private int columnas;

    /**Esto simula las frecuencias que nos entran, nose muy bien que estructura debería ser*/
    private HashMap<Character, Integer> letraAIndice;
    private int[][] matrizFrecuencias;


    public QAP(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        teclado = new char[filas][columnas];
        matrizFrecuencias = new int[filas * columnas][filas * columnas];
        letraAIndice = new HashMap<>();
    }

    // ASSIGNACIÓN ALEATORIA DE M TECLAS A M POSICIONES; DE MOMENTO NECESITAMOS QUE HAYA N*N TELAS (LLENARLO ENTERO)
    public void calcularAsignacionAleatoria(List<Character> teclas) {
        if(teclas.size() != filas * columnas) {
            throw new IllegalArgumentException("El número de teclas debe coincidir con el número de posiciones en el teclado.");
        }

        // Mezcla la lista de teclas
        Collections.shuffle(teclas);

        // Asigna las teclas aleatorizadas a la matriz del teclado
        int index = 0;
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                teclado[i][j] = teclas.get(index);
                index++;
            }
        }
    }

    public void generarMatrizDeFrecuencias(List<PairFrequency> frecuenciasPares, List<Character> teclas) {
        // Primero, mapear cada letra a su índice en la matriz del teclado
        int index = 0;
        for (Character c : teclas) {
            letraAIndice.put(c, index++);
        }

        // Inicializa la matriz de frecuencias a cero
        for (int i = 0; i < matrizFrecuencias.length; i++) {
            for (int j = 0; j < matrizFrecuencias[i].length; j++) {
                matrizFrecuencias[i][j] = 0;
            }
        }

        // Llena la matriz de frecuencias usando la lista de frecuencias de pares
        for (PairFrequency pf : frecuenciasPares) {
            char letra1 = pf.getPair().charAt(0);
            char letra2 = pf.getPair().charAt(1);
            int frecuencia = pf.getFrequency();

            Integer indice1 = letraAIndice.get(letra1);
            Integer indice2 = letraAIndice.get(letra2);

            if (indice1 != null && indice2 != null) {
                matrizFrecuencias[indice1][indice2] = frecuencia;
                matrizFrecuencias[indice2][indice1] = frecuencia; // Asumiendo que la relación es bidireccional y simétrica
            }
        }
    }

    public void imprimirTeclado() {
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                System.out.print(teclado[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void imprimirMatrizFrecuencias() {
        for (int i = 0; i < matrizFrecuencias.length; i++) {
            for (int j = 0; j < matrizFrecuencias[i].length; j++) {
                System.out.print(matrizFrecuencias[i][j] + " ");
            }
            System.out.println();
        }
    }
}
