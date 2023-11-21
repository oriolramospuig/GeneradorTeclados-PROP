# PROP Grup 1.1
Projecte de Programació, Grup 11, subgrup 1.1. <br>Professor: Jordi Turmo ([turmo@cs.upc.edu]()).

## Membres del grup

- Oriol Ramos ([oriol.ramos.puig@estudiantat.upc.edu]())
- Alexia Mayor ([alexia.mayor@estudiantat.upc.edu]())
- Júlia Tena ([julia.tena.domingo@estudiantat.upc.edu]())
- Víctor Moreno ([victor.moreno@estudiantat.upc.edu]()).

## Elements del directori

### DOCS:
Conté tota la documentació del projecte: diagrama de casos d'ús amb descripció de cada un d'ells, diagrama estàtic
complet del model conceptual de dades en versió disseny amb breu descripció dels atributs i mètodes de les classes,
relació de les classes implementades per cada membre de l'equip, descripció de les estructures de dades i algorismes
emprats per implementar les funcionalitats de l'entrega.

### EXE:
Fitxers executables (*.class*) de totes les classes que permeten provar les funcionalitats principals implementades.
Hi ha subdirectoris per cada un dels tipus de classes: test, excepcions, funcions, tipus, que segueixen l'estructura
determinada pels *packages*

### FONTS:
Codi de les classes de domini associades a les funcionalitats principals implementades fins al moment. Inclou també els
tests JUnit. Tots els fitxers estan dins dels subdirectoris que segueixen l'estructura de packages, perquè el codi sigui
recompilable directament. També inclou el fitxer *Makefile*.

### lib:
S'hi troben les llibreries externes que hem hagut d'utilitzar per als tests JUnit.

## Provar el programa

Per a executar el programa cal anar al directori `/FONTS/src`, que és on es troba el *Makefile* del programa. Es
construeix el sistema entrant `make` a la consola i es podrà provar totes les classes individualment a través dels
drivers.
