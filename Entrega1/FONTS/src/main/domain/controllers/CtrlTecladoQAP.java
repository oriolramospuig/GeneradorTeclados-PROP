package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.Algoritmo;
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

public class CtrlTecladoQAP {
    public Teclado crearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, Algoritmo algoritmo) {
        //calcular dim

        ArrayList<Character> letras = alfabeto.getLetras();
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
        QAP qap = new QAP(nf, nc, matrizFrecuencias, matrizDistancias, sol);

        Teclado teclado = new Teclado(nomT, asociacionTextos, alfabeto, algoritmo,dimensiones);

        //cridarem qap
        //reconstruir solució (números a lletres)
        return teclado;
    }

    public PairInt calculaDimensiones(int n) {
        double raiz = sqrt(n);
        int r = (int)raiz;
        int nf;
        int nc;
        if(raiz == r) {
            nf = nc = r;
        }
        else {
            nf = r;
            nc = nf + 1;
        }
        PairInt dim = new PairInt(nf,nc);
        return dim;
    }

    public HashMap<String,Integer> ordenarFrecuencias(HashMap<String,Integer> frecLetras) {
        return frecLetras;
    }
}
