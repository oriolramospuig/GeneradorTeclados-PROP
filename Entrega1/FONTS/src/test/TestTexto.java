package test;


import main.domain.classes.Frecuencias;
import main.domain.classes.Palabras;
import main.domain.classes.Texto;

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


public class TestTexto {
    private Palabras palabras;
    private Frecuencias frecuencias;

    private String nombreAT1;
    private String nombreAT2;

    @Before
    public void setUp() {
        nombreAT1 = "nombreAT1";
        nombreAT2 = "nombreAT2";

        palabras = new Palabras("nombreP1", "hola");
        frecuencias = new Frecuencias("nombreF1");
    }

    // ---------- SETTERS ----------
    @Test
    public void TestAgregarAsociacionesVinculadas() {
        System.out.println("Test Agregar Asociaciones Vinculadas");

        palabras.agregarAsociacionesVinculadas(nombreAT1);
        frecuencias.agregarAsociacionesVinculadas(nombreAT2);

        //Verificamos que la asociación se ha agregado
        assertFalse(palabras.getAsociacionesVinculadas().isEmpty());
        assertFalse(frecuencias.getAsociacionesVinculadas().isEmpty());
        assertTrue(palabras.getAsociacionesVinculadas().contains(nombreAT1));
        assertFalse(palabras.getAsociacionesVinculadas().contains(nombreAT2));
        assertFalse(frecuencias.getAsociacionesVinculadas().contains(nombreAT1));
        assertTrue(frecuencias.getAsociacionesVinculadas().contains(nombreAT2));
    }


    // ---------- AUXILIARES ----------
    @Test
    public void TestBorrarAsociacionesVinculadas() {
        System.out.println("Test Borrar Asociaciones Vinculadas");

       palabras.agregarAsociacionesVinculadas(nombreAT1);
       palabras.agregarAsociacionesVinculadas(nombreAT2);
       frecuencias.agregarAsociacionesVinculadas((nombreAT1));
       frecuencias.agregarAsociacionesVinculadas(nombreAT2);

       palabras.borrarAsociacionesVinculadas(nombreAT1);
       frecuencias.borrarAsociacionesVinculadas(nombreAT2);

       assertEquals(1, palabras.getAsociacionesVinculadas().size());
       assertFalse(palabras.getAsociacionesVinculadas().contains(nombreAT1));
       assertTrue(palabras.getAsociacionesVinculadas().contains(nombreAT2));

       assertEquals(1, frecuencias.getAsociacionesVinculadas().size());
       assertTrue(frecuencias.getAsociacionesVinculadas().contains(nombreAT1));
       assertFalse(frecuencias.getAsociacionesVinculadas().contains(nombreAT2));
    }
}