package test;

import main.domain.classes.Alfabeto;

import java.util.ArrayList;

import main.domain.classes.Frecuencias;
import main.domain.classes.Teclado;
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

// ---------- CONSTRUCTORAS ----------
public class TestFrecuencias {
    public void TestConstructora() {
        System.out.println("Test Constructora");
        String nombre = "NombreEjemplo";
        Frecuencias frecuencias = new Frecuencias(nombre);

        assertEquals(nombre, frecuencias.getNombre());
    }
    // ---------- GETTERS ----------

    public void TestGetTexto() {
        System.out.println("Test GetTexto");
        Texto texto = new Texto();

        texto.getFrecuenciaLetras().put("AB", 3);
        texto.getFrecuenciaLetras().put("CD", 7);

        String textoEjemplo = "AB 3\n CD 7\n";
        assertEquals(textoEjemplo, texto.getTexto());

    }

    public void TestanadirFrecuencia() {
        System.out.println("Test AñadirFrecuencia");

        String nombre = "Nombre";
        Frecuencias frecuencias = new Frecuencias(nombre);

        frecuencias.anadirFrecuencia("AB", 3);

        assertEquals(3, frecuencias.getFrecuenciaLetras());

    }
}
