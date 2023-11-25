# PROP Grupo 14.3
Proyectos de Programación, Grupo 14, subgrup 14.3 <br>Profesora: Alicia Ageno ([ageno@cs.upc.edu]()).

## Miembros del grupo

- Oriol Ramos ([oriol.ramos.puig@estudiantat.upc.edu]())
- Alexia Mayor ([alexia.mayor@estudiantat.upc.edu]())
- Júlia Tena ([julia.tena.domingo@estudiantat.upc.edu]())
- Víctor Moreno ([victor.moreno@estudiantat.upc.edu]()).

## Elementos del directorio

### DOCS:
Contiene toda la documentación del proyecto: diagrama de casos de uso con descripción de cada uno de ellos, diagrama
estático completo del modelo conceptual de datos en versión diseño con breve descripción de los atributos y métodos
de las clases, relación de las clases implementadas por cada miembro del equipo, descripción de las estructuras de 
datos y algoritmos empleados para implementar las funcionalidades de la entrega.

### EXE:
Archivos ejecutables (*.class*) de todas las clases que permiten probar las funcionalidades principales implementadas.
Hay subdirectorios para cada uno de los tipos de clases: test, excepciones, funciones, tipos, que siguen la estructura
determinada por los *packages*

### FONTS:
Código de las clases de dominio asociadas a las funcionalidades principales implementadas hasta el momento. Incluye
también los tests JUnit. Todos los archivos están dentro de los subdirectorios que siguen la estructura de paquetes,
para que el código sea recompilable directamente. También incluye el archivo *Makefile*.

### lib:
Se encuentran las librerias externas que hemos tenido que utilizar para los tests JUnit.

## Probar el programa

Para ejecutar el programa debemos ir al directorio `/FONTS/src`, que es donde se encuentra el *Makefile* del programa. 
Se construye el sistema entrando `make` a la consola i se podrá probar todas las clases individualmente a través de los
drivers.
