package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.AsociacionTextos;
import main.domain.classes.Texto;
import main.domain.classes.functions.InOut;
import main.domain.controllers.CtrlDominio;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Driver para testear las funcionalidades de CtrlTexto
 * @author X (X@estudiantat.upc.edu)
 */
public class DriverTexto {

    private final InOut inOut;
    private CtrlDominio ctrlDominio;

    public DriverTexto() {
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

    public void agregarTextoPorTerminal() {
        System.out.println("Introduce el nombre del texto:");
        String nombreTxt = inOut.leerString();
        System.out.println("Introduce las palabras del texto separadas por espacio (ejemplo: hola que tal...):");
        String frecuenciasLetras = inOut.leerString();
        if (contenidoValido(frecuenciasLetras)) {
            HashMap<String, Integer> frecletras = inOut.leerPalabrasDeTerminal(frecuenciasLetras);
            boolean agregado = ctrlDominio.agregarTexto(nombreTxt, frecletras);
            if (!agregado) System.out.println("Ya existe el texto " + nombreTxt);
            else System.out.println("AGREGADO CON EXITO!");
        } else {
            System.out.println("El contenido introducido no es válido. Asegúrate de que sean palabras separadas por un espacio.");
        }
    }
/*
    public void agregarTextoPorArchivo() {
        System.out.println("Introduce el nombre del archivo:");
        String nombreArchivo = inOut.leerString();
        try {
            HashMap<String, Integer> frecletras = inOut.leerPalabrasDeArchivo(frecuenciasLetras);
            System.out.println("Introduce el nombre del texto:");
            String nombreTxt = inOut.leerString();
            Texto texto = new Texto(nombreTxt, frecletras);
            ctrlDominio.agregarTexto(nombreTxt, texto);
            System.out.println("Texto agregado con éxito desde el archivo: " + nombreArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + nombreArchivo);
        } catch (IllegalArgumentException e) {
            System.out.println("El contenido del archivo no es válido: " + e.getMessage());
        }
    }

 */

    /*public void imprimirTexto(String nombre, Alfabeto a){
        ArrayList<Character> contenido = a.getLetras();

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
    }*/
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

  /*  public void imprimirNombresTextos() {
        HashMap<String, Texto> textos = ctrlDominio.getListaAlfabetos();
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
            System.out.println(nombre);
        }
    }

   */

    /*public void imprimirTextos() {
        // Obtén todos los alfabetos en el conjunto
        HashMap<String, Alfabeto> alfabetos = ctrlDominio.getListaAlfabetos();
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
            imprimirTexto(nombre,alfabeto);
        }
    }*/

    public void borrarTexto() {
        System.out.println("Alfabetos actuales:");
  //      imprimirNombresTextos();
        System.out.println("Introduce el nombre del alfabeto que quieres borrar:");
        String nombre = inOut.leerString(); // hay que comprobar que el nombre esta bien?
        if (ctrlDominio.alfabetoTieneTecladosVinculados(nombre)) {
            System.out.println("Este alfabeto tiene teclados vinculados. Estas seguro/a de que quieres borrarlo y tambien borrar sus teclados asociados?");
            String respuesta = inOut.leerString();
            if (respuesta.equals("si") || respuesta.equals("SI") || respuesta.equals("Si")) {
                ctrlDominio.borrarAlfabeto(nombre);
                System.out.println("BORRADO CON EXITO!");

            } else System.out.println("No se ha borrado el alfabeto " + nombre);
        }
        //else{
        //ctrlDominio.borrarAlfabeto(nombre);
        //System.out.println("BORRADO CON EXITO!");
        //}
    }


    /*public void borrarTexto() {
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
    }*/
}
