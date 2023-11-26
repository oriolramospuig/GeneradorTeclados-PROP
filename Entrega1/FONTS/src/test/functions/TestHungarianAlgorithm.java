package test.functions;

import main.domain.classes.functions.HungarianAlgorithm;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 */
public class TestHungarianAlgorithm {
    /*@Test
    public void testHungarian() {
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm();
        int[][] c1c2 = {
                {21, 34, 31, 43},
                {20, 35, 32, 44},
                {20, 34, 33, 45},
                {21, 34, 31, 43}
        };
        int result = hungarianAlgorithm.Hungarian(c1c2);
        assertEquals(128, result);
    }

   */

    @Test
    public void testNlineas() {
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm();
        int[][] c1c2 = {
                {0, 0, 0, 0},
                {0, 2, 2, 2},
                {0, 1, 3, 3},
                {0, 0, 0, 0}
        };
        HashMap<Integer,Integer> maxsol = new HashMap<>();
        maxsol.put(0,1);
        maxsol.put(1,3);
        maxsol.put(2,2);
        boolean[] filasCubiertas = new boolean[c1c2.length];
        boolean[] columnasCubiertas = new boolean[c1c2[0].length];
        int result = HungarianAlgorithm.calcularlineas(c1c2,maxsol, filasCubiertas, columnasCubiertas);
        assertEquals(3, result);
    }

    @Test
    public void calcularCosto() {
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm();
        int[][] c1c2 = {
                {21, 34, 31, 43},
                {20, 35, 32, 44},
                {20, 34, 33, 45},
                {21, 34, 31, 43}
        };
        int [][] m = {
                {0, 0, 0, 0},
                {0, 2, 2, 2},
                {0, 1, 3, 3},
                {0, 0, 0, 0}
        };
        HashMap<Integer, Integer> asignacio = new HashMap<Integer,Integer>();
        asignacio.put(0,3);
        asignacio.put(1,0);
        asignacio.put(2,1);
        asignacio.put(3,2);
        int cost = HungarianAlgorithm.calcularCostoAsignacion(asignacio, c1c2);
        assertEquals(128, cost);
    }
}