package main.persistence.classes;

import java.io.*;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Implementación de la clase gestionadora de datos para la clase "Texto", carga/vuelca los textos modificados en cada caso.
 */
public class GestorTexto {
    /**
     * Implementación del patrón de diseño "Singleton", con el objetivo de que haya una única instancia de esta clase en el
     * sistema. En este caso, esta propiedad es deseada ya que esta classe no tiene estado (astributos no estáticos). Para
     * lograrlo, declaramos la constructora como privada y añadimos una operación estática que retorne siempre la misma
     * instancia. Para acceder a esta instancia lo haremos mediante la llamada GestorTextoArchivo.getInstance();
     */
    /*private static GestorTexto singletonObject;

    public static GestorTexto getInstance() {
        if (singletonObject == null)
            singletonObject = new GestorTexto() {
            };
        return singletonObject;
    }

    public GestorTexto(){}

    //Para el consultarTexto
    public List<String> getContenidoTexto (String nombreArchivo) throws FileNotFoundException {
        LinkedList<String> contenidoTexto = new LinkedList<String>();

        FileReader fr = new FileReader("../INPUT_FILES/" + nombreArchivo);
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine()) {
            contenidoTexto.add(new String(scan.nextLine()));
        }
        return contenidoTexto;
    }

    public boolean existeTexto(String nombreTexto) {
        Path rutaArchivo = FileSystems.getDefault().getPath(nombreTexto);
        return Files.exists(rutaArchivo);
    }

    //Para borrarTexto
    public boolean borrarTexto(String nombreTexto) {
        Path rutaArchivo = FileSystems.getDefault().getPath(nombreTexto);

        try {
            Files.delete(rutaArchivo);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }*/
    public void guardarTexto(String texto, String path) {
        Path p = Paths.get(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(p.toString()))) {
            writer.write(texto);
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el texto: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    public void cargarTexto(String path) {
        StringBuilder texto = new StringBuilder();
        Path p = Paths.get(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(p.toString()))) {
            //para guardar cada linea del contenido del archivo
            String linea;
            while ((linea = reader.readLine()) != null) {
                texto.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("[#CARGAR] Error al cargar el texto: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
        //da error y no se porque
        //return texto.toString();
    }

}