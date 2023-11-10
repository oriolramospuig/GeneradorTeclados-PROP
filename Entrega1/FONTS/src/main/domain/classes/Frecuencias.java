package main.domain.classes;

public class Frecuencias extends Texto {
    // ---------- ATRIBUTOS ----------
    /**
     * ...
     */
    private String texto;


    // ---------- CONSTRUCTORES ----------
    public Frecuencias(String nombre, String contenido) {
        this.nombre = nombre;
        this.texto = contenido;
    }

    // ---------- GETTERS ----------
    public String getTexto() {
        return texto;
    }


    // ---------- SETTERS ----------


    // ---------- AUXILIARES -----------
}
