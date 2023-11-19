package test.types;

import main.domain.classes.Algoritmo;
import static org.junit.Assert.assertEquals;

public class TestAlgoritmo {
    public void testEnumValors() {
        assertEquals(Algoritmo.QAP, Algoritmo.valueOf("QAP"));
        assertEquals(Algoritmo.Alg2, Algoritmo.valueOf("Alg2"));
    }

    public void testEnumNums() {
        assertEquals(0, Algoritmo.QAP.ordinal());
        assertEquals(1, Algoritmo.Alg2.ordinal());
    }

    public void testEnumtoString() {
        assertEquals("QAP", Algoritmo.QAP.toString());
        assertEquals("Alg2", Algoritmo.Alg2.toString());
    }

    public void testEnumcambiocaso() {
        Algoritmo algoritmo = Algoritmo.QAP;
        String resultado = "";

        switch (algoritmo) {
            case QAP:
                resultado = "QAP";
                break;
            case Alg2:
                resultado = "Alg2";
                break;
        }

        assertEquals("QAP", resultado);
    }
}