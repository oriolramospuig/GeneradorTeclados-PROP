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


    // ---------- CONSTRUCTORES ----------
    /*public Frecuencias() {
        nombre = new String();
        frecuenciaLetras = new HashMap<>();
        asociacionesVinculadas = new ArrayList<>();
    }*/

    public Frecuencias(String nombre) {
        this.nombre = nombre;
        frecuenciaLetras = new HashMap<>();
        asociacionesVinculadas = new ArrayList<>();
        //el controlador llamara a anadirFrecuencia para ir pasando los valores que tocan directamente
    }


    // ---------- GETTERS ----------
    /**
     * Retorna el contenido del texto
     * @return String : Contenido del texto compuesto por pares de letras con sus frecuencias
     * ("ab", 5)
     */
    public String getTexto() {
        StringBuilder texto = new StringBuilder("");
        for (HashMap.Entry<String, Integer> i : frecuenciaLetras.entrySet()) {
            String parejaLetras = i.getKey();
            Integer frecuencia = i.getValue();

            texto.append(parejaLetras).append(" ").append(frecuencia).append("\n");
        }
        return texto.toString();
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
