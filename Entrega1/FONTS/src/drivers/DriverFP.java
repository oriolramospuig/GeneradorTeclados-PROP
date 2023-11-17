package drivers;

import main.domain.classes.Algoritmo;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.functions.InOut;
import main.domain.classes.functions.QAP;
import main.domain.controllers.CtrlQAP;

import java.util.HashMap;

/**
 * Driver para probar ...
 * @author X (X@estudiantat.upc.edu)
 */
public class DriverFP {

    private final InOut inOut;

    private CtrlQAP ctrqap;
    public DriverFP() {
        inOut = new InOut();
        ctrqap = new CtrlQAP();
    }


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
            imprimirNombresAsociacionesTextos();
            System.out.println("Introduce el nombre de la asociacion de textos:");
            String nombreAT = inOut.leerString();

            //funcion para mostrar algoritmos
            System.out.println("Escoge el algoritmo:");
            Integer numAlg = inOut.leerEntero();
            Algoritmo algoritmo;
            //  if (numAlg==1) algoritmo = QAP; //?
            //  else algoritmo = Alg2;  ///?

            //funcion para mostrar dimensiones - tiene que salir nombre que hay en enum , fila, columna
            System.out.println("Escoge las dimensiones del teclado:");
            String dimensiones = inOut.leerString();
            //passar de string a pairIntEnum

            //   ctrlDominio.agregarTeclado(nombreT, nombreA, nombreAT, QAP, dimensiones);
            boolean agregado = ctrqap.AgregarTeclado(nombreA,nombreAT,nombreT);
            if (!agregado) System.out.println("Ya existe el teclado " + nombreT);
            else System.out.println("AGREGADO CON EXITO!");
            System.out.println("Teclado agregado con éxito: " + nombreT);
        } catch (IllegalArgumentException e) {
            System.out.println("Existe un teclado con el mismo nombre " + nombreT); //?? que tipo de excepcion tendria que pasar?
        }
    }

    public static void main(String[] args) {
        DriverDominio driver = new DriverDominio();
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
                case "ImprimirAlfabetos": {
                    driver.imprimirAlfabetos();
                    break;
                }
                case "4":
                case "TextoPorTerminal": {
                    //driver.agregarTextoPorTerminal();
                    break;
                }
                case "5":
                case "TextoPorArchivo": {
                    // driver.agregarTextoPorArchivo();
                    break;
                }
                case "6":
                case "ImprimirTextos": {
                    // driver.imprimirTextos();
                    break;
                }
                case "7":
                case "CrearAsociacionTextos": {
                    // driver.crearAsociacionTextos();
                    break;
                }
                case "8":
                case "ImprimirAsociaciones": {
                    // driver.imprimirAsociaciones();
                    break;
                }
                case "9":
                case "CrearTeclado": {
                    driver.agregarTeclado();
                    break;
                }
                case "10":
                case "PruebaQAP": {
                    driver.imprimirPruebaQAP();
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
        //System.out.println("(3|ImprimirAlfabetos) - Imprimir Alfabetos");
        System.out.println("(4|TextoPorTerminal) - Añadir Texto");
        System.out.println("(5|TextoPorArchivo) - Añadir Texto");
        //System.out.println("(6|ImprimirTextos) - Imprimir Textos");
        System.out.println("(7|CrearAsociacionTextos) - Crear Asociación Textos");
        //System.out.println("(8|ImprimirAsociaciones) - Imprimir Asociaciones");
        System.out.println("(9|CrearTeclado) - Crear Teclado");
        System.out.println("(10|PruebaQAP) - Prueba QAP");
        System.out.println();
        System.out.println("(0|Salir) - Cerrar Driver");
    }

    private void volverMenu() {
        System.out.println("Pulsa ENTER para volver al menú principal");
        inOut.leerString();
    }

}
