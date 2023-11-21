package test;

import main.domain.classes.*;

import java.util.ArrayList;

import main.domain.classes.types.PairInt;
import org.junit.*;

import java.io.*;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import java.lang.IndexOutOfBoundsException;
import java.lang.NegativeArraySizeException;

public class TestTeclado {
    public void TestConstructora1() {
        System.out.println("Test Constructora sin parámetros");
        Teclado teclado = new Teclado();

        assertEquals("", teclado.getNombre());
        assertEquals(0.0, teclado.getPuntuacion());
        assertEquals(Algoritmo.QAP, teclado.getAlgoritmo());
        assertEquals(PairIntEnum.EMPTY_PAIR, teclado.getDimensiones());
        assertEquals("", teclado.getAlfabetoVinculado());
        assertEquals("", teclado.getAsociacionTextosVinculado());
    }

    public void TestConstructora2() {
        System.out.println("Test Constructora con un nombre de parámetro");
        String nombre = "Nombre";
        Teclado teclado = new Teclado(nombre);

        assertEquals(nombre, teclado.getNombre());
        assertEquals(0.0, teclado.getPuntuacion());
        assertEquals(Algoritmo.QAP, teclado.getAlgoritmo());
        assertEquals(PairIntEnum.EMPTY_PAIR, teclado.getDimensiones());
        assertEquals("", teclado.getAlfabetoVinculado());
        assertEquals("", teclado.getAsociacionTextosVinculado());
    }

    public void TestConstructora3() {
        System.out.println("Test Constructora con más parámetros");
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto("Alfabeto");
        Algoritmo algoritmo = Algoritmo.QAP;
        PairInt dimensiones = new PairInt(10, 20);

        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, algoritmo, dimensiones);

        assertEquals(nombre, teclado.getNombre());
        assertEquals(algoritmo, teclado.getAlgoritmo());
        assertEquals(dimensiones, teclado.getDimensiones());
        assertEquals(alfabeto.getNombre(), teclado.getAlfabetoVinculado());
        assertEquals(asociacionTextos.getNombre(), teclado.getAsociacionTextosVinculado());
    }

    ///// GETTERS

    public void testGetDimensiones() {
        System.out.println("Test get Dimensiones");
        Teclado teclado = new Teclado();
        PairInt dimensiones = new PairInt(5, 10);
        teclado.setDimensiones(dimensiones);

        PairInt resultado = teclado.getDimensiones();

        assertEquals(5, resultado.getPrimero().intValue());
        assertEquals(10, resultado.getSegundo().intValue());
    }

    /////SETTERS
    public void testSetPuntuacion() {
        System.out.println("Test set Puntuacion");
        Teclado teclado = new Teclado();
        float puntuacion = 100;

        teclado.setPuntuacion(puntuacion);

        assertEquals(100, teclado.getPuntuacion());
    }

    public void testSetDimensiones() {
        System.out.println("Test set Dimensiones");
        Teclado teclado = new Teclado();
        PairInt dimensiones = new PairInt(5, 10);

        teclado.setDimensiones(dimensiones);

        assertEquals(5, teclado.getDimensiones().getPrimero().intValue());
        assertEquals(10, teclado.getDimensiones().getSegundo().intValue());
    }

    public void testagregarAlfabetovinculado() {
        System.out.println("Test agregar Alfabeto Vinculado");
        Teclado teclado = new Teclado();
        Alfabeto alfabeto = new Alfabeto("nombre");

        teclado.agregarAlfabetoVinculado("nombre");

        assertEquals("nombre", teclado.getAlfabetoVinculado());
    }

    public void testagregarAsociacionTextosVinculado() {
        System.out.println("Test agregar Asociacion Textos Vinculado");
        Teclado teclado = new Teclado();
        AsociacionTextos asociacionTextos = new AsociacionTextos("nombre");

        teclado.agregarAlfabetoVinculado("nombre");

        assertEquals("nombre", teclado.getAsociacionTextosVinculado());
    }

    ///// AUXILIARES

    public void testborrarAsociacionTextosVinculado() {
        System.out.println("Test Borrar Asociacion Textos Vinculado");
        Teclado teclado = new Teclado();
        AsociacionTextos asociacionTextos = new AsociacionTextos("nombre");

        teclado.agregarAsociacionTextosVinculado("nombre");
        teclado.borrarAsociacionTextosVinculados("nombre");

        assertNull(teclado.getAsociacionTextosVinculado());
    }
}

