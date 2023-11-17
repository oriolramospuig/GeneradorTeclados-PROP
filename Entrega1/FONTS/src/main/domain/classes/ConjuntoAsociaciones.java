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
    public void agregarAsociacionTexto(String nomAT, AsociacionTextos asociacionTextos) {
        asociaciones.put(nomAT, asociacionTextos);
    }


    // ---------- AUXILIARES -----------
    public boolean existeAsociaciondeTextos(String nomAT) {
        return asociaciones.containsKey(nomAT);
    }

    public void borrarAsociacionTextos(String nomAT) {
        asociaciones.remove(nomAT);
    }
}
