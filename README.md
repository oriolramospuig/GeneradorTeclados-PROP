# PROP
Entregas de Proyectos de Programación (PROP) Q1 - UPC FIB
Nota final: 7.1

## Autores:
* [oriol.ramos.puig](oriol.ramos.puig@estudiantat.upc.edu)
* [alexia.mayor](alexia.mayor@estudiantat.upc.edu)
* [victor.moreno](victor.moreno@estudiantat.upc.edu)
* [julia.tena.domingo](julia.tena.domingo@estudiantat.upc.edu)

## Descripción del directorio 

### Comentarios

Muy importante probar el programa desde la carpeta subgrup-prop14.3. El path usado tiene en cuenta que la raíz del
proyecto sea esta carpeta.

Las vistas han estado creadas para una resolución de 1536x864. En caso de tener una resolución distinta
puede haber pequeñas variaciones.

El botón del manual de usuario solo funciona desde el IDE, haciendo make no funciona.

Alguna vez nos ha pasado, cómo hablamos en clase, que el seriazilableID provoca que no cargue alguno de los conjuntos. 
Para que vuelva a cargar, basta con agregar una unidad de dónde este el problema, es decir, si no cargan las asociaciones
agregamos una asociación, salimos de la interfaz y la volvemos a ejecutar. Eso actualizará el serializableID y ya funcionará,
pero deberemos ir con cuidado ya qué se cargará con la asociación creada, entonces habrá que cargar todo un estado entero,
para que no queden teclados creados con asociaciones inexistentes (por ejemplo habrá que cargar todo el EstadoAlgunosEstados).

### Makefile
El makefile está en la carpeta raíz, subgrup-prop14.3, por lo que para hacer make debemos colocarnos en esta carpeta.
Comandamientos a seguir: 
- make all 
- make ejecutable
- make ejecuta (en caso de querer volver a ejecutar)
- make jarInteractivo (para el driver interactivo)
- make clean (para limpiar)

## Descripción Makefile

- `make all`

      Compila todas las clases del sistema

- `make ejecutable`

      Compila i crea el ejecutable principal para iniciar el programa (Formato .jar) en el directorio `EXE` i lo ejecuta

- `make ejecuta`

      Executa el fitxer executable principal per tal d'iniciar el programa

- `make jar**NombreDriver**`

      Compila el código del sistema y el driver correspondiente y crea en un .jar ejecutable

      Ejemplo: make jarInteractivo -> crea el jar y lo ejecuta

- `make ejecutaDriver**NombreDriver**`

      Intenta executar el jar del Driver correspondiente

      Ejemplo: make ejecutaDriverInteractivo -> ejecuta el jar del Driver Interactivo

- `make fulltest`

      Ejecuta todos los test/tests suites de todas les clases

- `make Test**NombreTest/NombreSuite**`

      Ejecuta el/los test/tests NombreTest/NombreSuite

      - Tests
         1. fulltest
         2. functionstest
         3. typestest
         4. TestTeclado
         5. TestConjuntoTeclados
         6. TestTexto
         7. TestPalabras
         8. TestFrecuencias
         9. TestConjuntoTextos
         10. TestConjuntoAsociaciones
         11. TestConjuntoAlfabetos
         12. TestAsociacionTextos
         13. TestAlfabeto

- `make clean`

      Regla para limpiar los archivos generados

- `make distclean`

      Regla para limpiar todo (también elimina EXE)

