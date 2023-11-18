package main.domain.classes.functions;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

/** Clase
 * @author X (X@estudiantat.upc.edu)
 */
public class InOut {

    private Scanner scanner;

    public InOut() {
        this.scanner = new Scanner(System.in);
    }
    public String leerString() {
        return scanner.nextLine();
    }
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

    public ArrayList<Character> leerCaracteresDeTerminal(String line) {
        ArrayList<Character> caracteres = new ArrayList<>();
        for (char c : line.toCharArray()) {
            caracteres.add(c);
        }
        return caracteres;
    }

    public ArrayList<Character> leerCaracteresDeArchivo(String nombreArchivo) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        // Ruta absoluta del archivo
        String rutaArchivo = currentDirectory+"\\Entrega1\\INPUT_FILES\\"+nombreArchivo;
        ArrayList<Character> caracteres = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String line = br.readLine();
        if(line != null){
            if (!contenidoValido(line)) {
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


    /*public String leerPalabrasDeTerminal(String line) {
        HashMap<String, Integer> palabras = new HashMap<>();
        String texto = "";
        String linea = "";
        Integer frec = 0;
        while ((line = scanner.nextLine()) != null) {
            texto
        }
        for (char c : line.toCharArray()) {
            palabras.put(c,);
        }
        return palabras;
    }*/


    public String leerPalabrasDeArchivo(String nombreArchivo) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        // Ruta absoluta del archivo
        String rutaArchivo = currentDirectory+"\\Entrega1\\INPUT_FILES\\"+nombreArchivo;
        ArrayList<Character> caracteres = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String line = br.readLine();
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
    public boolean contenidoValido(String entrada) {
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

    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

}