package main.domain.classes;

public class Palabras extends Texto {
    // ---------- ATRIBUTOS ----------
    /**
     * ...
     */

    // ---------- CONSTRUCTORES ----------
    public Palabras(String nombre, String contenido) {
        this.nombre = nombre;
        this.texto = contenido;
        tratarEntrada();
    }

    // ---------- GETTERS ----------


    // ---------- SETTERS ----------


    // ---------- AUXILIARES -----------
    public void tratarEntrada() {
        char[] textoChars = texto.toCharArray();
        for(int i = 1; i < textoChars.length; ++i){
            String pairLetras = "" + textoChars[i-1] + textoChars[i];
            int frec = 1;
            if(frecuenciaLetras.containsKey(pairLetras)){
                frec = frecuenciaLetras.get(pairLetras)+1;
            }
            frecuenciaLetras.put(pairLetras,frec);
        }
    }
}
