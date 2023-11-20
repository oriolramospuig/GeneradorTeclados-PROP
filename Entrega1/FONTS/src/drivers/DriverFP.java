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
 * Driver para probar ...
 * @author X (X@estudiantat.upc.edu)
 */
public class DriverFP {
    private final InOut inOut;

    private CtrlDominio ctrlDominio;

    public DriverFP() {
        inOut = new InOut();
        ctrlDominio = new CtrlDominio();
    }


    // ---------- FUNCIONES ALFABETO ----------
    public void agregarAlfabetoPorTerminal() {
        System.out.println("Introduce el nombre del alfabeto:");
        String nombreA = inOut.leerString();
        System.out.println("Introduce los caracteres del alfabeto separados por espacio (ejemplo: a b c ...):");
        String entradaCaracteres = inOut.leerString();
        if (inOut.contenidoValido(entradaCaracteres)) {
            ArrayList<Character> caracteres = inOut.leerCaracteresDeTerminal(entradaCaracteres);
            boolean agregado = ctrlDominio.agregarAlfabeto(nombreA, caracteres);
            if (!agregado) System.out.println("Ya existe el alfabeto " + nombreA);
            else System.out.println("AGREGADO CON EXITO!");
        } else {
            System.out.println("El contenido introducido no es válido. Asegúrate de que sean caracteres separados por un espacio.");
        }
    }

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

    public void imprimirNombresAlfabetos() {
        HashMap<String, Alfabeto> alfabetos = ctrlDominio.getListaAlfabetos();
        if (alfabetos.isEmpty()) {
            System.out.println("No hay alfabetos para mostrar.");
            return;
        }
        for (HashMap.Entry<String, Alfabeto> entry : alfabetos.entrySet()) {
            String nombre = entry.getKey();
            System.out.println(nombre);
        }
    }

    public void consultarContenidoAlfabeto(){
        System.out.println("Alfabetos actuales:");
        imprimirNombresAlfabetos();
        System.out.println("Introduce el nombre del alfabeto que quieres consultar:");
        String nombreA = inOut.leerString(); //suponemos que lo escribe bien porque lo copia de la lista
        System.out.println(nombreA);
        ArrayList<Character> Letras = ctrlDominio.consultarContenidoAlfabeto(nombreA);
        for (Character letra : Letras) {
            System.out.println(letra);
        }
    }


    // ---------- FUNCIONES ASOCIACIONES TEXTOS ----------
    public void agregarTextoPorTerminal() {
        System.out.println("Introduce el nombre del texto:");
        String nombreTxt = inOut.leerString();
        System.out.println("Si desea entrar un texto escriba 1. En caso de querer entrar palabras con frecuencias escriba otro numero.");
        Integer tipoTexto = inOut.leerEntero();
        if (tipoTexto == 1) {
            System.out.println("Introduce las palabras del texto separadas por espacio (ejemplo: hola que tal...):");
            String texto = inOut.leerString();
            if (inOut.contenidoValido(texto)) {
                HashMap<String, Integer> frecletras = tratarEntradaPalabras(texto);     //falta implementar
                boolean agregado = ctrlDominio.agregarTextoPalabras(nombreTxt, texto, frecletras);      //falta implementar
                if (!agregado) System.out.println("Ya existe el texto " + nombreTxt);
                else System.out.println("AGREGADO CON EXITO!");
            }
            else
                System.out.println("El contenido introducido no es válido. Asegúrate de que sean palabras separadas por un espacio.");
        } else {
            System.out.println("Introduce palabras y sus frecuencias. El formato debe ser palabra, espacio, numero de frecuencia, espacio,  siguiente palabra. (ejemplo: hola 5 mesa 3):");
            String texto = inOut.leerString();
            if (inOut.contenidoValido(texto)) {
                HashMap<String,Integer> frecPalabras = convertirEntrada(texto);   //esto pasa texto a hasmap frecpalabras
                HashMap<String, Integer> frecLetras = tratarEntradaFrecuencias(frecPalabras);    // pasa frecpalabras a frecletras
                boolean agregado = ctrlDominio.agregarTextoFrecuencias(nombreTxt, frecPalabras, frecLetras);
                if (!agregado) System.out.println("Ya existe el texto " + nombreTxt);
                else System.out.println("AGREGADO CON EXITO!");
            }
            else
                System.out.println("El contenido introducido no es válido. Asegúrate de que sean palabras separadas por un espacio.");
        }
    }

    
    public HashMap<String, Integer> tratarEntradaPalabras(String texto) {
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        char[] textoChars = texto.toCharArray();
        for(int i = 1; i < textoChars.length; ++i){
            String pairLetras = "" + textoChars[i-1] + textoChars[i];
            int frec = 1;
            if (textoChars[i-1] > textoChars[i]) pairLetras = "" + textoChars[i] + textoChars[i-1];
            if(frecuenciaLetras.containsKey(pairLetras)){
                frec = frecuenciaLetras.get(pairLetras)+1;
            }
            frecuenciaLetras.put(pairLetras,frec);
        }
        return frecuenciaLetras;
    }

    public HashMap<String,Integer> convertirEntrada(String texto) {
        HashMap<String, Integer> frecuenciaPalabras = new HashMap<>();

        //esto pasa string texto a hasmap frecpalabras

        return frecuenciaPalabras;
    }

    public HashMap<String, Integer> tratarEntradaFrecuencias(HashMap<String,Integer> frecPalabras) {
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();

        //pasa frecpalabras a frecletras

        return frecuenciaLetras;
    }
    
    public void agregarTextoPorArchivo() {              //MISMA ESTRUCTURA QUE POR ARCHIVO
        System.out.println("Introduce el nombre del archivo:");
        String nombreArchivo = inOut.leerString();
        try {
            HashMap<String, Integer> frecletras = inOut.leerPalabrasDeArchivo(nombreArchivo);
            System.out.println("Introduce el nombre del texto:");
            String nombreTxt = inOut.leerString();
            boolean agregado = ctrlDominio.agregarTexto(nombreTxt, frecletras);
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

    public void imprimirNombresTextos() {
        HashMap<String, Texto> listaTextos = ctrlDominio.getListaTextos();
        if (listaTextos.isEmpty()) {
            System.out.println("No hay textos para mostrar.");
            return;
        }
        for (HashMap.Entry<String, Texto> entry : listaTextos.entrySet()) {
            String nombre = entry.getKey();
            System.out.println(nombre);
        }
    }

    public void imprimirNombresAsociaciones() {
        HashMap<String, AsociacionTextos> asociaciones = ctrlDominio.getListaAsociaciones();
        if (asociaciones.isEmpty()) {
            System.out.println("No hay asociaciones para mostrar.");
            return;
        }
        for (HashMap.Entry<String, AsociacionTextos> entry : asociaciones.entrySet()) {
            String nombre = entry.getKey();
            System.out.println(nombre);
        }
    }

    public void consultarContenidoTexto(){
        System.out.println("Textos actuales:");
        imprimirNombresTextos();
        System.out.println("Introduce el nombre del texto que quieres consultar:");
        String nombreT = inOut.leerString(); //suponemos que lo escribe bien porque lo copia de la lista
        System.out.println(nombreT);
        String Palabras = ctrlDominio.consultarContenidoTexto(nombreT);
        System.out.println(Palabras);
    }

    public void crearAsociacion(){
        System.out.println("Textos actuales:");
        imprimirNombresTextos();
        System.out.println("Introduce el numero de textos que quieres añadir a la nueva ascociacion:");
        Integer n = inOut.leerEntero();
        System.out.println("Introduce el nombre de la asociacion:");
        String nombreAT = inOut.leerString();
        ArrayList<String> textosagregar = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            System.out.println("Introduce el nombre del texto que quieres añadir a la nueva ascociacion:");
            String nombreT = inOut.leerString();
            textosagregar.add(nombreT);
        }
        boolean agregada = ctrlDominio.agregarAsociacion(nombreAT,textosagregar);
        if (!agregada) System.out.println("Ya existe el texto " + nombreAT);
        else System.out.println("AGREGADO CON EXITO!");
    }


    // ---------- FUNCIONES TECLADO ----------
    public void agregarTeclado() {
        System.out.println("Introduce el nombre del teclado:");
        String nombreT = inOut.leerString();
        try {
            //Seleccionar alfabeto
            System.out.println("Alfabetos actuales:");
            imprimirNombresAlfabetos();
            System.out.println("Introduce el nombre del alfabeto:");
            String nombreA = inOut.leerString();

            //Seleccionar asociacion de textos
            System.out.println("Asociaciones de textos actuales:");
            imprimirNombresAsociaciones();
            System.out.println("Introduce el nombre de la asociacion de textos:");
            String nombreAT = inOut.leerString();

            //Siguiente entrega: funcion para mostrar algoritmos
            //System.out.println("Escoge el algoritmo:");
            //Integer numAlg = inOut.leerEntero();
            //Algoritmo algoritmo;
            //  if (numAlg==1) algoritmo = algoritmo.QAP;
            //  else algoritmo = algoritmo.Alg2;

            //Seleccionar dimensiones del teclado
            System.out.println("Posibles Dimensiones a escoger para el alfabeto " + nombreA + ":");
            HashMap<Integer, PairInt> combinacionesDimensiones = imprimirPosiblesDimensiones(nombreA);
            DriverFP driver = new DriverFP();
            System.out.println("Selecciona las dimensiones del teclado:");
            Integer numDim = driver.inOut.leerEntero();
            PairInt dimensiones = escogerDimensiones(combinacionesDimensiones, numDim);
            System.out.println("El teclado tendrá " + dimensiones.getPrimero() + " filas y " + dimensiones.getSegundo() + " columnas.");


            //boolean agregado = ctrlDominio.agregarTeclado(nombreT, nombreA, nombreAT, Algoritmo.QAP, PairIntEnum.EMPTY_PAIR);
            boolean agregado = ctrlDominio.agregarTeclado(nombreT, nombreA, nombreAT, Algoritmo.QAP, dimensiones);
            if (!agregado) System.out.println("Ya existe el teclado " + nombreT);
            else System.out.println("AGREGADO CON EXITO!");
            System.out.println("Teclado agregado con éxito: " + nombreT);
        } catch (IllegalArgumentException e) {
            System.out.println("Existe un teclado con el mismo nombre " + nombreT); //?? que tipo de excepcion tendria que pasar?
        }
    }

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

    private PairInt escogerDimensiones(HashMap<Integer, PairInt> combinacionesDimensiones, Integer numDim) {
        Integer filas = combinacionesDimensiones.get(numDim).getPrimero();
        Integer columans = combinacionesDimensiones.get(numDim).getSegundo();
        return new PairInt(filas, columans);
    }

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
                    //   driver.imprimirPruebaQAP();
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
        System.out.println("(13|PruebaQAP) - Prueba QAP");
        System.out.println();
        System.out.println("(0|Salir) - Cerrar Driver");
    }

    private void volverMenu() {
        System.out.println("Pulsa ENTER para volver al menú principal");
        inOut.leerString();
    }
}
