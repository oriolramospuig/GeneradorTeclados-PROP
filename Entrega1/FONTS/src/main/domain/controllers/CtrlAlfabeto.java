package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar de conjunto alfabetos y alfabeto
 * @author
 */
public class CtrlAlfabeto
{
    // ---------- PARÁMETROS ----------
    /** Crea una instancia del conjunto de alfabetos*/
    private ConjuntoAlfabetos CjtAlfabetos;


    // ---------- CONSTRUCTORAS ----------
    /** Inicialización de la instancia conjunto de alfabetos.*/
    public CtrlAlfabeto(){
        CjtAlfabetos = new ConjuntoAlfabetos();
    }


    // ---------- FUNCIONES ALFABETO ----------
    /**
     * Devuelve el contenido del alfabeto con nombre nomA
     * @param nomA clave primaria con la que buscar un alfabeto
     * @return ArrayList : Lista de caracteres del contenido del alfabeto nomA
     */
    public ArrayList<Character> getContenido(String nomA){
        return CjtAlfabetos.getAlfabeto(nomA).getLetras();
    }

    /**
     * No devuelve nada.
     * @param nomT clave primaria del teclado
     * @param nomA clave primaria del alfabeto
     * Añade el nombre del teclado nomT a la lista de teclados vinculados del alfabeto nomA
     */
    public void agregarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).agregarTecladoVinculado(nomT);
    }


    //PARA LA SEGUNDA ENTREGA
    /*public void borrarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).borrarTecladoVinculado(nomT);
    }*/


    // ---------- FUNCIONES CONJUNTOALFABETOS ----------
    /**
     * Devuelve el objecto cjt alfabetos
     * @return ConjuntoAlfabetos : Un objeto cjt alfabetos concreto
     */
    public ConjuntoAlfabetos getCjtAlfabetos(){
        return CjtAlfabetos;
    }

    /**
     * Devuelve si se ha creado bien el alfabeto con el nombre nomA
     * @param entradaCaracteres lista de caracteres del contenido del alfabeto nomA
     * @param nomA nombre (clave única) del alfabeto a agregar
     * @return boolean : True si el alfabeto ha sido creado correctamente, false si no se ha creado bien
     */
    public boolean CrearAlfabeto(String nomA, ArrayList<Character> entradaCaracteres) {
        if (!CjtAlfabetos.existeAlfabeto(nomA)) {
            Alfabeto alfabeto = new Alfabeto(nomA, entradaCaracteres);
            CjtAlfabetos.agregarAlfabeto(nomA, alfabeto);
            return true;
        }
        return false;
    }

    //PARA LA SEGUNDA ENTREGA
    /*public ArrayList<String> getTecladosVinculadosAlfabeto(String nomA){
        ArrayList<String> tVinculados = CjtAlfabetos.getAlfabeto(nomA).getTecladosVinculados();
        return tVinculados;
    }
    public boolean alfabetoTieneTecladosVinculados(String nomA){
        ArrayList<String> tVinculados = CjtAlfabetos.getAlfabeto(nomA).getTecladosVinculados();
        return !tVinculados.isEmpty();
    }
    public void borrarAlfabeto(String nomA){
        CjtAlfabetos.borrarAlfabeto(nomA);
    }*/
}