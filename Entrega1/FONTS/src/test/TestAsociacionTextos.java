/* package test;

import main.domain.classes.AsociacionTextos;
import main.domain.classes.Texto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
public class TestAsociacionTextos {

    //////// CONSTRUCTORAS
    public void TestConstructora() {
        System.out.println("Test Constructora");
        AsociacionTextos asociacionTextos = new AsociacionTextos();

        assertEquals("", asociacionTextos.getNombre());
        assertTrue(asociacionTextos.getTextosAsociaciados().isEmpty());
        assertTrue(asociacionTextos.getTecladosVinculados().isEmpty());
        assertTrue(asociacionTextos.getFrecuenciaLetras().isEmpty());
    }

    public void TestConstructora1() {
        System.out.println("Test Constructora1");
        String nombre = "Asociacion";
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("ab", 2);
        frecuenciaLetras.put("ca", 3);

        AsociacionTextos asociacionTextos = new AsociacionTextos(nombre, frecuenciaLetras);

        assertEquals(nombre, asociacionTextos.getNombre());
        assertEquals(frecuenciaLetras, asociacionTextos.getFrecuenciaLetras());
        assertTrue(asociacionTextos.getTextosAsociaciados().isEmpty());
        assertTrue(asociacionTextos.getTecladosVinculados().isEmpty());
    }

    public void TestConstructora2() {
        System.out.println("Test Constructora2");
        String nombre = "Asociacion";
        AsociacionTextos asociacionTextos = new AsociacionTextos(nombre);

        assertEquals(nombre, asociacionTextos.getNombre());
        assertTrue(asociacionTextos.getTextosAsociaciados().isEmpty());
        assertTrue(asociacionTextos.getTecladosVinculados().isEmpty());
        assertTrue(asociacionTextos.getFrecuenciaLetras().isEmpty());
    }

    /////// GETTERS

    /*public void testGetFrecuenciaLetras() {
        AsociacionTextos asociacionTextos = new AsociacionTextos();

        // Agregar algunas frecuencias de letras para probar
        asociacionTextos.getFrecuenciaLetras().put("ab", 2);
        asociacionTextos.getFrecuenciaLetras().put("ba", 3);
        asociacionTextos.getFrecuenciaLetras().put("cd", 1);

        // Obtener la frecuencia de letras ordenada
        ArrayList<PairFrequency> frecuenciaOrdenada = asociacionTextos.getFrecuenciaLetras();

        // Verificar que la frecuencia se haya ordenado correctamente
        assertEquals(3, frecuenciaOrdenada.get(0).getFrequency());
        assertEquals(2, frecuenciaOrdenada.get(1).getFrequency());
        assertEquals(1, frecuenciaOrdenada.get(2).getFrequency());

        // Puedes agregar más verificaciones según sea necesario
    }

    ///////// SETTERS
    public void testAgregarTexto() {
        AsociacionTextos asociacionTextos = new AsociacionTextos();
        Texto texto = new Texto();
        texto.setTexto("abacaba");
        texto.tratarEntrada();

        // Agregar el texto a la asociación
        asociacionTextos.agregarTexto(texto);

        // Verificar que el texto se haya agregado correctamente
        assertTrue(asociacionTextos.getTextosAsociados().contains(texto.getNombre()));

        // Verificar que las frecuencias de letras se hayan actualizado correctamente
        HashMap<String, Integer> frecuenciaLetrasAsociacion = asociacionTextos.getFrecuenciaLetras();
        assertEquals(2, frecuenciaLetrasAsociacion.get("ab"));
        assertEquals(3, frecuenciaLetrasAsociacion.get("ba"));
        assertEquals(2, frecuenciaLetrasAsociacion.get("ac"));
        assertEquals(1, frecuenciaLetrasAsociacion.get("ca"));
    }
}
*/