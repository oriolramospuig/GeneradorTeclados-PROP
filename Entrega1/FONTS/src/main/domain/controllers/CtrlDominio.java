package main.domain.controllers;

import main.domain.classes.*;
import main.domain.classes.config.Configuracion;
import main.persistence.controllers.CtrlPersistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Este controlador se encarga de gestionar todos los métodos y distribuir las funciones a los respectivos controladores
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
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

    private final CtrlPersistencia ctrlPersistencia;

    private Configuracion configuracion;


    // ---------- CONSTRUCTORAS ----------
    /** Inicialización de la instancia controlador dominio */
    public CtrlDominio() {
        ctrlAlfabeto = new CtrlAlfabeto();
        ctrlTexto = new CtrlTexto();
        ctrlAsociacionTexto = new CtrlAsociacionTexto();
        ctrlTeclado = new CtrlTeclado();
        ctrlPersistencia = new CtrlPersistencia();
        //cargar configuracion alfabetos de capa de persistencia
        if (ctrlPersistencia.existeCongigAlfabetos()) {
            try {
                byte[] bytes = ctrlPersistencia.cargaConfigAlfabetos();
                ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
                ObjectInputStream is = new ObjectInputStream(bs);
                configuracion = (Configuracion) is.readObject();
                is.close();
            } catch (InvalidClassException e) {
                System.err.println("HANDLEABLE EXCEPTION -> CLASS VERSION MISMATCH");
                System.err.println("Regenerating configAlfabetos.cdp file");
                if (!ctrlPersistencia.borraConfigAlfabeto()) {
                    System.err.println("Could not handle exception! Quitting.");
                    System.err.println(Thread.currentThread().getStackTrace().toString());
                    System.exit(-100);
                }
                configuracion = new Configuracion();
                System.err.println("SUCCESS -> Exception handled!");
            } catch (Exception e) {
                System.err.println("HANDLEABLE EXCEPTION -> Exception when trying to write/create configuration file! E: "
                        + e.getMessage());
                System.err.println("Regenerating configAlfabetos.cdp file");
                if (!ctrlPersistencia.borraConfigAlfabeto()) {
                    System.err.println("Could not handle exception! Quitting.");
                    System.err.println(Thread.currentThread().getStackTrace().toString());
                    System.exit(-100);
                }
                configuracion = new Configuracion();
                System.err.println("SUCCESS -> Exception handled!");
            }
        }
        else {
            configuracion = new Configuracion();
        }
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
     * Retorna la lista de nombres de los alfabetos existentes
     * @return ArrayList<String>: lista de alfabetos existentes ordenada por el nombre de alfabeto que es la clave primaria
     */
    public ArrayList<String> getNombresAlfabetos(){
        return ctrlAlfabeto.getNombresAlfabetos();
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
    /**
     * No retorna
     * @param nomA el nombre del alfabeto a borrar
     * Borra el alfabeto con nombre nomA
     * También borra en cascada los teclados que tenia vinculados
     * Y desvincula las asociaciones de textos vinculadas a estos teclados borrados
     */
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
     * Retorna la lista de nombres de los textos existentes
     * @return ArrayList<String>: lista de textos existentes ordenada por el nombre de texto que es la clave primaria
     */
    public ArrayList<String> getNombresTextos(){
        return ctrlTexto.getNombresTextos();
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
    /**
     * Retorna si el texto nomT ha sido borrado correctamente
     * @param nomT el nombre del texto a borrar
     * Borra el texto con nombre nomT
     * También se desvincula de las asociaciones en las que estaba
     */
    public void borrarTexto(String nomT){
        ArrayList<String> AVinculadas = CtrlTexto.getAsociacionesVinculadasTexto(nomT);
        if(!AVinculadas.isEmpty()) {
            for (int i = 0; i < AVinculadas.size(); ++i){
                CtrlAsociacionTexto.borrarTextoAsociacion(AVinculadas.get(i),nomT);
            }
            CtrlTexto.borrarTexto(nomT);
        }
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
     * Retorna la lista de nombres de las asociaciones existentes
     * @return ArrayList<String>: lista de asociaciones existentes ordenada por el nombre de la asociación que es la clave primaria
     */
    public ArrayList<String> getNombresAsociaciones(){
        return ctrlAsociacionTexto.getNombresAsociaciones();
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

    /**
     * Retorna si la asociación con nombre nomAT ha sido borrada correctamente
     * @param nomAT el nombre del texto a borrar
     * Borra el texto con nombre nomT
     * También se desvincula de las asociaciones en las que estaba
     */
    /*public boolean borrarAsociacionTextos(String nomAT){
        //String avinculado = ctrlTeclado.TecladoTieneAlfabetoVinculado(tVinculados.get(i));
        //return ctrlTexto.borrarTexto(nomT);
        return false;
    }*/
    public void borrarAsociacionTextos(String nomAT){
        ArrayList<String> tVinculados = ctrlAsociacionTexto.getTecladosVinculadosAsociacion(nomAT);
        if(!tVinculados.isEmpty()) {
            for (int i = 0; i < tVinculados.size(); ++i){
                String avinculado = ctrlTeclado.TecladoTieneAlfabetoVinculado(tVinculados.get(i));
                ctrlAlfabeto.borrarTecladoVinculado(avinculado,tVinculados.get(i));
                ctrlTeclado.borrarTeclado(tVinculados.get(i));
            }
        }
        ctrlAsociacionTexto.borrarAsociacionTextos(nomAT);
    }


    // ---------- FUNCIONES TECLADO ----------

    /**
     * Retorna si el alfabeto y la asociacion de textos tiene caracteres parecidos y por lo tanto son compatibles
     * @param alfabeto objeto alfabeto para comparar
     * @param asociacionTextos objeto asociacion de textos para comparar
     * @return Boolean: true si el alfabeto y la asociación de textos son comptibles, false si no lo son
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
     * Retorna un valor para comprobar si el teclado ha sido agregado correctamente o ha habido algún fallo
     * @param nomT nombre del teclado a agregar
     * @param nomA nombre del alfabeto a vincular con el teclado nomT
     * @param nomAT nombre de la asociación de textos a vincular con el teclado nomT
     * @return Integer: 0 si se ha creado correctamente el teclado,
     * -1 si el nombre nomT ya existe en otro teclado
     * -2 si el alfabeto y la asociación de textos elegidos no son compatibles
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
     * Retorna el contenido del teclado nomT
     * @param nomT nombre del teclado a consultar
     * @return char[][]: la matriz que representa el contenido del teclado nomT
     */
    public char[][] consultarContenidoTeclado(String nomT){
        if(ctrlTeclado.existeTeclado(nomT)) {
            return ctrlTeclado.getContenido(nomT);
        }
        return null;
    }

    /**
     * Retorna el nombre del alfabeto asociado al teclado con nombre nomT
     * @param nomT nombre del teclado a buscar
     * @return String: nombre del alfabeto vinculado al teclado nomT
     */
    public String consultarAlfabetoAsociadoTeclado(String nomT) {
        if(ctrlTeclado.existeTeclado(nomT)) {
            return ctrlTeclado.getAlfabeto(nomT);
        }
        return null;
    }


    /**
     * Retorna el nombre de la asociación de textos asociada al teclado nomT
     * @param nomT nombre del teclado a buscar
     * @return String: nombre de la asociación vinculada al teclado nomT
     */
    public String consultarAsociacionAsociadoTeclado(String nomT) {
        if(ctrlTeclado.existeTeclado(nomT)) {
            return ctrlTeclado.getAsociacion(nomT);
        }
        return null;
    }

    /**
     * Retorna la lista de teclados existentes
     * @return ArrayList<String>: lista de nombres de los teclados existentes
     */
    public ArrayList<String> getListaTeclados(){
        return ctrlTeclado.getCjtTeclados().getNombresTeclados();
    }

    /**
     * No retorna
     * @param nomT el nombre del teclado a borrar
     * Borra el teclado con nombre nomT
     * También desvincula el alfabeto y la asociación de textos que tenía vinculados
     */
    public void borrarTeclado(String nomT) {
        String atvinculada = ctrlTeclado.TecladoTieneAsociacionVinculada(nomT);
        String aVinculado = ctrlTeclado.TecladoTieneAlfabetoVinculado(nomT);

        ctrlAsociacionTexto.borrarTecladoVinculado(atvinculada, nomT);
        ctrlAlfabeto.borrarTecladoVinculado(aVinculado, nomT);
        ctrlTeclado.borrarTeclado(nomT);
    }


    // ---------- FUNCIONES PERSISTENCIA CONFIGURACIÓN ----------
    /**
     * Guarda el objeto Configuracion configuracion en un fichero usando el CtrlPersistencia
     */
    public void guardaConfigAlfabetos() {
        try {
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bs);
            os.writeObject(configuracion);
            os.close();
            byte[] bytes = bs.toByteArray();
            ctrlPersistencia.guardaConfigAlfabetos(bytes);
        } catch (IOException e) {
            System.err.println(
                    "RUNTIME UNHANDLED EXCEPTION -> IOException when trying to save config file! E: " + e.toString());
            Thread.currentThread().getStackTrace();
            System.exit(-102);
        }
    }

    /**
     * LA HAREMOS MÁS TARDE!!!
     * Converteix les dades de Configuracio _config a una matriu de String per poder compartir-les entre capes
     public Vector<Vector<String>> obtenirConfig() {
     return _config.simplify();
     } */

    // ---------- FUNCIONES PERSISTENCIA ALFABETOS ----------
    public void guardaCnjtAlfabetos() {
        String nomDoc = "conjuntoAlfabetos";
        //if(nomDoc.endsWith(".prop")) { nomDoc = nomDoc+".prop"; }
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory+"\\Entrega1\\data\\Cache\\"+nomDoc+"\\";
        try {
            byte[] bytes = ctrlAlfabeto.alfabetosToByteArray();
            ctrlPersistencia.guardaCnjtAlfabetos(bytes,path);
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de alfabetos" + e.getMessage());
            Thread.currentThread().getStackTrace();
            System.exit(-102);
        }
        //configuracion.añadirCnjtAlfabetos(nomDoc, path);
        //guardaConfigAlfabetos();
    }

    public void cargaCnjtAlfabetos(String path) {
        try {
            byte[] bytes = ctrlPersistencia.cargaCnjtAlfabetos(path);
            CtrlAlfabeto.byteArrayToAlfabetos(bytes);
        } catch (Exception e) {
            System.err.println("[#CARGA] Error al cargar el conjunto de alfabetos" + e.getMessage());
        }
    }

    // ---------- FUNCIONES PERSISTENCIA TEXTOS ----------
    public void guardaCnjtTextos() {}

    public void cargaCnjtTextos() {}


    // ---------- FUNCIONES PERSISTENCIA ASOCIACIONES TEXTOS ----------


    // ---------- FUNCIONES PERSISTENCIA TECLADOS ----------


}
