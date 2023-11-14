package test;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TestConjuntoAlfabetos {
    private ConjuntoAlfabetos alfabetos;

    private Alfabeto alfabeto1;

    private Alfabeto alfabeto2;

    @Before
    public void setUp() {
        alfabetos = new ConjuntoAlfabetos();
        alfabeto1 = new Alfabeto("ABC");
        alfabeto2 = new Alfabeto("XYZ");
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

        alfabetos.agregarAlfabeto("Alfabeto1", alfabeto1);
        Alfabeto resultado = alfabetos.getAlfabeto("Alfabeto1");
        assertNotNull(resultado);
        assertEquals("ABC", resultado.getNombre());
    }

    @Test
    public void TestGetNombresAlfabetos() {
        System.out.println("Test getNombreAlfabetos");

        alfabetos.agregarAlfabeto("Alfabeto1", alfabeto1);
        alfabetos.agregarAlfabeto("Alfabeto2", alfabeto2);

        ArrayList<String> nombres = alfabetos.getNombresAlfabetos();

        assertEquals(2, nombres.size());
        assertTrue(nombres.contains("Alfabeto1"));
        assertTrue(nombres.contains("Alfabeto2"));
    }


    // ---------- SETTERS ----------
    @Test
    public void TestAgregarAlfabeto(){
        System.out.println("Test agregarAlfabeto");

        alfabetos.agregarAlfabeto("Alfabeto1", alfabeto1);
        alfabetos.agregarAlfabeto("Alfabeto2", alfabeto2);

        assertEquals(2, alfabetos.getAlfabetos().size());
        assertTrue(alfabetos.getAlfabetos().containsKey("Alfabeto1"));
        assertTrue(alfabetos.getAlfabetos().containsKey("Alfabeto2"));
    }


    // ---------- AUXILIARES ----------
    @Test
    public void TestExisteAlfabeto() {
        System.out.println("Test existeAlfabeto");

        alfabetos.agregarAlfabeto("Alfabeto1", alfabeto1);

        assertTrue(alfabetos.existeAlfabeto("Alfabeto1"));
        assertFalse(alfabetos.existeAlfabeto("Alfabeto2"));
    }

    @Test
    public void TestBorrarAlfabeto() {
        System.out.println("Test borrarAlfabeto");

        alfabetos.agregarAlfabeto("Alfabeto1", alfabeto1);
        alfabetos.agregarAlfabeto("Alfabeto2", alfabeto2);

        alfabetos.borrarAlfabeto("Alfabeto1");

        assertEquals(1, alfabetos.getAlfabetos().size());
        assertFalse(alfabetos.existeAlfabeto("Alfabeto1"));
        assertTrue(alfabetos.existeAlfabeto("Alfabeto2"));
    }
}
