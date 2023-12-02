package main.presentation.controllers;

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
    public static void vistaAlfabetoAB() {
        VistaAlfabetoAB vA = new VistaAlfabetoAB();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de alfabeto */
    public static void vistaAlfabetoCM() {
        VistaAlfabetoCM vA = new VistaAlfabetoCM();
    }

    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTextoAB() {
        VistaTextoAB vTxt = new VistaTextoAB();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTextoCM() {
        VistaTextoCM vTxt = new VistaTextoCM();
    }

    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextosAB() {
        VistaAsociacionTextosAB vAT = new VistaAsociacionTextosAB();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextosCM() {
        VistaAsociacionTextosCM vAT = new VistaAsociacionTextosCM();
    }

    /**
     * Muestra por pantalla la ventana de las funcionalidades de teclado
     */
    public static void vistaTecladoAB() {
        VistaTecladoAB vTec = new VistaTecladoAB();
    }
    /**
     * Muestra por pantalla la ventana de las funcionalidades de teclado
     */
    public static void vistaTecladoCM() {
        VistaTecladoCM vTec = new VistaTecladoCM();
    }


    //FUNCIONES DE CTRlDOMINIO DE ALFABETO
    /**
     * Llama a la función agregarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a agregar
     * @param entradaCaracteres es la lista de caracteres que forman el contenido del alfabeto
     */
    public static void agregarAlfabeto(String nomA, ArrayList<Character> entradaCaracteres) {
        boolean agregado = cd.agregarAlfabeto(nomA, entradaCaracteres);
    }
    /** Llama a la función getListaAlfabetos de CtrlDominio */
    public static void getListaAlfabetos() {
        //HashMap<String, Alfabeto> listaAlfabetos = cd.getListaAlfabetos(); // NO SE PUEDE PASAR EL OBJETO ALFABETO
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


    //FUNCIONES DE CTRlDOMINIO DE TEXTO
    /**
     * Llama a la función agregarTextoPalabras de CtrlDominio
     * @param nomTxt es el nombre del texto a agregar
     * @param texto es la lista de caracteres que forman el contenido del texto
     */
    public static void agregarTextoPalabras(String nomTxt, String texto) {
        boolean agregado = cd.agregarTextoPalabras(nomTxt, texto);
    }
    /*public static void agregarTextoPalabras(String nomT, String texto) {
        try {
            cd.agregarTextoPalabras(nomT,texto);
        } catch (Exception ignored) {}
    }*/
    /**
     * Llama a la función agregarTextoFrecuencias de CtrlDominio
     * @param nomTxt es el nombre del texto a agregar
     * @param frecuenciaPalabras es la map con las palabras y sus frecuencias que forman el contenido del texto
     */
    public static void agregarTextoFrecuencias(String nomTxt, HashMap<String,Integer> frecuenciaPalabras) {
        boolean agregado = cd.agregarTextoFrecuencias(nomTxt, frecuenciaPalabras);
    }
    /** Llama a la función getListaTextos de CtrlDominio */
    public static void getListaTextos() {
        //HashMap<String, Texto> getListaTextos = cd.getListaTextos(); NO SE PUEDE PASAR EL OBJETO TEXTO!!
    }
    /**
     * Llama a la función existetexto de CtrlDominio
     * @param nomTxt es el nombre del texto a consultar si existe
     */
    public static void existetexto(String nomTxt) {
        boolean existe = cd.existealfabeto(nomTxt);
    }
    /**
     * Llama a la función consultarContenidoTexto de CtrlDominio
     * @param nomTxt es el nombre del texto a consultar
     */
    public static void consultarContenidoTexto(String nomTxt) {
        String contenidoTxt = cd.consultarContenidoTexto(nomTxt);
    }
    /**
     * Llama a la función borrarTexto de CtrlDominio
     * @param nomTxt es el nombre del alfabeto a borrar
     */
    public static void borrarTexto(String nomTxt) {
        //cd.borrarTexto(nomTxt);
    }


    //FUNCIONES DE CTRlDOMINIO DE ASOCIACION DE TEXTOS
    //FUNCIONES DE CTRlDOMINIO DE TECLADO



}
