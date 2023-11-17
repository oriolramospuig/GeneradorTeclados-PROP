package test.functions;

import main.domain.classes.Frecuencias;
import main.domain.classes.Palabras;
import main.domain.classes.Texto;
import main.domain.classes.functions.Manhattan;
import main.domain.classes.functions.Matrices;

import java.util.ArrayList;

import main.domain.classes.Teclado;
import org.junit.*;

import java.io.*;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import java.lang.IndexOutOfBoundsException;
import java.lang.NegativeArraySizeException;

public class TestMatrices {
    public void TestGenerarMatrizDistancias() {
        int filas = 3;
        int columnas = 3;
        int[][] matrizDistancias = new int[filas * columnas][filas * columnas];


        Matrices.generarMatrizDistancias(filas, columnas, matrizDistancias);

        for (int i = 0; i < filas * columnas; i++) {
            for (int j = 0; j < filas * columnas; j++) {
                assertEquals(Manhattan.calcularDistancia(i / columnas, i % columnas, j / columnas, j % columnas), matrizDistancias[i][j]);
            }
        }
    }
}

