package main.domain.controllers;


import main.domain.classes.Teclado;

import java.util.HashMap;

/**
 * Controlador encargado de gestionar los métodos de añadir i borrar teclados
 * Los teclados existentes quedarán dentro de un HashMap<String, Teclado>
 * @author
 */
public class CtrlCjtTeclados {
    HashMap<String, Teclado> teclados = new HashMap<String, Teclado>();
}
