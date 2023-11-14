package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.functions.InOut;
import main.domain.controllers.CtrlDominio;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverTexto {

    private InOut inOut;
    private CtrlDominio ctrlDominio;

    public DriverTexto() {
        inOut = new InOut();
        ctrlDominio = new CtrlDominio();
    }
    /*public boolean contenidoValido(String entrada) {
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
    }*/


    public void agregarTextoPorTerminal() {
        System.out.println("Introduce el nombre del texto:");
        String nombre = inOut.leerString();
        System.out.println("Introduce las palabras del texto separadas por espacio (ejemplo: hola que tal...):");
        String palabras = inOut.leerString();
        if (inOut.contenidoValido(palabras)) {
            ArrayList<Character> frecletras = inOut.leerParabrasDeTerminal(palabras);
            boolean agregado = ctrlDominio.agregarTexto(nombre, frecletras);
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
            ArrayList<Character> frecuenciasLetras = inOut.frecuenciasLetrasDeArchivo(nombreArchivo);
            System.out.println("Introduce el nombre del alfabeto:");
            String nombre = inOut.leerString();
            //REVISAR SI FA FALTA, DEPENENT DE COM ES LLEGEIXI UN ARXIU A JAVA
            /*ArrayList<Character> caracteres = new ArrayList<>();
            for (char c: entradaCaracteres.toCharArray()) {
                // Solo agrega caracteres no espacios.
                // espacio tambien puede ser caracter
                if (c != ' ') caracteres.add(c);
            }*/
            //llegir arxiu i ficar el text a l'tring caracteres
            ctrlDominio.agregarAlfabeto(nombre, caracteres);
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

}
