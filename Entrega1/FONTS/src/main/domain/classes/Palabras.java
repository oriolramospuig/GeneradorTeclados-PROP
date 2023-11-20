package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un texto en formato lista de palabras
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class Palabras extends Texto
{
    // ---------- ATRIBUTOS ----------
    /** Contenido del texto (lista de palabras) */
    private String texto;


    // ---------- CONSTRUCTORES ----------

    public Palabras(String nombre, String contenido, HashMap<String, Integer> frecuenciaLetras) {
        this.nombre = nombre;
        this.texto = contenido;
        this.frecuenciaLetras = frecuenciaLetras;
        asociacionesVinculadas = new ArrayList<>();
    }

    // ---------- GETTERS ----------
    /**
     * Retorna el contenido del texto
     * @return String : Contenido del texto compuesto por palabras
     */
    public String getTexto() {
        return texto;
    }
    public void imprimirFrecuencias(){
        for(Map.Entry<String,Integer> e : frecuenciaLetras.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    // ---------- SETTERS ----------


    // ---------- AUXILIARES -----------

}
