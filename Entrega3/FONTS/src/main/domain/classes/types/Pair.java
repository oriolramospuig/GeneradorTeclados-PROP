package main.domain.classes.types;

import java.io.Serializable;

public class Pair <F extends Object, S extends Object> implements Serializable {
    private F first;
    private S second;


    /**
     * constructora
     * @param first primer elemento
     * @param second segundo elemento
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }


    /**
     * Modifica el primer elemento
     * @param first nuevo valor para el primer elemento
     */
    public void setFirst(F first) {
        this.first = first;
    }

    /**
     * Modifica el segundo elemento
     * @param second nuevo valor para el segundo elemento
     */
    public void setSecond(S second) {
        this.second = second;
    }

    /**
     * @return valor del primer elemento
     */
    public F getFirst() {
        return first;
    }

    /**
     * @return valor del segundo elemento
     */
    public S getSecond() {
        return second;
    }

    /**
     * Comparador entre pairs
     * @param o Objeto
     * @return true si es pair y false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair<F,S> p = (Pair<F,S>) o;
        return (first.equals(p.getFirst()) && second.equals(p.getSecond()));
    }

    /** Representacio d'un parell com a String
     *  @return La representacio de cada element com a string separat per un espai
     */
    @Override
    public String toString() {
        return first.toString() + " " + second.toString();
    }
}
