package main.persistence.controllers;

import main.persistence.classes.GestorAlfabeto;
import main.persistence.classes.GestorConfiguracion;
import main.persistence.classes.GestorTexto;

/**
 *  El controlador de persistencia se encarga de gestionar el almacenamiento de datos, es decir, se
 *  encarga de saber dónde y como están estos almacenados.
 */
public class CtrlPersistencia {
    private final GestorConfiguracion gestorConfiguracion;
    private final GestorAlfabeto gestorAlfabeto;
    private final GestorTexto gestorTexto;

    public CtrlPersistencia() {
        gestorConfiguracion = new GestorConfiguracion();
        gestorAlfabeto = new GestorAlfabeto();
    }

    // ---------- FUNCIONES CONFIGURACION ----------
    /**
     * Guarda contenido Alfabetos de la clase Configuracion en el fichero configAlfabetos.cdp"
     *
     * @param bytes
     */
    public void guardaConfigAlfabetos(byte[] bytes) {
        gestorConfiguracion.guardaConfigAlfabetos(bytes);
    }

    /**
     * Carga contenido de Alfabetos de la clase Configuracion del fichero "configAlfabetos.cdp"
     *
     * @return configuracion de alfabetos como a byte array
     */
    public byte[] cargaConfigAlfabetos() {
        return gestorConfiguracion.cargaConfigAlfabetos();
    }

    /**
     * Devuelve true si existe contenido de alfabetos en la clase Configuracion
     *
     * @return
     */
    public boolean existeCongigAlfabetos() {
        return gestorConfiguracion.existeConfigAlfabetos();
    }

    /**
     * Borra fichero alfabeto de Configuracion
     *
     * @return
     */
    public boolean borraConfigAlfabeto() {
        return gestorConfiguracion.borraConfigAlfabetos();
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


    // ---------- FUNCIONES TECLADOS ----------
}