package main.persistence.classes;

import main.domain.classes.Alfabeto;

import java.io.*;
import java.util.*;


/**
 * Clase que gestiona la carga y guardado de Conjuntos de Alfabetos en formato de csv.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class GestorAlfabeto {
    /** Ruta del archivo CSV para almacenar el conjunto de alfabetos. */
    private static final String alfabetos_path = "./conjuntoAlfabetos.csv";

    /**
     * Escribe el conjunto de alfabetos en un archivo CSV.
     * @param alfabetosNuevos HashMap que contiene el conjunto de alfabetos a ser escrito en el archivo CSV.
     * @throws IOException si hay un error de escritura durante la operación.
     */
    public void escribirEnCSV(HashMap<String, Alfabeto> alfabetosNuevos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(alfabetos_path))) {
            for (HashMap.Entry<String, Alfabeto> entry : alfabetosNuevos.entrySet()) {
                Alfabeto alfabeto = entry.getValue();
                String alfabetoString = pasarAlfabetoString(alfabeto);
                writer.write(alfabetoString);
                writer.newLine();
            }
        } catch (IOException exception) {
            throw new IOException("Error de escritura de conjunto de alfabetos en el fichero CSV");
        }
    }

    /**
     * Convierte una lista de caracteres en un String.
     * @param letras lista de caracteres a ser convertida.
     * @return String que representa la lista de caracteres.
     */
    public String lToString(ArrayList<Character> letras) {
        StringBuilder stringBuilder = new StringBuilder(letras.size());
        for (Character character : letras) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    /**
     * Convierte una lista de strings en un solo string con separador ";".
     * @param tecladosVinculados lista de strings a ser convertida.
     * @return String que representa la lista de strings con separador ";".
     */
    private String tvToString(ArrayList<String> tecladosVinculados) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : tecladosVinculados) {
            stringBuilder.append(element).append(";");
        }
        if (stringBuilder.length() > 0) {
            String separador = ";";
            stringBuilder.setLength(stringBuilder.length() - separador.length());
        }
        return stringBuilder.toString();
    }

    /**
     * Convierte un objeto Alfabeto a un String para ser almacenado en el archivo CSV.
     * @param alfabeto objeto Alfabeto a ser convertido.
     * @return String que representa el Alfabeto en formato CSV.
     */
    public String pasarAlfabetoString(Alfabeto alfabeto) {
        StringBuilder stringBuilder = new StringBuilder();

        String nombre = alfabeto.getNombre();
        ArrayList<Character> letras = alfabeto.getLetras();
        String letrasString = lToString(letras);
        ArrayList<String> tecladosVinculados = alfabeto.getTecladosVinculados();
        String tecladosVinculadosString = tvToString(tecladosVinculados);

        stringBuilder.append(nombre).append(",");
        stringBuilder.append(letrasString).append(",");
        stringBuilder.append(tecladosVinculadosString);
        return stringBuilder.toString();
    }

    /**
     * Lee el conjunto de alfabetos desde el archivo CSV y lo carga en memoria.
     * @return HashMap que contiene el conjunto de alfabetos cargado desde el archivo CSV.
     * @throws IOException si hay un error de lectura durante la operación.
     */
    public HashMap<String, Alfabeto> leerDeCSV() throws IOException {
        existeFichero();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(alfabetos_path));
            HashMap<String, Alfabeto> newCnjtAlfabetos = new HashMap<>();

            String line;

            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                String nombreA = partes[0];
                String letrasA = partes[1];

                ArrayList<Character> letrasArray = new ArrayList<>();
                for (char c : letrasA.toCharArray()) {
                    letrasArray.add(c);
                }
                Alfabeto alfabeto = new Alfabeto(nombreA, letrasArray);

                if (partes.length >= 3) {
                    String tvS = partes[2];
                    String[] tv = tvS.split(";");
                    ArrayList<String> listaTecladosVinculados = new ArrayList<>(Arrays.asList(tv));
                    for (int i = 0; i < listaTecladosVinculados.size(); i++) {
                        listaTecladosVinculados.set(i, listaTecladosVinculados.get(i).trim());
                        alfabeto.agregarTecladoVinculado(listaTecladosVinculados.get(i));
                    }
                }
                newCnjtAlfabetos.put(nombreA, alfabeto);
            }
            reader.close();
            return newCnjtAlfabetos;
        } catch (IOException e) {
            throw new IOException("[#CARGA] Error al cargar el conjunto de alfabetos en el fichero CSV");
        }
    }

    /**
     * Verifica la existencia del archivo especificado por la ruta 'alfabetos_path'.
     * Si el archivo no existe, intenta crearlo.
     * @throws IOException si hay un error durante la verificación o creación del archivo.
     */
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