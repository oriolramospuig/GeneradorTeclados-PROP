package test;

import main.domain.classes.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Clase de pruebas unitarias para ConjuntoTextos. Evalúa el correcto funcionamiento de la creación y manipulación de objetos ConjuntoTextos.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestConjuntoTextos {
    /** Instancia de la clase ConjuntoTextos utilizada en los casos de prueba. */
    private ConjuntoTextos textos;

    /** Instancias de la clase Textos (Palabras y Frecuencias) para datos de prueba. */
    private Palabras textoPalabras;
    private Frecuencias textoFrecuencias;

    /** Constantes para datos de prueba. */
    private static final String nombrePalabras = "textoPalabras";
    private static final String nombreFrecuencias = "textoFrecuencias";

    /**
     * Inicialización de las instancias Palabras y Frecuencias para realizar los juegos de prueba.
     */
    @Before
    public void setUp() {
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("ho", 1);
        frecuenciaLetras.put("ol", 1);
        frecuenciaLetras.put("la", 1);

        //Palabras
        String contenidoPalabras = "hola";
        textoPalabras = new Palabras(nombrePalabras, contenidoPalabras, frecuenciaLetras);

        //Frecuencias
        HashMap<String, Integer> frecuenciaPalabras = new HashMap<>();
        frecuenciaPalabras.put("hola", 1);
        textoFrecuencias = new Frecuencias(nombreFrecuencias, frecuenciaPalabras, frecuenciaLetras);
    }

    /**
     * Objeto de la prueba: Test de la constructora de ConjuntoTextos.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja gris. Se define un conjunto de textos y se comprueba que se crea correctamente.
     * Operativa: Creamos un nuevo ConjuntoTextos. Se comprueba que se ha creado vacío.
     */
    @Test
    public void TestConstructora() {
        //System.out.println("Test Constructora");
        textos = new ConjuntoTextos();

        assertTrue(textos.getNombresTextos().isEmpty());
    }

    /**
     * Objeto de la prueba: Test del método getTexto de la clase ConjuntoTextos.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja negra. Se añaden textos al conjunto y se verifica que el método getTexto devuelve los textos correctos.
     * Operativa: Se agregan instancias de Palabras y Frecuencias al conjunto. Se llama a getTexto para ambos textos y se verifica la igualdad.
     */
    @Test
    public void TestGetTexto() {
        //System.out.println("Test getTexto");
        textos = new ConjuntoTextos();
        textos.agregarTexto(nombrePalabras, textoPalabras);
        textos.agregarTexto(nombreFrecuencias, textoFrecuencias);

        Texto texto1 = textos.getTexto(nombrePalabras);
        Texto texto2 = textos.getTexto(nombreFrecuencias);

        assertNotNull(texto1);
        assertEquals(textoPalabras, texto1);
        assertNotNull(texto2);
        assertEquals(textoFrecuencias, texto2);
    }


    /**
     * Objeto de la prueba: Test del método getNombresTextos de la clase ConjuntoTextos.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja negra. Se añaden textos al conjunto y se verifica que el método getNombresTextos devuelve los nombres correctos.
     * Operativa: Se agregan instancias de Palabras y Frecuencias al conjunto. Se llama a getNombresTextos y se verifica la igualdad.
     */
    @Test
    public void TestGetNombresTextos() {
        //System.out.println("Test getNombresTextos");
        textos = new ConjuntoTextos();

        textos.agregarTexto(nombrePalabras, textoPalabras);
        textos.agregarTexto(nombreFrecuencias, textoFrecuencias);

        ArrayList<String> nombres = textos.getNombresTextos();

        assertEquals(2, nombres.size());
        assertTrue(nombres.contains(nombrePalabras));
        assertTrue(nombres.contains(nombreFrecuencias));
    }

    /**
     * Objeto de la prueba: Test del método agregarTexto de la clase ConjuntoTextos.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja negra. Se añaden textos al conjunto y se verifica que se agregan correctamente.
     * Operativa: Se añaden instancias de Palabras y Frecuencias al conjunto. Se verifica que los nombres estén presentes y los textos sean iguales.
     * También se comprueba que si se intenta añadir un texto que ya existe, no se añade otra vez en el conjunto.
     */
    @Test
    public void TestAgregarTexto(){
        //System.out.println("Test agregarTexto");
        textos = new ConjuntoTextos();
        assertTrue(textos.getNombresTextos().isEmpty());

        textos.agregarTexto(nombrePalabras, textoPalabras);

        assertTrue(textos.getNombresTextos().contains(nombrePalabras));
        assertEquals(textoPalabras, textos.getTexto(nombrePalabras));

        textos.agregarTexto(nombreFrecuencias, textoFrecuencias);

        assertTrue(textos.getNombresTextos().contains(nombreFrecuencias));
        assertEquals(textoFrecuencias, textos.getTexto(nombreFrecuencias));

        assertEquals(2, textos.getNombresTextos().size());

        textos.agregarTexto(nombreFrecuencias, textoFrecuencias);
        assertEquals(2, textos.getNombresTextos().size());

    }

    /**
     * Objeto de la prueba: Test del método borrarTexto de la clase ConjuntoTextos.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja negra. Se añaden textos al conjunto, se borra un texto y se verifica que se haya eliminado correctamente.
     * Operativa: Se añaden instancias de Palabras y Frecuencias al conjunto. Se verifica que los nombres estén presentes y los textos sean iguales.
     * Luego, se borra un texto y se verifica que el texto se haya eliminado correctamente y los demás textos sigan presentes.
     * También se comprueba que si se intenta borrar un texto que ya no existe el conjunto se queda igual.
     */
    @Test
    public void TestBorrarTexto() {
        //System.out.println("Test borrarTexto");
        textos = new ConjuntoTextos();

        textos.agregarTexto(nombrePalabras, textoPalabras);
        textos.agregarTexto(nombreFrecuencias, textoFrecuencias);

        assertTrue(textos.existeTexto(nombrePalabras));
        assertTrue(textos.existeTexto(nombreFrecuencias));

        textos.borrarTexto(nombrePalabras);

        assertFalse(textos.existeTexto(nombrePalabras));
        assertNull(textos.getTexto(nombrePalabras));
        assertTrue(textos.existeTexto(nombreFrecuencias));
        assertEquals(textoFrecuencias, textos.getTexto(nombreFrecuencias));

        textos.borrarTexto(nombrePalabras);

        assertFalse(textos.existeTexto(nombrePalabras));
        assertNull(textos.getTexto(nombrePalabras));
        assertTrue(textos.existeTexto(nombreFrecuencias));
        assertEquals(textoFrecuencias, textos.getTexto(nombreFrecuencias));
    }
}