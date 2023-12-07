package main.persistence.classes;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la clase gestionadora de datos para la clase "Alfabeto", carga/vuelca los alfabetos modificados en cada caso.
 */
public class GestorAlfabeto {
    public static void gestorAlfabetos(byte[] bytes, String path) {
        Path p = Paths.get(path);
        try {
            FileOutputStream outFile = new FileOutputStream(path);
            outFile.write(bytes);
            outFile.flush();
            outFile.close();
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de alfabetos: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    public byte[] cargarAlfabetos(String path) {
        byte[] bytes = null;
        try {
            FileInputStream inFile = new FileInputStream(path);
            bytes = inFile.readAllBytes();
            inFile.close();
        } catch (IOException e) {
            System.err.println("[#CARGAR] Error al cargar el conjunto de alfabetos: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
        return  bytes;
    }
}