package main.domain.controllers;


import main.domain.classes.*;
import main.domain.classes.types.PairInt;

import java.io.*;
import java.util.ArrayList;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar de conjunto teclados, teclado y el controlador del algoritmo
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class CtrlTeclado
{
    // ---------- PARÁMETROS ----------
    /** Crea una instancia del conjunto de teclados. */
    private static ConjuntoTeclados teclados;

    /** Crea una instancia del controlador del algoritmo. */
    private CtrlTecladoQAP ctrlAlgoritmo;


    // ---------- CONSTRUCTURAS ----------
    /** Inicialización de la instancia conjunto de teclados vacío. */
    public CtrlTeclado(){
        teclados = new ConjuntoTeclados();
        ctrlAlgoritmo = new CtrlTecladoQAP();
    }


    // ---------- FUNCIONES TECLADO ----------
    /**
     * Obtiene el contenido asociado a un Teclado específico.
     * @param nomT nombre del Teclado del cual se desea obtener el contenido.
     * @return matriz de caracteres que representa el contenido del Teclado especificado.
     */
    public char[][] getContenido(String nomT){
        return teclados.getTeclado(nomT).getContenido();
    }

    /**
     * Obtiene la puntuación asociada a un Teclado específico.
     * @param nomT nombre del Teclado del cual se desea obtener la puntuación.
     * @return puntuación asociada al Teclado especificado.
     */
    public int getPuntuacion(String nomT){
        return teclados.getTeclado(nomT).getPuntuacion();
    }

    /**
     * Obtiene el alfabeto vinculado a un Teclado específico.
     * @param nomT nombre del Teclado del cual se desea obtener el alfabeto vinculado.
     * @return cadena de caracteres que representa el alfabeto vinculado al Teclado especificado.
     */
    public String getAlfabeto(String nomT){
        return teclados.getTeclado(nomT).getAlfabetoVinculado();
    }

    /**
     * Obtiene la asociación de textos vinculada a un Teclado específico.
     * @param nomT nombre del Teclado del cual se desea obtener la asociación de textos vinculada.
     * @return cadena de caracteres que representa la asociación de textos vinculada al Teclado especificado.
     */
    public String getAsociacion(String nomT){
        return teclados.getTeclado(nomT).getAsociacionTextosVinculado();
    }

    /**
     * Obtiene las dimensiones asociadas a un Teclado específico.
     * @param nomT nombre del Teclado del cual se desea obtener las dimensiones.
     * @return objeto PairInt que contiene las dimensiones (ancho y alto) del Teclado especificado.
     */
    public PairInt getDimensiones(String nomT){
        return teclados.getTeclado(nomT).getDimensiones();
    }

    /**
     * No devuelve nada. Agrega un alfabeto vinculado a un Teclado específico.
     * @param nomT nombre del Teclado al cual se le agregará el alfabeto vinculado.
     * @param nomA nombre del alfabeto que se vinculará al Teclado especificado.
     */
    public void agregarAlfabetoVinculado(String nomT, String nomA) {
        teclados.getTeclado(nomT).agregarAlfabetoVinculado(nomA);
    }

    /**
     * No devuelve nada. Agrega una asociación de textos vinculada a un Teclado específico.
     * @param nomT nombre del Teclado al cual se le agregará la asociación de textos vinculada.
     * @param nomAT nombre de la asociación de textos que se vinculará al Teclado especificado.
     */
    public void agregarAsociacionTextosVinculado(String nomT, String nomAT) {
        teclados.getTeclado(nomT).agregarAsociacionTextosVinculado(nomAT);
    }

    /**
     * Obtiene las posibles dimensiones para formar una cuadrícula de tamaño n.
     * @param n tamaño para el cual se buscan las posibles dimensiones.
     * @return lista de objetos PairInt que representan las posibles dimensiones de una cuadrícula para el tamaño n.
     */
    public ArrayList<PairInt> getPosiblesDimensiones(int n) {
        ArrayList<PairInt> dim = new ArrayList<>();
        for (int filas = 1; filas <= n; filas++) {
            if (n % filas == 0) {
                int columnas = n / filas;
                dim.add(new PairInt(filas, columnas));
            }
        }
        if (esPrimo(n)) {
            int N = n+1;
            for (int filas = 1; filas <= N; filas++) {
                if (N % filas == 0) {
                    int columnas = N / filas;
                    dim.add(new PairInt(filas, columnas));
                }
            }
        }
        return dim;
    }

    /**
     * Verifica si un número es primo.
     * @param num número a verificar.
     * @return True si el número es primo, False en caso contrario.
     */
    private boolean esPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    // ---------- FUNCIONES CONJUNTOTECLADOS ----------
    /**
     * Obtiene el conjunto de teclados.
     * @return objeto ConjuntoTeclados que representa el conjunto de teclados.
     */
    public ConjuntoTeclados getCjtTeclados() {
        return teclados;
    }

    /**
     * Verifica si existe un Teclado con el nombre especificado.
     * @param nomT nombre del Teclado a verificar.
     * @return True si existe un Teclado con el nombre especificado, False en caso contrario.
     */
    public boolean existeTeclado(String nomT){
        return teclados.existeTeclado(nomT);
    }

    /**
     * No devuelve nada. Crea un nuevo Teclado y lo agrega al conjunto de teclados.
     * @param nomT nombre del Teclado a crear.
     * @param asociacionTextos objeto AsociacionTextos para vincular al Teclado.
     * @param alfabeto objeto Alfabeto para vincular al Teclado.
     * @param dim dimensiones (ancho y alto) del Teclado.
     * @param alg indica si se utiliza un algoritmo específico en la creación del Teclado.
     */
    public void CrearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, PairInt dim, boolean alg) {
        Teclado teclado = ctrlAlgoritmo.crearTeclado(nomT, asociacionTextos, alfabeto, dim, alg);
        teclados.agregarTeclado(nomT, teclado);
    }

    /**
     * Obtiene el nombre del Alfabeto vinculado a un Teclado específico.
     * @param nomT nombre del Teclado del cual se desea obtener el nombre del Alfabeto vinculado.
     * @return nombre del Alfabeto vinculado al Teclado especificado.
    */
    public String TecladoTieneAlfabetoVinculado(String nomT){
        return teclados.getTeclado(nomT).getAlfabetoVinculado();
    }

    /**
     * Obtiene el nombre de la Asociación de Textos vinculada a un Teclado específico.
     * @param nomT nombre del Teclado del cual se desea obtener el nombre de la Asociación de Textos vinculada.
     * @return nombre de la Asociación de Textos vinculada al Teclado especificado.
     */
    public String TecladoTieneAsociacionVinculada(String nomT){
        return teclados.getTeclado(nomT).getAsociacionTextosVinculado();
    }

    /**
     * Elimina un Teclado del conjunto de teclados.
     * @param nomT nombre del Teclado que se desea eliminar.
     */
    public void borrarTeclado(String nomT) {
        teclados.borrarTeclado(nomT);
    }


    // ---------- FUNCIONES PERSISTENCIA ----------
    /**
     * Convierte el conjunto de teclados en ByteArray con el fin de almacenarlos.
     * @return Arreglo de bytes que representa el conjunto de teclados.
     * @throws IOException en el caso de que se produzca un error durante la serialización.
     */
    public byte[] tecladosToByteArray() throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(teclados);
        os.close();
        return bs.toByteArray();
    }

    /**
     * Convierte un conjunto de bytes a un conjunto de teclados.
     * @param bytes conjunto de bytes que representa el conjunto de teclados.
     * @throws IOException en el caso de que se produzca un error durante la deserialización.
     * @throws ClassNotFoundException en el caso de que la clase ConjuntoTeclados no es encontrada durante la deserialización.
     */
    public static void byteArrayToTeclados(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(bs);
        teclados = (ConjuntoTeclados) is.readObject();
        is.close();
    }
}