package main.domain.controllers;

import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;
import main.domain.classes.ConjuntoTextos;
import main.domain.classes.functions.InOut;

import java.util.ArrayList;

public class CtrlDominio {

    private CtrlAlfabeto ctrlAlfabeto;
    private CtrlTexto ctrlTexto;
    private CtrlTeclado ctrlTeclado;

    public CtrlDominio() {
        ctrlAlfabeto = new CtrlAlfabeto();
        ctrlTexto = new CtrlTexto();
        ctrlTeclado = new CtrlTeclado();
    }

    // ---------- FUNCIONES ALFABETO ----------
    public boolean agregarAlfabeto(String nomA, ArrayList<Character> entradaCaracteres){
        //Verifica que la entrada de caracteres es válida.
        return ctrlAlfabeto.CrearAlfabeto(nomA,entradaCaracteres);
    }
    public boolean alfabetoTieneTecladosVinculados(String nomA){
        return ctrlAlfabeto.alfabetoTieneTecladosVinculados(nomA);
    }

    public void borrarAlfabeto(String nomA){
        ArrayList<String> tVinculados = ctrlAlfabeto.getTecladosVinculadosAlfabeto(nomA);
        if(!tVinculados.isEmpty()) {
            for (int i = 0; i < tVinculados.size(); ++i){
                ctrlTeclado.borrarTeclado(tVinculados.get(i));
            }
        }
        //Verifica que la entrada de caracteres es válida.
        ctrlAlfabeto.borrarAlfabeto(nomA);
    }

    // ---------- FUNCIONES TEXTO ----------
    public boolean agregarTexto(String nomT, String frecuenciasLetras){
        //Verifica que la entrada de caracteres es válida.
        return ctrlTexto.agregarTexto(nomT,frecuenciasLetras);
    }

    public boolean borrarTexto(String nomT){
        //Verifica que la entrada de caracteres es válida.
        //return ctrlTexto.borrarTexto(nomT);
        return false;
    }

    // ---------- FUNCIONES TECLADO ----------
}
