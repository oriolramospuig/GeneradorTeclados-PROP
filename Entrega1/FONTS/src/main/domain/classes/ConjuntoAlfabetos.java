package main.domain.classes;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa el conjunto de alfabetos
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class ConjuntoAlfabetos
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de alfabetos introducidos por el usuario */
    private HashMap<String, Alfabeto> alfabetos;

    // ---------- CONSTRUCTORES ----------
    public ConjuntoAlfabetos() {
        alfabetos = new HashMap<(String, Alfabeto)>;
    }

    public void agregarAlfabeto(String nombre, Alfabeto alfabeto) {
        alfabetos.put(nombre, alfabeto);
    }

    public boolean agregarAlfabetoSiNoExiste(String nombre, Alfabeto alfabeto) {
        if (!alfabetos.containsKey(nombre)) {
            alfabetos.put(nombre, alfabeto);
            return true;
        }
        return false;
    }


    // ---------- GETTERS ----------
    /**
     * Retorna el conjunto de alfabetos
     * @return alfabetos : Conjunto de alfabetos guardados
     */
    public HashMap<String, Alfabeto> getAlfabetos() {
        return alfabetos;
    }

    /**
     * Retorna el alfabeto con clave primaria introducida
     * @param nombre clave primaria con la que buscar un alfabeto
     * @return Nombre, Alfabeto : Alfabeto con el nombre introducido
     */
    public Alfabeto obtenerAlfabeto(String nombre) {
        return alfabetos.get(nombre);
    }

    // ---------- SETTERS ----------
    /**
     *  Modifica el conjunto de alfabetos
     *  @param alfabetos : El nuevo conjunto de alfabetos
     *
     */
    public void setAlfabetos(HashMap<String, Alfabeto> alfabetos) {
        this.alfabetos = alfabetos;
    }

    // ---------- AUXILIARES ----------
    /**
     * Retorna si existe el alfabeto con nombre dado
     * @return boolean : True si existe, false si no existe
     */
    public boolean existeAlfabeto(String nombre){

        return alfabetos.containsKey(nombre);
    }

}
