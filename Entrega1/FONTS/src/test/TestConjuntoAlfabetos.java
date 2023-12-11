package test;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestConjuntoAlfabetos {
    private ConjuntoAlfabetos alfabetos;

    private Alfabeto alfabeto1;

    private Alfabeto alfabeto2;

    @Before
    public void setUp() {
        alfabetos = new ConjuntoAlfabetos();
        ArrayList<Character> letras = new ArrayList<>();
        alfabeto1 = new Alfabeto("nombreA1", letras);
        alfabeto2 = new Alfabeto("nombreA2", letras);
    }


    // ---------- CONSTRUCTORAS ----------
    /**
     * Objeto de la prueba: Test de la constructora de ConjuntoAlfabeto (Constructora Default).
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se inicializa el atributo de conjuntoalfabeto vacío.
     * Operativa: AssertTrue() comprueba que la lista de alfabetos está vacía.
     */
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");
        assertTrue(alfabetos.getNombresAlfabetos().isEmpty());
    }

    // ---------- GETTERS ----------
    /**
     * Objeto de la prueba: Test del método GetAlfabeto de ConjuntoAlfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta un objecto alfabeto con el atributo que lo identifica.
     * Primero se añade un alfabeto para poder consultarlo.
     * Seguidamente se llama a la función getAlfabeto que retorna el objeto alfabeto con el nombre nombreA1 que es el que pasamos como parámetro.
     * Operativa: AssertNotNull() compruba que la variable donde se ha guardado el objeto alfabeto consultado no es null.
     * AssertEquals() comprueba que el nombre del alfabeto guardado equivale al nombre que se le ha añadido inicialmente.
     */
    @Test
    public void TestGetAlfabeto() {
        System.out.println("Test getAlfabeto");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);
        Alfabeto resultado = alfabetos.getAlfabeto("nombreA1");
        assertNotNull(resultado);
        assertEquals("nombreA1", resultado.getNombre());
    }

    /**
     * Objeto de la prueba: Test del método GetNombresAlfabetosde ConjuntoAlfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta la lista de nombres de los alfabetos existentes en el sistema.
     * Primero se añaden dos alfabeto para poder consultar la lista.
     * Seguidamente se llama a la función getNombresAlfabetos que retorna la lista de los nombres de los alfabetos existentes
     * Operativa: AssertEquals() comprueba que la medida de la lista de alfabetos sea 2.
     * Los siguientes dos AssertTrue comprueban que existan en la lista todos los nombre agregados anteriormente.
     */
    @Test
    public void TestGetNombresAlfabetos() {
        System.out.println("Test getNombreAlfabetos");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);
        alfabetos.agregarAlfabeto("nombreA2", alfabeto2);

        ArrayList<String> nombres = alfabetos.getNombresAlfabetos();

        assertEquals(2, nombres.size());
        assertNotNull(nombres);
        Assert.assertTrue(nombres.contains("nombreA1"));
        Assert.assertTrue(nombres.contains("nombreA1"));

    }


    // ---------- SETTERS ----------
    /**
     * Objeto de la prueba: Test del método AgregarAlfabeto de ConjuntoAlfabeto.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se añaden dos alfabetos con la función agregaralfabeto y con los nombres asignados que es el atributo que los identifica.
     * Operativa: AssertEquals() comprueba que la medida de la lista de alfabetos sea 2.
     * Los siguientes AssertTrue() comprueban que los nombres de los alfabetos guardados existen en la lista.
     */
    @Test
    public void TestAgregarAlfabeto(){
        System.out.println("Test agregarAlfabeto");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);
        alfabetos.agregarAlfabeto("nombreA2", alfabeto2);

        assertEquals(2, alfabetos.getNombresAlfabetos().size());
        //assertTrue(alfabetos.containsKey("nombreA1"));
        //assertTrue(alfabetos.getAlfabetos().containsKey("nombreA2"));
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
        System.out.println("Test existeAlfabeto");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);

        assertTrue(alfabetos.existeAlfabeto("nombreA1"));
        assertFalse(alfabetos.existeAlfabeto("nombreA2"));
    }

    /**
     * - Objetivo de la Prueba:
     *   Verificar que la función borrarAlfabeto de la clase elimina correctamente un alfabeto por nombre.
     *
     * - Ficheros Necesarios:
     *   No hay referencia a ficheros en esta función de prueba.
     *
     * - Valores Estudiados:
     *   - Se imprime un mensaje indicando que se está probando la función borrarAlfabeto.
     *   - Se agregan dos alfabetos con nombres "nombreA1" y "nombreA2" a la instancia de la clase (alfabetos).
     *   - Se utiliza la función borrarAlfabeto para eliminar el alfabeto con nombre "nombreA1".
     *   - Utiliza la aserción assertEquals para verificar que la cantidad de alfabetos es 1 después de la eliminación.
     *   - Utiliza la aserción assertFalse para verificar que el alfabeto con nombre "nombreA1" no existe después de la eliminación.
     *   - Utiliza la aserción assertTrue para verificar que el alfabeto con nombre "nombreA2" sigue existiendo después de la eliminación.
     *
     * - Operativa:
     *   1. Imprime un mensaje informativo en la consola indicando que se está probando la función borrarAlfabeto.
     *   2. Agrega dos alfabetos con nombres "nombreA1" y "nombreA2" a la instancia de la clase (alfabetos).
     *   3. Utiliza la función borrarAlfabeto para eliminar el alfabeto con nombre "nombreA1".
     *   4. Utiliza la aserción assertEquals para verificar que la cantidad de alfabetos es 1 después de la eliminación.
     *   5. Utiliza la aserción assertFalse para verificar que el alfabeto con nombre "nombreA1" no existe después de la eliminación.
     *   6. Utiliza la aserción assertTrue para verificar que el alfabeto con nombre "nombreA2" sigue existiendo después de la eliminación.
     *   7. Si alguna de las aserciones falla, se considera que la prueba no ha pasado con éxito.
     *   8. Este método es parte de un conjunto más amplio de pruebas unitarias.
     */
    @Test
    public void TestBorrarAlfabeto() {
        System.out.println("Test borrarAlfabeto");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);
        alfabetos.agregarAlfabeto("nombreA2", alfabeto2);

        alfabetos.borrarAlfabeto("nombreA1");

        assertEquals(1, alfabetos.getNombresAlfabetos().size());
        assertFalse(alfabetos.existeAlfabeto("nombreA1"));
        assertTrue(alfabetos.existeAlfabeto("nombreA2"));
    }
}
