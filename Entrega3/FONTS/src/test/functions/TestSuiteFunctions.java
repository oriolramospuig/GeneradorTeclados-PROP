package test.functions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Clase que testea todas las clases que estan dentro del directorio Test-Functions
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */

@RunWith(value = Suite.class)
@SuiteClasses(value = {
        TestGilmoreLawler.class, TestHungarianAlgorithm.class, TestManhattan.class, TestMatrices.class, TestQAP.class
})

public class TestSuiteFunctions {}
