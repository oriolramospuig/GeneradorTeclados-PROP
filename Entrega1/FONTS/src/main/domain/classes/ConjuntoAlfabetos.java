package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Clase que representa el conjunto de alfabetos
 * @author
 */
public class ConjuntoAlfabetos {

    // ---------- ATRIBUTOS ----------

    /** Guarda el conjunto de alfabetos existentes */
    private HashMap<String, Alfabeto> alfabetos;


    // ---------- CONSTRUCTORAS ----------
    /**
     * Constructora Conjunto de alfabetos.
     * La lista de alfabetos existentes está vacía inicialmente.
     */
    public ConjuntoAlfabetos() {
        alfabetos = new HashMap<>();
    }

    // ---------- GETTERS ----------
    /**
     * Retorna el alfabeto con el nombre nomA como clave primaria
     * @param nomA clave primaria con la que buscar un alfabeto
     * @return Alfabeto : Alfabeto con el nombre nomA
     */
    public Alfabeto getAlfabeto(String nomA) {
        if (alfabetos.containsKey(nomA)) return alfabetos.get(nomA);
        else return null;
    }
    /**
     * Retorna el conjunto de alfabetos existentes
     * @return HashMap<String, Alfabeto>: Conjunto de alfabetos
     */
    public HashMap<String, Alfabeto> getAlfabetos () {
        return alfabetos;
    }
    /**
     * Retorna una lista con el nombre de los alfabetos del conjunto
     * @return ArrayList<String>: Lista de nombres de los alfabetos del conjunto
     */
    public ArrayList<String> getNombresAlfabetos() {
        ArrayList<String> listaNombresA = new ArrayList<>();
        for (String clave : alfabetos.keySet()) {
            listaNombresA.add(clave);
        }
        return listaNombresA;
    }


    // ---------- SETTERS ----------
    /**
     * No retorna nada.
     * @param alfabeto objecto alfabeto a agregar al conjunto
     * @param nomA nombre del alfabeto a agregar (clave primaria del alfabeto)
     * Añade un alfabeto al conjunto de alfabetos existentes
     */
    public void agregarAlfabeto(String nomA, Alfabeto alfabeto) {
        alfabetos.put(nomA, alfabeto);
    }


    // ---------- AUXILIARES ----------
    /**
     * Retorna un bool de si existe el alfabeto con nombre nomA
     * @param nomA nombre del alfabeto a comprobar
     * @return boolean : True si el alfabeto con nombre nomA existe, false si no existe
     */
    public boolean existeAlfabeto(String nomA){
        return alfabetos.containsKey(nomA);
    }
    /**
     * No retorna nada.
     * @param nomA nombre del alfabeto a borrar
     * Borra el alfabeto con nombre nomA del conjunto de alfabetos.
     */
    public void borrarAlfabeto(String nomA) {
        alfabetos.remove(nomA);
    }
}