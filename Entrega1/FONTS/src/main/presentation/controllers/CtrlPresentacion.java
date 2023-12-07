package main.presentation.controllers;

import drivers.InOut;
import main.domain.classes.Alfabeto;
import main.domain.classes.AsociacionTextos;
import main.presentation.views.*;
import main.domain.controllers.CtrlDominio;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

    //VISTAS ALFABETO
    /** Muestra por pantalla la ventana de agregar alfabeto */
    public static void vistaAlfabetoA() {
        VistaAlfabetoA vA = new VistaAlfabetoA();
    }
    /** Muestra por pantalla la ventana de consultar alfabeto */
    public static void vistaAlfabetoC() {
        VistaAlfabetoC vA = new VistaAlfabetoC();
    }
    /** Muestra por pantalla la ventana de modificar de alfabeto */
    public static void vistaAlfabetoM() {
        VistaAlfabetoM vA = new VistaAlfabetoM();
    }
    /** Muestra por pantalla la ventana de borrar alfabeto */
    public static void vistaAlfabetoB() {
        VistaAlfabetoB vA = new VistaAlfabetoB();
    }

    //VISTAS TEXTO
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTextoA() {
        VistaTextoA vTxt = new VistaTextoA();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTextoC() {
        VistaTextoC vTxt = new VistaTextoC();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTextoM() {
        VistaTextoM vTxt = new VistaTextoM();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTextoB() {
        VistaTextoB vTxt = new VistaTextoB();
    }

    //VISTAS ASOCIACIONES DE TEXTOS
    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextosA() {
        VistaAsociacionTextosA vAT = new VistaAsociacionTextosA();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextosB() {
        VistaAsociacionTextosB vAT = new VistaAsociacionTextosB();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextosC() {
        VistaAsociacionTextosC vAT = new VistaAsociacionTextosC();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextosM() {
        VistaAsociacionTextosM vAT = new VistaAsociacionTextosM();
    }

    //VISTAS TECLADO
    /** Muestra por pantalla la ventana de las funcionalidades de teclado */
    public static void vistaTecladoA() {
        VistaTecladoA vTec = new VistaTecladoA();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de teclado */
    public static void vistaTecladoC() {
        VistaTecladoC vTec = new VistaTecladoC();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTecladoM() {
        VistaTecladoM vTxt = new VistaTecladoM();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTecladoB() {
        VistaTecladoB vTxt = new VistaTecladoB();
    }


    //FUNCIONES DE CTRlDOMINIO DE ALFABETO
    /**
     * Llama a la función agregarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a agregar
     * @param entradaCaracteres es el contenido del alfabeto
     * @param path path donde se crea y guarda el alfabeto
     */
    public static boolean agregarAlfabetoManual(String nomA, String entradaCaracteres, String path) {
        ArrayList<Character> entrada = InOut.leerCaracteresDeTerminal(entradaCaracteres);
        boolean agregado = cd.agregarAlfabeto(nomA, entrada);

        if (agregado) {
            try {
                File archivo = new File(path, nomA + ".txt");
                if (!archivo.exists()) {
                    archivo.createNewFile(); // Crea el archivo si no existe
                }
                try (PrintWriter writer = new PrintWriter(archivo)) {
                    for (Character c : entrada) {
                        writer.print(c);
                    }
                }
                return true; // El alfabeto se agregó correctamente y se guardó el archivo
            } catch (IOException e) {
                return false; // Retorna false si hubo un error al escribir el archivo
            }
        } else {
            return false; // El alfabeto no se pudo agregar
        }
    }
    /**
     * Llama a la función agregarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a agregar
     * @param entradaCaracteres es el contenido del alfabeto
     */
    public static boolean agregarAlfabetoManual(String nomA, String entradaCaracteres) {
        ArrayList<Character> entrada = InOut.leerCaracteresDeTerminal(entradaCaracteres);
        boolean agregado = cd.agregarAlfabeto(nomA, entrada);
        return agregado;
    }
    /**
     * Llama a la función agregarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a agregar
     * @param path es la lista de caracteres que forman el contenido del alfabeto
     */
    public static boolean agregarAlfabetoPath(String nomA, String path) {
        //ArrayList<Character> entrada = InOut.leerCaracteresDeArchivo(path);
        //boolean agregado = cd.agregarAlfabeto(nomA, entradaCaracteres);
        //return agregado;
        return false;
    }

    //crec que no s'hauria d'utilitzar perque no podem passar per referencia tots els alfabets aixi per la cara
    /** Llama a la función getListaAlfabetos de CtrlDominio
    public static void getListaAlfabetos() {
        //HashMap<String, Alfabeto> listaAlfabetos = cd.getListaAlfabetos(); // NO SE PUEDE PASAR EL OBJETO ALFABETO
    }*/
    /** Llama a la función getNombresAlfabetos de CtrlDominio */
    public static ArrayList<String> getNombresAlfabetos() {
        ArrayList<String> listaAlfabetosNombres = cd.getNombresAlfabetos();
        return listaAlfabetosNombres;
    }
    /**
     * Llama a la función existealfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a consultar si existe
     */
    public static boolean existeAlfabeto(String nomA) {
        boolean existe = cd.existealfabeto(nomA);
        return existe;
    }
    /**
     * Llama a la función consultarContenidoAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a consultar
     */
    public static ArrayList<Character> consultarContenidoAlfabeto(String nomA) {
        ArrayList<Character> contenidoA = cd.consultarContenidoAlfabeto(nomA);
        return contenidoA;
    }
    /**
     * Llama a la función borrarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a borrar
     */
    public static void borrarAlfabeto(String nomA) {
        cd.borrarAlfabeto(nomA);
    }


    //FUNCIONES DE CTRlDOMINIO DE TEXTO
    /**
     * Llama a la función agregarTextoPalabras de CtrlDominio
     * @param nomTxt es el nombre del texto a agregar
     * @param texto es la lista de caracteres que forman el contenido del texto
     */
    public static boolean agregarTextoPalabras(String nomTxt, String texto) {
        //ArrayList<Character> entrada = InOut.leerCaracteresDeTerminal(entradaCaracteres);
        boolean agregado = cd.agregarTextoPalabras(nomTxt, texto);
        return agregado;
    }
    /**
     * Llama a la función agregarTextoFrecuencias de CtrlDominio
     * @param nomTxt es el nombre del texto a agregar
     * @param frecuenciaPalabras es la map con las palabras y sus frecuencias que forman el contenido del texto
     */
    public static boolean agregarTextoFrecuencias(String nomTxt, String frecuenciaPalabras) {
        //HashMap<String,Integer> entrada = InOut.leerCaracteresDeTerminal(frecuenciaPalabras);
        //boolean agregado = cd.agregarTextoFrecuencias(nomTxt, entrada);
        //return agregado;
        return false;
    }

    //crec que no s'hauria d'utilitzar perque no podem passar per referencia tots els textos aixi per la cara
    /** Llama a la función getListaTextos de CtrlDominio
    public static void getListaTextos() {
        //HashMap<String, Texto> ListaTextos = cd.getListaTextos(); NO SE PUEDE PASAR EL OBJETO TEXTO!!
    }*/
    /** Llama a la función getNombresTextos de CtrlDominio */
    public static ArrayList<String> getNombresTextos() {
        ArrayList<String> listaTextosNombres = cd.getNombresAsociaciones();
        return listaTextosNombres;
    }
    /**
     * Llama a la función existetexto de CtrlDominio
     * @param nomTxt es el nombre del texto a consultar si existe
     */
    public static boolean existeTexto(String nomTxt) {
        boolean existe = cd.existealfabeto(nomTxt);
        return existe;
    }
    /**
     * Llama a la función consultarContenidoTexto de CtrlDominio
     * @param nomTxt es el nombre del texto a consultar
     */
    public static String consultarContenidoTexto(String nomTxt) {
        String contenidoTxt = cd.consultarContenidoTexto(nomTxt);
        return contenidoTxt;
    }
    /**
     * Llama a la función borrarTexto de CtrlDominio
     * @param nomTxt es el nombre del alfabeto a borrar
     */
    public static void borrarTexto(String nomTxt) {
        cd.borrarTexto(nomTxt);
    }


    //FUNCIONES DE CTRlDOMINIO DE ASOCIACION DE TEXTOS
    /**
     * Llama a la función agregarAsociacion de CtrlDominio
     * @param nomAT es el nombre de la asociación a agregar
     * @param textosagregar es la lista de nombres de textos a agregar en la asociación
     */
    public static boolean agregarAsociacion(String nomAT, ArrayList<String> textosagregar) {
        boolean agregada = cd.agregarAsociacion(nomAT, textosagregar);
        return agregada;
    }
    /**
     * Llama a la función agregarAsociacion de CtrlDominio
     * @param nomAT es el nombre de la asociación a agregar
     * @param textosagregar es la lista de nombres de textos a agregar en la asociación
     */
    public static void agregarTextoAsociacion (String nomAT, ArrayList<String> textosagregar) {
        cd.agregarTextoAsociacion(nomAT, textosagregar);
    }

    //crec que no s'hauria d'utilitzar perque no podem passar per referencia totes les associacions aixi per la cara
    /** Llama a la función getListaAsociaciones de CtrlDominio
     public static void getListaAsociaciones() {
     //HashMap<String, AsociacionTextos> ListaAsociaciones = cd.getListaAsociaciones(); NO SE PUEDE PASAR EL OBJETO TEXTO!!
     }*/
    /**
     * Llama a la función getNombresAsociaciones de CtrlDominio
     *
     * @return
     */
    public static ArrayList<String> getNombresAsociaciones() {
        ArrayList<String> listaAsociacionesNombres = cd.getNombresAsociaciones();
        return listaAsociacionesNombres;
    }
    /**
     * Llama a la función existeasociacion de CtrlDominio
     * @param nomAT es el nombre de la asociación a consultar si existe
     */
    public static boolean existeAsociacion(String nomAT) {
        boolean existe = cd.existeasociacion(nomAT);
        return existe;
    }
    /**
     * Llama a la función borrarAsociacionTextos de CtrlDominio
     * @param nomAT es el nombre de la asociación a borrar
     */
    public static void borrarAsociacionTextos(String nomAT) {
        cd.borrarAsociacionTextos(nomAT);
    }


    //FUNCIONES DE CTRlDOMINIO DE TECLADO
    /**
     * Retorna si el alfabeto y la asociacion de textos tiene caracteres parecidos y por lo tanto son compatibles
     * @param alfabeto objeto alfabeto para comparar
     * @param asociacionTextos objeto asociacion de textos para comparar
     * @return Boolean: true si el alfabeto y la asociación de textos son comptibles, false si no lo son
     */
    public boolean compatibles(Alfabeto alfabeto, AsociacionTextos asociacionTextos){
        boolean comp = cd.compatibles(alfabeto,asociacionTextos);
        return comp;
    }

    /**
     * Llama a la función agregarTeclado de CtrlDominio
     * @param nomT nombre del teclado a agregar
     * @param nomA nombre del alfabeto a vincular con el teclado nomT
     * @param nomAT nombre de la asociación de textos a vincular con el teclado nomT
     */
    public int agregarTeclado(String nomT, String nomA, String nomAT){
        int acabado = cd.agregarTeclado(nomT,nomA,nomAT);
        return acabado;
    }
    //falten mes


}
