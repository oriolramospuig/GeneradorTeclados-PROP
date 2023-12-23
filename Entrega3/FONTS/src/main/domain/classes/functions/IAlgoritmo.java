package main.domain.classes.functions;

import main.domain.classes.Alfabeto;
import main.domain.classes.AsociacionTextos;
import main.domain.classes.Teclado;
import main.domain.classes.types.PairInt;

import java.util.HashMap;


/**
 * Interfaz que define un método para la creación de objetos Teclado mediante un algoritmo específico.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public interface IAlgoritmo {
    /**
     * Crea un objeto Teclado con los parámetros proporcionados y utilizando una asignación específica entre letras y sus índices.
     * @param nomT nombre del Teclado a crear.
     * @param asociacionTextos objeto AsociacionTextos para vincular al Teclado.
     * @param alfabeto objeto Alfabeto para vincular al Teclado.
     * @param dim dimensiones (ancho y alto) del Teclado.
     * @param letraAIndice HashMap que asigna cada letra a su índice correspondiente.
     * @return objeto Teclado creado con los parámetros proporcionados.
     */
    Teclado crearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, PairInt dim, HashMap<Character, Integer> letraAIndice);
}
