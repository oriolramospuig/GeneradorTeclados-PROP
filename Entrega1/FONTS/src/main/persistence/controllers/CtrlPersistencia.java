package main.persistence.controllers;

import main.persistence.classes.*;

/**
 *  El controlador de persistencia se encarga de gestionar el almacenamiento de datos, es decir, se
 *  encarga de saber dónde y como están estos almacenados.
 */
public class CtrlPersistencia {
    private final GestorAlfabeto gestorAlfabeto;
    private final GestorTexto gestorTexto;
    private final GestorAsociaciones gestorAsociaciones;
    private final GestorTeclado gestorTeclado;

    public CtrlPersistencia() {
        gestorAlfabeto = new GestorAlfabeto();
        gestorTexto = new GestorTexto();
        gestorAsociaciones = new GestorAsociaciones();
        gestorTeclado = new GestorTeclado();
    }

    // ---------- FUNCIONES ALFABETOS ----------
    public void guardaCnjtAlfabetos(byte[] bytes, String path) {
        GestorAlfabeto.gestorAlfabetos(bytes, path);
    }

    public byte[] cargaCnjtAlfabetos(String path) {
        return gestorAlfabeto.cargarAlfabetos(path);
    }


    // ---------- FUNCIONES TEXTOS ----------
    public void guardaCnjtTextos(byte[] bytes, String path) {
        GestorTexto.gestorTextos(bytes, path);
    }

    public byte[] cargaCnjtTextos(String path) {
        return gestorTexto.cargarTextos(path);
    }


    // ---------- FUNCIONES ASOCIACIONES TEXTOS ----------
    public void guardaCnjtAsociaciones(byte[] bytes, String path) {
        GestorAsociaciones.gestorAsociaciones(bytes, path);
    }

    public byte[] cargaCnjtAsociaciones(String path) {
        return gestorAsociaciones.cargarAsociaciones(path);
    }


    // ---------- FUNCIONES TECLADOS ----------
    public void guardaCnjtTeclados(byte[] bytes, String path) {
        GestorTeclado.gestorTeclados(bytes, path);
    }

    public byte[] cargaCnjtTeclados(String path) {
        return gestorTeclado.cargarTeclados(path);
    }
}