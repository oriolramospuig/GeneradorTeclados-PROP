package main.domain.classes.functions;

/**
 * Calcula la distancia Manhattan entre dos puntos (x,y) y (x', y')
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 */
public class Manhattan {
    /**
     * Calcula la distancia Manhattan entre dos puntos en una cuadrícula.
     * La distancia Manhattan es la suma de las diferencias absolutas de sus coordenadas.
     *
     * @param fila1 Coordenada de fila del primer punto.
     * @param columna1 Coordenada de columna del primer punto.
     * @param fila2 Coordenada de fila del segundo punto.
     * @param columna2 Coordenada de columna del segundo punto.
     * @return La distancia Manhattan entre los dos puntos especificados.
     */
    public static int calcularDistancia(int fila1, int columna1, int fila2, int columna2) {
        return Math.abs(fila1 - fila2) + Math.abs(columna1 - columna2);
    }
}

