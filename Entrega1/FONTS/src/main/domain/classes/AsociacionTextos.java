package main.domain.classes;

import main.domain.classes.types.PairFrequency;

import java.util.*;

/** Clase que implementa un comparador de frecuencias
 * @author X (X@estudiantat.upc.edu)
 */
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

/** Clase que implementa una asociación de textos
 * @author X (X@estudiantat.upc.edu)
 */
public class AsociacionTextos
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el nombre introducido por el usuario */
    private String nombre;

    /** Guarda la lista de textos de los que está compuesta la asociación */
    private ArrayList<String> textosAsociaciados;

    /** Guarda la lista de teclados que se han creado a partir de la asociacion */
    private ArrayList<String> tecladosVinculados;

    /** Guarda el map que asocia pares de letras ("ab") con sus frecuencias ("20") */
    private HashMap<String, Integer> frecuenciaLetras;


    // ---------- CONSTRUCTORES ----------
    /** Crea una instancia de la clase AsociacionTextos e inicializa las variables como vacías */
    public AsociacionTextos() {
        nombre = new String();
        textosAsociaciados = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
        frecuenciaLetras = new HashMap<>();
    }

    /** Crea una instancia de la clase AsociacionTextos e inicializa las variables como vacías, excepto nombre y frecuenciaLetras que se les asignan valores
     * @param nombre nombre que adquiere la AsociacionTextos creada
     * @param frecuenciaLetras HashMap que contiene los pares de letras y sus respectivas frecuencias de la AsociacionTextos creada
     */
    public AsociacionTextos(String nombre, HashMap<String, Integer> frecuenciaLetras) {
        this.nombre = nombre;
        this.frecuenciaLetras = frecuenciaLetras;
        textosAsociaciados = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
    }

    /** Crea una instancia de la clase AsociacionTextos e inicializa las variables como vacías, excepto nombre que se le asigna un valor específico
     * @param nombre nombre que adquiere la AsociacionTextos creada
     */
    public AsociacionTextos(String nombre) {
        this.nombre = nombre;
        frecuenciaLetras = new HashMap<>();
        textosAsociaciados = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
    }


    // ---------- GETTERS ----------
    /**
     * Devuelve el nombre introducido por el usuario
     * @return String: Nombre introducido por el usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el nombre de los textos asociados
     * @return ArrayList<String>: Lista de nombres de los textos asociados
     */
    public ArrayList<String> getTextosAsociaciados() {
        return textosAsociaciados;
    }

    /**
     * Devuelve el nombre de los teclados vinculados a la asocciación de textos
     * @return ArrayList<String>: Lista de nombres de los teclados vinculados
     */
    public ArrayList<String> getTecladosVinculados() {
        return tecladosVinculados;
    }

    /**
     * Devuelve el map de pares de letras con sus frecuencias
     * @return HashMap<String,Integer>: Map de frecuenciaLetras
     */
    public HashMap<String,Integer> getFrecuenciaLetras() {
        return frecuenciaLetras;
    }

    /**
     * Devuelve los pares String, Integer de los pares de letras con sus frecuencias ordenados
     * @return ArrayList<PairFrequency>: Lista de pares de letras y frecuencias ordenados
     */
    public ArrayList<PairFrequency> getFrecuenciaLetrasArray() {
        ArrayList<PairFrequency> freq = new ArrayList<>();
        for(HashMap.Entry<String, Integer> e : frecuenciaLetras.entrySet()){
            PairFrequency pf = new PairFrequency(e.getKey(),e.getValue());
            freq.add(pf);
        }
        Collections.sort(freq,new FrequencyComparator());
        return freq;
    }


    // ---------- SETTERS ----------
    /**
     * No devuelve nada. Añade a la lista de nombres de los teclados vinculados el nombre del nuevo teclado nomT
     * @param nomT nombre del teclado a vincular
     */
    public void agregarTecladoVinculado (String nomT) {
        tecladosVinculados.add(nomT);
    }

    /**
     * No devuelve nada. Añade a la lista de nombres de los textos asociados el nombre del nuevo texto
     * @param texto texto a agregar a la asociación
     */
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
    // Segunda entrega
    /**
     * No devuelve nada. Borra de la lista de nombres de los teclados vinculados el nombre del teclado nomT
     * @param nomT nombre del teclado a desvincular
     */
    public void borrarTecladoVinculado (String nomT) {
        tecladosVinculados.remove(nomT);
    }

    //Segunda entrega
    /**
     * No devuelve nada. Borra de la lista de nombres de los textos asociados el nombre del texto nomT
     * @param nomT nombre del texto a quitar de la asociación
     */
    public void borrarTexto (String nomT) {
        textosAsociaciados.remove(nomT);
    }
}