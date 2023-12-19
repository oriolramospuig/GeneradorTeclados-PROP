package main.domain.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa el conjunto de textos
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class ConjuntoTextos implements Serializable
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de textos  introducidos por el usuario */
    private HashMap<String, Texto> textos;


    // ---------- CONSTRUCTORAS ----------
    /**
     * Constructora conjunto de textos
     * Inicialmente el conjunto de textos existentes está vacío
     */
    public ConjuntoTextos() {
        textos = new HashMap<>();
    }


    // ---------- GETTERS ----------
    /**
     * Devuelve el texto con clave primaria introducida si existe
     * @param nomT clave primaria con la que buscar un texto
     * @return Texto: Texto con el nombre introducido
     */
    public Texto getTexto(String nomT) {
        if (textos.containsKey(nomT)) return textos.get(nomT);
        return null;
    }

    /**
     * Devuelve el nombre de los textos del conjunto textos
     * @return ArrayList<String>: Lista de nombres de los textos del conjunto
     */
    public ArrayList<String> getNombresTextos() {
        ArrayList<String> listaNombres = new ArrayList<>();
        for (String clave : textos.keySet()) {
            listaNombres.add(clave);
        }
        return listaNombres;
    }

    /**
     * Devuelve el conjunto de textos existentes
     * @return HashMap<String, Texto>: Conjunto de textos
     */
    public HashMap<String, Texto> getTextos() {
        return textos;
    }


    // ---------- SETTERS ----------
    /**
     * No devuelve nada. Añade un texto al conjunto de texto
     * @param nomT nombre del texto a agregar
     * @param texto texto a agregar
     */
    public void agregarTexto(String nomT, Texto texto) {
        textos.put(nomT, texto);
    }


    // ---------- AUXILIARES -----------
    /**
     * Devuelve si existe el texto con el nombre dado
     * @param nomT nombre del texto a comprobar
     * @return boolean: True si el texto con nombre nomT existe, false si no existe
     */
    public boolean existeTexto(String nomT) {
        return textos.containsKey(nomT);
    }

    /**
     * No devuelve nada. Borra el texto con nombre nomT del conjunto de textos.
     * @param nomT nombre del texto a borrar
     */
    public void borrarTexto(String nomT) {
        textos.remove(nomT);
    }
}