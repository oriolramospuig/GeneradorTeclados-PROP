package main.domain.classes;

public enum PairIntEnum {
    EMPTY_PAIR(0,0),
    PAIR_1(2, 2),
    PAIR_2(2, 3),
    PAIR_3(3, 4),
    PAIR_4(4, 3),
    PAIR_5(4, 5),
    PAIR_6(5, 5),
    PAIR_7(5, 6),
    PAIR_8(8, 8);


    private final Integer fila;
    private final Integer columna;

    private PairIntEnum(Integer fila, Integer columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public Integer getFila() {
        return fila;
    }

    public Integer getColumna() {
        return columna;
    }
}
