package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa el conjunto de teclados
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class ConjuntoTeclados
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de teclados generados por el usuario */
    private HashMap<String, Teclado> teclados;


    // ---------- CONSTRUCTORES ----------
    public ConjuntoTeclados() {
        teclados = new HashMap<>();
    }


    // ---------- GETTERS ----------
    public Teclado getTeclado(String nomT) {
        return null;
    }

    // tenemos que considerar si queremos/necesitamos esta funcion
    public HashMap<String, Teclado> getTeclados() {
        return teclados;
    }

    public ArrayList<String> getNombresTeclados() {
        return null;
    }


    // ---------- SETTERS ----------
    public void agregarTeclado(String nombre, Teclado teclado) {}


    // ---------- AUXILIARES -----------
    public boolean existeTeclado(String nomT){
        return true;
    }

    public void borrarTeclado(String nomT) {}

    public boolean disponibilidadNombre(String nomt) {
        return true;
    }
}
