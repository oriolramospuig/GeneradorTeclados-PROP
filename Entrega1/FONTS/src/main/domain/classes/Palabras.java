package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

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
 /*   public Palabras() {
        nombre = new String();
        frecuenciaLetras = new HashMap<>();
        asociacionesVinculadas = new ArrayList<>();
        texto = new String();
    }
  */

    public Palabras(String nombre, String contenido) {
        this.nombre = nombre;
        this.texto = contenido;
        frecuenciaLetras = new HashMap<>();
        asociacionesVinculadas = new ArrayList<>();
        tratarEntrada();
    }

    // ---------- GETTERS ----------
    /**
     * Retorna el contenido del texto
     * @return String : Contenido del texto compuesto por palabras
     */
    public String getTexto() {
        return texto;
    }


    // ---------- SETTERS ----------


    // ---------- AUXILIARES -----------
    /**
     * No retorna.
     * Convierte las palabras de la entrada en frecuencias del estilo par de letras, frecuencia ("ab", 5)
     */
    public void tratarEntrada() {
        char[] textoChars = texto.toCharArray();
        for(int i = 1; i < textoChars.length; ++i){
            String pairLetras = "" + textoChars[i-1] + textoChars[i];
            int frec = 1;
            if(frecuenciaLetras.containsKey(pairLetras)){
                frec = frecuenciaLetras.get(pairLetras)+1;
            }
            frecuenciaLetras.put(pairLetras,frec);
        }
    }
}
