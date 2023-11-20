package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.functions.InOut;
import main.domain.controllers.CtrlDominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Driver para testear las funcionalidades de CtrlAlfabeto
 * @author X (X@estudiantat.upc.edu)
 */
public class DriverAlfabeto {

    private InOut inOut;
    private CtrlDominio ctrlDominio;

    public void DriverAfabeto() {
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
        System.out.println("Introduce el nombre del alfabeto:");
        String nombreArchivo = inOut.leerString();
        try {
            ArrayList<Character> caracteres = inOut.leerCaracteresDeArchivo(nombreArchivo);
            System.out.println("Introduce el nombre del alfabeto:");
            String nombreA = inOut.leerString();
            boolean agregado = ctrlDominio.agregarAlfabeto(nombreA, caracteres);
            if (!agregado) System.out.println("Ya existe el alfabeto " + nombreA);
            else System.out.println("AGREGADO CON EXITO!");
        }
        catch (IllegalArgumentException e) {
            System.out.println("El contenido del archivo no es válido: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("El archivo no se encontró: " + nombreArchivo);
        }
    }

    /*public void imprimirAlfabeto(String nombre, Alfabeto a){
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

    /*public void imprimirAlfabetos() {
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
            imprimirAlfabeto(nombre,alfabeto);
        }
    }*/

    public void borrarAlfabeto() {
        System.out.println("Alfabetos actuales:");
        imprimirNombresAlfabetos();
        System.out.println("Introduce el nombre del alfabeto que quieres borrar:");
        String nombreA = inOut.leerString(); // hay que comprobar que el nombre esta bien?
        if (ctrlDominio.alfabetoTieneTecladosVinculados(nombreA)) {
            System.out.println("Este alfabeto tiene teclados vinculados. Estas seguro/a de que quieres borrarlo y tambien borrar sus teclados asociados?");
            String respuesta = inOut.leerString();
            if (respuesta.equals("si") || respuesta.equals("SI") || respuesta.equals("Si")) {
                //ctrlDominio.borrarAlfabeto(nombreA);
                System.out.println("BORRADO CON EXITO!");

            } else System.out.println("No se ha borrado el alfabeto " + nombreA);
        }
        else{
            //ctrlDominio.borrarAlfabeto(nombreA);
            System.out.println("BORRADO CON EXITO!");
        }
    }
}
