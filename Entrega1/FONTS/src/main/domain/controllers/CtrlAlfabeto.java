package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;

import java.util.ArrayList;

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
        Alfabetoexistente = null;
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
    /**
     * @param nuevasLetras
    public void sobreEscribirLetras (ArrayList<Character> nuevasLetras){
        Alfabetoexistente.sobreEscribirLetras(nuevasLetras);
    }*/

    /**
     * No retorna nada, manda a añadir el nuevo teclado al cjt de teclados vinculados
     */
    public void agregarTecladoVinculado (String nomT){
        Alfabetoexistente.agregarTecladoVinculado(nomT);
    }
    /**
     * No retorna nada, manda a borrar un teclado al cjt de teclados vinculados
     * @return true // trendría que ser return bool?
     */
    public void borrarTecladoVinculado (String nomT){
        Alfabetoexistente.borrarTecladoVinculado(nomT);
    }

    // ---------- FUNCIONES CONJUNTOALFABETOS ----------

    /**
     * Retorna el objecto cjt alfabetos pedido
     * @return ConjuntoAlfabetos : Un objeto cjt alfabetos concreto
     */
    public ConjuntoAlfabetos getCjtAlfabetos(){
        return CjtAlfabetos;
        Alfabetoexistente = null;
        return Alfabetoexistente;
    }

    /**
     * No retorna nada, ,crea el nuevo objecto alfabeto
     * también se añade este objeto en ConjuntoAlfabetos
     */
    public void CrearAlfabeto(String nomA){
        if(Alfabetoexistente == null){
            //informar formado y contenido
            if(CjtAlfabetos.disponibilidadNombre(nomA)){
                Alfabetoexistente = new Alfabeto (nomAlfabeto);
                agregarAlfabeto(nomAlfabeto, Alfabetoexistente);
            }
            //else informar usuario
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
        CjtAlfabetos.mostrarAlfabetos();
        String nomA = CjtAlfabetos.borrarAlfabetoconcreto(); // crear funcio a cjt alfabetos
        if (CjtAlfabetos.existeAlfabeto(nomA, alfabeto)){ // crec que nomes hem de passar nom
            CjtAlfabetos.getAlfabeto(nomA);
            ArrayList<String> tVinculado = Alfabetoexistente.getTecladosVinculados();
            if(tVinculado.size() > 0) {
                // mostrar mensaje alerta
                // if usuario continua
                for (int i = 0; i < tVinculado.size(); ++i){
                    CjtTeclados.invalidarteclado(tVinculado[i]);
                }
                CjtAlfabetos.borrarAlfabeto(nomA, Alfabetoexistente);
            }
        }
    }
}
