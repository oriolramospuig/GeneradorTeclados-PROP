package main.domain.classes.types;

public class PairString<S, S1> {
    String letra1;
    String letra2;

    public PairString(String letra1, String letra2) {
        this.letra1 = letra1;
        this.letra2 = letra2;
    }

    public String getLetra1() {
        return letra1;
    }

    public String getLetra2() {
        return letra2;
    }
}
