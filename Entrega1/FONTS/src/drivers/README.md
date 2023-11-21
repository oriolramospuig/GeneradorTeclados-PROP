# Directorio drivers

> Path absoluto: /FONTS/src/drivers

## Descripción del directorio
Este directorio contiene el código de los Drivers de los controladores que proporcionan alguna funcionalidad principal del sistema

## Elementos del directorio

- **DriverFP.java:**
  Contiene el código del driver del CtrlDominio (Proporciona todas las funcionalidades actuales del sistema)

Al ser ejecutado se muestra un menú con las posibles opciones a ejecutar. Se puede entrar el nombre o el título del método a probar.

Uso:
//Agregar
System.out.println("(1|AlfabetoPorTerminal) - Añadir Alfabeto");
System.out.println("(2|AlfabetoPorArchivo) - Añadir Alfabeto");
System.out.println("(3|TextoPorTerminal) - Añadir Texto");
System.out.println("(4|TextoPorArchivo) - Añadir Texto");
//Crear
System.out.println("(5|CrearAsociacionTextos) - Crear Asociación Textos");
System.out.println("(6|CrearTeclado) - Crear Teclado");
//Consultar
System.out.println("(7|ConsultarlistaAlfabetos) - Consultar Lista Alfabetos");
System.out.println("(8|ConsultarlistaAsociaciones) - Consultar Lista Asociaciones");
System.out.println("(9|ConsultarlistaTextos) - Consultar Lista Textos");
System.out.println("(10|ConsultarlistaTeclados) - Consultar Lista Teclados");
System.out.println("(11|ConsultarAlfabeto) - Consultar Alfabeto");
System.out.println("(12|ConsultarTexto) - Consultar Texto");

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
    

    