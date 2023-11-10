package main.domain.classes;

import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairInt;

import java.util.ArrayList;

public class Teclado {

    public enum Algoritmo {
        QAP,
        Alg2
    }

    // ---------- ATRIBUTOS ----------
    /** Guarda el nombre introducido por el usuario */
    private String nombre;

    /** Puntuación del teclado */
    private Float puntuacion;

    private Algoritmo algoritmo;

    private PairInt dimensiones;




    // ---------- CONSTRUCTORES ----------
    public Teclado() {
        nombre = new String();
        puntuacion = new Float(0);
        algoritmo = Algoritmo.QAP;
        dimensiones = new PairInt(0,0);
    }

    public Teclado(String nombre) {
        this.nombre = nombre;
        puntuacion = new Float(0);
        algoritmo = Algoritmo.QAP;
        dimensiones = new PairInt(0,0);
    }

    public Teclado(String nombre, AsociacionTextos asociacionTextos, Alfabeto alfabeto, Algoritmo algoritmo, PairInt dimensiones) {
        this.nombre = nombre;
        this.algoritmo = algoritmo;
        this.dimensiones = dimensiones;
    }


    // ---------- GETTERS ----------
    public String getNombre() {return nombre;}

    public Float getPuntuacion() {return puntuacion;}

    public String getAlgoritmo() {
        if (algoritmo == Algoritmo.QAP) return "QAP";
        else return "Alg2";
    }


    // ---------- SETTERS ----------


    // ---------- AUXILIARES -----------
}



