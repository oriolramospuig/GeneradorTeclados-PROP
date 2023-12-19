package main.domain.classes.functions;

import main.domain.classes.Alfabeto;
import main.domain.classes.AsociacionTextos;
import main.domain.classes.Teclado;
import main.domain.classes.types.PairInt;

import java.util.HashMap;


public interface Algoritmo {
    /**
     * Crea un objeto Teclado con los parámetros proporcionados y utilizando una asignación
     * específica entre letras y sus índices.
     *
     * @param nomT             Nombre del Teclado a crear.
     * @param asociacionTextos Objeto AsociacionTextos para vincular al Teclado.
     * @param alfabeto         Objeto Alfabeto para vincular al Teclado.
     * @param dim              Dimensiones (ancho y alto) del Teclado.
     * @param letraAIndice     HashMap que asigna cada letra a su índice correspondiente.
     * @return Objeto Teclado creado con los parámetros proporcionados.
     */
    public Teclado crearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, PairInt dim, HashMap<Character, Integer> letraAIndice);
}
