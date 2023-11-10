package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa un texto
 * @author
 */
abstract class Texto
{
    // ---------- ATRIBUTOS COMUNES ----------
    /** Guarda el nombre introducido por el usuario */
    protected String nombre;

    protected String texto;
    protected HashMap<String, Integer> frecuenciaLetras; //string: parejaLetras, int: frecuencia

    protected ArrayList<String> asociacionesVinculadas;


    // ---------- CONSTRUCTORES ----------
    public Texto() {
        nombre = new String();
        frecuenciaLetras = new HashMap<>();
        asociacionesVinculadas = new ArrayList<>();
    }


    // ---------- GETTERS ----------
    /**
     * Retorna el nombre introducido por el usuario
     * @return String : Nombre introducido por el usuario
     */
    public String getNombre() { return nombre; }

    public HashMap<String, Integer> getFrecuenciaLetras()
    {
        return null;
    }

    /**
     * Retorna el contenido del texto (lista de palabras)
     * @return String : Contenido del texto usado por las funciones
     */
    public ArrayList<String> getAsociacionesVinculadas()
    {
        return null;
    }

    public String getTexto() {
        return texto;
    }



    // ---------- SETTERS ----------
    /* creo que no hace falta
    public void setNombre(String nom) {
        nombre = nom;
    }
    */
    public void agregarAsociacionesVinculadas(String nomAT) {}


    // ---------- AUXILIARES ----------
    public void borrarAsociacionesVinculadas(String nomAT) {}

    abstract void tratarEntrada();
}

