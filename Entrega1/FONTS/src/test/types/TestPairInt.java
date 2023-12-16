package test.types;

import main.domain.classes.Alfabeto;
import main.domain.classes.types.PairInt;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase que testea PairInt.java
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class TestPairInt {
    /**
     * Objeto de la prueba: Test de la constructora de la clase PairInt
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crea un pair, se comprueba que no es nulo y después que está creado correctamente
     * Operativa: Se comprueba que los datos del pair creado son correctos.
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
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crea un pair y se modifica el valor del primer elemento
     * Operativa: Se comprueba que el primer elemento del pair creado es correcto
     */
    @Test
    public void TestSetPrimero() {
        System.out.println("Test setPrimero");

        PairInt pair = new PairInt(1,2);
        pair.setPrimero(3);
        assertEquals(Integer.valueOf(3), pair.getPrimero());
        assertEquals(Integer.valueOf(2), pair.getSegundo());
    }

    /**
     * Objeto de la prueba: Test del método SetSegundo() de la clase PairInt
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
     * Valores estudiados: Estrategia de caja gris. Se crea un pair y se modifica el valor del segundo elemento
     * Operativa: Se comprueba que el segundo elemento del pair creado es correcto
     */
    @Test
    public void TestSetSegundo() {
        System.out.println("Test setSegundo");

        PairInt pair = new PairInt(1,2);
        pair.setSegundo(4);
        assertEquals(Integer.valueOf(1), pair.getPrimero());
        assertEquals(Integer.valueOf(4), pair.getSegundo());
    }

    /**
     * Objeto de la prueba: Test del método ToString() de la clase PairInt
     * Ficheros de datos necesarios: Datos introducidos manualmente. No hace falta ficheros adicionales.
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