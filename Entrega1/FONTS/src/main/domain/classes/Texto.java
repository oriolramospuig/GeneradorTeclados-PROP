package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa un texto
 * @author
 */
public abstract class Texto
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
    public String getNombre() { return nombre; }

    public HashMap<String, Integer> getFrecuenciaLetras()
    {
        return frecuenciaLetras;
    }

    /**
     * Retorna el contenido del texto (lista de palabras)
     * @return String : Contenido del texto usado por las funciones
     */
    public ArrayList<String> getAsociacionesVinculadas()
    {
        return null;
    }

    abstract String getTexto();


    // ---------- SETTERS ----------
    /* creo que no hace falta
    public void setNombre(String nom) {
        nombre = nom;
    }
    */
    public void agregarAsociacionesVinculadas(String nomAT) {}


    // ---------- AUXILIARES ----------
    public void borrarAsociacionesVinculadas(String nomAT) {}

}

