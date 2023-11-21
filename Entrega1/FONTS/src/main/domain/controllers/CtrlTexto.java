package main.domain.controllers;

import main.domain.classes.*;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar alfabetos
 * Los alfabetos existentes quedarán dentro de un ...
 *
 */
public class CtrlTexto
{
    // ---------- PARÁMETROS ----------
    /**
     * Parámetros de la clase Alfabeto y ConjuntoAlfabetos
     */
    private ConjuntoTextos CjtTextos;
    private ConjuntoTeclados CjtTeclados;
    // private ConjuntoAsociaciones CjtAsociaciones;

    /**
     * Asigna un alfabeto y un cjt de alfabetos vacío
     */
    public CtrlTexto(){
        CjtTextos = new ConjuntoTextos();
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
    public boolean agregarTextoPalabras(String nomT, String texto) {
        if(!CjtTextos.existeTexto(nomT)) {
            HashMap<String,Integer> frecuenciaLetras = convertirTextoAFrecuencias(texto);
            Palabras palabras = new Palabras(nomT, texto,frecuenciaLetras);
            //palabras.imprimirFrecuencias();
            CjtTextos.agregarTexto(nomT, palabras);
            return true;
        }
        return false;
    }
    /**
     * No retorna.
     * Convierte las palabras de la entrada en frecuencias del estilo par de letras, frecuencia ("ab", 5)
     */
    public HashMap<String,Integer> convertirTextoAFrecuencias(String texto) {
        HashMap<String,Integer> frecuenciaLetras = new HashMap<String,Integer>();
        char[] textoChars = texto.toCharArray();
        for(int i = 1; i < textoChars.length; ++i){
            String pairLetras = "" + textoChars[i-1] + textoChars[i];
            int frec = 1;
            if (textoChars[i-1] > textoChars[i]) pairLetras = "" + textoChars[i] + textoChars[i-1];
            if(frecuenciaLetras.containsKey(pairLetras)){
                frec = frecuenciaLetras.get(pairLetras)+1;
            }
            frecuenciaLetras.put(pairLetras,frec);
        }
        return frecuenciaLetras;
    }

    public HashMap<String, Integer> convertirFrecuenciasPalabrasAFrecuenciasLetras(HashMap<String,Integer> frecPalabras) {
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();

        for(HashMap.Entry<String,Integer> e : frecPalabras.entrySet()){
            HashMap<String,Integer> flPal = convertirTextoAFrecuencias(e.getKey());
            for(HashMap.Entry<String,Integer> el : flPal.entrySet()){
                if(frecuenciaLetras.containsKey(el.getKey())){
                    frecuenciaLetras.replace(el.getKey(),frecuenciaLetras.get(el.getKey()) + el.getValue()*e.getValue());
                }
                else frecuenciaLetras.put(el.getKey(),el.getValue()*e.getValue());
            }
        }

        return frecuenciaLetras;
    }
    public boolean agregarTextoFrecuencias(String nomT, HashMap<String,Integer> frecuenciaPalabras) {
        if(!CjtTextos.existeTexto(nomT)){
            HashMap<String,Integer> frecuenciasLetras = convertirFrecuenciasPalabrasAFrecuenciasLetras(frecuenciaPalabras);
            Frecuencias frecuencias = new Frecuencias(nomT, frecuenciaPalabras, frecuenciasLetras);
            frecuencias.imprimirFrecuencias();
            CjtTextos.agregarTexto(nomT, frecuencias);
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
