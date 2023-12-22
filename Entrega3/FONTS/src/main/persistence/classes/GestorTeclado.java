package main.persistence.classes;

import main.domain.classes.Teclado;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que gestiona la carga y guardado de conjuntos de teclados en formato de bytes.
 * @author Víctor Moreno
 */
public class GestorTeclado {
    /**
     * Guarda un conjunto de teclados representado como un arreglo de bytes en un archivo.
     * @param bytes arreglo de bytes que representa el conjunto de teclados.
     * @param path ruta del archivo donde se guardará el conjunto de teclados.
     */
    public static void gestorTeclados(byte[] bytes, String path) {
        try {
            FileOutputStream outFile = new FileOutputStream(path);
            outFile.write(bytes);
            outFile.flush();
            outFile.close();
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de teclados: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Carga un conjunto de teclados desde un archivo y lo devuelve como un arreglo de bytes.
     * @param path ruta del archivo desde donde se cargará el conjunto de teclados.
     * @return arreglo de bytes que representa el conjunto de teclados cargado.
     */
    public byte[] cargarTeclados(String path) {
        byte[] bytes = null;
        try {
            FileInputStream inFile = new FileInputStream(path);
            bytes = inFile.readAllBytes();
            inFile.close();
        } catch (IOException e) {
            System.err.println("[#CARGAR] Error al cargar el conjunto de teclados: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
        return bytes;
    }
}