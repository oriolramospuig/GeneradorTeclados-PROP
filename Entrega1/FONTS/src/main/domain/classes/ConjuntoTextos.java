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

    /**
     * Retorna el texto con clave primaria introducida
     * @param nomT clave primaria con la que buscar un texto
     * @return Texto : Texto con el nombre introducido
     */
    // ---------- GETTERS ----------
    public Texto getTexto(String nomT) {
        if (textos.containsKey(nomT)) return textos.get(nomT);
        else {
            // podria salir un mensaje: "texto nomT no existe en el sistema"
            return null;
        }
        //????????
    }
    /**
     * Retorna el conjunto de textos existentes
     * @return HashMap<String, Texto>: Conjunto de texto
     */
    public HashMap<String, Texto> getTextos() {
        return textos;
    }
    /**
     * Retorna el nombre de los textos del conjunto
     * @return ArrayList<String>: Lista de nombres de los textos del conjunto
     */
    public ArrayList<String> getNombresTextos() {
        ArrayList<String> listaNombres = new ArrayList<>();
        for (String clave : textos.keySet()) {
            listaNombres.add(clave);
        }
        return listaNombres;
    }


    // ---------- SETTERS ----------
    /**
     * No retorna nada.
     * @param texto texto a agregar
     * @param nomT nombre del texto a agregar
     * Añade un texto al conjunto de texto
     */
    public void agregarTexto(String nomT, Texto texto) {
        textos.put(nomT, texto);
    }


    // ---------- AUXILIARES -----------
    /**
     * Retorna si existe el texto con nombre dado
     * @param nomT nombre del texto a comprobar
     * @return boolean : True si el texto con nombre nomT existe, false si no existe
     */
    public boolean existeTexto(String nomT) {
        return textos.containsKey(nomT);
    }
    /**
     * No retorna nada.
     * @param nomT nombre del texto a borrar
     * Borra el texto con nombre nomT del conjunto de textos.
     */
    public void borrarTexto(String nomT) {
        textos.remove(nomT);
    }
}
