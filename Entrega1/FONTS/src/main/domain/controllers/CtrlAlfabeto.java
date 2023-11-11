package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;

import java.util.ArrayList;
import java.util.HashMap;

public class CtrlAlfabeto {

    // ---------- PARÁMETROS ----------
    /**
     * Parámetros de la clase Alfabeto y ConjuntoAlfabetos
     */
    private Alfabeto Alfabetoexistente;
    private ConjuntoAlfabetos CjtAlfabetos;
    private ConjuntoTeclados CjtTeclados;

    /**
     * Asigna un alfabeto y un cjt de alfabetos vacío
     */
    public CtrlAlfabeto(){
        CjtAlfabetos = null;
    }

    // ---------- FUNCIONES ALFABETO ----------
    /**
     * Retorna el objecto alfabeto pedido
     * @return Alfabeto : Un objeto alfabeto concreto
     */
    public Alfabeto getAlfabetoexistente(){
        return Alfabetoexistente;
    }
    /**
     * No retorna nada, manda a añadir el nuevo teclado al cjt de teclados vinculados
     * @return true // trendría que ser return bool?
     */
    public void sobreEscribirLetras (String nomA,ArrayList<Character> nuevasLetras){
        CjtAlfabetos.getAlfabeto(nomA).sobreEscribirLetras(nuevasLetras);
    }
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
        CjtAlfabetos.getAlfabeto(nomA).agregarTecladoVinculado(nomT);
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
     * No retorna nada, ,crea el nuevo objecto alfabeto
     * también se añade este objeto en ConjuntoAlfabetos
     */
    public void CrearAlfabeto(String nomA){
        HashMap<String, Alfabeto> AlfabetosExistentes = CjtAlfabetos.getNombresAlfabetos();
        if(!AlfabetosExistentes.containsKey(nomA)){
            Alfabetoexistente = new Alfabeto (nomA);
            agregarAlfabeto(nomA, Alfabetoexistente);
        }
    }

    /**
     * No retorna nada, manda a añadir el nuevo teclado a
     */
    public void agregarAlfabeto(String nomA, Alfabeto alfabeto){
        CjtAlfabetos.agregarAlfabeto(nomA, alfabeto);
    }

    /**
     * No retorna nada, borra el objecto alfabeto
     * también desvincula los teclados asociados
     * también borra este objeto de ConjuntoAlfabetos
     */
    public void borrarAlfabeto(String nomA){ // borrar alfabeto sense nom primer
        HashMap<String, Alfabeto> AlfabetosExistentes = CjtAlfabetos.getNombresAlfabetos();
        // no existe
        // String nomAlf = CjtAlfabetos.borrarAlfabetoconcreto(); // crear funcio a cjt alfabetos
        if (CjtAlfabetos.existeAlfabeto(nomA)){ // crec que nomes hem de passar nom
            CjtAlfabetos.getAlfabeto(nomA);
            ArrayList<String> tVinculado = Alfabetoexistente.getTecladosVinculados();
            if(tVinculado.size() > 0) {
                // mostrar mensaje alerta
                // if usuario continua
                for (int i = 0; i < tVinculado.size(); ++i){
                    // no existeix encara
                    // CjtTeclados.invalidarteclado(tVinculado[i]);
                }
                CjtAlfabetos.borrarAlfabeto(nomA);
            }
        }
    }
}
