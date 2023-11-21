package test;

import main.domain.classes.Alfabeto;
import main.domain.classes.types.PairInt;
import main.domain.controllers.CtrlTecladoQAP;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestCtrlTecladoQAP {
    @Test
    public void TestCrearTeclado() {

    }

    @Test
    public void testCalculaDim() {
        int n = 10;
        CtrlTecladoQAP ctrlTecladoQAP = new CtrlTecladoQAP();
        PairInt dim = ctrlTecladoQAP.calculaDimensiones(n);
        PairInt sol = new PairInt(3,4);
        assertEquals(sol, dim);
    }
}
