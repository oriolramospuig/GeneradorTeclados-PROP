package drivers;

import main.domain.classes.AsociacionTextos;
import main.domain.classes.Palabras;
import main.domain.classes.types.PairFrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DriverProva {
    public static void main(String[] args) {
        Palabras p = new Palabras("t1", "hola hola hola");
        HashMap<String, Integer> f = p.getFrecuenciaLetras();
        for (HashMap.Entry<String, Integer> e : f.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        AsociacionTextos at = new AsociacionTextos("at1");
        at.agregarTexto(p);
        ArrayList<PairFrequency> af = at.getFrecuenciaLetras();
        System.out.println("-----------------");
        for (PairFrequency pf : af) {
            System.out.println(pf.getPair() + " " + pf.getFrequency());
        }
    }
}
