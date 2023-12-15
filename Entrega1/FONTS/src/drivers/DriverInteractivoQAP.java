package drivers;
import main.domain.classes.functions.QAP;
import main.domain.classes.functions.SimulatedAnnealing;
import main.domain.classes.types.PairInt;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverInteractivoQAP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecciona un test: \n1: sko100a \n2: sko64 \n3: chr12a \n4: chr12b \n5: chr12c \n6: tai10a \n7: tai10b \n8: tai25a \n9: Salir");
            int opcionTest = obtenerOpcionValida(scanner, 9);

            if (opcionTest == 9) {
                System.out.println("Saliendo del driver interactivo...");
                break;
            }

            String nombreTest = obtenerNombreTest(opcionTest);
            System.out.println("Selecciona un método: \n1: QAP \n2: SA (Simulated Annealing) \n3: N SA (Múltiples SA)");
            int opcionMetodo = obtenerOpcionValida(scanner, 3);

            String filePath = obtenerRutaArchivo(nombreTest);
            if (filePath != null) {
                ejecutarMetodoSeleccionado(filePath, opcionMetodo, scanner);
            } else {
                System.out.println("Archivo no encontrado.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static int obtenerOpcionValida(Scanner scanner, int maxOpcion) {
        int opcion;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // para descartar la entrada incorrecta
            }
            opcion = scanner.nextInt();
            if (opcion < 1 || opcion > maxOpcion) {
                System.out.println("Opción inválida, por favor intenta de nuevo.");
            }
        } while (opcion < 1 || opcion > maxOpcion);
        return opcion;
    }

    private static String obtenerNombreTest(int opcionTest) {
        switch (opcionTest) {
            case 1:
                return "sko100a";
            case 2:
                return "sko64";
            case 3:
                return "chr12a";
            case 4:
                return "chr12b";
            case 5:
                return "chr12c";
            case 6:
                return "tai10a";
            case 7:
                return "tai10b";
            case 8:
                return "tai25a";
            // Agrega más casos para otras opciones
            default:
                return null;
        }
    }

    private static String obtenerRutaArchivo(String nombreTest) {
        String currentDirectory = System.getProperty("user.dir");
        return currentDirectory + "\\Entrega1\\FONTS\\src\\test\\QAP_tests\\" + nombreTest + ".dat";
    }

    private static void ejecutarMetodoSeleccionado(String filePath, int opcionMetodo, Scanner scanner) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            Scanner fileScanner = new Scanner(br);
            int n = fileScanner.nextInt();
            // Crear matrices de frecuencias y distancias
            int[][] matrizFrecuencias = new int[n][n];
            int[][] matrizDistancias = new int[n][n];

            // Leer y llenar la matriz de frecuencias
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (fileScanner.hasNextInt()) { // Asegúrate de que hay un entero disponible antes de leerlo
                        matrizFrecuencias[i][j] = fileScanner.nextInt();
                    }
                }
            }

            // Leer y llenar la matriz de distancias
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (fileScanner.hasNextInt()) { // Asegúrate de que hay un entero disponible antes de leerlo
                        matrizDistancias[i][j] = fileScanner.nextInt();
                    }
                }
            }

            fileScanner.close();
            ArrayList<PairInt> posiblesDimensiones = new ArrayList<>();
            posiblesDimensiones = generarDimensiones(n);
            int nfilas = 1, ncolumnas = n;

            switch (opcionMetodo) {
                case 1: // QAP
                    int [][] tec;
                    QAP qap = new QAP(nfilas,ncolumnas,matrizFrecuencias,matrizDistancias, 0);
                    tec = qap.getTeclado();
                    for (int i = 0; i < nfilas; ++i) {
                        for (int j = 0; j < ncolumnas; ++j) {
                            System.out.print(tec[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 2: // SA
                    SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(nfilas, ncolumnas, matrizFrecuencias, matrizDistancias);
                    int p = simulatedAnnealing.getPuntuacionFinal();
                    System.out.println("Puntuacion = " + p);
                    break;
                case 3: // N SA
                    System.out.println("Introduce el número de ejecuciones para SA:");
                    int nEjecuciones = scanner.nextInt();
                    int peor = 0;
                    int mejor = 999999999;
                    for (int i = 0; i < nEjecuciones; ++i) {
                        //System.out.println("Iteracion " + i + " simulated Annealing");
                        SimulatedAnnealing NsimulatedAnnealing = new SimulatedAnnealing(nfilas, ncolumnas, matrizFrecuencias, matrizDistancias);
                        int pt = NsimulatedAnnealing.getPuntuacionFinal();
                        //System.out.println("Puntuacion = " + pt);
                        if (pt < mejor) mejor = pt;
                        if (pt > peor) peor = pt;
                    }
                    System.out.println("Mejor de las N iteraciones = " + mejor);
                    System.out.println("Peor de las N ejecuciones = " + peor);
                    break;
                default:
                    System.out.println("Método no reconocido.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static ArrayList<PairInt> generarDimensiones(int n) {
        ArrayList<PairInt> dim = new ArrayList<>();
        Integer x = 1;
        for (int filas = 1; filas <= n; filas++) {
            if (n % filas == 0) {
                int columnas = n / filas;
                System.out.print(x + ": " + filas + "filas, " + columnas + "columnas");
                dim.add(new PairInt(filas, columnas));
                if (n - filas * columnas == 1) System.out.println(" Falta una tecla");
                else System.out.println();
                x++;
            }
        }
        if (esPrimo(n)) {
            int N = n+1;
            Integer y = 1;
            for (int filas = 1; filas <= N; filas++) {
                if (N % filas == 0) {
                    int columnas = N / filas;
                    System.out.print(y + ": " + filas + "filas, " + columnas + "columnas");
                    dim.add(new PairInt(filas, columnas));
                    System.out.println();
                    y++;
                }
            }
        }
        return dim;
    }

    private static boolean esPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
