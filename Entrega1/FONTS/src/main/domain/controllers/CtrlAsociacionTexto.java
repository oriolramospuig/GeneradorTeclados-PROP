package main.domain.controllers;

import main.domain.classes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CtrlAsociacionTexto {

    // ---------- PARÁMETROS ----------
    private ConjuntoAsociaciones AsociacionesTextos;

    private ConjuntoTeclados conjuntoTeclados;

    public CtrlAsociacionTexto(){ AsociacionesTextos = null;}

    public void agregarAsociacionTextoVinculada (String nomAT,String nomT) {
        AsociacionesTextos.getAsociacionTextos(nomAT).agregarTecladoVinculado(nomT);
    }

    public void borrarAsociacionTextoVinculada(String nomAT, String nomT) {
        AsociacionesTextos.getAsociacionTextos(nomAT).borrarTecladoVinculado(nomT);
    }

    public ConjuntoAsociaciones getCjtAsociaciones() {return AsociacionesTextos;}

    /**Potser està malament, revisar*/
    public boolean CrearAsociacionTextos(String nomAT, HashMap<String, Integer> frecuenciaLetras) {
        if(!AsociacionesTextos.existeAsociaciondeTextos(nomAT)){
            AsociacionTextos AT = new AsociacionTextos(nomAT, frecuenciaLetras);
            AsociacionesTextos.agregarAsociacionTexto(nomAT,AT);
            return true;
        }
        return false;
    }

    /**
     * No retorna nada.
     * Manda borrar el alfabeto dado, desvincula los teclados asociados
     * también borra este alfabeto de la lista de ConjuntoAlfabetos
     */

    /* FUNCIO COMENTADA PQ DONA UN ERROR
    public void borrarAsociacionTextos(String nomAT){
        // mirar error d'aquesta linia, diu algo de static
        ArrayList<String> tVinculado = ConjuntoAsociaciones.getAsociacionTextos(nomAT).getTecladosVinculados();
        if(!tVinculado.isEmpty()) {
            for (int i = 0; i < tVinculado.size(); ++i){
                conjuntoTeclados.borrarTeclado(tVinculado.get(i));
            }
            AsociacionesTextos.borrarAsociacionTextos(nomAT);
        }
    }
     */
}
