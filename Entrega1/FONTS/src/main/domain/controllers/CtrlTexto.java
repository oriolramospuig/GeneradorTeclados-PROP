package main.domain.controllers;

import main.domain.classes.Texto;
import main.domain.classes.ConjuntoTextos;
import main.domain.classes.ConjuntoTeclados;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar i borrar alfabetos
 * Los alfabetos existentes quedarán dentro de un ...
 *
 */
public class CtrlTexto {

    // ---------- PARÁMETROS ----------
    /**
     * Parámetros de la clase Alfabeto y ConjuntoAlfabetos
     */
    private Texto TextoExistente;
    private ConjuntoTextos CjtTextos;
    private ConjuntoTeclados CjtTeclados;

    /**
     * Asigna un alfabeto y un cjt de alfabetos vacío
     */
    public CtrlTexto(){
        CjtTextos = null;
        TextoExistente = null;
    }



}
