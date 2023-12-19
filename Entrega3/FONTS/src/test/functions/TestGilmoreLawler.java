package test.functions;

import main.domain.classes.functions.GilmoreLawler;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 */
public class TestGilmoreLawler {
    /**
     * Objeto de la Prueba: La prueba tiene como objetivo verificar la correcta inicialización
     * y configuración de una instancia de la clase GilmoreLawler mediante su constructora vacía.
     * Ficheros Necesarios: No se requieren ficheros externos para esta prueba.
     * Valores Estudiados: gilmoreLawler: Instancia de la clase GilmoreLawler creada mediante la constructora vacía.
     * Operativa:
     * 1. Mensaje informativo en consola para identificar la prueba.
     * 2. Creación de la instancia de la clase GilmoreLawler mediante la constructora vacía.
     * 3. Aserciones para verificar la configuración y valores de la instancia de GilmoreLawler.
     */
    @Test
    public void TestConstructoraVacia() {
        System.out.println("TestConstructoraVacia");

        GilmoreLawler gilmoreLawler = new GilmoreLawler();
        
        assertEquals(0, gilmoreLawler.getFilas());
        assertEquals(0, gilmoreLawler.getColumnas());
        assertEquals(0, gilmoreLawler.getGlBound());
        assertEquals(0, gilmoreLawler.getMatrizDistancias().length);
        assertEquals(0, gilmoreLawler.getMatrizFrecuencias().length);
        assertEquals(new ArrayList<>(), gilmoreLawler.getMejorSolucionParcial());
    }

    /**
     * Objeto de la Prueba: La prueba tiene como objetivo verificar la correcta inicialización
     * y configuración de una instancia de la clase GilmoreLawler mediante su constructora.
     * Ficheros Necesarios: No se requieren ficheros externos para esta prueba.
     * Valores Estudiados:
     * - gilmoreLawler: Instancia de la clase GilmoreLawler creada mediante la constructora vacía.
     * - nf : número de filas
     * - nc : número de columnas
     * - bound : cota inicial
     * - mf : matriz de frecuencias
     * - md : matriz de distancias
     * - letraAIndice : Hashmap donde guardo todos los carácteres con sus respectivas frecuencias
     * Operativa:
     * 1. Mensaje informativo en consola para identificar la prueba.
     * 2. Se inicializan los diferentes parámetros necesarios
     * 3. Creación de la instancia de la clase GilmoreLawler mediante la constructora.
     * 4. Aserciones para verificar la configuración y valores de la instancia de GilmoreLawler.
     */
    @Test
    public void TestConstructora() {
        System.out.println("TestConstructora");
        int nf = 3;
        int nc = 3;
        int bound = 10;
        int[][] mf = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] md = {{0, 1, 2}, {1, 0, 3}, {2, 3, 0}};
        HashMap<Character, Integer> letraAIndice = new HashMap<>();
        letraAIndice.put('A', 1);
        letraAIndice.put('B', 2);
        letraAIndice.put('C', 3);

        GilmoreLawler gl = new GilmoreLawler(nf, nc, bound, mf, md);

        assertEquals(nf, gl.getFilas());
        assertEquals(nc, gl.getColumnas());
        assertArrayEquals(md, gl.getMatrizDistancias());
        assertArrayEquals(mf, gl.getMatrizFrecuencias());
        assertTrue(gl.getMejorSolucionParcial().isEmpty());

    }

    /**
     * Objeto de la Prueba: La prueba tiene como objetivo verificar el correcto funcionamiento
     * del método 'gilmore_lawler' de la clase GilmoreLawler.
     * Ficheros Necesarios: No se requieren ficheros externos para esta prueba.
     * Valores Estudiados:
     * - gilmoreLawler: Instancia de la clase GilmoreLawler creada mediante la constructora vacía.
     * - indices: Lista de caracteres que representa los índices utilizados en el método 'gilmore_lawler'.
     * - cotaInicial: Valor inicial utilizado en el método 'gilmore_lawler'.
     * - result: Resultado obtenido al llamar al método 'gilmore_lawler'.
     * Operativa:
     * 1. Mensaje informativo en consola para identificar la prueba.
     * 2. Creación de la instancia de la clase GilmoreLawler mediante la constructora vacía.
     * 3. Definición de la lista de caracteres 'indices'.
     * 4. Definición de la cota inicial.
     * 5. Llamada al método 'gilmore_lawler'.
     * 6. Aserción para verificar que el resultado obtenido coincide con el valor esperado.
     */
    @Test
    public void testgilmore_lawler() {
        System.out.println("Test Gilmore_Lawler");
        GilmoreLawler gilmoreLawler = new GilmoreLawler();
        List<Character> indices = Arrays.asList('a','b','c');
        int cotaInicial = 0;
        int result = gilmoreLawler.gilmore_lawler();

        assertEquals(0, result);

    }

    /**
     * Objeto de la Prueba: La prueba tiene como objetivo verificar el correcto
     * funcionamiento del método 'minimos' de la clase GilmoreLawler.
     * Ficheros Necesarios: No se requieren ficheros externos para esta prueba.
     * Valores Estudiados:
     * - gilmoreLawler: Instancia de la clase GilmoreLawler creada mediante la constructora vacía.
     * - c1c2: Matriz de enteros utilizada como entrada para el método 'minimos'.
     * - resultado: Resultado obtenido al llamar al método 'minimos'.
     * Operativa:
     * 1. Mensaje informativo en consola para identificar la prueba
     * 2. Creación de la instancia de la clase GilmoreLawler mediante la constructora vacía.
     * 3. Definición de la matriz de enteros c1c2.
     * 4. Llamada al método 'minimos' con la matriz c1c2 como argumento.
     * 5. Aserción para verificar que el resultado obtenido coincide con el valor esperado.
     */    @Test
    public void testminimos(){
        System.out.println("Test Minimos");
        GilmoreLawler gilmoreLawler = new GilmoreLawler();
        int[][] c1c2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int resultado = gilmoreLawler.minimos(c1c2);

        assertEquals(12, resultado);
    }

}


