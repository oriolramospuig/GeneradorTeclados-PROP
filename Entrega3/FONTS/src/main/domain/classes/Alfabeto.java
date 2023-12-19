package main.domain.classes;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;


/**
 * Clase que representa un alfabeto
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class Alfabeto implements Serializable
{
    // ---------- ATRIBUTOS ----------
    /** Nombre del alfabeto (clave única) */
    private String nombre;

    /** Contenido del afabeto */
    private ArrayList<Character> letras;

    /** Lista de nombres de teclados vinculados a ese alfabeto*/
    private ArrayList<String> tecladosVinculados;


    // ---------- CONSTRUCTORES ----------

    /**
     * Constructora de alfabeto vacío
     */
    public Alfabeto() {
        this.nombre = new String();
        this.letras = new ArrayList<>();
        this.tecladosVinculados = new ArrayList<>();
    }

    /**
     * Constructora alfabeto con nombre y contenido asignados.
     * La lista de nombres de teclados vinculados esta vacía inicialmente.
     */
    public Alfabeto(String nombre, ArrayList<Character> letras) {
        this.nombre = nombre;
        this.letras = letras;
        tecladosVinculados = new ArrayList<>();
    }


    // ---------- GETTERS ----------
    /**
     * Devuelve el nombre del alfabeto
     * @return String : Nombre alfabeto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el contenido del alfabeto
     * @return ArrayList<Character> : Contenido del alfabeto usado por las funciones
     */
    public ArrayList<Character> getLetras() {
        return letras;
    }

    /**
     * Devuelve la lista de nombres de los teclados vinculados al alfabeto
     * @return ArrayList<String> : Lista de nombres de los teclados vinculados
     */
    public ArrayList<String> getTecladosVinculados() {
        return tecladosVinculados;
    }


    // ---------- SETTERS ----------
    /**
     * No devuelve nada.
     * @param nomT nombre del teclado a vincular
     * Añade a la lista de nombres de los teclados vinculados el nombre del nuevo teclado nomT
     */
    public void agregarTecladoVinculado (String nomT) {
        tecladosVinculados.add(nomT);
    }

    public void modificarContenido(ArrayList<Character> entradaCaracteres){
        letras = entradaCaracteres;
    }


    // ---------- AUXILIARES ----------
    /**
     * No devuelve nada.
     * @param nomT nombre del teclado a desvincular
     * Borra de la lista de nombres de los teclados vinculados el nombre del teclado nomT
     */
    public void borrarTecladoVinculado(String nomT) {
        tecladosVinculados.remove(nomT);
    }
}