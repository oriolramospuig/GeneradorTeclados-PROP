package main.persistence.classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Implementación de la clase gestionadora de datos para la clase "Alfabeto", carga/vuelca los alfabetos modificados en cada caso.
 */
public class GestorAlfabeto {
    /**
     implementación del patrón de diseño "Singleton", con el objetivo de que haya una única instancia de esta clase en el
     sistema. En este caso, esta propiedad es deseada ya que esta classe no tiene estado (astributos no estáticos). Para
     lograrlo, declaramos la constructora como privada y añadimos una operación estática que retorne siempre la misma
     instancia. Para acceder a esta instancia lo haremos mediante la llamada GestorAlfabetoArchivo.getInstance();
     */
     private static GestorAlfabeto singletonObject;

     public static GestorAlfabeto getInstance() {
         if (singletonObject == null)
             singletonObject = new GestorAlfabeto() {
             };
         return singletonObject;
     }


     // ---------- CONSTRUCTORA PRIVADA ----------
     public GestorAlfabeto() {
     }

     public List<String> getContenidoAlfabeto(String nombreArchivo) throws FileNotFoundException {
         LinkedList<String> contenidoAlfabeto = new LinkedList<String>();

         FileReader fr = new FileReader("../INPUT_FILES/"+nombreArchivo);
         Scanner scan = new Scanner(fr);

         while (scan.hasNextLine()) {
             contenidoAlfabeto.add(new String(scan.nextLine()));
         }
         return contenidoAlfabeto;
     }

     public boolean existeAlfabeto(String nombreA) {
       // return alfabetos.containsKey(nombreA);
         return false;
     }

     public boolean borrarAlfabeto(String nombreA) {
         //alfabetos.remove(nombreA);
         return false;
     }

}