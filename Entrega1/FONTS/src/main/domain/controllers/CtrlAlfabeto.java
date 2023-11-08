package main.domain.controllers;

import main.domain.classes.Alfabeto;

public class CtrlAlfabeto {

    private Alfabeto Alfabetoexistente;



    public CtrlAlfabeto(){
        Alfabetoexistente = null;
    }

    public Alfabeto getAlfabetoexistente(){
        Alfabetoexistente = null;
    }


    public void CrearAlfabeto(){
        if(Alfabetoexistente == null){
            Alfabetoexistente = new Alfabeto();
        }

    }


}
