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
    /**
     * Objeto de la Prueba: Validar la implementación del algoritmo húngaro en la clase HungarianAlgorithm.
     * Ficheros Necesarios: No se requieren ficheros externos. Los datos de entrada están definidos en la prueba.
     * Valores Estudiados: Una matriz ejemplo de frecuencias
     * Operativa:
     * 1. Se instancia un objeto de la clase HungarianAlgorithm, que presumiblemente contiene la implementación del algoritmo húngaro.
     * 2. Se llama al método hungarianLeastCost(c1c2) de la instancia creada, pasando la matriz de costos c1c2 como argumento.
     * 3. El método hungarianLeastCost debería devolver el costo mínimo de asignación según el algoritmo húngaro.
     * 4. Se utiliza la aserción assertEquals(128, leastCost) para verificar que el costo mínimo obtenido coincide con el valor esperado.
     */
    @Test
    public void testHungarian() {
        //HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm();
        int[][] c1c2 = {
                {21, 34, 31, 43},
                {20, 35, 32, 44},
                {20, 34, 33, 45},
                {21, 34, 31, 43}
        };
        //int result = hungarianAlgorithm.Hungarian(c1c2);
        HungarianAlgorithm hungarian = new HungarianAlgorithm(c1c2.length);

        // Llamas al método para obtener el costo mínimo de asignación
        int leastCost = hungarian.hungarianLeastCost(c1c2);
        assertEquals(128, leastCost);
    }

    /**
     * Objeto de la Prueba: Validar la implementación del algoritmo húngaro en la clase HungarianAlgorithm.
     * Ficheros Necesarios: No se requieren ficheros externos. Los datos de entrada están definidos en la prueba.
     * Valores Estudiados: Una matriz ejemplo de frecuenciasn (diferente al anterior)
     * Operativa:
     * 1. Se instancia un objeto de la clase HungarianAlgorithm, que presumiblemente contiene la implementación del algoritmo húngaro.
     * 2. Se llama al método hungarianLeastCost(c1c2) de la instancia creada, pasando la matriz de costos c1c2 como argumento.
     * 3. El método hungarianLeastCost debería devolver el costo mínimo de asignación según el algoritmo húngaro.
     * 4. Se utiliza la aserción assertEquals(128, leastCost) para verificar que el costo mínimo obtenido coincide con el valor esperado.
     */
    @Test
    public void testHungarian2() {
        //HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm();
        int[][] c1c2 = {
                {40, 26, 7, 33},
                {23, 37, 15, 21},
                {74, 72, 12, 23},
                {37, 21, 65, 91}
        };
        //int result = hungarianAlgorithm.Hungarian(c1c2);
        HungarianAlgorithm hungarian = new HungarianAlgorithm(c1c2.length);

        // Llamas al método para obtener el costo mínimo de asignación
        int leastCost = hungarian.hungarianLeastCost(c1c2);
        assertEquals(74, leastCost);
    }

    /**
     * Objeto de la Prueba: Validar la implementación del algoritmo húngaro en la clase HungarianAlgorithm.
     * Ficheros Necesarios: No se requieren ficheros externos. Los datos de entrada están definidos en la prueba.
     * Valores Estudiados: Una matriz ejemplo de frecuencias (diferente a los anteriores)
     * Operativa:
     * 1. Se instancia un objeto de la clase HungarianAlgorithm, que presumiblemente contiene la implementación del algoritmo húngaro.
     * 2. Se llama al método hungarianLeastCost(c1c2) de la instancia creada, pasando la matriz de costos c1c2 como argumento.
     * 3. El método hungarianLeastCost debería devolver el costo mínimo de asignación según el algoritmo húngaro.
     * 4. Se utiliza la aserción assertEquals(128, leastCost) para verificar que el costo mínimo obtenido coincide con el valor esperado.
     */
    @Test
    public void testHungarian3() {
        //HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm();
        int[][] c1c2 = {
                {13, 6, 50, 35, 92, 76},
                {48, 24, 68, 30, 13, 30},
                {49, 79, 56, 88, 40, 43},
                {27, 32, 69, 40, 4, 82},
                {19, 53, 56, 97, 69, 55},
                {33, 86, 3, 62, 2, 62}
        };
        //int result = hungarianAlgorithm.Hungarian(c1c2);
        HungarianAlgorithm hungarian = new HungarianAlgorithm(c1c2.length);

        // Llamas al método para obtener el costo mínimo de asignación
        int leastCost = hungarian.hungarianLeastCost(c1c2);
        assertEquals(105, leastCost);
    }
}