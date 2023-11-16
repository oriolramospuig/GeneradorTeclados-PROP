package test;


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
    public void TestConstructora() {
        System.out.println("Test Constructoras");

        Texto texto = new Texto();
        // Verificar que los campos se inicializan correctamente

        assertNotNull(texto.getNombre());
        assertNotNull(texto.getFrecuenciaLetras());
        assertNotNull(texto.getAsociacionesVinculadas());
        assertEquals(0, texto.getFrecuenciaLetras().size());
        assertEquals(0,texto.getAsociacionesVinculadas());
    }

    public class TextoTest {

        public void TestagregarAsociacionesVinculadas() {
            System.out.println("Test Agregar Asociaciones Vinculadas");

            Texto texto = new Texto();

            //verificamos que la lista de asociaciones está vacía al principio
            assertTrue(texto.getAsociacionesVinculadas().isEmpty());

            //Llamamos a la función
            texto.agregarAsociacionesVinculadas("Nombre Asociacion");

            //Verificamos que la asociación se ha agregado
            assertFalse(texto.getAsociacionesVinculadas().isEmpty());
            assertEquals(1, texto.getAsociacionesVinculadas().size());
            assertEquals("Nombre Asociacion", texto.getAsociacionesVinculadas().get(0));
        }
        
        public void TestborrarAsociacionesVinculadas() {
            System.out.println("Test Borrar Asociaciones Vinculadas");
            Texto texto = new Texto();
            texto.agregarAsociacionesVinculadas("Nombre Asociacion");
            assertFalse(texto.getAsociacionesVinculadas().isEmpty());
            assertEquals(1, texto.getAsociacionesVinculadas().size());
            assertEquals("Nombre Asociacion", texto.getAsociacionesVinculadas().get(0));

            texto.borrarAsociacionesVinculadas("NombreAsociacion");
            assertTrue(texto.getAsociacionesVinculadas().isEmpty());
        }
    }
}

