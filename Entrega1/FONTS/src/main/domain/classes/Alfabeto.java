package main.domain.classes;

import java.io.*;
import java.lang.String;
import java.lang.Comparable;


/**
 * Classe que representa un alfabeto
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class Alfabeto // implements Comparable<Cela>, Serializable
{
    /** Guarda el nombre introducido por el usuario */
    private String nombre;

    /**
     * Contenido del afabeto */
    private String contenido;

    // ---------- CONSTRUCTORES ----------
    public Alfabeto()
    {
        nombre = new String();
        contenido = null;
    }

    public Alfabeto(String contenido) { this.setContenido(contenido); }

    // ---------- GETTERS ----------

    /**
     * Retorna el nombre introducido por el usuario
     * @return String : Nombre introducido por el usuario
     */
    public String getNombre() { return nombre; }

    /**
     * Retorna el contenido del alfabeto
     * @return String : Contenido del alfabeto usado por las funciones
     */
    public String getContenido()
    {
        return contenido;
    }

    // ---------- SETTERS ----------
    /**
     *  Modifica el contenido del alfabeto
     *  @param Contenido : El nuevo contenido del alfabeto
     *
     */
    public void setContenido(String Contenido)
    {
        contenido = Contenido;
    }

    public void setNombre(String nom)
    {
        nombre = nom;
    }

    /**
     * Override del metode equals() de la classe Object
     * @param obj : Object amb el que comparar
     * @return Boolean : Retorna true solo si el objeto es el mismo
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Alfabeto)) return false;
        if (obj == this) return true;

        return false;
    }

    // ho comento però no ho elimino, serà inetressant fer metode toString
    //@Override
    //public String toString() {return _valorUsuari;}
}