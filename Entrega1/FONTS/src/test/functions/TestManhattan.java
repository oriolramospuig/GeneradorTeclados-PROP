package test.functions;
import main.domain.classes.Alfabeto;

import java.util.ArrayList;

import main.domain.classes.Teclado;
import main.domain.classes.functions.Manhattan;
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

public class TestManhattan {
    @Test
    public void testcalcularDistancia() {
        System.out.println("Test Calcular Distancia");
        int distancia = Manhattan.calcularDistancia(1, 2, 4, 6);

        assertEquals(7, distancia);
    }
}

