package main.persistence.classes;

import main.domain.classes.Teclado;

import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorTeclado {
    private static final Logger logger = Logger.getLogger(GestorAlfabeto.class.getName());

    public static void guardarTeclado (Teclado teclado, String path) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(path))) {
            o.writeObject(teclado);
            System.out.println("Teclado guardado con éxito en" + path);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error al guardar teclado en" + path, e);
        }
    }

    public static Teclado cargarTeclado(String path) {
        Teclado teclado = null;
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path))) {
            teclado = (Teclado) oi.readObject();
            System.out.println("Teclado cargado con éxito en" + path);
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Error al cargar teclado desde " + path, e);
        }
        return teclado;
    }
}
