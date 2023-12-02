package main.persistence.controllers;

import main.persistence.classes.GestorAlfabeto;
import main.persistence.classes.GestorConfiguracion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.FileNotFoundException;

/**
 *  El controlador de persistencia se encarga de gestionar el almacenamiento de datos, es decir, se
 *  encarga de saber dónde y como están estos almacenados.
 */
public class CtrlPersistencia {
    private final GestorConfiguracion gestorConfiguracion;

    public CtrlPersistencia() {
        gestorConfiguracion = new GestorConfiguracion();
    }

    /**
     * Guarda contenido Alfabetos de la clase Configuracion en el fichero configAlfabetos.cdp"
     * @param bytes
     */
    public void guardaConfigAlfabetos(byte[] bytes) {
        gestorConfiguracion.guardaConfigAlfabetos(bytes);
    }

    /**
     * Carga contenido de Alfabetos de la clase Configuracion del fichero "configAlfabetos.cdp"
     * @return configuracion de alfabetos como a byte array
     */
    public byte[] cargaConfigAlfabetos() {
        return gestorConfiguracion.cargaConfigAlfabetos();
    }

    /**
     * Devuelve true si existe contenido de alfabetos en la clase Configuracion
     * @return
     */
    public boolean existeCongigAlfabetos() {
        return gestorConfiguracion.existeConfigAlfabetos();
    }

    /**
     * Borra fichero alfabeto de Configuracion
     * @return
     */
    public boolean borraConfigAlfabeto() {
        return gestorConfiguracion.borraConfigAlfabetos();
    }



    // public void guardaAlfabeto(String nombreA) throws FileNotFoundException {gestorAlfabeto.getContenidoAlfabeto(nombreA);}
    // public boolean existeAlfabeto(String nombreA) { return gestorAlfabeto.existeAlfabeto(nombreA);}
    // public boolean borraAlfabeto(String nombreA) {return gestorAlfabeto.borrarAlfabeto(nombreA);}
}