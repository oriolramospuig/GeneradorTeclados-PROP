package main.persistence.controllers;

import drivers.InOut;
import main.persistence.classes.*;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que controla la persistencia de conjuntos de alfabetos, textos, asociaciones de textos y teclados. Se encarga de gestionar el almacenamiento de datos.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class CtrlPersistencia {
    /** Representa el gestor de persistencia de alfabetos. */
    private final GestorAlfabeto gestorAlfabeto;

    /** Representa el gestor de persistencia de textos. */
    private final GestorTexto gestorTexto;

    /** Representa el gestor de persistencia de asociaciones de textos. */
    private final GestorAsociaciones gestorAsociaciones;

    /** Representa el gestor de persistencia de teclados. */
    private final GestorTeclado gestorTeclado;

    private final GestorLectura gestorLectura;

    /**
     * Constructor de la clase CtrlPersistencia.
     * Inicializa los gestores de persistencia para alfabetos, textos, asociaciones de textos y teclados.
     */
    public CtrlPersistencia() {
        gestorAlfabeto = new GestorAlfabeto();
        gestorTexto = new GestorTexto();
        gestorAsociaciones = new GestorAsociaciones();
        gestorTeclado = new GestorTeclado();
        gestorLectura = new GestorLectura();
    }

    // ---------- FUNCIONES ALFABETOS ----------
    /**
     * Guarda un conjunto de alfabetos en un archivo.
     * @param bytes arreglo de bytes que representa el conjunto de alfabetos.
     * @param path ruta del archivo donde se guardará el conjunto de alfabetos.
     */
    public void guardaCnjtAlfabetos(byte[] bytes, String path) {
        GestorAlfabeto.gestorAlfabetos(bytes, path);
    }

    /**
     * Carga un conjunto de alfabetos desde un archivo.
     * @param path ruta del archivo desde donde se cargará el conjunto de alfabetos.
     * @return arreglo de bytes que representa el conjunto de alfabetos cargado.
     */
    public byte[] cargaCnjtAlfabetos(String path) {
        return gestorAlfabeto.cargarAlfabetos(path);
    }


    // ---------- FUNCIONES TEXTOS ----------
    /**
     * Guarda un conjunto de textos en un archivo.
     * @param bytes arreglo de bytes que representa el conjunto de textos.
     * @param path ruta del archivo donde se guardará el conjunto de textos.
     */
    public void guardaCnjtTextos(byte[] bytes, String path) {
        GestorTexto.gestorTextos(bytes, path);
    }

    /**
     * Carga un conjunto de textos desde un archivo.
     * @param path ruta del archivo desde donde se cargará el conjunto de textos.
     * @return arreglo de bytes que representa el conjunto de textos cargado.
     */
    public byte[] cargaCnjtTextos(String path) {
        return gestorTexto.cargarTextos(path);
    }


    // ---------- FUNCIONES ASOCIACIONES TEXTOS ----------
    /**
     * Guarda un conjunto de asociaciones de textos en un archivo.
     * @param bytes arreglo de bytes que representa el conjunto de asociaciones de textos.
     * @param path ruta del archivo donde se guardará el conjunto de asociaciones de textos.
     */
    public void guardaCnjtAsociaciones(byte[] bytes, String path) {
        GestorAsociaciones.gestorAsociaciones(bytes, path);
    }

    /**
     * Carga un conjunto de asociaciones de textos desde un archivo.
     * @param path ruta del archivo desde donde se cargará el conjunto de asociaciones de textos.
     * @return arreglo de bytes que representa el conjunto de asociaciones de textos cargado.
     */
    public byte[] cargaCnjtAsociaciones(String path) {
        return gestorAsociaciones.cargarAsociaciones(path);
    }


    // ---------- FUNCIONES TECLADOS ----------
    /**
     * Guarda un conjunto de teclados en un archivo.
     * @param bytes arreglo de bytes que representa el conjunto de teclados.
     * @param path ruta del archivo donde se guardará el conjunto de teclados.
     */
    public void guardaCnjtTeclados(byte[] bytes, String path) {
        GestorTeclado.gestorTeclados(bytes, path);
    }

    /**
     * Carga un conjunto de teclados desde un archivo.
     * @param path ruta del archivo desde donde se cargará el conjunto de teclados.
     * @return arreglo de bytes que representa el conjunto de teclados cargado.
     */
    public byte[] cargaCnjtTeclados(String path) {
        return gestorTeclado.cargarTeclados(path);
    }


    public ArrayList<Character> leerArchivoPath(String pathArchivo) throws IOException {
        return gestorLectura.leerPath(pathArchivo);
    }

    public String leerTextoPalabrasPath(String pathTexto) throws IOException {
        return gestorLectura.leerTextoPalabrasPath(pathTexto);
    }
}