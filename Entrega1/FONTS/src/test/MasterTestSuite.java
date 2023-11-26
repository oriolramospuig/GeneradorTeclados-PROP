package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.types.TestSuiteTypes;
import test.functions.TestSuiteFunctions;

@RunWith(value = Suite.class)
@SuiteClasses(value = {
            TestAlfabeto.class, TestAsociacionTextos.class, TestConjuntoAlfabetos.class, TestConjuntoAsociaciones.class, TestConjuntoTeclados.class, TestConjuntoTextos.class, TestFrecuencias.class, TestPalabras.class, TestTeclado.class, TestTexto.class, TestSuiteTypes.class, TestSuiteFunctions.class
})

public class MasterTestSuite {}
