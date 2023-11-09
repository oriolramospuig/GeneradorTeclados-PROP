package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;

import java.util.ArrayList;

public class CtrlAlfabeto {

    // ---------- PARÁMETROS ----------
    /**
     * Parámetros de la clase Alfabeto y ConjuntoAlfabetos
     */
    private Alfabeto Alfabetoexistente;
    private ConjuntoAlfabetos CjtAlfabetos;

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
    }

    /**
     * No retorna nada, ,crea el nuevo objecto alfabeto
     * también se añade este objeto en ConjuntoAlfabetos
     */
    public void CrearAlfabeto(String nomAlfabeto){
        if(Alfabetoexistente == null){
            Alfabetoexistente = new Alfabeto(nomAlfabeto);
            agregarAlfabeto(nomAlfabeto, Alfabetoexistente);
        }
    }

    /**
     * No retorna nada, manda a añadir el nuevo teclado a
     */
    public void agregarAlfabeto(String nomA, Alfabeto alfabeto){
        CjtAlfabetos.agregarAlfabeto(String nomA, Alfabeto alfabeto);
    }

    // ---------- FALTA MIRAR BIEN ----------

    /**
     * No retorna nada, ,crea el nuevo objecto alfabeto
     * también se añade este objeto en ConjuntoAlfabetos
     */
    public void BorrarAlfabeto(String nomAlfabeto){
        //getcjtAlfabetos
        //getAlfabeto
        
        borrarAlfabeto(nomAlfabeto, Alfabetoexistente);
    }

    /**
     * No retorna nada, manda a añadir el nuevo teclado a
     */
    public void borrarAlfabeto(String nomA, Alfabeto alfabeto){
        CjtAlfabetos.agregarAlfabeto(String nomA, Alfabeto alfabeto);
    }

}
