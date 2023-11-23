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
import java.util.Map;

import static java.lang.Math.sqrt;

/**
 * Este controlador se encarga de crear un teclado
 * @author Oriol
 */
public class CtrlTecladoQAP {
    public Teclado crearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto) {
        //calcular dim

        // com ens entren caracter espai caracter espai, hem de treure els espais. S'ha de replantejar això, per exemple, tipo lo de com introduir
        // els textos quan els posem per frequència o algo així
        ArrayList<Character> letrasaux = alfabeto.getLetras();
        ArrayList<Character> letras  = new ArrayList<>();
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

        // List<Integer> sol = new ArrayList<>();
        int [][] tec;
        QAP qap = new QAP(nf, nc, matrizFrecuencias, matrizDistancias);
        tec = qap.getTeclado();
        char[][] tecl = new char[tec.length][tec[0].length];
        for (int i = 0; i < tec.length; i++) {
            for (int j = 0; j < tec[i].length; j++) {
                for (Map.Entry<Character, Integer> entry : letraAIndice.entrySet()) {
                    if (entry.getValue().equals(tec[i][j])) {
                        tecl[i][j] = entry.getKey();
                        break;
                    }
                }
            }
        }
        Teclado teclado = new Teclado(nomT, asociacionTextos, alfabeto,dimensiones, tecl);

        return teclado;
    }

    /*esta malament, cal pensar com volem generar la n*/
    public PairInt calculaDimensiones(int n) {
        int nf = 1;
        int nc = n;
        // if (n%2 == 1) nc = nc + 1;
        PairInt dim = new PairInt(nf, nc);
        return dim;
    }
}
