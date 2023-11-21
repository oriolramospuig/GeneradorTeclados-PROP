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
    /**
     * No retorna nada, manda a introducir la puntuación escrita en un Teclado (también pedido)
     */
    public void setPuntuacion(String nomT, Float puntuacion) {
        teclados.getTeclado(nomT).setPuntuacion(puntuacion);
    }
    /**
     * No retorna nada, manda a introducir las dimensiones escritas en un Teclado (también pedido)
     */
    public void setDimensiones(String nomT, PairInt dimensiones) {
        teclados.getTeclado(nomT).setDimensiones(dimensiones);
    }

    /**
     * No retorna nada, manda a vincular un Alfabeto a un Teclado
     */
    public void agregarAlfabetoVinculado(String nomT, String nomA) {
        teclados.getTeclado(nomT).agregarAlfabetoVinculado(nomA);
    }
    /**
     * No retorna nada, manda a vincular una Asociacion de Textos a un Teclado
     */
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
    /**
     * Retorna el objecto cjt de Teclados pedido
     * @return ConjuntoTeclados : Un objeto cjt de Teclados concreto
     */
    public ConjuntoTeclados getCjtTeclados() {
        return teclados;
    }

    /**
     * Retorna booleano de si que existe el teclado pedido en el cjt de teclados
     * @return ConjuntoTeclados : Un objeto cjt de Teclados concreto
     */
    public boolean existeTeclado(String nomT){
        return teclados.existeTeclado(nomT);
    }
    /**
     * No retorna nada.
     * Crea el nuevo objecto Teclado y añade este objeto a ConjuntoTeclados
     */
    public void CrearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto) {
        Teclado teclado = ctrlAlgoritmo.crearTeclado(nomT, asociacionTextos, alfabeto);
        teclados.agregarTeclado(nomT, teclado);
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
