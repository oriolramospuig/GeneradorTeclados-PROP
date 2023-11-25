package drivers;
import main.domain.classes.functions.QAP;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import static java.lang.Math.sqrt;

public class QAPTester {

        public static void main(String[] args) {
            String nombreTest = "scr12.dat";
            //String path = "C:\\Users\\34696\\OneDrive\\Descargas\\VARIS\\";
            //String pathInput = path + "qapdata\\rou12.dat";
            //String pathSolutions = path + "qapsoln";
            String currentDirectory = System.getProperty("user.dir");
            // Ruta absoluta del archivo
            String filePath = currentDirectory+"\\subgrup-prop14.3\\Entrega1\\FONTS\\src\\test\\QAP_tests\\"+nombreTest;


            System.out.println("PATH: " + filePath);
            try {
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                Scanner scanner = new Scanner(br);
                int n = scanner.nextInt();
                System.out.println("EMPEZAMOS! N: " + n);
                // Crear matrices de frecuencias y distancias
                int[][] matrizFrecuencias = new int[n][n];
                int[][] matrizDistancias = new int[n][n];

                // Leer y llenar la matriz de frecuencias
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (scanner.hasNextInt()) { // Asegúrate de que hay un entero disponible antes de leerlo
                            matrizFrecuencias[i][j] = scanner.nextInt();
                        }
                    }
                }

                // Leer y llenar la matriz de distancias
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (scanner.hasNextInt()) { // Asegúrate de que hay un entero disponible antes de leerlo
                            matrizDistancias[i][j] = scanner.nextInt();
                        }
                    }
                }

                double raiz = sqrt(n);
                int r = (int)raiz;
                int nfilas = 1, ncolumnas = 12;
                /*if(raiz == r) {
                    nfilas = ncolumnas = r;
                }
                else {
                    nfilas = r;
                    ncolumnas = nfilas + 1;
                }*/
                System.out.println("NFILAS: " + nfilas + " NCOLS: " + ncolumnas);
                List<Integer> sol = new ArrayList<>();
                int [][] tec;
                QAP qap = new QAP(nfilas,ncolumnas,matrizFrecuencias,matrizDistancias);
                tec = qap.getTeclado();
                System.out.println("Tec = ");
                for (int i = 0; i < nfilas; ++i) {
                    for (int j = 0; j < ncolumnas; ++j) {
                        System.out.print(tec[i][j]);
                    }
                    System.out.println();
                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public static void cargarDatos(String filePath) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            System.out.println(line);
            Path path = Paths.get(filePath);
            try (Scanner scanner = new Scanner(Files.newBufferedReader(path))) {
                // Leer el número 'n'
                int n = scanner.nextInt();
                System.out.println("EMPEZAMOS! N: " + n);
                // Crear matrices de frecuencias y distancias
                int[][] matrizFrecuencias = new int[n][n];
                int[][] matrizDistancias = new int[n][n];

                // Leer y llenar la matriz de frecuencias
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (scanner.hasNextInt()) { // Asegúrate de que hay un entero disponible antes de leerlo
                            matrizFrecuencias[i][j] = scanner.nextInt();
                        }
                    }
                }

                // Leer y llenar la matriz de distancias
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (scanner.hasNextInt()) { // Asegúrate de que hay un entero disponible antes de leerlo
                            matrizDistancias[i][j] = scanner.nextInt();
                        }
                    }
                }

                double raiz = sqrt(n);
                int r = (int)raiz;
                int nfilas, ncolumnas;
                if(raiz == r) {
                    nfilas = ncolumnas = r;
                }
                else {
                    nfilas = r;
                    ncolumnas = nfilas + 1;
                }
                System.out.println("NFILAS: " + nfilas + " NCOLS: " + ncolumnas);
                List<Integer> sol = new ArrayList<>();
                int [][]tec = new int[nfilas][ncolumnas];
                QAP qap = new QAP(nfilas,ncolumnas,matrizFrecuencias,matrizDistancias);
            }
        }
}
