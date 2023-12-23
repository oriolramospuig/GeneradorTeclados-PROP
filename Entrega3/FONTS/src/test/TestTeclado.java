package test;

import main.domain.classes.*;

import main.domain.classes.types.PairInt;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias para Teclado. Evalúa el correcto funcionamiento de la creación y manipulación de objetos Teclado.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class TestTeclado {

    /**
     * Objeto de la prueba: Test de la constructora de Teclado.
     * Ficheros de datos necesarios: Una asociación de textos, un alfabeto y un algoritmo creados anteriormente.
     * Valores estudiados: Estrategia caja gris. Se define un teclado a partir de una asociación de texto y un alfabeto y se comprueba que los que guardo sean los mismos.
     * Operativa: Creamos un nuevo Teclado con los parámetros mencionados y escogemos un algoritmo y unas dimensiones para la creación de este.
     **/
    @Test
    public void TestConstructora() {
        //System.out.println("Test Constructora");
        String nombre = "nombreTeclado";
        AsociacionTextos asociacionTextos = new AsociacionTextos("nombreAsociaciondetextos");

        ArrayList<Character> l = new ArrayList<>();
        Alfabeto alfabeto = new Alfabeto("nombreAlfabeto", l);

        PairInt dimensiones = new PairInt(10,20);
        char[][] contenido = new char[dimensiones.getPrimero()][dimensiones.getSegundo()];

        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido, 0);

        assertNotNull(teclado);
        assertEquals(nombre, teclado.getNombre());
        assertEquals(10, teclado.getDimensiones().getPrimero().intValue());
        assertEquals(20, teclado.getDimensiones().getSegundo().intValue());
        assertEquals(alfabeto.getNombre(), teclado.getAlfabetoVinculado());
        assertEquals(asociacionTextos.getNombre(), teclado.getAsociacionTextosVinculado());
        assertEquals(0, teclado.getPuntuacion());
    }


    // ---------- GETTERS ----------
    /**
     * Objeto de la prueba: Test del método getDimensiones() de la clase Teclado.
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. Se crea un teclado y un PairInt de dimensiones y se asegura que los datos se han introducido correctamente.
     * Operativa: Se comprueba que el método getDimensiones() proporciona los datos correctos sobre las dimensiones del teclado.
     **/

    @Test
    public void testgetDimensiones() {
        //System.out.println("Test get Dimensiones");
        String nombre = "nombreTec";

        AsociacionTextos asociacionTextos = new AsociacionTextos("AsociaciondetextosTec");

        ArrayList<Character> l = new ArrayList<>();
        Alfabeto alfabeto = new Alfabeto("AlfabetoTec", l);

        PairInt dimensiones = new PairInt(5, 10);
        char[][] contenido = new char[dimensiones.getPrimero()][dimensiones.getSegundo()];

        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido, 0);

        PairInt resultado = teclado.getDimensiones();

        assertEquals(5, resultado.getPrimero().intValue());
        assertEquals(10, resultado.getSegundo().intValue());
    }

    /**
     * Objeto de la prueba: Test del método agregarAlfabetoVinculado(String nomA) de la clase Teclado.
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. Se crea un teclado y un alfabeto, se añade el alfabeto como vinculado al teclado y se comprueba de que se ha agregado correctamente.
     * Operativa: Se comprueba que el mismo método añade el alfabeto al Teclado correctamente.
     **/
    @Test
    public void testagregarAlfabetovinculado() {
        //System.out.println("Test agregar Alfabeto Vinculado");
        String nombre = "nombreTecladoTest";

        AsociacionTextos asociacionTextos = new AsociacionTextos("nAsociaciondetextos");

        ArrayList<Character> l = new ArrayList<>();
        Alfabeto alfabeto = new Alfabeto("nAlfabeto", l);

        PairInt dimensiones = new PairInt(5, 10);

        char[][] contenido = new char[dimensiones.getPrimero()][dimensiones.getSegundo()];
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido, 0);

        ArrayList<Character> letras = new ArrayList<>();
        Alfabeto alfabeto2 = new Alfabeto("nombre2", letras);

        teclado.agregarAlfabetoVinculado("nombre2");
        assertEquals(alfabeto2.getNombre(), teclado.getAlfabetoVinculado());
    }

    /**
     * Objeto de la prueba: Test del método agregarAsociacionTextosVinculado(String nomAT) de la clase Teclado.
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. Se crea un teclado y una asociacion de textos, se añade la asociacion como vinculada al teclado y se comprueba de que se ha agregado correctamente.
     * Operativa: Se comprueba que el mismo método añade la Asociación de Textos al Teclado correctamente.
     **/
    @Test
    public void testagregarAsociacionTextosVinculado() {
        //System.out.println("Test agregar Asociacion Textos Vinculado");
        String nombre = "nombreT";

        AsociacionTextos asociacionTextos = new AsociacionTextos("nomAsociaciondetextos");

        ArrayList<Character> l = new ArrayList<>();
        Alfabeto alfabeto = new Alfabeto("nomAlfabeto", l);

        PairInt dimensiones = new PairInt(5, 10);

        char[][] contenido = new char[dimensiones.getPrimero()][dimensiones.getSegundo()];
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido, 0);

        AsociacionTextos asociacionTextos2 = new AsociacionTextos("nombreAT2");

        teclado.agregarAsociacionTextosVinculado("nombreAT2");
        assertEquals(asociacionTextos2.getNombre(), teclado.getAsociacionTextosVinculado());
    }
}

