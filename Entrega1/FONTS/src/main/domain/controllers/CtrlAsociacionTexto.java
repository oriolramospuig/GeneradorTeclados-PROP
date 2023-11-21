package main.domain.controllers;

import main.domain.classes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar de asociaciones de textos
 * @author
 */
public class CtrlAsociacionTexto
{
    // ---------- PARÁMETROS ----------
    /** Representa conjunto de asociaciones de textos dentro del controlador para gestioanr y manipular los textos */
    private ConjuntoAsociaciones AsociacionesTextos;


    // ---------- CONSTRUCTORA ----------
    /** Inicializa el conjunto de asociaciones de textos */
    public CtrlAsociacionTexto(){
        AsociacionesTextos = new ConjuntoAsociaciones();
    }


    // ---------- FUNCIONES ASOCIACION ----------
    /**
     * No devuelve nada. Manda añadir el nuevo teclado al conjunto de teclados vinculados
     * @param nomA nombre de la asociación de textos
     * @param nomT nombre del teclado a agregar
     */
    public void agregarTecladoVinculado (String nomA, String nomT) {
        AsociacionesTextos.getAsociacionTextos(nomA).agregarTecladoVinculado(nomT);
    }

    /**
     * No devuelve nada. Manda añadir un texto a la asociacion de textos pasada como parámetro
     * @param nomA nombre de la asociación de textos
     * @param texto objeto Texto a agregar
     */
    public void agregarTextoAsociacion (String nomA, Texto texto){
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
    /**
     * Devuelve el conjunto de asociaciones de textos
     * @return Conjunto de asociaciones de textos
     */
    public ConjuntoAsociaciones getCjtAsociaciones() {
        return AsociacionesTextos;
    }

    /**
     * Agrega una nueva asociación de textos al conjunto
     * @param nomAT nombre de la nueva asociación de textos a agregar
     * @return true si la asociación se ha agregado correctamente y false en caso contrario
     */
    public boolean agregarAsociacion(String nomAT){
        if(!AsociacionesTextos.existeAsociaciondeTextos(nomAT)){
            AsociacionTextos asociacionTextos = new AsociacionTextos(nomAT);
            AsociacionesTextos.agregarAsociacionTexto(nomAT, asociacionTextos);
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