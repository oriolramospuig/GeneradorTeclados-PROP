package test;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Classe de testeo de Alfabeto.java
 * @author X (X@estudiantat.upc.edu)
 */
public class TestConjuntoAlfabetos {
    private ConjuntoAlfabetos alfabetos;

    private Alfabeto alfabeto1;

    private Alfabeto alfabeto2;

    @Before
    public void setUp() {
        alfabetos = new ConjuntoAlfabetos();
        alfabeto1 = new Alfabeto("nombreA1");
        alfabeto2 = new Alfabeto("nombreA2");
    }


    // ---------- CONSTRUCTORAS ----------
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");
        assertTrue(alfabetos.getAlfabetos().isEmpty());
    }


    // ---------- GETTERS ----------
    @Test
    public void TestGetAlfabeto() {
        System.out.println("Test getAlfabeto");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);
        Alfabeto resultado = alfabetos.getAlfabeto("nombreA1");
        assertNotNull(resultado);
        assertEquals("nombreA1", resultado.getNombre());
    }

    @Test
    public void TestGetNombresAlfabetos() {
        System.out.println("Test getNombreAlfabetos");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);
        alfabetos.agregarAlfabeto("nombreA2", alfabeto2);

        ArrayList<String> nombres = alfabetos.getNombresAlfabetos();

        assertEquals(2, nombres.size());
        assertTrue(nombres.contains("nombreA1"));
        assertTrue(nombres.contains("nombreA2"));
    }


    // ---------- SETTERS ----------
    @Test
    public void TestAgregarAlfabeto(){
        System.out.println("Test agregarAlfabeto");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);
        alfabetos.agregarAlfabeto("nombreA2", alfabeto2);

        assertEquals(2, alfabetos.getAlfabetos().size());
        assertTrue(alfabetos.getAlfabetos().containsKey("nombreA1"));
        assertTrue(alfabetos.getAlfabetos().containsKey("nombreA2"));
    }


    // ---------- AUXILIARES ----------
    @Test
    public void TestExisteAlfabeto() {
        System.out.println("Test existeAlfabeto");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);

        assertTrue(alfabetos.existeAlfabeto("nombreA1"));
        assertFalse(alfabetos.existeAlfabeto("nombreA2"));
    }

    @Test
    public void TestBorrarAlfabeto() {
        System.out.println("Test borrarAlfabeto");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);
        alfabetos.agregarAlfabeto("nombreA2", alfabeto2);

        alfabetos.borrarAlfabeto("nombreA1");

        assertEquals(1, alfabetos.getAlfabetos().size());
        assertFalse(alfabetos.existeAlfabeto("nombreA1"));
        assertTrue(alfabetos.existeAlfabeto("nombreA2"));
    }
}
