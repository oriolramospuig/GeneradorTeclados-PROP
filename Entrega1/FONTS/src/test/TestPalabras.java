package test;

import main.domain.classes.AsociacionTextos;
import main.domain.classes.Palabras;

import java.util.ArrayList;

import main.domain.classes.Frecuencias;
import main.domain.classes.Texto;
import main.domain.classes.functions.InOut;
import main.domain.classes.types.PairFrequency;
import org.junit.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
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

        assertEquals(2, palabras.getFrecuenciaLetras().size());
        assertEquals(4, (int) palabras.getFrecuenciaLetras().get("ai"));
        assertFalse(palabras.getFrecuenciaLetras().containsKey("ia"));
        assertEquals(2, (int) palabras.getFrecuenciaLetras().get("ac"));
        assertFalse(palabras.getFrecuenciaLetras().containsKey("ca"));
    }
}