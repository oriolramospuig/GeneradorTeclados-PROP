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
     * Objeto de la prueba: Test de la constructora de ConjuntoTextos (Constructora Default).
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se inicializa el atributo de conjuntoTextos vacío.
     * Operativa: AssertEquals() comprueba que la lista de textos está vacía.
     */
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");

        assertTrue(textos.getNombresTextos().isEmpty());
    }


    // ---------- GETTERS ----------
    /**
     * Objeto de la prueba: Test del método GetTexto de ConjuntoTextos.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta un objecto texto con el atributo que lo identifica.
     * Primero se añade un texto para poder consultarlo.
     * Seguidamente se llama a la función getTexto que retorna el objeto textocon el nombre nombreF1 que es el que pasamos como parámetro.
     * Operativa :AssertNotNull() compruba que la variable donde se ha guardado el objeto texto consultado no es null.
     * AssertEquals() comprueba que el nombre del texto guardado equivale al nombre que se le ha añadido inicialmente.
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
     * Objeto de la prueba: Test del método GetNombresTextos de ConjuntoTextos.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta la lista de nombres de los textos existentes en el sistema.
     * Primero se añaden cuatro textos para poder consultar la lista.
     * Seguidamente se llama a la función getNombresTextos que retorna la lista de los nombres de los textos existentes
     * Operativa: AssertEquals() comprueba que la medida de la lista de textos sea 4.
     * Los siguientes cuatro AssertTrue() comprueban que existan en la lista todos los nombres agregados anteriormente.
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
     * Objeto de la prueba: Test del método AgregarTexto de ConjuntoTextos.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se añaden cuatro textos con la función agregartexto y con los nombres asignados que es el atributo que los identifica.
     * Operativa: AssertEquals() comprueba que la medida de la lista de textos sea 4.
     * Los siguientes AssertTrue() comprueban que los nombres de los textos guardados existen en la lista.
     */
    @Test
    public void TestAgregarTexto(){
        System.out.println("Test agregarTexto");

        textos.agregarTexto("nombreF1", tfrecuancias1);
        textos.agregarTexto("nombreF2", tfrecuencias2);
        textos.agregarTexto("nombreP1", tpalabras1);
        textos.agregarTexto("nombreP2", tpalabras2);

        assertEquals(4, textos.getNombresTextos().size());
        //assertTrue(textos.getTextos().containsKey("nombreF1"));
        //assertTrue(textos.getTextos().containsKey("nombreF2"));
        //assertTrue(textos.getTextos().containsKey("nombreP1"));
        //assertTrue(textos.getTextos().containsKey("nombreP2"));
    }


    // ---------- AUXILIARES ----------
    /**
     * Objeto de la prueba: Test del método ExisteTexto de ConjuntoTextos.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta si los texto con un nombre concreto existen en la lista de textos existentes.
     * Operativa: Los AssertTrue() comprueban que el nombre de los textos guardados existen en la lista.
     * Los AssertFalse() comprueban que los nombres de los textos no guardados, no existen en la lista.
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

        assertEquals(2, textos.getNombresTextos().size());
        assertFalse(textos.existeTexto("nombreF1"));
        assertFalse(textos.existeTexto("nombreP1"));
        assertTrue(textos.existeTexto("nombreF2"));
        assertTrue(textos.existeTexto("nombreP2"));
    }
}