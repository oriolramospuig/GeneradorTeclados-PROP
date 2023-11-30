package main.presentation.controllers;

import main.presentation.views.*;
import main.domain.controllers.CtrlDominio;

import java.util.ArrayList;

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
    public static void vistaAlfabeto(String nomA, String contingut) {
        //VistaAlfabeto vA = new VistaAlfabeto (nomA,contingut);
    }

    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTexto(String nomTxt, String contingut) {
        //VistaTexto vTxt = new VistaTexto(nomTxt,contingut);
    }

    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextos(String nomAT) {
        //VistaAsociacionTextos vAT = new VistaAsociacionTextos(nomAT);
    }

    /**
     * Muestra por pantalla la ventana de las funcionalidades de teclado
     */
    public static void vistaTeclado(String nomTec) {
        //VistaTeclado vTec = new VistaTeclado(nomTec);
    }


    //FUNCIONES DE DOMINIO
    //FUNCIONES DE ALFABETO
    /**
     * Llama a la función agregarAlfabeto de CtrlDominio
     * @param
     * @param
     */
    public static void agregarAlfabeto(String nomA, ArrayList<Character> entradaCaracteres) {
        cd.agregarAlfabeto(nomA, entradaCaracteres);
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
