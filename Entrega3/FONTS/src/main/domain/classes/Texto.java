package main.domain.classes;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa un texto.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public abstract class Texto implements Serializable
{
    // ---------- ATRIBUTOS COMUNES ----------
    /** Guarda el nombre introducido por el usuario. */
    protected String nombre;

    /** Guarda la lista de pares de caracteres y su frecuencia ("ab", 5). */
    protected HashMap<String, Integer> frecuenciaLetras;

    /** Guarda el nombre de las asociaciones de textos que tienen este texto en su asociación. */
    protected ArrayList<String> asociacionesVinculadas;


    // ---------- GETTERS ----------
    /**
     * Devuelve el nombre introducido por el usuario.
     * @return String: Nombre introducido por el usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el map de pares de letras con sus frecuencias.
     * @return HashMap String,Integer: Map de frecuenciaLetras.
     */
    public HashMap<String, Integer> getFrecuenciaLetras() {
        return frecuenciaLetras;
    }

    /**
     * Devuelve una lista de nombres de las asociaciones de textos que contienen el texto.
     * @return ArrayList String: Lista de los nombres de las asociaciones vinculadas al texto.
     */
    public ArrayList<String> getAsociacionesVinculadas() {
        return asociacionesVinculadas;
    }

    /**
     * Devuelve el contenido del texto. Es una función abstracta.
     * @return String: Contenido del texto, ya sea del tipo Palabra o Frecuencia.
     */
    public abstract String getTexto();


    // ---------- SETTERS ----------
    /**
     * No devuelve nada. Añade a la lista de asociaciones vinculadas el nombre de la asociación de textos pasada por parámetro nomAT.
     * @param nomAT nombre de la asociación de textos a vincular.
     */
    public void agregarAsociacionesVinculadas(String nomAT) {
        asociacionesVinculadas.add(nomAT);
    }


    // ---------- AUXILIARES ----------
    /**
     * No devuelve nada. Borra de la lista de asociaciones de textos vinculadas el nombre de la asociación pasada por parámetro nomAT.
     * @param nomAT nombre de la asociación de textos a desvincular.
     */
    public void borrarAsociacionesVinculadas(String nomAT) {
        asociacionesVinculadas.remove(nomAT);
    }
}