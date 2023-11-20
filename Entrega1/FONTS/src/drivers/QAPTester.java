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
            String filePath = currentDirectory+"\\Entrega1\\FONTS\\src\\test\\QAP_tests\\"+nombreTest;


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
                QAP qap = new QAP(nfilas,ncolumnas,matrizFrecuencias,matrizDistancias);


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
/*

            File file = new File(pathInput);

            if(!file.exists()) System.out.println("Carpeta no existe");
            else{
                System.out.println("BIEN");
                if(file.isFile()){
                    System.out.println("es fichero");
                    try {
                        System.out.println("FICHERO:" + file.getName());
                        cargarDatos(file.getPath());
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + file.getPath());
                        e.printStackTrace();
                    }
                }
                System.out.println("fin");

                /*File[] listOfFiles = folder.listFiles();
                if(listOfFiles == null) System.out.println("nooooo");

                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        try {
                            System.out.println("FICHERO:" + file.getName());
                            cargarDatos(file.getPath());
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo: " + file.getPath());
                            e.printStackTrace();
                        }
                    }
                }
            }*/




            /*String pathToFicheros = "lala.txt"; // Asegúrate de establecer la ruta correcta.
            try {
                File folder = new File(pathToFicheros);
                File[] listOfFiles = folder.listFiles();

                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        try {
                            cargarDatos(file.getPath());
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo: " + file.getPath());
                            e.printStackTrace();
                        }
                    }
                }
            }*/

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
                QAP qap = new QAP(nfilas,ncolumnas,matrizFrecuencias,matrizDistancias);
                // Aquí puedes llamar a tu algoritmo con las matrices cargadas
                // Por ejemplo: resolverQAP(matrizFrecuencias, matrizDistancias);
            }
        }

        // Implementa tu algoritmo aquí
        public static void resolverQAP(int[][] matrizFrecuencias, int[][] matrizDistancias) {
            // ...
        }

}
