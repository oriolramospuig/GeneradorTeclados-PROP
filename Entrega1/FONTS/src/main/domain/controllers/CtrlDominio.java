package main.domain.controllers;

import main.domain.classes.*;
import main.domain.classes.functions.InOut;

import java.util.ArrayList;
import java.util.HashMap;

public class CtrlDominio {

    private CtrlAlfabeto ctrlAlfabeto;
    private CtrlAsociacionTexto ctrlAsociacionTexto;
    private CtrlTexto ctrlTexto;
    private CtrlTeclado ctrlTeclado;

    public CtrlDominio() {
        ctrlAlfabeto = new CtrlAlfabeto();
        ctrlTexto = new CtrlTexto();
        ctrlTeclado = new CtrlTeclado();
    }

    // ---------- FUNCIONES ALFABETO ----------
    public boolean agregarAlfabeto(String nomA, ArrayList<Character> entradaCaracteres){
        return ctrlAlfabeto.CrearAlfabeto(nomA,entradaCaracteres);
    }
    public boolean alfabetoTieneTecladosVinculados(String nomA){
        return ctrlAlfabeto.alfabetoTieneTecladosVinculados(nomA);
    }
    public void borrarAlfabeto(String nomA){
        ArrayList<String> tVinculados = ctrlAlfabeto.getTecladosVinculadosAlfabeto(nomA);
        if(!tVinculados.isEmpty()) {
            for (int i = 0; i < tVinculados.size(); ++i){
                String atvinculada = ctrlTeclado.TecladoTieneAsociacionVinculada(tVinculados.get(i));
                ctrlAsociacionTexto.borrarTecladoVinculado(atvinculada,tVinculados.get(i));
                ctrlTeclado.borrarTeclado(tVinculados.get(i));
            }
        }
        ctrlAlfabeto.borrarAlfabeto(nomA);
    }
    public HashMap<String, Alfabeto> getListaAlfabetos(){
        return ctrlAlfabeto.getCjtAlfabetos().getAlfabetos();
    }

    // ---------- FUNCIONES TEXTO ----------
    public boolean agregarTexto(String nomT, HashMap<String, Integer> frecuenciasLetras){
        return ctrlTexto.agregarTexto(nomT,frecuenciasLetras);
    }

    public boolean borrarTexto(String nomT){
        //Verifica que la entrada de caracteres es válida.
        //return ctrlTexto.borrarTexto(nomT);
        return false;
    }
    //String avinculado = ctrlTeclado.TecladoTieneAlfabetoVinculado(tVinculados.get(i));

    // ---------- FUNCIONES TECLADO ----------
    public boolean agregarTeclado(String nomT, String nomA, String nomAT, Algoritmo algoritmo, PairIntEnum dimensiones){
        ctrlAlfabeto.agregarTecladoVinculado(nomA, nomT);
        ctrlAsociacionTexto.agregarTecladoVinculado(nomAT, nomA);
        Alfabeto alfabeto = ctrlAlfabeto.getCjtAlfabetos().getAlfabeto(nomA);
        AsociacionTextos asociacionTextos = ctrlAsociacionTexto.getCjtAsociaciones().getAsociacionTextos(nomAT);
        return ctrlTeclado.CrearTeclado(nomT, asociacionTextos, alfabeto, algoritmo, dimensiones);
    }

    public ArrayList<String> getListaTeclados(){
        return ctrlTeclado.getCjtTeclados().getNombresTeclados();
    }

    public void borrarTeclado(String nomT) {
        String atvinculada = ctrlTeclado.TecladoTieneAsociacionVinculada(nomT);
        String aVinculado = ctrlTeclado.TecladoTieneAlfabetoVinculado(nomT);

        ctrlAsociacionTexto.borrarTecladoVinculado(atvinculada, nomT);
        ctrlAlfabeto.borrarTecladoVinculado(aVinculado, nomT);
        ctrlTeclado.borrarTeclado(nomT);
    }
}
