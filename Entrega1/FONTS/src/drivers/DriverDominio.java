package drivers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DriverDominio {
    public static void main(String[] args) {
        DriverDominio driverDominio = new DriverDominio();
        System.out.println("Driver Principal Dominio");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        ConjuntoAlfabetos conjuntoAlfabetos = new ConjuntoAlfabetos();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear un nuevo alfabeto");
            System.out.println("2. Ver alfabetos existentes");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del alfabeto: ");
                    String nombreAlfabeto = scanner.nextLine();

                    System.out.print("Introduce los caracteres del alfabeto separados por espacios: ");
                    String entrada = scanner.nextLine();

                    String[] caracteres = entrada.split(" ");
                    ArrayList<Character> contenido = new ArrayList<>();

                    for (String caracter : caracteres) {
                        contenido.add(caracter.charAt(0));
                    }

                    Alfabeto alfabeto = new Alfabeto(nombreAlfabeto, contenido);
                    conjuntoAlfabetos.agregarAlfabeto(nombreAlfabeto, alfabeto);
                    System.out.println("Alfabeto creado: " + nombreAlfabeto);
                    break;

                case 2:
                    HashMap<String, Alfabeto> alfabetos = conjuntoAlfabetos.getAlfabetos();
                    System.out.println("Alfabetos existentes:");
                    for (HashMap.Entry<String, Alfabeto> entry : alfabetos.entrySet()) {
                        String nombre = entry.getKey();
                        Alfabeto alf = entry.getValue();
                        System.out.println(nombre + ": " + alf.getContenido());
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
