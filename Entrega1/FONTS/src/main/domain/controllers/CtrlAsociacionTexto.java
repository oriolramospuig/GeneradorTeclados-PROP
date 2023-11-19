package main.domain.controllers;

import main.domain.classes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CtrlAsociacionTexto {

    // ---------- PARÁMETROS ----------
    private ConjuntoAsociaciones AsociacionesTextos;

    public CtrlAsociacionTexto(){
        AsociacionesTextos = null;
    }

    // ---------- FUNCIONES ASOCIACION ----------
    /**
     * No retorna nada.
     * Manda añadir el nuevo teclado al cjt de teclados vinculados
     */
    public void agregarTecladoVinculado (String nomA, String nomT){
        AsociacionesTextos.getAsociacionTextos(nomA).agregarTecladoVinculado(nomT);
    }
    /**
     * No retorna nada.
     * Manda añadir un texto a la asociacion de textos pasada como parámetro
     */
    public void agregarTextoAsociacion (String nomA, Texto texto){ //
        AsociacionesTextos.getAsociacionTextos(nomA).agregarTexto(texto);
    }

    //Para la segunda entrega
    /*public void borrarTecladoVinculado (String nomA, String nomT){
        AsociacionesTextos.getAsociacionTextos(nomA).borrarTecladoVinculado(nomT);
    }
    public void borrarTextoAsociacion (String nomA, String nomT){
        AsociacionesTextos.getAsociacionTextos(nomA).borrarTexto(nomT);
    }*/


    // ---------- FUNCIONES CONJUNTOASOCIACIONES ----------
    public ConjuntoAsociaciones getCjtAsociaciones() {
        return AsociacionesTextos;
    }
    public boolean agregarAsociacion(String nomAT){
        if(!AsociacionesTextos.existeAsociaciondeTextos(nomAT)){
            AsociacionTextos asociacionTextos = new AsociacionTextos(nomAT);
            AsociacionesTextos.agregarAsociacionTexto(nomAT, asociacionTextos);
            //crear las frec de palabras?
            return true;
        }
        return false;
    }

    //Para la segunda entrega
    /*public void borrarAsociacionTextos(String nomAT){
        // mirar error d'aquesta linia, diu algo de static
        ArrayList<String> tVinculado = AsociacionesTextos.getAsociacionTextos(nomAT).getTecladosVinculados();
        if(!tVinculado.isEmpty()) {
            for (int i = 0; i < tVinculado.size(); ++i){
                conjuntoTeclados.borrarTeclado(tVinculado.get(i));
            }
        }
        AsociacionesTextos.borrarAsociacionTextos(nomAT);
    }*/
}
