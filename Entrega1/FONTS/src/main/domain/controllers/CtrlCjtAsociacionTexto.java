package main.domain.controllers;


import main.domain.classes.AsociacionTextos;

import java.util.HashMap;

/**
 * Controlador encargado de gestionar los métodos de añadir i borrar asociacionestextos
 * Las asociaciones de textos existentes quedarán dentro de un HashMap<String,AsociacionTextos>
 * @author
 */
public class CtrlCjtAsociacionTexto {
    private HashMap<String, AsociacionTextos> textos = new HashMap<String, AsociacionTextos>();
}
