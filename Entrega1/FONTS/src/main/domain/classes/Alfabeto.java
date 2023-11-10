package main.domain.classes;

import java.lang.String;
import java.util.ArrayList;


/**
 * Classe que representa un alfabeto
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class Alfabeto // implements Comparable<Cela>, Serializable
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el nombre introducido por el usuario */
    private String nombre;

    /** Contenido del afabeto */
    private ArrayList<Character> letras;

    /** Guarda lista de teclados vinculados */
    private ArrayList<String> tecladosVinculados;


    // ---------- CONSTRUCTORES ----------
    public Alfabeto()
    {
        nombre = new String();
        letras = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
    }

    public Alfabeto(String nom, ArrayList<Character> letras)
    {
        this.nombre = nom;
        this.letras = letras;
        tecladosVinculados = new ArrayList<>();
    }

    public Alfabeto(String nombre) {
        this.nombre = nombre;
        this.letras = new ArrayList<>();
        this.tecladosVinculados = new ArrayList<>();
    }


    // ---------- GETTERS ----------
    /**
     * Retorna el nombre introducido por el usuario
     * @return String : Nombre introducido por el usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el contenido del alfabeto
     * @return String : Contenido del alfabeto usado por las funciones
     */
    public ArrayList<Character> getLetras() {
        return null;
    }

    public ArrayList<String> getTecladosVinculados() {
        return null;
    }


    // ---------- SETTERS ----------
    public void sobreEscribirLetras(ArrayList<Character> nuevasLetras) {}

    public void agregarTecladoVinculado (String nomT) {}


    // ---------- AUXILIARES ----------
    public void borrarTecladoVinculado(String nomT) {}






    /**
     * INFO EXTRA
    // CREO QUE SON LAS DEL DRIVER
    public void introducirCaracteres()
    {}

    // CREO QUE SON LAS DEL DRIVER
    public void introducirArchivo()
    {}

     * Override del metode equals() de la classe Object
     * @param obj : Objeto con el que comparar
     * @return Boolean : Retorna true solo si el objeto es el mismo
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Alfabeto)) return false;
        if (obj == this) return true;

        return false;
    }

    */

    /** ho comento però no ho elimino, serà inetressant fer metode toString
    @Override
    public String toString() {return _valorUsuari;}
    */
}