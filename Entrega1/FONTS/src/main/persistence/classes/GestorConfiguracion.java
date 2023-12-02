package main.persistence.classes;

import java.io.*;

/**
 * Clase que contiene los métodos necesarios para mentener información sobre que alfabetos se han creado y donde se encuentran
 */
public class GestorConfiguracion {
    /** Contiene el path completo donde se guarda la configuración de alfabetos del programa */
    private final String pathAlfabetos = System.getProperty("user.dir") + "/" + "configAlfabetos.cdp";


    /**
     * Guarda los datos del byte array bytes a disco en el path marcado por el atributo pathAlfabetos
     * @param bytes
     */
    public void guardaConfigAlfabetos(byte[] bytes) {
        try {
            FileOutputStream outFile = new FileOutputStream(pathAlfabetos);
            outFile.write(bytes);
            outFile.flush();
            outFile.close();
        } catch (IOException e) {
            System.err.println("RUNTIME UNHANDLED EXCEPTION -> IOException when trying to write/create config file! E: " + e.toString());
            Thread.currentThread().getStackTrace();
            System.exit(-2);
        }
    }

    /**
     * Devuelve un byte array con los datos leidos del fichero marcado por atributo pathAlfabetos
     * @return
     */
    public byte[] cargaConfigAlfabetos() {
        byte[] bytes = null;
        try {
            FileInputStream inFile = new FileInputStream(pathAlfabetos);
            bytes = inFile.readAllBytes();
            inFile.close();
        } catch (IOException e) {
            System.err.println("RUNTIME UNHANDLED EXCEPTION -> IOException when trying to read config file! E: " + e.toString());
            Thread.currentThread().getStackTrace();
            System.exit(-2);
        }
        return bytes;
    }

    /**
     * Devuelve true si existe el fichero marcado por pathAlfabetos, falso en caso contrario
     */
    public boolean existeConfigAlfabetos() {
        File f = new File(pathAlfabetos);
        return f.exists();
    }

    /**
     * Elimina el fichero marcado por pathAlfabetos. Si se elimina correctamente devuelve true y false en caso contrario
     */
    public boolean borraConfigAlfabetos() {
        File f = new File(pathAlfabetos);
        return f.delete();
    }
}
