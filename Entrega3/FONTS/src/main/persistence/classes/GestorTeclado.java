package main.persistence.classes;

import main.domain.classes.Teclado;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorTeclado {
    public static void gestorTeclados(byte[] bytes, String path) {
        Path p = Paths.get(path);
        try {
            FileOutputStream outFile = new FileOutputStream(path);
            outFile.write(bytes);
            outFile.flush();
            outFile.close();
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de teclados: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    public byte[] cargarTeclados(String path) {
        byte[] bytes = null;
        try {
            FileInputStream inFile = new FileInputStream(path);
            bytes = inFile.readAllBytes();
            inFile.close();
        } catch (IOException e) {
            System.err.println("[#CARGAR] Error al cargar el conjunto de teclados: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
        return  bytes;
    }
}
