package main.domain.controllers;

import main.domain.classes.*;
import main.domain.classes.functions.InOut;
import main.domain.classes.types.PairInt;

import java.util.ArrayList;
import java.util.HashMap;

public class CtrlDominio {

    private CtrlAlfabeto ctrlAlfabeto;
    private CtrlTexto ctrlTexto;
    private CtrlAsociacionTexto ctrlAsociacionTexto;
    private CtrlTeclado ctrlTeclado;

    public CtrlDominio() {
        ctrlAlfabeto = new CtrlAlfabeto();
        ctrlTexto = new CtrlTexto();
        ctrlAsociacionTexto = new CtrlAsociacionTexto();
        ctrlTeclado = new CtrlTeclado();
    }

    // ---------- FUNCIONES ALFABETO ----------
    public boolean agregarAlfabeto(String nomA, ArrayList<Character> entradaCaracteres){
        return ctrlAlfabeto.CrearAlfabeto(nomA,entradaCaracteres);
    }
    public boolean alfabetoTieneTecladosVinculados(String nomA){
        return ctrlAlfabeto.alfabetoTieneTecladosVinculados(nomA);
    }
    public HashMap<String, Alfabeto> getListaAlfabetos(){
        return ctrlAlfabeto.getCjtAlfabetos().getAlfabetos();
    }
    public ArrayList<Character> consultarContenidoAlfabeto(String nomA){
        if(ctrlAlfabeto.getCjtAlfabetos().existeAlfabeto(nomA)) {
            return ctrlAlfabeto.getContenido(nomA);
        }
        return null;
        //return ctrlAlfabeto.getContenido(nomA);
    }
    public int numeroCaracteres(String nomA) {
        return ctrlAlfabeto.getCjtAlfabetos().getAlfabeto(nomA).getLetras().size();
    }

    //Para la segunda entrega
    /*public void borrarAlfabeto(String nomA){
        ArrayList<String> tVinculados = ctrlAlfabeto.getTecladosVinculadosAlfabeto(nomA);
        if(!tVinculados.isEmpty()) {
            for (int i = 0; i < tVinculados.size(); ++i){
                String atvinculada = ctrlTeclado.TecladoTieneAsociacionVinculada(tVinculados.get(i));
                ctrlAsociacionTexto.borrarTecladoVinculado(atvinculada,tVinculados.get(i));
                ctrlTeclado.borrarTeclado(tVinculados.get(i));
            }
        }
        ctrlAlfabeto.borrarAlfabeto(nomA);
    }*/


    // ---------- FUNCIONES TEXTO ----------
    public boolean agregarTextoPalabras(String nomT, String texto, HashMap<String, Integer> frecuenciasLetras){
        return ctrlTexto.agregarTextoPalabras(nomT, texto, frecuenciasLetras);
    }
    public boolean agregarTextoFrecuencias(String nomT, HashMap<String,Integer> frecuenciaPalabras, HashMap<String, Integer> frecuenciasLetras){
        return ctrlTexto.agregarTextoFrecuencias(nomT, frecuenciaPalabras, frecuenciasLetras);
    }
    public HashMap<String, Texto> getListaTextos(){
        return ctrlTexto.getTextos().getTextos();
    }

    public String consultarContenidoTexto(String nomT){
        return ctrlTexto.getContenido(nomT);
    }



    // ---------- FUNCIONES ASOCIACION TEXTOS ----------
    public boolean agregarAsociacion(String nomAT, ArrayList<String> textosagregar){
        if(ctrlAsociacionTexto.agregarAsociacion(nomAT)){
            agregarTextoAsociacion(nomAT,textosagregar);
            return true;
        }
        else return false;
    }
    public void agregarTextoAsociacion (String nomAT, ArrayList<String> textosagregar){
        for (String nomT : textosagregar) {
            ctrlTexto.agregarAsociacionVinculada(nomT,nomAT);
            Texto texto = ctrlTexto.getTexto(nomT);
            ctrlAsociacionTexto.agregarTextoAsociacion(nomAT, texto);
        }
    }
    public HashMap<String, AsociacionTextos> getListaAsociaciones(){
        return ctrlAsociacionTexto.getCjtAsociaciones().getAsociacionesTextos();
    }

    //Para la segunda entrega
    /*public boolean borrarTexto(String nomT){
        String avinculado = ctrlTeclado.TecladoTieneAlfabetoVinculado(tVinculados.get(i));
        return ctrlTexto.borrarTexto(nomT);
    }*/


    // ---------- FUNCIONES TECLADO ----------
    public boolean agregarTeclado(String nomT, String nomA, String nomAT, Algoritmo algoritmo, PairInt dimensiones){
        ctrlAlfabeto.agregarTecladoVinculado(nomA, nomT);
        ctrlAsociacionTexto.agregarTecladoVinculado(nomAT, nomA);
        Alfabeto alfabeto = ctrlAlfabeto.getCjtAlfabetos().getAlfabeto(nomA);
        AsociacionTextos asociacionTextos = ctrlAsociacionTexto.getCjtAsociaciones().getAsociacionTextos(nomAT);
        ctrlTeclado.agregarAlfabetoVinculado(nomT,nomA);
        ctrlTeclado.agregarAsociacionTextosVinculado(nomT,nomAT);
        return ctrlTeclado.CrearTeclado(nomT, asociacionTextos, alfabeto, algoritmo, dimensiones);
    }

    public ArrayList<String> getListaTeclados(){
        return ctrlTeclado.getCjtTeclados().getNombresTeclados();
    }

    //Para la segunda entrega
    /*public void borrarTeclado(String nomT) {
        String atvinculada = ctrlTeclado.TecladoTieneAsociacionVinculada(nomT);
        String aVinculado = ctrlTeclado.TecladoTieneAlfabetoVinculado(nomT);

        ctrlAsociacionTexto.borrarTecladoVinculado(atvinculada, nomT);
        ctrlAlfabeto.borrarTecladoVinculado(aVinculado, nomT);
        ctrlTeclado.borrarTeclado(nomT);
    }*/
}
