package main.domain.classes;

import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairInt;

/**
 * Classe que representa un teclado
 * @author Júlia
 */
public class Teclado
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el nombre introducido por el usuario*/
    private String nombre;

    /** Puntuación del teclado */
    private float puntuacion;

    /** Dimensiones del teclado */
    private PairInt dimensiones;

    /** Alfabeto vinculado al teclado */
    private String alfabetoVinculado;

    /** Asociación de textos vinculada al teclado */
    private String asociacionTextosVinculado;

    /** Contenido del teclado, generado por el algoritmo */
    private char[][] contenido;


    // ---------- CONSTRUCTORAS ----------
    /**
     * Constructora de la clase Teclado
     */
    public Teclado(String nombre, AsociacionTextos asociacionTextos, Alfabeto alfabeto, PairInt dimensiones, char[][] contenido) {
        this.nombre = nombre;
        // this.algoritmo = algoritmo;
        this.dimensiones = dimensiones;
        this.alfabetoVinculado = alfabeto.getNombre();
        this.asociacionTextosVinculado = asociacionTextos.getNombre();
        this.contenido = contenido;
    }


    // ---------- GETTERS --------------
    /**
     * Devuelve el nombre introducido por el usuario
     * @return String: nombre introducido por el usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la puntuación del teclado
     * @return float: Puntuación del teclado calculada debido al algoritmo
     */
    public float getPuntuacion() {
        return puntuacion;
    }

    /**
     * Devuelve las dimensiones del teclado generado
     * @return PairInt : Dimensiones del teclado generado (filas, columnas)
     */
    public PairInt getDimensiones() {
        PairInt dim = new PairInt(0,0);
        dim.setPrimero(dimensiones.getPrimero());
        dim.setSegundo(dimensiones.getSegundo());
        return dim;
    }

    /**
     * Devuelve el alfabeto usado para generar el teclado
     * @return String : Nombre del alfabeto vinculado al teclado
     */
    public String getAlfabetoVinculado() {
        return alfabetoVinculado;
    }

    /**
     * Devuelve el la asociación de textos usada para generar el teclado
     * @return String : Nombre de la asociación de textos vinculado al teclado
     */
    public String getAsociacionTextosVinculado() {
        return asociacionTextosVinculado;
    }

    /**
     * Devuelve el contenido del teclado, mediante la distribución de las letras
     * @return int[][] : Contenido del teclado
     */
    public char[][] getContenido() {return contenido; }


    // ---------- SETTERS ----------
    /**
     * No devuelve nada.
     * @param puntuacion nueva puntuación del teclado
     * Setea la puntuación con el valor pasado por parámetro puntuación
     */
    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * No devuelve nada.
     * @param dimensiones dimensiones del teclado
     * Pone las dimensiones pasadas por parámetro dimensiones al teclado
     */
    public void setDimensiones(PairInt dimensiones) {
        this.dimensiones = dimensiones;
    }

    /**
     * No devuelve nada.
     * @param nomA nombre del alfabeto a vincular
     * Setea el valor de alfabetoVinculado al nombre del alfabeto pasado por parámetro nomA
     */
    public void agregarAlfabetoVinculado(String nomA) {
        alfabetoVinculado = nomA;
    }

    /**
     * No devuelve nada.
     * @param nomAT nombre de la asociación de textos a vincular
     * Setea el valor de asociacionTextosVinculado al nombre de la asociación de textos
     * pasada por parámetro nomAT
     */
    public void agregarAsociacionTextosVinculado(String nomAT) {
        asociacionTextosVinculado = nomAT;
    }


    // ---------- AUXILIARES -----------
    /**
     * No devuelve nada.
     * @param nomA nombre del alfabeto anterior
     * Desvincula el alfabetoVinculado dejandolo a null
     */
    //Segunda entrega
    public void borrarAlfabetoVinculado(String nomA) {
        alfabetoVinculado = null;
    }

    /**
     * No devuelve nada.
     * @param nomAT nombre de la asociación de textos anterior
     * Desvincula la asociacionTextosVinculado dejandola a null
     */
    //Segunda entrega
    public void borrarAsociacionTextosVinculados(String nomAT) {
        asociacionTextosVinculado = null;
    }
}