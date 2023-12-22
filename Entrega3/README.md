# PROP Grupo 14.3
Proyectos de Programación, Grupo 14, subgrup 14.3 <br>Profesora: Alicia Ageno ([ageno@cs.upc.edu]()).

## Miembros del grupo

- Oriol Ramos ([oriol.ramos.puig@estudiantat.upc.edu]())
- Alexia Mayor ([alexia.mayor@estudiantat.upc.edu]())
- Júlia Tena ([julia.tena.domingo@estudiantat.upc.edu]())
- Víctor Moreno ([victor.moreno@estudiantat.upc.edu]()).

## Elementos del directorio

### DOCS:
Contiene tota la documentación referente a los tests de integración de todo el proyecto, relación de las clases implementadas por
miembro del equipo y la documentación Javadoc de todo el código.

### EXE:
Archivos ejecutables (*.class*) de todas las clases que permiten probar las funcionalidades principales implementadas.
Hay subdirectorios para cada uno de los tipos de clases: test, excepciones, funciones, tipos, que siguen la estructura
determinada por los *packages*

### FONTS:
Código de las clases de dominio, persisténcia i presentación asociados a las funcionalidades principals. Incluye también los
tests JUnit. Todos los ficheros están dentro de los subdirectorios que siguen la estructura de packages, porque el código sea
compilable directamente.

### lib:
Se encuentran las librerías externas que hemos tenido que utilizar para los tests JUnit.

## Probar el programa

Para ejecutar el programa debemos ir al directorio raíz, que es donde se encuentra el *Makefile* del programa. 
Se construye el sistema entrando `make` a la consola y se podrá probar todas las clases individualmente a través de los
drivers.
