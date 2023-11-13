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
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia caja gris. Se crea un nuevo objeto Alfabeto y se comprueba que el nombre y las letras sean los mismos.
     * Operativa: Creamos un nuevo Alfabeto con los parámetros "Vocales" y una lista de las vocales y comprobamos que los valores
     * obtenidos de nombre y letras con los getters sean los mismos que los introducidos.
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
     * Objeto de la prueba: Test del método agregarTecladoVinculado(String nomT) de la clase Alfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crea un alfabeto y un nombre de un teclado y se comprueba que se puede añadir correctamente un nombre de un teclado a tecladosVinculados.
     * Operativa: Se comprueba que el método agregarTecladoVinculado añade correctamente en su lista un nuevo String, que corresponde al nombre de un teclado.
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
        String nombreTeclado = "teclado1";
        a.agregarTecladoVinculado(nombreTeclado);

        assertTrue(a.getTecladosVinculados().contains(nombreTeclado));
    }


    // ---------- AUXILIARES ----------
    /**
     * Objecte de la prova: Test del mètode EliminarFull(id) de la classe Document
     * Fitxers de dades necessaris: Dades introduïdes manualment. Necessitem la classe Full.
     * Valors estudiats: Estratègia caixa gris. Mètode saber Eliminar el Full amb clau primaria id.
     * Operativa: En aquest test es comprova si el mètode EliminarFull(id) elimina del Document el Full amb clau id.
     * Primer es crea un objecte Document, es crida al mètode crearFull() i al EliminarFull(id) i es comprova que ExisteixFull(id) retorni false.
     */
    /**
     * Objeto de la prueba: Test del método borrarTecladoVinculado(String nomT) de la clase Alfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crea un alfabeto y un nombre de un teclado, se añade a la lista tecladosVinculades y se comprueba que se puede borrar un nombre de un teclado correctamente.
     * Operativa: Se comprueba que el método borrarTecladoVinculado borra correctamente de su lista un String, que corresponde al nombre de un teclado.
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

//IMPORTANTE: escoger que opcion es mejor: crear teclado y luego .getnombre() o crear String nombre sin crear teclado --> unificar formato escogido en agregar y borrar
//Se podria detallar más el apartado de Operativa