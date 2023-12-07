package main.persistence.controllers;

import main.persistence.classes.GestorAlfabeto;
import main.persistence.classes.GestorAsociaciones;
import main.persistence.classes.GestorConfiguracion;
import main.persistence.classes.GestorTexto;

/**
 *  El controlador de persistencia se encarga de gestionar el almacenamiento de datos, es decir, se
 *  encarga de saber dónde y como están estos almacenados.
 */
public class CtrlPersistencia {
    //private final GestorConfiguracion gestorConfiguracion;
    private final GestorAlfabeto gestorAlfabeto;
    private final GestorTexto gestorTexto;
    private final GestorAsociaciones gestorAsociaciones;

    public CtrlPersistencia() {
        //gestorConfiguracion = new GestorConfiguracion();
        gestorAlfabeto = new GestorAlfabeto();
        gestorTexto = new GestorTexto();
        gestorAsociaciones = new GestorAsociaciones();
    }

    // ---------- FUNCIONES CONFIGURACION ----------
/*
    public void guardaConfig(byte[] bytes) {
        gestorConfiguracion.guardaConfig(bytes);
    }

    public byte[] cargaConfig() {
        return gestorConfiguracion.cargaConfig();
    }

    public boolean existeConfig() {
        return gestorConfiguracion.existeConfig();
    }

    public boolean borraConfig() {
        return gestorConfiguracion.borraConfig();
    }

 */

    /**
     * Carga contenido de Alfabetos de la clase Configuracion del fichero "configAlfabetos.cdp"
     *
     * @return configuracion de alfabetos como a byte array
     */
 /*
 /**
     * Guarda contenido Alfabetos de la clase Configuracion en el fichero configAlfabetos.cdp"
     *
     * @param bytes
     *
    public void guardaConfigAlfabetos(byte[] bytes) {
        gestorConfiguracion.guardaConfigAlfabetos(bytes);
    }

    public byte[] cargaConfigAlfabetos() {
        return gestorConfiguracion.cargaConfigAlfabetos();
    }*/
    /*

    /**
     * Devuelve true si existe contenido de alfabetos en la clase Configuracion
     *
     * @return

    public boolean existeConfigAlfabetos() {
        return gestorConfiguracion.existeConfigAlfabetos();
    }

    /**
     * Borra fichero alfabeto de Configuracion
     *
     * @return
     *
    public boolean borraConfigAlfabeto() {
        return gestorConfiguracion.borraConfigAlfabetos();
    }
  */


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
}