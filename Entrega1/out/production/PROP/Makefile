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
CLASS_OUTPUT = ../../EXE/
JAR_OUTPUT = ../../EXE/

# Rutas de las bibliotecas de JUnit
JUNIT_JARS = ../../lib/junit-4.12.jar:../../lib/hamcrest-core-1.3.jar:../../lib/mockito-core-4.9.0.jar

# Regla principal para compilar todo
all: compile_main compile_driver compile_tests

# Regla para compilar las clases del modelo (Main)
compile_main:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT_MAIN)

# Regla para compilar los drivers
compile_driver:
	javac -cp $(CLASS_OUTPUT):$(JUNIT_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT_DRIVER)

# Regla para compilar los tests con JUnit
compile_tests:
	javac -cp $(CLASS_OUTPUT):$(JUNIT_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT_TESTS)

MasterTestSuite: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.MasterTestSuite

TestSuiteFunctions: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.functions.TestSuiteFunctions

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

DriverPersistencia: all
	java -cp $(CLASS_OUTPUT) drivers.DriverPersistencia

DriverPresentacion: all
	java -cp $(CLASS_OUTPUT) drivers.DriverPresentacion

DriverInteractivo: all
	java -cp $(CLASS_OUTPUT) drivers.DriverInteractivoQAP

# Regla para limpiar los archivos generados
clean:
	rm -rf $(CLASS_OUTPUT)*

# Regla para limpiar todo (también elimina EXE)
distclean: clean
	rm -rf ../EXE
