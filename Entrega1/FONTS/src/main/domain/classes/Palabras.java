package main.domain.classes;

public class Palabras extends Texto {
    // ---------- ATRIBUTOS ----------
    /**
     * ...
     */
    private String texto;


    // ---------- CONSTRUCTORES ----------
    public Palabras(String nombre, String contenido) {
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
