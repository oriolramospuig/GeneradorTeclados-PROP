package test;

import main.domain.classes.Alfabeto;

import java.util.ArrayList;

import main.domain.classes.Frecuencias;
import main.domain.classes.Palabras;
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
 * Clase de pruebas unitarias para Alfabeto. Evalúa el correcto funcionamiento de la creación y manipulación de objetos Alfabeto.
 * @author Alèxia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class TestAlfabeto {

    /** Instancia de la clase Alfabeto utilizada en los casos de prueba. Se inicializa y utiliza en el método de configuración (setUp) para disponer de un objeto de prueba en los distintos casos de prueba de la clase TestAlfabeto. */
    private Alfabeto alfabeto;

    /**
     * Inicialización de un alfabeto.
     */
    @Before
    public void setUp() {
        alfabeto = new Alfabeto();
    }

    // --------- CONSTRUCTORAS ----------
    /**
     * Objeto de la prueba: Test de la constructora de Alfabeto (Constructora Default).
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se inicializan los atributos del alfabeto y se crea un objeto alfabeto con estos atributos.
     * Operativa: El primer assertEquals() comprueba que el nombre de aquel alfabeto este vacío.
     * El segundo assertTrue() compruba que el contenido del alfabeto(getLetras) este vacío.
     * El tercer assertTrue() comprueba que la lista de teclados vinculados a ese alfabeto este vacía.
     * Seguidamente se añaden los datos que requiere la constructora. Estos son: el nombre y el contenido.
     * El cuarto assertEquals() comprueba que el nombre del alfabeto se ha añadido correctamente, por tanto, coincide con la variable.
     * El quinto assertEquals() comprueba que el contenido del alfabeto se ha añadido correctamente, por tanto, coincide con la variable.
     * El sexto assertTrue() comprueba que no se ha añadido ningún teclado vinculado, por tanto, está vacío.
     */
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora Default");
        assertEquals("", alfabeto.getNombre());
        assertTrue(alfabeto.getLetras().isEmpty());
        assertTrue(alfabeto.getTecladosVinculados().isEmpty());

        String nombre = "Vocales";
        ArrayList<Character> letras = new ArrayList<>();
        // Agregar caracteres al ArrayList
        letras.add('A');
        letras.add('E');
        letras.add('I');
        letras.add('O');
        letras.add('U');

        System.out.println("Test Constructora con Nombre y Letras");
        Alfabeto a = new Alfabeto(nombre, letras);
        assertEquals(nombre, a.getNombre());
        assertEquals(letras, a.getLetras());
        assertTrue(a.getTecladosVinculados().isEmpty());
    }


    // ---------- GETTERS ----------

    /**
     * Objeto de la prueba: Test del método getAlfabeto de la clase Alfabeto.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba. Se crean instancias de Alfabeto en el método de configuración.
     * Valores estudiados: Estrategia caja gris. Se evalúa que el método getAlfabeto devuelva los alfabetos esperados.
     * Operativa: Se crea una instancia de Alfabeto con datos específicos.
     */
    @Test
    public void TestGetAlfabeto() {
        //System.out.println("Test Get Texto");

        //String getAlfabeto = alfabeto;
        //assertEquals(getTextoPalabras, "hola");
    }

    // ---------- SETTERS ----------

    /**
     * Objeto de la prueba: Test del método agregarTecladoVinculado(String nomT) de alfabeto. Este método debe agregar a un teclado a la lista de un alfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. A partir del Alfabeto, se añade un teclado vinculado al alfabeto. Se comprueba que se ha agregado correctamente.
     * Operativa: Se define el nombre de dos teclados.
     * El segundo assertTrue() compruba que el teclado1 está en la lista.
     * El tercer assertTrue() comprueba que el teclado2 está en la lista.
     */

    @Test
    public void TestAgregarTecladoVinculado() {
        System.out.println("Test agregarTecladoVinculado");
        String nombreT1 = "Teclado1";
        String nombreT2 = "Teclado2";

        alfabeto.agregarTecladoVinculado(nombreT1);
        alfabeto.agregarTecladoVinculado(nombreT2);

        assertEquals(2, alfabeto.getTecladosVinculados().size());
        assertTrue(alfabeto.getTecladosVinculados().contains(nombreT1));
        assertTrue(alfabeto.getTecladosVinculados().contains(nombreT2));
    }


    // ---------- AUXILIARES ----------
    /**
     * Objeto de la prueba: Test del método borrarTecladoVinculado(String nomT) de alfabeto. Este método debe borrar de un teclado de la lista del alfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. A partir del Alfabeto que contiene algun teclado, se borra uno de ellos. Se comprueba que se ha borrado correctamente.
     * Operativa: Se define el nombre de dos teclados.
     * Primero, se añaden los dos teclados a alfabeto y se borra uno de ellos. Se comprueba que se ha borrado correctamente, asegurando que el número de elementos que tiene el ArrayList de tecladosVinculados es 1 y que este solo contiene el que no se ha borrado.
     */
    @Test
    public void TestBorrarTecladoVinculado() {
        System.out.println("Test borrarTecladoVinculado");

        String nombreT1 = "Teclado1";
        String nombreT2 = "Teclado2";

        alfabeto.agregarTecladoVinculado(nombreT1);
        alfabeto.agregarTecladoVinculado(nombreT2);
        alfabeto.borrarTecladoVinculado(nombreT1);

        assertEquals(1, alfabeto.getTecladosVinculados().size());
        assertFalse(alfabeto.getTecladosVinculados().contains(nombreT1));
        assertTrue(alfabeto.getTecladosVinculados().contains(nombreT2));
    }
}

