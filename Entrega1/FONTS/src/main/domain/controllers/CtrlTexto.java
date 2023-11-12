package main.domain.controllers;

import main.domain.classes.*;

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
    private ConjuntoAsociaciones CjtAsociaciones;

    /**
     * Asigna un alfabeto y un cjt de alfabetos vacío
     */
    public CtrlTexto(){
        CjtTextos = null;
    }

    // ---------- FUNCIONES TEXTO ----------
    /**
     * No retorna nada.
     * Manda a añadir el nuevo teclado al cjt de teclados vinculados
     */
    public void agregarAsociacionTextoVinculada (String nomTxt,String nomAT) {
        CjtTextos.getTexto(nomTxt).agregarAsociacionesVinculadas(nomAT);
    }
    /**
     * No retorna nada.
     * Manda a borrar un teclado al cjt de teclados vinculados
     */
    public void borrarAsociacionTextoVinculada(String nomTxt, String nomAT) {
        CjtTextos.getTexto(nomTxt).borrarAsociacionesVinculadas(nomAT);
    }

    // ---------- FUNCIONES CONJUNTOTEXTOS ----------
    public ConjuntoTextos getTextos(){
        return CjtTextos;
    }
    /**
     * No retorna nada.
     * Crea el nuevo objecto texto y añade este objeto a ConjuntoTextos
     */
    public boolean agregarTexto(String nomT, String frecuenciasLetras) {
        if(!CjtTextos.existeTexto(nomT)){
            HashMap<String, Integer> frecLetras = new HashMap<>();
            /*for (char c:entradaCaracteres.toCharArray()) {
                // Solo agrega caracteres no espacios.
                // espacio tambien puede ser caracter
                if (c != ' ') caracteres.add(c);
            }*/
            Texto texto = new Texto(nomT, frecLetras);
            CjtTextos.agregarTexto(nomT, texto); // no hay constructor para pasar eso
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
        }
        CjtTextos.borrarTexto(nomT);
    }
}
