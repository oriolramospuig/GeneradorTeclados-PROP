package main.domain.classes.config;

import main.domain.classes.Alfabeto;
import main.domain.classes.types.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Configuracion {
    /** Contiene la estructura de datos donde se guardan todos los alfabetos con los respectivos campos de cada uno */
    private HashMap<String, HashMap<String, Pair<ArrayList<Character>, ArrayList<String>>>> configAlfabetos;

   /* private boolean existeAlfabeto(String nombreA, ArrayList<Character> contenido) {
        for (var entry : configAlfabetos.entrySet()) {
            if (entry.getKey().equals(nombreA) && entry.getValue().equals(contenido)) return true;
        }
        return false;
    }
    */

    /** Constructora por defecto para crear una instancia vacía de la clase. */
    public Configuracion() {
        configAlfabetos = new HashMap<>();
    }

  /*  /**
     * Añade un nuevo alfabeto con nombreA, letras y tecladosVinculados.
     * @param nombreA
     * @param letras
     * @param tecladosVinculados
    public void añadirAlfabeto(String nombreA, ArrayList<Character> letras, ArrayList<String> tecladosVinculados) {
        if (!existeAlfabeto(nombreA, letras)) {
            HashMap<String, Pair<ArrayList<Character>, ArrayList<String>>> nuevoAlfabeto = new HashMap<>();
            Pair<ArrayList<Character>, ArrayList<String>> datosAlfabeto = new Pair<>(letras, tecladosVinculados);
            nuevoAlfabeto.put(nombreA,datosAlfabeto);
            configAlfabetos.put(nombreA, nuevoAlfabeto);
        }
    }
   */

/*
    public void modificarAlfabeto(String nombreA, ArrayList<Character> letras) {
        for (var entry : configAlfabetos.entrySet()) {
            if (entry.getKey().equals(nombreA)) {
                //String valorAnterior = entry.getValue();
                ArrayList<String> tecladosVinculados = entry.getValue().get(nombreA).getSecond();
                configAlfabetos.remove(entry.getKey());
                añadirAlfabeto(nombreA, letras, tecladosVinculados);
                return;
            }
        }
    }

 */
    /*
    public void eliminarAlfabeto(String nombreA) {
        for (var entry : configAlfabetos.entrySet()) {
            if (entry.getKey().equals(nombreA)) {
                configAlfabetos.remove(entry.getKey());
                return;
            }
        }
    }
     */

    /**
     * SE NECESITA UNA FUNCION DE ESTE TIPO PARA HACER EL TEST DE CONFIG.
     * TAMBIEN VA LIGADO A CTRLPRESENTACION
     * ES DE ANDYFRATELLO -> HAY QUE MODIFICARLA A NUESTRO CASO
     * Retorna una matriu d’Strings on cada entrada del primer index es un document i cada document té la data d'última
     * modificació, el nom del document i el path del document. Aquesta matriu esta ordenada per Data i hora de manera
     * descendent (Més recents primers), i si la data coincideix per nom del document.
     * @return Matriu de Strings
    public Vector<Vector<String>> simplify() {
    Vector<Vector<String>> res = new Vector<Vector<String>>();
    configDocs.forEach((keyDoc, pathDoc) -> {
    res.add(new Vector<> (List.of(keyDoc.first().toString(), keyDoc.second(), pathDoc)));
    });
    return res;
    }
    public Vector<Vector<String>> simplifyAlfabeto() {
    Vector<Vector<String>> resAlfabeto = new Vector<>();
    configAlfabetos.forEach(keyAlfabeto, pathAlfabeto) -> {
    resAlfabeto.add(new Vector<>(List.of(keyAlfabeto.)))
    };
    }*/
}