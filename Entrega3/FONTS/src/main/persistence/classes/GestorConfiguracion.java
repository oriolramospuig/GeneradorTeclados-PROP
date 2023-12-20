package main.persistence.classes;

import java.io.*;

/**
 * Clase que contiene los métodos necesarios para mentener información sobre que alfabetos se han creado y donde se encuentran
 */
public class GestorConfiguracion {
    /** Contiene el path completo donde se guarda la configuración de alfabetos del programa */
    private final String pathAlfabetos = System.getProperty("user.dir") + "/" + "configAlfabetos.cdp";

    /** Contiene el path completo donde se guarda la configuración de textos del programa */
    private final String pathTextos = System.getProperty("user.dir") + "/" + "configTextos.cdp";

    /** Contiene el path completo donde se guarda la configuración de asociaciones del programa */
    private final String pathAsociaciones = System.getProperty("user.dir") + "/" + "configAsociaciones.cdp";

    /** Contiene el path completo donde se guarda la configuración de teclados del programa */
    private final String pathTeclados = System.getProperty("user.dir") + "/" + "configTeclados.cdp";


    /*  /**
     * Guarda los datos del byte array bytes a disco en el path marcado por el atributo pathAlfabetos
     * @param bytes
     *
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
   */
    public void guardaConfig(byte[] bytes) {
        try {
            //Alfabetos
            FileOutputStream outFileAlfabetos = new FileOutputStream(pathAlfabetos);
            outFileAlfabetos.write(bytes);
            outFileAlfabetos.flush();
            outFileAlfabetos.close();
            //Textos
            FileOutputStream outFileTextos = new FileOutputStream(pathTextos);
            outFileTextos.write(bytes);
            outFileTextos.flush();
            outFileTextos.close();
            //Asociaciones
            FileOutputStream outFileAsociaciones = new FileOutputStream(pathAsociaciones);
            outFileAsociaciones.write(bytes);
            outFileAsociaciones.flush();
            outFileAsociaciones.close();
            //Teclados
            FileOutputStream outFileTeclados = new FileOutputStream(pathTeclados);
            outFileTeclados.write(bytes);
            outFileTeclados.flush();
            outFileTeclados.close();
        } catch (IOException e) {
            System.err.println("RUNTIME UNHANDLED EXCEPTION -> IOException when trying to write/create config file! E: " + e.toString());
            Thread.currentThread().getStackTrace();
            System.exit(-2);
        }
    }

    /**
     * Devuelve un byte array con los datos leidos del fichero marcado por atributo pathAlfabetos
     * @return
     *
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
    }*/

    public byte[] cargaConfig() {
        byte[] bytesAlfabetos = null;
        byte[] bytesTextos = null;
        byte[] bytesAsociaciones = null;
        byte[] bytesTeclados = null;
        try {
            FileInputStream inFileAlfabetos = new FileInputStream(pathAlfabetos);
            bytesAlfabetos = inFileAlfabetos.readAllBytes();
            inFileAlfabetos.close();
            FileInputStream inFileTextos = new FileInputStream(pathTextos);
            bytesTextos = inFileTextos.readAllBytes();
            inFileTextos.close();
            FileInputStream inFileAsociaciones = new FileInputStream(pathAsociaciones);
            bytesAsociaciones = inFileAsociaciones.readAllBytes();
            inFileAsociaciones.close();
            FileInputStream inFileTeclados = new FileInputStream(pathTeclados);
            bytesTeclados = inFileTeclados.readAllBytes();
            inFileTeclados.close();
        } catch (IOException e) {
            System.err.println("RUNTIME UNHANDLED EXCEPTION -> IOException when trying to read config file! E: " + e.toString());
            Thread.currentThread().getStackTrace();
            System.exit(-2);
        }
        return new byte[bytesAlfabetos.length + bytesTextos.length + bytesAsociaciones.length + bytesTeclados.length];
    }

    /**
     * Devuelve true si existe el fichero marcado por pathAlfabetos, falso en caso contrario
     */
  /*  public boolean existeConfigAlfabetos() {
        File f = new File(pathAlfabetos);
        return f.exists();
    }
   */


    public boolean existeConfig() {
        File fAlfabetos = new File(pathAlfabetos);
        File fTextos = new File(pathTextos);
        File fAsociaciones = new File(pathAsociaciones);
        File fTeclados = new File(pathTeclados);
        return fAlfabetos.exists() && fTextos.exists() && fAsociaciones.exists() && fTeclados.exists();
    }

    /**
     * Elimina el fichero marcado por pathAlfabetos. Si se elimina correctamente devuelve true y false en caso contrario
     *
    public boolean borraConfigAlfabetos() {
        File f = new File(pathAlfabetos);
        return f.delete();
    }*/

    public boolean borraConfig() {
        File fAlfabetos = new File(pathAlfabetos);
        File fTextos = new File(pathTextos);
        File fAsociaciones = new File(pathAsociaciones);
        File fTeclados = new File(pathTeclados);
        return fAlfabetos.delete() && fTextos.delete() && fAsociaciones.delete() && fTeclados.delete();
    }
}