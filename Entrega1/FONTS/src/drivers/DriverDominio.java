
package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;
import main.domain.classes.ConjuntoTextos;
import main.domain.classes.functions.GilmoreLawler;
import main.domain.classes.functions.InOut;
import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairFrequency;
import main.domain.controllers.CtrlDominio;

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
    private DriverAlfabeto driverAfabeto;
    private DriverTeclado driverTeclado;
    private ConjuntoAlfabetos conjuntoAlfabetos;
    private ConjuntoTextos conjuntoTextos;
    private ConjuntoTeclados conjuntoTeclados;
    private CtrlDominio ctrlDominio;
    private final InOut inOut;

    private InOut inOut;

    public DriverDominio() {
        InOut inOut = new InOut();
        conjuntoAlfabetos = new ConjuntoAlfabetos();
    }

    // ---------- FUNCIONES ALFABETO ----------

    /**
     * No retorna nada.
     */
    public void agregarAlfabetoPorArchivo() {
        driverAfabeto.agregarAlfabetoPorArchivo();
    }
    public void agregarAlfabetoPorTerminal() {
        driverAfabeto.agregarAlfabetoPorTerminal();
    }
    public void borrarAlfabeto() {
        driverAfabeto.borrarAlfabeto();
    }
    public void imprimirAlfabetos() {
        driverAfabeto.imprimirAlfabetos();
    }


    // ---------- FUNCIONES TEXTO ----------
    /**
     * No retorna nada.
     * Muestra al usuario como debe ser la entrada
     * Manda a comprobar que la entrada sea válida
     * Manda añadir el nuevo texto con los atributos asignados
     * Envía mensaje de contenido no válido si no lo es
     */
    public void agregarTextoPorTerminal() {
        System.out.println("Introduce el nombre del texto:");
        String nombre = inOut.leerString();
        System.out.println("Introduce las palabras del texto separadas por espacio (ejemplo: hola que tal...):");
        String frecuenciasLetras = inOut.leerString(); // canviar perq ara es texto
        if (inOut.contenidoValido(frecuenciasLetras)) {
            boolean agregado = ctrlDominio.agregarTexto(nombre, frecuenciasLetras);
            if (!agregado) System.out.println("Ya existe el texto " + nombre);
            else System.out.println("AGREGADO CON EXITO!");
        } else {
            System.out.println("El contenido introducido no es válido. Asegúrate de que sean palabras separadas por un espacio.");
        }
    }

    public void agregarTextoPorArchivo() {
        System.out.println("Introduce el nombre del archivo:");
        String nombreArchivo = inOut.leerString();
        try {
            ArrayList<Character> caracteres = inOut.leerCaracteresDeArchivo(nombreArchivo);
            //System.out.println("Introduce el nombre del alfabeto:"); // cambiar esto porque no son caracteres son palabras de un texto
            String nombre = inOut.leerString();
            Alfabeto alfabeto = new Alfabeto(nombre, caracteres); // aixo no ho hauria de fer el ctrlDominio i ctrlAlfabeto?
            conjuntoAlfabetos.agregarAlfabeto(nombre, alfabeto);
            System.out.println("Alfabeto agregado con éxito desde el archivo: " + nombreArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + nombreArchivo);
        } catch (IllegalArgumentException e) {
            System.out.println("El contenido del archivo no es válido: " + e.getMessage());
        }
    }

    public void borrarTexto() {
        //listar textos
        String nombre = inOut.leerString();
        boolean borrado = ctrlDominio.borrarTexto(nombre);
        if (!borrado) System.out.println("No se ha borrado el texto " + nombre);
        else System.out.println("BORRADO CON EXITO!");
    }


    public void imprimirTexto() {
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


    // ---------- FUNCIONES TECLADO ----------
    public void agregarTeclado() {
        driverTeclado.agregarTeclado();
    }
    public void borrarTeclado() {
        driverTeclado.borrarTeclado();
    }
    public void imprimirTeclado() {
       // driverTeclado.imprimirTeclado();
    }


    // ---------- FUNCIONES QAP ----------

    void imprimirPruebaQAP() {
        System.out.println("Se generará un teclado aleatorio de 3*4 con las letras de la A a la L: ");
        System.out.println();
        List<Character> teclas = new ArrayList<>();
        for(char c = 'a'; c <= 'l'; c++) { // Asumiendo un alfabeto de 'a' a 'l'
            teclas.add(c);
        }
        List<PairFrequency> frecuenciasPares = new ArrayList<>();
        frecuenciasPares.add(new PairFrequency("ab", 1200)); // Frecuencia del par AB
        frecuenciasPares.add(new PairFrequency("bc", 900)); // Frecuencia del par BC
        frecuenciasPares.add(new PairFrequency("cd", 820)); // y así sucesivamente...
        frecuenciasPares.add(new PairFrequency("de", 710));
        frecuenciasPares.add(new PairFrequency("ef", 600));
        frecuenciasPares.add(new PairFrequency("fg", 550));
        frecuenciasPares.add(new PairFrequency("gh", 445));
        frecuenciasPares.add(new PairFrequency("hi", 330));
        frecuenciasPares.add(new PairFrequency("ia", 220));

        QAP qap = new QAP(3,4, teclas, frecuenciasPares);

        qap.imprimirMatrices();

        qap.calcularAsignacionAleatoria(teclas);
        qap.imprimirTeclado();

        int puntuacion = qap.calculoPuntuacion();


        List<Character> teclasOrdenadas = qap.getTeclasOrdenadas();

        qap.calcularAsignacionGreedy(frecuenciasPares, teclasOrdenadas);
        qap.imprimirTeclado();

        int puntuacionGreedy = qap.calculoPuntuacion();


        GilmoreLawler gilmoreLawler = new GilmoreLawler(qap.getFilas(), qap.getColumnas(), qap.getGlBound(), qap.getMatrizFrecuencias(), qap.getMatrizDistancias(), qap.getLetraAIndice());
        gilmoreLawler.gilmore_lawler(frecuenciasPares, teclasOrdenadas, puntuacionGreedy);
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
