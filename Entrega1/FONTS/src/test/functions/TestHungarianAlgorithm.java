
package test.functions;

import main.domain.classes.functions.HungarianAlgorithm;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

public class TestHungarianAlgorithm {
    @Test
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

    @Test
    public void testNlineas() {
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm();
        int[][] c1c2 = {
                {0, 0, 0, 0},
                {0, 2, 2, 2},
                {0, 1, 3, 3},
                {0, 0, 0, 0}
        };
        boolean result = hungarianAlgorithm.isComplete(c1c2);
        assertEquals(false, result);
    }
}