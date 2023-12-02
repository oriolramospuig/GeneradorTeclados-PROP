package main.persistence.classes;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la clase gestionadora de datos para la clase "Alfabeto", carga/vuelca los alfabetos modificados en cada caso.
 */
public class GestorAlfabeto {
    private static final Logger logger = Logger.getLogger(GestorAlfabeto.class.getName());
    public static void guardarAlfabeto(Map<String, ArrayList<Character>> alfabetos, String path) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(path))) {
            o.writeObject(alfabetos);
            System.out.println("Alfabeto guardado con éxito en " + path);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error al guardar alfabeto en" + path, e);
        }
    }

    public static Map<String, ArrayList<Character>> cargarAlfabeto(String path) {
        Map<String, ArrayList<Character>> alfabeto = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            alfabeto = (Map<String, ArrayList<Character>>) ois.readObject();
            System.out.println("Alfabeto cargado con éxito desde " + path);
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Error al cargar alfabetos desde el archivo " + path, e);
        }
        return alfabeto;
    }
}