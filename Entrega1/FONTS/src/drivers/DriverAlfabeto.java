package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.functions.InOut;
import main.domain.controllers.CtrlAlfabeto;
import main.domain.controllers.CtrlDominio;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverAlfabeto {

    private InOut inOut;
    private CtrlDominio ctrlDominio;

    public DriverAfabeto() {
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
        String nombre = inOut.leerString();
        System.out.println("Introduce los caracteres del alfabeto separados por espacio (ejemplo: a b c ...):");
        String entradaCaracteres = inOut.leerString();
        if (contenidoValido(entradaCaracteres)) {
            boolean agregado = ctrlDominio.agregarAlfabeto(nombre, entradaCaracteres);
            if (!agregado) System.out.println("Ya existe el alfabeto " + nombre);
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

    public void imprimirAlfabeto(String nombre, Alfabeto a){
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
    }

    public void imprimirNombresAlfabetos() {
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
            System.out.println(nombre);
        }
    }

    public void imprimirAlfabetos() {
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
    }

    public void borrarAlfabeto() {
        System.out.println("Alfabetos actuales:");
        imprimirNombresAlfabetos();
        System.out.println("Introduce el nombre del alfabeto que quieres borrar:");
        String nombre = inOut.leerString();
        if(ctrlDominio.alfabetoTieneTecladosVinculados(nombre)){
            System.out.println("Este alfabeto tiene teclados vinculados. Estas seguro/a de que quieres borrarlo y tambien borrar sus teclados asociados?");
            String respuesta = inOut.leerString();
            if(respuesta.equals("si") || respuesta.equals("SI") || respuesta.equals("Si")){
                ctrlDominio.borrarAlfabeto(nombre);
                System.out.println("BORRADO CON EXITO!");

            }
            else System.out.println("No se ha borrado el alfabeto " + nombre);
        }
    }
}
