package test.types;

import main.domain.classes.types.PairFrequency;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestPairFrequency {
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");

        PairFrequency pairFrequency = new PairFrequency("ae", 4);

        assertNotNull(pairFrequency);
        assertEquals("ae", pairFrequency.getPair());
        assertEquals(4, pairFrequency.getFrequency());
    }
}