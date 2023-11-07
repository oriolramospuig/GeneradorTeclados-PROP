package main.domain.classes;

import java.util.HashMap;

public class ConjuntoTextos {
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de asociaciones de textos introducidos por el usuario */
    private HashMap<String, AsociacionTextos> textos;

    // ---------- CONSTRUCTORES ----------
    public ConjuntoTextos() {
        textos = new HashMap<>();
    }

    public void agregarTexto(String nombre, Texto texto) {
        textos.put(nombre, texto);
    }

    public boolean agregarTextoSiNoExiste(String nombre, Texto texto) {
        if (!textos.containsKey(nombre)) {
            textos.put(nombre, texto);
            return true;
        }
        return false;
    }

    // ---------- GETTERS ----------
    public HashMap<String, AsociacionTextos> getTextos() { return textos}

    public AsociacionTextos obtenerTextos(String nombre) {
        return AsociacionTextos.get(nombre);
    }

    // ---------- SETTERS ----------
    public HashMap<String, Alfabeto> getAsociaciondeTextos() {
        return textos;
    }

    public Alfabeto obtenerAsociaciondeTextos(String nombre) {
        return textos.get(nombre);
    }

    // ---------- AUXILIARES -----------

    public boolean existeAsociaciondeTextos(String nombre){

        return textos.containsKey(nombre);
    }
}
