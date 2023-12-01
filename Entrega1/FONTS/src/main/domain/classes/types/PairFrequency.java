package main.domain.classes.types;

/** Clase que implementa un pair de String, Int
 * @author Júlia Tena (julia.tena-domingo   @estudiantat.upc.edu)
 */
public class PairFrequency {
    String pair;
    int frequency;

    public PairFrequency(String pair, int frequency) {
        this.pair = pair;
        this.frequency = frequency;
    }

    public String getPair() {
        return pair;
    }

    public int getFrequency() {
        return frequency;
    }
}
