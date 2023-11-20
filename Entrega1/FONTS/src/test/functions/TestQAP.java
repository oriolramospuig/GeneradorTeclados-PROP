/*package test.functions;
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
        QAP qap = new QAP(filas, columnas, teclas, paresFrecuencias);

        assertEquals(filas, qap.getFilas());
        assertEquals(columnas, qap.getColumnas());
        assertEquals(filas * columnas, qap.getN());
        assertNotNull(qap.getMatrizDistancias());
        assertNotNull(qap.getMatrizFrecuencias());
        assertNotNull(qap.getTeclasOrdenadas());
        assertNotNull(qap.getLetraAIndice());

        assertEquals(filas * columnas, qap.getTeclasOrdenadas().size());
    }
}*/
