package main.persistence.controllers;

import main.persistence.classes.GestorAlfabeto;

import java.io.FileNotFoundException;

/**
 *  El controlador de persistencia se encarga de gestionar el almacenamiento de datos, es decir, se
 *  encarga de saber dónde y como están estos almacenados.
 */
public class CtrlPersistencia {
    private final GestorAlfabeto gestorAlfabetoArchivo;

    //private final GestorTextoArchivo gestorTextoArchivo;

    public CtrlPersistencia() {
        gestorAlfabetoArchivo = new GestorAlfabeto();
        //gestorTextoArchivo = new GestorTextoArchivo();
    }

    public void guardaAlfabeto(String nombreA) throws FileNotFoundException {
        gestorAlfabetoArchivo.getContenidoAlfabeto(nombreA);
    }

    public boolean existeAlfabeto(String nombreA) {
        return gestorAlfabetoArchivo.existeAlfabeto(nombreA);
    }

    public boolean borraAlfabeto(String nombreA) {
        return gestorAlfabetoArchivo.borrarAlfabeto(nombreA);
    }
}