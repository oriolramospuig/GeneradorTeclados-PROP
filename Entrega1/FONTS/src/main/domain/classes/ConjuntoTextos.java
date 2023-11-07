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

    public void agregarAsociacionTexto(String nombre, AsociacionTextos asociacionTextos) {

        textos.put(nombre, asociacionTextos);
    }

    public boolean agregarAsociacionTextoSiNoExiste(String nombre, AsociacionTextos texto) {
        if (!textos.containsKey(nombre)) {
            textos.put(nombre, texto);
            return true;
        }
        return false;
    }

    // ---------- GETTERS ----------
    public HashMap<String, AsociacionTextos> getTextos() { return textos; }

    public AsociacionTextos obtenerTextos(String nombre) {
        return textos.get(nombre);
    }

    // ---------- SETTERS ----------


    // ---------- AUXILIARES -----------

    public boolean existeAsociaciondeTextos(String nombre){

        return textos.containsKey(nombre);
    }
}
