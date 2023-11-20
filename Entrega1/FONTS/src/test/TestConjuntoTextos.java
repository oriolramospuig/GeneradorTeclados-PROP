package test;

import main.domain.classes.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class TestConjuntoTextos {
    private ConjuntoTextos textos;

    private Frecuencias tfrecuancias1;

    private Frecuencias tfrecuencias2;

    private Palabras tpalabras1;

    private Palabras tpalabras2;

    @Before
    public void setUp() {
        textos = new ConjuntoTextos();
        HashMap<String, Integer> contenidoFrec = new HashMap<>();
        contenidoFrec.put("hola", 2);
        tfrecuancias1 = new Frecuencias("nombreF1", contenidoFrec);         //tfrecuencias1 tiene: hola-2
        contenidoFrec.remove("hola", 2);
        contenidoFrec.put("ai", 1);
        tfrecuencias2 = new Frecuencias("nombreF2", contenidoFrec);         //tfrecuencias2 tiene ai-1
        tpalabras1 = new Palabras("nombreP1", "abc");
        tpalabras2 = new Palabras("nombreP2", "cde");
    }


    // ---------- CONSTRUCTORAS ----------
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");

        assertTrue(textos.getTextos().isEmpty());
    }


    // ---------- GETTERS ----------
    @Test
    public void TestGetTexto() {
        System.out.println("Test getTexto");

        textos.agregarTexto("nombreF1", tfrecuancias1);
        Texto resultadoFrecuencia = textos.getTexto("nombreF1");

        textos.agregarTexto("nombreP1", tpalabras1);
        Texto resultadoPalabras = textos.getTexto("nombreP1");

        assertNotNull(resultadoFrecuencia);
        assertEquals("nombreF1", resultadoFrecuencia.getNombre());
        assertNotNull(resultadoPalabras);
        assertEquals("nombreP1", resultadoPalabras.getNombre());
    }

    @Test
    public void TestGetNombresTextos() {
        System.out.println("Test getNombresTextos");

        textos.agregarTexto("nombreF1", tfrecuancias1);
        textos.agregarTexto("nombreF2", tfrecuencias2);
        textos.agregarTexto("nombreP1", tpalabras1);
        textos.agregarTexto("nombreP2", tpalabras2);

        ArrayList<String> nombres = textos.getNombresTextos();

        assertEquals(4, nombres.size());
        assertTrue(nombres.contains("nombreF1"));
        assertTrue(nombres.contains("nombreF2"));
        assertTrue(nombres.contains("nombreP1"));
        assertTrue(nombres.contains("nombreP2"));
    }


    // ---------- SETTERS ----------
    @Test
    public void TestAgregarTexto(){
        System.out.println("Test agregarTexto");

        textos.agregarTexto("nombreF1", tfrecuancias1);
        textos.agregarTexto("nombreF2", tfrecuencias2);
        textos.agregarTexto("nombreP1", tpalabras1);
        textos.agregarTexto("nombreP2", tpalabras2);

        assertEquals(4, textos.getTextos().size());
        assertTrue(textos.getTextos().containsKey("nombreF1"));
        assertTrue(textos.getTextos().containsKey("nombreF2"));
        assertTrue(textos.getTextos().containsKey("nombreP1"));
        assertTrue(textos.getTextos().containsKey("nombreP2"));
    }


    // ---------- AUXILIARES ----------
    @Test
    public void TestExisteTexto() {
        System.out.println("Test existeTexto");

        textos.agregarTexto("nombreF1", tfrecuancias1);
        textos.agregarTexto("nombreP1", tpalabras1);

        assertTrue(textos.existeTexto("nombreF1"));
        assertTrue(textos.existeTexto("nombreP1"));
        assertFalse(textos.existeTexto("nombreF2"));
        assertFalse(textos.existeTexto("nombreP2"));
    }

    @Test
    public void TestBorrarTexto() {
        System.out.println("Test borrarTexto");

        textos.agregarTexto("nombreF1", tfrecuancias1);
        textos.agregarTexto("nombreF2", tfrecuencias2);
        textos.agregarTexto("nombreP1", tpalabras1);
        textos.agregarTexto("nombreP2", tpalabras2);

        textos.borrarTexto("nombreF1");
        textos.borrarTexto("nombreP1");

        assertEquals(2, textos.getTextos().size());
        assertFalse(textos.existeTexto("nombreF1"));
        assertFalse(textos.existeTexto("nombreP1"));
        assertTrue(textos.existeTexto("nombreF2"));
        assertTrue(textos.existeTexto("nombreP2"));
    }
}