package main.domain.controllers;

import main.domain.classes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CtrlAsociacionTexto {

    // ---------- PARÁMETROS ----------
    private ConjuntoAsociaciones AsociacionesTextos;
    private AsociacionTextos AsociacionExistente;
    private ConjuntoTeclados conjuntoTeclados;
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
     * Manda borrar un teclado al cjt de teclados vinculados
     */
    public void borrarTecladoVinculado (String nomA, String nomT){
        AsociacionesTextos.getAsociacionTextos(nomA).borrarTecladoVinculado(nomT);
    }
    /**
     * No retorna nada.
     * Manda añadir un texto a la asociacion de textos pasada como parámetro
     */
    public void agregarTextoAsociacion (String nomA, Texto texto){ //
        AsociacionesTextos.getAsociacionTextos(nomA).agregarTexto(texto);
    }
    /**
     * No retorna nada.
     * Manda borrar un texto de la asociacion de textos pasada como parámetro
     */
    public void borrarTextoAsociacion (String nomA, String nomT){
        AsociacionesTextos.getAsociacionTextos(nomA).borrarTexto(nomT);
    }


    // ---------- FUNCIONES CONJUNTOASOCIACIONES ----------
    public ConjuntoAsociaciones getCjtAsociaciones() {
        return AsociacionesTextos;
    }
    /**
     * No retorna nada.
     * Crea el nuevo objecto Asociación y añade este objeto a ConjuntoAsociaciones
     */
    /*public boolean CrearAsociacionTextos(String nomAT, HashMap<String, Integer> frecuenciaLetras) {
        if(!AsociacionesTextos.existeAsociaciondeTextos(nomAT)){
            HashMap<String, Integer> frecLetras = new HashMap<>();

            //for (char c:entradaCaracteres.toCharArray()) {
            //agregar frecLetras

            AsociacionTextos AT = new AsociacionTextos(nomAT, frecuenciaLetras);
            AsociacionesTextos.agregarAsociacionTexto(nomAT,AT);
            return true;
        }
        return false;
    }*/

    public boolean agregarAsociacion(String nomAT){
        if(!AsociacionesTextos.existeAsociaciondeTextos(nomAT)){
            AsociacionTextos asociacionTextos = new AsociacionTextos(nomAT);
            AsociacionesTextos.agregarAsociacionTexto(nomAT, asociacionTextos);
            return true;
        }
        return false;
    }
    /**
     * No retorna nada.
     * Manda borrar la asociación dada, desvincula los teclados asociados
     * también borra esta asociación de la lista de ConjuntoAlfabetos
     */
    public void borrarAsociacionTextos(String nomAT){
        // mirar error d'aquesta linia, diu algo de static
        ArrayList<String> tVinculado = AsociacionesTextos.getAsociacionTextos(nomAT).getTecladosVinculados();
        if(!tVinculado.isEmpty()) {
            for (int i = 0; i < tVinculado.size(); ++i){
                conjuntoTeclados.borrarTeclado(tVinculado.get(i));
            }
        }
        AsociacionesTextos.borrarAsociacionTextos(nomAT);
    }
}
