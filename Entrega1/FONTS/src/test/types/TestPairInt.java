package test.types;

import main.domain.classes.Alfabeto;
import main.domain.classes.types.PairInt;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPairInt {
    // ---------- CONSTRUCTORAS ----------
    /**
     * Objeto de la prueba: Test de la constructora de la clase PairInt
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia de caja gris. Se crea un pair, se comprueba que no es nulo y después que ya se ha creado correctamente
     * Operativa: Se comprueba que los datos del Pair creado son correctos
     */
    @Test
    public void TestConstructora() {
        System.out.println("Test Constructora");

        PairInt pair = new PairInt(1,2);
        assertNotNull(pair);
        assertEquals(Integer.valueOf(1), pair.getPrimero());
        assertEquals(Integer.valueOf(2), pair.getSegundo());
    }

    /**
     * Objeto de la prueba: Test del método SetPrimero() de la clase PairInt
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia de caja gris. Se crea un pair y se asegura que el Pair (en este caso del primer valor)
     * Operativa: Se comprueba que el primer dato del Pair creado es correcto
     */
    @Test
    public void TestSetPrimero() {
        System.out.println("Test setPrimero");

        PairInt pair = new PairInt(1,2);
        pair.setPrimero(3);
        assertEquals(Integer.valueOf(3), pair.getPrimero());
    }

    /**
     * Objeto de la prueba: Test del método SetSegundo() de la clase PairInt
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia de caja gris. Se crea un pair y se asegura que el Pair (en este caso del segundo valor)
     * Operativa: Se comprueba que el segundo dato del Pair creado es correcto
     */
    @Test
    public void TestSetSegundo() {
        System.out.println("Test setSegundo");

        PairInt pair = new PairInt(1,2);
        pair.setSegundo(4);
        assertEquals(Integer.valueOf(4), pair.getSegundo());
    }

    /**
     * Objeto de la prueba: Test del método ToString() de la clase PairInt
     * Ficheros de datos necesarios: Datos introducidos manualmente.
     * Valores estudiados: Estrategia de caja gris. Se crea un pair, se convierte a string y se asegura de que se ha hecho correctamente
     * Operativa: Se comprueba que el pair creado se ha pasado correctamente a String
     */
    @Test
    public void TestToString() {
        System.out.println("Test toString");

        PairInt pair = new PairInt(1,2);
        assertEquals("(1,2)", pair.toString());
    }
}