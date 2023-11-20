package main.domain.classes;

import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairInt;

/**
 * Classe que representa un teclado
 * @author X (X@estudiantat.upc.edu)
 */
public class Teclado
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el nombre introducido por el usuario */
    private String nombre;

    /** Puntuación del teclado */
    private float puntuacion;

    /** Algoritmo usado para el teclado */
    private Algoritmo algoritmo;

    /** Dimensiones del teclado */
    private PairInt dimensiones;

    /** Alfabeto vinculado al teclado */
    private String alfabetoVinculado;

    /** Asociación de textos vinculada al teclado */
    private String asociacionTextosVinculado;


    // ---------- CONSTRUCTORES ----------
    public Teclado() {
        nombre = "";
        puntuacion = 0 ;        //hay que poner valor nulo?
        //algoritmo = Algoritmo.QAP;
        dimensiones = new PairInt(0,0);
        alfabetoVinculado = "";
        asociacionTextosVinculado = "";
    }

    public Teclado(String nombre) {
        this.nombre = nombre;
        puntuacion = 0;
        //algoritmo = Algoritmo.QAP;
        dimensiones =  new PairInt(0,0);
        alfabetoVinculado = "";
        asociacionTextosVinculado = "";
    }

    public Teclado(String nombre, AsociacionTextos asociacionTextos, Alfabeto alfabeto, Algoritmo algoritmo) {
        this.nombre = nombre;
        this.algoritmo = algoritmo;
        this.dimensiones = dimensiones;
        alfabetoVinculado = alfabeto.getNombre();
        asociacionTextosVinculado = asociacionTextos.getNombre();
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
     * Retorna la puntuación del teclado
     * @return Float : Puntuación del teclado calculada mediante el algoritmo de generación
     */
    public float getPuntuacion() {
        return puntuacion;
    }

    /**
     * Retorna el nombre del algoritmo usado para generar el teclado
     * @return String : Nombre del algoritmo usado para generar el teclado
     */
    /*public String getAlgoritmo() {
        if (algoritmo == Algoritmo.QAP) return "QAP";
        else return "Alg2";
    }*/

    /**
     * Retorna las dimensiones del teclado generado
     * @return PairInt : Dimensiones del teclado generado (filas, columnas)
     */
    public PairInt getDimensiones() {
        PairInt dim = new PairInt(0,0);
        dim.setPrimero(dimensiones.getPrimero());
        dim.setSegundo(dimensiones.getSegundo());
        return dim;
    }

    /**
     * Retorna el alfabeto usado para generar el teclado
     * @return String : Nombre del alfabeto vinculado al teclado
     */
    public String getAlfabetoVinculado() {
        return alfabetoVinculado;
    }

    /**
     * Retorna el la asociación de textos usada para generar el teclado
     * @return String : Nombre de la asociación de textos vinculado al teclado
     */
    public String getAsociacionTextosVinculado() {
        return asociacionTextosVinculado;
    }


    // ---------- SETTERS ----------
    /**
     * No retorna.
     * @param puntuacion nueva puntuación del teclado
     * Setea la puntuación con el valor pasado por parámetro puntuación
     */
    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * No retorna.
     * @param dimensiones dimensiones del teclado
     * Pone las dimensiones pasadas por parámetro dimensiones al teclado
     */
    public void setDimensiones(PairInt dimensiones) {
        this.dimensiones = dimensiones;
    }

    /**
     * No retorna.
     * @param nomA nombre del alfabeto a vincular
     * Setea el valor de alfabetoVinculado al nombre del alfabeto pasado por parámetro nomA
     */
    public void agregarAlfabetoVinculado(String nomA) {
        alfabetoVinculado = nomA;
    }

    /**
     * No retorna.
     * @param nomAT nombre de la asociación de textos a vincular
     * Setea el valor de asociacionTextosVinculado al nombre de la asociación de textos
     * pasada por parámetro nomAT
     */
    public void agregarAsociacionTextosVinculado(String nomAT) {
        asociacionTextosVinculado = nomAT;
    }


    // ---------- AUXILIARES -----------
    /**
     * No retorna.
     * @param nomA nombre del alfabeto anterior
     * Desvincula el alfabetoVinculado dejandolo a null
     */
    public void borrarAlfabetoVinculado(String nomA) {
        alfabetoVinculado = null;
    }

    /**
     * No retorna.
     * @param nomAT nombre de la asociación de textos anterior
     * Desvincula la asociacionTextosVinculado dejandola a null
     */
    public void borrarAsociacionTextosVinculados(String nomAT) {
        asociacionTextosVinculado = null;
    }
}



