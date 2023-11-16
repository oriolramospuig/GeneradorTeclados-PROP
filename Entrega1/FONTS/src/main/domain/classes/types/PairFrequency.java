package main.domain.classes.types;

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
