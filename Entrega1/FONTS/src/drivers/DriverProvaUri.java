package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.functions.GilmoreLawler;
import main.domain.classes.functions.InOut;
import main.domain.classes.functions.Matrices;
import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairFrequency;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
/**
 * Este driver sirve para ...
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class DriverProvaUri {

    InOut inOut;
    private ConjuntoAlfabetos conjuntoAlfabetos;

    public DriverProvaUri() {
        inOut = new InOut();
        conjuntoAlfabetos = new ConjuntoAlfabetos();
    }

    void imprimirPruebaQAP() {
        System.out.println("Se generará un teclado aleatorio de 3*3 con las letras de la A a la I: ");
        System.out.println();

        /* llista de caracters de l'alfabet = "tecles"*/

        List<Character> teclas = new ArrayList<>();
        for(char c = 'a'; c <= 'l'; c++) { // Asumiendo un alfabeto de 'a' a 'l'
            teclas.add(c);
        }
        /*llista de freuencies ordenades decreixentment*/
        List<PairFrequency> frecuenciasPares = new ArrayList<>();
        frecuenciasPares.add(new PairFrequency("ia", 10000));
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
        frecuenciasPares.add(new PairFrequency("fg", 20));
        frecuenciasPares.add(new PairFrequency("gh", 10));
        frecuenciasPares.add(new PairFrequency("hi", 5));

        /*numero de files i de columnes*/
        int nf = 3;
        int nc = 4;

        /*aixo serveix per enlloc de tractar lletres a, b, c ... tractar números 1, 2, 3... a la tornada de l'algoritme
        * ho tornem a lletres.*/
        HashMap<Character, Integer> letraAIndice = new HashMap<>();
        for (int i = 0; i < teclas.size(); i++) {
            letraAIndice.put(teclas.get(i), i);
        }
        /*les dues matrius que s'han de generar, una a partir de frecuencies, l'altre a partir del teclat seleccionat(mides)*/
        int[][] matrizFrecuencias = new int[nf*nc][nf*nc];
        Matrices.generarMatrizDeFrecuencias(frecuenciasPares, teclas, letraAIndice, matrizFrecuencias);

        int [][] matrizDistancias = new int[nf*nc][nf*nc];
        Matrices.generarMatrizDistancias(nf,nc,matrizDistancias);
        /*creadora de la classe qap nova, per que poguem provar amb lo que ha dit a classe*/
        QAP qap = new QAP(nf, nc, matrizFrecuencias, matrizDistancias);
    }



    public static void main(String[] args) {
        DriverProvaUri driver = new DriverProvaUri();
        muestraMetodos();
        String metodo = driver.inOut.leerString();
        while (!metodo.equals("0") && !metodo.equals("Salir")) {
            switch (metodo) {
                case "9":
                case "PruebaQAP": {
                    driver.imprimirPruebaQAP();
                    break;
                }
                default: {
                    System.out.println("Método no reconocido");
                    break;
                }
            }
            driver.volverMenu();
            muestraMetodos();
            metodo = driver.inOut.leerString();
        }
        driver.inOut.cerrarScanner();
    }

    private static void muestraMetodos() {
        System.out.println("(9|PruebaQAP) - Prueba QAP");
        System.out.println();
        System.out.println("(0|Salir) - Cerrar Driver");
    }

    private void volverMenu() {
        System.out.println("Pulsa ENTER para volver al menú principal");
        inOut.leerString();
    }
}
