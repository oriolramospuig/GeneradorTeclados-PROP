package main.presentation.controllers;

import drivers.InOut;
import main.domain.classes.Alfabeto;
import main.domain.classes.AsociacionTextos;
import main.domain.classes.types.PairInt;
import main.presentation.views.*;
import main.domain.controllers.CtrlDominio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * El CtrlPresentacion se encarga de hacer de comunicador entre las vistas de la capa de presentación.
 * También transmite a la capa de presentación los datos de las capas inferiores.
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class CtrlPresentacion {
    /** Instància del controlador de domini. */
    private static final CtrlDominio cd = new CtrlDominio();

    // COMUNICACIÓN ENTRE VISTAS
    /** Muestra por pantalla la ventana del menú principal. */
    public static void iniPresentacion() {
        VistaMenuPrincipal vMP = new VistaMenuPrincipal();
    }

    //VISTAS ALFABETO
    /** Muestra por pantalla la ventana de agregar alfabeto. */
    public static void vistaAlfabetoA() {
        VistaAlfabetoA vA = new VistaAlfabetoA();
    }
    /** Muestra por pantalla la ventana de consultar alfabeto. */
    public static void vistaAlfabetoC() {
        VistaAlfabetoC vA = new VistaAlfabetoC();
    }
    /** Muestra por pantalla la ventana de modificar alfabeto. */
    public static void vistaAlfabetoM() {
        VistaAlfabetoM vA = new VistaAlfabetoM();
    }
    /** Muestra por pantalla la ventana de borrar alfabeto. */
    public static void vistaAlfabetoB() {
        VistaAlfabetoB vA = new VistaAlfabetoB();
    }

    //VISTAS TEXTO
    /** Muestra por pantalla la ventana de agregar texto. */
    public static void vistaTextoA() {
        VistaTextoA vTxt = new VistaTextoA();
    }
    /** Muestra por pantalla la ventana de consultar texto. */
    public static void vistaTextoC() {
        VistaTextoC vTxt = new VistaTextoC();
    }
    /** Muestra por pantalla la ventana de modificar texto. */
    public static void vistaTextoM() {
        VistaTextoM vTxt = new VistaTextoM();
    }
    /** Muestra por pantalla la ventana de borrar texto. */
    public static void vistaTextoB() {
        VistaTextoB vTxt = new VistaTextoB();
    }

    //VISTAS ASOCIACIONES DE TEXTOS
    /** Muestra por pantalla la ventana de agregar asociación de textos. */
    public static void vistaAsociacionTextosA() {
        VistaAsociacionTextosA vAT = new VistaAsociacionTextosA();
    }
    /** Muestra por pantalla la ventana de borrar asociación de textos. */
    public static void vistaAsociacionTextosB() {
        VistaAsociacionTextosB vAT = new VistaAsociacionTextosB();
    }
    /** Muestra por pantalla la ventana de consultar asociación de textos. */
    public static void vistaAsociacionTextosC() {
        VistaAsociacionTextosC vAT = new VistaAsociacionTextosC();
    }
    /** Muestra por pantalla la ventana de modificar asociación de textos. */
    public static void vistaAsociacionTextosM() {
        VistaAsociacionTextosM vAT = new VistaAsociacionTextosM();
    }

    //VISTAS TECLADO
    /** Muestra por pantalla la ventana de agregar teclado. */
    public static void vistaTecladoA() {
        VistaTecladoA vTec = new VistaTecladoA();
    }
    /** Muestra por pantalla la ventana de consultar teclado. */
    public static void vistaTecladoC() {
        VistaTecladoC vTec = new VistaTecladoC();
    }
    /** Muestra por pantalla la ventana de modificar teclado. */
    public static void vistaTecladoM() {
        VistaTecladoM vTec = new VistaTecladoM();
    }
    /** Muestra por pantalla la ventana de borrar teclado. */
    public static void vistaTecladoB() {
        VistaTecladoB vTec= new VistaTecladoB();
    }


    //FUNCIONES DE CTRlDOMINIO DE ALFABETO
    /**
     * Llama a la función agregarAlfabeto de CtrlDominio.
     * @param nomA es el nombre del alfabeto a agregar.
     * @param entrada la lista de caracteres que forman el contenido del alfabeto.
     * @return Boolean: true si se ha agregado bien, false si no se ha agregado bien.
     */
    public static boolean agregarAlfabetoManual(String nomA, ArrayList<Character> entrada) {
        return cd.agregarAlfabeto(nomA, entrada);
    }

    /**
     * Llama a la función agregarAlfabetoPath de CtrlDominio.
     * @param nomA es el nombre del alfabeto a agregar.
     * @param path es el path donde hay que buscar el archivo que es el alfabeto con nombre nomA.
     * @return Boolean: true si se ha agregado bien, false si no se ha agregado bien.
     */
    public static boolean agregarAlfabetoPath(String nomA, String path) throws IOException {
        return CtrlDominio.agregarAlfabetoPath(nomA, path);
    }

    /** Llama a la función getNombresAlfabetos de CtrlDominio.
     * @return ArrayList<String>: Lista de nombres de los alfabetos del conjunto de alfabetos existente.
     */
    public static ArrayList<String> getNombresAlfabetos() {
        ArrayList<String> listaAlfabetosNombres = cd.getNombresAlfabetos();
        return listaAlfabetosNombres;
    }

    /**
     * Consulta y devuelve el contenido de un alfabeto dado su nombre.
     * Llama a la función consultarContenidoAlfabeto de CtrlDominio.
     * @param nomA El nombre del alfabeto a consultar.
     * @return ArrayList<Character>: Una lista de caracteres que representa el contenido del alfabeto.
     * Retorna una lista vacía si el alfabeto no existe o está vacío.
     */
    public static ArrayList<Character> consultarContenidoAlfabeto(String nomA) {
        ArrayList<Character> contenidoA = cd.consultarContenidoAlfabeto(nomA);
        return contenidoA;
    }

    /**
     * Modifica el contenido de un alfabeto dado su nombre.
     * Llama a la función modificarContenidoAlfabeto de CtrlDominio.
     * @param nomA El nombre del alfabeto a modificar.
     * @param entrada La nueva lista de caracteres que representa el contenido actualizado del alfabeto.
     */
    public static void modificarContenidoAlfabeto(String nomA, ArrayList<Character> entrada) {
        cd.modificarContenidoAlfabeto(nomA, entrada);
    }

    /**
     * Llama a la función borrarAlfabeto de CtrlDominio.
     * Borra un alfabeto dado su nombre.
     * @param nomA El nombre del alfabeto a borrar.
     */
    public static void borrarAlfabeto(String nomA) {
        cd.borrarAlfabeto(nomA);
    }

    /** Llama a la función guardaCnjtAlfabetos de CtrlDominio para almacenar el conjunto de alfabetos.
     * @implSpec Si se produce un error durante el proceso de guardado:
     *  - Se muestra un mensaje de error en la consola.
     *  - Se imprime la traza de la pila en la consola.
     *  - Se finaliza la aplicación.
     */
    public static void guardaAlfabetos(){
        cd.guardaCnjtAlfabetos();
    }


    //FUNCIONES DE CTRlDOMINIO DE TEXTO
    /**
     * Llama a la función esTextoPalabras de CtrlDominio.
     * Verifica si un texto está compuesto exclusivamente por palabras.
     * @param nomTxt El nombre del texto a verificar.
     * @return true si el texto está compuesto solo por palabras, false en caso contrario.
     */
    public static boolean esTextoDePalabras(String nomTxt) {
        return cd.esTextoPalabras(nomTxt);
    }

    /**
     * Llama a la función agregarTextoPalabras de CtrlDominio.
     * Agrega un nuevo texto compuesto por palabras al sistema.
     * @param nomTxt El nombre del texto a agregar.
     * @param texto La lista de caracteres que forma el contenido del texto.
     * @return true si se agregó el texto correctamente, false en caso contrario.
     */
    public static boolean agregarTextoPalabras(String nomTxt, String texto) {
        return cd.agregarTextoPalabras(nomTxt, texto);
    }

    /**
     * Llama a la función agregarTextoPalabras de CtrlDominio.
     * Agrega un nuevo texto compuesto por palabras al sistema utilizando un archivo en la ruta especificada.
     * @param nomTxt El nombre del texto a agregar.
     * @param path La ruta del archivo que contiene el contenido del texto.
     * @return true si se agregó el texto correctamente, false en caso contrario.
     */
    public static boolean agregarTextoPalabrasPath(String nomTxt, String path) throws IOException {
        return cd.agregarTextoPalabrasPath(nomTxt, path);
    }

    /**
     * Llama a la función agregarTextoFrecuencias de CtrlDominio.
     * Agrega un nuevo texto compuesto por frecuencias de palabras al sistema.
     * @param nomTxt El nombre del texto a agregar.
     * @param frecuenciaPalabras El mapa con las palabras y sus frecuencias que forman el contenido del texto.
     * @return true si se agregó el texto correctamente, false en caso contrario.
     */
    public static boolean agregarTextoFrecuencias(String nomTxt, HashMap<String, Integer> frecuenciaPalabras) {
        return cd.agregarTextoFrecuencias(nomTxt, frecuenciaPalabras);
    }

    /** Llama a la función getNombresTextos de CtrlDominio.
     * Obtiene la lista de nombres de todos los textos almacenados en el sistema.
     * @return ArrayList<String>: Una lista de cadenas que representa los nombres de los textos.
     * Retorna una lista vacía si no hay textos almacenados.
     */
    public static ArrayList<String> getNombresTextos() {
        ArrayList<String> listaTextosNombres = cd.getNombresTextos();
        return listaTextosNombres;
    }

    /**
     * Llama a la función consultarContenidoTexto de CtrlDominio.
     * Consulta y devuelve el contenido de un texto dado su nombre.
     * @param nomTxt El nombre del texto a consultar.
     * @return String: El contenido del texto como una cadena.
     * Retorna una cadena vacía si el texto no existe o está vacío.
     */
    public static String consultarContenidoTexto(String nomTxt) {
        String contenidoTxt = cd.consultarContenidoTexto(nomTxt);
        return contenidoTxt;
    }

    /**
     * Llama a la función modificarContenidoTexto de CtrlDominio.
     * Modifica el contenido de un texto dado su nombre.
     * @param nomTxt El nombre del texto a modificar.
     * @param entrada La nueva cadena que representa el contenido actualizado del texto.
     */
    public static void modificarContenidoTexto(String nomTxt, String entrada) {
        cd.modificarContenidoTexto(nomTxt, entrada);
    }

    /**
     * Llama a la función modificarContenidoTexto de CtrlDominio.
     * Modifica el contenido de un texto dado su nombre utilizando frecuencias de palabras.
     * @param nomTxt El nombre del texto a modificar.
     * @param entrada El mapa con las palabras y sus frecuencias que forman el contenido actualizado del texto.
     */
    public static void modificarContenidoTextoFrecuencias(String nomTxt, HashMap<String, Integer> entrada) {
        cd.modificarContenidoTextoFrec(nomTxt, entrada);
    }

    /**
     * Llama a la función borrarTexto de CtrlDominio.
     * Borra un texto dado su nombre.
     * @param nomTxt El nombre del texto a borrar.
     */
    public static void borrarTexto(String nomTxt) {
        cd.borrarTexto(nomTxt);
    }


    /** Llama a la función guardaCnjtTextos de CtrlDominio para almacenar el conjunto de textos.
     * @implSpec Si se produce un error durante el proceso de guardado:
     *  - Se muestra un mensaje de error en la consola.
     *  - Se imprime la traza de la pila en la consola.
     *  - Se finaliza la aplicación.
     */
    public static void guardaTextos(){
        cd.guardaCnjtTextos();
    }


    //FUNCIONES DE CTRlDOMINIO DE ASOCIACION DE TEXTOS
    /**
     * Llama a la función agregarAsociacion de CtrlDominio.
     * Agrega una nueva asociación de textos al sistema.
     * @param nomAT El nombre de la asociación a agregar.
     * @param textosagregar La lista de nombres de textos a agregar a la asociación.
     * @return true si se agregó la asociación correctamente, false en caso contrario.
     */
    public static boolean agregarAsociacion(String nomAT, ArrayList<String> textosagregar) {
        return cd.agregarAsociacion(nomAT, textosagregar);
    }

    /**
     * Llama a la función agregarAsociacion de CtrlDominio
     * Agrega un nuevo texto a una asociación existente en el sistema.
     * @param nomAT El nombre de la asociación a la que se agregará el texto.
     * @param nomTxt El nombre del texto a agregar en la asociación.
     */
    public static void agregarTextoAsociacion (String nomAT, String nomTxt) {
        cd.agregarTextoAsociacion(nomAT, nomTxt);
    }

    /**
     * Llama a la función getNombresAsociaciones de CtrlDominio
     * Obtiene la lista de nombres de todas las asociaciones almacenadas en el sistema.
     * @return ArrayList<String>: Una lista de cadenas que representa los nombres de las asociaciones.
     * Retorna una lista vacía si no hay asociaciones almacenadas.
     */
    public static ArrayList<String> getNombresAsociaciones() {
        ArrayList<String> listaAsociacionesNombres = cd.getNombresAsociaciones();
        return listaAsociacionesNombres;
    }

    /**
     * Llama a la función consultarContenidoAsociacion de CtrlDominio.
     * Consulta y devuelve la lista de nombres de textos asociados a una asociación dada su nombre.
     * @param nomAT El nombre de la asociación a consultar.
     * @return ArrayList<String>:Una lista de cadenas que representa los nombres de los textos asociados a la asociación.
     * Retorna una lista vacía si la asociación no existe o no tiene textos asociados.
     */
    public static ArrayList<String> consultarCjtTextosAsociacion(String nomAT) {
            ArrayList<String > cjtTextosAsociacion = cd.consultarCjtTextosAsociacion(nomAT);
            return cjtTextosAsociacion;
    }

    /**
     * Llama a la función borrarTextoAsociacion de CtrlDominio.
     * Borra un texto de una asociación dados sus respectivos nombres.
     * @param nomAT El nombre de la asociación.
     * @param nomTxt El nombre del texto a borrar de la asociación.
     */
    public static void borrarTextoAsociacion (String nomAT, String nomTxt) {
        cd.borrarTextoAsociacion(nomAT, nomTxt);
    }

    /**
     * Llama a la función borrarAsociacionTextos de CtrlDominio.
     * Borra una asociación de textos dada su nombre.
     * @param nomAT El nombre de la asociación a borrar.
     */
    public static void borrarAsociacionTextos(String nomAT) {
        cd.borrarAsociacionTextos(nomAT);
    }

    /** Llama a la función guardaCnjtAsociaciones de CtrlDominio para almacenar el conjunto de asociaciones de textos.
     * @implSpec Si se produce un error durante el proceso de guardado:
     * - Se muestra un mensaje de error en la consola.
     * - Se imprime la traza de la pila en la consola.
     * - Se finaliza la aplicación.
     */
    public static void guardaAsociaciones(){
        cd.guardaCnjtAsociaciones();
    }


    //FUNCIONES DE CTRlDOMINIO DE TECLADO
    /**
     * Llama a la función agregarTeclado de CtrlDominio.
     * Agrega un nuevo teclado al sistema y lo vincula con un alfabeto y una asociación de textos.
     * @param nomT El nombre del teclado a agregar.
     * @param nomA El nombre del alfabeto a vincular con el teclado nomT.
     * @param nomAT El nombre de la asociación de textos a vincular con el teclado nomT.
     * @param dim Las dimensiones (filas x columnas) del teclado.
     * @param alg Indica el algoritmo específico para la disposición de teclas.
     * @return true si se agregó el teclado correctamente, false en caso contrario.
     */
    public static boolean agregarTeclado(String nomT, String nomA, String nomAT, PairInt dim, boolean alg){
        boolean acabado = cd.agregarTeclado(nomT,nomA,nomAT, dim, alg);
        return acabado;
    }

    /**
     * Llama a la función consultarContenidoTeclado de CtrlDominio.
     * Consulta y devuelve la matriz que representa el contenido de un teclado dado su nombre.
     * @param nomT El nombre del teclado a consultar.
     * @return char[][]: Una matriz de caracteres que representa el contenido del teclado nomT.
     * Retorna una matriz vacía si el teclado no existe.
     */
    public static char[][] consultarContenidoTeclado(String nomT){
        return cd.consultarContenidoTeclado(nomT);
    }

    /**
     * Llama a la función consultarContenidoTeclado de CtrlDominio.
     * Consulta y devuelve la puntuación asociada a un teclado dado su nombre.
     * @param nomT El nombre del teclado a consultar.
     * @return La puntuación del teclado nomT.
     */
    public static int consultarPuntuacionTeclado(String nomT){
        return cd.consultarPuntuacionTeclado(nomT);
    }

    /**
     * Llama a la función consultarAlfabetoAsociadoTeclado de CtrlDominio.
     * Consulta y devuelve el nombre del alfabeto vinculado a un teclado dado su nombre.
     * @param nomT El nombre del teclado a consultar.
     * @return String: El nombre del alfabeto vinculado al teclado nomT.
     */
    public static String consultarAlfabetoAsociadoTeclado(String nomT) {
        return cd.consultarAlfabetoAsociadoTeclado(nomT);
    }

    /**
     * Llama a la función consultarAsociacionAsociadoTeclado de CtrlDominio.
     * Consulta y devuelve el nombre de la asociación vinculada a un teclado dado su nombre.
     * @param nomT El nombre del teclado a consultar.
     * @return String: El nombre de la asociación vinculada al teclado nomT.
     */
    public static String consultarAsociacionAsociadoTeclado(String nomT) {
        return cd.consultarAsociacionAsociadoTeclado(nomT);
    }

    /**
     * Llama a la función consultarAsociacionAsociadoTeclado de CtrlDominio
     * Consulta y devuelve las dimensiones (filas x columnas) de un teclado dado su nombre.
     * @param nomT El nombre del teclado a consultar.
     * @return Un objeto `PairInt` que representa las dimensiones (filas x columnas) del teclado nomT.
     */
    public static PairInt consultarDimensionesTeclado(String nomT) {
        return cd.consultarDimensionesTeclado(nomT);
    }

    /**
     * Llama a la función getListaTeclados de CtrlDominio
     * Obtiene y devuelve una lista de nombres de teclados existentes.
     * @return ArrayList<String>: Una lista de cadenas que representa los nombres de los teclados existentes.
     * Retorna una lista vacía si no hay teclados registrados.
     */
    public static ArrayList<String> getListaTeclados(){
        ArrayList<String> listaTeclados = cd.getListaTeclados();
        return listaTeclados;
    }

    /**
     * Llama a la función borrarTeclado de CtrlDominio para eliminar un teclado dado su nombre.
     * @param nomT El nombre del teclado a borrar.
     */
    public static void borrarTeclado(String nomT) {
        cd.borrarTeclado(nomT);
    }

    /**
     * Llama a la función getPosiblesDimensiones de CtrlDominio.
     * Obtiene y devuelve una lista de posibles dimensiones (filas x columnas) para un teclado dado su alfabeto con nombre nomA.
     * @param nomA El nombre del alfabeto para el cual se desean obtener las dimensiones.
     * @return ArrayList<PairInt>: Una lista de objetos `PairInt` que representan las posibles dimensiones (filas x columnas) para el teclado que tiene el alfabeto nomA.
     * Retorna una lista vacía si no hay posibles dimensiones disponibles.
     */
    public static ArrayList<PairInt> getPosiblesDimensiones(String nomA) {
        return cd.getPosiblesDimensiones(nomA);
    }

    /**
     * VVerifica si el formato de las frecuencias es correcto para agregar a un contenido de texto.
     * @param contenidoTexto El contenido de texto al que se agregarán las frecuencias.
     * @param pathTexto La ruta del archivo de texto asociado al contenido.
     * @param frecuencias El mapa de frecuencias a agregar al contenido de texto.
     * @return True si el formato de las frecuencias es correcto, False de lo contrario.
     */
    public static boolean formatoCorrectoAgregarFrecuencias(String contenidoTexto, String pathTexto, HashMap<String, Integer> frecuencias) {
        return cd.formatoCorrectoAgregarFrecuencias(contenidoTexto, pathTexto, frecuencias);
    }

    /** Llama a la función guardaCnjtTeclados de CtrlDominio para almacenar el conjunto de teclados. */
    public static void guardaTeclados(){
        cd.guardaCnjtTeclados();
    }
}
