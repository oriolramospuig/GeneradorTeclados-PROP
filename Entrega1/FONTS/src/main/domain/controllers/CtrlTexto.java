package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.Texto;
import main.domain.classes.ConjuntoTextos;
import main.domain.classes.ConjuntoTeclados;

import java.util.ArrayList;

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
    private Texto TextoExistente;
    private ConjuntoTextos CjtTextos;
    private ConjuntoTeclados CjtTeclados;

    /**
     * Asigna un alfabeto y un cjt de alfabetos vacío
     */
    public CtrlTexto(){
        CjtTextos = null;
        TextoExistente = null;
    }


    // ---------- FUNCIONES CONJUNTOTEXTOS ----------
    public ConjuntoTextos getTextos(){
        return CjtTextos;
    }
    /**
     * No retorna nada.
     * Crea el nuevo objecto texto y añade este objeto a ConjuntoTextos
     */
    public boolean agregarTexto(String nomT, ArrayList<Character> frecuenciasLetras) {
        if(!CjtTextos.existeTexto(nomT)){
            Texto texto = new Texto(nomT, frecuenciasLetras); // no hay constructor para pasar eso
            CjtTextos.agregarTexto(nomT, texto);
            return true;
        }
        return false;
    }

    /**
     * No retorna nada.
     * Manda borrar el texto dado, desvincula las asociaciones vinculadas
     * también borra este texto de la lista de ConjuntoTextos
     */

    public void borrarTexto(String nomT){
        ArrayList<String> AVinculadas = CjtTextos.getTexto(nomT).getAsociacionesVinculadas();
        if(!AVinculadas.isEmpty()) {
            for (int i = 0; i < AVinculadas.size(); ++i){
                CjtAsociaciones.borrarAsociacionTextos(AVinculadas.get(i));
            }
            CjtTextos.borrarTexto(nomT);
        }
    }
}
