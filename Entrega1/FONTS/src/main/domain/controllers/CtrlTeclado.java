package main.domain.controllers;


import main.domain.classes.*;
import main.domain.classes.types.PairInt;

import java.io.*;
import java.util.ArrayList;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar de conjunto teclados, teclado y el controlador del algoritmo
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class CtrlTeclado
{
    // ---------- PARÁMETROS ----------
    /** Crea una instancia del conjunto de teclados*/
    private static ConjuntoTeclados teclados;

    /** Crea una instancia del controlador del algoritmo*/
    private CtrlTecladoQAP ctrlAlgoritmo;


    // ---------- CONSTRUCTURAS ----------
    /** Inicialización de la instancia conjunto de teclados vacío.*/
    public CtrlTeclado(){
        teclados = new ConjuntoTeclados();
        ctrlAlgoritmo = new CtrlTecladoQAP();
    }


    // ---------- FUNCIONES TECLADO ----------
    public char[][] getContenido(String nomT){
        return teclados.getTeclado(nomT).getContenido();
    }

    public String getAlfabeto(String nomT){
        return teclados.getTeclado(nomT).getAlfabetoVinculado();
    }

    public String getAsociacion(String nomT){
        return teclados.getTeclado(nomT).getAsociacionTextosVinculado();
    }

    /**
     * No devuelve nada, manda a introducir las dimensiones escritas en un Teclado (también pedido)
     */
    public void setDimensiones(String nomT, PairInt dimensiones) {
        teclados.getTeclado(nomT).setDimensiones(dimensiones);
    }

    /**
     * No devuelve nada, manda a vincular un Alfabeto a un Teclado
     */
    public void agregarAlfabetoVinculado(String nomT, String nomA) {
        teclados.getTeclado(nomT).agregarAlfabetoVinculado(nomA);
    }

    /**
     * No devuelve nada, manda a vincular una Asociacion de Textos a un Teclado
     */
    public void agregarAsociacionTextosVinculado(String nomT, String nomAT) {
        teclados.getTeclado(nomT).agregarAsociacionTextosVinculado(nomAT);
    }

    //Para la segunda entrega
    /*public void borrarAlfabetoVinculado(String nomT, String nomA) {
        teclados.getTeclado(nomT).borrarAlfabetoVinculado(nomA);
    }
    public void borrarAsociacionTextosVinculados(String nomT, String nomAT) {
        teclados.getTeclado(nomT).borrarAsociacionTextosVinculados(nomAT);
    }*/


    // ---------- FUNCIONES CONJUNTOTECLADOS ----------
    /**
     * Devuelve el objecto cjt de Teclados pedido
     * @return ConjuntoTeclados : Un objeto cjt de Teclados concreto
     */
    public ConjuntoTeclados getCjtTeclados() {
        return teclados;
    }

    /**
     * Devuelve booleano de si que existe el teclado pedido en el cjt de teclados
     * @return ConjuntoTeclados : Un objeto cjt de Teclados concreto
     */
    public boolean existeTeclado(String nomT){
        return teclados.existeTeclado(nomT);
    }

    /**
     * No devuelve nada.
     * Crea el nuevo objecto Teclado y añade este objeto a ConjuntoTeclados
     */
    public void CrearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, PairInt dim) {
        Teclado teclado = ctrlAlgoritmo.crearTeclado(nomT, asociacionTextos, alfabeto, dim);
        teclados.agregarTeclado(nomT, teclado);
    }

    /**
     * Obtiene el nombre del alfabeto vinculado a un teclado específico.
     * @param nomT
     * @return Nombre del alfabeto vinculado a un teclado específico
     */
    public String TecladoTieneAlfabetoVinculado(String nomT){
        return teclados.getTeclado(nomT).getAlfabetoVinculado();
    }

    /**
     * Obtiene el nombre de la asociación de textos vinculada a un teclado específico.
     * @param nomA
     * @return Nombre de la asociación de textos vinculada a un teclado específico
     */
    public String TecladoTieneAsociacionVinculada(String nomA){
        return teclados.getTeclado(nomA).getAsociacionTextosVinculado();
    }

    /**
     * Borra Teclado con nombre nomT.
     * @param nomT
     */
    public void borrarTeclado(String nomT) {
        //String alfabetoVinculado = teclados.getTeclado(nomT).getAlfabetoVinculado();
        //if (!alfabetoVinculado.isEmpty()) alfabetos.borrarAlfabeto(alfabetoVinculado);
        teclados.borrarTeclado(nomT);

        //String asociacionTextosVinculado = teclados.getTeclado(nomT).getAsociacionTextosVinculado();
        //if (!asociacionTextosVinculado.isEmpty()) asociacionesTextos.borrarAsociacionTextos(asociacionTextosVinculado);
    }

    /**
     * Convierte un conjunto de teclados en ByteArray con el fin de almacenarlos.
     * @return Conjunto de teclados convertidos
     * @throws IOException
     */
    public byte[] tecladosToByteArray() throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(teclados);
        os.close();
        return bs.toByteArray();
    }

    /**
     * Transforma un conjunto de teclados almacenar en un array de bytes al formato original de Teclado.
     * @param bytes
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void byteArrayToTeclados(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(bs);
        teclados = (ConjuntoTeclados) is.readObject();
        is.close();
    }
}
