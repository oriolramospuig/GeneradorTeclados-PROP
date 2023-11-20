package main.domain.controllers;

import main.domain.classes.*;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar i borrar alfabetos
 * Los alfabetos existentes quedarán dentro de un ...
 *
 */
public class CtrlTexto {

    // ---------- PARÁMETROS ----------
    /**
     * Parámetros de la clase Alfabeto y ConjuntoAlfabetos
     */
    private ConjuntoTextos CjtTextos;
    private ConjuntoTeclados CjtTeclados;
    private ConjuntoAsociaciones CjtAsociaciones;


    /**
     * Asigna un alfabeto y un cjt de alfabetos vacío
     */
    public CtrlTexto(){
        CjtTextos = null;
    }
    // ---------- FUNCIONES TEXTO ----------

    public String getContenido(String nomT){
        //return CjtTextos.getTexto(nomT).getFrecuenciaPalabras();
        return CjtTextos.getTexto(nomT).getTexto();
    }

    public void agregarAsociacionVinculada(String nomT, String nomAT){
        CjtTextos.getTexto(nomT).agregarAsociacionesVinculadas(nomAT);
    }

    // ---------- FUNCIONES CONJUNTOTEXTOS ----------
    public Texto getTexto(String nomT){
        return CjtTextos.getTexto(nomT);
    }
    public ConjuntoTextos getTextos(){
        return CjtTextos;
    }
    /**
     * No retorna nada.
     * Crea el nuevo objecto texto y añade este objeto a ConjuntoTextos
     */
    public boolean agregarTexto(String nomT, HashMap<String, Integer> frecuenciasLetras) {
        if(!CjtTextos.existeTexto(nomT)){
            // ho deixo comentat perque s'ha de canviar lo de TEXTO i no hi ha creadora comptabile ara mateix
            //Texto texto = new Texto(nomT, frecuenciasLetras); // no hay constructor para pasar eso
            //CjtTextos.agregarTexto(nomT, texto);
            return true;
        }
        return false;
    }

    //Para la segunda entrega
    /*public void borrarTexto(String nomT){
        ArrayList<String> AVinculadas = CjtTextos.getTexto(nomT).getAsociacionesVinculadas();
        if(!AVinculadas.isEmpty()) {
            for (int i = 0; i < AVinculadas.size(); ++i){
                CjtAsociaciones.borrarAsociacionTextos(AVinculadas.get(i));
            }
            CjtTextos.borrarTexto(nomT);
        }
    }*/
}
