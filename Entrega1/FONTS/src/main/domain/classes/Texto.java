package main.domain.classes;

import main.domain.classes.types.PairString;

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

    private HashMap<PairString<String, String>, Integer> frecuenciaLetras; //Pair: parejaLetras, int: frecuencia

    private ArrayList<String> asociacionesTextosVinculos;


    // ---------- CONSTRUCTORES ----------
    public Texto() {
        nombre = new String();
        frecuenciaLetras = new HashMap<>();
        asociacionesTextosVinculos = new ArrayList<>();
    }


    // ---------- GETTERS ----------
    /**
     * Retorna el nombre introducido por el usuario
     * @return String : Nombre introducido por el usuario
     */
    public String getNombre() { return nombre; }

    public HashMap<PairString<String, String>, Integer> getFrecuenciaLetras()
    {
        return null;
    }

    /**
     * Retorna el contenido del texto (lista de palabras)
     * @return String : Contenido del texto usado por las funciones
     */
    public ArrayList<String> getAsociacionesTextosVinculos()
    {
        return null;
    }

    /**
     * Retorna el contenido del texto (lista de frecuencias)
     * @return String : Contenido del texto usado por las funciones
     */


    // ---------- SETTERS ----------

    public void setNombre(String nom)
    {
        nombre = nom;
    }

    // ---------- AUXILIARES ----------


}

