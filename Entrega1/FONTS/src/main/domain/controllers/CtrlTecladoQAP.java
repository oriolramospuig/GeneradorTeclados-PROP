package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.AsociacionTextos;
import main.domain.classes.Teclado;
import main.domain.classes.functions.GilmoreLawler;
import main.domain.classes.functions.Matrices;
import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairFrequency;
import main.domain.classes.types.PairInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.sqrt;

/**
 * Este controlador se encarga de crear un teclado
 * @author Oriol
 */
public class CtrlTecladoQAP {
    public Teclado crearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto) {
        //calcular dim

        ArrayList<Character> letrasaux = alfabeto.getLetras();
        ArrayList<Character> letras  =new ArrayList<>();
        for (int i = 0; i < letrasaux.size(); ++i) {
            if (letrasaux.get(i) != ' ') {
                letras.add(letrasaux.get(i));
            }
        }
        int n = letras.size();
        PairInt dimensiones = calculaDimensiones(n);
        int nf = dimensiones.getPrimero();
        int nc = dimensiones.getSegundo();

        // HashMap<String, Integer> frecuenciasLetras = asociacionTextos.getFrecuenciaLetras();
        ArrayList<PairFrequency> frecuencias = asociacionTextos.getFrecuenciaLetrasArray();

        HashMap<Character, Integer> letraAIndice = new HashMap<>();
        for (int i = 0; i < letras.size(); i++) {
            letraAIndice.put(letras.get(i), i);
        }
        int[][] matrizFrecuencias = new int[nf*nc][nf*nc];
        Matrices.generarMatrizDeFrecuencias(frecuencias, letras, letraAIndice, matrizFrecuencias);

        int [][] matrizDistancias = new int[nf*nc][nf*nc];
        Matrices.generarMatrizDistancias(nf,nc,matrizDistancias);

        List<Integer> sol = new ArrayList<>();
        int [][] tec = new int[nf][nc];
        QAP qap = new QAP(nf, nc, matrizFrecuencias, matrizDistancias);
        for (int i = 0; i < sol.size(); ++i) {
            int posicion = sol.get(i);
            System.out.println("Posición " + posicion + ": Elemento " + i + " | ");
        }
        tec = qap.getTec();
        Teclado teclado = new Teclado(nomT, asociacionTextos, alfabeto,dimensiones);

        //reconstruir solució (números a lletres)
        return teclado;
    }

    /*esta malament, genera 3*4 per 10 tecles i volem que generi 2*5*/
    public PairInt calculaDimensiones(int n) {
        int nf = n/2;
        int nc = n/2;
        if (n%2 == 1) nc = nc + 1;
        PairInt dim = new PairInt(nf, nc);
        return dim;
    }
}
