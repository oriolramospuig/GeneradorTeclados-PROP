package main.domain.controllers;

import main.domain.classes.*;
import main.domain.classes.functions.InOut;
import main.domain.classes.types.PairInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Este controlador se encarga de gestionar todos los métodos y distribuir las funciones a los respectivos controladores
 * @author Alexia
 */
public class CtrlDominio
{
    /** Crea una instancia del controlador alfabeto */
    private CtrlAlfabeto ctrlAlfabeto;

    /** Crea una instancia del controlador texto */
    private CtrlTexto ctrlTexto;

    /** Crea una instancia del controlador asociación de texto */
    private CtrlAsociacionTexto ctrlAsociacionTexto;

    /** Crea una instancia del controlador teclado */
    private CtrlTeclado ctrlTeclado;


    // ---------- CONSTRUCTORAS ----------
    /** Inicialización de la instancia controlador dominio */
    public CtrlDominio() {
        ctrlAlfabeto = new CtrlAlfabeto();
        ctrlTexto = new CtrlTexto();
        ctrlAsociacionTexto = new CtrlAsociacionTexto();
        ctrlTeclado = new CtrlTeclado();
    }


    // ---------- FUNCIONES ALFABETO ----------

    /**
     *
     * @param nomA
     * @param entradaCaracteres
     * @return
     */
    public boolean agregarAlfabeto(String nomA, ArrayList<Character> entradaCaracteres){
        return ctrlAlfabeto.CrearAlfabeto(nomA,entradaCaracteres);
    }

    /**
     *
     * @return
     */
    public HashMap<String, Alfabeto> getListaAlfabetos(){
        return ctrlAlfabeto.getCjtAlfabetos().getAlfabetos();
    }

    /**
     *
     * @param nomA
     * @return
     */
    public boolean existealfabeto(String nomA){
        return ctrlAlfabeto.getCjtAlfabetos().existeAlfabeto(nomA);
    }

    /**
     *
     * @param nomA
     * @return
     */
    public ArrayList<Character> consultarContenidoAlfabeto(String nomA){
        if(existealfabeto(nomA)) {
            return ctrlAlfabeto.getContenido(nomA);
        }
        return null;
    }

    /**
     *
     * @param nomA
     * @return
     */
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
    }

    public boolean alfabetoTieneTecladosVinculados(String nomA){
        return ctrlAlfabeto.alfabetoTieneTecladosVinculados(nomA);
    }
    */


    // ---------- FUNCIONES TEXTO ----------

    /**
     *
     * @param nomT
     * @param texto
     * @return
     */
    public boolean agregarTextoPalabras(String nomT, String texto){
        return ctrlTexto.agregarTextoPalabras(nomT,texto);
    }

    /**
     *
     * @param nomT
     * @param frecuenciaPalabras
     * @return
     */
    public boolean agregarTextoFrecuencias(String nomT, HashMap<String,Integer> frecuenciaPalabras){
        return ctrlTexto.agregarTextoFrecuencias(nomT,frecuenciaPalabras);
    }

    /**
     *
     * @return
     */
    public HashMap<String, Texto> getListaTextos(){
        return ctrlTexto.getTextos().getTextos();
    }

    /**
     *
     * @param nomT
     * @return
     */
    public String consultarContenidoTexto(String nomT){
        return ctrlTexto.getContenido(nomT);
    }

    /**
     *
     * @param nomT
     * @return
     */
    public boolean existetexto(String nomT){
        return ctrlTexto.getTextos().existeTexto(nomT);
    }


    // ---------- FUNCIONES ASOCIACION TEXTOS ----------

    /**
     *
     * @param nomAT
     * @param textosagregar
     * @return
     */
    public boolean agregarAsociacion(String nomAT, ArrayList<String> textosagregar){
        if(ctrlAsociacionTexto.agregarAsociacion(nomAT)){
            agregarTextoAsociacion(nomAT,textosagregar);
            return true;
        }
        else return false;
    }

    /**
     *
     * @param nomAT
     * @param textosagregar
     */
    public void agregarTextoAsociacion (String nomAT, ArrayList<String> textosagregar){
        for (String nomT : textosagregar) {
            ctrlTexto.agregarAsociacionVinculada(nomT,nomAT);
            Texto texto = ctrlTexto.getTexto(nomT);
            ctrlAsociacionTexto.agregarTextoAsociacion(nomAT, texto);
        }
    }

    /**
     *
     * @return
     */
    public HashMap<String, AsociacionTextos> getListaAsociaciones(){
        return ctrlAsociacionTexto.getCjtAsociaciones().getAsociacionesTextos();
    }

    /**
     *
     * @param nomAT
     * @return
     */
    public boolean existeasociacion(String nomAT){
        return ctrlAsociacionTexto.getCjtAsociaciones().existeAsociaciondeTextos(nomAT);
    }

    //Para la segunda entrega
    /*public boolean borrarTexto(String nomT){
        String avinculado = ctrlTeclado.TecladoTieneAlfabetoVinculado(tVinculados.get(i));
        return ctrlTexto.borrarTexto(nomT);
    }*/


    // ---------- FUNCIONES TECLADO ----------

    /**
     *
     * @param alfabeto
     * @param asociacionTextos
     * @return
     */
    public boolean compatibles(Alfabeto alfabeto,AsociacionTextos asociacionTextos){
        HashMap<String,Integer> f = asociacionTextos.getFrecuenciaLetras();
        ArrayList<Character> a = alfabeto.getLetras();
        for(HashMap.Entry<String,Integer> e : f.entrySet()){
            Character c1 = e.getKey().charAt(0);
            Character c2 = e.getKey().charAt(1);
            if(!a.contains(c1) || !a.contains(c2)) return false;
        }
        return true;
    }

    /**
     *
     * @param nomT
     * @param nomA
     * @param nomAT
     * @return
     */
    public int agregarTeclado(String nomT, String nomA, String nomAT){
        if(ctrlTeclado.existeTeclado(nomT)) return -1;
        
        Alfabeto alfabeto = ctrlAlfabeto.getCjtAlfabetos().getAlfabeto(nomA);
        AsociacionTextos asociacionTextos = ctrlAsociacionTexto.getCjtAsociaciones().getAsociacionTextos(nomAT);
        if(compatibles(alfabeto,asociacionTextos)) {
            ctrlAlfabeto.agregarTecladoVinculado(nomA, nomT);
            ctrlAsociacionTexto.agregarTecladoVinculado(nomAT, nomA);
            ctrlTeclado.CrearTeclado(nomT, asociacionTextos, alfabeto);
            ctrlTeclado.agregarAlfabetoVinculado(nomT,nomA);
            ctrlTeclado.agregarAsociacionTextosVinculado(nomT,nomAT);
            return 0;
        }
        else return -2;
    }

    /**
     * 
     * @return
     */
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
