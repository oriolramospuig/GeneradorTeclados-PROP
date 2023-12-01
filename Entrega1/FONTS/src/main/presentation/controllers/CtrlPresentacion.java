package main.presentation.controllers;

import main.domain.classes.Alfabeto;
import main.presentation.views.*;
import main.domain.controllers.CtrlDominio;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * El CtrlPresentacion se encarga de hacer de comunicador entre las vistas de la capa de presentación.
 * También transmite a la capa de presentación los datos de las capas inferiores.
 * @author
 */
public class CtrlPresentacion {
    /** Instància del controlador de domini */
    private static final CtrlDominio cd = new CtrlDominio();

    // COMUNICACIÓN ENTRE VISTAS
    /** Muestra por pantalla la ventana del menú principal */
    public static void iniPresentacion() {
        VistaMenuPrincipal vMP = new VistaMenuPrincipal();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de alfabeto */
    public static void vistaAlfabeto() {
        VistaAlfabeto vA = new VistaAlfabeto ();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTexto() {
        VistaTexto vTxt = new VistaTexto();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextos() {
        VistaAsociacionTextos vAT = new VistaAsociacionTextos();
    }
    /**
     * Muestra por pantalla la ventana de las funcionalidades de teclado
     */
    public static void vistaTeclado() {
        VistaTeclado vTec = new VistaTeclado();
    }


    //FUNCIONES DE DOMINIO



    //FUNCIONES DE ALFABETO
    /**
     * Llama a la función agregarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a agregar
     * @param entradaCaracteres es la lista de caracteres que forman el contenido del alfabeto
     */
    public static void agregarAlfabeto(String nomA, ArrayList<Character> entradaCaracteres) {
        boolean agregado = cd.agregarAlfabeto(nomA, entradaCaracteres);
    }
    /**
     * Llama a la función getListaAlfabetos de CtrlDominio
     */
    public static void getListaAlfabetos() {
        HashMap<String, Alfabeto> listaAlfabetos = cd.getListaAlfabetos();
    }
    /**
     * Llama a la función existealfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a consultar si existe
     */
    public static void existealfabeto(String nomA) {
        boolean existe = cd.existealfabeto(nomA);
    }
    /**
     * Llama a la función consultarContenidoAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a consultar
     */
    public static void consultarContenidoAlfabeto(String nomA) {
        ArrayList<Character> contenidoA = cd.consultarContenidoAlfabeto(nomA);
    }
    /**
     * Llama a la función borrarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a borrar
     */
    public static void borrarAlfabeto(String nomA) {
        //cd.borrarAlfabeto(nomA);
    }


    //s'han d'afegir totes les funcions de totes les classes que crida el ctrlDominio


    //FUNCIONES DE TEXTO
    /**
     * Llama a la función agregarTextoPalabras de CtrlDomini
     * @param
     * @param
     * @param
     */
    public static void agregarTextoPalabras(String nomT, String texto) {
        try {
            cd.agregarTextoPalabras(nomT,texto);
        } catch (Exception ignored) {}
    }

    //FUNCIONES DE ASOCIACION DE TEXTOS
    //FUNCIONES DE TECLADO



}
