package test.functions;


import main.domain.classes.Frecuencias;
import main.domain.classes.Palabras;
import main.domain.classes.Texto;
import main.domain.classes.functions.Manhattan;
import main.domain.classes.functions.Matrices;

import static org.junit.Assert.assertEquals;

public class TestMatrices {
    public void TestGenerarMatrizDistancias() {
        int filas = 3;
        int columnas = 3;
        int[][] matrizDistancias = new int[filas * columnas][filas * columnas];

        // Llamar a la función para generar la matriz de distancias
        Matrices.generarMatrizDistancias(filas, columnas, matrizDistancias);

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
