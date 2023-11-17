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
    /**
     * Retorna el alfabeto con clave primaria introducida
     * @param nomAT clave primaria con la que buscar una asociacion de textos
     * @return Asociacion Textos : Asociación de textos con el nombre introducido
     */
    public AsociacionTextos getAsociacionTextos(String nomAT) {
        if (asociaciones.containsKey(nomAT)) return asociaciones.get(nomAT);
        else return null;
    }
    /**
     * Retorna el conjunto de asociaciones de textos existentes
     * @return HashMap<String, AsociacionTextos>: Conjunto de asociaciones de textos
     */
    public HashMap<String, AsociacionTextos> getAsociacionesTextos() {
        return asociaciones;
    }
    /**
     * Retorna el nombre de las asociaciones del conjunto
     * @return ArrayList<String>: Lista de nombres de las asociaciones del conjunto
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
     * No retorna nada.
     * @param asociacionTextos asociación a agregar al conjunto de asociaciones
     * @param nomAT nombre de la asociacion a agregaral conjunto
     * Añade una asociación de textos al conjunto de asociaciones de textos
     */
    public void agregarAsociacionTexto(String nomAT, AsociacionTextos asociacionTextos) {
        asociaciones.put(nomAT, asociacionTextos);
    }


    // ---------- AUXILIARES -----------
    /**
     * Retorna si existe la asociación de textos con nombre dado
     * @param nomAT nombre de la asociación de textos a comprobar
     * @return boolean : True si el la asociación de textos con nombre nomAT existe, false si no existe
     */
    public boolean existeAsociaciondeTextos(String nomAT) {
        return asociaciones.containsKey(nomAT);
    }
    /**
     * No retorna nada.
     * @param nomAT nombre de la asociación de textos a borrar
     * Borra la asociación de textos con nombre nomAT del conjunto de asociaciones.
     */
    public void borrarAsociacionTextos(String nomAT) {
        asociaciones.remove(nomAT);
    }
}
