package drivers;

import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.functions.InOut;

/**
 * Driver para probar ...
 * @author X (X@estudiantat.upc.edu)
 */
public class DriverFP {

    private InOut inOut;
    public DriverFP() {
        inOut = new InOut();
    }

    public static void main(String[] args) {
        DriverProvaUri driver = new DriverProvaUri();
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
                case "PruebaQAP": {
                    driver.imprimirPruebaQAP();
                    break;
                }
                default: {
                    System.out.println("Método no reconocido");
                    break;
                }
            }
            /*cal canviar el driver perquè faci servir driverFP i no driverprovauri*/
            // driver.volverMenu();
            muestraMetodos();
            metodo = driver.inOut.leerString();
            // MIRAR DE FER SERVIR SCANNER I NEXT LINE
        }
        driver.inOut.cerrarScanner();
    }

    private static void muestraMetodos() {
        System.out.println("(1|AlfabetoPorTerminal) - Añadir Alfabeto");
        System.out.println("(2|AlfabetoPorArchivo) - Añadir Alfabeto");
        System.out.println("(3|ImprimirAlfabetos) - Imprimir Alfabetos");
        System.out.println("(4|TextoPorTerminal) - Añadir Texto");
        System.out.println("(5|TextoPorArchivo) - Añadir Texto");
        System.out.println("(6|ImprimirTextos) - Imprimir Textos");
        System.out.println("(7|CrearAsociacionTextos) - Crear Asociación Textos");
        System.out.println("(8|ImprimirAsociaciones) - Imprimir Asociaciones");
        System.out.println("(9|PruebaQAP) - Prueba QAP");
        System.out.println();
        System.out.println("(0|Salir) - Cerrar Driver");
    }

    private void volverMenu() {
        System.out.println("Pulsa ENTER para volver al menú principal");
        inOut.leerString();
    }

}
