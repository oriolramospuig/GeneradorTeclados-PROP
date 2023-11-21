/*package test;


import main.domain.classes.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class TestConjuntoTeclados {
    private ConjuntoTeclados teclados;

    private Teclado teclado1;

    private Teclado teclado2;

    @Before
    public void setUp() {
        teclados = new ConjuntoTeclados();
        teclado1 = new Teclado("nombreT1");
        teclado2 = new Teclado("nombreT2");
    }


    // ---------- CONSTRUCTORAS ----------
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");

        assertTrue(teclados.getTeclados().isEmpty());
    }


    // ---------- GETTERS ----------
    @Test
    public void TestGetTeclado() {
        System.out.println("Test getTeclado");

        teclados.agregarTeclado("nombreT1", teclado1);
        Teclado resultado = teclados.getTeclado("nombreT1");
        assertNotNull(resultado);
        assertEquals("nombreT1", resultado.getNombre());
    }

    @Test
    public void TestGetNombresTeclados() {
        System.out.println("Test getNombresTeclados");

        teclados.agregarTeclado("nombreT1", teclado1);
        teclados.agregarTeclado("nombreT2", teclado2);

        ArrayList<String> nombres = teclados.getNombresTeclados();

        assertEquals(2, nombres.size());
        assertTrue(nombres.contains("nombreT1"));
        assertTrue(nombres.contains("nombreT2"));
    }


    // ---------- SETTERS ----------
    @Test
    public void TestAgregarTeclado(){
        System.out.println("Test agregarTeclado");

        teclados.agregarTeclado("nombreT1", teclado1);
        teclados.agregarTeclado("nombreT2", teclado2);

        assertEquals(2, teclados.getTeclados().size());
        assertTrue(teclados.getTeclados().containsKey("nombreT1"));
        assertTrue(teclados.getTeclados().containsKey("nombreT2"));
    }


    // ---------- AUXILIARES ----------
    @Test
    public void TestExisteTeclado() {
        System.out.println("Test existeTeclado");

        teclados.agregarTeclado("nombreT1", teclado1);

        assertTrue(teclados.existeTeclado("nombreT1"));
        assertFalse(teclados.existeTeclado("nombreT2"));
    }

    @Test
    public void TestBorrarTeclado() {
        System.out.println("Test borrarTeclado");

        teclados.agregarTeclado("nombreT1", teclado1);
        teclados.agregarTeclado("nombreT2", teclado2);

        teclados.borrarTeclado("nombreT1");

        assertEquals(1, teclados.getTeclados().size());
        assertFalse(teclados.existeTeclado("nombreT1"));
        assertTrue(teclados.existeTeclado("nombreT2"));
    }
}*/