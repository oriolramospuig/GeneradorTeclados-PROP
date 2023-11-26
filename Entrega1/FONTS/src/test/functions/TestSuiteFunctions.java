package test.functions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)

@SuiteClasses(value = {
        TestGilmoreLawler.class, TestHungarianAlgorithm.class, TestManhattan.class, TestMatrices.class, TestQAP.class
})

public class TestSuiteFunctions {}
