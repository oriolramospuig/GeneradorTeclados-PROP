package main.domain.classes;

import main.domain.classes.types.PairFrequency;

import java.util.*;

class FrequencyComparator implements Comparator<PairFrequency> {
    // override the compare() method
    public int compare(PairFrequency pf1, PairFrequency pf2)
    {
        if (pf1.getFrequency() > pf2.getFrequency())
            return -1;
        if (pf1.getFrequency() < pf2.getFrequency())
            return 1;
        else if(pf1.getPair().compareTo(pf2.getPair()) < 0) return -1;
        return 1;
    }
}

public class AsociacionTextos {
    // ---------- ATRIBUTOS ----------
    /** Guarda el nombre introducido por el usuario */
    private String nombre;

    private ArrayList<String> textosAsociaciados;

    private ArrayList<String> tecladosVinculados;

    private HashMap<String, Integer> frecuenciaLetras;


    // ---------- CONSTRUCTORES ----------
    public AsociacionTextos() {
        nombre = new String();
        textosAsociaciados = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
        frecuenciaLetras = new HashMap<>();
    }

    public AsociacionTextos(String nombre, HashMap<String, Integer> frecuenciaLetras) {
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
    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getTextosAsociaciados() {
        return textosAsociaciados;
    }

    public ArrayList<String> getTecladosVinculados() {
        return tecladosVinculados;
    }

    public ArrayList<PairFrequency> getFrecuenciaLetras() {
        ArrayList<PairFrequency> freq = new ArrayList<>();
        for(HashMap.Entry<String, Integer> e : frecuenciaLetras.entrySet()){
            PairFrequency pf = new PairFrequency(e.getKey(),e.getValue());
            freq.add(pf);
        }
        Collections.sort(freq,new FrequencyComparator());
        return freq;
    }


    // ---------- SETTERS ----------
    public void agregarTecladoVinculado (String nomT) {
        tecladosVinculados.add(nomT);
    }

    public void agregarTexto (Texto texto) {
        textosAsociaciados.add(texto.getNombre());
        HashMap<String,Integer> freqTexto = texto.getFrecuenciaLetras();

        for(Map.Entry<String,Integer> e : freqTexto.entrySet()){
            Integer frec = e.getValue();
            if(frecuenciaLetras.containsKey(e.getKey())) {
                frec = frecuenciaLetras.get(e.getKey()) + e.getValue();
            }
            frecuenciaLetras.put(e.getKey(),frec);
        }
    }

    // ---------- AUXILIARES -----------
    public void borrarTecladoVinculado (String nomT) {
        tecladosVinculados.remove(nomT);
    }

    public void borrarTexto (String nomT) {
        textosAsociaciados.remove(nomT);
        /* al borrar un texto frecuenciaLetras cambiara, entones
        IMPORTANTE llamar a getFrecuenciaLetras cada vez que se cree un teclado!!!
         */
    }
}