CLASS_INPUT =	./main/domain/classes/*.java \
				./main/domain/classes/functions/*.java \
				./main/domain/classes/exceptions/*.java \
				./main/domain/classes/types/*.java \
				./main/domain/controllers/*.java

CLASS_OUTPUT =	../../EXE/out/

JAR_OUTPUT =	../../EXE/

JUNIT_JARS = ../../lib/junit-4.12.jar:../../lib/hamcrest-core-1.3.jar

JUNIT_TESTS = ./test/*.java \
			  ./test/types/*.java \
			  ./test/functions/*.java

FUNCIONS_TESTS =		./test/functions/*.java

TYPE_TESTS =			./test/types/*.java

INTERPRET_CLASS_INPUT =	./main/domain/classes/functions/*.java \
						./main/domain/classes/types/*.java \
						./main/domain/classes/exceptions/*.java \
						./main/domain/controllers/CtrlAlfabeto.java \
						./main/domain/controllers/CtrlAsociacionTexto.java \
						./main/domain/controllers/CtrlDominio.java \
						./main/domain/controllers/CtrlTeclado.java \
						./main/domain/controllers/CtrlTexto.java \

TYPE_CLASS_INPUT =		./main/domain/classes/types/PairFrequency.java \
						./main/domain/classes/types/PairInt.java

ALPHABET_CLASS_INPUT =	./main/domain/controllers/CtrlAlfabeto.java \
						./main/domain/classes/Alfabeto.java

CLASS_SOURCES =			$(CLASS_OUTPUT)drivers/*.class \
						$(CLASS_OUTPUT)main/domain/classes/*.class \
						$(CLASS_OUTPUT)main/domain/classes/exceptions/*.class \
						$(CLASS_OUTPUT)main/domain/classes/functions/*.class \
						$(CLASS_OUTPUT)main/domain/classes/types/*.class \
						$(CLASS_OUTPUT)main/domain/controllers/*.class

all:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT)
	javac -cp $(JUNIT_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT) $(JUNIT_TESTS)

jarAlfabeto:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT) ./drivers/DriverAlfabeto.java
	jar cmvf ./drivers/Alfabeto.mf $(JAR_OUTPUT)DriverAlfabeto.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)DriverAlfabeto.jar

jarTexto:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT) ./drivers/DriverTexto.java
	jar cmvf ./drivers/Texto.mf $(JAR_OUTPUT)DriverTexto.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)DriverTexto.jar

jarTeclado:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT) ./drivers/DriverTeclado.java
	jar cmvf ./drivers/Teclado.mf $(JAR_OUTPUT)DriverTeclado.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)DriverTeclado.jar

jarDominio:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT) ./drivers/DriverDominio.java
	jar cmvf ./drivers/Dominio.mf $(JAR_OUTPUT)DriverDominio.jar -C $(CLASS_OUTPUT) .
	java -jar $(JAR_OUTPUT)DriverDominio.jar
jars:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT) ./drivers/DriverAlfabeto.java ./drivers/DriverTexto.java ./drivers/DriverDominio.java ./drivers/DriverTeclado.java
	jar cmvf ./drivers/Alfabeto.mf $(JAR_OUTPUT)DriverAlfabeto.jar -C $(CLASS_OUTPUT) .
	jar cmvf ./drivers/Texto.mf $(JAR_OUTPUT)DriverTexto.jar -C $(CLASS_OUTPUT) .
	jar cmvf ./drivers/Dominio.mf $(JAR_OUTPUT)DriverDominio.jar -C $(CLASS_OUTPUT) .
	jar cmvf ./drivers/Teclado.mf $(JAR_OUTPUT)DriverTeclado.jar -C $(CLASS_OUTPUT) .

executaDriverDomini:
	java -jar $(JAR_OUTPUT)DriverDominio.jar

executaDriverDocument:
	java -jar $(JAR_OUTPUT)DriverAlfabeto.jar

executaDriverClipboard:
	java -jar $(JAR_OUTPUT)DriverTexto.jar

executaDriverCelaSeleccionada:
	java -jar $(JAR_OUTPUT)DriverTeclado.jar

executaDriverPresentacio:
	java -jar $(JAR_OUTPUT)DriverPresentacio.jar
buildfuncions:
	javac -d $(CLASS_OUTPUT) $(INTERPRET_CLASS_INPUT)
	javac -cp $(JUNIT_JARS) -d $(CLASS_OUTPUT) $(INTERPRET_CLASS_INPUT) $(FUNCIONS_TESTS)

buildtypes:
	javac -d $(CLASS_OUTPUT) $(TYPE_CLASS_INPUT)
	javac -cp $(JUNIT_JARS) -d $(CLASS_OUTPUT) $(TYPE_CLASS_INPUT) $(TYPE_TESTS)

fulltest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.MasterTestSuite

TestSuiteFuncions: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.functions.TestSuiteFuncions

TestSuiteTipus: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.types.TestSuiteTipus

TestInterpret: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.functions.TestInterpret

TestAlfabeto: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestAlfabetp

TestConjuntoAlfabetos: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestConjuntoAlfabetos

TestConjuntoAsociaciones: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestConjuntoAsociaciones

TestConjuntoTeclados: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestConjuntoTeclados

TestTexto: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestTexto

TestConjuntoTextos: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TestConjuntoTextos

clean:
	rm -r ../../EXE/out/*

distclean:
	rm -r ../../EXE/*