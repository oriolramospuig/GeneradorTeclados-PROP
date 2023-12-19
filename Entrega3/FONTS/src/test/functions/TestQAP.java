package test.functions;
import main.domain.classes.functions.Matrices;
import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairFrequency;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.*;
import static org.junit.Assert.*;

/**
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 */
public class TestQAP {
    @Test
    public void testConstructora() {
        System.out.println("Test Constructora");
        int filas = 3;
        int columnas = 3;
        List<Character> teclas = Arrays.asList('a', 'b', 'c');
        List<PairFrequency> paresFrecuencias = Arrays.asList(
                new PairFrequency("ab", 3),
                new PairFrequency("bc", 2),
                new PairFrequency("ca", 1)
        );
        HashMap<Character, Integer> letraAIndice = new HashMap<>();
        for (int i = 0; i < teclas.size(); i++) {
            letraAIndice.put(teclas.get(i), i);
        }
        int [][] mf = Matrices.generarMatrizDeFrecuencias(9, paresFrecuencias, teclas, letraAIndice);
        int [][] md = Matrices.generarMatrizDistancias(3,3);
        List<Integer> sol = new ArrayList<>();
        int [][] tec = new int[filas][columnas];
        QAP qap = new QAP(filas, columnas, mf, md, 0);
        tec = qap.getTeclado();

        assertEquals(filas, qap.getFilas());
        assertEquals(columnas, qap.getColumnas());
        assertEquals(filas * columnas, qap.getN());
        assertNotNull(qap.getMatrizDistancias());
        assertNotNull(qap.getMatrizFrecuencias());
    }

    @Test
    public void TestAlgortimoQAP() {

        List<Character> teclas = new ArrayList<>();
        for(char c = 'a'; c <= 'l'; c++) { // Asumiendo un alfabeto de 'a' a 'l'
            teclas.add(c);
        }
        /*llista de freuencies ordenades decreixentment*/
        List<PairFrequency> frecuenciasPares = new ArrayList<>();
        frecuenciasPares.add(new PairFrequency("ia", 10000));
        frecuenciasPares.add(new PairFrequency("ab", 400)); // Frecuencia del par AB
        frecuenciasPares.add(new PairFrequency("bc", 300)); // Frecuencia del par BC
        frecuenciasPares.add(new PairFrequency("ac", 200));
        frecuenciasPares.add(new PairFrequency("ad", 150));
        frecuenciasPares.add(new PairFrequency("bd", 100));
        frecuenciasPares.add(new PairFrequency("be", 75)); // y así sucesivamente...
        frecuenciasPares.add(new PairFrequency("cd", 60));
        frecuenciasPares.add(new PairFrequency("de", 50));
        frecuenciasPares.add(new PairFrequency("df", 40));
        frecuenciasPares.add(new PairFrequency("ef", 30));
        frecuenciasPares.add(new PairFrequency("fg", 20));
        frecuenciasPares.add(new PairFrequency("gh", 10));
        frecuenciasPares.add(new PairFrequency("hi", 5));

        /*numero de files i de columnes*/
        int nf = 3;
        int nc = 4;

        HashMap<Character, Integer> letraAIndice = new HashMap<>();
        for (int i = 0; i < teclas.size(); i++) {
            letraAIndice.put(teclas.get(i), i);
        }
        /*les dues matrius que s'han de generar, una a partir de frecuencies, l'altre a partir del teclat seleccionat(mides)*/
        int[][] matrizFrecuencias = Matrices.generarMatrizDeFrecuencias(nf*nc, frecuenciasPares, teclas, letraAIndice);;

        int [][] matrizDistancias = Matrices.generarMatrizDistancias(nf,nc);
        /*creadora de la classe qap nova, per que poguem provar amb lo que ha dit a classe*/
        List<Integer> sol = new ArrayList<>();
        int [][] tec = new int[nf][nc];
        QAP qap = new QAP(nf, nc, matrizFrecuencias, matrizDistancias, 0);
        tec = qap.getTeclado();
    }
}
