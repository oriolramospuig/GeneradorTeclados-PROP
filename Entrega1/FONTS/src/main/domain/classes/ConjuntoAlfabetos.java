package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa el conjunto de alfabetos
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class ConjuntoAlfabetos
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de alfabetos introducidos por el usuario */
    private HashMap<String, Alfabeto> alfabetos;


    // ---------- CONSTRUCTORAS ----------
    public ConjuntoAlfabetos() {
        alfabetos = new HashMap<>();
    }


    // ---------- GETTERS ----------
    /**
     * Retorna el alfabeto con clave primaria introducida
     * @param nomA clave primaria con la que buscar un alfabeto
     * @return Nombre, Alfabeto : Alfabeto con el nombre introducido
     */
    public Alfabeto getAlfabeto(String nomA) {
        /** return alfabetos.get(nombre); */
        return null;
    }

    public HashMap<String, Alfabeto> getAlfabetos () {
        return alfabetos;
    }

    /**
     * Retorna el conjunto de alfabetos
     * @return alfabetos : Conjunto de alfabetos guardados
     */
    public ArrayList<String> getNombresAlfabetos() {
        return null;
    }


    // ---------- SETTERS ----------
    public void agregarAlfabeto(String nomA, Alfabeto alfabeto) {
        /**
         * public boolean agregarAlfabetoSiNoExiste(String nombre, Alfabeto alfabeto) {
         *         if (!alfabetos.containsKey(nombre)) {
         *             alfabetos.put(nombre, alfabeto);
         *             return true;
         *         }
         *         return false;
         */
    }


    // ---------- AUXILIARES ----------
    /**
     * Retorna si existe el alfabeto con nombre dado
     * @return boolean : True si existe, false si no existe
     */
    public boolean existeAlfabeto(String nomA, Alfabeto alfabeto){
        /** return alfabetos.containsKey(nombre); */
        return true;
    }

    public void borrarAlfabeto(String nomA) {}

    public boolean disponibilidadNombre(String nomA) {
        return true;
    }
}