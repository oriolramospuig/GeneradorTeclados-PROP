package main.persistence.classes;

import drivers.InOut;

import java.io.IOException;
import java.util.ArrayList;

public class GestorLectura {
    public ArrayList<Character> leerPath(String nombreAlfabeto, String pathArchivo) throws IOException {
        return InOut.leerCaracteresDeArchivo(pathArchivo);
    }
}
