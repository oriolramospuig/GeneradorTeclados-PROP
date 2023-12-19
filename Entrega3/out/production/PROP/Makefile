# Rutas de los archivos fuente y de salida
CLASS_INPUT_MAIN = ./main/domain/classes/*.java \
						./main/domain/classes/functions/*.java \
						./main/domain/classes/types/*.java \
						./main/domain/controllers/*.java \
						./main/presentation/controllers/*.java \
						./main/presentation/views/*.java \
						./main/persistence/classes/*.java \
						./main/persistence/controllers/*.java
CLASS_INPUT_DRIVER = ./drivers/*.java
CLASS_INPUT_TESTS = ./test/*.java \
						./test/functions/*.java \
						./test/types/*.java

CLASS_INPUT_ALL = $(CLASS_INPUT_MAIN) $(CLASS_INPUT_DRIVER) $(CLASS_INPUT_TESTS)

CLASS_OUTPUT = ../../EXE/
JAR_OUTPUT = ../../EXE/

# Rutas de las bibliotecas de JUnit
JUNIT_JARS = ../../lib/junit-4.12.jar:../../lib/hamcrest-core-1.3.jar:../../lib/mockito-core-4.9.0.jar

# Regla principal para compilar todo
all: compile_main compile_driver compile_tests

ejecutable:
	javac -cp $(JUNIT_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT_ALL)
	jar cmvf ./drivers/Presentacion.mf $(JAR_OUTPUT)PROP14-3.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)PROP14-3.jar

ejecuta:
	java -jar $(JAR_OUTPUT)PROP14-3.jar

jarInteractivo:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT) ./drivers/DriverInteractivoQAP.java
	jar cmvf ./drivers/Interactivo.mf $(JAR_OUTPUT)DriverInteractivoQAP.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)DriverInteractivoQAP.jar

jarPersistencia:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT) ./drivers/DriverPersistencia.java
	jar cmvf ./drivers/Persistencia.mf $(JAR_OUTPUT)DriverPersistencia.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)DriverPersistencia.jar

jarPresentacion:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT) ./drivers/DriverPresentacion.java
	jar cmvf ./drivers/Presentacion.mf $(JAR_OUTPUT)DriverPresentacion.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)DriverPresentacion.jar

ejecutaDriverInteractivo:
	java -jar $(JAR_OUTPUT)DriverInteractivoQAP.jar

ejecutaDriverPersistencia:
	java -jar $(JAR_OUTPUT)DriverPersistencia.jar

ejecutaDriverPresentacion:
	java -jar $(JAR_OUTPUT)DriverPresentacion.jar

# Regla para compilar las clases del modelo (Main)
compile_main:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT_MAIN)

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

# Regla para limpiar los archivos generados
clean:
	rm -rf $(CLASS_OUTPUT)*

# Regla para limpiar todo (también elimina EXE)
distclean: clean
	rm -rf ../EXE
