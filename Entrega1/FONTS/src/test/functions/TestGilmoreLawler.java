package test.functions;

import main.domain.classes.functions.GilmoreLawler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

public class TestGilmoreLawler {
    public void TestConstructoraVacia() {
        System.out.println("TestConstructoraVacia");

        GilmoreLawler gilmoreLawler = new GilmoreLawler();
        
        assertEquals(0, gilmoreLawler.getFilas());
        assertEquals(0, gilmoreLawler.getColumnas());
        assertEquals(0, gilmoreLawler.getGlBound());
        assertEquals(0, gilmoreLawler.getMatrizDistancias().length);
        assertEquals(0, gilmoreLawler.getMatrizFrecuencias().length);
        assertEquals(new HashMap<Character, Integer>(), gilmoreLawler.getLetraAIndice());
        assertEquals(new ArrayList<>(), gilmoreLawler.getMejorSolucionParcial());
    }
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

        GilmoreLawler gl = new GilmoreLawler(nf, nc, bound, mf, md, letraAIndice);

        assertEquals(nf, gl.getFilas());
        assertEquals(nc, gl.getColumnas());
        assertArrayEquals(md, gl.getMatrizDistancias());
        assertArrayEquals(mf, gl.getMatrizFrecuencias());
        assertEquals(letraAIndice, gl.getLetraAIndice());
        assertTrue(gl.getMejorSolucionParcial().isEmpty());

    }

    public void testgilmore_lawler() {
        System.out.println("Test Gilmore_Lawler");
        GilmoreLawler gilmoreLawler = new GilmoreLawler();
        List<Character> indices = Arrays.asList('a','b','c');
        int cotaInicial = 0;
        int result = gilmoreLawler.gilmore_lawler();

        assertEquals(0, result);

    }

    public void testimprimirMejorSolucionParcial() {
        System.out.println("Test Imprimir Mejor Solucion Parcial");
        GilmoreLawler gilmoreLawler = new GilmoreLawler();
        gilmoreLawler.setMejorSolucionParcial(Arrays.asList(1, 2, 3, 4));
        ByteArrayOutputStream SalidaEstandar = new ByteArrayOutputStream();
        System.setOut(new PrintStream(SalidaEstandar));
        gilmoreLawler.imprimirMejorSolucionParcial();
        System.setOut(System.out);

        assertEquals("La mejor solución parcial es: Posición 0: Tecla a | Posición 1: Tecla b | Posición 2: Tecla c | Posición 3: Tecla d", SalidaEstandar.toString());
    }
    public void testminimos(){
        System.out.println("Test Minimos");
        GilmoreLawler gilmoreLawler = new GilmoreLawler();
        int[][] c1c2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int resultado = gilmoreLawler.minimos(c1c2);

        assertEquals(6, resultado);
    }
}


