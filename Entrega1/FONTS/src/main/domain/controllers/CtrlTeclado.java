package main.domain.controllers;


import main.domain.classes.*;
import main.domain.classes.types.PairInt;

import java.util.ArrayList;

public class CtrlTeclado {

    // ---------- PARÁMETROS ----------
    private ConjuntoTeclados teclados;

    private CtrlTecladoQAP ctrlAlgoritmo;
    /**
     * Asigna un cjt de alfabetos vacío
     */
    public CtrlTeclado(){
        teclados = new ConjuntoTeclados();
        ctrlAlgoritmo = new CtrlTecladoQAP();
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

    //Para la segunda entrega
    /*public void borrarAlfabetoVinculado(String nomT, String nomA) {
        teclados.getTeclado(nomT).borrarAlfabetoVinculado(nomA);
    }
    public void borrarAsociacionTextosVinculados(String nomT, String nomAT) {
        teclados.getTeclado(nomT).borrarAsociacionTextosVinculados(nomAT);
    }*/


    // ---------- FUNCIONES CONJUNTOTECLADOS ----------
    public ConjuntoTeclados getCjtTeclados() {
        return teclados;
    }

    public int CrearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, Algoritmo algoritmo) {
        if (!teclados.existeTeclado(nomT)) {
            ctrlAlgoritmo.crearTeclado(nomT, asociacionTextos, alfabeto, algoritmo);
            Teclado teclado = new Teclado(nomT, asociacionTextos, alfabeto, algoritmo);
            teclados.agregarTeclado(nomT, teclado);
            return 0;
        }
        return -1;
    }

    //Para la segunda entrega
    /*public String TecladoTieneAlfabetoVinculado(String nomT){
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
    }*/
}
