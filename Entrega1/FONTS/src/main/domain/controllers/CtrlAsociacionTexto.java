package main.domain.controllers;

import main.domain.classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar de asociaciones de textos
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class CtrlAsociacionTexto
{
    // ---------- PARÁMETROS ----------
    /** Representa conjunto de asociaciones de textos dentro del controlador para gestioanr y manipular los textos */
    private static ConjuntoAsociaciones AsociacionesTextos;


    // ---------- CONSTRUCTORA ----------
    /** Inicializa el conjunto de asociaciones de textos */
    public CtrlAsociacionTexto(){
        AsociacionesTextos = new ConjuntoAsociaciones();
    }


    // ---------- FUNCIONES ASOCIACION ----------
    /**
     * No devuelve nada. Manda añadir el nuevo teclado al conjunto de teclados vinculados
     * @param nomA nombre de la asociación de textos
     * @param nomT nombre del teclado a agregar
     */
    public void agregarTecladoVinculado (String nomA, String nomT) {
        AsociacionesTextos.getAsociacionTextos(nomA).agregarTecladoVinculado(nomT);
    }
    /**
     * No devuelve nada. Manda añadir un texto a la asociacion de textos pasada como parámetro
     * @param nomA nombre de la asociación de textos
     * @param texto objeto Texto a agregar
     */
    public void agregarTextoAsociacion (String nomA, Texto texto){
        AsociacionesTextos.getAsociacionTextos(nomA).agregarTexto(texto);
    }
    public ArrayList<String> getCjtTextos(String nomAT){
        return AsociacionesTextos.getAsociacionTextos(nomAT).getTextosAsociaciados();
    }
    public void borrarTecladoVinculado(String atvinculada,String tvinculado){
        AsociacionesTextos.getAsociacionTextos(atvinculada).borrarTecladoVinculado(tvinculado);
    }
    public void borrarTextoAsociacion(String nomA, String nomT){
        AsociacionesTextos.getAsociacionTextos(nomA).borrarTexto(nomT);
    }


    // ---------- FUNCIONES CONJUNTOASOCIACIONES ----------
    /**
     * Devuelve el conjunto de asociaciones de textos
     * @return Conjunto de asociaciones de textos
     */
    public ConjuntoAsociaciones getCjtAsociaciones() {
        return AsociacionesTextos;
    }

    /**
     * Agrega una nueva asociación de textos al conjunto
     * @param nomAT nombre de la nueva asociación de textos a agregar
     * @return true si la asociación se ha agregado correctamente y false en caso contrario
     */
    public void agregarAsociacion(String nomAT, Texto texto){
        AsociacionTextos asociacionTextos = new AsociacionTextos(nomAT);
        AsociacionesTextos.agregarAsociacionTexto(nomAT, asociacionTextos);
        agregarTextoAsociacion(nomAT, texto);
    }
    /**
     * Devuelve la lista de nombres de asociaciones existentes
     * @return ArrayList<String> : La lista de los nombres de las asociaciones existentes
     */
    public ArrayList<String> getNombresAsociaciones(){
        return AsociacionesTextos.getNombresAsociacionesTextos();
    }

    /**
     * Devuelve la lista de nombres de teclados vinculados a la asociación con nombre nomA.
     * @param nomAT
     */
    public ArrayList<String> getTecladosVinculadosAsociacion(String nomAT){
        ArrayList<String> tVinculados = AsociacionesTextos.getAsociacionTextos(nomAT).getTecladosVinculados();
        return tVinculados;
    }

    /**
     * No retorna
     * @param nomAT el nombre de la asociación a borrar
     * Borra la asociaión con nombre nomAT
     */
    public void borrarAsociacionTextos(String nomAT){
        AsociacionesTextos.borrarAsociacionTextos(nomAT);
    }

    /**
     * Convierte un conjunto de asociación de textos en ByteArray con el fin de almacenarlos.
     * @throws IOException
     */
    public byte[] asociacionesToByteArray() throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(AsociacionesTextos);
        os.close();
        return bs.toByteArray();
    }

    /**
     * Transforma un conjunto de asociación de textos para almacenar en un array de bytes al formato original de AsaociacionTextos.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void byteArrayToAsociaciones(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(bs);
        AsociacionesTextos = (ConjuntoAsociaciones) is.readObject();
        is.close();
    }
}