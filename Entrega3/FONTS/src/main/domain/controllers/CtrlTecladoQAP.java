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
 * Controlador encargado de crear y configurar teclados utilizando algoritmos de optimización: QAP y Simulated Annealing.
 * El controlador toma información sobre las letras, sus frecuencias y dimensiones del teclado para generar una configuración óptima.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class CtrlTecladoQAP {
    /**
     * Crea un teclado optimizado basado en la asociación de textos y el alfabeto proporcionado.
     * Utiliza algoritmos de optimización (QAP o Simulated Annealing) para determinar la disposición óptima de las teclas.
     * @param nomT Nombre del teclado a crear.
     * @param asociacionTextos Asociación de textos que proporciona las frecuencias de las letras.
     * @param alfabeto Alfabeto que proporciona las letras a incluir en el teclado.
     * @param dim Dimensiones del teclado.
     * @param alg Flag booleano para elegir entre QAP (true) o Simulated Annealing (false).
     * @return Un objeto Teclado configurado óptimamente según el algoritmo seleccionado.
     */
    public Teclado crearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, PairInt dim, boolean alg) {
        ArrayList<Character> letras = alfabeto.getLetras();

        int n = letras.size();
        int nf = dim.getPrimero();
        int nc = dim.getSegundo();

        ArrayList<PairFrequency> frecuencias = asociacionTextos.getFrecuenciaLetrasArray();

        HashMap<Character, Integer> letraAIndice = new HashMap<>();
        for (int i = 0; i < letras.size(); i++) {
            letraAIndice.put(letras.get(i), i);
        }

        int[][] matrizFrecuencias = Matrices.generarMatrizDeFrecuencias(nf*nc, frecuencias, letras, letraAIndice);;

        int [][] matrizDistancias = Matrices.generarMatrizDistancias(nf,nc);

        if (alg) {
            QAP qap = new QAP(nf, nc, matrizFrecuencias, matrizDistancias);
            Teclado teclado = qap.crearTeclado(nomT, asociacionTextos, alfabeto, dim, letraAIndice);
            return teclado;
        }
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(nf, nc, matrizFrecuencias, matrizDistancias);
        Teclado teclado = simulatedAnnealing.crearTeclado(nomT, asociacionTextos, alfabeto, dim, letraAIndice);
        return teclado;
    }
}
