package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.Algoritmo;
import main.domain.classes.AsociacionTextos;
import main.domain.classes.PairIntEnum;
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

    public boolean contenidoValido(String entrada) {
        if (entrada == null || entrada.isEmpty()) {
            return false; // Entrada vacía no es válida.
        }
        String[] partes = entrada.split(" ");
        for (String parte : partes) {
            // Verifica que cada parte sea un solo carácter.
            if (parte.length() != 1) {
                return false;
            }
        }
        return true; // La entrada es válida si todos los segmentos contienen solo un carácter.
    }

    // ---------- FUNCIONES ALFABETO ----------
    public void agregarAlfabetoPorTerminal() {
        System.out.println("Introduce el nombre del alfabeto:");
        String nombreA = inOut.leerString();
        System.out.println("Introduce los caracteres del alfabeto separados por espacio (ejemplo: a b c ...):");
        String entradaCaracteres = inOut.leerString();
        if (contenidoValido(entradaCaracteres)) {
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

    // ---------- FUNCIONES ASOCIACIONES TEXTOS ----------


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
                    //driver.agregarTextoPorTerminal();
                    break;
                }
                case "4":
                case "TextoPorArchivo": {
                    //driver.agregarTextoPorArchivo();
                    break;
                }
                case "5":
                case "CrearAsociacionTextos": {
                    // driver.crearAsociacionTextos();
                    break;
                }
                case "6":
                case "CrearTeclado": {
                    driver.agregarTeclado();
                    break;
                }
                case "7":
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
                }
                case "11":
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
        System.out.println("(1|AlfabetoPorTerminal) - Añadir Alfabeto");
        System.out.println("(2|AlfabetoPorArchivo) - Añadir Alfabeto");
        System.out.println("(3|TextoPorTerminal) - Añadir Texto");
        System.out.println("(4|TextoPorArchivo) - Añadir Texto");
        System.out.println("(5|CrearAsociacionTextos) - Crear Asociación Textos");
        System.out.println("(6|CrearTeclado) - Crear Teclado");
        System.out.println("(7|BorrarAlfabeto) - Borrar Alfabeto");
        System.out.println("(8|BorrarTexto) - Borrar Texto");
        System.out.println("(9|BorrarAsociacionTextos) - Borrar Asociacion Textos");
        System.out.println("(10|BorrarTeclado) - Borrar Teclado");
        System.out.println("(11|PruebaQAP) - Prueba QAP");
        System.out.println();
        System.out.println("(0|Salir) - Cerrar Driver");
    }
    private void volverMenu() {
        System.out.println("Pulsa ENTER para volver al menú principal");
        inOut.leerString();
    }

}
