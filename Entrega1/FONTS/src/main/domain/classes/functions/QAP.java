package main.domain.classes.functions;

import java.util.Collections;
import java.util.List;

public class QAP {
    private char[][] teclado; // La matriz del teclado
    private int filas;
    private int columnas;

    public QAP(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        teclado = new char[filas][columnas];
    }

    // ASSIGNACIÓN ALEATORIA DE M TECLAS A M POSICIONES; DE MOMENTO NECESITAMOS QUE HAYA N*N TELAS (LLENARLO TODO)
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

    public void imprimirTeclado() {
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                System.out.print(teclado[i][j] + " ");
            }
            System.out.println();
        }
    }
}
