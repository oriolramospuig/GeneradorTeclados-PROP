/*package test;

import main.domain.classes.AsociacionTextos;
import main.domain.classes.ConjuntoAsociaciones;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestConjuntoAsociaciones
{
    private ConjuntoAsociaciones asociaciones;

    private AsociacionTextos asociacionTextos1;

    private AsociacionTextos asociacionTextos2;

    @Before
    public void setUp() {
        asociaciones = new ConjuntoAsociaciones();
        asociacionTextos1 = new AsociacionTextos("nombreAT1");
        asociacionTextos2 = new AsociacionTextos("nombreAT2");
    }


    // ---------- CONSTRUCTORAS ----------
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");

        assertTrue(asociaciones.getAsociacionesTextos().isEmpty());
    }


    // ---------- GETTERS ----------
    @Test
    public void TestGetAsociacionTextos() {
        System.out.println("Test getAsociacionTextos");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);
        AsociacionTextos resultado = asociaciones.getAsociacionTextos("nombreAT1");
        assertNotNull(resultado);
        assertEquals("nombreAT1", resultado.getNombre());
    }

    @Test
    public void TestGetNombresAsociacionesTextos() {
        System.out.println("Test getNombresAsociacionesTextos");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);
        asociaciones.agregarAsociacionTexto("nombreAT2", asociacionTextos2);

        ArrayList<String> nombres = asociaciones.getNombresAsociacionesTextos();

        assertEquals(2, nombres.size());
        assertTrue(nombres.contains("nombreAT1"));
        assertTrue(nombres.contains("nombreAT2"));
    }


    // ---------- SETTERS ----------
    @Test
    public void TestAgregarAsociacionTexto(){
        System.out.println("Test agregarAsociacionTexto");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);
        asociaciones.agregarAsociacionTexto("nombreAT2", asociacionTextos2);

        assertEquals(2, asociaciones.getAsociacionesTextos().size());
        assertTrue(asociaciones.getAsociacionesTextos().containsKey("nombreAT1"));
        assertTrue(asociaciones.getAsociacionesTextos().containsKey("nombreAT2"));
    }


    // ---------- AUXILIARES ----------
    @Test
    public void TestExisteAsociaciondeTextos() {
        System.out.println("Test existeAsociaciondeTextos");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);

        assertTrue(asociaciones.existeAsociaciondeTextos("nombreAT1"));
        assertFalse(asociaciones.existeAsociaciondeTextos("nombreAT2"));
    }

    @Test
    public void TestBorrarAsociacionTextos() {
        System.out.println("Test borrarAsociacionTextos");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);
        asociaciones.agregarAsociacionTexto("nombreAT2", asociacionTextos2);

        asociaciones.borrarAsociacionTextos("nombreAT1");

        assertEquals(1, asociaciones.getAsociacionesTextos().size());
        assertFalse(asociaciones.existeAsociaciondeTextos("nombreAT1"));
        assertTrue(asociaciones.existeAsociaciondeTextos("nombreAT2"));
    }
}*/