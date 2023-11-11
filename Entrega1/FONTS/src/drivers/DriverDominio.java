package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.functions.InOut;
import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairFrequency;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
/**
 * Este driver sirve para ...
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class DriverDominio {
    private InOut inOut;
    private ConjuntoAlfabetos conjuntoAlfabetos;

    public DriverDominio() {
        inOut = new InOut();
        conjuntoAlfabetos = new ConjuntoAlfabetos();
    }

    public void agregarAlfabetoPorTerminal() {
        System.out.println("Introduce el nombre del alfabeto:");
        String nombre = inOut.leerString();
        System.out.println("Introduce los caracteres del alfabeto separados por espacio (ejemplo: a b c ...):");
        String entradaCaracteres = inOut.leerString();

        // Verifica que la entrada de caracteres es válida.
        if (inOut.contenidoValido(entradaCaracteres)) {
            // Convierte la entrada en un ArrayList de caracteres.
            ArrayList<Character> caracteres = new ArrayList<>();
            for (char c : entradaCaracteres.toCharArray()) {
                // Solo agrega caracteres no espacios.
                if(c != ' ') {
                    caracteres.add(c);
                }
            }
            // Agrega el alfabeto al conjunto si es válido.
            Alfabeto alfabeto = new Alfabeto(nombre, caracteres);
            conjuntoAlfabetos.agregarAlfabeto(nombre, alfabeto);
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
            String nombre = inOut.leerString();
            Alfabeto alfabeto = new Alfabeto(nombre, caracteres);
            conjuntoAlfabetos.agregarAlfabeto(nombre, alfabeto);
            System.out.println("Alfabeto agregado con éxito desde el archivo: " + nombreArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + nombreArchivo);
        } catch (IllegalArgumentException e) {
            System.out.println("El contenido del archivo no es válido: " + e.getMessage());
        }
    }


    public void imprimirAlfabetos() {
        // Obtén todos los alfabetos en el conjunto
        HashMap<String, Alfabeto> alfabetos = conjuntoAlfabetos.getAlfabetos();
        //ArrayList<String> alfabetos = conjuntoAlfabetos.getNombresAlfabetos();

        // Verifica si hay alfabetos en el conjunto
        if (alfabetos.isEmpty()) {
            System.out.println("No hay alfabetos para mostrar.");
            return;
        }

        // Itera sobre el conjunto de alfabetos e imprime la información de cada uno
        for (HashMap.Entry<String, Alfabeto> entry : alfabetos.entrySet()) {
            // Obtiene el nombre y el alfabeto del conjunto
            String nombre = entry.getKey();
            Alfabeto alfabeto = entry.getValue();
            ArrayList<Character> contenido = alfabeto.getLetras();

            // Imprime el nombre y el contenido del alfabeto
            System.out.println("Nombre del alfabeto: " + nombre);
            System.out.print("Contenido del alfabeto: ");

            // Imprime el contenido del alfabeto, si no es nulo y tiene caracteres
            if (contenido != null && !contenido.isEmpty()) {
                for (char c : contenido) {
                    System.out.print(c + " ");
                }
            } else {
                System.out.print("El alfabeto está vacío o no se ha inicializado.");
            }
            System.out.println();
        }
    }

    void imprimirPruebaQAP() {
        System.out.println("Se generará un teclado aleatorio de 3*4 con las letras de la A a la L: ");
        System.out.println();
        QAP qap = new QAP(3,4);
        List<Character> teclas = new ArrayList<>();
        for(char c = 'a'; c <= 'l'; c++) { // Asumiendo un alfabeto de 'a' a 'l'
            teclas.add(c);
        }
        /**
        QAP qap = new QAP(3,4);
         List<Character> teclas = new ArrayList<>();
         for(char c = 'a'; c <= 'i'; c++) { // Asumiendo un alfabeto de 'a' a 'l'
         teclas.add(c);
         }
         */

        List<PairFrequency> frecuenciasPares = new ArrayList<>();
        /**frecuenciasPares.add(new PairFrequency("ab", 40)); // Frecuencia del par AB
        frecuenciasPares.add(new PairFrequency("bc", 35)); // Frecuencia del par BC
        frecuenciasPares.add(new PairFrequency("cd", 30));
        frecuenciasPares.add(new PairFrequency("de", 25));
        frecuenciasPares.add(new PairFrequency("ef", 20));
        frecuenciasPares.add(new PairFrequency("fg", 15));
        frecuenciasPares.add(new PairFrequency("gh", 10));
        frecuenciasPares.add(new PairFrequency("hi", 5));
         */
        frecuenciasPares.add(new PairFrequency("ab", 100)); // Frecuencia del par AB
        frecuenciasPares.add(new PairFrequency("bc", 80)); // Frecuencia del par BC
        frecuenciasPares.add(new PairFrequency("cd", 50)); // y así sucesivamente...
        frecuenciasPares.add(new PairFrequency("de", 25));
        frecuenciasPares.add(new PairFrequency("ef", 20));
        frecuenciasPares.add(new PairFrequency("fg", 10));
        frecuenciasPares.add(new PairFrequency("gh", 5));
        frecuenciasPares.add(new PairFrequency("hi", 2));
        frecuenciasPares.add(new PairFrequency("ia", 1));

        System.out.println("Matriz de frecuencias del ejemplo: ");
        System.out.println();
        qap.generarMatrizDeFrecuencias(frecuenciasPares, teclas);
        qap.imprimirMatrizFrecuencias();
        System.out.println();

        System.out.println("Matriz de distancias del ejemplo: ");
        System.out.println();
        qap.generarMatrizDistancias();
        qap.imprimirMatrizDistancias();
        System.out.println();

        System.out.println("Asignación de las teclas aleatoria: ");
        System.out.println();
        qap.calcularAsignacionAleatoria(teclas);
        qap.imprimirTeclado();
        System.out.println();
        int puntuacion = qap.calcularPuntuacionTeclado();
        System.out.println("La puntuación inicial es: " + puntuacion);
        System.out.println();

        System.out.println("Asignación de las teclas greedy: ");
        System.out.println();
        qap.calcularAsignacionGreedy(frecuenciasPares, teclas);
        qap.imprimirTeclado();
        System.out.println();
        int puntuacionGreedy = qap.calcularPuntuacionTeclado();
        System.out.println("La puntuación es: " + puntuacionGreedy);
        System.out.println();

        System.out.println("PROBAMOS GILMORE-LAWLER");
        System.out.println();
        int cotaFinal = qap.gilmore_lawler(frecuenciasPares, teclas, puntuacion);
        System.out.println("Cota final = " + cotaFinal);
        System.out.println();
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
