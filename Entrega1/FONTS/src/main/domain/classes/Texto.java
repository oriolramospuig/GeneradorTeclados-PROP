package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Texto {
    /** Guarda el nombre introducido por el usuario */
    private String nombre;

    /** Lista de palabras */
    private ArrayList<String> contenidoPalabras;

    /** Lista de palabra con frecuencias */
    private HashMap<String, Integer> contenidoFrecuencias;

    // ---------- CONSTRUCTORES ----------
    public Texto() {
        nombre = new String();
        contenidoPalabras = new ArrayList<>();
        contenidoFrecuencias = new HashMap<>();
    }

    public Texto(String nom, ArrayList<String> cont) {
        this.nombre = nom;
        this.contenidoPalabras = cont;
    }

    public Texto(String nom, HashMap<String, Integer> frec) {
        this.nombre = nom;
        this.contenidoFrecuencias = frec;
    }

    // ---------- GETTERS ----------
    /**
     * Retorna el nombre introducido por el usuario
     * @return String : Nombre introducido por el usuario
     */
    public String getNombre() { return nombre; }

    /**
     * Retorna el contenido del texto (lista de palabras)
     * @return String : Contenido del texto usado por las funciones
     */
    public ArrayList<String> getContenidoPalabras()
    {
        return contenidoPalabras;
    }

    /**
     * Retorna el contenido del texto (lista de frecuencias)
     * @return String : Contenido del texto usado por las funciones
     */
    public HashMap<String, Integer> getContenidoFrecuencias()
    {
        return contenidoFrecuencias;
    }

    // ---------- SETTERS ----------
}
