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
    /**
     * Objeto de la Prueba: La prueba tiene como objetivo verificar el correcto funcionamiento del método calcularDistancia
     * de la clase Manhattan, que calcula la distancia de Manhattan entre dos puntos en un plano cartesiano.
     * Ficheros Necesarios: No se requieren ficheros externos para esta prueba.
     * Valores Estudiados: Puntos en un plano cartesiano representados por las coordenadas (x1, y1) y (x2, y2).
     * Operativa:
     * 1. Mensaje informativo en consola para identificar la prueba.
     * 2. Llamada al método calcularDistancia con los puntos dados.
     * 3. Aserción para verificar que la distancia calculada coincide con el valor esperado (en este caso, 7).
     */
    @Test
    public void testcalcularDistancia() {
        System.out.println("Test Calcular Distancia");
        int distancia = Manhattan.calcularDistancia(1, 2, 4, 6);

        assertEquals(7, distancia);
    }
}

