package test;

import main.domain.classes.*;

import main.domain.classes.types.PairInt;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestTeclado {

    /**
     * Objeto de la prueba: Test de la constructora de Teclado
     * Ficheros de datos necesarios: Una asociación de textos, un alfabeto y un algoritmo creados anteriormente
     * Valores estudiados: Estrategia caja gris. Se define un teclado a partir de una asociación de texto y un alfabeto y se comprueba que los que guardo sean los mismos.
     * Operativa: Creamos un nuevo Teclado con los parámetros mencionados y escogemos un algoritmo y unas dimensiones para la creación de este
     **/
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto();
        //Algoritmo algoritmo = Algoritmo.QAP;
        PairInt dimensiones = new PairInt(10, 20);
        //buit, no esta generat per algorisme
        char[][] contenido = new char[0][0];
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido);

        assertEquals(nombre, teclado.getNombre());
        //assertEquals(algoritmo, teclado.getAlgoritmo());
        assertEquals(dimensiones, teclado.getDimensiones());
        assertEquals(alfabeto.getNombre(), teclado.getAlfabetoVinculado());
        assertEquals(asociacionTextos.getNombre(), teclado.getAsociacionTextosVinculado());
    }

    ///// GETTERS
    /**
     * Objeto de la prueba: Test del método getDimensiones() de la clase Teclado
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. Se crea un teclado y un PairInt de dimensiones y se asegura que los datos se han introducido correctamente
     * Operativa: Se comprueba que el método getDimensiones() proporciona los datos correctos sobre las dimensiones del teclado
     **/

    @Test
    public void testgetDimensiones() {
        System.out.println("Test get Dimensiones");
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto();
        //Algoritmo algoritmo = Algoritmo.QAP;
        PairInt dimensiones = new PairInt(5, 10);
        //buida, no l'hem generat a partir de l'algoritme
        char[][] contenido = new char[0][0];
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido);
        teclado.setDimensiones(dimensiones);

        PairInt resultado = teclado.getDimensiones();

        assertEquals(5, resultado.getPrimero().intValue());
        assertEquals(10, resultado.getSegundo().intValue());
    }

    /////SETTERS
    /**
     * Objeto de la prueba: Test del método setPuntuacion(float puntuacion) de la clase Teclado
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. Se crea un teclado y una puntuación y se comprueba que se puede añadir la segunda a la primera correctamente
     * Operativa: Se comprueba que la puntuación insertada es equivalente a la del teclado tras haberle añadido la misma
     **/
    @Test
    public void testSetPuntuacion() {
        System.out.println("Test set Puntuacion");
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto();
        //Algoritmo algoritmo = Algoritmo.QAP;
        PairInt dimensiones = new PairInt(5, 10);
        char[][] contenido = new char[0][0];
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido);
        float puntuacion = 100;

        teclado.setPuntuacion(puntuacion);

        assertEquals(100, teclado.getPuntuacion());
    }

    /**
     * Objeto de la prueba: Test del método setDimensiones(PairInt Dimensiones) de la clase Teclado
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. Se crea un teclado y unas dimensiones y se comprueba que se puede añadir la segunda a la primera correctamente
     * Operativa: Se comprueba que las dimensiones insertadas son equivalentes a las del teclado tras haberle añadido las mismas.
     **/
    @Test
    public void testSetDimensiones() {
        System.out.println("Test set Dimensiones");
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto();
        //Algoritmo algoritmo = Algoritmo.QAP;
        PairInt dimensiones = new PairInt(10, 20);
        char[][] contenido = new char[0][0];
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido);
        PairInt dimensiones2 = new PairInt(5, 10);

        teclado.setDimensiones(dimensiones2);

        assertEquals(5, teclado.getDimensiones().getPrimero().intValue());
        assertEquals(10, teclado.getDimensiones().getSegundo().intValue());
    }

    /**
     * Objeto de la prueba: Test del método agregarAlfabetoVinculado(String nomA) de la clase Teclado
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. Se crea un teclado y un alfabeto, se añade el alfabeto como vinculado al teclado y se comprueba de que se ha agregado correctamente.
     * Operativa: Se comprueba que el mismo método añade el alfabeto al Teclado correctamente.
     **/
    @Test
    public void testagregarAlfabetovinculado() {
        System.out.println("Test agregar Alfabeto Vinculado");
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto();
        //Algoritmo algoritmo = Algoritmo.QAP;
        PairInt dimensiones = new PairInt(10, 20);
        char[][] contenido = new char[0][0];
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido);
        ArrayList<Character> letras = new ArrayList<>();
        Alfabeto alfabeto2 = new Alfabeto("nombre2", letras);

        teclado.agregarAlfabetoVinculado("nombre2");

        assertEquals("nombre2", teclado.getAlfabetoVinculado());
    }

    /**
     * Objeto de la prueba: Test del método agregarAsociacionTextosVinculado(String nomAT) de la clase Teclado
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia caja gris. Se crea un teclado y una asociacion de textos, se añade la asociacion como vinculada al teclado y se comprueba de que se ha agregado correctamente.
     * Operativa: Se comprueba que el mismo método añade la Asociación de Textos al Teclado correctamente.
     **/
    @Test
    public void testagregarAsociacionTextosVinculado() {
        System.out.println("Test agregar Asociacion Textos Vinculado");
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto();
        //Algoritmo algoritmo = Algoritmo.QAP;
        PairInt dimensiones = new PairInt(10, 20);
        char[][] contenido = new char[0][0];
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido);
        AsociacionTextos asociacionTextos2 = new AsociacionTextos("nombre2");

        teclado.agregarAsociacionTextosVinculado("nombre2");

        assertEquals("nombre2", teclado.getAsociacionTextosVinculado());
    }

    ///// AUXILIARES

    /**
     * Objeto de la prueba: Test del método borrarAlfabetoVinculado(String nomA) de la clase Teclado.
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia de caja gris. Se crea un teclado con su alfabeto ya creado se comprueba que se puede borrar de la misma.
     * Operativa: Se comprueba que el método borrarAlfabetoVinculado(String nomAT) borra correctamente un String, que corresponde al nombre del alfabeto.
     */
    @Test
    public void testborrarAlfabetoVinculado() {
        System.out.println("Test Borrar Alfabeto Vinculado");
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto();
        //Algoritmo algoritmo = Algoritmo.QAP;
        PairInt dimensiones = new PairInt(10, 20);
        char[][] contenido = new char[0][0];
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido);

        teclado.borrarAlfabetoVinculado("Alfabeto");

        assertNull(teclado.getAlfabetoVinculado());
    }
    /**
     * Objeto de la prueba: Test del método borrarAsociacionTextosVinculado(String nomAT) de la clase Teclado.
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia de caja gris. Se crea un teclado con su asociaciondeTextos también creada y se comprueba que se puede borrar de la misma.
     * Operativa: Se comprueba que el método borrarAsociacionTextosVinculado(String nomAT) borra correctamente un String, que corresponde al nombre de una asociación de textos.
     */
    @Test
    public void testborrarAsociacionTextosVinculado() {
        System.out.println("Test Borrar Asociacion Textos Vinculado");
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto();
        //Algoritmo algoritmo = Algoritmo.QAP;
        PairInt dimensiones = new PairInt(10, 20);
        char[][] contenido = new char[0][0];
        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, dimensiones, contenido);

        teclado.borrarAsociacionTextosVinculados("AsociaciondeTextos");

        assertNull(teclado.getAlfabetoVinculado());
    }
}

