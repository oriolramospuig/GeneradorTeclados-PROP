
package test.functions;

import main.domain.classes.functions.HungarianAlgorithm;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

public class TestHungarianAlgorithm {
    public void testHungarian() {
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm();
        int[][] c1c2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int result = hungarianAlgorithm.Hungarian(c1c2);
        assertEquals(0, result);
    }
}