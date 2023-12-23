package test.types;

import main.domain.classes.types.PairFrequency;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Clase que testea PairFrequency.java
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestPairFrequency {
    /**
     * Objeto de la prueba: Test de la constructora de la clase PairFrequency.
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se comprueba que los valores insertados al Pair se han añadido correctamente.
     * Operativa: Se escribe un PairFrequency con la clave (string) y una frecuencia (int).
     */
    @Test
    public void TestConstructora() {
        //System.out.println("Test Constructora");

        PairFrequency pairFrequency = new PairFrequency("ae", 4);

        assertNotNull(pairFrequency);
        assertEquals("ae", pairFrequency.getPair());
        assertEquals(4, pairFrequency.getFrequency());
    }
}