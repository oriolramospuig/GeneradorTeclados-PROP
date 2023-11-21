package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;

import java.util.ArrayList;
import java.util.HashMap;

public class CtrlAlfabeto {

    // ---------- PARÁMETROS ----------

    private ConjuntoAlfabetos CjtAlfabetos;

    public CtrlAlfabeto(){
        CjtAlfabetos = new ConjuntoAlfabetos();
    }

    // ---------- FUNCIONES ALFABETO ----------

    public ArrayList<Character> getContenido(String nomA){
        return CjtAlfabetos.getAlfabeto(nomA).getLetras();
    }
    /**
     * No retorna nada, manda a añadir el nuevo teclado al cjt de teclados vinculados
     */
    public void agregarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).agregarTecladoVinculado(nomT);
    }


    //Para la segunda entrega
    /*public void borrarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).borrarTecladoVinculado(nomT);
    }*/

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