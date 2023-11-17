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

    /*public void TestConstructora2() {
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

    public void TestConstructora3(){
        String nombre = "nombre";
        AsociacionTextos asociacionTextos = new AsociacionTextos("Asociaciondetextos");
        Alfabeto alfabeto = new Alfabeto("Alfabeto");
        Algoritmo algoritmo = new Algoritmo();
        PairIntEnum dimensiones = new PairIntEnum(10, 20);

        Teclado teclado = new Teclado(nombre, asociacionTextos, alfabeto, algoritmo, dimensiones);

        assertEquals(nombre, teclado.getNombre());
        assertEquals(algoritmo, teclado.getAlgoritmo());
        assertEquals(dimensiones, teclado.getDimensiones());
        assertEquals(alfabeto.getNombre(), teclado.getAlfabetoVinculado());
        assertEquals(asociacionTextos.getNombre(), teclado.getAsociacionTextosVinculado());
*/

}

