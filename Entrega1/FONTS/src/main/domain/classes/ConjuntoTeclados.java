package main.domain.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa el conjunto de teclados
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class ConjuntoTeclados implements Serializable
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de teclados generados por el usuario */
    private HashMap<String, Teclado> teclados;


    // ---------- CONSTRUCTORES ----------
    /**
     * Constructora conjunto de teclados.
     * Inicialmente el conjunto de teclados existentes está vacío.
     */
    public ConjuntoTeclados() {
        teclados = new HashMap<>();
    }


    // ---------- GETTERS ----------
    /**
     * Retorna el teclado con clave primaria introducida
     * @param nomT clave primaria con la que buscar un teclado
     * @return Teclado : Teclado con el nombre introducido
     */
    public Teclado getTeclado(String nomT) {
        if (teclados.containsKey(nomT)) return teclados.get(nomT);
        else return null;
    }

    /**
     * Retorna el conjunto de teclados existentes
     * @return HashMap<String, Teclado>: Conjunto de teclados
     */
    public HashMap<String, Teclado> getTeclados() {
        return teclados;
    }

    /**
     * Retorna el nombre de los teclados del conjunto
     * @return ArrayList<String>: Lista de nombres de los teclados del conjunto
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
     * No retorna nada.
     * @param teclado teclado a agregar
     * @param nomT nombre del teclado a agregar
     * Añade un teclado al conjunto de teclados
     */
    public void agregarTeclado(String nomT, Teclado teclado) {
        teclados.put(nomT, teclado);
    }


    // ---------- AUXILIARES -----------
    /**
     * Retorna si existe el teclado con nombre dado
     * @param nomT nombre del teclado a comprobar
     * @return boolean : True si el teclado con nombre nomT existe, false si no existe
     */
    public boolean existeTeclado(String nomT){
        return teclados.containsKey(nomT);
    }

    /**
     * No retorna nada.
     * @param nomT nombre del teclado a borrar
     * Borra el alfabeto con nombre nomT del conjunto de teclados.
     */
    public void borrarTeclado(String nomT) {
        teclados.remove(nomT);
    }
}