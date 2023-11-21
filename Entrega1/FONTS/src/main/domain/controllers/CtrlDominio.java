package main.domain.controllers;

import main.domain.classes.*;
import main.domain.classes.functions.InOut;
import main.domain.classes.types.PairInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Este controlador se encarga de gestionar todos los métodos y distribuir las funciones a los respectivos controladores
 * @author
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
     * Retorna si se ha creado bien el alfabeto con el nombre y el contenido dados
     * @param nomA nombre alfabeto a crear
     * @param entradaCaracteres lista de caracteres del contenido del alfabeto
     * @return Boolean: true si se ha creado bien el alfabeto, false si no se ha creado bien
     */
    public boolean agregarAlfabeto(String nomA, ArrayList<Character> entradaCaracteres){
        return ctrlAlfabeto.CrearAlfabeto(nomA,entradaCaracteres);
    }

    /**
     * Retorna la lista de alfabetos existentes
     * @return HashMap<String, Alfabeto>: lista de alfabetos existentes ordenada por el nombre de alfabeto que es la clave primaria
     */
    public HashMap<String, Alfabeto> getListaAlfabetos(){
        return ctrlAlfabeto.getCjtAlfabetos().getAlfabetos();
    }

    /**
     * Retorna si existe el alfabeto con nomA
     * @param nomA el nombre del alfabeto a buscar
     * @return Boolean: true si existe el alfabeto con nomA, false si no existe
     */
    public boolean existealfabeto(String nomA){
        return ctrlAlfabeto.getCjtAlfabetos().existeAlfabeto(nomA);
    }

    /**
     * Retorna el contenido del alfabeto con nomA
     * @param nomA el nombre del alfabeto a buscar
     * @return ArrayList<Character>: una lista de caracteres del contenido del alfabeto con nombre nomA
     */
    public ArrayList<Character> consultarContenidoAlfabeto(String nomA){
        if(existealfabeto(nomA)) {
            return ctrlAlfabeto.getContenido(nomA);
        }
        return null;
    }

    /**
     * Retorna el numero de caracteres que tiene el contenido del alfabeto
     * @param nomA el nombre del alfabeto a buscar
     * @return int: el numero de caracteres que tiene el contenido del alfabeto con nombre nomA
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
     * Retorna si se ha creado bien el texto
     * @param nomT nombre del texto a crear
     * @param texto contenido del texto
     * @return Boolean: true si se ha agregado bien el texto, false si no se ha creado bien
     */
    public boolean agregarTextoPalabras(String nomT, String texto){
        return ctrlTexto.agregarTextoPalabras(nomT,texto);
    }

    /**
     * Retorna si se ha creado bien el texto
     * @param nomT nombre del texto a crear
     * @param frecuenciaPalabras contenido del texto
     * @return Boolean: true si se ha agregado bien el texto, false si no se ha creado bien
     */
    public boolean agregarTextoFrecuencias(String nomT, HashMap<String,Integer> frecuenciaPalabras){
        return ctrlTexto.agregarTextoFrecuencias(nomT,frecuenciaPalabras);
    }

    /**
     * Retorna la lista de textos existentes
     * @return HashMap<String, Texto>: lista de textos existentes ordenados por el nombre que es su clave primaria
     */
    public HashMap<String, Texto> getListaTextos(){
        return ctrlTexto.getTextos().getTextos();
    }

    /**
     * Retorna el contenido del texto con nombre nomT
     * @param nomT el nombre del texto a buscar
     * @return String: contenido del texto con nombre nomT
     */
    public String consultarContenidoTexto(String nomT){
        return ctrlTexto.getContenido(nomT);
    }

    /**
     * Retorna si existe el texto con nombre nomT
     * @param nomT elnombre del texto a buscar
     * @return Boolean: true si existe el texto con nombre nomT, false si no existe
     */
    public boolean existetexto(String nomT){
        return ctrlTexto.getTextos().existeTexto(nomT);
    }


    // ---------- FUNCIONES ASOCIACION TEXTOS ----------

    /**
     * Retorna si se ha creado bien la asociacion con nombre nomAT
     * @param nomAT el nombre de la asociacion a agregar
     * @param textosagregar la lista de nombres de los textos que forman la asociacion
     * @return Boolean: true si se ha creado bien la asociacion, false si no se ha creado bien
     */
    public boolean agregarAsociacion(String nomAT, ArrayList<String> textosagregar){
        if(ctrlAsociacionTexto.agregarAsociacion(nomAT)){
            agregarTextoAsociacion(nomAT,textosagregar);
            return true;
        }
        else return false;
    }

    /**
     * No retorna
     * @param nomAT nombre de la asociacion donde añadir el texto
     * @param textosagregar lista de los nombres de los textos a añadir en la asociacion
     */
    public void agregarTextoAsociacion (String nomAT, ArrayList<String> textosagregar){
        for (String nomT : textosagregar) {
            ctrlTexto.agregarAsociacionVinculada(nomT,nomAT);
            Texto texto = ctrlTexto.getTexto(nomT);
            ctrlAsociacionTexto.agregarTextoAsociacion(nomAT, texto);
        }
    }

    /**
     * Retorna la lista de asociaciones existentes
     * @return HashMap<String, AsociacionTextos>: lista de asociaciones ordenada por nombres que son las claves primarias de las asociaciones
     */
    public HashMap<String, AsociacionTextos> getListaAsociaciones(){
        return ctrlAsociacionTexto.getCjtAsociaciones().getAsociacionesTextos();
    }

    /**
     * Retorna si existe la asociacion con nombre nomAT
     * @param nomAT nombre de la asociacion a buscar
     * @return Boolean: true si se ha encontrado la asociacion, false si no se ha encontrado
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
     * Retorna si el alfabeto y la asociacion de textos tiene caracteres parecidos y por lo tanto son compatibles
     * @param alfabeto objeto alfabeto para comparar
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
            ctrlTeclado.agregarAlfabetoVinculado(nomT,nomA);
            ctrlTeclado.agregarAsociacionTextosVinculado(nomT,nomAT);
            ctrlTeclado.CrearTeclado(nomT, asociacionTextos, alfabeto);
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
