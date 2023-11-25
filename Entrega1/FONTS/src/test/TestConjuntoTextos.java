package test;

import main.domain.classes.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestConjuntoTextos {
    private ConjuntoTextos textos;

    private Frecuencias tfrecuancias1;

    private Frecuencias tfrecuencias2;

    private Palabras tpalabras1;

    private Palabras tpalabras2;

    @Before
    public void setUp() {
        textos = new ConjuntoTextos();
        HashMap<String, Integer> frecuenciaLetras = new HashMap<String,Integer>();
        HashMap<String, Integer> contenidoFrec = new HashMap<String, Integer>();
        frecuenciaLetras.put("ho", 1);
        frecuenciaLetras.put("la", 1);
        contenidoFrec.put("hola", 2);
        tfrecuancias1 = new Frecuencias("nombreF1", contenidoFrec, frecuenciaLetras);         //tfrecuencias1 tiene: hola-2
        frecuenciaLetras.remove("ho", 1);
        frecuenciaLetras.remove("la", 1);
        contenidoFrec.remove("hola", 2);
        contenidoFrec.put("ai", 1);
        tfrecuencias2 = new Frecuencias("nombreF2", contenidoFrec, frecuenciaLetras);         //tfrecuencias2 tiene ai-1
        tpalabras1 = new Palabras("nombreP1", "abc", frecuenciaLetras);
        tpalabras2 = new Palabras("nombreP2", "cde", frecuenciaLetras);
    }


    // ---------- CONSTRUCTORAS ----------
    /**
     * Objetivo de la Prueba:
     * La función `TestExisteAsociaciondeTextos` tiene como objetivo verificar el correcto funcionamiento
     * del método `existeAsociaciondeTextos` de la clase `Asociaciones`. Este método debería devolver
     * `true` si la asociación de textos con el nombre dado está presente en la colección y `false` en caso contrario.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Asociaciones`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agrega una asociación de textos mediante el método `agregarAsociacionTexto`.
     * 3. Se verifica que el método `existeAsociaciondeTextos` devuelva `true` para el nombre de la asociación agregada y `false` para un nombre que no está presente.
     *
     * Operativa:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agrega una asociación de textos mediante el método `agregarAsociacionTexto`.
     * 3. Se verifica que el método `existeAsociaciondeTextos` devuelva `true` para el nombre de la asociación agregada y `false` para un nombre que no está presente.
     */
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");

        assertTrue(textos.getTextos().isEmpty());
    }


    // ---------- GETTERS ----------
    /**
     * Objetivo de la Prueba:
     * La función `TestGetTexto` tiene como objetivo verificar el correcto funcionamiento
     * del método `getTexto` de la clase `Textos`. Este método debería devolver un objeto
     * `Texto` específico según el nombre proporcionado.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Textos`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se agrega un texto de frecuencias a la colección mediante el método `agregarTexto`.
     * 2. Se obtiene el texto de frecuencias por su nombre usando el método `getTexto`.
     * 3. Se agrega un texto de palabras a la colección mediante el método `agregarTexto`.
     * 4. Se obtiene el texto de palabras por su nombre usando el método `getTexto`.
     * 5. Se verifica que los objetos `Texto` devueltos no sean nulos y que tengan los nombres esperados.
     *
     * Operativa:
     * 1. Se agrega un texto de frecuencias a la colección mediante el método `agregarTexto`.
     * 2. Se obtiene el texto de frecuencias por su nombre usando el método `getTexto`.
     * 3. Se agrega un texto de palabras a la colección mediante el método `agregarTexto`.
     * 4. Se obtiene el texto de palabras por su nombre usando el método `getTexto`.
     * 5. Se verifica que los objetos `Texto` devueltos no sean nulos y que tengan los nombres esperados.
     */
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

    /**
     * Objetivo de la Prueba:
     * La función `TestGetNombresTextos` tiene como objetivo verificar el correcto funcionamiento
     * del método `getNombresTextos` de la clase `Textos`. Este método debería devolver una lista
     * de nombres de textos presentes en la colección.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Textos`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se agregan cuatro textos a la colección mediante el método `agregarTexto`.
     * 2. Se obtiene la lista de nombres de textos mediante el método `getNombresTextos`.
     * 3. Se verifica que la lista tenga el tamaño esperado y contenga los nombres de los textos agregados.
     *
     * Operativa:
     * 1. Se agregan cuatro textos a la colección mediante el método `agregarTexto`.
     * 2. Se obtiene la lista de nombres de textos mediante el método `getNombresTextos`.
     * 3. Se verifica que la lista tenga el tamaño esperado y contenga los nombres de los textos agregados.
     */
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
    /**
     * Objetivo de la Prueba:
     * La función `TestAgregarTexto` tiene como objetivo verificar el correcto funcionamiento
     * del método `agregarTexto` de la clase `Textos`. Este método debería agregar un texto a la colección.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Textos`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se agrega un total de cuatro textos a la colección mediante el método `agregarTexto`.
     * 2. Se verifica que la colección tenga el tamaño esperado y contenga los textos agregados.
     *
     * Operativa:
     * 1. Se agrega un total de cuatro textos a la colección mediante el método `agregarTexto`.
     * 2. Se verifica que la colección tenga el tamaño esperado y contenga los textos agregados.
     */
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
    /**
     * Objetivo de la Prueba:
     * La función `TestExisteTexto` tiene como objetivo verificar el correcto funcionamiento
     * del método `existeTexto` de la clase `Textos`. Este método debería indicar si un texto
     * específico existe en la colección.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Textos`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se agrega un total de dos textos a la colección mediante el método `agregarTexto`.
     * 2. Se verifica la existencia de los textos agregados y la no existencia de textos no agregados.
     *
     * Operativa:
     * 1. Se agrega un total de dos textos a la colección mediante el método `agregarTexto`.
     * 2. Se verifica la existencia de los textos agregados y la no existencia de textos no agregados.
     */
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

    /**
     * Objetivo de la Prueba:
     * La función `TestBorrarTexto` tiene como objetivo verificar el correcto funcionamiento
     * del método `borrarTexto` de la clase `Textos`. Este método debería eliminar un texto
     * específico de la colección.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Textos`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se agregan un total de cuatro textos a la colección mediante el método `agregarTexto`.
     * 2. Se eliminan dos textos específicos mediante el método `borrarTexto`.
     * 3. Se verifica que la colección tenga el tamaño esperado después de la eliminación.
     * 4. Se verifica la no existencia de los textos eliminados y la existencia de los no eliminados.
     *
     * Operativa:
     * 1. Se agregan un total de cuatro textos a la colección mediante el método `agregarTexto`.
     * 2. Se eliminan dos textos específicos mediante el método `borrarTexto`.
     * 3. Se verifica que la colección tenga el tamaño esperado después de la eliminación.
     * 4. Se verifica la no existencia de los textos eliminados y la existencia de los no eliminados.
     */
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