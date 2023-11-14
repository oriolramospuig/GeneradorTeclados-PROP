package test;


import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;
import main.domain.classes.Teclado;
import org.junit.Before;

public class TestConjuntoTeclados {
    private ConjuntoTeclados teclados;

    private Teclado teclado1;

    private Teclado teclado2;

    @Before
    public void setUp() {
        teclados = new ConjuntoTeclados();
        teclado1 = new Teclado("ABC");
        teclado2 = new Teclado("XYZ");
    }


}
