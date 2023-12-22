# Directorio FONTS

> Path absoluto: /FONTS

## Descripción del directorio
Este directorio contiene distintos directorios que hacen referencia a distintos estados de la caché (persistencia del programa). Además, también contiene otro directorio que contiene los alfabetos y textos que se quieren añadir por archivo.

## Elementos del directorio
- **Directorio Cache:**
  Contiene los ficheros conjuntoAlfabetos, conjuntoTextos, conjuntosAsociaciones, conjuntosTeclados que hacen referencia a la memoria del programa. Son los que se usan al ejecutar el programa.


- **Directorio EstadoVacío:**
  Contiene los ficheros conjuntoAlfabetos, conjuntoTextos, conjuntosAsociaciones, conjuntosTeclados vacíos, es decir, se usan en el momento de iniciar el programa y querer empezarlo de cero.


- **Directorio EstadoAPartirCache:**
  Contiene los ficheros conjuntoAlfabetos, conjuntoTextos, conjuntosAsociaciones, conjuntosTeclados que guardan el contenido de los elementos una vez se ha iniciado desde cero.


- **Directorio EstadoAlgunosCasos:**
  Contiene los ficheros conjuntoAlfabetos, conjuntoTextos, conjuntosAsociaciones, conjuntosTeclados que tienen el contenido de algunas estructuras.
  - Alfabetos creados: Easy, Catalan, Numeros
  - Textos creados: EasyFrecuencias, Catalan1, Catalan2, CatalanFrecuencias NumerosPalabaras
  - Asociaciones creadas: Easy, Catalan, Numeros
  - Teclados creados: Easy, Catalan, Numeros


- **Directorio EstadoMuyCompleto:**
  Contiene los ficheros conjuntoAlfabetos, conjuntoTextos, conjuntosAsociaciones, conjuntosTeclados que tienen el contenido de muchas estructuras.
  - Alfabetos creados: Easy, Random, TildesMath, Catalan, Numeros, Sencillo
  - Textos creados: EasyPalabras, EasyFrecuencias, Random1, Random2, Tildes+Math1, Tildes+Math2, Catalan1, Catalan2, Catalan3, Catalan4, CatalanFrecuencias, NumerosPalabaras, NumerosFrecuencias, SencilloPalabras, SencilloFrecuencias  
  - Asociaciones creadas: Easy, Random, Tildes+Math, Catalan, Numeros, Sencillo
  - Teclados creados: Easy, Random, Tildes+Math, Catalan, Numeros, Sencillo


- **Directorio InputFiles:**
  Contiene dos directorios (Alfabetos y Textos) que contienen los alfabetos y textos, respectivamente, en formato .txt.