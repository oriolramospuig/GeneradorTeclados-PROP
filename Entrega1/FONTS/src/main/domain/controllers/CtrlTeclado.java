package main.domain.controllers;


import main.domain.classes.*;
import main.domain.classes.types.PairInt;

import java.util.ArrayList;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar de conjunto teclados, teclado y el controlador del algoritmo
 * @author
 */
public class CtrlTeclado
{
    // ---------- PARÁMETROS ----------
    /** Crea una instancia del conjunto de teclados*/
    private ConjuntoTeclados teclados;

    /** Crea una instancia del conjunto de alfabetos*/
    private CtrlTecladoQAP ctrlAlgoritmo;


    // ---------- CONSTRUCTURAS ----------
    /** Inicialización de la instancia conjunto de teclados vacío.*/
    public CtrlTeclado(){
        teclados = new ConjuntoTeclados();
        ctrlAlgoritmo = new CtrlTecladoQAP();
    }


    // ---------- FUNCIONES TECLADO ----------
    /**
     * No devuelve nada, manda a introducir la puntuación escrita en un Teclado (también pedido)
     */
    public void setPuntuacion(String nomT, Float puntuacion) {
        teclados.getTeclado(nomT).setPuntuacion(puntuacion);
    }

    /**
     * No devuelve nada, manda a introducir las dimensiones escritas en un Teclado (también pedido)
     */
    public void setDimensiones(String nomT, PairInt dimensiones) {
        teclados.getTeclado(nomT).setDimensiones(dimensiones);
    }

    /**
     * No devuelve nada, manda a vincular un Alfabeto a un Teclado
     */
    public void agregarAlfabetoVinculado(String nomT, String nomA) {
        teclados.getTeclado(nomT).agregarAlfabetoVinculado(nomA);
    }

    /**
     * No devuelve nada, manda a vincular una Asociacion de Textos a un Teclado
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
     * Devuelve el objecto cjt de Teclados pedido
     * @return ConjuntoTeclados : Un objeto cjt de Teclados concreto
     */
    public ConjuntoTeclados getCjtTeclados() {
        return teclados;
    }

    /**
     * Devuelve booleano de si que existe el teclado pedido en el cjt de teclados
     * @return ConjuntoTeclados : Un objeto cjt de Teclados concreto
     */
    public boolean existeTeclado(String nomT){
        return teclados.existeTeclado(nomT);
    }

    /**
     * No devuelve nada.
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
