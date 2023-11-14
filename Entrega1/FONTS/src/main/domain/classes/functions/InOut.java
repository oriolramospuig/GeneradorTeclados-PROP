package main.domain.classes.functions;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
    //no cal que llegeixi des d'aquí podem llegir des del controlador i ara nomes li passem el string
    public ArrayList<Character> leerCaracteresDeTerminal(String line) {
        ArrayList<Character> caracteres = new ArrayList<>();
        for (char c : line.toCharArray()) {
            caracteres.add(c);
        }
        return caracteres;
    }

    public ArrayList<Character> leerParabrasDeTerminal(String line) {
        ArrayList<Character> freqletras = new ArrayList<>();
        for (char c : line.toCharArray()) { // NO HAY QUE HACER ESTO, HAY QUE LEER FRECUENCIAS
            freqletras.add(c);
        }
        return freqletras;
    }


    /*public ArrayList<Character> leerCaracteresDeArchivo(String nombreArchivo) throws FileNotFoundException {
        File file = new File(nombreArchivo);
        Scanner fileScanner = new Scanner(file);
        ArrayList<Character> caracteres = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            for (char c : line.toCharArray()) {
                caracteres.add(c);
            }
        }

        fileScanner.close();
        return caracteres;
    }
     */

    public ArrayList<Character> leerCaracteresDeArchivo(String nombreArchivo) throws FileNotFoundException {
        File file = new File(nombreArchivo);
        Scanner fileScanner = new Scanner(file);
        ArrayList<Character> caracteres = new ArrayList<>();
        boolean esPrimeraLinea = true;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // Verificar la validez de la primera línea que se espera contenga la definición de caracteres.
            if (esPrimeraLinea) {
                if (!contenidoValido(line)) {
                    fileScanner.close();
                    throw new IllegalArgumentException("El contenido del archivo no es válido.");
                }
                esPrimeraLinea = false;
            }

            for (char c : line.toCharArray()) {
                if(c != ' ') { // Asume que los caracteres están separados por espacios, ignora los espacios
                    caracteres.add(c);
                }
            }
        }

        fileScanner.close();
        return caracteres;
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
