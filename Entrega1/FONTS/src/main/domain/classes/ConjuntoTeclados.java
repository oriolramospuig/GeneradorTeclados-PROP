package main.domain.classes;

import java.util.HashMap;

public class ConjuntoTeclados {
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de teclados generados por el usuario */
    private HashMap<String, Teclado> teclados;

    // ---------- CONSTRUCTORES ----------
    public ConjuntoTeclados() {
        teclados = new HashMap<>();
    }

    public void agregarTeclado(String nombre, Teclado teclado) {
        teclados.put(nombre, teclado);
    }

    public boolean agregarTecladoSiNoExiste(String nombre, Teclado teclado) {
        if (!teclados.containsKey(nombre)) {
            teclados.put(nombre, teclado);
            return true;
        }
        return false;
    }

    // ---------- GETTERS ----------


    // ---------- SETTERS ----------


    // ---------- AUXILIARES -----------
}
