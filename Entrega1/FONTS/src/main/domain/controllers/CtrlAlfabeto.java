package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;

import java.util.ArrayList;
import java.util.HashMap;

public class CtrlAlfabeto {

    // ---------- PARÁMETROS ----------

    private ConjuntoAlfabetos CjtAlfabetos;
    /**
     * Asigna un alfabeto y un cjt de alfabetos vacío
     */
    public CtrlAlfabeto(){
        CjtAlfabetos = null;
    }

    // ---------- FUNCIONES ALFABETO ----------
    /**
     * No retorna nada, manda a añadir el nuevo teclado al cjt de teclados vinculados
     */
    public void agregarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).agregarTecladoVinculado(nomT);
    }
    /**
     * No retorna nada, manda a borrar un teclado al cjt de teclados vinculados
     * @return true // trendría que ser return bool?
     */
    public void borrarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).borrarTecladoVinculado(nomT);
    }

    // ---------- FUNCIONES CONJUNTOALFABETOS ----------
    /**
     * Retorna el objecto cjt alfabetos pedido
     * @return ConjuntoAlfabetos : Un objeto cjt alfabetos concreto
     */
    public ConjuntoAlfabetos getCjtAlfabetos(){
        return CjtAlfabetos;
    }
    /**
     * No retorna nada.
     * Crea el nuevo objecto alfabeto y añade este objeto a ConjuntoAlfabetos
     */
    public boolean CrearAlfabeto(String nomA, ArrayList<Character> entradaCaracteres) {
        if(!CjtAlfabetos.existeAlfabeto(nomA)){
            Alfabeto alfabeto = new Alfabeto(nomA, entradaCaracteres);
            CjtAlfabetos.agregarAlfabeto(nomA, alfabeto);
            return true;
        }
        return false;
    }
    public boolean alfabetoTieneTecladosVinculados(String nomA){
        ArrayList<String> tVinculados = CjtAlfabetos.getAlfabeto(nomA).getTecladosVinculados();
        return !tVinculados.isEmpty();

    }
    public ArrayList<String> getTecladosVinculadosAlfabeto(String nomA){
        ArrayList<String> tVinculados = CjtAlfabetos.getAlfabeto(nomA).getTecladosVinculados();
        return tVinculados;

    }
    /**
     * No retorna nada.
     * Manda borrar el alfabeto dado, desvincula los teclados asociados
     * también borra este alfabeto de la lista de ConjuntoAlfabetos
     */
    public void borrarAlfabeto(String nomA){
        CjtAlfabetos.borrarAlfabeto(nomA);
    }
}