package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class ConjuntoTextos {

    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de textos  introducidos por el usuario */
    private HashMap<String, Texto> textos;


    // ---------- CONSTRUCTORES ----------
    public ConjuntoTextos() {
        textos = new HashMap<>();
    }


    // ---------- GETTERS ----------
    public Texto getTexto(String nomT) {
        return null:
    }

    public HashMap<String, Texto> getTextos() {
        return textos;
    }

    public ArrayList<String> getNombreTextos() {
        return null;
    }


    // ---------- SETTERS ----------
    public void agregarTexto(String nomA, Texto texto) {}


    // ---------- AUXILIARES -----------
    public boolean existeTexto(String nomT, Texto texto) {
        return true;
    }

    public void borrarTexto(String nomT) {}

    public boolean disponibilidadNombre(String nomT) {
        return true;
    }
}
