package main.domain.classes.types;

import java.io.Serializable;

/** Clase que implementa un pair de Int, Int
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class PairInt implements Serializable {
    /** Guarda el primer elemento que conforma el PairInt */
    Integer int1;

    /** Guarda el segundo elemento que conforma el PairInt */
    Integer int2;

    /**
     * Crea una instancia de la clase PairInt e inicializa los atributos de esta clase con los valores correspondientes
     * @param int1 primer elemento del PairInt
     * @param int2 segundo elemento del PairInt
     */
    public PairInt(Integer int1, Integer int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    /**
     * Devuelve el primer elemento del PairInt
     * @return int: int1
     */
    public Integer getPrimero() {
        return int1;
    }

    /**
     * Devuelve el segundo elemento del PairInt
     * @return int: int2
     */
    public Integer getSegundo() {
        return int2;
    }

    /**
     * Modifica el primer elemento del PairInt
     * @param int1 nuevo valor para int1
     */
    public void setPrimero(Integer int1) {
        this.int1 = int1;
    }

    /**
     * Modifica el segundo elemento del PairInt
     * @param int2 nuevo valor para int2
     */
    public void setSegundo(Integer int2) {
        this.int2 = int2;
    }

    /**
     * Convierte el PairInt a un string
     * @return String: PairInt convertido al formato: (int1,int2)
     */
    @Override
    public String toString() {
        return "(" + int1 + "," + int2 + ")";
    }
}