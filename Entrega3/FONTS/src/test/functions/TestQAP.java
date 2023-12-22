package test.functions;
import main.domain.classes.functions.Matrices;
import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairFrequency;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.*;
import static org.junit.Assert.*;

/**
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 */
public class TestQAP {
    /**
     * Objeto de la Prueba: La prueba tiene como objetivo verificar la correcta
     * inicialización y configuración de una instancia de la clase QAP (Quadratic Assignment Problem) utilizando su constructora.
     * Ficheros necesarios: No se requieren ficheros externos para esta prueba.
     * Valores Estudiados:
     * - filas: Número de filas para la configuración de la instancia de QAP.
     * - columnas: Número de columnas para la configuración de la instancia de QAP.
     * - teclas: Lista de caracteres que representan las teclas disponibles.
     * - paresFrecuencias: Lista de pares de frecuencias (PairFrequency) para la generación de la matriz de frecuencias.
     * - letraAIndice: Mapa que asigna a cada letra su índice correspondiente.
     * - mf: Matriz de frecuencias generada a partir de pares de frecuencias, teclas y letraAIndice.
     * - md: Matriz de distancias generada con dimensiones (3x3).
     * - sol: Lista para almacenar la solución (teclado) generada por la instancia de QAP.
     * Operativa:
     * 1. Mensaje informativo en consola para identificar la prueba.
     * 2. Definición de los parámetros para la configuración de la instancia de QAP.
     * 3. Inicialización de la instancia de HashMap letraAIndice y generación de la matriz de frecuencias (mf).
     * 4. Generación de la matriz de distancias (md).
     * 5. Inicialización de la lista sol y la matriz tec.
     * 6. Creación de la instancia de QAP con los parámetros definidos.
     * 7. Obtención de la matriz de teclado generada por la instancia de QAP.
     * 8. Aserciones para verificar la configuración y valores de la instancia de QAP.
     */
    @Test
    public void testConstructora() {
        System.out.println("Test Constructora");
        int filas = 3;
        int columnas = 3;
        List<Character> teclas = Arrays.asList('a', 'b', 'c');
        List<PairFrequency> paresFrecuencias = Arrays.asList(
                new PairFrequency("ab", 3),
                new PairFrequency("bc", 2),
                new PairFrequency("ca", 1)
        );
        HashMap<Character, Integer> letraAIndice = new HashMap<>();
        for (int i = 0; i < teclas.size(); i++) {
            letraAIndice.put(teclas.get(i), i);
        }
        int [][] mf = Matrices.generarMatrizDeFrecuencias(9, paresFrecuencias, teclas, letraAIndice);
        int [][] md = Matrices.generarMatrizDistancias(3,3);
        List<Integer> sol = new ArrayList<>();
        int [][] tec = new int[filas][columnas];
        QAP qap = new QAP(filas, columnas, mf, md);
        tec = qap.getTeclado();

        assertEquals(filas, qap.getFilas());
        assertEquals(columnas, qap.getColumnas());
        assertEquals(filas * columnas, qap.getN());
        assertNotNull(qap.getMatrizDistancias());
        assertNotNull(qap.getMatrizFrecuencias());
    }

    /**
     * Objetivo de la prueba: Verificar que el algoritmo QAP genera un diseño de teclado
     * que minimiza la función objetivo, considerando las frecuencias de pares de letras y las distancias entre teclas.
     * Ficheros necesarios: Ninguno.
     * Valores necesarios:
     *   - Teclas disponibles: {'a', 'b', 'c', 'd', 'e', 'f'}.
     *   - Frecuencias de pares de letras ordenadas decrecientemente:
     *        - {"ab": 400, "bc": 300, "ac": 200, "ad": 150, "bd": 100, "be": 75, "cd": 60, "de": 50, "df": 40, "ef": 30}.
     *   - Número de filas y columnas en el teclado: nf = 2, nc = 4.
     * Operativa:
     *   1. Se crea una lista de teclas disponibles ('a' a 'f' asumiendo un alfabeto de 'a' a 'l').
     *   2. Se crea una lista de frecuencias de pares de letras ordenadas decrecientemente.
     *   3. Se establece el número de filas (nf) y columnas (nc) del teclado.
     *   4. Se crea un mapa que asigna cada letra a su índice correspondiente.
     *   5. Se generan dos matrices necesarias para el algoritmo QAP:
     *        - Matriz de frecuencias a partir de las frecuencias de pares de letras.
     *        - Matriz de distancias a partir del número de filas y columnas en el teclado.
     *   6. Se crea una instancia de la clase QAP con las matrices generadas.
     *   7. Se obtiene el diseño de teclado generado por el algoritmo QAP.
     */
    @Test
    public void TestAlgortimoQAP() {

        List<Character> teclas = new ArrayList<>();
        for(char c = 'a'; c <= 'f'; c++) { // Asumiendo un alfabeto de 'a' a 'l'
            teclas.add(c);
        }
        /*llista de freuencies ordenades decreixentment*/
        List<PairFrequency> frecuenciasPares = new ArrayList<>();
        frecuenciasPares.add(new PairFrequency("ab", 400)); // Frecuencia del par AB
        frecuenciasPares.add(new PairFrequency("bc", 300)); // Frecuencia del par BC
        frecuenciasPares.add(new PairFrequency("ac", 200));
        frecuenciasPares.add(new PairFrequency("ad", 150));
        frecuenciasPares.add(new PairFrequency("bd", 100));
        frecuenciasPares.add(new PairFrequency("be", 75)); // y así sucesivamente...
        frecuenciasPares.add(new PairFrequency("cd", 60));
        frecuenciasPares.add(new PairFrequency("de", 50));
        frecuenciasPares.add(new PairFrequency("df", 40));
        frecuenciasPares.add(new PairFrequency("ef", 30));

        /*numero de files i de columnes*/
        int nf = 2;
        int nc = 4;

        HashMap<Character, Integer> letraAIndice = new HashMap<>();
        for (int i = 0; i < teclas.size(); i++) {
            letraAIndice.put(teclas.get(i), i);
        }
        /*les dues matrius que s'han de generar, una a partir de frecuencies, l'altre a partir del teclat seleccionat(mides)*/
        int[][] matrizFrecuencias = Matrices.generarMatrizDeFrecuencias(nf*nc, frecuenciasPares, teclas, letraAIndice);;

        int [][] matrizDistancias = Matrices.generarMatrizDistancias(nf,nc);
        /*creadora de la classe qap nova, per que poguem provar amb lo que ha dit a classe*/
        List<Integer> sol = new ArrayList<>();
        int [][] tec = new int[nf][nc];
        QAP qap = new QAP(nf, nc, matrizFrecuencias, matrizDistancias);
        tec = qap.getTeclado();
    }
}
