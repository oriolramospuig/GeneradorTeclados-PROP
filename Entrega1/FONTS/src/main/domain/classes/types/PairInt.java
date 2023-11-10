package main.domain.classes.types;

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
}
