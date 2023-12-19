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


/**
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestTexto {
    private Palabras palabras;
    private Frecuencias frecuencias;

    private String nombreAT1;
    private String nombreAT2;

    /*@Before
    public void setUp() {
        nombreAT1 = "nombreAT1";
        nombreAT2 = "nombreAT2";

        palabras = new Palabras("nombreP1", "hola");
        frecuencias = new Frecuencias("nombreF1");
    }*/

    // ---------- SETTERS ----------
    /**
     * Objetivo de la Prueba:
     * La función `TestAgregarAsociacionesVinculadas` tiene como objetivo verificar el correcto funcionamiento
     * del método `AgregarAsociacionesVinculadas` de la clase `Texto`. Este método debería agregar
     * un texto a una asociacion
     * Ficheros Necesarios: No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Textos`.
     * Valores Estudiados:
     * 1. Se crea una instancia de `Palabras` y `Frecuencias`.
     * 2. Se agregan las dos a una Asociacion.
     * 3. Se verifica que la lista de frecuencias y palabras vinculadas se haya actualizado correctamente
     * Operativa:
     * 1. Se crea una palabras y una frecencias
     * 2. Se agregan las dos a la asociación mediante el método `agregarAsociacionesVinculadas`.
     * 3. Se verifica que la lista de teclados vinculados tenga el tamaño esperado
     */
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
    /**
     * Objetivo de la Prueba:
     * La función `TestBorrarAsociacionesVinculadas` tiene como objetivo verificar el correcto funcionamiento
     * del método `BorrarAsociacionesVinculadas` de la clase `Texto`. Este método debería borrar
     * un texto a una asociacion
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Textos`.
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se crean dos instancia de `Palabras` y `Frecuencias`.
     * 2. Se agregan las 4 a una Asociacion y se borran 2
     * 3. Se verifica que la lista de frecuencias y palabras vinculadas se haya actualizado correctamente
     * Operativa:
     * 1. Se crean dos palabras y dos frecencias
     * 2. Se agregan las 4 a la asociación mediante el método `agregarAsociacionesVinculadas`.
     * 3. Se borran una de cada una
     * 4. Se verifica que la lista de teclados vinculados tenga el tamaño esperado y se han eliminado
     */
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
