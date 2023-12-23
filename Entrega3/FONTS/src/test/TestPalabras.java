package test;

import main.domain.classes.Frecuencias;
import main.domain.classes.Palabras;

import org.junit.*;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

/**
 * Clase de pruebas unitarias para Palabras. Evalúa el correcto funcionamiento de la creación y manipulación de objetos Texto de tipo Palabras.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestPalabras {
    /** Instancia de la clase Palabras utilizada en los casos de prueba. */
    private Palabras palabras;

    /** Constantes para datos de prueba. */
    private static final String nombreP = "textoPalabras";
    private static final String texto1 = "aiacaia";
    private static final String texto2 = "hola";

    /** HashMaps para frecuencias de palabras y frecuencias usadas en la prueba. */
    private static final HashMap<String, Integer> frecuenciaLetras1 = new HashMap<>();
    private static final HashMap<String, Integer> frecuenciaLetras2 = new HashMap<>();

    /**
     * Inicialización de HashMaps para datos de la prueba.
     */
    @Before
    public void setUp() {
        frecuenciaLetras1.put("ai", 4);
        frecuenciaLetras1.put("ac", 2);

        frecuenciaLetras2.put("ho", 1);
        frecuenciaLetras2.put("ol", 1);
        frecuenciaLetras2.put("la", 1);
    }

    /**
     * Objeto de la prueba: Test de la constructora de Palabras.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja gris. Se define un texto de tipo Palabras y se comprueba que se crea correctamente.
     * Operativa: Creamos un nuevo Texto de tipo Palabras con los parámetros nombreP, texto1 y frecuenciaLetras1 que se han definido previamente. Se comprueba que los valores se introducen adecuadamente.
     */
    @Test
    public void TestConstructora () {
        //System.out.println("Test Constructora");
        palabras = new Palabras(nombreP, texto1, frecuenciaLetras1);

        assertEquals(nombreP, palabras.getNombre());
        assertEquals(texto1, palabras.getTexto());
        assertEquals(2, palabras.getFrecuenciaLetras().size());
        assertTrue(palabras.getFrecuenciaLetras().containsKey("ai"));
        assertTrue(palabras.getFrecuenciaLetras().containsKey("ac"));
        assertTrue(palabras.getAsociacionesVinculadas().isEmpty());
    }

    /**
     * Objeto de la prueba: Test del método modificarFrecuencias de la clase Palabras.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja gris. Se evalúa que el método modificarPalabras. A partir de una instancia de palabras ya creada, se cambia correctamente el contenido de esta.
     * Operativa: Se crea una instancia de Palabras con datos específicos (texto1, frecuenciaLetras1). A partir de esto se llama a la función modificarPalabras, pasando nuevos parámetros (texto2, frecuenciaLetras2) y se comprueba que posteriormente el contenido ha cambiado.
     */
    @Test
    public void TestModificarPalabras() {
        //System.out.println("Test modificarPalabras");
        palabras = new Palabras(nombreP, texto1, frecuenciaLetras1);

        palabras.modificarPalabras(texto2, frecuenciaLetras2);

        assertEquals(nombreP, palabras.getNombre());
        assertEquals(texto2, palabras.getTexto());
        assertEquals(3, palabras.getFrecuenciaLetras().size());
        assertTrue(palabras.getFrecuenciaLetras().containsKey("ho"));
        assertFalse(palabras.getFrecuenciaLetras().containsKey("ac"));
        assertTrue(palabras.getAsociacionesVinculadas().isEmpty());
    }
}