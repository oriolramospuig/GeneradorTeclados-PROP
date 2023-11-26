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

/**
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestAlfabeto {
    private Alfabeto alfabeto;

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

    // ---------- SETTERS ----------
    /**
     * Objeto de la prueba: Test del método agregarTecladoVinculado de alfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se añaden dos teclados a la lista de teclados vinculados de ese alfabeto.
     * Primero se guarda el nombre de los dos teclados en variables para poder llamar a dicha función y agragarlos.
     * Se llama a la función y ahora hay que comprobar que se han añadido correctamente.
     * Operativa: El primer assertEquals() comprueba que la medida de la lista de teclados vinculados sea 2.
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
     * Objeto de la prueba: Test del método borrarTecladoVinculado de alfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se borra un teclado de la lista de teclados vinculados de ese alfabeto.
     * Primero hay que añadir dos teclados de igual manera que hemos hecho en la función agregarTecladoVinculado.
     * Seguidamente se llama a la función borrarTecladoVinculado con uno de los nombres de los teclados agregados anteriormente.
     * Operativa: El primer assertEquals() comprueba que la medida de la lista de teclados vinculados sea 1.(2 inicialmente menos el que hemos borrado).
     * El segundo assertFalse() compruba que el teclado1 no está en la lista.
     * El tercer assertTrue() comprueba que el teclado2 está en la lista.
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

