package main.domain.classes;

import main.domain.classes.types.PairFrequency;
import main.domain.classes.types.PairString;

import java.util.ArrayList;
import java.util.HashMap;

public class AsociacionTextos {
    // ---------- ATRIBUTOS ----------
    /** Guarda el nombre introducido por el usuario */
    private String nombre;

    private ArrayList<String> textosAsociaciados;

    private ArrayList<String> tecladosVinculados;

    private HashMap<PairString<String,String>, Integer> frecuenciaLetras;


    // ---------- CONSTRUCTORES ----------
    public AsociacionTextos() {
        nombre = new String();
        textosAsociaciados = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
        frecuenciaLetras = new HashMap<>();
    }

    public AsociacionTextos(String nombre, HashMap<PairString<String,String>, Integer> frecuenciaLetras) {
        this.nombre = nombre;
        this.frecuenciaLetras = frecuenciaLetras;
        textosAsociaciados = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
    }

    public AsociacionTextos(String nombre) {
        this.nombre = nombre;
        frecuenciaLetras = new HashMap<>();
        textosAsociaciados = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
    }


    // ---------- GETTERS ----------
    public String getNombre() {return nombre;}

    public ArrayList<String> getTextosAsociaciados() { return null;}

    public ArrayList<String> getTecladosVinculados() { return null;}

    public ArrayList<PairFrequency> getFrecuenciaLetras() { return null;}


    // ---------- SETTERS ----------
    public void agregarTecladoVinculado (String nomT) {}

    public void agregarTexto (Texto texto) {}


    // ---------- AUXILIARES -----------
    public void borrarTecladoVinculado (String nomT) {}

    public void borrarTexto (String nomTexto) {}

}
