# Rutas de los archivos fuente y de salida
CLASS_INPUT_MAIN = Entrega3/FONTS/src/main/domain/classes/*.java \
                   Entrega3/FONTS/src/main/domain/classes/functions/*.java \
                   Entrega3/FONTS/src/main/domain/classes/types/*.java \
                   Entrega3/FONTS/src/main/domain/controllers/*.java \
                   Entrega3/FONTS/src/main/presentation/controllers/*.java \
                   Entrega3/FONTS/src/main/presentation/views/*.java \
                   Entrega3/FONTS/src/main/persistence/classes/*.java \
                   Entrega3/FONTS/src/main/persistence/controllers/*.java
CLASS_INPUT_DRIVER = Entrega3/FONTS/src/drivers/*.java

CLASS_INPUT_TESTS = Entrega3/FONTS/src/test/*.java \
                    Entrega3/FONTS/src/test/functions/*.java \
                    Entrega3/FONTS/src/test/types/*.java

CLASS_INPUT_ALL = $(CLASS_INPUT_MAIN) $(CLASS_INPUT_DRIVER) $(CLASS_INPUT_TESTS)

CLASS_OUTPUT = Entrega3/EXE/
JAR_OUTPUT = Entrega3/EXE/

JUNIT_JARS = Entrega3/lib/junit-4.12.jar:Entrega3/lib/hamcrest-core-1.3.jar:Entrega3/lib/mockito-core-4.9.0.jar

# Regla principal para compilar todo
all: compile_InOut compile_main compile_driver compile_tests

ejecutable:
	javac -cp $(JUNIT_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT_ALL)
	jar cmvf Entrega3/FONTS/src/drivers/Presentacion.mf $(JAR_OUTPUT)PROP14-3.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)PROP14-3.jar

ejecuta:
	java -jar $(JAR_OUTPUT)PROP14-3.jar

jarInteractivo:
	javac -cp "$(CLASS_OUTPUT):$(JUNIT_JARS)" -d $(CLASS_OUTPUT) Entrega3/FONTS/src/drivers/DriverInteractivoQAP.java
	jar cmvf Entrega3/FONTS/src/drivers/Interactivo.mf $(JAR_OUTPUT)DriverInteractivoQAP.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)DriverInteractivoQAP.jar

jarPresentacion:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT_ALL) Entrega3/FONTS/src/drivers/DriverPresentacion.java
	jar cmvf Entrega3/FONTS/src/drivers/Presentacion.mf $(JAR_OUTPUT)DriverPresentacion.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)DriverPresentacion.jar

ejecutaDriverInteractivo:
	java -jar $(JAR_OUTPUT)DriverInteractivoQAP.jar

ejecutaDriverPresentacion:
	java -jar $(JAR_OUTPUT)DriverPresentacion.jar

# Define la regla para compilar solo la clase InOut
compile_InOut:
	javac -cp ".;$(CLASS_OUTPUT);$(JUNIT_JARS)" -d $(CLASS_OUTPUT) Entrega3/FONTS/src/drivers/InOut.java

# Regla para compilar las clases del modelo (Main)
compile_main:
	javac -cp "$(JUNIT_JARS):$(CLASS_OUTPUT)" -d $(CLASS_OUTPUT) $(CLASS_INPUT_MAIN)

# Regla para compilar los drivers
compile_driver:
	javac -cp $(CLASS_OUTPUT):$(JUNIT_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT_DRIVER)

# Regla para compilar los tests con JUnit
compile_tests:
	javac -cp $(CLASS_OUTPUT):$(JUNIT_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT_TESTS)

fulltest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.MasterTestSuite

functionstest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.functions.TestSuiteFunctions

typestest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.types.TestSuiteTypes

TestTeclado: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestTeclado

TestConjuntoTeclados: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestConjuntoTeclados

TestTexto: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestTexto

TestPalabras: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestPalabras

TestFrecuencias: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestFrecuencias

TestConjuntoTextos: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestConjuntoTextos

TestConjuntoAsociaciones: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestConjuntoAsociaciones

TestConjuntoAlfabetos: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestConjuntoAlfabetos

TestAsociacionTextos: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestAsociacionTextos

TestAlfabeto: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestAlfabeto

# Reglas para limpiar los archivos generados
clean:
	rm -rf $(CLASS_OUTPUT)*

# Regla para limpiar todo (también elimina EXE)
distclean: clean
	rm -rf Entrega3/EXE
