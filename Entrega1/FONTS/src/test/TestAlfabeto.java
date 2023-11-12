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

public class TestAlfabeto
{
    // ---------- CONSTRUCTORAS ----------
    /**
     * Objeto de la prueba: Test de la constructora de Alfabeto
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Estrategia caja gris. Se crea un nuevo objeto Alfabeto y se comprueba que el nombre y las letras sean los mismos.
     * Operativa: Creamos un nuevo Alfabeto con los parámetros "test" y comprobamos que el nombre y las letras sea el mismo.
     **/
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructoras");

        String nombre = "Vocales";
        ArrayList<Character> letras = new ArrayList<>();
        // Agregar caracteres al ArrayList
        letras.add('A');
        letras.add('E');
        letras.add('I');
        letras.add('O');
        letras.add('U');
        Alfabeto a = new Alfabeto(nombre, letras);

        assertEquals("Vocales", a.getNombre());
        //seria lo mismo: assertEquals(nombre, a.getNombre()); ????
        assertEquals(letras, a.getLetras());
        assertNull(a.getTecladosVinculados());
    }


    // ---------- GETTERS ----------


    // ---------- SETTERS ----------
    /**
     * Objecte de la prova: Test del método agregarTecladoVinculado(String nomT) de la clase Alfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia de caja gris. Método para ....
     * Operativa: Este test comprueba si se añade correctamente un Teclado a la lista tecladosVinculados. Primero,.... (explicar que hacemos en la función)
     */
    @Test
    public void TestAgregarTecladoVinculado() {
        System.out.println("Test agregarTecladoVinculado");

        String nombre = "Vocales";
        ArrayList<Character> letras = new ArrayList<>();
        // Agregar caracteres al ArrayList
        letras.add('A');
        letras.add('E');
        letras.add('I');
        letras.add('O');
        letras.add('U');
        Alfabeto a = new Alfabeto(nombre, letras);
        Teclado t = new Teclado("teclado1");
        a.agregarTecladoVinculado(t.getNombre());

        assertTrue(a.getTecladosVinculados().contains("teclado1"));
    }


    // ---------- AUXILIARES ----------
    /**
     * Objecte de la prova: Test del mètode EliminarFull(id) de la classe Document
     * Fitxers de dades necessaris: Dades introduïdes manualment. Necessitem la classe Full.
     * Valors estudiats: Estratègia caixa gris. Mètode saber Eliminar el Full amb clau primaria id.
     * Operativa: En aquest test es comprova si el mètode EliminarFull(id) elimina del Document el Full amb clau id.
     * Primer es crea un objecte Document, es crida al mètode crearFull() i al EliminarFull(id) i es comprova que ExisteixFull(id) retorni false.
     */
    @Test
    public void TestBorrarTecladoVinculado() {
        System.out.println("Test borrarTecladoVinculado");

        String nombre = "Vocales";
        ArrayList<Character> letras = new ArrayList<>();
        // Agregar caracteres al ArrayList
        letras.add('A');
        letras.add('E');
        letras.add('I');
        letras.add('O');
        letras.add('U');
        Alfabeto a = new Alfabeto(nombre, letras);
        Teclado t = new Teclado("teclado1");

        a.agregarTecladoVinculado(t.getNombre());   //no se si aqui habria que hacer esto de otra manera, porque si esta funcion ya no va bien podemos confundirnos y pensarnos que la que esta mal es borrar y no agregar
        a.borrarTecladoVinculado(t.getNombre());

        assertFalse(a.getTecladosVinculados().contains("teclado1"));
    }
}
