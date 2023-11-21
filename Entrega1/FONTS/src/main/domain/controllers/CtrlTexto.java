package main.domain.controllers;

import main.domain.classes.*;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

/** Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar textos */
public class CtrlTexto
{
    // ---------- PARÁMETROS ----------
    /** Representa conjunto de textos dentro del controlador para gestioanr y manipular los textos */
    private ConjuntoTextos CjtTextos;

    //se usa?
    private ConjuntoTeclados CjtTeclados;
    // private ConjuntoAsociaciones CjtAsociaciones;


    // ---------- CONSTRUCTORA ----------
    /** Inicializa el conjunto de textos */
    public CtrlTexto(){
        CjtTextos = new ConjuntoTextos();
    }


    // ---------- FUNCIONES TEXTO ----------
    /**
     * Obtiene el contenido de un texto dado su nombre
     * @param nomT Nombre del texto
     * @return Contenido del texto
     */
    public String getContenido(String nomT){
        //return CjtTextos.getTexto(nomT).getFrecuenciaPalabras();
        return CjtTextos.getTexto(nomT).getTexto();
    }

    /**
     * No devuelve nada. Agrega una asociación vinculada a un texto dado su nombre
     * @param nomT Nombre del texto
     * @param nomAT Nombre de la asociación de textos
     */
    public void agregarAsociacionVinculada(String nomT, String nomAT){
        CjtTextos.getTexto(nomT).agregarAsociacionesVinculadas(nomAT);
    }

    // ---------- FUNCIONES CONJUNTOTEXTOS ----------
    /**
     * Obtiene un objeto Texto dado su nombre
     * @param nomT Nombre del texto
     * @return Objeto Texto
     */
    public Texto getTexto(String nomT){
        return CjtTextos.getTexto(nomT);
    }

    /**
     * Obtiene el conjunto de textos
     * @return Conjunto de textos
     */
    public ConjuntoTextos getTextos(){
        return CjtTextos;
    }

    /** Convierte el texto de entarda a frecuencias de letras y agrega un nuevo texto del tipo Palabras
     * @param nomT Nombre del texto a añadir
     * @param texto Contenido del nuevo texto
     * @return True si el texto de tipo Palabras se ha agregado con éxito y false en caso contrario
     */
    public boolean agregarTextoPalabras(String nomT, String texto) {
        if(!CjtTextos.existeTexto(nomT)) {
            HashMap<String,Integer> frecuenciaLetras = convertirTextoAFrecuencias(texto);
            Palabras palabras = new Palabras(nomT, texto,frecuenciaLetras);
            CjtTextos.agregarTexto(nomT, palabras);
            return true;
        }
        return false;
    }

    /**
     * Convierte el texto de entrada en frencuencia de letars (pareja letras con frecuencia respectiva)
     * @param texto Contenido del texto
     * @return HashMap de frecuencia de letras
     */
    public HashMap<String,Integer> convertirTextoAFrecuencias(String texto) {
        HashMap<String,Integer> frecuenciaLetras = new HashMap<String,Integer>();
        char[] textoChars = texto.toCharArray();
        for(int i = 1; i < textoChars.length; ++i){
            String pairLetras = "" + textoChars[i-1] + textoChars[i];
            int frec = 1;
            if (textoChars[i-1] > textoChars[i]) pairLetras = "" + textoChars[i] + textoChars[i-1];
            if(frecuenciaLetras.containsKey(pairLetras)){
                frec = frecuenciaLetras.get(pairLetras)+1;
            }
            frecuenciaLetras.put(pairLetras,frec);
        }
        return frecuenciaLetras;
    }

    /**
     * Convierte las frecuencias de palabars en frecuencias de letras
     * @param frecPalabras Frecuencias de palabras a convertir
     * @return HashMap de frecuencias de letras resultante
     */
    public HashMap<String, Integer> convertirFrecuenciasPalabrasAFrecuenciasLetras(HashMap<String,Integer> frecPalabras) {
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();

        for(HashMap.Entry<String,Integer> e : frecPalabras.entrySet()){
            HashMap<String,Integer> flPal = convertirTextoAFrecuencias(e.getKey());
            for(HashMap.Entry<String,Integer> el : flPal.entrySet()){
                if(frecuenciaLetras.containsKey(el.getKey())){
                    frecuenciaLetras.replace(el.getKey(),frecuenciaLetras.get(el.getKey()) + el.getValue()*e.getValue());
                }
                else frecuenciaLetras.put(el.getKey(),el.getValue()*e.getValue());
            }
        }

        return frecuenciaLetras;
    }

    /**
     * Convierte las frecuencias de palabras a frecuencias de letras y agrega un nuevo texto del tipo Frecuencias
     * @param nomT Nombre del texto a añadir
     * @param frecuenciaPalabras Frecuencias de palabras del texto a añadir
     * @return True si el texto de tipo Frecuencia se ha agregado con éxito y false en caso contrario
     */
    public boolean agregarTextoFrecuencias(String nomT, HashMap<String,Integer> frecuenciaPalabras) {
        if(!CjtTextos.existeTexto(nomT)){
            HashMap<String,Integer> frecuenciasLetras = convertirFrecuenciasPalabrasAFrecuenciasLetras(frecuenciaPalabras);
            Frecuencias frecuencias = new Frecuencias(nomT, frecuenciaPalabras, frecuenciasLetras);
            CjtTextos.agregarTexto(nomT, frecuencias);
            return true;
        }
        return false;
    }

    //Para la segunda entrega
    /*public void borrarTexto(String nomT){
        ArrayList<String> AVinculadas = CjtTextos.getTexto(nomT).getAsociacionesVinculadas();
        if(!AVinculadas.isEmpty()) {
            for (int i = 0; i < AVinculadas.size(); ++i){
                CjtAsociaciones.borrarAsociacionTextos(AVinculadas.get(i));
            }
            CjtTextos.borrarTexto(nomT);
        }
    }*/
}
