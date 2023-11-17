package test;

import main.domain.classes.Palabras;

import java.util.ArrayList;

import main.domain.classes.Frecuencias;
import main.domain.classes.Texto;
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

public class TestPalabras
{
    private Palabras palabras;

    @Before
    public void setUp() {
        palabras = new Palabras("nombreP", "aiacaia");
    }

    // ---------- CONSTRUCTORAS ----------
    public void TestConstructora () {
        System.out.println("Test Constructora");

        assertEquals("nombreP", palabras.getNombre());
        assertEquals("aiacaia", palabras.getTexto());
        assertTrue(palabras.getTexto().isEmpty());
        assertTrue(palabras.getFrecuenciaLetras().isEmpty());
        assertTrue(palabras.getAsociacionesVinculadas().isEmpty());
    }

    // ---------- AUXILIARES -----------
    @Test
    public void TestTratarEntrada() {
        System.out.println("Test TratarEntrada");

        palabras.tratarEntrada();

        //System.out.println("Test 1");
        assertEquals(2, palabras.getFrecuenciaLetras().get("ai").compareTo(2));
        //System.out.println("Test 2");
        assertEquals(2, palabras.getFrecuenciaLetras().get("ia").intValue());
        //System.out.println("Test 3");
        assertEquals(1, palabras.getFrecuenciaLetras().get("ac").intValue());
        //System.out.println("Test 4");
        assertEquals(1, palabras.getFrecuenciaLetras().get("ca").intValue());
    }
}
