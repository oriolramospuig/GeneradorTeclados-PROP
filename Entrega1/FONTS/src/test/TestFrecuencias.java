package test;

import main.domain.classes.*;

import java.util.ArrayList;

import org.junit.*;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

import java.lang.IndexOutOfBoundsException;
import java.lang.NegativeArraySizeException;

import static org.junit.Assert.*;

/**
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestFrecuencias
{
    private Frecuencias frecuencias;

    @Before
    public void setUp() {
        HashMap<String, Integer> frecuenciaPalabras = new HashMap<>();
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuencias = new Frecuencias("nombreF", frecuenciaPalabras, frecuenciaLetras);
    }


    // ---------- CONSTRUCTORAS ----------
    /**
     * Objetivo de la Prueba:
     * La función `TestConstructora` tiene como objetivo verificar el correcto funcionamiento
     * de la constructora de la clase `Frecuencias`. Se evalúan dos casos:
     * - Constructora sin parámetros, se espera que los atributos tengan valores predeterminados.
     * - Constructora con un nombre específico, se espera que el nombre se establezca correctamente.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de la lógica interna de la constructora de la clase `Frecuencias`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Constructora sin parámetros: Se verifica que el nombre sea una cadena vacía y que las listas
     *    de texto, frecuencia de letras y asociaciones vinculadas estén vacías.
     * 2. Constructora con un nombre específico: Se verifica que el nombre sea el esperado y que las listas
     *    de texto, frecuencia de letras y asociaciones vinculadas estén vacías.
     *
     * Operativa:
     * Se ejecutan dos casos de prueba:
     * 1. Constructora sin parámetros.
     * 2. Constructora con un nombre específico.
     */
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora Default");
        assertEquals("", frecuencias.getNombre());
        assertTrue(frecuencias.getTexto().isEmpty());
        assertTrue(frecuencias.getFrecuenciaLetras().isEmpty());
        assertTrue(frecuencias.getAsociacionesVinculadas().isEmpty());


        System.out.println("Test Constructora con Nombre");
        assertEquals("nombreF", frecuencias.getNombre());
        assertTrue(frecuencias.getTexto().isEmpty());
        assertTrue(frecuencias.getFrecuenciaLetras().isEmpty());
        assertTrue(frecuencias.getAsociacionesVinculadas().isEmpty());
    }


    // ---------- GETTERS ----------
    /**
     * Objetivo de la Prueba:
     * La función `TestGetTexto` tiene como objetivo verificar el correcto funcionamiento
     * del método `getTexto` de la clase `Frecuencias`. Este método debería devolver una
     * representación de cadena del objeto, que contiene las frecuencias de letras.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de la lógica interna del método `getTexto` de la clase `Frecuencias`.
     *
     * Valores Estudiados:
     * Se evalúa el siguiente aspecto:
     * 1. Se añaden dos frecuencias de letras a la instancia de `Frecuencias`.
     * 2. Se verifica que la cadena devuelta por el método `getTexto` sea la esperada.
     *
     * Operativa:
     * 1. Se crea una instancia de `Frecuencias`.
     * 2. Se añaden dos frecuencias de letras mediante el método `anadirFrecuencia`.
     * 3. Se verifica que la cadena devuelta por el método `getTexto` sea la esperada.
     */
    @Test
    public void TestGetTexto() {
        System.out.println("Test GetTexto");

        frecuencias.anadirPalabra("AB", 3);
        frecuencias.anadirPalabra("CD", 7);

        String textoEjemplo = "AB 3\nCD 7\n";
        assertEquals(textoEjemplo, frecuencias.getTexto());

    }

    // ---------- SETTERS -----------
    /*@Test
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
    }*/
}
