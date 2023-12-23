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
 * Clase de pruebas unitarias para Frecuencias. Evalúa el correcto funcionamiento de la creación y manipulación de objetos Texto de tipo Frecuencias.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestFrecuencias {
    /** Instancia de la clase Frecuencias utilizada en los casos de prueba. */
    private Frecuencias frecuencias;

    /** Constantes para datos de prueba. */
    private static final String nombreF = "textoFrecuencias";
    private static final String texto_hola = "hola";
    private static final String texto_adios = "adios";

    /** HashMaps para frecuencias de palabras y frecuencias usadas en la prueba. */
    private static final HashMap<String, Integer> frecuenciaPalabras_hola = new HashMap<>();
    private static final HashMap<String, Integer> frecuenciaLetras_hola = new HashMap<>();
    private static final HashMap<String, Integer> frecuenciaPalabras_adios = new HashMap<>();
    private static final HashMap<String, Integer> frecuenciaLetras_adios = new HashMap<>();

    /**
     * Inicialización de HashMaps para datos de la prueba.
     */
    @Before
    public void setUp() {
        frecuenciaPalabras_hola.put(texto_hola, 1);
        frecuenciaLetras_hola.put("ho", 1);
        frecuenciaLetras_hola.put("ol", 1);
        frecuenciaLetras_hola.put("la", 1);

        frecuenciaPalabras_adios.put(texto_adios, 4);
        frecuenciaLetras_adios.put("ad", 1);
        frecuenciaLetras_adios.put("di", 1);
        frecuenciaLetras_adios.put("io", 1);
        frecuenciaLetras_adios.put("os", 1);
    }

    /**
     * Objeto de la prueba: Test de la constructora de Frecuencias.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja gris. Se define un texto de tipo Frecuencias y se comprueba que se crea correctamente.
     * Operativa: Creamos un nuevo Texto de tipo Frecuencias con los parámetros nombreF, frecuenciaPalabras_hola y frecuenciaLetras_hola que se han definido previamente. Se comprueba que los valores se introducen adecuadamente.
     */
    @Test
    public void TestConstructora() {
        //System.out.println("Test Constructora");

        frecuencias = new Frecuencias(nombreF, frecuenciaPalabras_hola, frecuenciaLetras_hola);

        assertEquals("textoFrecuencias", frecuencias.getNombre());
        assertEquals("hola 1\n", frecuencias.getTexto());
        assertEquals(3, frecuencias.getFrecuenciaLetras().size());
        assertTrue(frecuencias.getFrecuenciaLetras().containsKey("ho"));
        assertTrue(frecuencias.getFrecuenciaLetras().containsKey("ol"));
        assertTrue(frecuencias.getFrecuenciaLetras().containsKey("la"));
        assertTrue(frecuencias.getAsociacionesVinculadas().isEmpty());
    }

    /**
     * Objeto de la prueba: Test del método getTexto de la clase Frecuencias.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja gris. Se evalúa que el método getTexto devuelva los textos esperados para instancias de Frecuencias.
     * Operativa: Se crea una instancia de Frecuencias con datos específicos (frecuenciaPalabras_adios y frecuenciaLetras_adios). Se llama al método getTexto y se verifica que el resultado sea igual a "adios 4\n".
     */
    @Test
    public void TestGetTexto() {
        //System.out.println("Test GetTexto");

        frecuencias = new Frecuencias(nombreF, frecuenciaPalabras_adios, frecuenciaLetras_adios);

        assertEquals("adios 4\n", frecuencias.getTexto());
    }

    /**
     * Objeto de la prueba: Test del método modificarFrecuencias de la clase Frecuencias.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja gris. Se evalúa que el método modificarFrecuencias. A partir de una instancia de frecuencias ya creada, se cambia correctamente el contenido de frecuencias de letras y palabras de esta.
     * Operativa: Se crea una instancia de Frecuencias con datos específicos (frecuenciaPalabras_hola y frecuenciaLetras_hola). A partir de esto se llama a la función modificarFrecuencias, pasando nuevos HashMaps (adios) y se comprueba que posteriormente el contenido ha cambiado.
     */
    @Test
    public void TestModificarFrecuencias() {
        //System.out.println("Test modificarFrecuencias");

        frecuencias = new Frecuencias(nombreF, frecuenciaPalabras_hola, frecuenciaLetras_hola);

        frecuencias.modificarFrecuencias(frecuenciaPalabras_adios, frecuenciaLetras_adios);

        assertNotEquals("hola 1\n", frecuencias.getTexto());
        assertEquals("adios 4\n", frecuencias.getTexto());
        assertNotEquals(3, frecuencias.getFrecuenciaLetras().size());
        assertEquals(4, frecuencias.getFrecuenciaLetras().size());
    }
}