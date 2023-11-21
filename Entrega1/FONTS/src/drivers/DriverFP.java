package drivers;

import main.domain.classes.*;
import main.domain.classes.functions.InOut;
import main.domain.classes.types.PairInt;
import main.domain.controllers.CtrlDominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Driver para probar las funcionalidades de la entrega
 * @author Alexia
 */
public class DriverFP {

    // ---------- PARÁMETROS ----------
    private final InOut inOut;
    private CtrlDominio ctrlDominio;

    /** Constructora del driver de la funcionalidad principal */
    public DriverFP() {
        inOut = new InOut();
        ctrlDominio = new CtrlDominio();
    }


    // ---------- FUNCIONES ALFABETO ----------
    /**
     * No devuelve nada.
     * Muestra por pantalla mensajes para introducir información por terminal del alfabeto que se quiere crear.
     * Llama a la función de ctrlDominio para agregar el alfabeto.
     * Muestra por pantalla mensajes de error o de éxito.
     */
    public void agregarAlfabetoPorTerminal() {
        System.out.println("Introduce el nombre del alfabeto:");
        String nombreA = inOut.leerString();
        System.out.println("Introduce los caracteres del alfabeto separados por espacio (ejemplo: a b c ...):");
        String entradaCaracteres = inOut.leerString();
        if (inOut.alfabetoValido(entradaCaracteres)) {
            ArrayList<Character> caracteres = inOut.leerCaracteresDeTerminal(entradaCaracteres);
            boolean agregado = ctrlDominio.agregarAlfabeto(nombreA, caracteres);
            if (!agregado) System.out.println("Ya existe el alfabeto " + nombreA + ". Introduce un nombre nuevo");
            else System.out.println("AGREGADO CON EXITO!");
        } else {
            System.out.println("El contenido introducido no es válido. Asegúrate de que sean caracteres separados por un espacio.");
        }
    }

    /**
     * No devuelve nada.
     * Muestra por pantalla mensajes para introducir información por archivo del alfabeto que se quiere crear.
     * Llama a la función de ctrlDominio para agregar el alfabeto.
     * Muestra por pantalla mensajes de error o de éxito.
     */
    public void agregarAlfabetoPorArchivo() {
        System.out.println("Introduce el nombre del archivo:");
        String nombreArchivo = inOut.leerString();
        try {
            ArrayList<Character> caracteres = inOut.leerCaracteresDeArchivo(nombreArchivo);
            System.out.println("Introduce el nombre del alfabeto:");
            String nombreA = inOut.leerString();
            boolean agregado = ctrlDominio.agregarAlfabeto(nombreA, caracteres);
            if (!agregado) System.out.println("Ya existe el alfabeto " + nombreA);
            else System.out.println("AGREGADO CON EXITO!");
        } catch (IllegalArgumentException e) {
            System.out.println("El contenido del archivo no es válido: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("El archivo no se encontró: " + nombreArchivo);
        }
    }

    /**
     * No devuelve nada.
     * Imprime por pantalla una lista de los alfabetos que hay en el sistema
     */
    public void imprimirNombresAlfabetos() {
        HashMap<String, Alfabeto> alfabetos = ctrlDominio.getListaAlfabetos();
        if (alfabetos.isEmpty()) {
            System.out.println("No hay alfabetos para mostrar. Debes agregar un alfabeto para hacer este paso.");
            return;
        }
        System.out.println("Alfabetos actuales:");
        for (HashMap.Entry<String, Alfabeto> entry : alfabetos.entrySet()) {
            String nombre = entry.getKey();
            System.out.println(nombre);
        }
    }

    /**
     * No devuelve nada.
     * Imprime por pantalla el contenido del teclado que se desea consultar, si existe
     */
    public void consultarContenidoAlfabeto(){
        imprimirNombresAlfabetos();
        System.out.println("Introduce el nombre del alfabeto que quieres consultar:");
        String nombreA = inOut.leerString();
        ArrayList<Character> Letras = ctrlDominio.consultarContenidoAlfabeto(nombreA);
        if(Letras == null) {
            System.out.println("Este nombre de alfabeto no existe, debes entrar un alfabeto de la lista");
        }
        else {
            System.out.println(nombreA);
            Letras.forEach(System.out::print);
            System.out.println();
        }
    }


    // ---------- FUNCIONES ASOCIACIONES TEXTOS ----------
    /**
     * No devuelve nada.
     * Muestra por pantalla mensajes para introducir información por terminal del texto que se quiere crear.
     * Pide al usuario si quiere introducir frases o palabras con frecuencias.
     * Llama a la función de ctrlDominio para agregar el texto.
     * Muestra por pantalla mensajes de error o de éxito.
     */
    public void agregarTextoPorTerminal() {
        System.out.println("Introduce el nombre del texto:");
        String nombreTxt = inOut.leerString();
        System.out.println("Si desea entrar un texto escriba 1. En caso de querer entrar palabras con frecuencias escriba otro numero.");
        Integer tipoTexto = inOut.leerEntero();
        if (tipoTexto == 1) {
            System.out.println("Introduce el texto:");
            String texto = inOut.leerString();
            if(texto == null)
                System.out.println("El contenido introducido no es válido. Asegúrate de que sean palabras separadas por un espacio.");
            else {
                boolean agregado = ctrlDominio.agregarTextoPalabras(nombreTxt,texto);
                if (!agregado) System.out.println("Ya existe el texto " + nombreTxt);
                else System.out.println("AGREGADO CON EXITO!");
            }
        } else {
            System.out.println("Introduce cuantas palabras quieres indicar:");
            int n = inOut.leerEntero();
            System.out.println("Introduce palabras y sus frecuencias. El formato debe ser palabra, espacio, numero de frecuencia, salto de linea,  siguiente palabra.");
            System.out.println("Ejemplo:");
            System.out.println("hola 5");
            System.out.println("mesa 3");

            HashMap<String,Integer> frecPalabras = inOut.leerTextoFrecuenciasPalabras(n);   //esto pasa texto a hasmap frecpalabras
            if (frecPalabras == null) {
                System.out.println("El contenido introducido no es válido. Asegúrate de que sean palabras separadas por un espacio.");
            }
            else {
                boolean agregado = ctrlDominio.agregarTextoFrecuencias(nombreTxt, frecPalabras);
                if (!agregado) System.out.println("Ya existe el texto " + nombreTxt);
                else System.out.println("AGREGADO CON EXITO!");
            }
        }
    }

    /**
     * No devuelve nada.
     * Muestra por pantalla mensajes para introducir información por archivo del texto que se quiere crear.
     * Pide al usuario si quiere introducir frases o palabras con frecuencias.
     * Llama a la función de ctrlDominio para agregar el texto.
     * Muestra por pantalla mensajes de error o de éxito.
     */
    public void agregarTextoPorArchivo() {
        System.out.println("Introduce el nombre del archivo:");
        String nombreArchivo = inOut.leerString();
        try {
            String texto = inOut.leerPalabrasDeArchivo(nombreArchivo);
            System.out.println("Introduce el nombre del texto:");
            String nombreTxt = inOut.leerString();
            boolean agregado = ctrlDominio.agregarTextoPalabras(nombreTxt,texto);
            if (!agregado) System.out.println("Ya existe el texto " + nombreTxt);
            else System.out.println("AGREGADO CON EXITO!");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + nombreArchivo);
        } catch (IllegalArgumentException e) {
            System.out.println("El contenido del archivo no es válido: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * No devuelve nada.
     * Imprime por pantalla una lista de los textos que hay en el sistema
     */
    public void imprimirNombresTextos() {

        HashMap<String, Texto> listaTextos = ctrlDominio.getListaTextos();
        if (listaTextos.isEmpty()) {
            System.out.println("No hay textos para mostrar. Debes agregar un texto para hacer este paso");
            return;
        }
        System.out.println("Textos actuales:");
        for (HashMap.Entry<String, Texto> entry : listaTextos.entrySet()) {
            String nombre = entry.getKey();
            System.out.println(nombre);
        }
    }

    /**
     * No devuelve nada.
     * Imprime por pantalla una lista de las asociaciones de textos que hay en el sistema
     */
    public void imprimirNombresAsociaciones() {
        HashMap<String, AsociacionTextos> asociaciones = ctrlDominio.getListaAsociaciones();
        if (asociaciones.isEmpty()) {
            System.out.println("No hay asociaciones para mostrar. Debes crear una asociacion para hacer este paso");
            return;
        }
        for (HashMap.Entry<String, AsociacionTextos> entry : asociaciones.entrySet()) {
            String nombre = entry.getKey();
            System.out.println(nombre);
        }
    }

    /**
     * No devuelve nada.
     * Imprime por pantalla el contenido del texto que se desea consultar, si existe
     */
    public void consultarContenidoTexto(){
        imprimirNombresTextos();
        System.out.println("Introduce el nombre del texto que quieres consultar:");
        String nombreT = inOut.leerString(); //suponemos que lo escribe bien porque lo copia de la lista
        String contenido = ctrlDominio.consultarContenidoTexto(nombreT);
        if(contenido == null) {
            System.out.println("Este nombre de texto no existe, debes entrar un texto de la lista");
        }
        else {
            System.out.println(nombreT);
            String Palabras = ctrlDominio.consultarContenidoTexto(nombreT);
            System.out.println(Palabras);
        }
    }

    /**
     * No devuelve nada.
     * Se crea una asociación nueva con textos existentes que haya en el sistema
     */
    public void crearAsociacion(){
        imprimirNombresTextos();
        HashMap<String, Texto> textos = ctrlDominio.getListaTextos();
        //HashMap<String, AsociacionTextos> asociaciones1 = ctrlDominio.getListaAsociaciones();
        if (!textos.isEmpty()) {
            System.out.println("Introduce el numero de textos que quieres añadir a la nueva ascociacion:");
            Integer n = inOut.leerEntero();
            if(n <= textos.size()) {
                System.out.println("Introduce el nombre de la asociacion:");
                String nombreAT = inOut.leerString();
                ArrayList<String> textosagregar = new ArrayList<>();
                boolean crear = true;
                int i = 0;
                while (i < n && crear) {
                    System.out.println("Introduce el nombre del texto que quieres añadir a la nueva ascociacion:");
                    String nombreT = inOut.leerString();
                    if (ctrlDominio.existetexto(nombreT)) textosagregar.add(nombreT);
                    else {
                        System.out.println("No existe un texto con ese nombre. Vuelve a crear la asociacion.");
                        crear = false;
                    }
                    ++i;
                }
                if(crear){
                    boolean agregada = ctrlDominio.agregarAsociacion(nombreAT, textosagregar);
                    if (!agregada) System.out.println("Ya existe el texto " + nombreAT);
                    else System.out.println("AGREGADO CON EXITO!");
                }
            }
            else System.out.println("No hay tantos textos creados. Debes crear más textos.");
        }
    }


    // ---------- FUNCIONES TECLADO ----------
    /**
     * No devuelve nada.
     * Muestra por pantalla mensajes para introducir información por terminal del teclado que se quiere crear.
     * Llama a la función de ctrlDominio para agregar el teclado.
     * Muestra por pantalla mensajes de error o de éxito.
     */
    public void agregarTeclado() {
        System.out.println("Introduce el nombre del teclado:");
        String nombreT = inOut.leerString();
        try {
            //Seleccionar alfabeto
            imprimirNombresAlfabetos();
            HashMap<String, Alfabeto> alfabetos = ctrlDominio.getListaAlfabetos();
            HashMap<String, AsociacionTextos> asociaciones = ctrlDominio.getListaAsociaciones();
            if (!alfabetos.isEmpty()) {
                System.out.println("Introduce el nombre de un alfabeto de la lista:");
                String nombreA = inOut.leerString();
                if(ctrlDominio.existealfabeto(nombreA)){
                    //Seleccionar asociacion de textos
                    System.out.println("Asociaciones de textos actuales:");
                    imprimirNombresAsociaciones();
                    if(!asociaciones.isEmpty()) {
                        System.out.println("Introduce el nombre de una asociacion de textos de la lista:");
                        String nombreAT = inOut.leerString();
                        if (ctrlDominio.existeasociacion(nombreAT)) {
                            //Siguiente entrega: funcion para mostrar algoritmos
                            //System.out.println("Escoge el algoritmo:");
                            //Integer numAlg = inOut.leerEntero();
                            //Algoritmo algoritmo;
                            //  if (numAlg==1) algoritmo = algoritmo.QAP;
                            //  else algoritmo = algoritmo.Alg2;

                            //Seleccionar dimensiones del teclado
                            /*System.out.println("Posibles Dimensiones a escoger para el alfabeto " + nombreA + ":");
                            HashMap<Integer, PairInt> combinacionesDimensiones = imprimirPosiblesDimensiones(nombreA);
                            DriverFP driver = new DriverFP();
                            System.out.println("Selecciona las dimensiones del teclado:");
                            Integer numDim = driver.inOut.leerEntero();
                            PairInt dimensiones = escogerDimensiones(combinacionesDimensiones, numDim);
                            System.out.println("El teclado tendrá " + dimensiones.getPrimero() + " filas y " + dimensiones.getSegundo() + " columnas.");*/


                            //boolean agregado = ctrlDominio.agregarTeclado(nombreT, nombreA, nombreAT, Algoritmo.QAP, PairIntEnum.EMPTY_PAIR);
                            int agregado = ctrlDominio.agregarTeclado(nombreT, nombreA, nombreAT);
                            if (agregado == -1) System.out.println("Ya existe el teclado " + nombreT);
                            else if(agregado == -2) System.out.println("El alfabeto y la asociación de textos no son compatibles");
                            else System.out.println("AGREGADO CON EXITO!");
                        }
                        else System.out.println("No existe ninguna asociacion con ese nombre. Hay que seleccionar una asociacion de la lista");
                    }
                }
                else System.out.println("No existe ningun alfabeto con ese nombre. Hay que seleccionar un alfabeto de la lista");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Existe un teclado con el mismo nombre " + nombreT); //?? que tipo de excepcion tendria que pasar?
        }
    }

    /**
     * No devuelve nada.
     * Imprime por pantalla una lista de los teclados que hay en el sistema
     */
    public void imprimirNombresTeclados() {
        ArrayList<String> teclados = ctrlDominio.getListaTeclados();
        if (teclados.isEmpty()) {
            System.out.println("No hay teclados para mostrar.");
            return;
        }
        for (String nombre : teclados) {
            System.out.println(nombre);
        }
    }

    /* 
    private PairInt escogerDimensiones(HashMap<Integer, PairInt> combinacionesDimensiones, Integer numDim) {
        Integer filas = combinacionesDimensiones.get(numDim).getPrimero();
        Integer columans = combinacionesDimensiones.get(numDim).getSegundo();
        return new PairInt(filas, columans);
    }*/

    /*Entrega 2*/
    private HashMap<Integer, PairInt> imprimirPosiblesDimensiones(String nomA) {
        int numCaracteres = ctrlDominio.numeroCaracteres(nomA);       // func saber num caracteres del alfabeto

        HashMap<Integer, PairInt> combinacionesDimensiones = new HashMap<>();
        Integer x = 1;
        for (int filas = 1; filas <= numCaracteres; filas++) {
            if (numCaracteres%filas == 0) {
                int columnas = numCaracteres/filas;
                System.out.println(x + ": " + filas + "filas, " + columnas + "columnas");
                combinacionesDimensiones.put(x, new PairInt(filas,columnas));
                x++;
            }
        }
        return combinacionesDimensiones;
    }


    // ---------- FUNCIONES MAIN ----------
    public static void main(String[] args) {
        DriverFP driver = new DriverFP();
        muestraMetodos();
        // System.out.println("Selecciona el método para agregar el alfabeto (1 - Terminal, 2 - Archivo):");
        String metodo = driver.inOut.leerString();
        while (!metodo.equals("0") && !metodo.equals("Salir")) {
            switch (metodo) {
                case "1":
                case "AlfabetoPorTerminal": {
                    driver.agregarAlfabetoPorTerminal();
                    break;
                }
                case "2":
                case "AlfabetoPorArchivo": {
                    driver.agregarAlfabetoPorArchivo();
                    break;
                }
                case "3":
                case "TextoPorTerminal": {
                    driver.agregarTextoPorTerminal();
                    break;
                }
                case "4":
                case "TextoPorArchivo": {
                    driver.agregarTextoPorArchivo();
                    break;
                }
                case "5":
                case "CrearAsociacionTextos": {
                    driver.crearAsociacion();
                    break;
                }
                case "6":
                case "CrearTeclado": {
                    driver.agregarTeclado();
                    break;
                }
                case "7":
                case "ConsultarlistaAlfabetos": {
                    driver.imprimirNombresAlfabetos();
                    break;
                }
                case "8":
                case "ConsultarlistaAsociaciones": {
                    driver.imprimirNombresAsociaciones();
                    break;
                }
                case "9":
                case "ConsultarlistaTextos": {
                    driver.imprimirNombresTextos();
                    break;
                }
                case "10":
                case "ConsultarlistaTeclados": {
                    driver.imprimirNombresTeclados();
                    break;
                }
                case "11":
                case "ConsultarAlfabeto": {
                    driver.consultarContenidoAlfabeto();
                    break;
                }
                case "12":
                case "ConsultarTexto": {
                    driver.consultarContenidoTexto();
                    break;
                }
                /*case "7":
                case "BorrarAlfabeto": {
                    // driver.borrarAlfabeto();
                    break;
                }
                case "8":
                case "BorrarTexto": {
                    // driver.borrarTexto();
                    break;
                }
                case "9":
                case "BorrarAsociacionTexto": {
                    //driver.borrarAsociacionTexto();
                    break;
                }
                case "10":
                case "BorrarTeclado": {
                    //driver.borrarTeclado();
                    break;
                }*/
                case "13":
                case "PruebaQAP": {
                    // driver.agregarTeclado();
                    break;
                }
                default: {
                    System.out.println("Método no reconocido");
                    break;
                }
            }
            driver.volverMenu();
            muestraMetodos();
            metodo = driver.inOut.leerString();
            // MIRAR DE FER SERVIR SCANNER I NEXT LINE
        }
        driver.inOut.cerrarScanner();
    }

    /**
     * No devueleve nada.
     * Imprime por pantalla todos los métodos que el usuario es capaz de realizar
     */
    private static void muestraMetodos() {
        //Agregar
        System.out.println("(1|AlfabetoPorTerminal) - Añadir Alfabeto");
        System.out.println("(2|AlfabetoPorArchivo) - Añadir Alfabeto");
        System.out.println("(3|TextoPorTerminal) - Añadir Texto");
        System.out.println("(4|TextoPorArchivo) - Añadir Texto");
        //Crear
        System.out.println("(5|CrearAsociacionTextos) - Crear Asociación Textos");
        System.out.println("(6|CrearTeclado) - Crear Teclado");
        //Consultar
        System.out.println("(7|ConsultarlistaAlfabetos) - Consultar Lista Alfabetos");
        System.out.println("(8|ConsultarlistaAsociaciones) - Consultar Lista Asociaciones");
        System.out.println("(9|ConsultarlistaTextos) - Consultar Lista Textos");
        System.out.println("(10|ConsultarlistaTeclados) - Consultar Lista Teclados");
        System.out.println("(11|ConsultarAlfabeto) - Consultar Alfabeto");
        System.out.println("(12|ConsultarTexto) - Consultar Texto");
        //Borrar
        //System.out.println("(11|BorrarAlfabeto) - Borrar Alfabeto");
        //System.out.println("(12|BorrarTexto) - Borrar Texto");
        //System.out.println("(13|BorrarAsociacionTextos) - Borrar Asociacion Textos");
        //System.out.println("(14|BorrarTeclado) - Borrar Teclado");
        //QAP
        System.out.println();
        System.out.println("(0|Salir) - Cerrar Driver");
    }

    /**
     * No devuelve nada.
     * Imprime la acción que el usuario debe realizar para volver al menú principal
     */
    private void volverMenu() {
        System.out.println("Pulsa ENTER para volver al menú principal");
        inOut.leerString();
    }
}
