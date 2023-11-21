package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa el conjunto de asociaciones
 * @author ...
 */
public class ConjuntoAsociaciones
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de asociaciones de textos introducidas por el usuario */
    private HashMap<String, AsociacionTextos> asociaciones;


    // ---------- CONSTRUCTORES ----------
    /** Crea una instancia de la clase ConjuntoAsociaciones e inicializa la variable asociaciones como un nuevo HashMap */
    public ConjuntoAsociaciones() {
        asociaciones = new HashMap<>();
    }


    // ---------- GETTERS ----------
    /**
     * Devuelve la asociacion de textos nomAT introducida si existe
     * @param nomAT clave primaria con la que buscar una asociacion de textos
     * @return AsociacionTextos: Asociación de textos con el nombre introducido
     */
    public AsociacionTextos getAsociacionTextos(String nomAT) {
        if (asociaciones.containsKey(nomAT)) return asociaciones.get(nomAT);
        return null;
    }

    /**
     * Devuelve el conjunto de asociaciones de textos existentes
     * @return HashMap<String, AsociacionTextos>: Conjunto de asociaciones de textos
     */
    public HashMap<String, AsociacionTextos> getAsociacionesTextos() {
        return asociaciones;
    }

    /**
     * Devuelve el nombre de las asociaciones del conjunto
     * @return ArrayList<String>: Lista de nombres de las asociaciones de textos del conjunto
     */
    public ArrayList<String> getNombresAsociacionesTextos() {
        ArrayList<String> listaNombres = new ArrayList<>();
        for (String clave : asociaciones.keySet()) {
            listaNombres.add(clave);
        }
        return listaNombres;
    }


    // ---------- SETTERS ----------
    /**
     * No devuelve nada. Añade una asociación de textos al conjunto de asociaciones de textos
     * @param asociacionTextos asociación a agregar al conjunto de asociaciones
     * @param nomAT nombre de la asociacion a agregaral conjunto
     */
    public void agregarAsociacionTexto(String nomAT, AsociacionTextos asociacionTextos) {
        asociaciones.put(nomAT, asociacionTextos);
    }


    // ---------- AUXILIARES -----------
    /**
     * Devuelve si existe la asociación de textos con el nombre dado
     * @param nomAT nombre de la asociación de textos a comprobar
     * @return boolean: True si el la asociación de textos con nombre nomAT existe en el conjunto, false si no existe
     */
    public boolean existeAsociaciondeTextos(String nomAT) {
        return asociaciones.containsKey(nomAT);
    }

    //Segunda entrega
    /**
     * No devuelve nada. Borra la asociación de textos con nombre nomAT del conjunto de asociaciones
     * @param nomAT nombre de la asociación de textos a borrar
     */
    public void borrarAsociacionTextos(String nomAT) {
        asociaciones.remove(nomAT);
    }
}