package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.AsociacionTextos;
import main.domain.classes.Teclado;
import main.domain.classes.functions.GilmoreLawler;
import main.domain.classes.functions.Matrices;
import main.domain.classes.functions.QAP;
import main.domain.classes.functions.SimulatedAnnealing;
import main.domain.classes.types.PairFrequency;
import main.domain.classes.types.PairInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.sqrt;

/**
 * Este controlador se encarga de crear un teclado
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class CtrlTecladoQAP {
    public Teclado crearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, PairInt dim, boolean alg) {

        ArrayList<Character> letras = alfabeto.getLetras();
        for (int i = 0; i < letras.size(); ++i) {
            System.out.print(letras.get(i) + " ");
        }

        int n = letras.size();
        int nf = dim.getPrimero();
        int nc = dim.getSegundo();

        // HashMap<String, Integer> frecuenciasLetras = asociacionTextos.getFrecuenciaLetras();
        ArrayList<PairFrequency> frecuencias = asociacionTextos.getFrecuenciaLetrasArray();

        HashMap<Character, Integer> letraAIndice = new HashMap<>();
        for (int i = 0; i < letras.size(); i++) {
            letraAIndice.put(letras.get(i), i);
        }

        int[][] matrizFrecuencias = Matrices.generarMatrizDeFrecuencias(nf*nc, frecuencias, letras, letraAIndice);;
        for (int i = 0; i < matrizFrecuencias.length; ++i) {
            for (int j = 0; j < matrizFrecuencias.length; ++j) {
                System.out.print(matrizFrecuencias[i][j]);
            }
            System.out.println();
        }

        int [][] matrizDistancias = Matrices.generarMatrizDistancias(nf,nc);

        if (alg) {
            // List<Integer> sol = new ArrayList<>();
            int [][] tec;
            QAP qap = new QAP(nf, nc, matrizFrecuencias, matrizDistancias, 0);
            tec = qap.getTeclado();
            char[][] tecl = new char[tec.length][tec[0].length];
            int puntuacion = qap.getGlBound();
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
            Teclado teclado = new Teclado(nomT, asociacionTextos, alfabeto, dim, tecl, puntuacion);

            return teclado;
        }
        int [][] tecSA;
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(nf, nc, matrizFrecuencias, matrizDistancias);
        int p = simulatedAnnealing.getPuntuacionFinal();
        tecSA = simulatedAnnealing.getTecFinal();
        char[][] contenido = new char[tecSA.length][tecSA[0].length];
        for (int i = 0; i < tecSA.length; i++) {
            for (int j = 0; j < tecSA[i].length; j++) {
                for (Map.Entry<Character, Integer> entry : letraAIndice.entrySet()) {
                    if (entry.getValue().equals(tecSA[i][j])) {
                        contenido[i][j] = entry.getKey();
                        break;
                    }
                }
            }
        }
        Teclado tecladoSA = new Teclado(nomT, asociacionTextos, alfabeto, dim, contenido, p);
        return tecladoSA;
    }
}
