package main.domain.controllers;

import main.domain.classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, consultar modificar y borrar de asociaciones de textos.
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class CtrlAsociacionTexto
{
    // ---------- PARÁMETROS ----------
    /** Crea una instancia de conjunto de asociaciones de textos. */
    private static ConjuntoAsociaciones AsociacionesTextos;


    // ---------- CONSTRUCTORA ----------
    /** IInicialización de la instancia conjunto de asociaciones de textos. */
    public CtrlAsociacionTexto(){
        AsociacionesTextos = new ConjuntoAsociaciones();
    }


    // ---------- FUNCIONES ASOCIACION ----------
    /**
     * No devuelve nada.
     * @param nomA clave única y nombre de la asociación de textos.
     * @param nomT clave única y nombre del teclado a vincular.
     * Manda añadir el nuevo teclado con nombre nomT al conjunto de teclados vinculados de la asociación con nombre nomA.
     */
    public void agregarTecladoVinculado (String nomA, String nomT) {
        AsociacionesTextos.getAsociacionTextos(nomA).agregarTecladoVinculado(nomT);
    }
    /**
     * No devuelve nada.
     * @param nomA clave única y nombre de la asociación de textos.
     * @param nomTxt clave única y nombre del texto a agregar.
     * @param freqTexto map de las frecuencias de palabras del texto a agregar.
     * Manda a añadir el texto con nombre nomTxt a la asociacion de textos con nombre nomA.
     */
    public void agregarTextoAsociacion (String nomA, String nomTxt, HashMap<String,Integer> freqTexto){
        AsociacionesTextos.getAsociacionTextos(nomA).agregarTexto(nomTxt,freqTexto);
    }

    /**
     * Devuelve la lista de nombres de los textos que están asociados a la asociación con nombre nomAT.
     * @param nomAT clave única y nombre de la asociación de textos.
     * @return ArrayList<String>: lista de los nombres de los textos de la asociación
     */
    public ArrayList<String> getCjtTextos(String nomAT){
        return AsociacionesTextos.getAsociacionTextos(nomAT).getTextosAsociaciados();
    }

    /**
     * No devuelve nada.
     * @param atvinculada clave única y nombre de la asociación de textos.
     * @param tvinculado clave única y nombre del teclado.
     * Manda borrar el teclado tvinculado de la lista de teclados vinculados de la asociación con nombre atvinculada.
     */
    public void borrarTecladoVinculado(String atvinculada,String tvinculado){
        AsociacionesTextos.getAsociacionTextos(atvinculada).borrarTecladoVinculado(tvinculado);
    }

    /**
     * No devuelve nada.
     * @param nomA clave única y nombre de la asociación.
     * @param nomT clave única y nombre del texto.
     * @param frecuenciaLetras Map de los pares de letras y sus frecuencias.
     * Manda borrar el texto con nombre nomT de la lista de textos asociados a la asociación con nombre nomA.
     */
    public void borrarTextoAsociacion(String nomA, String nomT, HashMap<String, Integer> frecuenciaLetras){
        AsociacionesTextos.getAsociacionTextos(nomA).borrarTexto(nomT, frecuenciaLetras);
    }


    // ---------- FUNCIONES CONJUNTOASOCIACIONES ----------
    /**
     * Devuelve el conjunto de asociaciones de textos.
     * @return Conjunto de asociaciones de textos.
     */
    public ConjuntoAsociaciones getCjtAsociaciones() {
        return AsociacionesTextos;
    }

    /**
     * No devuelve nada.
     * @param nomAT clave única y nombre de la nueva asociación de textos a agregar.
     * Agrega una nueva asociación de textos al conjunto de asociaciones.
     */
    public void agregarAsociacion(String nomAT){
        AsociacionTextos asociacionTextos = new AsociacionTextos(nomAT);
        AsociacionesTextos.agregarAsociacionTexto(nomAT, asociacionTextos);
    }

    /**
     * Devuelve la lista de nombres de las asociaciones del conjunto de asociaciones.
     * @return ArrayList<String> : La lista de los nombres de las asociaciones existentes.
     */
    public ArrayList<String> getNombresAsociaciones(){
        return AsociacionesTextos.getNombresAsociacionesTextos();
    }

    /**
     * Devuelve la lista de nombres de teclados vinculados a la asociación con nombre nomA.
     * @param nomAT clave única y nombre de la asociación.
     * @return ArrayList<String>: lista de los nombres de los teclados vinculados a la asociación con nombre nomA.
     */
    public ArrayList<String> getTecladosVinculadosAsociacion(String nomAT){
        ArrayList<String> tVinculados = AsociacionesTextos.getAsociacionTextos(nomAT).getTecladosVinculados();
        return tVinculados;
    }

    /**
     * No devuelve nada.
     * @param nomAT clave única y nombre de la asociación a borrar.
     * Borra la asociaión con nombre nomAT del conjunto de asociaciones.
     */
    public void borrarAsociacionTextos(String nomAT){
        AsociacionesTextos.borrarAsociacionTextos(nomAT);
    }


    /**
     * Convierte un conjunto de asociaciones de textos en ByteArray con el fin de almacenarlos.
     * Utiliza la serialización de objetos para convertir el conjunto en un formato que puede ser guardado.
     * @return Un ByteArray que representa el conjunto de asociaciones de textos.
     * @throws IOException Si ocurre un error durante el proceso de serialización.
     */
    public byte[] asociacionesToByteArray() throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(AsociacionesTextos);
        os.close();
        //Devolver el ByteArray resultante
        return bs.toByteArray();
    }

    /**
     * Transforma un array de bytes en un conjunto de asociación de textos, restaurando su formato original.
     * @param bytes El array de bytes que representa el conjunto de asociaciones de textos.
     * @throws IOException Si ocurre un error durante la deserialización.
     * @throws ClassNotFoundException Si no se encuentra la clase al deserializar.
     */
    public static void byteArrayToAsociaciones(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(bs);
        AsociacionesTextos = (ConjuntoAsociaciones) is.readObject();
        is.close();
    }
}