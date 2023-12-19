package main.persistence.classes;

import main.domain.classes.Texto;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que gestiona la carga y guardado de Conjuntos de Asociaciones de textos en formato de bytes.
 * @author
 */
public class GestorAsociaciones {
    /**
     * Guarda un conjunto de asociaciones de textos representado como un arreglo de bytes en un archivo.
     * @param bytes arreglo de bytes que representa el conjunto de asociaciones de textos.
     * @param path ruta del archivo donde se guardará el conjunto de asociaciones de textos.
     */
    public static void gestorAsociaciones(byte[] bytes, String path) {
        try {
            FileOutputStream outFile = new FileOutputStream(path);
            outFile.write(bytes);
            outFile.flush();
            outFile.close();
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de asociaciones de textos: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Carga un conjunto de asociaciones de textos desde un archivo y lo devuelve como un arreglo de bytes.
     * @param path ruta del archivo desde donde se cargará el conjunto de asociaciones de textos.
     * @return arreglo de bytes que representa el conjunto de asociaciones de textos cargado.
     */
    public byte[] cargarAsociaciones(String path) {
        byte[] bytes = null;
        try {
            FileInputStream inFile = new FileInputStream(path);
            bytes = inFile.readAllBytes();
            inFile.close();
        } catch (IOException e) {
            System.err.println("[#CARGAR] Error al cargar el conjunto de asociaciones de textos: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
        return bytes;
    }
}