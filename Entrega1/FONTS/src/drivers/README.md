# Directorio drivers

> Path absoluto: /FONTS/src/drivers

## Descripción del directorio
Este directorio contiene el código de los Drivers de los controladores que proporcionan alguna funcionalidad principal del sistema

## Elementos del directorio

- **DriverFP.java:**
  Contiene el código del driver del CtrlDominio (Proporciona todas las funcionalidades actuales del sistema)

Al ser ejecutado se muestra un menú con las posibles opciones a ejecutar. Se puede entrar el nombre o el título del método a probar.

Uso:

    0. Tancar el Driver
        Finalitza la execucio del Driver


    1. Alfabeto terminal
        Pregunta al usuario la información del alfabeto por terminal
        Guarda un alfabeto creado con un nombre y un contenido


    2. Alfabeto por archivo
        Pregunta al usuario la información del alfabeto por terminal pero entra un fichero en la carpeta INPUT_FILES
        Se lee el archivo adjuntado que es donde hay el contenido del alfabeto
        Guarda un alfabeto creado con un nombre y un contenido


    3. Texto terminal
        Pregunta al usuario la información del texto por terminal
        Guarda un texto creado con un nombre y un contenido


    4. Texto por archivo
        Pregunta al usuario la información del texto por terminal pero entra un fichero en la carpeta INPUT_FILES
        Se lee el archivo adjuntado que es donde hay el contenido del texto
        Guarda un texto creado con un nombre y un contenido


    5. Crear Asociacion
        Pide la informacion de la asociacion por terminal
        Crea una asociacion con textos y una lista de frecuebcias entre dos letras


    6. Crear Teclado
        Pide la informacion del teclado por terminal
        Crea un teclado con una asociacion de textos y un alfabeto


    7. Consultar lista alfabetos
        Muestra la lista de alfabetos existentes


    8. Consultar lista asociaciones
        Muestra la lista de asociaciones existentes


    9. Consultar lista textos
        Muestra la lista de textos existentes


    10. Consultar lista teclados
        Muestra la lista de teclados existentes


    11. Consultar Alfabeto
        Muestra la lista de alfabetos existentes
        Pide el nombre de un alfabeto de la lista
        Muestra el contendio del alfabeto seleccionado


    12. Consultar texto
        Muestra la lista de textos existentes
        Pide el nombre de un texto de la lista
        Muestra el contendio del texto seleccionado


    13. Consultar Teclado
        Muestra la lista de teclados existentes
        Pide el nombre de un teclado de la lista
        Muestra el contendio del teclado y el nombre del alfabeto y asociación asociados