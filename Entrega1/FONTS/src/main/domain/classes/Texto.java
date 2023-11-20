package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Classe que representa un texto
 * @author X (X@estudiantat.upc.edu)
 */

public abstract class Texto
{
    // ---------- ATRIBUTOS COMUNES ----------
    /** Guarda el nombre introducido por el usuario */
    protected String nombre;

    /** Guarda la lista de pares de carácteres y su frecuencia ("ab", 5) */
    protected HashMap<String, Integer> frecuenciaLetras;

    /** Guarda las asociaciones que tiene este texto en su asociación */
    protected ArrayList<String> asociacionesVinculadas;


    // ---------- CONSTRUCTORES ----------
   /*public Texto(String nombreT,HashMap<String, Integer> frecP, HashMap<String, Integer> frecL ) {
        nombre = nombreT;
        frecuenciaPalabras = frecP;
        frecuenciaLetras = frecL;
        asociacionesVinculadas = new ArrayList<>();
    }
    */

    // ---------- GETTERS ----------
    /**
     * Retorna el nombre introducido por el usuario
     * @return String : Nombre introducido por el usuario
     */
    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Integer> getFrecuenciaLetras() {
        return frecuenciaLetras;
    }

   /* public HashMap<String, Integer> getFrecuenciaPalabras() {
        return frecuenciaPalabras;
    }

    */

    /**
     * Retorna lista de nombres de las asociaciones de textos que tienen el texto
     * @return ArrayList<String> : Lista de los nombres de las asociaciones vinculadas al texto
     */
    public ArrayList<String> getAsociacionesVinculadas() {
        return asociacionesVinculadas;
    }

    /**
     * Retorna el contenido del texto
     * @return String : Contenido del texto usado por las funciones, dependiendo del tipo de Texto el formato variará
     */
    public abstract String getTexto();


    // ---------- SETTERS ----------
    /**
     * No retorna.
     * @param nomAT nombre de la  asocación de textos a vincular
     * Añade a la lista de asociaciones vinculadas el nombre de la asociación de textos
     * pasada por parámetro nomAT
     */
    public void agregarAsociacionesVinculadas(String nomAT) {
        asociacionesVinculadas.add(nomAT);
    }


    // ---------- AUXILIARES ----------
    /**
     * No retorna.
     * @param nomAT nombre de la asociación de textos a desvincular
     * Borra de la lista de asociaciones de textos vinculadas el nombre de la
     * asociación pasada por parámetro nomAT
     */
    public void borrarAsociacionesVinculadas(String nomAT) {
    asociacionesVinculadas.remove(nomAT);
}
}
