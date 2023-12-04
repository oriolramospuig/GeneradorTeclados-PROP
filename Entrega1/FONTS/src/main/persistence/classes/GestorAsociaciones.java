package main.persistence.classes;

import main.domain.classes.Texto;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorAsociaciones {
    private static final Logger logger = Logger.getLogger(GestorAlfabeto.class.getName());
    public static void guardarAsociacion(HashMap<String, ArrayList<Texto>> texto, String path) {
        try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(path))) {
            o.writeObject(texto);
            System.out.println("Asociacion guardada con éxito en" + path);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error al guardar asociación en " + path, e);
        }
    }

    public static HashMap<String, ArrayList<Texto>> cargarAsociacion(String path) {
        HashMap<String, ArrayList<Texto>> asociacion = new HashMap<>();
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path))) {
            asociacion = (HashMap<String, ArrayList<Texto>>) oi.readObject();
            System.out.println("Asociacion cargada con éxito desde " + path);
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Error al cargar asociación desde " + path, e);
        }
        return asociacion;
    }
}
