package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar de conjunto alfabetos y alfabeto
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class CtrlAlfabeto
{
    // ---------- PARÁMETROS ----------
    /** Crea una instancia del conjunto de alfabetos*/
    private static ConjuntoAlfabetos CjtAlfabetos;


    // ---------- CONSTRUCTORAS ----------
    /** Inicialización de la instancia conjunto de alfabetos.*/
    public CtrlAlfabeto(){
        CjtAlfabetos = new ConjuntoAlfabetos();
    }


    // ---------- FUNCIONES ALFABETO ----------
    /**
     * Devuelve el contenido del alfabeto con nombre nomA
     * @param nomA clave primaria con la que buscar un alfabeto
     * @return ArrayList : Lista de caracteres del contenido del alfabeto nomA
     */
    public ArrayList<Character> getContenido(String nomA){
        return CjtAlfabetos.getAlfabeto(nomA).getLetras();
    }


    public void modificarContenido(String nomA, ArrayList<Character> entradaCaracteres) {
        CjtAlfabetos.getAlfabeto(nomA).modificarContenido(entradaCaracteres);
    }
    /**
     * No devuelve nada.
     * @param nomT clave primaria del teclado
     * @param nomA clave primaria del alfabeto
     * Añade el nombre del teclado nomT a la lista de teclados vinculados del alfabeto nomA
     */
    public void agregarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).agregarTecladoVinculado(nomT);
    }
    /**
     * No devuelve nada.
     * @param nomT clave primaria del teclado
     * @param nomA clave primaria del alfabeto
     * Borra el nombre del teclado nomT de la lista de teclados vinculados del alfabeto nomA
     */
    public void borrarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).borrarTecladoVinculado(nomT);
    }


    // ---------- FUNCIONES CONJUNTOALFABETOS ----------
    /**
     * Devuelve el objecto cjt alfabetos
     * @return ConjuntoAlfabetos : Un objeto cjt alfabetos concreto
     */
    public ConjuntoAlfabetos getCjtAlfabetos(){
        return CjtAlfabetos;
    }

    /**
     * Devuelve si se ha creado bien el alfabeto con el nombre nomA
     * @param entradaCaracteres lista de caracteres del contenido del alfabeto nomA
     * @param nomA nombre (clave única) del alfabeto a agregar
     * @return boolean : True si el alfabeto ha sido creado correctamente, false si no se ha creado bien
     */
    public boolean CrearAlfabeto(String nomA, ArrayList<Character> entradaCaracteres) {
        if (!CjtAlfabetos.existeAlfabeto(nomA)) {
            Alfabeto alfabeto = new Alfabeto(nomA, entradaCaracteres);
            CjtAlfabetos.agregarAlfabeto(nomA, alfabeto);
            return true;
        }
        return false;
    }

    /**
     * Devuelve la lista de nombres de alfabetos existentes
     * @return ArrayList<String> : La lista de los nombres de los alfabetos existentes
     */
    public ArrayList<String> getNombresAlfabetos(){
        return CjtAlfabetos.getNombresAlfabetos();
    }

    /**
     * Devuelve la lista de nombres de teclados vinculados al alfabeto con nombre nomA
     * @return ArrayList<String> : La lista de los nombres de teclados vinculados al alfabeto
     */
    public ArrayList<String> getTecladosVinculadosAlfabeto(String nomA){
        ArrayList<String> tVinculados = CjtAlfabetos.getAlfabeto(nomA).getTecladosVinculados();
        return tVinculados;
    }

    /**
     * No retorna
     * @param nomA el nombre del alfabeto a borrar
     * Borra el alfabeto con nombre nomA
     */
    public void borrarAlfabeto(String nomA){
        CjtAlfabetos.borrarAlfabeto(nomA);
    }

    /**
     * Convierte un conjunto de alfabeto en ByteArray con el fin de almacenarlos.
     * @throws IOException
     */
    public byte[] alfabetosToByteArray() throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(CjtAlfabetos);
        os.close();
        return bs.toByteArray();
    }

    /**
     * Transforma un conjunto de alfabetos para almacenar en un array de bytes al formato original de Alfabeto.
     * @param bytes
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void byteArrayToAlfabetos(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(bs);
        CjtAlfabetos = (ConjuntoAlfabetos) is.readObject();
        is.close();
    }
}