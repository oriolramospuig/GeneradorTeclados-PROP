package main.domain.controllers;

import main.domain.classes.Alfabeto;

public class CtrlAlfabeto {

    private Alfabeto Alfabetoexistente;

    public CtrlAlfabeto(){
        Alfabetoexistente = null;
    }

    public Alfabeto getAlfabetoexistente(){
        Alfabetoexistente = null;
        return Alfabetoexistente;
    }

    public void CrearAlfabeto(String nomAlfabeto){
        if(Alfabetoexistente == null){
            Alfabetoexistente = new Alfabeto(nomAlfabeto);
        }

    }


}
