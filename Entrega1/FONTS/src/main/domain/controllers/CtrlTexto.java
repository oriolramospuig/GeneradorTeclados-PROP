package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.Texto;
import main.domain.classes.ConjuntoTextos;
import main.domain.classes.ConjuntoTeclados;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar i borrar alfabetos
 * Los alfabetos existentes quedarán dentro de un ...
 *
 */
public class CtrlTexto {

    // ---------- PARÁMETROS ----------
    /**
     * Parámetros de la clase Alfabeto y ConjuntoAlfabetos
     */
    private Texto TextoExistente;
    private ConjuntoTextos CjtTextos;
    private ConjuntoTeclados CjtTeclados;

    /**
     * Asigna un alfabeto y un cjt de alfabetos vacío
     */
    public CtrlTexto(){
        CjtTextos = null;
        TextoExistente = null;
    }

    // ---------- FUNCIONES ALFABETO ----------
    /**
     * Retorna el objecto alfabeto pedido
     * @return Alfabeto : Un objeto alfabeto concreto
     */
    public Texto getTextoexistente(){
        return TextoExistente;
    }

    /**
     * No retorna nada, manda a añadir el nuevo teclado al cjt de teclados vinculados
     */
    public void agregarTecladoVinculado (String nomTxt, String nomT){
        //CjtTextos.getTexto(nomTxt).agregarTecladoVinculado(nomT);
    }
    /**
     * No retorna nada, manda a borrar un teclado al cjt de teclados vinculados
     * @return true // trendría que ser return bool?
     */
    public void borrarTecladoVinculado (String nomT){
        //Alfabetoexistente.borrarTecladoVinculado(nomT);
    }



}
