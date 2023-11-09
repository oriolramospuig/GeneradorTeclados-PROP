package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;

/**
 * Classe que representa un texto
 * @author
 */
public class Texto
{
    // ---------- ATRIBUTOS COMUNES ----------
    /** Guarda el nombre introducido por el usuario */
    private String nombre;

    private HashMap<String, int> frecuenciaLetras; //String: parejaLetras, int: frecuencia

    private ArrayList<pair<String, String>> asociacionVinculo;


    // ---------- CONSTRUCTORES ----------
    public Texto() {
        nombre = new String();
        contenidoPalabras = new ArrayList<>();
        contenidoFrecuencias = new HashMap<>();
    }

    public Texto(String nom, ArrayList<String> cont) {
        this.nombre = nom;
        this.contenidoPalabras = cont;
    }

    public Texto(String nom, HashMap<String, Integer> frec) {
        this.nombre = nom;
        this.contenidoFrecuencias = frec;
    }

    // ---------- GETTERS ----------
    /**
     * Retorna el nombre introducido por el usuario
     * @return String : Nombre introducido por el usuario
     */
    public String getNombre() { return nombre; }

    /**
     * Retorna el contenido del texto (lista de palabras)
     * @return String : Contenido del texto usado por las funciones
     */
    public ArrayList<String> getContenidoPalabras()
    {
        return contenidoPalabras;
    }

    /**
     * Retorna el contenido del texto (lista de frecuencias)
     * @return String : Contenido del texto usado por las funciones
     */
    public HashMap<String, Integer> getContenidoFrecuencias()
    {
        return contenidoFrecuencias;
    }

    // ---------- SETTERS ----------
    /**
     *  Modifica el contenido del texto (lista de palabras)
     *  @param Contenido : El nuevo contenido del texto
     *
     */
    public void setContenidoPalabras(ArrayList<String> Contenido)
    {
        contenidoPalabras = Contenido;
    }

    /**
     *  Modifica el contenido del texto (lista de frecuencias)
     *  @param Contenido : El nuevo contenido del texto
     *
     */
    public void setContenidoFrecuencias(HashMap<String, Integer> Contenido)
    {
        contenidoFrecuencias = Contenido;
    }

    public void setNombre(String nom)
    {
        nombre = nom;
    }

    // ---------- AUXILIARES ----------
    /**
     * Override del metode equals() de la classe Object
     * @param obj : Objeto con el que comparar
     * @return Boolean : Retorna true solo si el objeto es el mismo
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Alfabeto)) return false;
        if (obj == this) return true;

        return false;
    }

    // CREO QUE SON LAS DEL DRIVER
    public void introducirCaracteres()
    {}

    // CREO QUE SON LAS DEL DRIVER
    public void introducirArchivo()
    {}

    // ESTA MEJOR EN CONJ DE TEXTOS NO?
    public boolean nombreDisponible(String nombre)
    {return false;}

    // ESTA CREO QUE MEJOR EN LA CLASE IN/OUT
    public boolean contenidoPalabrasValido(ArrayList<String> contenidoPalabras)
    {return false;}

    // ESTA CREO QUE MEJOR EN LA CLASE IN/OUT
    public boolean contenidoFrecuenciasValido(HashMap<String, Integer> contenidoFrecuencias)
    {return false;}

    public boolean formatoValido()
    {return false;}

    public void getAsociacion()
    {}
}

public class Frecuencias extends Texto
{
    // ---------- ATRIBUTOS ----------
    /** ... */
    private String texto;

}

public class Palabras extends Texto
{
    // ---------- ATRIBUTOS ----------
    /** ... */
    private String texto;

}