package test;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
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
     * - Objetivo de la Prueba:
     *   Verificar que la constructora de la clase crea una instancia válida y que el conjunto
     *   de alfabetos está vacío después de la creación.
     * - Ficheros Necesarios:
     *   No hay referencia a ficheros en esta función de prueba.
     * - Valores Estudiados:
     *   - Se imprime un mensaje indicando que se está probando la constructora.
     *   - Se utiliza la aserción assertTrue para verificar que el conjunto de alfabetos
     *     está vacío después de la creación.
     * - Operativa:
     *   1. Imprime un mensaje informativo en la consola indicando que se está probando la constructora.
     *   2. Utiliza la aserción assertTrue para verificar que el conjunto de alfabetos está vacío
     *      después de crear una instancia de la clase.
     *   3. Si la aserción falla, se considera que la prueba no ha pasado con éxito.
     *   4. Este método es parte de un conjunto más amplio de pruebas unitarias.
     */
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");
        assertTrue(alfabetos.getAlfabetos().isEmpty());
    }

    // ---------- GETTERS ----------
    /**
     * - Objetivo de la Prueba:
     *   Verificar que la función getAlfabeto de la clase devuelve el alfabeto correcto asociado a un nombre dado.
     *
     * - Ficheros Necesarios:
     *   No hay referencia a ficheros en esta función de prueba.
     *
     * - Valores Estudiados:
     *   - Se imprime un mensaje indicando que se está probando la función getAlfabeto.
     *   - Se agrega un alfabeto a la instancia de la clase (alfabetos).
     *   - Se utiliza la aserción assertNotNull para verificar que el resultado de getAlfabeto no es nulo.
     *   - Se utiliza la aserción assertEquals para verificar que el nombre del alfabeto obtenido coincide con el esperado.
     *
     * - Operativa:
     *   1. Imprime un mensaje informativo en la consola indicando que se está probando la función getAlfabeto.
     *   2. Agrega un alfabeto con nombre "nombreA1" a la instancia de la clase (alfabetos).
     *   3. Utiliza la función getAlfabeto para obtener el alfabeto asociado al nombre "nombreA1".
     *   4. Utiliza las aserciones assertNotNull y assertEquals para verificar que el resultado obtenido es válido.
     *   5. Si alguna aserción falla, se considera que la prueba no ha pasado con éxito.
     *   6. Este método es parte de un conjunto más amplio de pruebas unitarias.
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
     * - Objetivo de la Prueba:
     *   Verificar que la función getNombresAlfabetos de la clase devuelve la lista de nombres de alfabetos correcta.
     *
     * - Ficheros Necesarios:
     *   No hay referencia a ficheros en esta función de prueba.
     *
     * - Valores Estudiados:
     *   - Se imprime un mensaje indicando que se está probando la función getNombresAlfabetos.
     *   - Se agregan dos alfabetos a la instancia de la clase (alfabetos).
     *   - Se utiliza la función getNombresAlfabetos para obtener la lista de nombres de alfabetos.
     *   - Se utiliza la aserción assertEquals para verificar que la cantidad de nombres obtenidos coincide con la esperada.
     *
     * - Operativa:
     *   1. Imprime un mensaje informativo en la consola indicando que se está probando la función getNombresAlfabetos.
     *   2. Agrega dos alfabetos con nombres "nombreA1" y "nombreA2" a la instancia de la clase (alfabetos).
     *   3. Utiliza la función getNombresAlfabetos para obtener la lista de nombres de alfabetos.
     *   4. Utiliza la aserción assertEquals para verificar que la cantidad de nombres obtenidos coincide con la esperada (2).
     *   5. Si la aserción falla, se considera que la prueba no ha pasado con éxito.
     *   6. Este método es parte de un conjunto más amplio de pruebas unitarias.
     */
    @Test
    public void TestGetNombresAlfabetos() {
        System.out.println("Test getNombreAlfabetos");

        alfabetos.agregarAlfabeto("nombreA1", alfabeto1);
        alfabetos.agregarAlfabeto("nombreA2", alfabeto2);

        ArrayList<String> nombres = alfabetos.getNombresAlfabetos();

        assertEquals(2, nombres.size());
    }


    // ---------- SETTERS ----------
    /**
     * - Objetivo de la Prueba:
     *   Verificar que la función agregarAlfabeto de la clase añade correctamente alfabetos a la instancia y actualiza su estado interno.
     *
     * - Ficheros Necesarios:
     *   No hay referencia a ficheros en esta función de prueba.
     *
     * - Valores Estudiados:
     *   - Se imprime un mensaje indicando que se está probando la función agregarAlfabeto.
     *   - Se agregan dos alfabetos con nombres "nombreA1" y "nombreA2" a la instancia de la clase (alfabetos).
     *   - Utiliza la aserción assertEquals para verificar que la cantidad de alfabetos es la esperada (2).
     *   - Utiliza la aserción assertTrue para verificar que los nombres "nombreA1" y "nombreA2" están presentes en la instancia de la clase.
     *
     * - Operativa:
     *   1. Imprime un mensaje informativo en la consola indicando que se está probando la función agregarAlfabeto.
     *   2. Agrega dos alfabetos con nombres "nombreA1" y "nombreA2" a la instancia de la clase (alfabetos).
     *   3. Utiliza la aserción assertEquals para verificar que la cantidad de alfabetos es la esperada (2).
     *   4. Utiliza la aserción assertTrue para verificar que los nombres "nombreA1" y "nombreA2" están presentes en la instancia de la clase.
     *   5. Si alguna de las aserciones falla, se considera que la prueba no ha pasado con éxito.
     *   6. Este método es parte de un conjunto más amplio de pruebas unitarias.
     */
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
    /**
     * - Objetivo de la Prueba:
     *   Verificar que la función existeAlfabeto de la clase devuelve el resultado esperado al buscar un alfabeto por nombre.
     *
     * - Ficheros Necesarios:
     *   No hay referencia a ficheros en esta función de prueba.
     *
     * - Valores Estudiados:
     *   - Se imprime un mensaje indicando que se está probando la función existeAlfabeto.
     *   - Se agrega un alfabeto con nombre "nombreA1" a la instancia de la clase (alfabetos).
     *   - Utiliza la aserción assertTrue para verificar que el alfabeto con nombre "nombreA1" existe en la instancia de la clase.
     *   - Utiliza la aserción assertFalse para verificar que el alfabeto con nombre "nombreA2" no existe en la instancia de la clase.
     *
     * - Operativa:
     *   1. Imprime un mensaje informativo en la consola indicando que se está probando la función existeAlfabeto.
     *   2. Agrega un alfabeto con nombre "nombreA1" a la instancia de la clase (alfabetos).
     *   3. Utiliza la aserción assertTrue para verificar que el alfabeto con nombre "nombreA1" existe en la instancia de la clase.
     *   4. Utiliza la aserción assertFalse para verificar que el alfabeto con nombre "nombreA2" no existe en la instancia de la clase.
     *   5. Si alguna de las aserciones falla, se considera que la prueba no ha pasado con éxito.
     *   6. Este método es parte de un conjunto más amplio de pruebas unitarias.
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

        assertEquals(1, alfabetos.getAlfabetos().size());
        assertFalse(alfabetos.existeAlfabeto("nombreA1"));
        assertTrue(alfabetos.existeAlfabeto("nombreA2"));
    }
}
