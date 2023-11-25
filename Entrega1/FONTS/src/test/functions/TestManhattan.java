package test.functions;
import main.domain.classes.Alfabeto;

import java.util.ArrayList;

import main.domain.classes.Teclado;
import main.domain.classes.functions.Manhattan;
import org.junit.*;

import java.io.*;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 */
public class TestManhattan {
    @Test
    public void testcalcularDistancia() {
        System.out.println("Test Calcular Distancia");
        int distancia = Manhattan.calcularDistancia(1, 2, 4, 6);

        assertEquals(7, distancia);
    }
}

