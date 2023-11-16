package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Classe que representa un texto
 * @author
 */

public class Texto
{
    // ---------- ATRIBUTOS COMUNES ----------
    /** Guarda el nombre introducido por el usuario */
    protected String nombre;

    protected HashMap<String, Integer> frecuenciaLetras; //string: parejaLetras, int: frecuencia

    protected ArrayList<String> asociacionesVinculadas;


    // ---------- CONSTRUCTORES ----------
    public Texto() {
        nombre = new String();
        frecuenciaLetras = new HashMap<>();
        asociacionesVinculadas = new ArrayList<>();
    }

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

    /**
     * Retorna lista de AsociacionTextos que tiene el texto
     * @return
     */
    public ArrayList<String> getAsociacionesVinculadas() {
        return asociacionesVinculadas;
    }

    /**
     * Retorna el contenido del texto
     * @return String : Contenido del texto usado por las funciones, dependiendo del tipo de Texto el formato variará
     */
    public String getTexto() {
        return null;
    }


    // ---------- SETTERS ----------
    public void agregarAsociacionesVinculadas(String nomAT) {
        asociacionesVinculadas.add(nomAT);
    }


    // ---------- AUXILIARES ----------
    public void borrarAsociacionesVinculadas(String nomAT) {
    asociacionesVinculadas.remove(nomAT);
}
}
