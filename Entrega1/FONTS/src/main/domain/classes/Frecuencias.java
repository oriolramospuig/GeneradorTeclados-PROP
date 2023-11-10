package main.domain.classes;

import java.util.HashMap;

public class Frecuencias extends Texto
{
    // ---------- ATRIBUTOS ----------


    // ---------- CONSTRUCTORES ----------
    public Frecuencias(String nombre) {
        this.nombre = nombre;
        //el controlador llamara a anadirFrecuencia para ir pasando los valores que tocan directamente
    }


    // ---------- GETTERS ----------
    public String getTexto() {
        StringBuilder texto = new StringBuilder("");
        for (HashMap.Entry<String, Integer> i : frecuenciaLetras.entrySet()) {
            String parejaLetras = i.getKey();
            Integer frecuencia = i.getValue();

            texto.append(parejaLetras).append(" ").append(frecuencia).append("\n");
        }
        return texto.toString();
    }


    // ---------- SETTERS ----------
    void anadirFrecuencia(String parejaLetras, Integer frecuencia) {
        frecuenciaLetras.put(parejaLetras, frecuencia);
    }


    // ---------- AUXILIARES -----------
}
