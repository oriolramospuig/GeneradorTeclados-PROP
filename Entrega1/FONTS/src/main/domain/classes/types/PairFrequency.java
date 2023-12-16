package main.domain.classes.types;

/** Clase que implementa un pair de String, Int
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class PairFrequency {
    /** Guarda el conjunto de letras que conforman el pairFrequency */
    String pair;

    /** Guarda el número de veces que aparecen las letars */
    int frequency;

    /**
     * Crea una instancia de la clase PairFrequency e inicializa los atributos de esta clase con los valores correspondientes
     * @param pair pareja de letras
     * @param frequency veces que aparecen las letras
     */
    public PairFrequency(String pair, int frequency) {
        this.pair = pair;
        this.frequency = frequency;
    }

    /**
     * Devuelve la pareja de letras
     * @return String: pareja de letras
     */
    public String getPair() {
        return pair;
    }

    /**
     * Devuelve la frecuencia de las letras
     * @return int: frequencia
     */
    public int getFrequency() {
        return frequency;
    }
}