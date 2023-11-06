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

    public ArrayList<Character> leerCaracteresDeTerminal() {
        String line = leerString();
        ArrayList<Character> caracteres = new ArrayList<>();
        for (char c : line.toCharArray()) {
            caracteres.add(c);
        }
        return caracteres;
    }

    public ArrayList<Character> leerCaracteresDeArchivo(String nombreArchivo) throws FileNotFoundException {
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

    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
