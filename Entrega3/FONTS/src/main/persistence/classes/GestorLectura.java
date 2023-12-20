package main.persistence.classes;

import drivers.InOut;

import java.io.IOException;
import java.util.ArrayList;

public class GestorLectura {
    public ArrayList<Character> leerPath(String pathArchivo) throws IOException {
        return InOut.leerCaracteresDeArchivo(pathArchivo);
    }

    public String leerTextoPalabrasPath(String pathArchivo) throws IOException {
        return InOut.leerPalabrasDeArchivo(pathArchivo);
    }
}
