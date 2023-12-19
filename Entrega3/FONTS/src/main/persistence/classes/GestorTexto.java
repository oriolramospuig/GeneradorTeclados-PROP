package main.persistence.classes;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.domain.classes.Texto;

/**
 * Clase que gestiona la carga y guardado de conjuntos de textos en formato de bytes.
 * @author
 */
public class GestorTexto {
    /**
     * Guarda un conjunto de textos representado como un arreglo de bytes en un archivo.
     * @param bytes arreglo de bytes que representa el conjunto de textos.
     * @param path ruta del archivo donde se guardará el conjunto de textos.
     */
    public static void gestorTextos(byte[] bytes, String path) {
        try {
            FileOutputStream outFile = new FileOutputStream(path);
            outFile.write(bytes);
            outFile.flush();
            outFile.close();
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de textos: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Carga un conjunto de textos desde un archivo y lo devuelve como un arreglo de bytes.
     * @param path ruta del archivo desde donde se cargará el conjunto de textos.
     * @return arreglo de bytes que representa el conjunto de textos cargado.
     */
    public byte[] cargarTextos(String path) {
        byte[] bytes = null;
        try {
            FileInputStream inFile = new FileInputStream(path);
            bytes = inFile.readAllBytes();
            inFile.close();
        } catch (IOException e) {
            System.err.println("[#CARGAR] Error al cargar el conjunto de textos: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
        return bytes;
    }
}