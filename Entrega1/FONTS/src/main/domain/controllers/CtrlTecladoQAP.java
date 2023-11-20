package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.Algoritmo;
import main.domain.classes.AsociacionTextos;
import main.domain.classes.Teclado;
import main.domain.classes.types.PairFrequency;
import main.domain.classes.types.PairInt;

import java.util.ArrayList;

public class CtrlTecladoQAP {
    public Teclado crearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, Algoritmo algoritmo) {
        PairInt dimensiones = new PairInt(0,0);
        //calcular dim
        Teclado teclado = new Teclado(nomT, asociacionTextos, alfabeto, algoritmo,dimensiones);

        //generar matrius
        ArrayList<PairFrequency> frecuencias = asociacionTextos.getFrecuenciaLetrasArray();

        //cridarem qap
        //reconstruir solució (números a lletres)
        return teclado;
    }
}
