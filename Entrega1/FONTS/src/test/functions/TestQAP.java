package test.functions;
import main.domain.classes.functions.Matrices;
import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairFrequency;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.*;
import static org.junit.Assert.*;

public class TestQAP {
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
        int [][] mf = new int[3][3];
        Matrices.generarMatrizDeFrecuencias(paresFrecuencias, teclas, letraAIndice, mf);
        int [][] md = new int [3][3];
        Matrices.generarMatrizDistancias(1,3,md);
        List<Integer> sol = new ArrayList<>();
        QAP qap = new QAP(filas, columnas, mf, md, sol);

        assertEquals(filas, qap.getFilas());
        assertEquals(columnas, qap.getColumnas());
        assertEquals(filas * columnas, qap.getN());
        assertNotNull(qap.getMatrizDistancias());
        assertNotNull(qap.getMatrizFrecuencias());
    }
}
