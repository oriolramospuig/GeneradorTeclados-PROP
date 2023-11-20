/*package test;

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
public class TestAsociacionTextos {

    // ---------- CONSTRUCTORAS ----------
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

    // ---------- GETTERS ----------
    public void testgetFrecuenciaLetras() {
        System.out.println("Test getFrecuenciasLetras");
        AsociacionTextos asociacionTextos = new AsociacionTextos();
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("ab", 5);
        frecuenciaLetras.put("bc", 3);
        frecuenciaLetras.put("ca", 2);
        List<PairFrequency> result = asociacionTextos.getFrecuenciaLetras();

        assertEquals(3, result.size());
        /*assertEquals("A", result.get(0).getLetra());
        assertEquals(5, result.get(0).getFrecuencia());

        assertEquals("B", result.get(1).g;
        assertEquals(3, result.get(1).getFrecuencia());
        assertEquals("C", result.get(2).getLetra());
        assertEquals(2, result.get(2).getFrecuencia());
        assertEquals(frecuenciaLetras, asociacionTextos.getFrecuenciaLetras());
    }

    // ---------- SETTERS ----------
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

    public void TestagregarTexto(){
        System.out.println("Test agregarTexto");
        String nombre = "Asociacion";
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("ab", 2);
        frecuenciaLetras.put("ca", 3);
        AsociacionTextos asociacionTextos = new AsociacionTextos(nombre, frecuenciaLetras);

        Frecuencias texto = new Frecuencias("nombre");
        asociacionTextos.agregarTexto(texto);
        List<String> textoAsociados = asociacionTextos.getTextosAsociaciados();
        ArrayList<PairFrequency> frecuenciasLetras = asociacionTextos.getFrecuenciaLetras();

        assertEquals(1, textoAsociados.size());
        assertEquals("nombre", textoAsociados.get(0));
        assertEquals(2, frecuenciaLetras.size());
        assertEquals(3, frecuenciaLetras.get("ca").intValue());
        assertEquals(2, frecuenciaLetras.get("ab").intValue());

    }

    // ---------- AUXILIARES ----------
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
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("ab", 2);
        frecuenciaLetras.put("ca", 3);
        AsociacionTextos asociacionTextos = new AsociacionTextos(nombre, frecuenciaLetras);

        Frecuencias texto = new Frecuencias("nombre");
        asociacionTextos.borrarTexto("nombre");
        List<String> textoAsociados = asociacionTextos.getTextosAsociaciados();
        ArrayList<PairFrequency> frecuenciasLetras = asociacionTextos.getFrecuenciaLetras();

        assertEquals(0, textoAsociados.size());
        assertEquals(0, frecuenciaLetras.size());
        assertEquals(0, frecuenciaLetras.get("ab").intValue());
        assertEquals(0, frecuenciaLetras.get("ca").intValue());
    }
}*/

