package test.types;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Clase que testea todas las clases que estan dentro del directorio Test-Types
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */

@RunWith(value = Suite.class)
@SuiteClasses(value = {
        TestPairFrequency.class, TestPairInt.class
})

public class TestSuiteTypes {}