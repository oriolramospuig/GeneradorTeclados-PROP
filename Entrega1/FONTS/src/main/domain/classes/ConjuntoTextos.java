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
        if (textos.containsKey(nomT)) return textos.get(nomT);
        else {
            // podria salir un mensaje: "texto nomT no existe en el sistema"
            return null;
        }
    }

    public HashMap<String, Texto> getTextos() {
        return textos;
    }

    public ArrayList<String> getNombresTextos() {
        ArrayList<String> listaNombres = new ArrayList<>();
        for (String clave : textos.keySet()) {
            listaNombres.add(clave);
        }
        return listaNombres;
    }


    // ---------- SETTERS ----------
    public void agregarTexto(String nomT, Texto texto) {
        textos.put(nomT, texto);
    }


    // ---------- AUXILIARES -----------
    public boolean existeTexto(String nomT) {
        return textos.containsKey(nomT);
    }

    public void borrarTexto(String nomT) {
        textos.remove(nomT);
    }
}
