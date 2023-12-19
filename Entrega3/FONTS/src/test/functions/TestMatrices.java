package test.functions;

import main.domain.classes.functions.Manhattan;
import main.domain.classes.functions.Matrices;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 */
public class TestMatrices {
    /**
     * Objeto de la Prueba: La prueba tiene como objetivo verificar la correcta generación de una matriz de
     * distancias utilizando la función generarMatrizDistancias de la clase Matrices.
     * Se comprueba que las distancias en la matriz coincidan con las calculadas mediante la función Manhattan.
     * Ficheros necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados:
     *  filas: Número de filas de la matriz.
     *  columnas: Número de columnas de la matriz.
     * Operativa:
     * 1. Definición de los parámetros de la matriz (filas y columnas).
     * 2. Llamada al método generarMatrizDistancias para obtener la matriz de distancias.
     * 3. Verificación de la generación correcta de la matriz de distancias.
     * 4. Verificación de que la distancia sea la calculada por la función Manhattan.
     */
    @Test
    public void TestGenerarMatrizDistancias() {
        int filas = 3;
        int columnas = 3;
        int[][] matrizDistancias = Matrices.generarMatrizDistancias(filas, columnas);;


        // Verificar que la matriz de distancias se haya generado correctamenteyou
        for (int i = 0; i < filas * columnas; i++) {
            for (int j = 0; j < filas * columnas; j++) {
                // Verificar que la distancia sea la calculada por la función Manhattan
                assertEquals(Manhattan.calcularDistancia(i / columnas, i % columnas, j / columnas, j % columnas),
                        matrizDistancias[i][j]);
            }
        }
    }
}
