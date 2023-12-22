package test;

import main.domain.classes.AsociacionTextos;
import main.domain.classes.ConjuntoAsociaciones;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Victor Moreno
 */
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

    /**
     * Objeto de la prueba: Test de la constructora de ConjuntoAsociacion (Constructora Default).
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se inicializa el atributo de conjuntoasociaciones vacío.
     * Operativa: AssertEquals() comprueba que la lista de asociaciones está vacía.
     */
    // ---------- CONSTRUCTORAS ----------
    @Test
    public void TestConstructora() {
        //System.out.println("Test Constructora");

        assertTrue(asociaciones.getNombresAsociacionesTextos().isEmpty());
    }


    // ---------- GETTERS ----------
    /**
     * Objeto de la prueba: Test del método GetAsociacionTextos de ConjuntoAsociacionesTextos.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta un objecto asociación con el atributo que lo identifica.
     * Primero se añade una asociación para poder consultarla.
     * Seguidamente se llama a la función getAsociacionTexto que retorna el objeto asociación con el nombre nombreAT1 que es el que pasamos como parámetro.
     * Operativa: AssertNotNull() compruba que la variable donde se ha guardado el objeto asociación consultada no es null.
     * AssertEquals() comprueba que el nombre de la asociación guardada equivale al nombre que se le ha añadido inicialmente.
     */
    @Test
    public void TestGetAsociacionTextos() {
        //System.out.println("Test getAsociacionTextos");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);
        AsociacionTextos resultado = asociaciones.getAsociacionTextos("nombreAT1");
        assertNotNull(resultado);
        assertEquals("nombreAT1", resultado.getNombre());
    }

    /**
     * Objeto de la prueba: Test del método GetNombresAsociacionesTextos de ConjuntoTextos.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta la lista de nombres de las aociaciones existentes en el sistema.
     * Primero se añaden dos asociaciaciones para poder consultar la lista.
     * Seguidamente se llama a la función getNombresAsociacionesTextos que retorna la lista de los nombres de los asociaciones existentes
     * Operativa: AssertEquals() comprueba que la medida de la lista de alfabetos sea 2.
     * Los siguientes dos AssertTrue() comprueban que existan en la lista todos los nombres agregados anteriormente.
     */
    @Test
    public void TestGetNombresAsociacionesTextos() {
        //System.out.println("Test getNombresAsociacionesTextos");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);
        asociaciones.agregarAsociacionTexto("nombreAT2", asociacionTextos2);

        ArrayList<String> nombres = asociaciones.getNombresAsociacionesTextos();

        assertEquals(2, nombres.size());
        assertTrue(nombres.contains("nombreAT1"));
        assertTrue(nombres.contains("nombreAT2"));
    }


    // ---------- SETTERS ----------
    /**
     * Objeto de la prueba: Test del método AgregarAsociacion de ConjuntoAsociaciones.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se añaden dos asociaciones con la función agregarAsociacionTexto y con los nombres asignados que es el atributo que las identifica.
     * Operativa: AssertEquals() comprueba que la medida de la lista de asociaciones sea 2.
     * Los siguientes AssertTrue() comprueban que los nombres de las asociaciones guardadas existen en la lista.
     */
    @Test
    public void TestAgregarAsociacionTexto(){
        //System.out.println("Test agregarAsociacionTexto");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);
        asociaciones.agregarAsociacionTexto("nombreAT2", asociacionTextos2);

        assertEquals(2, asociaciones.getNombresAsociacionesTextos().size());
        //assertTrue(asociaciones.getAsociacionesTextos().containsKey("nombreAT1"));
        //assertTrue(asociaciones.getAsociacionesTextos().containsKey("nombreAT2"));
    }


    // ---------- AUXILIARES ----------
    /**
     * Objeto de la prueba: Test del método ExisteAsociaciondeTextos de ConjuntoAsociaciones.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hacen falta ficheros adicionales.
     * Valores estudiados: Se consulta si la ssociación con un nombre concreto existe en la lista de asociaciones existentes.
     * Operativa: AssertTrue() comprueba que el nombre de la asociación guardada existe en la lista.
     * AssertFalse() comprueba que el nombre de la asociación no guardada, no existe en la lista.
     */
    @Test
    public void TestExisteAsociaciondeTextos() {
        //System.out.println("Test existeAsociaciondeTextos");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);

        assertTrue(asociaciones.existeAsociaciondeTextos("nombreAT1"));
        assertFalse(asociaciones.existeAsociaciondeTextos("nombreAT2"));
    }

    /**
     * Objetivo de la Prueba:
     * La función `TestBorrarAsociacionTextos` tiene como objetivo verificar el correcto funcionamiento
     * del método `borrarAsociacionTextos` de la clase `Asociaciones`. Este método debería eliminar
     * una asociación de textos de la colección.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Asociaciones`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agregan dos asociaciones de textos mediante el método `agregarAsociacionTexto`.
     * 3. Se elimina una de las asociaciones mediante el método `borrarAsociacionTextos`.
     * 4. Se verifica que la colección de asociaciones tenga el tamaño esperado y que no contenga la asociación eliminada.
     *
     * Operativa:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agregan dos asociaciones de textos mediante el método `agregarAsociacionTexto`.
     * 3. Se elimina una de las asociaciones mediante el método `borrarAsociacionTextos`.
     * 4. Se verifica que la colección de asociaciones tenga el tamaño esperado y que no contenga la asociación eliminada.
     */
    @Test
    public void TestBorrarAsociacionTextos() {
        //System.out.println("Test borrarAsociacionTextos");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);
        asociaciones.agregarAsociacionTexto("nombreAT2", asociacionTextos2);

        asociaciones.borrarAsociacionTextos("nombreAT1");

        assertEquals(1, asociaciones.getNombresAsociacionesTextos().size());
        assertFalse(asociaciones.existeAsociaciondeTextos("nombreAT1"));
        assertTrue(asociaciones.existeAsociaciondeTextos("nombreAT2"));
    }
}