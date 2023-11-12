package main.domain.controllers;


import main.domain.classes.*;
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

    public void setDimensiones(String nomT, PairIntEnum dimensiones) {
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
    public void agregarTeclado(String nomT, Teclado teclado) {
        teclados.put(nomT, teclado);
    }

    public ConjuntoTeclados getCjtTeclados() {
        return teclados;
    }

    public boolean CrearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, Algoritmo algoritmo, PairIntEnum dimensiones) {
        if (!teclados.existeTeclado(nomT)) {
            Teclado teclado = new Teclado(nomT, asociacionTextos, alfabeto, algoritmo, dimensiones);
            teclados.agregarTeclado(nomT, teclado);
            return true;
        }
        return false;
    }

    public void borrarTeclado(String nomT) {
        String alfabetoVinculado = teclados.getTeclado(nomT).getAlfabetoVinculado();
        if (!alfabetoVinculado.isEmpty()) alfabetos.borrarAlfabeto(alfabetoVinculado);
        teclados.borrarTeclado(alfabetoVinculado);

        String asociacionTextosVinculado = teclados.getTeclado(nomT).getAsociacionTextosVinculado();
        if (!asociacionTextosVinculado.isEmpty()) asociacionesTextos.borrarAsociacionTextos(asociacionTextosVinculado);
        teclados.borrarTeclado(asociacionTextosVinculado);
    }
}
