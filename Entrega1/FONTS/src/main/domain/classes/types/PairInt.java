package main.domain.classes.types;

/** Clase que implementa un pair de Int, Int
 * @author X (X@estudiantat.upc.edu)
 */
public class PairInt {
    Integer int1;
    Integer int2;

    public PairInt(Integer int1, Integer int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    public Integer getPrimero() {
        return int1;
    }

    public Integer getSegundo() {
        return int2;
    }

    public void setPrimero(Integer int1) {
        this.int1 = int1;
    }

    public void setSegundo(Integer int2) {
        this.int2 = int2;
    }

    @Override
    public String toString() {
        return "(" + int1 + ", " + int2 + ")";
    }
}
