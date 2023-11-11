package main.domain.classes;

import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairInt;

public class Teclado
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el nombre introducido por el usuario */
    private String nombre;

    /** Puntuación del teclado */
    private Float puntuacion;

    private Algoritmo algoritmo;

    private PairIntEnum dimensiones;

    private String alfabetoVinculado;

    private String asociacionTextosVinculado;


    // ---------- CONSTRUCTORES ----------
    public Teclado() {
        nombre = new String();
        puntuacion = new Float(0);
        algoritmo = Algoritmo.QAP;
        dimensiones = PairIntEnum.EMPTY_PAIR;
        alfabetoVinculado = new String();
        asociacionTextosVinculado = new String();
    }

    public Teclado(String nombre) {
        this.nombre = nombre;
        puntuacion = new Float(0);
        algoritmo = Algoritmo.QAP;
        dimensiones = PairIntEnum.EMPTY_PAIR;
        alfabetoVinculado = new String();
        asociacionTextosVinculado = new String();
    }

    public Teclado(String nombre, AsociacionTextos asociacionTextos, Alfabeto alfabeto, Algoritmo algoritmo, PairIntEnum dimensiones) {
        this.nombre = nombre;
        this.algoritmo = algoritmo;
        this.dimensiones = dimensiones;
        alfabetoVinculado = alfabeto.getNombre();
        asociacionTextosVinculado = asociacionTextos.getNombre();
    }


    // ---------- GETTERS ----------
    public String getNombre() {
        return nombre;
    }

    public Float getPuntuacion() {
        return puntuacion;
    }

    public String getAlgoritmo() {
        if (algoritmo == Algoritmo.QAP) return "QAP";
        else return "Alg2";
    }

    public PairInt getDimensiones() {
        PairInt dim = new PairInt(0,0);
        dim.setPrimero(dimensiones.getFila());
        dim.setSegundo(dimensiones.getColumna());
        return dim;
    }

    public String getAlfabetoVinculado() {
        return alfabetoVinculado;
    }

    public String getAsociacionTextosVinculado() {
        return asociacionTextosVinculado;
    }


    // ---------- SETTERS ----------
    public void setPuntuacion(Float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setDimensiones(PairIntEnum dimensiones) {
        this.dimensiones = dimensiones;
    }

    public void agregarAlfabetoVinculado(String nomA) {
        alfabetoVinculado = nomA;
    }

    public void agregarAsociacionTextosVinculado(String nomAT) {
        asociacionTextosVinculado = nomAT;
    }


    // ---------- AUXILIARES -----------
    public void borrarAlfabetoVinculado(String nomA) {
        alfabetoVinculado = null;
    }

    public void borrarAsociacionTextosVinculados(String nomAT) {
        asociacionTextosVinculado = null;
    }
}



