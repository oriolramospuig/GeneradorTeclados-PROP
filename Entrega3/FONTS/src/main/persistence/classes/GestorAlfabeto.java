package main.persistence.classes;

import java.io.*;
import java.util.*;


/**
 * Clase que gestiona la carga y guardado de Conjuntos de Alfabetos en formato de csv.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class GestorAlfabeto {
    /**
     * Guarda un conjunto de alfabetos representado como un arreglo de bytes en un archivo.
     * @param bytes arreglo de bytes que representa el conjunto de alfabetos.
     * @param path ruta del archivo donde se guardará el conjunto de alfabetos.
     */
    public static void gestorAlfabetos(byte[] bytes, String path) {
        try {
            FileOutputStream outFile = new FileOutputStream(path);
            outFile.write(bytes);
            outFile.flush();
            outFile.close();
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de alfabetos: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Carga un conjunto de alfabetos desde un archivo y lo devuelve como un arreglo de bytes.
     * @param path ruta del archivo desde donde se cargará el conjunto de alfabetos.
     * @return arreglo de bytes que representa el conjunto de alfabetos cargado.
     */
    public byte[] cargarAlfabetos(String path) {
        byte[] bytes = null;
        try {
            FileInputStream inFile = new FileInputStream(path);
            bytes = inFile.readAllBytes();
            inFile.close();
        } catch (IOException e) {
            System.err.println("[#CARGAR] Error al cargar el conjunto de alfabetos: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
        return bytes;
    }
}