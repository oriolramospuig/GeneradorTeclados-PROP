package main.persistence.classes;

import main.domain.classes.Alfabeto;

import java.io.*;
import java.util.*;


/**
 * Clase que gestiona la carga y guardado de Conjuntos de Alfabetos en formato de bytes.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class GestorAlfabeto {
    static String currentDirectory = System.getProperty("user.dir");
    //private static final String alfabetos_path = currentDirectory+"Entrega3//data//Cache"+"./conjuntoAlfabetos.csv";
    private static final String alfabetos_path = "./conjuntoAlfabetos.csv";
    private HashMap<String, Alfabeto> alfabetos = new HashMap<>();

    public HashMap<String, Alfabeto> getAlfabetos() {
        return this.alfabetos;
    }

    public void setCnjtAlfabetos(HashMap<String, Alfabeto> alfabetos) {
        this.alfabetos = alfabetos;
    }

    public void escribirEnCSV(HashMap<String, Alfabeto> alfabetosNuevos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(alfabetos_path))) {
            for (HashMap.Entry<String, Alfabeto> entry : alfabetosNuevos.entrySet()) {
                String nombreA = entry.getKey();
                Alfabeto alfabeto = entry.getValue();
                String alfabetoString = pasarAlfabetoString(alfabeto);
                writer.write(nombreA + "," + alfabetoString);
                writer.newLine();
            }
        } catch (IOException exception) {
            throw new IOException("Error de escritura de conjunto de alfabetos en el fichero CSV");
        }
    }

    public String pasarAlfabetoString(Alfabeto alfabeto) {
        StringBuilder stringBuilder = new StringBuilder();
        String nombre = alfabeto.getNombre();
        System.out.println(nombre);
        ArrayList<Character> letras = alfabeto.getLetras();
        System.out.println(letras);
        ArrayList<String> tecladosvinculados = alfabeto.getTecladosVinculados();
        System.out.println(tecladosvinculados);
        stringBuilder.append(nombre).append(",");
        stringBuilder.append(letras.toString()).append(",");
        stringBuilder.append(tecladosvinculados.toString());
        return stringBuilder.toString();
    }

    public HashMap<String, Alfabeto> leerDeCSV() throws IOException {
        existeFichero();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(alfabetos_path));
            HashMap<String, Alfabeto> newCnjtAlfabetos = new HashMap<>();

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nombreA = parts[0];
                ArrayList<Character> letrasArray = new ArrayList<>();
                for (char c : parts[2].toCharArray()) {
                    letrasArray.add(c);
                }
                Alfabeto alfabeto = new Alfabeto(nombreA, letrasArray);
                String[] partes = parts[3].split(",");
                ArrayList<String> listaTecladosVinculados = new ArrayList<>(Arrays.asList(partes));
                for (int i = 0; i < listaTecladosVinculados.size(); i++) {
                    listaTecladosVinculados.set(i, listaTecladosVinculados.get(i).trim());
                    alfabeto.agregarTecladoVinculado(listaTecladosVinculados.get(i));
                }
                newCnjtAlfabetos.put(nombreA, alfabeto);
            }
            reader.close();
            return newCnjtAlfabetos;
        } catch (IOException e) {
            throw new IOException("[#CARGA] Error al cargar el conjunto de alfabetos en el fichero CSV");
        }
    }

    private void existeFichero() throws IOException {
        File file = new File(alfabetos_path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new IOException("Error de la creación del fichero CSV del ranking");
            }
        }
    }
}

/*
/**
 *
 * Guarda un conjunto de alfabetos representado como un arreglo de bytes en un archivo.
 * @param bytes arreglo de bytes que representa el conjunto de alfabetos.
 * @param path ruta del archivo donde se guardará el conjunto de alfabetos.
 *
public static void gestorAlfabetos(byte[] bytes, String path) {
    try {
        FileOutputStream outFile = new FileOutputStream(path);
        outFile.write(bytes);
        outFile.flush();
        outFile.close();
    } catch (IOException e) {
        System.err.println("[#GUARDAR] Error al guardar el conjunto de alfabetos: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
    }
}

    /**
     * Carga un conjunto de alfabetos desde un archivo y lo devuelve como un arreglo de bytes.
     * @param path ruta del archivo desde donde se cargará el conjunto de alfabetos.
     * @return arreglo de bytes que representa el conjunto de alfabetos cargado.
     *
    public byte[] cargarAlfabetos(String path) {
        byte[] bytes = null;
        try {
            FileInputStream inFile = new FileInputStream(path);
            bytes = inFile.readAllBytes();
            inFile.close();
        } catch (IOException e) {
            System.err.println("[#CARGAR] Error al cargar el conjunto de alfabetos: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
        return bytes;
    }

 */