package test;

import main.domain.classes.AsociacionTextos;
import main.domain.classes.ConjuntoAsociaciones;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
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
     * Objetivo de la Prueba:
     * La función `TestBorrarTecladoVinculado` tiene como objetivo verificar el correcto funcionamiento
     * del método `borrarTecladoVinculado` de la clase `AsociacionTextos`. Este método debería eliminar
     * un teclado vinculado de la asociación.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `AsociacionTextos`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se crea una instancia de `AsociacionTextos`.
     * 2. Se agregan dos teclados vinculados a la asociación mediante el método `agregarTecladoVinculado`.
     * 3. Se elimina un teclado vinculado específico mediante la invocación del método `borrarTecladoVinculado`.
     * 4. Se verifica que la lista de teclados vinculados se haya actualizado correctamente después de la eliminación.
     *
     * Operativa:
     * 1. Se crea una asociación de textos.
     * 2. Se agregan dos teclados vinculados a la asociación mediante el método `agregarTecladoVinculado`.
     * 3. Se elimina uno de los teclados vinculados mediante el método `borrarTecladoVinculado`.
     * 4. Se verifica que la lista de teclados vinculados tenga el tamaño esperado y que no contenga el teclado eliminado.
     */
    // ---------- CONSTRUCTORAS ----------
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");

        assertTrue(asociaciones.getAsociacionesTextos().isEmpty());
    }


    // ---------- GETTERS ----------
    /**
     * Objetivo de la Prueba:
     * La función `TestGetAsociacionTextos` tiene como objetivo verificar el correcto funcionamiento
     * del método `getAsociacionTextos` de la clase `Asociaciones`. Este método debería devolver
     * la asociación de textos con el nombre especificado.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Asociaciones`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agrega una asociación de textos a `Asociaciones` mediante el método `agregarAsociacionTexto`.
     * 3. Se obtiene una asociación de textos por su nombre utilizando el método `getAsociacionTextos`.
     * 4. Se verifica que la asociación de textos devuelta no sea nula y que tenga el nombre esperado.
     *
     * Operativa:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agrega una asociación de textos a `Asociaciones` mediante el método `agregarAsociacionTexto`.
     * 3. Se obtiene la asociación de textos por su nombre utilizando el método `getAsociacionTextos`.
     * 4. Se verifica que la asociación de textos devuelta no sea nula y que tenga el nombre esperado.
     */
    @Test
    public void TestGetAsociacionTextos() {
        System.out.println("Test getAsociacionTextos");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);
        AsociacionTextos resultado = asociaciones.getAsociacionTextos("nombreAT1");
        assertNotNull(resultado);
        assertEquals("nombreAT1", resultado.getNombre());
    }

    /**
     * Objetivo de la Prueba:
     * La función `TestGetNombresAsociacionesTextos` tiene como objetivo verificar el correcto funcionamiento
     * del método `getNombresAsociacionesTextos` de la clase `Asociaciones`. Este método debería devolver
     * una lista de los nombres de las asociaciones de textos presentes en la colección.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Asociaciones`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agregan dos asociaciones de textos mediante el método `agregarAsociacionTexto`.
     * 3. Se verifica que la lista de nombres de asociaciones tenga el tamaño esperado y que contenga los nombres de las asociaciones agregadas.
     *
     * Operativa:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agregan dos asociaciones de textos mediante el método `agregarAsociacionTexto`.
     * 3. Se verifica que la lista de nombres de asociaciones tenga el tamaño esperado y que contenga los nombres de las asociaciones agregadas.
     */
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
    /**
     * Objetivo de la Prueba:
     * La función `TestAgregarAsociacionTexto` tiene como objetivo verificar el correcto funcionamiento
     * del método `agregarAsociacionTexto` de la clase `Asociaciones`. Este método debería agregar
     * una asociación de textos a la colección de asociaciones.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Asociaciones`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agregan dos asociaciones de textos mediante el método `agregarAsociacionTexto`.
     * 3. Se verifica que la colección de asociaciones tenga el tamaño esperado y que contenga las asociaciones agregadas.
     *
     * Operativa:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agregan dos asociaciones de textos mediante el método `agregarAsociacionTexto`.
     * 3. Se verifica que la colección de asociaciones tenga el tamaño esperado y que contenga las asociaciones agregadas.
     */
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
    /**
     * Objetivo de la Prueba:
     * La función `TestExisteAsociaciondeTextos` tiene como objetivo verificar el correcto funcionamiento
     * del método `existeAsociaciondeTextos` de la clase `Asociaciones`. Este método debería devolver
     * `true` si la asociación de textos con el nombre dado está presente en la colección y `false` en caso contrario.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `Asociaciones`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agrega una asociación de textos mediante el método `agregarAsociacionTexto`.
     * 3. Se verifica que el método `existeAsociaciondeTextos` devuelva `true` para el nombre de la asociación agregada y `false` para un nombre que no está presente.
     *
     * Operativa:
     * 1. Se crea una instancia de `Asociaciones`.
     * 2. Se agrega una asociación de textos mediante el método `agregarAsociacionTexto`.
     * 3. Se verifica que el método `existeAsociaciondeTextos` devuelva `true` para el nombre de la asociación agregada y `false` para un nombre que no está presente.
     */
    @Test
    public void TestExisteAsociaciondeTextos() {
        System.out.println("Test existeAsociaciondeTextos");

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
        System.out.println("Test borrarAsociacionTextos");

        asociaciones.agregarAsociacionTexto("nombreAT1", asociacionTextos1);
        asociaciones.agregarAsociacionTexto("nombreAT2", asociacionTextos2);

        asociaciones.borrarAsociacionTextos("nombreAT1");

        assertEquals(1, asociaciones.getAsociacionesTextos().size());
        assertFalse(asociaciones.existeAsociaciondeTextos("nombreAT1"));
        assertTrue(asociaciones.existeAsociaciondeTextos("nombreAT2"));
    }
}