package test;

import main.domain.classes.Alfabeto;

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

public class TestAlfabeto {
    private Alfabeto alfabeto;

    @Before
    public void setUp() {
        alfabeto = new Alfabeto();
    }


    // ---------- CONSTRUCTORAS ----------
    /**
     * Objeto de la prueba: Test de la constructora de Alfabeto
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia caja gris. Se crea un nuevo objeto Alfabeto y se comprueba que el nombre y las letras sean los mismos.
     * Operativa: Creamos un nuevo Alfabeto con los parámetros "Vocales" y una lista de las vocales y comprobamos que los valores
     * obtenidos de nombre y letras con los getters sean los mismos que los introducidos.
     **/
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

        System.out.println("Test Constructora con Nombre");
        Alfabeto aNombre = new Alfabeto(nombre);
        assertEquals(nombre, aNombre.getNombre());
        assertTrue(aNombre.getLetras().isEmpty());
        assertTrue(aNombre.getTecladosVinculados().isEmpty());

        System.out.println("Test Constructora con Nombre y Letras");
        Alfabeto a = new Alfabeto(nombre, letras);
        assertEquals(nombre, a.getNombre());
        assertEquals(letras, a.getLetras());
        assertTrue(a.getTecladosVinculados().isEmpty());
    }


    // ---------- GETTERS ----------

    // ---------- SETTERS ----------
    /**
     * Objeto de la prueba: Test del método agregarTecladoVinculado(String nomT) de la clase Alfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crea un alfabeto y un nombre de un teclado y se comprueba que se puede añadir correctamente un nombre de un teclado a tecladosVinculados.
     * Operativa: Se comprueba que el método agregarTecladoVinculado añade correctamente en su lista un nuevo String, que corresponde al nombre de un teclado.
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
     * Objeto de la prueba: Test del método borrarTecladoVinculado(String nomT) de la clase Alfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crea un alfabeto y un nombre de un teclado, se añade a la lista tecladosVinculades y se comprueba que se puede borrar un nombre de un teclado correctamente.
     * Operativa: Se comprueba que el método borrarTecladoVinculado borra correctamente de su lista un String, que corresponde al nombre de un teclado.
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