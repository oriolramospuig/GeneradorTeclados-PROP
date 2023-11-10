package main.domain.classes;

public class Frecuencias extends Texto {
    // ---------- ATRIBUTOS ----------
    /**
     * ...
     */

    // ---------- CONSTRUCTORES ----------
    public Frecuencias(String nombre, String contenido) {
        this.nombre = nombre;
        this.texto = contenido;
        tratarEntrada();
    }

    // ---------- GETTERS ----------

    // ---------- SETTERS ----------


    // ---------- AUXILIARES -----------
    public void tratarEntrada() {}
}
