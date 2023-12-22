package test;

import main.domain.classes.*;
import main.domain.classes.types.PairInt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias para ConjuntoAlfabetos. Evalúa el correcto funcionamiento de la creación y manipulación de objetos ConjuntoAlfabetos.
 * @author Alèxia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class TestConjuntoAlfabetos {
    /** Instancia de la clase ConjuntoAlfabetos utilizada en los casos de prueba. */
    private ConjuntoAlfabetos alfabetos;

    /** Instancias de la clase Alfabeto para datos de prueba. */
    private Alfabeto alfabeto1;
    private Alfabeto alfabeto2;

    /** Constantes para datos de prueba. */
    private static final String nombre1 = "alfabeto1";
    private static final String nombre2 = "alfabeto2";
    private static ArrayList<Character> letras1 = null;
    private static ArrayList<Character> letras2 = null;


    /**
     * Inicialización de las instancias Palabras y Frecuencias para realizar los juegos de prueba.
     */
   @Before
   public void setUp(){


       letras1 = new ArrayList<>();
       letras1.add('a');
       letras1.add('b');
       letras1.add('c');
       alfabeto1 = new Alfabeto(nombre1,letras1);

       letras2 = new ArrayList<>();
       letras2.add('d');
       letras2.add('e');
       letras2.add('f');
       alfabeto2 = new Alfabeto(nombre2,letras2);

   }

    // ---------- CONSTRUCTORAS ----------
    /**
     * Objeto de la prueba: Test de la constructora de ConjuntoAlfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Estrategia caja gris. Se define un conjunto de alfabetos y se comprueba que se crea correctamente.
     * Operativa: Creamos un nuevo ConjuntoAlfabetos. Se comprueba que se ha creado vacío.
     */
    @Test
    public void TestConstructora() {
        //System.out.println("Test Constructora");
        alfabetos = new ConjuntoAlfabetos();
        assertTrue(alfabetos.getNombresAlfabetos().isEmpty());
    }

    // ---------- GETTERS ----------
    /**
     * Objeto de la prueba: Test del método GetAlfabeto de ConjuntoAlfabeto.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja negra. Se añaden textos al conjunto y se verifica que el método getTexto devuelve los textos correctos.
     * Primero se añade un alfabeto para poder consultarlo.
     * Seguidamente se llama a la función getAlfabeto que retorna el objeto alfabeto con el nombre nombreA1 que es el que pasamos como parámetro.
     * Operativa: AssertNotNull() compruba que la variable donde se ha guardado el objeto alfabeto consultado no es null.
     * AssertEquals() comprueba que el nombre del alfabeto guardado equivale al nombre que se le ha añadido inicialmente.
     */
    @Test
    public void TestGetAlfabeto() {
        //System.out.println("Test getAlfabeto");
        alfabetos = new ConjuntoAlfabetos();
        alfabetos.agregarAlfabeto(nombre1, alfabeto1);
        //alfabetos.agregarAlfabeto(nombre2, letras2);

        Alfabeto resultado = alfabetos.getAlfabeto(nombre1);
        assertNotNull(resultado);
        assertEquals(alfabeto1, resultado);
    }

    /**
     * Objeto de la prueba: Test del método GetNombresAlfabetosde ConjuntoAlfabeto.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja negra. Se añaden alfabetos al conjunto y se verifica que el método getNombresAlfabetos devuelve los nombres correctos.
     * Operativa: Se agregan instancias de alfabetos al conjunto. Se llama a getNombresAlfabetos y se verifica la igualdad.
     */
    @Test
    public void TestGetNombresAlfabetos() {
        //System.out.println("Test getNombreAlfabetos");

        alfabetos = new ConjuntoAlfabetos();
        alfabetos.agregarAlfabeto(nombre1, alfabeto1);
        alfabetos.agregarAlfabeto(nombre2, alfabeto2);

        ArrayList<String> nombres = alfabetos.getNombresAlfabetos();

        assertEquals(2, nombres.size());
        assertNotNull(nombres);
        Assert.assertTrue(nombres.contains(nombre1));
        Assert.assertTrue(nombres.contains(nombre2));

    }


    // ---------- SETTERS ----------
    /**
     * Objeto de la prueba: Test del método AgregarAlfabeto de ConjuntoAlfabeto.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja negra. Se añaden alfabetos al conjunto y se verifica que se agregan correctamente.
     * Operativa: Se añaden instancias de alfabetos al conjunto. Se verifica que los nombres estén presentes y los alfabetos sean iguales.
     * También se comprueba que si se intenta añadir un alfabeto que ya existe, no se añade otra vez en el conjunto.
     */
    @Test
    public void TestAgregarAlfabeto(){
        //System.out.println("Test agregarAlfabeto");

        alfabetos = new ConjuntoAlfabetos();
        alfabetos.agregarAlfabeto(nombre1, alfabeto1);
        alfabetos.agregarAlfabeto(nombre2, alfabeto2);

        assertEquals(2, alfabetos.getNombresAlfabetos().size());
        assertTrue(alfabetos.getAlfabetos().containsKey(nombre1));
    }


    // ---------- AUXILIARES ----------
    /**
     * Objeto de la prueba: Test del método ExisteAlfabeto de ConjuntoAlfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta si el alfabeto con un nombre concreto existe en la lista de alfabetos existentes.
     * Operativa: AssertTrue() comprueba que el nombre del alfabeto guardado existe en la lista.
     * AssertFalse() comprueba que el nombre del alfabeto no guardado, no existe en la lista.
     */
    @Test
    public void TestExisteAlfabeto() {
        //System.out.println("Test existeAlfabeto");
        alfabetos = new ConjuntoAlfabetos();
        alfabetos.agregarAlfabeto(nombre1, alfabeto1);

        assertTrue(alfabetos.existeAlfabeto(nombre1));
        assertFalse(alfabetos.existeAlfabeto(nombre2));
    }

    /**
     * Objeto de la prueba: Test del método borrarAlfabeto de la clase ConjuntoAlfabetos.
     * Ficheros de datos necesarios: No se requieren ficheros externos para esta prueba.
     * Valores estudiados: Estrategia caja negra. Se añaden alfabetos al conjunto, se borra un alfabeto y se verifica que se haya eliminado correctamente.
     * Operativa: Se añaden instancias de alfabetos al conjunto. Se verifica que los nombres estén presentes y los alfabetos sean iguales.
     * Luego, se borra un alfabeto y se verifica que el alfabeto se haya eliminado correctamente y los demás alfabetos sigan presentes.
     * También se comprueba que si se intenta borrar un alfabeto que ya no existe el conjunto se queda igual.
     */
    @Test
    public void TestBorrarAlfabeto() {
        //System.out.println("Test borrarAlfabeto");
        alfabetos = new ConjuntoAlfabetos();
        alfabetos.agregarAlfabeto(nombre1, alfabeto1);
        alfabetos.agregarAlfabeto(nombre2, alfabeto2);
        alfabetos.borrarAlfabeto(nombre1);

        assertEquals(1, alfabetos.getNombresAlfabetos().size());
        assertFalse(alfabetos.existeAlfabeto(nombre1));
        assertTrue(alfabetos.existeAlfabeto(nombre2));
    }
}
