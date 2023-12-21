package main.persistence.classes;

import drivers.InOut;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase que gestiona la carga y guardado de Conjuntos de Alfabetos en formato de bytes.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class GestorLectura {
    public static boolean alfabetoValido(String entrada) {
        if (entrada == null || entrada.isEmpty()) {
            return false; // Entrada vacía no es válida.
        }
        return true; // La entrada es válida si todos los segmentos contienen solo un carácter.
    }
    public ArrayList<Character> leerAlfabetosPath(String pathArchivo) throws IOException {
        ArrayList<Character> caracteres = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(pathArchivo));
        String line = br.readLine();
        if(line != null){
            if (!alfabetoValido(line)) {
                throw new IllegalArgumentException("El contenido del archivo no es válido.");
            }
            for (char c : line.toCharArray()) {
                caracteres.add(c);
            }
        }
        return caracteres;
    }

    public String leerTextoPalabrasPath(String pathArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(pathArchivo));
        String line;
        String texto = "";
        while ((line = br.readLine()) != null) {
            texto += line;
        }
        return texto;
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
