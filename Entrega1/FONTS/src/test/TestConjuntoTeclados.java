package test;


import main.domain.classes.*;
import main.domain.classes.types.PairInt;
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
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto("Alfabeto");
        Algoritmo algoritmo = Algoritmo.QAP;
        PairInt dimensiones = new PairInt(5, 10);
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, algoritmo, dimensiones);
        String nombre1 = "nombre";
        AsociacionTextos asociacionTextos1 = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto1 = new Alfabeto("Alfabeto");
        Algoritmo algoritmo1 = Algoritmo.QAP;
        PairInt dimensiones1 = new PairInt(5, 10);
        Teclado teclado1 = new Teclado(nombre, asociacionTextos, alfabeto, algoritmo, dimensiones);
    }


    // ---------- CONSTRUCTORAS ----------
    /**
     * Objeto de la prueba: Test de la constructora de ConjuntoTeclados
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia caja gris. Se crea un nuevo objeto Conjunto de Teclados y se comprueba que no tiene ningun teclado dentro del conjunto.
     * Operativa: Creamos un nuevo Conjunto de Teclados vacío
     **/
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");

        assertTrue(teclados.getTeclados().isEmpty());
    }


    // ---------- GETTERS ----------
    /**
     * Objeto de la prueba: Test del método getTeclado(String nomT) de la clase Conjunto de Teclados.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crea un teclado, se agrega a un conjunto ya creado y se comprueba que se puede acceder a el
     * Operativa: Se comprueba que el resultado sacado pertenece al conjunto de Teclados.
     */
    @Test
    public void TestGetTeclado() {
        System.out.println("Test getTeclado");

        teclados.agregarTeclado("nombreT1", teclado1);
        Teclado resultado = teclados.getTeclado("nombreT1");
        assertNotNull(resultado);
        assertEquals("nombreT1", resultado.getNombre());
    }

    /**
     * Objeto de la prueba: Test del método getNombresTeclado(String nomT) de la clase conjuntoTeclados
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crea un listado de teclados, se añaden a conjuntodeTextos y se comprueba que se puede acceder al nombre de ellos
     * Operativa: Se comprueba que el resultado sacado pertenece al conjunto de Teclados.
     */
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
    /**
     * Objeto de la prueba: Test del método AgregarTeclado(String nomT, Teclado teclado) de la clase conjuntoTeclados
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crean teclados, se añaden al conjunto y se comprueban que estos teclados existen
     * Operativa: Se comprueba que los teclados pertenecen al conjunto de Teclados.
     */
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
    /**
     * Objeto de la prueba: Test del método ExisteTeclado(String nomT) de la clase conjuntoTeclados
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crea un Teclado, se agrega al conjunto y se comprueba que se ha agregado correctamente.
     * Operativa: Se comprueba que el teclado añadido existe en el conjunto.
     */
    @Test
    public void TestExisteTeclado() {
        System.out.println("Test existeTeclado");

        teclados.agregarTeclado("nombreT1", teclado1);

        assertTrue(teclados.existeTeclado("nombreT1"));
        assertFalse(teclados.existeTeclado("nombreT2"));
    }

    /**
     * Objeto de la prueba: Test del método BorrarTeclado(String nomT) de la clase conjuntoTeclados
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crean unos Teclados, se agregan al conjunto, se borran y se comprueba que se ha borrado correctamente.
     * Operativa: Se comprueba que el teclado borrado no existe en el conjunto.
     */
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
}