package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa el conjunto de textos
 * @author
 */
public class ConjuntoTextos
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de textos  introducidos por el usuario */
    private HashMap<String, Texto> textos;


    // ---------- CONSTRUCTORAS ----------
    public ConjuntoTextos() {
        textos = new HashMap<>();
    }


    // ---------- GETTERS ----------
    public Texto getTexto(String nomT) {
        return null;
    }

    public HashMap<String, Texto> getTextos() {
        return textos;
    }

    public ArrayList<String> getNombresTextos() {
        return null;
    }


    // ---------- SETTERS ----------
    public void agregarTexto(String nomT, Texto texto) {}


    // ---------- AUXILIARES -----------
    public boolean existeTexto(String nomT, Texto texto) {
        return true;
    }

    public void borrarTexto(String nomT) {}

    public boolean disponibilidadNombre(String nomT) {
        return true;
    }
}
