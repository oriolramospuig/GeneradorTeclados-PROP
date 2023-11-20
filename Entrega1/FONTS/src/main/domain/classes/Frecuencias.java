package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa un texto en formato pares de letras con sus frecuencias
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class Frecuencias extends Texto
{
    // ---------- ATRIBUTOS ----------
    /** Guarda la lista de palabras que contienen el texto y su frecuencia ("hola", 5) */
    protected HashMap<String, Integer> frecuenciaPalabras;


    // ---------- CONSTRUCTORES ----------
    /*public Frecuencias() {
        nombre = new String();
        frecuenciaLetras = new HashMap<>();
        asociacionesVinculadas = new ArrayList<>();
    }*/

    public Frecuencias(String nombre, HashMap<String, Integer> frecuenciaPalabras, HashMap<String, Integer> frecuenciaLetras) {
        this.nombre = nombre;
        this.frecuenciaPalabras = frecuenciaPalabras;
        this.frecuenciaLetras = frecuenciaLetras;
        asociacionesVinculadas = new ArrayList<>();
    }


    // ---------- GETTERS ----------
    /**
     * Retorna el contenido del texto
     * @return String : Contenido del texto compuesto por pares de letras con sus frecuencias
     * ("ab", 5)
     */
    /*public String getTexto() {
        StringBuilder texto = new StringBuilder("");
        for (HashMap.Entry<String, Integer> i : frecuenciaLetras.entrySet()) {
            String parejaLetras = i.getKey();
            Integer frecuencia = i.getValue();

            texto.append(parejaLetras).append(" ").append(frecuencia).append("\n");
        }
        return texto.toString();
    }
     */
    public String getTexto() {
        StringBuilder texto = new StringBuilder("");
        for (HashMap.Entry<String, Integer> i : frecuenciaPalabras.entrySet()) {
            String palabra = i.getKey();
            Integer frecuencia = i.getValue();

            texto.append(palabra).append(" ").append(frecuencia).append("\n");
        }
        return texto.toString();
    }

    public HashMap<String, Integer> getFrecuenciaPalabras() {
        return frecuenciaPalabras;
    }


    // ---------- SETTERS ----------
    /**
     * No retorna.
     * @param parejaLetras pareja de caracteres del texto
     * @param frecuencia frecuencia del par de palabras parejaLetras
     * Añade el par de letras con su frecuencia (parejaLetras, frecuencia)
     * a frecuenciasLetras, estructura donde las guardamos
     */
    public void anadirFrecuencia(String parejaLetras, Integer frecuencia) {
        frecuenciaLetras.put(parejaLetras, frecuencia);
    }


    // ---------- AUXILIARES -----------
}
