# Rutas de los archivos fuente y de salida
CLASS_INPUT_MAIN = ./main/*.java
CLASS_INPUT_DRIVER = ./drivers/*.java
CLASS_INPUT_TESTS = ./test/*.java
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

TestTeclado: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore Tests.TestTeclado

TestConjuntoTeclados: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore Tests.TestConjuntoTeclados

TestTexto: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore Tests.TestTexto

TestPalabras: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore Tests.TestPalabras

TestFrecuencias: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore Tests.TestFrecuencias

TestConjuntoTextos: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore Tests.TestConjuntoTextos

TestConjuntoAsociaciones: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore Tests.TestConjuntoAsociaciones

TestConjuntoAlfabetos: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore Tests.TestConjuntoAlfabetos

TestAsociacionTextos: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore Tests.TestAsociacionTextos

TestAlfabeto: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore Tests.TestAlfabeto


DriverFP: all
	java -cp $(CLASS_OUTPUT) Driver.DriverFP

# Regla para limpiar los archivos generados
clean:
	rm -rf $(CLASS_OUTPUT)*

# Regla para limpiar todo (también elimina EXE)
distclean: clean
	rm -rf ../EXE
