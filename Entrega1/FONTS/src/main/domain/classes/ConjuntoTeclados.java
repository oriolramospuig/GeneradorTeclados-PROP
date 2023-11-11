package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa el conjunto de teclados
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class ConjuntoTeclados
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de teclados generados por el usuario */
    private HashMap<String, Teclado> teclados;


    // ---------- CONSTRUCTORES ----------
    public ConjuntoTeclados() {
        teclados = new HashMap<>();
    }


    // ---------- GETTERS ----------
    public Teclado getTeclado(String nomT) {
        if (teclados.containsKey(nomT)) return teclados.get(nomT);
        else return null;
    }

    // tenemos que considerar si queremos/necesitamos esta funcion
    public HashMap<String, Teclado> getTeclados() {
        return teclados;
    }

    public ArrayList<String> getNombresTeclados() {
        ArrayList<String> listaNombres = new ArrayList<>();
        for (String clave : teclados.keySet()) {
            listaNombres.add(clave);
        }
        return listaNombres;
    }


    // ---------- SETTERS ----------
    public void agregarTeclado(String nomT, Teclado teclado) {
        teclados.put(nomT, teclado);
    }


    // ---------- AUXILIARES -----------
    public boolean existeTeclado(String nomT){
        return teclados.containsKey(nomT);
    }

    public void borrarTeclado(String nomT) {
        teclados.remove(nomT);
    }
}
