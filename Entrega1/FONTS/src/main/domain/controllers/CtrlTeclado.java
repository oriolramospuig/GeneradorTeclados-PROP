package main.domain.controllers;


import main.domain.classes.*;
import main.domain.classes.types.PairInt;

import java.util.ArrayList;

public class CtrlTeclado {

    // ---------- PARÁMETROS ----------
    /**
     * Parámetros de la clase Teclado y ConjuntoTeclados
     */
    private ConjuntoAsociaciones asociacionesTextos;

    private ConjuntoAlfabetos alfabetos;

    private ConjuntoTeclados teclados;

    /**
     * Asigna un alfabeto y un cjt de alfabetos vacío
     */
    public CtrlTeclado(){
        teclados = null;
    }

    // ---------- FUNCIONES TECLADO ----------
    public void setPuntuacion(String nomT, Float puntuacion) {
        teclados.getTeclado(nomT).setPuntuacion(puntuacion);
    }

    public void setDimensiones(String nomT, PairInt dimensiones) {
        teclados.getTeclado(nomT).setDimensiones(dimensiones);
    }

    public void agregarAlfabetoVinculado(String nomT, String nomA) {
        teclados.getTeclado(nomT).agregarAlfabetoVinculado(nomA);
    }

    public void agregarAsociacionTextosVinculado(String nomT, String nomAT) {
        teclados.getTeclado(nomT).agregarAsociacionTextosVinculado(nomAT);
    }

    public void borrarAlfabetoVinculado(String nomT, String nomA) {
        teclados.getTeclado(nomT).borrarAlfabetoVinculado(nomA);
    }

    public void borrarAsociacionTextosVinculados(String nomT, String nomAT) {
        teclados.getTeclado(nomT).borrarAsociacionTextosVinculados(nomAT);
    }


    // ---------- FUNCIONES CONJUNTOTECLADOS ----------
    public ConjuntoTeclados getCjtTeclados() {
        return teclados;
    }

    public boolean CrearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, Algoritmo algoritmo, PairInt dimensiones) {
        if (!teclados.existeTeclado(nomT)) {
            Teclado teclado = new Teclado(nomT, asociacionTextos, alfabeto, algoritmo, dimensiones);
            teclados.agregarTeclado(nomT, teclado);
            return true;
        }
        return false;
    }

    public String TecladoTieneAlfabetoVinculado(String nomT){
        return teclados.getTeclado(nomT).getAlfabetoVinculado();
    }
    public String TecladoTieneAsociacionVinculada(String nomA){
        return teclados.getTeclado(nomA).getAsociacionTextosVinculado();
    }

    public void borrarTeclado(String nomT) {
        //String alfabetoVinculado = teclados.getTeclado(nomT).getAlfabetoVinculado();
        //if (!alfabetoVinculado.isEmpty()) alfabetos.borrarAlfabeto(alfabetoVinculado);
        teclados.borrarTeclado(nomT);

        //String asociacionTextosVinculado = teclados.getTeclado(nomT).getAsociacionTextosVinculado();
        //if (!asociacionTextosVinculado.isEmpty()) asociacionesTextos.borrarAsociacionTextos(asociacionTextosVinculado);
    }
}
