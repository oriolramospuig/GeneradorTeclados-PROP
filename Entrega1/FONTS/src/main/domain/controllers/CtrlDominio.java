package main.domain.controllers;

import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;
import main.domain.classes.ConjuntoTextos;
import main.domain.classes.functions.InOut;

public class CtrlDominio {

    private InOut inOut;
    private ConjuntoAlfabetos conjuntoAlfabetos;
    private ConjuntoTextos conjuntoTextos;
    private ConjuntoTeclados conjuntoTeclados;
    private CtrlAlfabeto ctrlAlfabeto;
    private CtrlTexto ctrlTexto;
    private CtrlTeclado ctrlTeclado;

    public CtrlDominio() {
        conjuntoAlfabetos = new ConjuntoAlfabetos();
        conjuntoTextos = new ConjuntoTextos();
        conjuntoTeclados = new ConjuntoTeclados();
    }


    public boolean agregarAlfabeto(String nomA, String entradaCaracteres){
        //Verifica que la entrada de caracteres es válida.
        return ctrlAlfabeto.CrearAlfabeto(nomA,entradaCaracteres);
    }
    public boolean borrarAlfabeto(String nomA){
        //Verifica que la entrada de caracteres es válida.
        return ctrlAlfabeto.borrarAlfabeto(nomA);
    }

    public boolean agregarTexto(String nomT, String frecuenciasLetras){
        //Verifica que la entrada de caracteres es válida.
        return ctrlTexto.agregarTexto(nomT,frecuenciasLetras);
    }

    public boolean borrarTexto(String nomT){
        //Verifica que la entrada de caracteres es válida.
        //return ctrlTexto.borrarTexto(nomT);
        return false;
    }
}
