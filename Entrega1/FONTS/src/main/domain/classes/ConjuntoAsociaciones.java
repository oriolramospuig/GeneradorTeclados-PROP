package main.domain.classes;

import java.util.HashMap;

public class ConjuntoAsociaciones {
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de asociaciones de textos introducidos por el usuario */
    private HashMap<String, AsociacionTextos> asociaciones;

    // ---------- CONSTRUCTORES ----------
    public ConjuntoAsociaciones() {
        asociaciones = new HashMap<>();
    }

    public void agregarAsociacionTexto(String nombre, AsociacionTextos asociacionTextos) {

        asociaciones.put(nombre, asociacionTextos);
    }

    public boolean agregarAsociacionTextoSiNoExiste(String nombre, AsociacionTextos texto) {
        if (!asociaciones.containsKey(nombre)) {
            asociaciones.put(nombre, texto);
            return true;
        }
        return false;
    }

    // ---------- GETTERS ----------
    public HashMap<String, AsociacionTextos> getTextos() { return asociaciones; }

    public AsociacionTextos obtenerTextos(String nombre) {
        return asociaciones.get(nombre);
    }

    // ---------- SETTERS ----------


    // ---------- AUXILIARES -----------

    public boolean existeAsociaciondeTextos(String nombre){

        return asociaciones.containsKey(nombre);
    }
}
