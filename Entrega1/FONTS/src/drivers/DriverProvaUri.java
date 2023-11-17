package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.functions.GilmoreLawler;
import main.domain.classes.functions.InOut;
import main.domain.classes.functions.Matrices;
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
public class DriverProvaUri {
    /*
    InOut inOut;
    private ConjuntoAlfabetos conjuntoAlfabetos;

    public DriverProvaUri() {
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
        System.out.println("Se generará un teclado aleatorio de 3*3 con las letras de la A a la I: ");
        System.out.println();

        /* llista de caracters de l'alfabet = "tecles"*/
    /*
        List<Character> teclas = new ArrayList<>();
        for(char c = 'a'; c <= 'i'; c++) { // Asumiendo un alfabeto de 'a' a 'l'
            teclas.add(c);
        }
        /*llista de freuencies ordenades decreixentment*/
 /*       List<PairFrequency> frecuenciasPares = new ArrayList<>();
        frecuenciasPares.add(new PairFrequency("ab", 400)); // Frecuencia del par AB
        frecuenciasPares.add(new PairFrequency("bc", 300)); // Frecuencia del par BC
        frecuenciasPares.add(new PairFrequency("ac", 200));
        frecuenciasPares.add(new PairFrequency("ad", 150));
        frecuenciasPares.add(new PairFrequency("bd", 125));
        frecuenciasPares.add(new PairFrequency("be", 100)); // y así sucesivamente...
        frecuenciasPares.add(new PairFrequency("cd", 75));
        frecuenciasPares.add(new PairFrequency("de", 50));
        frecuenciasPares.add(new PairFrequency("df", 40));
        frecuenciasPares.add(new PairFrequency("ef", 30));
        frecuenciasPares.add(new PairFrequency("fg", 20));
        frecuenciasPares.add(new PairFrequency("gh", 15));
        frecuenciasPares.add(new PairFrequency("hi", 10));
        frecuenciasPares.add(new PairFrequency("ia", 5));

        /*numero de files i de columnes*/
   /*     int nf = 3;
        int nc = 3;

        /*aixo serveix per enlloc de tractar lletres a, b, c ... tractar números 1, 2, 3... a la tornada de l'algoritme
        * ho tornem a lletres. No se si es necessari tenir-ho, diria que no*/
   /*     HashMap<Character, Integer> letraAIndice = new HashMap<>();
        for (int i = 0; i < teclas.size(); i++) {
            letraAIndice.put(teclas.get(i), i);
        }
        /*les dues matrius que s'han de generar, una a partir de frecuencies, l'altre a partir del teclat seleccionat(mides)*/
   /*     int[][] matrizFrecuencias = new int[nf*nc][nf*nc];
        Matrices.generarMatrizDeFrecuencias(frecuenciasPares, teclas, letraAIndice, matrizFrecuencias);

        int [][] matrizDistancias = new int[nf*nc][nf*nc];
        Matrices.generarMatrizDistancias(nf,nc,matrizDistancias);
        /*creadora de la classe qap nova, per que poguem provar amb lo que ha dit a classe*/
        //QAP qap = new QAP(nf*nc, matrizFrecuencias, matrizFrecuencias);
        /*creadora antiga, amb això anava i donava resultat, la canviem per a canviar l'estrcutura del qap*/
     /*   QAP qap = new QAP(nf, nc, teclas, frecuenciasPares);
    }
/*


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
*/
}
