package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.Algoritmo;
import main.domain.classes.PairIntEnum;
import main.domain.classes.Teclado;
import main.domain.classes.functions.InOut;
import main.domain.classes.functions.QAP;
import main.domain.classes.types.PairInt;
import main.domain.controllers.CtrlDominio;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DriverTeclado {
    private static final Object QAP = ;
    private InOut inOut;
    private CtrlDominio ctrlDominio;

    public DriverTeclado() {
        inOut = new InOut();
        ctrlDominio = new CtrlDominio();
    }

    public void agregarTeclado() {
        System.out.println("Introduce el nombre del teclado:");
        String nombreT = inOut.leerString();
        try {
            System.out.println("Introduce el nombre del alfabeto:");
            String nombreA = inOut.leerString();
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
            System.out.println("Teclado agregado con éxito: " + nombreT);
        } catch (IllegalArgumentException e) {
            System.out.println("Existe un teclado con el mismo nombre " + nombreT); //?? que tipo de excepcion tendria que pasar?
        }
    }

    public void imprimirTeclado(String nombre, Teclado t){
        ArrayList<Character> contenido = t.getLetras();

        // Imprime el nombre y el contenido del teclado
        System.out.println("Nombre del teclado: " + nombre);
        System.out.print("Contenido del teclado: ");

        // Imprime el contenido del teclado
        for (char c : contenido) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void imprimirNombresTeclados() {
        // Obtén todos los teclados en el conjunto
        ArrayList<String> teclados = ctrlDominio.getListaTeclados();

        // Verifica si hay teclados en el conjunto
        if (teclados.isEmpty()) {
            System.out.println("No hay teclados para mostrar.");
            return;
        }

        // Itera sobre el conjunto de teclados e imprime la información de cada uno
        for (HashMap.Entry<String, Teclado> entry : teclados.entrySet()) {
            // Obtiene el nombre y el teclado del conjunto
            String nombre = entry.getKey();
            System.out.println(nombre);
        }
    }

    public void imprimirTeclados() {
        // Obtén todos los teclados en el conjunto
        ArrayList<String> teclados = ctrlDominio.getListaTeclados();

        // Verifica si hay teclados en el conjunto
        if (teclados.isEmpty()) {
            System.out.println("No hay teclados para mostrar.");
            return;
        }

        // Itera sobre el conjunto de teclados e imprime la información de cada uno
        for (HashMap.Entry<String, Teclado> entry : teclados.entrySet()) {
            // Obtiene el nombre y el alfabeto del conjunto
            String nombre = entry.getKey();
            Teclado teclado = entry.getValue();
            imprimirTeclado(nombre,teclado);
        }
    }

    public void borrarTeclado() {
        System.out.println("Teclados actuales:");
        imprimirNombresTeclados();
        System.out.println("Introduce el nombre del teclado que quieres borrar:");
        String nombre = inOut.leerString(); // hay que comprobar que el nombre esta bien?

        ctrlDominio.borrarAlfabeto(nombre);
        System.out.println("BORRADO CON EXITO!");
    }
}
