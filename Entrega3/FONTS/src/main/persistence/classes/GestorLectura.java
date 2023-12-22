package main.persistence.classes;

import drivers.InOut;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase que proporciona métodos para leer y validar información desde archivos.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class GestorLectura {
    /**
     * Verifica si un alfabeto es válido.
     * @param entrada cadena que representa el alfabeto.
     * @return True si el alfabeto es válido, False de lo contrario.
     */
    public static boolean alfabetoValido(String entrada) {
        if (entrada == null || entrada.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Lee un archivo que contiene un alfabeto y devuelve una lista de caracteres.
     * @param pathArchivo ruta del archivo que contiene el alfabeto.
     * @return lista de caracteres que representan el alfabeto.
     * @throws IOException en el caso de haber un error de entrada/salida al leer el archivo de texto.
     * @throws IllegalArgumentException en el caso que el contenido del archivo no es válido.
     */
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

    /**
     * Lee un archivo de texto y devuelve su contenido como una cadena.
     * @param pathArchivo ruta del archivo de texto.
     * @return contenido del archivo de texto como una cadena.
     * @throws IOException en el caso de haber un error de entrada/salida al leer el archivo de texto.
     */
    public String leerTextoPalabrasPath(String pathArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(pathArchivo));
        String line;
        String texto = "";
        while ((line = br.readLine()) != null) {
            texto += line;
        }
        return texto;
    }

    /**
     * Verifica si el formato de las frecuencias es correcto para agregar a un contenido de texto.
     * @param pathTexto ruta del archivo de texto asociado al contenido.
     * @param frecuencias mapa de frecuencias a agregar al contenido de texto.
     * @return True si el formato de las frecuencias es correcto, False de lo contrario.
     */
    public boolean formatoCorrectoAgregarFrecuenciasPath(String pathTexto, HashMap<String, Integer> frecuencias) {
        boolean formatoCorrecto = true;
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
        return formatoCorrecto;
    }
}
