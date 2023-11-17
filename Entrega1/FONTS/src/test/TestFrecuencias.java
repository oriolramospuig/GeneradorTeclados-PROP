package test;

import main.domain.classes.*;

import java.util.ArrayList;

import org.junit.*;

import java.io.*;
import java.util.Set;

import java.lang.IndexOutOfBoundsException;
import java.lang.NegativeArraySizeException;

import static org.junit.Assert.*;

public class TestFrecuencias
{
    private Frecuencias frecuencias;

    @Before
    public void setUp() {
        frecuencias = new Frecuencias("nombreF");
    }


    // ---------- CONSTRUCTORAS ----------
    @Test
    public void TestConstructora() {
     /*   System.out.println("Test Constructora Default");
        assertEquals("", frecuencias.getNombre());
        assertTrue(frecuencias.getTexto().isEmpty());
        assertTrue(frecuencias.getFrecuenciaLetras().isEmpty());
        assertTrue(frecuencias.getAsociacionesVinculadas().isEmpty());
        */

        System.out.println("Test Constructora con Nombre");
        assertEquals("nombreF", frecuencias.getNombre());
        assertTrue(frecuencias.getTexto().isEmpty());
        assertTrue(frecuencias.getFrecuenciaLetras().isEmpty());
        assertTrue(frecuencias.getAsociacionesVinculadas().isEmpty());
    }


    // ---------- GETTERS ----------
    @Test
    public void TestGetTexto() {
        System.out.println("Test GetTexto");

        frecuencias.anadirFrecuencia("AB", 3);
        frecuencias.anadirFrecuencia("CD", 7);

        String textoEjemplo = "AB 3\nCD 7\n";
        assertEquals(textoEjemplo, frecuencias.getTexto());

    }

    // ---------- SETTERS -----------
    @Test
    public void TestAnadirFrecuencia() {
        System.out.println("Test AñadirFrecuencia");

        frecuencias.anadirFrecuencia("AB", 3);
        frecuencias.anadirFrecuencia("CD", 1);

        assertEquals(2, frecuencias.getFrecuenciaLetras().size());
        assertTrue(frecuencias.getFrecuenciaLetras().containsKey("AB"));
        assertEquals(3, (int) frecuencias.getFrecuenciaLetras().get("AB"));
        assertNotEquals(2, (int) frecuencias.getFrecuenciaLetras().get("AB"));
        assertTrue(frecuencias.getFrecuenciaLetras().containsKey("CD"));
        assertEquals(1, (int) frecuencias.getFrecuenciaLetras().get("CD"));
    }
}
