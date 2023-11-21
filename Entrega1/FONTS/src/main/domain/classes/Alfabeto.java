package main.domain.classes;

import java.lang.String;
import java.util.ArrayList;


/**
 * Clase que representa un alfabeto
 * @author
 */
public class Alfabeto {

    // ---------- ATRIBUTOS ----------

    /** Nombre del alfabeto (clave única) */
    private String nombre;

    /** Contenido del afabeto */
    private ArrayList<Character> letras;

    /** Lista de nombres de teclados vinculados a ese alfabeto*/
    private ArrayList<String> tecladosVinculados;


    // ---------- CONSTRUCTORES ----------
    /**
     * Constructora alfabeto con nombre y contenido asignados.
     * La lista de nombres de teclados vinculados está vacía inicialmente.
     */
    public Alfabeto(String nombre, ArrayList<Character> letras) {
        this.nombre = nombre;
        this.letras = letras;
        tecladosVinculados = new ArrayList<>();
    }

    // ---------- GETTERS ----------
    /**
     * Retorna el nombre del alfabeto
     * @return String : Nombre alfabeto
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Retorna el contenido del alfabeto
     * @return ArrayList<Character> : Contenido del alfabeto usado por las funciones
     */
    public ArrayList<Character> getLetras() {
        return letras;
    }
    /**
     * Retorna la lista de nombres de los teclados vinculados al alfabeto
     * @return ArrayList<String> : Lista de nombres de los teclados vinculados
     */
    public ArrayList<String> getTecladosVinculados() {
        return tecladosVinculados;
    }

    // ---------- SETTERS ----------
    /**
     * No retorna.
     * @param nomT nombre del teclado a vincular
     * Añade a la lista de nombres de los teclados vinculados el nombre del nuevo teclado nomT
     */
    public void agregarTecladoVinculado (String nomT) {
        tecladosVinculados.add(nomT);
    }

    // ---------- AUXILIARES ----------
    /**
     * No retorna.
     * @param nomT nombre del teclado a desvincular
     * Borra de la lista de nombres de los teclados vinculados el nombre del teclado nomT
     */
    public void borrarTecladoVinculado(String nomT) {
        tecladosVinculados.remove(nomT);
    }

}