package test;

import main.domain.classes.AsociacionTextos;
import main.domain.classes.Frecuencias;
import main.domain.classes.Texto;
import main.domain.classes.types.PairFrequency;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 */
public class TestAsociacionTextos {

    // ---------- CONSTRUCTORAS ----------

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
    public void TestConstructora() {
        System.out.println("Test Constructora Vacia");
        AsociacionTextos asociacionTextos = new AsociacionTextos();

        assertEquals("", asociacionTextos.getNombre());
        assertTrue(asociacionTextos.getTextosAsociaciados().isEmpty());
        assertTrue(asociacionTextos.getTecladosVinculados().isEmpty());
        assertTrue(asociacionTextos.getFrecuenciaLetras().isEmpty());

        System.out.println("Test Constructora con nombre y frecuencias");
        String nombre = "Asociacion";
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("a", 2);
        frecuenciaLetras.put("b", 1);
        frecuenciaLetras.put("c", 2);

        AsociacionTextos asociacionTextos2 = new AsociacionTextos(nombre, frecuenciaLetras);

        assertEquals(nombre, asociacionTextos.getNombre());
        assertEquals(frecuenciaLetras, asociacionTextos.getFrecuenciaLetras());
        assertTrue(asociacionTextos.getTextosAsociaciados().isEmpty());
        assertTrue(asociacionTextos.getTecladosVinculados().isEmpty());

        assertEquals("a", asociacionTextos2.getFrecuenciaLetras().get(0));
        assertEquals("b", asociacionTextos2.getFrecuenciaLetras().get(1));
        assertEquals("c", asociacionTextos2.getFrecuenciaLetras().get(2));

        System.out.println("Test Constructora con nombre");
        AsociacionTextos asociacionTextos3 = new AsociacionTextos(nombre);

        assertEquals(nombre, asociacionTextos.getNombre());
        assertTrue(asociacionTextos.getTextosAsociaciados().isEmpty());
        assertTrue(asociacionTextos.getTecladosVinculados().isEmpty());
        assertTrue(asociacionTextos.getFrecuenciaLetras().isEmpty());
    }

    // ---------- GETTERS ----------

    // ---------- SETTERS ----------
    /**
     * - Objetivo de la Prueba:
     *   Verificar que la función agregarTecladoVinculado añade correctamente un teclado vinculado a la instancia de
     *   AsociacionTextos y actualiza la lista de teclados vinculados.
     *
     * - Ficheros Necesarios:
     *   No hay referencia a ficheros en esta función de prueba.
     *
     * - Valores Estudiados:
     *   - Se imprime un mensaje indicando que se está probando la función agregarTecladoVinculado.
     *   - Se crea una instancia de AsociacionTextos.
     *   - Se añaden dos teclados vinculados (nombreT1 y nombreT2) mediante la función agregarTecladoVinculado.
     *   - Se verifica que la lista de teclados vinculados se actualiza correctamente.
     *
     * - Operativa:
     *   1. Imprime un mensaje informativo en la consola indicando que se está probando la función agregarTecladoVinculado.
     *   2. Crea una instancia de AsociacionTextos.
     *   3. Añade dos teclados vinculados (nombreT1 y nombreT2) mediante la función agregarTecladoVinculado.
     *   4. Utiliza aserciones para verificar que la lista de teclados vinculados se actualiza correctamente.
     *   5. Este método es parte de un conjunto más amplio de pruebas unitarias.
     */
    public void TestagregarTecladoVinculado() {
        System.out.println("Test agregarTecladoVinculado");
        String nombreT1 = "Teclado1";
        String nombreT2 = "Teclado2";
        AsociacionTextos asociacionTextos = new AsociacionTextos();

        asociacionTextos.agregarTecladoVinculado(nombreT1);
        asociacionTextos.agregarTecladoVinculado(nombreT2);

        assertEquals(2, asociacionTextos.getTecladosVinculados().size());
        assertTrue(asociacionTextos.getTecladosVinculados().contains(nombreT1));
        assertTrue(asociacionTextos.getTecladosVinculados().contains(nombreT2));
    }

/**
 * Objetivo de la Prueba:
 * La función `TestagregarTexto` tiene como objetivo verificar el correcto funcionamiento
 * del método `agregarTexto` de la clase `AsociacionTextos`. Este método debe agregar
 * un texto a la asociación, actualizando las frecuencias de letras existentes en la asociación.
 *
 * Ficheros Necesarios:
 * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
 * principalmente de las estructuras de datos internas de la clase `AsociacionTextos` y
 * la clase `Frecuencias`.
 *
 * Valores Estudiados:
 * Se evalúan los siguientes aspectos:
 * 1. Se crea una instancia de `AsociacionTextos` con un nombre y frecuencias de letras iniciales.
 * 2. Se crea una instancia de `Frecuencias` con un nombre y frecuencias de palabras y letras.
 * 3. Se agrega la instancia de `Frecuencias` a la asociación mediante el método `agregarTexto`.
 * 4. Se verifica que el texto se haya asociado correctamente mediante la verificación del tamaño
 *    de la lista de textos asociados.
 * 5. Se verifica que las frecuencias de letras en la asociación se hayan actualizado correctamente
 *    según las frecuencias del nuevo texto.
 *
 * Operativa:
 * 1. Se crea una asociación de textos con un nombre y frecuencias de letras iniciales.
 * 2. Se crea un nuevo texto (`Frecuencias`) con un nombre y frecuencias de palabras y letras específicas.
 * 3. Se agrega el nuevo texto a la asociación mediante la invocación del método `agregarTexto`.
 * 4. Se obtiene la lista de textos asociados y se verifica que tenga el tamaño esperado y que contenga
 *    el nombre del texto recién agregado.
 * 5. Se verifican las frecuencias de letras en la asociación para asegurarse de que se hayan actualizado
 *    correctamente según las frecuencias del nuevo texto.
 */
 public void TestagregarTexto(){
        System.out.println("Test agregarTexto");
        String nombre = "Asociacion";
        HashMap<String, Integer> frecuenciaPalabras = new HashMap<String, Integer>();
        frecuenciaPalabras.put("aba", 2);
        frecuenciaPalabras.put("cbc", 4);
        HashMap<String, Integer> frecuenciaLetras = new HashMap<String, Integer>();
        frecuenciaLetras.put("ab", 2);
        frecuenciaLetras.put("bc", 2);
        AsociacionTextos asociacionTextos = new AsociacionTextos(nombre, frecuenciaLetras);

        Frecuencias texto = new Frecuencias("nombre", frecuenciaPalabras, frecuenciaLetras);
        asociacionTextos.agregarTexto(texto);
        List<String> textoAsociados = asociacionTextos.getTextosAsociaciados();

        assertEquals(1, textoAsociados.size());
        assertEquals("nombre", textoAsociados.get(0));
        assertEquals(2, frecuenciaLetras.size());
        assertEquals(4, frecuenciaLetras.get("ab").intValue());
        assertEquals(8, frecuenciaLetras.get("bc").intValue());
    }

    // ---------- AUXILIARES ----------
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
    public void TestBorrarTecladoVinculado() {
        System.out.println("Test borrarTecladoVinculado");
        AsociacionTextos asociacionTextos = new AsociacionTextos();
        String nombreT1 = "Teclado1";
        String nombreT2 = "Teclado2";

        asociacionTextos.agregarTecladoVinculado(nombreT1);
        asociacionTextos.agregarTecladoVinculado(nombreT2);
        asociacionTextos.borrarTecladoVinculado(nombreT1);

        assertEquals(1, asociacionTextos.getTecladosVinculados().size());
        assertFalse(asociacionTextos.getTecladosVinculados().contains(nombreT1));
        assertTrue(asociacionTextos.getTecladosVinculados().contains(nombreT2));
    }

    public void TestborrarTexto() {
        System.out.println("Test borrar Texto");
        String nombre = "Asociacion";
        HashMap<String, Integer> frecuenciaPalabras = new HashMap<String, Integer>();
        frecuenciaPalabras.put("aba", 4);
        frecuenciaPalabras.put("cbc", 8);
        HashMap<String, Integer> frecuenciaLetras = new HashMap<String, Integer>();
        frecuenciaLetras.put("ab", 2);
        frecuenciaLetras.put("bc", 3);
        AsociacionTextos asociacionTextos = new AsociacionTextos(nombre, frecuenciaLetras);

        Frecuencias texto = new Frecuencias("nombre", frecuenciaPalabras, frecuenciaLetras);
        asociacionTextos.borrarTexto("nombre");
        List<String> textoAsociados = asociacionTextos.getTextosAsociaciados();
        HashMap<String, Integer> frecuenciasLetras = asociacionTextos.getFrecuenciaLetras();

        assertEquals(0, textoAsociados.size());
        assertEquals(0, frecuenciaLetras.size());
        assertEquals(0, frecuenciaLetras.get("ab").intValue());
        assertEquals(0, frecuenciaLetras.get("ca").intValue());
    }
}

