package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa el conjunto de asociaciones
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class ConjuntoAsociaciones
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de asociaciones de textos introducidos por el usuario */
    private HashMap<String, AsociacionTextos> asociaciones;


    // ---------- CONSTRUCTORES ----------
    public ConjuntoAsociaciones() {
        asociaciones = new HashMap<>();
    }


    // ---------- GETTERS ----------
    public AsociacionTextos getAsociacionTextos(String nomAT) {
        return null;
    }

    public HashMap<String, AsociacionTextos> getAsociacionesTextos() {
        return asociaciones;
    }

    public ArrayList<String> getNombresAsociacionesTextos() {
        return null;
    }

    // ---------- SETTERS ----------
    public void agregarAsociacionTexto(String nomAT, AsociacionTextos asociacionTextos) {
        //asociaciones.put(nomA, asociacionTextos);
    }


    // ---------- AUXILIARES -----------
    public boolean existeAsociaciondeTextos(String nomAT) {
        //return asociaciones.containsKey(nomAT);
        return true;
    }

    public void borrarAsociacionTextos(String nomAT) {}

    public boolean disponibilidadNombre(String nomAT) {
        return true;
    }
}
