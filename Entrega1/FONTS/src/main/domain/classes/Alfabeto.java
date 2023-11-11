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
    public Alfabeto(String nombre) {
        this.nombre = nombre;
        this.letras = new ArrayList<>();
        this.tecladosVinculados = new ArrayList<>();
    }
    public Alfabeto(String nombre, ArrayList<Character> letras) {
        this.nombre = nombre;
        this.letras = letras;
        tecladosVinculados = new ArrayList<>();
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
     * @return ArrayList<Character> : Contenido del alfabeto usado por las funciones
     */
    public ArrayList<Character> getLetras() {
        return letras;
    }
    /**
     * Retorna el nombre de los teclados vinculados al alfabeto
     * @return ArrayList<String> : Lista de nombres de los teclados vinculados
     */
    public ArrayList<String> getTecladosVinculados() {
        return tecladosVinculados;
    }

    // ---------- SETTERS ----------
    /**
     * No retorna.
     * Añade a la lista de nombres de los teclados asociados el nombre
     * del nuevo teclado pasado como parámetro
     */
    public void agregarTecladoVinculado (String nomT) {
        tecladosVinculados.add(nomT);
    }

    // ---------- AUXILIARES ----------
    /**
     * No retorna.
     * Borra de la lista de nombres de los teclados asociados el nombre
     * del teclado pasado como parámetro
     */
    public void borrarTecladoVinculado(String nomT) {
        tecladosVinculados.remove(nomT);
    }




    /** ho comento però no ho elimino, serà inetressant fer metode toString
    @Override
    public String toString() {return _valorUsuari;}
    */
}