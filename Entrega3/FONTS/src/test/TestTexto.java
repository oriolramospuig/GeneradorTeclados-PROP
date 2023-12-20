package test;


import main.domain.classes.Frecuencias;
import main.domain.classes.Palabras;
import main.domain.classes.Texto;

import java.util.ArrayList;

import main.domain.classes.Teclado;
import org.junit.*;

import java.io.*;
import java.util.HashMap;
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
 * Clase de pruebas unitarias para Texto. Evalúa el correcto funcionamiento de la creación y manipulación de objetos Texto, ya sean de tipo Palabras o Frecuencias.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestTexto {
    /** Instancia de la clase Palabras utilizada en los casos de prueba. Se inicializa y utiliza en el método de configuración (setUp) para disponer de un objeto de prueba en los distintos casos de prueba de la clase TestTexto. */
    private Palabras textoPalabras;

    /** Instancia de la clase Frecuencias utilizada en los casos de prueba. Se inicializa y utiliza en el método de configuración (setUp) para disponer de un objeto de prueba en los distintos casos de prueba de la clase TestTexto. */
    private Frecuencias textoFrecuencias;

    /**
     * Inicialización de un texto de tipo Palabras y otro de tipo Frecuencias.
     */
    @Before
    public void setUp() {
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("ho", 1);
        frecuenciaLetras.put("ol", 1);
        frecuenciaLetras.put("la", 1);

        //Palabras
        String nombreP = "textoPalabras";
        String textoP = "hola";
        textoPalabras = new Palabras(nombreP, textoP, frecuenciaLetras);

        //Frecuencias
        String nombreF = "textoFrecuencias";
        HashMap<String,Integer> frecuenciaPalabras = new HashMap<>();
        frecuenciaPalabras.put("hola", 1);
        textoFrecuencias = new Frecuencias(nombreF, frecuenciaPalabras, frecuenciaLetras);
    }

    /**
     * Objeto de la prueba: Test del método getTexto de la clase Texto. Se trata de una función abstracta pero se quiere comprobar que tanto para Palabras como Frecuencias funciona adecuadamente.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba. Se crean instancias de Palabras y Frecuencias en el método de configuración.
     * Valores estudiados: Estrategia caja gris. Se evalúa que el método getTexto devuelva los textos esperados para instancias de Palabras y Frecuencias.
     * Operativa: Se crea una instancia de Palabras y una de Frecuencias con datos específicos.
     * Para Palabras se llama al método getTexto y se verifica que el resultado sea igual a "hola".
     * Para Frecuencias se llama al método getTexto y se verifica que el resultado sea igual a "hola 1\n".
     */
    @Test
    public void TestGetTexto() {
        //System.out.println("Test Get Texto");

        //Palabras
        String getTextoPalabras = textoPalabras.getTexto();
        assertEquals(getTextoPalabras, "hola");

        //Frecuencias
        String getTextoFrecuencias = textoFrecuencias.getTexto();
        assertEquals(getTextoFrecuencias, "hola 1\n");
    }

    /**
     * Objeto de la prueba: Test del método agregarAsociacionesVinculadas(String nomAT) de la clase Texto. Este método debe agregar a un texto una asociación.
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. A partir del Texto, ya sea Palabra o Frecuencia, se añade una asociación como vinculada a este. Se comprueba que se ha agregado correctamente.
     * Operativa: Se define el nombre de dos asociaciones de textos.
     * Primero, se añade el primer nombre a textoPalabras y se comprueba que se ha agregado correctamente, asegurando que el número de elementos que tiene el ArrayList de asociacionesVinculadas es 1 y que este solo contiene el nomATvinculada1.
     * Después se realiza lo mismo con textoFrecuencias.
     */
    @Test
    public void TestAgregarAsociacionesVinculadas() {
        //System.out.println("Test Agregar Asociaciones Vinculadas");

        String nombreATvinculada1 = "nomAT1";
        String nombreATvinculada2 = "nomAT2";

        //Palabras
        textoPalabras.agregarAsociacionesVinculadas(nombreATvinculada1);

        assertFalse(textoPalabras.getAsociacionesVinculadas().isEmpty());
        assertEquals(1, textoPalabras.getAsociacionesVinculadas().size());
        assertTrue(textoPalabras.getAsociacionesVinculadas().contains(nombreATvinculada1));
        assertFalse(textoPalabras.getAsociacionesVinculadas().contains(nombreATvinculada2));

        //Frecuencias
        textoFrecuencias.agregarAsociacionesVinculadas(nombreATvinculada1);

        assertFalse(textoFrecuencias.getAsociacionesVinculadas().isEmpty());
        assertEquals(1, textoFrecuencias.getAsociacionesVinculadas().size());
        assertTrue(textoFrecuencias.getAsociacionesVinculadas().contains(nombreATvinculada1));
        assertFalse(textoFrecuencias.getAsociacionesVinculadas().contains(nombreATvinculada2));
    }

    /**
     * Objeto de la prueba: Test del método borrarAsociacionesVinculadas(String nomAT) de la clase Texto. Este método debe borrar de un texto una asociación.
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. A partir del Texto, ya sea Palabra o Frecuencia, que contiene alguna asociación, se borra una de ellas. Se comprueba que se ha borrado correctamente.
     * Operativa: Se define el nombre de dos asociaciones de textos.
     * Primero, se añaden las dos asociaciones a textoPalabras y se borra una de ellas (ATvinculada1). Se comprueba que se ha borrado correctamente nombreATvinculado1, asegurando que el número de elementos que tiene el ArrayList de asociacionesVinculadas es 1 y que este solo contiene el nomATvinculada2.
     * Después se realiza lo mismo con textoFrecuencias.
     */
    @Test
    public void TestBorrarAsociacionesVinculadas() {
        //System.out.println("Test Borrar Asociaciones Vinculadas");

        String nombreATvinculada1 = "nomAT1";
        String nombreATvinculada2 = "nomAT2";

        //Palabras
        textoPalabras.agregarAsociacionesVinculadas(nombreATvinculada1);
        textoPalabras.agregarAsociacionesVinculadas(nombreATvinculada2);

        textoPalabras.borrarAsociacionesVinculadas(nombreATvinculada1);

        assertEquals(1, textoPalabras.getAsociacionesVinculadas().size());
        assertFalse(textoPalabras.getAsociacionesVinculadas().contains(nombreATvinculada1));
        assertTrue(textoPalabras.getAsociacionesVinculadas().contains(nombreATvinculada2));

        //Frecuencias
        textoFrecuencias.agregarAsociacionesVinculadas(nombreATvinculada1);
        textoFrecuencias.agregarAsociacionesVinculadas(nombreATvinculada2);

        textoFrecuencias.borrarAsociacionesVinculadas(nombreATvinculada1);

        assertEquals(1, textoFrecuencias.getAsociacionesVinculadas().size());
        assertFalse(textoFrecuencias.getAsociacionesVinculadas().contains(nombreATvinculada1));
        assertTrue(textoFrecuencias.getAsociacionesVinculadas().contains(nombreATvinculada2));
      }
}