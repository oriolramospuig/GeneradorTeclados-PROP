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

public class TestPalabras {
    public void TestConstructora() {
        System.out.println("Test Constructora");
        String nombre = "Nombre";
        String contenido = "Contenido";
        Palabras palabras = new Palabras(nombre, contenido);

        assertEquals(nombre, palabras.getNombre());
        assertEquals(contenido, palabras.getTexto());
    }

    public void TestTratarEntrada() {
        System.out.println("Test TratarEntrada");

        Palabras palabras = new Palabras("Nombre", "aiacaia");
        palabras.tratarEntrada();

        assertEquals(2, palabras.getFrecuenciaLetras().get("ai").intValue());
        assertEquals(2, palabras.getFrecuenciaLetras().get("ia").intValue());
        assertEquals(1, palabras.getFrecuenciaLetras().get("ac").intValue());
        assertEquals(1, palabras.getFrecuenciaLetras().get("ca").intValue());
    }
}
