package main.domain.classes;

public class Palabras extends Texto {
    // ---------- ATRIBUTOS ----------
    /**
     * ...
     */
    private String texto;


    // ---------- CONSTRUCTORES ----------
    public Palabras(String nom, String contenido) {
        this.nombre = nom;
        this.texto = contenido;
    }

    // ---------- GETTERS ----------
    public String getTexto() {
        return texto;
    }


    // ---------- SETTERS ----------


    // ---------- AUXILIARES -----------
}
