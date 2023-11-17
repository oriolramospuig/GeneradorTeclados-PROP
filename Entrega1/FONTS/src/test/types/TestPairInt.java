package test.types;

import main.domain.classes.Alfabeto;
import main.domain.classes.types.PairInt;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPairInt {
    // ---------- CONSTRUCTORAS ----------
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");

        PairInt pair = new PairInt(1,2);
        assertNotNull(pair);
        assertEquals(Integer.valueOf(1), pair.getPrimero());
        assertEquals(Integer.valueOf(2), pair.getSegundo());
    }


    @Test
    public void TestSetPrimero() {
        System.out.println("Test setPrimero");

        PairInt pair = new PairInt(1,2);
        pair.setPrimero(3);
        assertEquals(Integer.valueOf(3), pair.getPrimero());
    }

    @Test
    public void TestSetSegundo() {
        System.out.println("Test setSegundo");

        PairInt pair = new PairInt(1,2);
        pair.setSegundo(4);
        assertEquals(Integer.valueOf(4), pair.getSegundo());
    }

    @Test
    public void TestToString() {
        System.out.println("Test toString");

        PairInt pair = new PairInt(1, 2);
        assertEquals("(1,2)", pair.toString());
    }
}