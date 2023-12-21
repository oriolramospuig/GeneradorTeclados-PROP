package main.persistence.classes;

import drivers.InOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GestorLectura {
    public ArrayList<Character> leerAlfabetosPath(String pathArchivo) throws IOException {
        return InOut.leerCaracteresDeArchivo(pathArchivo);
    }

    public String leerTextoPalabrasPath(String pathArchivo) throws IOException {
        return InOut.leerPalabrasDeArchivo(pathArchivo);
    }

    public boolean formatoCorrectoAgregarFrecuencias(String contenidoTexto, String pathTexto, HashMap<String, Integer> frecuencias) {
        boolean formatoCorrecto = true;
        if (!contenidoTexto.isEmpty()) {
            String[] lineas = contenidoTexto.split("\n");
            for (String linea : lineas) {
                linea = linea.trim();
                if (!linea.matches("\\S+\\s+\\d+")) {
                    formatoCorrecto = false;
                    break;
                }
                String[] partes = linea.split("\\s+");
                frecuencias.put(partes[0], Integer.parseInt(partes[1]));
            }
        } else {
            try {
                File archivo = new File(pathTexto);
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine().trim();
                    if (!linea.matches("\\S+\\s+\\d+")) {
                        formatoCorrecto = false;
                        break;
                    }
                    String[] partes = linea.split("\\s+");
                    frecuencias.put(partes[0], Integer.parseInt(partes[1]));
                }
                scanner.close();
            } catch (FileNotFoundException ex) {
                formatoCorrecto = false;
            }
        }
        return formatoCorrecto;
    }
}
