package main.persistence.classes;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.domain.classes.Texto;

/**
 * Implementación de la clase gestionadora de datos para la clase "Texto", carga/vuelca los textos modificados en cada caso.
 */
public class GestorTexto {
    private static final Logger logger = Logger.getLogger(GestorAlfabeto.class.getName());
    public static void guardarTexto(HashMap<String, Texto> texto, String path) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(path))) {
            o.writeObject(texto);
            System.out.println("Texto guardado con éxito en " + path);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error al guardar texto en " + path, e);
        }
    }
    public static HashMap<String, Texto> cargarTexto(String path) {
        HashMap<String, Texto> texto = new HashMap<>();
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path))) {
            texto = (HashMap<String, Texto>) oi.readObject();
            System.out.println("Texto cargado con éxito desde " + path);
        } catch (IOException | ClassNotFoundException e){
            logger.log(Level.SEVERE, "Error al cargar texto desde " + path, e);
        }
        return texto;
    }
}