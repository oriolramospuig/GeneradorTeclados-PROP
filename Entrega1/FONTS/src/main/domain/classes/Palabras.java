package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un Texto del tipo Palabras
 * @author Júlia
 */
public class Palabras extends Texto
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de palabras que conforman el texto */
    private String texto;


    // ---------- CONSTRUCTORES ----------
    /** Crea una instancia de la clase Palabras e inicializa los atributos de esta clase con los valores correspondientes
     * @param nombre nombre que adquiere el Texto de Tipo Palabras creada
     * @param texto String que contiene las palabras que forman el texto creado
     * @param frecuenciaLetras HashMap que contiene los pares de letras y sus respectivas frecuencias del Texto del Tipo Palabras creado
     */
     public Palabras(String nombre, String texto, HashMap<String, Integer> frecuenciaLetras) {
        this.nombre = nombre;
        this.texto = texto;
        this.frecuenciaLetras = frecuenciaLetras;
        asociacionesVinculadas = new ArrayList<>();
     }


    // ---------- GETTERS ----------
    /**
     * Devuelve el contenido, es decir, texto, del Texto de Tipo Palabras
     * @return String: Contenido del texto compuesto por palabras
     */
    public String getTexto() {
        return texto;
    }

    /** No devuelve nada. Imprime los valores de frecuenciaLetras */
    public void imprimirFrecuencias(){
        for(Map.Entry<String,Integer> e : frecuenciaLetras.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }


}
