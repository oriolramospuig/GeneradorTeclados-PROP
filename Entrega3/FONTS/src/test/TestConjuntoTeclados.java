package test;


import main.domain.classes.*;
import main.domain.classes.types.PairInt;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestConjuntoTeclados {
    private ConjuntoTeclados teclados;

    private Teclado teclado1;

    private Teclado teclado2;

    @Before
    public void setUp() {
        teclados = new ConjuntoTeclados();

        String nombre = "teclado1";

        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos1");

        ArrayList<Character> letras = new ArrayList<>();
        Character c = 'a';
        for (int i = 0; i < 12; ++i) {
            letras.add(c);
            ++c;
        }
        Alfabeto alfabeto = new Alfabeto("Alfabeto1", letras);

        PairInt dimensiones = new PairInt(3, 4);
        char[][] contenido = new char[dimensiones.getPrimero()][dimensiones.getSegundo()];
        teclado1 = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido, 0);

        String nombre1 = "teclado2";

        AsociacionTextos asociacionTextos1 = new AsociacionTextos("Asociaciondetextos2");

        Alfabeto alfabeto1 = new Alfabeto("Alfabeto2", letras);
        PairInt dimensiones1 = new PairInt(2, 6);
        char[][] cont = new char[dimensiones.getPrimero()][dimensiones.getSegundo()];
        teclado2 = new Teclado(nombre1, asociacionTextos1, alfabeto1, dimensiones1, cont, 0);
    }


    // ---------- CONSTRUCTORAS ----------
    /**
     * Objeto de la prueba: Test de la constructora de ConjuntoTeclados (Constructora Default).
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se inicializa el atributo de conjuntoteclados vacío.
     * Operativa: AssertEquals() comprueba que la lista de teclados está vacía.
     */
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");
        assertTrue(teclados.getNombresTeclados().isEmpty());
    }


    // ---------- GETTERS ----------
    /**
     * Objeto de la prueba: Test del método GetTeclado de ConjuntoTeclados.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta un objecto teclado con el atributo que lo identifica.
     * Primero se añade un teclado para poder consultarlo.
     * Seguidamente se llama a la función getTeclado que retorna el objeto teclado con el nombre nombreT1 que es el que pasamos como parámetro.
     * Operativa: AssertNotNull() compruba que la variable donde se ha guardado el objeto teclado consultado no es null.
     * AssertEquals() comprueba que el nombre del teclado guardado equivale al nombre que se le ha añadido inicialmente.
     */
    @Test
    public void TestGetTeclado() {
        System.out.println("Test getTeclado");

        teclados.agregarTeclado(teclado1.getNombre(), teclado1);
        Teclado resultado = teclados.getTeclado(teclado1.getNombre());
        assertNotNull(resultado);
        assertEquals("teclado1", resultado.getNombre());
    }

    /**
     * Objeto de la prueba: Test del método GetNombresTecladosde ConjuntoTeclados.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta la lista de nombres de los teclados existentes en el sistema.
     * Primero se añaden dos teclados para poder consultar la lista.
     * Seguidamente se llama a la función getNombresTeclados que retorna la lista de los nombres de los teclados existentes
     * Operativa: AssertEquals() comprueba que la medida de la lista de teclados sea 2.
     * Los siguientes dos AssertTrue() comprueban que existan en la lista todos los nombres agregados anteriormente.
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
     * Objeto de la prueba: Test del método AgregarTecladode ConjuntoTeclados.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se añaden dos teclados con la función agregarTeclado y con los nombres asignados que es el atributo que los identifica.
     * Operativa: AssertEquals() comprueba que la medida de la lista de teclados sea 2.
     * Los siguientes AssertTrue() comprueban que los nombres de los teclados guardados existen en la lista.
     */
    @Test
    public void TestAgregarTeclado(){
        System.out.println("Test agregarTeclado");

        teclados.agregarTeclado("nombreT1", teclado1);
        teclados.agregarTeclado("nombreT2", teclado2);

        assertEquals(2, teclados.getNombresTeclados().size());
        //assertTrue(teclados.getTeclados().containsKey("nombreT1"));
        //assertTrue(teclados.getTeclados().containsKey("nombreT2"));
    }


    // ---------- AUXILIARES ----------
    /**
     * Objeto de la prueba: Test del método ExisteTecladode ConjuntoTeclados.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta si el teclado con un nombre concreto existe en la lista de teclados existentes.
     * Operativa: AssertTrue() comprueba que el nombre del teclado guardado existe en la lista.
     * AssertFalse() comprueba que el nombre del teclado no guardado, no existe en la lista.
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

        assertEquals(1, teclados.getNombresTeclados().size());
        assertFalse(teclados.existeTeclado("nombreT1"));
        assertTrue(teclados.existeTeclado("nombreT2"));
    }
}