package main.domain.controllers;

import drivers.InOut;
import main.domain.classes.*;
import main.domain.classes.types.PairInt;
import main.persistence.controllers.CtrlPersistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Este controlador se encarga de gestionar todos los métodos y distribuir las funciones a los respectivos controladores.
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu) y Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class CtrlDominio
{
    /** Crea una instancia del controlador alfabeto. */
    private static CtrlAlfabeto ctrlAlfabeto;

    /** Crea una instancia del controlador texto. */
    private static CtrlTexto ctrlTexto;

    /** Crea una instancia del controlador asociación de texto. */
    private CtrlAsociacionTexto ctrlAsociacionTexto;

    /** Crea una instancia del controlador teclado. */
    private CtrlTeclado ctrlTeclado;

    /** Crea una instancia del controlador de persistencia. */
    private static CtrlPersistencia ctrlPersistencia;


    // ---------- CONSTRUCTORAS ----------
    /** Inicialización de la instancia controlador dominio. */
    public CtrlDominio() {
        ctrlAlfabeto = new CtrlAlfabeto();
        ctrlTexto = new CtrlTexto();
        ctrlAsociacionTexto = new CtrlAsociacionTexto();
        ctrlTeclado = new CtrlTeclado();
        ctrlPersistencia = new CtrlPersistencia();
        //cargar alfabetos, textos, asociaciones y teclados de capa de persistencia
        String currentDirectory = System.getProperty("user.dir");
        File currentDir = new File(currentDirectory);
        File rootDir = currentDir.getParentFile().getParentFile().getParentFile();
        String rootPath = rootDir.getAbsolutePath(); // para makefile
        cargaCnjtAlfabetos(currentDirectory+"//Entrega3//data//Cache//"+"conjuntoAlfabetos"+"//");
        cargaCnjtTextos(currentDirectory+"//Entrega3//data//Cache//"+"conjuntoTextos"+"//");
        cargaCnjtAsociaciones(currentDirectory+"//Entrega3//data//Cache//"+"conjuntoAsociaciones"+"//");
        cargaCnjtTeclados(currentDirectory+"//Entrega3//data//Cache//"+"conjuntoTeclados"+"//");
    }


    // ---------- FUNCIONES ALFABETO ----------
    /**
     * Retorna si se ha creado bien el alfabeto con el nombre y el contenido dados.
     * @param nomA clave única y nombre del alfabeto a agregar.
     * @param entradaCaracteres lista de carácteres que forman el contenido del alfabeto.
     * @return Boolean: true si se ha agregado bien el alfabeto, false si no se ha agregado bien.
     */
    public static boolean agregarAlfabeto(String nomA, ArrayList<Character> entradaCaracteres){
        return ctrlAlfabeto.CrearAlfabeto(nomA,entradaCaracteres);
    }

    /**
     * Retorna la lista de nombres de los alfabetos existentes en el conjunto.
     * @return ArrayList<String>: lista de nombres de los alfabetos existentes ordenada por el nombre de alfabeto que es la clave única.
     */
    public ArrayList<String> getNombresAlfabetos(){
        return ctrlAlfabeto.getNombresAlfabetos();
    }

    /**
     * Retorna si existe el alfabeto con nombre nomA.
     * @param nomA clave única y nombre del alfabeto a buscar.
     * @return Boolean: true si existe el alfabeto con nomA, false si no existe.
     */
    public boolean existealfabeto(String nomA){
        return ctrlAlfabeto.getCjtAlfabetos().existeAlfabeto(nomA);
    }

    /**
     * Retorna el contenido del alfabeto con nomA.
     * @param nomA clave única y nombre del alfabeto a buscar.
     * @return ArrayList<Character>: una lista de carácteres que forma el contenido del alfabeto con nombre nomA.
     */
    public ArrayList<Character> consultarContenidoAlfabeto(String nomA){
        if(existealfabeto(nomA)) {
            return ctrlAlfabeto.getContenido(nomA);
        }
        return null;
    }

    /**
     * No devuelve nada.
     * @param nomA clave única y nombre del alfabeto a borrar.
     * @param entrada lista de carácteres que forman el nuevo contenido del alfabeto con nomA.
     * Modifica el contenido del alfabeto con nombre nomA actualizando la lista de carácteres con la nueva lista que ha entrado el usuario.
     */
    public void modificarContenidoAlfabeto(String nomA, ArrayList<Character> entrada){
        if (existealfabeto(nomA)) {
            ctrlAlfabeto.modificarContenido(nomA, entrada);
            ArrayList<String> tecV = ctrlAlfabeto.getCjtAlfabetos().getAlfabeto(nomA).getTecladosVinculados();
            for (int j = 0; j < tecV.size(); ++j) {
                Teclado t = ctrlTeclado.getCjtTeclados().getTeclado(tecV.get(j));
                AsociacionTextos at = ctrlAsociacionTexto.getCjtAsociaciones().getAsociacionTextos(ctrlTeclado.getAsociacion(t.getNombre()));
                Alfabeto a = ctrlAlfabeto.getCjtAlfabetos().getAlfabeto(t.getAlfabetoVinculado());
                ctrlTeclado.CrearTeclado(t.getNombre(), at, a, t.getDimensiones(), false);
            }
        }
    }

    /**
     * Retorna el número de carácteres que tiene el contenido del alfabeto.
     * @param nomA clave única y nombre del alfabeto a buscar.
     * @return int: el número de carácteres que tiene el contenido del alfabeto con nombre nomA.
     */
    public int numeroCaracteres(String nomA) {
        return ctrlAlfabeto.getCjtAlfabetos().getAlfabeto(nomA).getLetras().size();
    }

    /**
     * No devuelve nada.
     * @param nomA clave única y nombre del alfabeto a borrar.
     * Borra el alfabeto con nombre nomA.
     * También borra en cascada los teclados que tenia vinculados.
     * Y desvincula las asociaciones de textos vinculadas a estos teclados borrados.
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
     * Retorna si el texto es de palabras o frecuencias.
     * @param nomT clave única y nombre del texto a crear.
     * @return Boolean: true si es palabras, false si es frecuencias.
     */
    public boolean esTextoPalabras(String nomT){
        return ctrlTexto.esTextoPalabras(nomT);
    }

    /**
     * Retorna si se ha agregado bien el texto(formato palabras).
     * @param nomT clave única y nombre del texto a crear.
     * @param texto contenido del texto (formato palabras).
     * @return Boolean: true si se ha agregado bien el texto, false si no se ha creado bien.
     */
    public static boolean agregarTextoPalabras(String nomT, String texto){
        return ctrlTexto.agregarTextoPalabras(nomT,texto);
    }

    /**
     * Retorna si se ha creado bien el texto (formato frecuencias).
     * @param nomT clave única y nombre del texto a crear.
     * @param frecuenciaPalabras contenido del texto (formato frecuencias).
     * @return Boolean: true si se ha agregado bien el texto, false si no se ha creado bien.
     */
    public boolean agregarTextoFrecuencias(String nomT, HashMap<String, Integer> frecuenciaPalabras){
        return ctrlTexto.agregarTextoFrecuencias(nomT,frecuenciaPalabras);
    }

    /**
     * Retorna la lista de nombres de los textos existentes en el conjunto de textos.
     * @return ArrayList<String>: lista de textos existentes ordenada por el nombre de texto que es la clave primaria.
     */
    public ArrayList<String> getNombresTextos(){
        return ctrlTexto.getNombresTextos();
    }

    /**
     * Retorna el contenido del texto con nombre nomT.
     * @param nomT clave única y nombre del texto a buscar.
     * @return String: contenido del texto con nombre nomT.
     */
    public String consultarContenidoTexto(String nomT){
        return ctrlTexto.getContenido(nomT);
    }

    /**
     * Retorna si el texto nomT ha sido modificado correctamente.
     * @param nomT clave única y nombre del texto a modificar.
     * @param entrada contenido nuevo del texto con nombre nomT.
     * Modifica el texto con nombre nomT y lo actualiza con el contenido del párametro entrada (formato palabras).
     * También actualiza la lista de pares de letras de todas las asociaciones a las que está vinculado este texto.
     * De manera que se eliminan las frecuncias de pares de letras del contenido anterior y se añaden las del contenido nuevo.
     * Además hay que volver a generar los teclados que están vinculados a estas asociaciones que han sido modificadas.
     */
    public boolean modificarContenidoTexto(String nomT, String entrada){
        if(existetexto(nomT)) {
            String contenidoAntiguo = ctrlTexto.getContenido(nomT);
            HashMap<String, Integer> frecAntiguas = ctrlTexto.getTexto(nomT).getFrecuenciaLetras();
            if (ctrlTexto.modificarContenido(nomT, entrada)) {
                ArrayList<String> asocV =  ctrlTexto.getTexto(nomT).getAsociacionesVinculadas();
                HashMap<String, Integer> frecTxt = ctrlTexto.getTexto(nomT).getFrecuenciaLetras();
                for (int i = 0; i < asocV.size(); ++i) {
                    AsociacionTextos at = ctrlAsociacionTexto.getCjtAsociaciones().getAsociacionTextos(asocV.get(i));
                    at.borrarTexto(nomT, frecAntiguas);
                    at.agregarTexto(nomT, frecTxt);
                    ArrayList<String> tecV = at.getTecladosVinculados();
                    for (int j = 0; j < tecV.size(); ++j) {
                        Teclado t = ctrlTeclado.getCjtTeclados().getTeclado(tecV.get(i));
                        ctrlTeclado.CrearTeclado(t.getNombre(), at, ctrlAlfabeto.getCjtAlfabetos().getAlfabeto(t.getAlfabetoVinculado()), t.getDimensiones(), false);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Retorna si el texto nomT ha sido modificado correctamente.
     * @param nomT clave única y nombre del texto a modificar.
     * @param entrada contenido nuevo del texto con nombre nomT.
     * Modifica el texto con nombre nomT y lo actualiza con el contenido del párametro entrada (formato frecuencias).
     * También actualiza la lista de pares de letras de todas las asociaciones a las que está vinculado este texto.
     * De manera que se eliminan las frecuncias de pares de letras del contenido anterior y se añaden las del contenido nuevo.
     * Además hay que volver a generar los teclados que están vinculados a estas asociaciones que han sido modificadas.
     */
    public boolean modificarContenidoTextoFrec(String nomT, HashMap<String, Integer> entrada){
        if(existetexto(nomT)) {
            HashMap<String, Integer> frecAntiguas = ctrlTexto.getTexto(nomT).getFrecuenciaLetras();
            if (ctrlTexto.modificarContenidoFrec(nomT, entrada)) {
                ArrayList<String> asocV =  ctrlTexto.getTexto(nomT).getAsociacionesVinculadas();
                for (int i = 0; i < asocV.size(); ++i) {
                    AsociacionTextos at = ctrlAsociacionTexto.getCjtAsociaciones().getAsociacionTextos(asocV.get(i));
                    at.borrarTexto(nomT, frecAntiguas);
                    at.agregarTexto(nomT, entrada);
                    ArrayList<String> tecV = at.getTecladosVinculados();
                    for (int j = 0; j < tecV.size(); ++j) {
                        Teclado t = ctrlTeclado.getCjtTeclados().getTeclado(tecV.get(i));
                        ctrlTeclado.CrearTeclado(t.getNombre(), at, ctrlAlfabeto.getCjtAlfabetos().getAlfabeto(t.getAlfabetoVinculado()), t.getDimensiones(), false);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Retorna si existe el texto con nombre nomT.
     * @param nomT clave única y nombre del texto a buscar.
     * @return Boolean: true si existe el texto con nombre nomT, false si no existe.
     */
    public boolean existetexto(String nomT){
        return ctrlTexto.getTextos().existeTexto(nomT);
    }

    /**
     * No devuelve nada.
     * @param nomT clave única y nombre del texto a borrar.
     * Borra el texto con nombre nomT.
     * También elimina ese texto de las asociaciones en las que estaba asociado.
     */
    public void borrarTexto(String nomT){
        ArrayList<String> AVinculadas = CtrlTexto.getAsociacionesVinculadasTexto(nomT);
        if(!AVinculadas.isEmpty()) {
            for (int i = 0; i < AVinculadas.size(); ++i){
                borrarTextoAsociacion(AVinculadas.get(i),nomT);
            }
        }
        CtrlTexto.borrarTexto(nomT);
    }

    // ---------- FUNCIONES ASOCIACION TEXTOS ----------

    /**
     * Retorna si se ha creado bien la asociacion con nombre nomAT.
     * @param nomAT clave única y nombre de la asociacion a agregar.
     * @param textosgregar la lista de nombres de los textos que hay que agregar a la asociación.
     * @return Boolean: true si se ha creado bien la asociación, false si no se ha creado bien.
     */
    public boolean agregarAsociacion(String nomAT, ArrayList<String> textosgregar){
        if(!existeasociacion(nomAT)){
            ctrlAsociacionTexto.agregarAsociacion(nomAT);
            for (String s : textosgregar) {
                agregarTextoAsociacion(nomAT,s);
            }
            return true;
        }
        return false;
    }

    /**
     * No devuelve nada.
     * @param nomAT clave única y nombre de la asociación donde añadir el texto.
     * @param nomTxt clave única u nombre del texto a añadir en la asociación.
     * Agrega el texto con nombre nomTxt a la lista de textos de la asociación con nombre nomAT.
     */
    public void agregarTextoAsociacion (String nomAT, String nomTxt){

        HashMap<String,Integer> freqTexto = ctrlTexto.getTexto(nomTxt).getFrecuenciaLetras();
        ctrlAsociacionTexto.agregarTextoAsociacion(nomAT, nomTxt, freqTexto);
        ctrlTexto.agregarAsociacionVinculada(nomTxt,nomAT);
    }

    /**
     * Retorna la lista de nombres de las asociaciones del conjunto de asociaciones.
     * @return ArrayList<String>: lista de asociaciones existentes ordenada por el nombre de la asociación que es la clave primaria.
     */
    public ArrayList<String> getNombresAsociaciones(){
        return ctrlAsociacionTexto.getNombresAsociaciones();
    }

    /**
     * Retorna si existe la asociacion con nombre nomAT.
     * @param nomAT clave única y nombre de la asociacion a buscar.
     * @return Boolean: true si se ha encontrado la asociacion, false si no se ha encontrado.
     */
    public boolean existeasociacion(String nomAT){
        return ctrlAsociacionTexto.getCjtAsociaciones().existeAsociaciondeTextos(nomAT);
    }

    /**
     * Retorna el contenido de la asociación con nomAT.
     * @param nomAT clave única y nombre de la asociación a buscar.
     * @return ArrayList<String>: una lista de los nombres de los textos que forman la asociación con nombre nomAT.
     */
    public ArrayList<String> consultarCjtTextosAsociacion(String nomAT){
        if(existeasociacion(nomAT)) {
            return ctrlAsociacionTexto.getCjtTextos(nomAT);
        }
        return null;
    }

    /**
     * No devuelve nada.
     * @param nomAT clave única y nombre de la asociación a buscar.
     * Manda borrar el texto con nombre nomTxt de la lista de textos asociados a la asociación con nombre nomAT.
     */
    public void borrarTextoAsociacion (String nomAT, String nomTxt){
        HashMap<String, Integer> frecuenciaLetras = ctrlTexto.getTexto(nomTxt).getFrecuenciaLetras();
        ctrlAsociacionTexto.borrarTextoAsociacion(nomAT,nomTxt,frecuenciaLetras);
        ctrlTexto.borrarAsociacionVinculada(nomTxt,nomAT);
    }

    /**
     * No devuelve nada.
     * @param nomAT clave única y nombre de la asociación de textos a borrar.
     * Borra la asociación de textos con nombre nomAT.
     * También desvincula la asociación borrada de todos los textos que estaban asociados a esta.
     */
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
     * Retorna si el teclado ha sido agregado correctamente o no.
     * @param nomT clave única y nombre del teclado a agregar.
     * @param nomA clave única y nombre del alfabeto a vincular con el teclado nomT.
     * @param nomAT clave única y nombre de la asociación de textos a vincular con el teclado nomT.
     * @return Boolean: true si se ha creado correctamente el teclado, false si ya existe un teclado con ese nombre.
     */
    public boolean agregarTeclado(String nomT, String nomA, String nomAT, PairInt dimensiones, boolean alg){
        if(ctrlTeclado.existeTeclado(nomT)) return false;
        
        Alfabeto alfabeto = ctrlAlfabeto.getCjtAlfabetos().getAlfabeto(nomA);
        AsociacionTextos asociacionTextos = ctrlAsociacionTexto.getCjtAsociaciones().getAsociacionTextos(nomAT);
        ctrlAlfabeto.agregarTecladoVinculado(nomA, nomT);
        ctrlAsociacionTexto.agregarTecladoVinculado(nomAT, nomT);
        ctrlTeclado.CrearTeclado(nomT, asociacionTextos, alfabeto, dimensiones, alg);
        ctrlTeclado.agregarAlfabetoVinculado(nomT,nomA);
        ctrlTeclado.agregarAsociacionTextosVinculado(nomT,nomAT);
        return true;

    }

    /**
     * Retorna el contenido del teclado con nombre nomT.
     * @param nomT clave única y nombre del teclado a consultar.
     * @return char[][]: la matriz que representa el contenido del teclado nomT.
     */
    public char[][] consultarContenidoTeclado(String nomT){
        if(ctrlTeclado.existeTeclado(nomT)) {
            return ctrlTeclado.getContenido(nomT);
        }
        return null;
    }

    /**
     * Retorna la puntuación del teclado con nombre nomT.
     * @param nomT clave única y nombre del teclado a consultar.
     * @return Integer: el valor de la puntuación del teclado nomT.
     */
    public int consultarPuntuacionTeclado(String nomT){
        if(ctrlTeclado.existeTeclado(nomT)) {
            return ctrlTeclado.getPuntuacion(nomT);
        }
        return -1;
    }

    /**
     * Retorna el nombre del alfabeto asociado al teclado con nombre nomT.
     * @param nomT clave única y nombre del teclado a buscar.
     * @return String: nombre del alfabeto vinculado al teclado nomT.
     */
    public String consultarAlfabetoAsociadoTeclado(String nomT) {
        if(ctrlTeclado.existeTeclado(nomT)) {
            return ctrlTeclado.getAlfabeto(nomT);
        }
        return null;
    }

    /**
     * Retorna el nombre de la asociación de textos asociada al teclado nomT.
     * @param nomT clave única y nombre del teclado a buscar.
     * @return String: nombre de la asociación vinculada al teclado nomT.
     */
    public String consultarAsociacionAsociadoTeclado(String nomT) {
        if(ctrlTeclado.existeTeclado(nomT)) {
            return ctrlTeclado.getAsociacion(nomT);
        }
        return null;
    }

    /**
     * Retorna el valor de las dimensiones del teclado nomT.
     * @param nomT clave única y nombre del teclado a buscar.
     * @return PairInt: valores de las dimensiones del teclado nomT.
     */
    public PairInt consultarDimensionesTeclado(String nomT) {
        if(ctrlTeclado.existeTeclado(nomT)) {
            return ctrlTeclado.getDimensiones(nomT);
        }
        return null;
    }

    /**
     * Retorna la lista de nombres de los teclados del conjunto de teclados.
     * @return ArrayList<String>: lista de nombres de los teclados existentes.
     */
    public ArrayList<String> getListaTeclados(){
        return ctrlTeclado.getCjtTeclados().getNombresTeclados();
    }

    /**
     * No devuelve nada.
     * @param nomT clave única y nombre del teclado a borrar.
     * Borra el teclado con nombre nomT.
     * También desvincula el alfabeto y la asociación de textos que tenía vinculados.
     */
    public void borrarTeclado(String nomT) {
        String atvinculada = ctrlTeclado.TecladoTieneAsociacionVinculada(nomT);
        String aVinculado = ctrlTeclado.TecladoTieneAlfabetoVinculado(nomT);

        ctrlAsociacionTexto.borrarTecladoVinculado(atvinculada, nomT);
        ctrlAlfabeto.borrarTecladoVinculado(aVinculado, nomT);
        ctrlTeclado.borrarTeclado(nomT);
    }

    /**
     * Retorna la lista de posibles dimensiones que puede tener el teclado.
     * @param nomA clave única y nombre del alfabeto a buscar.
     * @return ArrayList<PairInt>: lista de valores de las posibles dimensiones del teclado nomT.
     */
    public ArrayList<PairInt> getPosiblesDimensiones(String nomA) {
        int n = ctrlAlfabeto.getContenido(nomA).size();
        return ctrlTeclado.getPosiblesDimensiones(n);
    }


    // ---------- FUNCIONES PERSISTENCIA ALFABETOS ----------

    /**
     * Almacena el conjunto de alfabetos en una localización específica.
     */
    public void guardaCnjtAlfabetos() {
        String nomDoc = "conjuntoAlfabetos";
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory+"//Entrega3//data//Cache//"+nomDoc+"//";
        try {
            byte[] bytes = ctrlAlfabeto.alfabetosToByteArray();
            ctrlPersistencia.guardaCnjtAlfabetos(bytes,path);
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de alfabetos" + e.getMessage());
            Thread.currentThread().getStackTrace();
            System.exit(-102);
        }
    }

    /**
     * Retorna el conjunto de alfabetos que se encuentra en path.
     * @param path
     */
    public void cargaCnjtAlfabetos(String path) {
        try {
            byte[] bytes = ctrlPersistencia.cargaCnjtAlfabetos(path);
            if (bytes != null || bytes.length != 0) {
                CtrlAlfabeto.byteArrayToAlfabetos(bytes);
            }
            else {
                System.out.println("El archivo está vacío. No se carga ningun alfabeto.");
            }
        } catch (Exception e) {
            System.err.println("[#CARGA] Error al cargar el conjunto de alfabetos " + e.getMessage());
        }
    }



    // ---------- FUNCIONES PERSISTENCIA TEXTOS ----------

    /**
     * Guarda el conjunto de textos en una ubicación específica.
     * La ubicación por defecto es la carpeta 'Entrega3/data/Cache' del directorio de trabajo actual.
     * Se utiliza la persistencia para guardar los datos, convirtiendo el conjunto de textos
     * en un array de bytes y llamando a un método en el controlador de persistencia.
     * Si se produce un error durante el proceso de guardado, se muestra un mensaje de error en la consola
     * y se finaliza la aplicación con un código de error.
     */
    public void guardaCnjtTextos() {
        String nomDoc = "conjuntoTextos";
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory+"//Entrega3//data//Cache//"+nomDoc+"//";
        try {
            byte[] bytes = ctrlTexto.textosToByteArray();
            ctrlPersistencia.guardaCnjtTextos(bytes,path);
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de textos " + e.getMessage());
            Thread.currentThread().getStackTrace();
            System.exit(-102);
        }
    }

    /**
     * Carga el conjunto de textos desde el archivo especificado en la ruta proporcionada.
     * @param path La ruta del archivo desde el cual cargar el conjunto de textos.
     */
    public void cargaCnjtTextos(String path) {
        try {
            byte[] bytes = ctrlPersistencia.cargaCnjtTextos(path);
            if (bytes != null || bytes.length != 0) {
                CtrlTexto.byteArrayToTextos(bytes);
            }
            else {
                System.out.println("El archivo está vacío. No se carga ningun texto.");
            }
        } catch (Exception e) {
            System.err.println("[#CARGA] Error al cargar el conjunto de textos " + e.getMessage());
        }
    }


    // ---------- FUNCIONES PERSISTENCIA ASOCIACIONES TEXTOS ----------
    /**
     * Guarda el conjunto de asociaciones de textos en una ubicación específica.
     * La ubicación por defecto es la carpeta 'Entrega3/data/Cache' del directorio de trabajo actual.
     * Se utiliza la persistencia para guardar los datos, convirtiendo el conjunto de asociaciones de textos
     * en un array de bytes y llamando a un método en el controlador de persistencia.
     * Si se produce un error durante el proceso de guardado, se muestra un mensaje de error en la consola
     * y se finaliza la aplicación con un código de error.
     */
    public void guardaCnjtAsociaciones() {
        String nomDoc = "conjuntoAsociaciones";
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory+"//Entrega3//data//Cache//"+nomDoc+"//";
        try {
            byte[] bytes = ctrlAsociacionTexto.asociacionesToByteArray();
            ctrlPersistencia.guardaCnjtAsociaciones(bytes,path);
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de asociaciones de textos " + e.getMessage());
            Thread.currentThread().getStackTrace();
            System.exit(-102);
        }
    }

    /**
     * Carga el conjunto de asociaciones de textos desde el archivo especificado en la ruta proporcionada.
     * @param path La ruta del archivo desde el cual cargar el conjunto de asociaciones de textos.
     */
    public void cargaCnjtAsociaciones(String path) {
        try {
            byte[] bytes = ctrlPersistencia.cargaCnjtAsociaciones(path);
            if (bytes != null || bytes.length != 0) {
                CtrlAsociacionTexto.byteArrayToAsociaciones(bytes);
            }
            else {
                System.out.println("El archivo está vacío. No se carga ninguna asociación.");
            }
        } catch (Exception e) {
            System.err.println("[#CARGA] Error al cargar el conjunto de asociaciones de textos " + e.getMessage());
        }
    }


    // ---------- FUNCIONES PERSISTENCIA TECLADOS ----------
    /**
     * Guarda el conjunto de teclados en una ubicación específica.
     * La ubicación por defecto es la carpeta 'Entrega3/data/Cache' del directorio de trabajo actual.
     * Se utiliza la persistencia para guardar los datos, convirtiendo el conjunto de teclados
     * en un array de bytes y llamando a un método en el controlador de persistencia.
     * Si se produce un error durante el proceso de guardado, se muestra un mensaje de error en la consola
     * y se finaliza la aplicación con un código de error.
     */
    public void guardaCnjtTeclados() {
        String nomDoc = "conjuntoTeclados";
        String currentDirectory = System.getProperty("user.dir");
        String path = currentDirectory+"//Entrega3//data//Cache//"+nomDoc+"//";
        try {
            byte[] bytes = ctrlTeclado.tecladosToByteArray();
            ctrlPersistencia.guardaCnjtTeclados(bytes,path);
        } catch (IOException e) {
            System.err.println("[#GUARDAR] Error al guardar el conjunto de teclados " + e.getMessage());
            Thread.currentThread().getStackTrace();
            System.exit(-102);
        }
    }

    /**
     * Carga el conjunto de teclados desde el archivo especificado en la ruta proporcionada.
     * @param path La ruta del archivo desde el cual cargar el conjunto de teclados.
     */
    public void cargaCnjtTeclados(String path) {
        try {
            byte[] bytes = ctrlPersistencia.cargaCnjtTeclados(path);
            if (bytes != null || bytes.length != 0) {
                ctrlTeclado.byteArrayToTeclados(bytes);
            }
            else {
                System.out.println("El archivo está vacío. No se carga ningun teclado.");
            }
        } catch (Exception e) {
            System.err.println("[#CARGA] Error al cargar el conjunto de teclados " + e.getMessage());
        }
    }


    /**
     * Agrega un alfabeto utilizando un archivo especificado por la ruta.
     * @param nombreAlfabeto nombre del alfabeto a agregar.
     * @param pathArchivo ruta del archivo que contiene la definición del alfabeto.
     * @return True si el alfabeto se agrega con éxito, False de lo contrario.
     * @throws IOException en el caso de haber un error de entrada/salida al leer el archivo.
     */
    public static boolean agregarAlfabetoPath(String nombreAlfabeto, String pathArchivo) throws IOException {
        ArrayList<Character> entrada = ctrlPersistencia.leerArchivoPath(pathArchivo);
        return agregarAlfabeto(nombreAlfabeto, entrada);
    }

    /**
     * Agrega un texto de palabras utilizando un archivo de texto especificado por la ruta.
     * @param nombreTexto nombre del texto de palabras a agregar.
     * @param pathTexto ruta del archivo de texto que contiene las palabras.
     * @return True si el texto de palabras se agrega con éxito, False de lo contrario.
     * @throws IOException en el caso de haber un error de entrada/salida al leer el archivo de texto.
     */
    public boolean agregarTextoPalabrasPath(String nombreTexto, String pathTexto) throws IOException {
        String texto = ctrlPersistencia.leerTextoPalabrasPath(pathTexto);
        return agregarTextoPalabras(nombreTexto, texto);
    }

    /**
     * Verifica si el formato de las frecuencias es correcto para agregar a un contenido de texto.
     * @param contenidoTexto contenido de texto al que se agregarán las frecuencias.
     * @param pathTexto ruta del archivo de texto asociado al contenido.
     * @param frecuencias mapa de frecuencias a agregar al contenido de texto.
     * @return True si el formato de las frecuencias es correcto, False de lo contrario.
     */
    public boolean formatoCorrectoAgregarFrecuencias(String contenidoTexto, String pathTexto, HashMap<String, Integer> frecuencias) {
        return ctrlPersistencia.formatoCorrectoAgregarFrecuencias(contenidoTexto, pathTexto, frecuencias);
    }
}