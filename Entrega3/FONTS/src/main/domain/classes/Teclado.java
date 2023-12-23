package main.domain.classes;

import main.domain.classes.types.PairInt;

import java.io.Serializable;

/**
 * Representa un teclado en el contexto de un problema de asignación cuadrática (QAP).
 * Almacena información sobre la configuración y propiedades del teclado, incluyendo su nombre,
 * dimensiones, contenido, y puntuación asignada según un algoritmo específico.
 * Esta clase es serializable para facilitar el almacenamiento y recuperación de los teclados.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class Teclado implements Serializable
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el nombre introducido por el usuario. */
    private String nombre;

    /** Puntuación del teclado. */
    private int puntuacion;

    /** Dimensiones del teclado. */
    private PairInt dimensiones;

    /** Alfabeto vinculado al teclado. */
    private String alfabetoVinculado;

    /** Asociación de textos vinculada al teclado. */
    private String asociacionTextosVinculado;

    /** Contenido del teclado, generado por el algoritmo. */
    private char[][] contenido;


    // ---------- CONSTRUCTORAS ----------
    /**
     * Constructor de la clase Teclado.
     * Inicializa un nuevo teclado con las propiedades especificadas.
     *
     * @param nombre Nombre del teclado.
     * @param asociacionTextos Asociación de textos que se relaciona con el teclado.
     * @param alfabeto Alfabeto utilizado en el teclado.
     * @param dimensiones Dimensiones del teclado (filas y columnas).
     * @param contenido Contenido del teclado, representado como un arreglo bidimensional de caracteres.
     * @param puntuacion Puntuación del teclado calculada por un algoritmo.
     */
    public Teclado(String nombre, AsociacionTextos asociacionTextos, Alfabeto alfabeto, PairInt dimensiones, char[][] contenido, int puntuacion) {
        this.nombre = nombre;
        this.dimensiones = dimensiones;
        this.alfabetoVinculado = alfabeto.getNombre();
        this.asociacionTextosVinculado = asociacionTextos.getNombre();
        this.contenido = contenido;
        this.puntuacion = puntuacion;
    }


    // ---------- GETTERS --------------
    /**
     * Devuelve el nombre introducido por el usuario.
     *
     * @return String: nombre introducido por el usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la puntuación del teclado.
     *
     * @return int: Puntuación del teclado calculada debido al algoritmo.
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * Devuelve las dimensiones del teclado generado.
     *
     * @return PairInt : Dimensiones del teclado generado (filas, columnas).
     */
    public PairInt getDimensiones() {
        PairInt dim = new PairInt(0,0);
        dim.setPrimero(dimensiones.getPrimero());
        dim.setSegundo(dimensiones.getSegundo());
        return dim;
    }

    /**
     * Devuelve el alfabeto usado para generar el teclado.
     *
     * @return String : Nombre del alfabeto vinculado al teclado.
     */
    public String getAlfabetoVinculado() {
        return alfabetoVinculado;
    }

    /**
     * Devuelve el la asociación de textos usada para generar el teclado.
     *
     * @return String : Nombre de la asociación de textos vinculado al teclado.
     */
    public String getAsociacionTextosVinculado() {
        return asociacionTextosVinculado;
    }

    /**
     * Devuelve el contenido del teclado, mediante la distribución de las letras.
     *
     * @return int[][] : Contenido del teclado.
     */
    public char[][] getContenido() {return contenido; }


    // ---------- SETTERS ----------
    /**
     * No devuelve nada.
     * Setea el valor de alfabetoVinculado al nombre del alfabeto pasado por parámetro nomA.
     *
     * @param nomA nombre del alfabeto a vincular.
     */
    public void agregarAlfabetoVinculado(String nomA) {
        alfabetoVinculado = nomA;
    }

    /**
     * No devuelve nada.
     * Setea el valor de asociacionTextosVinculado al nombre de la asociación de textos
     * pasada por parámetro nomAT.
     *
     * @param nomAT nombre de la asociación de textos a vincular.
     */
    public void agregarAsociacionTextosVinculado(String nomAT) {
        asociacionTextosVinculado = nomAT;
    }
}