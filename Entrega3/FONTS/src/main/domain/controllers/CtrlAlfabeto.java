package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, consultar, modificar y borrar de conjunto alfabetos y alfabeto.
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class CtrlAlfabeto
{
    // ---------- PARÁMETROS ----------
    /** Crea una instancia del conjunto de alfabetos. */
    private static ConjuntoAlfabetos CjtAlfabetos;


    // ---------- CONSTRUCTORAS ----------
    /** Inicialización de la instancia conjunto de alfabetos. */
    public CtrlAlfabeto(){
        CjtAlfabetos = new ConjuntoAlfabetos();
    }


    // ---------- FUNCIONES ALFABETO ----------
    /**
     * Devuelve el contenido del alfabeto con nombre nomA.
     * @param nomA clave primaria con la que buscar un alfabeto.
     * @return ArrayList : Lista de caracteres del contenido del alfabeto con nombre nomA.
     */
    public ArrayList<Character> getContenido(String nomA){
        return CjtAlfabetos.getAlfabeto(nomA).getLetras();
    }

    /**
     * No devuelve nada.
     * @param nomA clave primaria (identificador) del alfabeto.
     * @param entradaCaracteres lista de carácteres que forman el nuevo contenido del alfabeto.
     * Llama a la función de modificar alfabeto de Alfabeto, donde se actualiza el contenido de este con el nuevo contenido.
     */
    public void modificarContenido(String nomA, ArrayList<Character> entradaCaracteres) {
        CjtAlfabetos.getAlfabeto(nomA).modificarContenido(entradaCaracteres);
    }

    /**
     * No devuelve nada.
     * @param nomA clave primaria del alfabeto.
     * @param nomT clave primaria del teclado.
     * Añade el nombre del teclado nomT a la lista de teclados vinculados del alfabeto nomA.
     */
    public void agregarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).agregarTecladoVinculado(nomT);
    }

    /**
     * Devuelve la lista de nombres de los teclados vinculados al alfabeto con nombre nomA.
     * @param nomA clave primaria del alfabeto.
     * @return ArrayList<String> : La lista de los nombres de teclados vinculados al alfabeto con nombre nomA.
     */
    public ArrayList<String> getTecladosVinculadosAlfabeto(String nomA){
        ArrayList<String> tVinculados = CjtAlfabetos.getAlfabeto(nomA).getTecladosVinculados();
        return tVinculados;
    }

    /**
     * No devuelve nada.
     * @param nomA clave primaria del alfabeto.
     * @param nomT clave primaria del teclado.
     * Borra el nombre del teclado nomT de la lista de teclados vinculados del alfabeto nomA.
     */
    public void borrarTecladoVinculado (String nomA, String nomT){
        CjtAlfabetos.getAlfabeto(nomA).borrarTecladoVinculado(nomT);
    }


    // ---------- FUNCIONES CONJUNTOALFABETOS ----------
    /**
     * Devuelve el objecto cjt alfabetos.
     * @return ConjuntoAlfabetos : Un objeto cjt alfabetos concreto.
     */
    public ConjuntoAlfabetos getCjtAlfabetos(){
        return CjtAlfabetos;
    }

    /**
     * Devuelve si se ha creado bien el alfabeto con el nombre nomA.
     * @param nomA nombre (clave única) del alfabeto a agregar.
     * @param entradaCaracteres lista de carácteres que forman el contenido del alfabeto con nombre nomA.
     * @return boolean : True si el alfabeto ha sido agregado correctamente al conjunto de alfabetos, false si no se ha creado bien.
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
     * Devuelve la lista de nombres de alfabetos existentes.
     * @return ArrayList<String> : La lista de los nombres de los alfabetos existentes.
     */
    public ArrayList<String> getNombresAlfabetos(){
        return CjtAlfabetos.getNombresAlfabetos();
    }

    /**
     * No devuelve nada.
     * @param nomA el nombre del alfabeto a borrar.
     * Borra el alfabeto con nombre nomA del conjunto de alfabetos.
     */
    public void borrarAlfabeto(String nomA){
        CjtAlfabetos.borrarAlfabeto(nomA);
    }

    /**
     * Convierte un conjunto de alfabeto en ByteArray con el fin de almacenarlos.
     * Esta función utiliza serialización de objetos.
     * @return ByteArray que representa el conjunto de alfabetos.
     * @throws IOException Si ocurre un error durante la serialización.
     */
    public byte[] alfabetosToByteArray() throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(CjtAlfabetos);
        os.close();
        return bs.toByteArray();
    }

    /**
     * Transforma un array de bytes en un conjunto de alfabetos, restaurando su formato original.
     * @param bytes El array de bytes que representa el conjunto de alfabetos.
     * @throws IOException Si ocurre un error durante la deserialización.
     * @throws ClassNotFoundException Si no se encuentra la clase al deserializar.
     */
    public static void byteArrayToAlfabetos(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(bs);
        CjtAlfabetos = (ConjuntoAlfabetos) is.readObject();
        is.close();
    }
}