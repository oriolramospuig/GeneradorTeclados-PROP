package main.domain.classes.functions;

public class Manhattan {
    public static int calcularDistancia(int fila1, int columna1, int fila2, int columna2) {
        return Math.abs(fila1 - fila2) + Math.abs(columna1 - columna2);
    }
}

