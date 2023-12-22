package main.domain.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representa un conjunto de teclados, permitiendo almacenar y gestionar múltiples teclados.
 * Ofrece funcionalidades para agregar, eliminar, buscar y listar teclados.
 * Esta clase es serializable para facilitar el almacenamiento y recuperación del conjunto de teclados.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class ConjuntoTeclados implements Serializable
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de teclados generados por el usuario. */
    private HashMap<String, Teclado> teclados;


    // ---------- CONSTRUCTORES ----------
    /**
     * Constructor de ConjuntoTeclados.
     * Inicializa un nuevo conjunto de teclados vacío.
     */
    public ConjuntoTeclados() {
        teclados = new HashMap<>();
    }


    // ---------- GETTERS ----------
    /**
     * Obtiene un teclado específico del conjunto por su nombre.
     *
     * @param nomT El nombre del teclado a buscar.
     * @return Teclado con el nombre especificado o null si no se encuentra.
     */
    public Teclado getTeclado(String nomT) {
        if (teclados.containsKey(nomT)) return teclados.get(nomT);
        else return null;
    }

    /**
     * Retorna los nombres de todos los teclados en el conjunto.
     *
     * @return Una lista con los nombres de los teclados.
     */
    public ArrayList<String> getNombresTeclados() {
        ArrayList<String> listaNombres = new ArrayList<>();
        for (String clave : teclados.keySet()) {
            listaNombres.add(clave);
        }
        return listaNombres;
    }


    // ---------- SETTERS ----------
    /**
     * Agrega un nuevo teclado al conjunto.
     *
     * @param nomT El nombre del teclado a agregar.
     * @param teclado El teclado a agregar.
     */
    public void agregarTeclado(String nomT, Teclado teclado) {
        teclados.put(nomT, teclado);
    }


    // ---------- AUXILIARES -----------
    /**
     * Verifica si existe un teclado con un nombre específico en el conjunto.
     *
     * @param nomT El nombre del teclado a verificar.
     * @return True si el teclado existe, false en caso contrario.
     */
    public boolean existeTeclado(String nomT){
        return teclados.containsKey(nomT);
    }

    /**
     * Elimina un teclado del conjunto por su nombre.
     *
     * @param nomT El nombre del teclado a eliminar.
     */
    public void borrarTeclado(String nomT) {
        teclados.remove(nomT);
    }

    /**
     * Obtiene el conjunto completo de teclados.
     *
     * @return El HashMap que contiene todos los teclados, indexados por su nombre.
     */
    public HashMap<String, Teclado> getTeclados() {
        return teclados;
    }

}