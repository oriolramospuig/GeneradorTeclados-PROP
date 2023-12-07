package drivers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** Clase para gestionar entrada/salida de la terminal
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class InOut {
    private Scanner scanner;

    /**
     * Constructor de la clase InOut. Inicializa un objeto Scanner para la entrada estándar.
     */
    public InOut() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Lee una línea de texto desde la entrada estándar.
     * @return La línea de texto leída o null si no hay más elementos para leer.
     */
    public String leerString() {
        String linea;
        try{
            linea = scanner.nextLine();
            return linea;
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    /**
     * Lee un número entero desde la entrada estándar.
     * @return El número entero leído o -1 si la entrada no es válida como entero.
     */
    public int leerEntero() {
        if (scanner.hasNextInt()) {
            int numero = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            return numero;
        } else {
            scanner.nextLine(); // Consume the invalid input
            return -1; // O puedes lanzar una excepción si prefieres manejarlo de esa manera
        }
    }

    /**
     * Convierte una cadena de texto en una lista de caracteres.
     * @param line La cadena de texto que se convertirá.
     * @return Una lista de caracteres que representa la cadena de texto.
     */
    public static ArrayList<Character> leerCaracteresDeTerminal(String line) {
        ArrayList<Character> caracteres = new ArrayList<>();
        for (char c : line.toCharArray()) {
            caracteres.add(c);
        }
        return caracteres;
    }

    /**
     * Lee caracteres de un archivo y los almacena en una lista.
     *
     * @param nombreArchivo El nombre del archivo que se va a leer.
     * @return Una lista de caracteres leídos desde el archivo.
     * @throws IOException Si ocurre un error al leer el archivo.
     * @throws IllegalArgumentException Si el contenido del archivo no es válido.
     */
    public static ArrayList<Character> leerCaracteresDeArchivo(String nombreArchivo) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        // Ruta absoluta del archivo
        String rutaArchivo = currentDirectory+"\\Entrega1\\data\\Alfabetos\\"+nombreArchivo;
        ArrayList<Character> caracteres = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String line = br.readLine();
        if(line != null){
            if (!alfabetoValido(line)) {
                throw new IllegalArgumentException("El contenido del archivo no es válido.");
            }
            for (char c : line.toCharArray()) {
                if (c != ' ') { // Asume que los caracteres están separados por espacios, ignora los espacios
                    caracteres.add(c);
                }
            }
        }
        return caracteres;
    }

    /**
     * Lee líneas de texto que contienen palabras y sus frecuencias y almacena la información en un HashMap.
     * @param n Número de líneas a leer.
     * @return Un HashMap que mapea palabras a sus frecuencias.
     * @throws NumberFormatException Si la frecuencia no es un número válido.
     */
    public HashMap<String,Integer> leerTextoFrecuenciasPalabras(int n) {
        HashMap<String, Integer> frecuenciaPalabras = new HashMap<>();
        String linea;
        for(int i = 0; i < n; i++){
            linea = leerString();
            if(linea == null) return null;
            String[] partes = linea.split(" ");
            if(partes.length != 2) return null;
            try{
                Integer f = Integer.valueOf(partes[1]);
                frecuenciaPalabras.put(partes[0],f);
            }
            catch (NumberFormatException e){
                return null;
            }
        }
        return frecuenciaPalabras;
    }

    /**
     * Lee todas las líneas de un archivo y concatena el contenido en un solo String.
     *
     * @param nombreArchivo El nombre del archivo que se va a leer.
     * @return Un String que contiene todas las líneas del archivo concatenadas.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public String leerPalabrasDeArchivo(String nombreArchivo) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        // Ruta absoluta del archivo
        String rutaArchivo = currentDirectory+"\\Entrega1\\INPUT_FILES\\"+nombreArchivo;
        ArrayList<Character> caracteres = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String line;
        String texto = "";
        while ((line = br.readLine()) != null) {
            texto += line;
        }
        return texto;
    }


    /**
     * Valida si la cadena de entrada representa una secuencia de caracteres válida,
     * es decir, caracteres individuales separados por espacios.
     * @param entrada La cadena de entrada a validar.
     * @return true si la entrada es válida, false de lo contrario.
     */
    public static boolean alfabetoValido(String entrada) {
        if (entrada == null || entrada.isEmpty()) {
            return false; // Entrada vacía no es válida.
        }
        String[] partes = entrada.split(" ");
        for (String parte : partes) {
            // Verifica que cada parte sea un solo carácter.
            if (parte.length() != 1) {
                return false;
            }
        }
        return true; // La entrada es válida si todos los segmentos contienen solo un carácter.
    }

    /**
     * Cierra el objeto Scanner utilizado para la entrada estándar si aún no ha sido cerrado.
     */
    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
