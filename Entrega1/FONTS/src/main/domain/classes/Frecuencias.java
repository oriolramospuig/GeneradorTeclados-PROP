package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un Texto del tipo Frecuencias
 * @author ...
 */
public class Frecuencias extends Texto
{
    // ---------- ATRIBUTOS ----------
    /** Guarda la lista de palabras que contienen el texto y su frecuencia ("hola", 5) */
    protected HashMap<String, Integer> frecuenciaPalabras;


    // ---------- CONSTRUCTORES ----------
    /** Crea una instancia de la clase Frecuencias e inicializa los atributos de esta clase con los valores correspondientes
     * @param nombre nombre que adquiere el Texto de Tipo Frecuencia creada
     * @param frecuenciaPalabras HashMap que contiene las palabras con sus frecuencias
     * @param frecuenciaLetras HashMap que contiene los pares de letras y sus respectivas frecuencias del Texto del Tipo Frecuencias creado
     */
     public Frecuencias(String nombre, HashMap<String, Integer> frecuenciaPalabras, HashMap<String, Integer> frecuenciaLetras) {
        this.nombre = nombre;
        this.frecuenciaPalabras = frecuenciaPalabras;
        this.frecuenciaLetras = frecuenciaLetras;
        asociacionesVinculadas = new ArrayList<>();
     }

    /** No devuelve nada. Imprime los valores de los atributos frecuenciaPalabras y frecuenciaLetras */
    public void imprimirFrecuencias(){
        System.out.println("PALABRAS:");
        for(Map.Entry<String,Integer> e : frecuenciaPalabras.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
        System.out.println("LETRAS:");
        for(Map.Entry<String,Integer> e : frecuenciaLetras.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }


    // ---------- GETTERS ----------
    /**
     * Devuelve el contenido, es decir, frecuenciaPalabras, del Texto de Tipo Frecuencias
     * @return String: Contenido del texto compuesto por pares de palabras con sus frecuencias ("ab", 5)
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

    /**
     * Devuelve el map de pares de palabras con sus frecuencias
     * @return HashMap<String,Integer>: Map de frecuenciaPalabras
     */
     public HashMap<String, Integer> getFrecuenciaPalabras() {
        return frecuenciaPalabras;
    }


    // ---------- SETTERS ----------
    /**
     * No devuelve nada. Añade el par de letras con su frecuencia (parejaLetras, frecuencia) a frecuenciasLetras, estructura donde las guardamos
     * @param parejaLetras pareja de caracteres del texto
     * @param frecuencia frecuencia del par de palabras parejaLetras
     *
     */
    //PARA LA SEGUNDA ENTREGA
     public void anadirFrecuencia(String parejaLetras, Integer frecuencia) {
        frecuenciaLetras.put(parejaLetras, frecuencia);
     }


    // ---------- AUXILIARES -----------
}
