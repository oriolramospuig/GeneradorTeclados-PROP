package main.domain.controllers;

import main.domain.classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/** Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar de textos
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class CtrlTexto
{
    // ---------- PARAMETROS ----------
    /** Representa conjunto de textos dentro del controlador para gestionar y manipular los textos. */
    private static ConjuntoTextos CjtTextos;


    // ---------- CONSTRUCTORA ----------
    /** Inicializa el conjunto de textos. */
    public CtrlTexto(){
        CjtTextos = new ConjuntoTextos();
    }


    // ---------- FUNCIONES TEXTO ----------
    /**
     * Obtiene el contenido de un texto dado su nombre.
     * @param nomT nombre del texto.
     * @return contenido del texto, ya sea del tipo Palabras o Frecuencias.
     */
    public String getContenido(String nomT){
        return CjtTextos.getTexto(nomT).getTexto();
    }

    /**
     * Modifica el contenido de un Texto identificado por su nombre, utilizando la frecuencia de caracteres proporcionada.
     * @param nomT nombre del Texto a modificar.
     * @param entradaCaracteres string de caracteres que conformaran el nuevo contenido del texto nomT.
     * @return True si se ha modificado el contenido correctamente y False en caso contrario.
     */
    public boolean modificarContenido(String nomT, String entradaCaracteres) {
        Texto t = CjtTextos.getTexto(nomT);
        HashMap<String, Integer> frecLet = convertirTextoAFrecuencias(entradaCaracteres);
        if (t instanceof Palabras) {
            Palabras palabras = (Palabras) t;
            palabras.modificarPalabras(entradaCaracteres, frecLet);
            return true;
        }
        return false;
    }

    /**
     * Modifica el contenido de un Texto identificado por su nombre, utilizando un mapa de frecuencias proporcionado.
     * @param nomT nombre del Texto a modificar.
     * @param frec HashMap de frecuencias que se usará para la modificación.
     * @return True si se ha modificado el contenido correctamente y False en caso contrario.
     */
    public boolean modificarContenidoFrec(String nomT, HashMap<String, Integer> frec) {
        Texto t = CjtTextos.getTexto(nomT);
        HashMap<String, Integer> frecLet = convertirFrecuenciasPalabrasAFrecuenciasLetras(frec);
        if (t instanceof Frecuencias) {
            Frecuencias frecuencias = (Frecuencias) t;
            frecuencias.modificarFrecuencias(frec, frecLet);
            return true;
        }
        return false;
    }

    /**
     * No devuelve nada. Agrega una asociación vinculada a un texto dado su nombre.
     * @param nomT nombre del texto.
     * @param nomAT nombre de la asociación de textos.
     */
    public void agregarAsociacionVinculada(String nomT, String nomAT){
        CjtTextos.getTexto(nomT).agregarAsociacionesVinculadas(nomAT);
    }

    /**
     * Elimina las asociaciones vinculadas a un Texto específico.
     * @param nomT nombre del Texto del cual se eliminarán las asociaciones vinculadas.
     * @param nomAT nombre de la asociación que se utilizará para identificar y eliminar las asociaciones vinculadas.
     */
    public void borrarAsociacionVinculada(String nomT, String nomAT){
        CjtTextos.getTexto(nomT).borrarAsociacionesVinculadas(nomAT);
    }


    // ---------- FUNCIONES CONJUNTOTEXTOS ----------
    /**
     * Obtiene un objeto Texto dado su nombre.
     * @param nomT nombre del texto.
     * @return objeto Texto.
     */
    public Texto getTexto(String nomT){
        return CjtTextos.getTexto(nomT);
    }

    /**
     * Obtiene el conjunto de textos.
     * @return Conjunto de textos.
     */
    public ConjuntoTextos getTextos(){
        return CjtTextos;
    }

    /**
     * Convierte el texto de entrada a frecuencias de letras y agrega un nuevo texto del tipo Palabras.
     * @param nomT nombre del texto a añadir.
     * @param texto contenido del nuevo texto.
     * @return True si el texto de tipo Palabras se ha agregado con éxito y False en caso contrario.
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
     * Convierte comprueba si el texto es de palabras o frecuencias.
     * @param nomT nombre del texto a añadir.
     * @return True si el texto es de palabras y False en caso contrario.
     */
    public boolean esTextoPalabras(String nomT) {
        Texto texto = getTexto(nomT);
        return texto instanceof Palabras;
    }

    /**
     * Convierte el texto de entrada en frecuencia de letras (pareja letras con frecuencia respectiva).
     * @param texto contenido del texto.
     * @return HashMap de frecuencia de letras.
     */
    public HashMap<String,Integer> convertirTextoAFrecuencias(String texto) {
        HashMap<String,Integer> frecuenciaLetras = new HashMap<>();
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
     * Convierte las frecuencias de palabras en frecuencias de letras.
     * @param frecPalabras frecuencias de palabras a convertir.
     * @return HashMap de frecuencias de letras resultantes.
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
     * Convierte las frecuencias de palabras a frecuencias de letras y agrega un nuevo texto del tipo Frecuencias.
     * @param nomT nombre del texto a añadir.
     * @param frecuenciaPalabras frecuencias de palabras del texto a añadir.
     * @return True si el texto de tipo Frecuencia se ha agregado con éxito y False en caso contrario.
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

    /**
     * Devuelve la lista de nombres de textos existentes.
     * @return ArrayList String: lista de los nombres de los textos existentes.
     */
    public ArrayList<String> getNombresTextos(){
        return CjtTextos.getNombresTextos();
    }

    /**
     * Devuelve la lista de nombres de teclados vinculados al alfabeto con nombre nomA.
     * @return ArrayList String: lista de los nombres de teclados vinculados al alfabeto.
     */
    public static ArrayList<String> getAsociacionesVinculadasTexto(String nomT){
        return CjtTextos.getTexto(nomT).getAsociacionesVinculadas();
    }

    /**
     * No devuelve nada. Borra el Texto con nombre nomT y desvincula las asociaciones de textos vinculadas a este texto borrado.
     * @param nomT el nombre del Texto a borrar.
     */
    public static void borrarTexto(String nomT){
        CjtTextos.borrarTexto(nomT);
    }


    // ---------- FUNCIONES PERSISTENCIA ----------
    /**
     * Convierte el conjunto de textos en ByteArray con el fin de almacenarlos.
     * @return Arreglo de bytes que representa el conjunto de textos.
     * @throws IOException en el caso de que se produzca un error durante la serialización.
     */
    public byte[] textosToByteArray() throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(CjtTextos);
        os.close();
        return bs.toByteArray();
    }

    /**
     * Convierte un conjunto de bytes a un conjunto de textos.
     * @param bytes conjunto de bytes que representa el conjunto de textos.
     * @throws IOException en el caso de que se produzca un error durante la deserialización.
     * @throws ClassNotFoundException en el caso de que la clase ConjuntoTextos no es encontrada durante la deserialización.
     */
    public static void byteArrayToTextos(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(bs);
        CjtTextos = (ConjuntoTextos) is.readObject();
        is.close();
    }
}