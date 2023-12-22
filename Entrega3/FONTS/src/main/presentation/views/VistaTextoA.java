package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Vista para agregar un nuevo texto.
 * <p>
 * Esta vista permite al usuario agregar un nuevo texto al sistema, especificando su nombre y su contenido.
 * El usuario puede introducir el contenido del texto manualmente o cargarlo desde un archivo.
 * La vista incluye validaciones para asegurar que el nombre del texto sea único y que se haya proporcionado el contenido adecuadamente.
 * Incluye botones para agregar el texto, seleccionar un archivo y volver al menú principal.
 * @author Alèxia Mayor (alexia.mayor@estudiantat.upc.edu)
 */

public class VistaTextoA extends JFrame {
    /** Panel donde se incluyen los elementos de la ventana.*/
    private final JPanel lamina = new JPanel();
    /** Título1 de la ventana. */
    private final JLabel tituloVistaTxtA = new JLabel("Agregar texto de palabras");

    /** Título2 de la ventana. */
    private final JLabel tituloVistaTxtA1 = new JLabel("Agregar texto de frecuencias");

    /** Botón para agregar un texto en formato palabras. */
    private final JButton bAgregarTexto = new JButton("Agregar texto de palabras");

    /** Botón para agregar un texto en formato frecuencias.*/
    private final JButton bAgregarTextoFrec = new JButton("Agregar texto de frecuencias");

    /** Botón para seleccionar un texto de archivo en formato palabras.*/
    private final JButton bSeleccionarArchivoPalabras = new JButton("Seleccionar Archivo");

    /** Botón para agregar un texto de archivo en formato frecuencias.*/
    private final JButton bSeleccionarArchivoFrecuencias = new JButton("Seleccionar Archivo");

    /** Botón de volver a la pantalla del menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    //TEXTOS Y AREAS DE TEXTO
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto (en formato palabras). */
    private final JLabel txtNombreTxtA = new JLabel("NOMBRE:");

    /** Área de texto para introducir el nombre del texto que se quiere crear (en formato palabras). */
    private final JTextArea areanomTxtA = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del texto (en formato palabras). */
    private final JLabel txtContenidoTxtA = new JLabel("CONTENIDO:");


    /** Área de texto para introducir el contenido del texto que se quiere crear (en formato palabras). */
    private final JTextArea areaContenidoTxtA = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el path del texto, para saber donde esta guardado (en formato palabras). */
    private final JLabel txtPathTxtA = new JLabel("PATH:");

    /** Área de texto para introducir el path del texto que se quiere crear (en formato palabras).*/
    private final JTextArea areaPathTxtA = new JTextArea();

    /** Texto explicando las instrucciones de como entrar el texto en caso de palabras */
    private final JLabel txtInstruccionesTxtA = new JLabel("(Hay que añadir un texto del formato palabras en frases. Ej: Hola que tal)");

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto (en formato frecuencias).*/
    private final JLabel txtNombreTxtA1 = new JLabel("NOMBRE:");

    /** Área de texto para introducir el nombre del texto que se quiere crear (en formato frecuencias).*/
    private final JTextArea areanomTxtA1 = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del texto (en formato frecuencias).*/
    private final JLabel txtContenidoTxtA1 = new JLabel("CONTENIDO:");

    /** Área de texto para introducir el contenido del texto que se quiere crear (en formato frecuencias).*/
    private final JTextArea areaContenidoTxtA1 = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el path del texto, para saber donde esta guardado (en formato frecuencias).*/
    private final JLabel txtPathTxtA1 = new JLabel("PATH:");

    /** Área de texto para introducir el path del texto que se quiere crear (en formato frecuencias). */
    private final JTextArea areaPathTxtA1 = new JTextArea();

    /** Texto explicando las instrucciones de como entrar el texto en caso de palabras */
    private final JLabel txtInstruccionesTxtA1 = new JLabel("(Hay que añadir un texto del formato palabras con sus rescpectivas");
    /** Texto explicando las instrucciones de como entrar el texto en caso de palabras */
    private final JLabel txtInstruccionesTxtA2 = new JLabel("frecuencias separadas por un espacio. Ej: hola 5)");

    /**
     * Constructor de la clase VistaTextoA.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para la adición de un nuevo texto, ya sea manualmente o mediante un archivo.
     */
    public VistaTextoA(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades texto);

        // Título ventana superior
        tituloVistaTxtA.setBounds(10, 5, 200, 30);
        add(tituloVistaTxtA);

        // Título ventana superior2
        tituloVistaTxtA1.setBounds(510, 5, 200, 30);
        add(tituloVistaTxtA1);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTxtA.setBounds(30, 140, 200, 20);
        add(txtNombreTxtA);

        // Área texto Nombre
        areanomTxtA.setBounds(230,140, 200,20);
        add(areanomTxtA);

        // Texto Contenido
        txtContenidoTxtA.setBounds(30, 180, 200, 20);
        add(txtContenidoTxtA);


        JScrollPane scrollPane0 = new JScrollPane(areaContenidoTxtA); // Para agregar scroll al área de texto
        scrollPane0.setBounds(230, 180, 200, 90); // Ajusta las dimensiones según tus necesidades
        add(scrollPane0);

        // Texto Path
        txtPathTxtA.setBounds(30, 280, 200, 20);
        add(txtPathTxtA);

        // Área texto Path
        JScrollPane scrollPane = new JScrollPane(areaPathTxtA);
        scrollPane.setBounds(230, 280, 200, 60);
        add(scrollPane);

        // Texto Instrucciones
        txtInstruccionesTxtA.setBounds(30, 360, 500, 20);
        add(txtInstruccionesTxtA);


        //VENTANA SUPERIOR2
        // Texto Nombre
        txtNombreTxtA1.setBounds(550, 140, 200, 20);
        add(txtNombreTxtA1);

        // Área texto Nombre
        areanomTxtA1.setBounds(750,140, 200,20);
        add(areanomTxtA1);

        // Texto Contenido
        txtContenidoTxtA1.setBounds(550, 180, 200, 20);
        add(txtContenidoTxtA1);

        JScrollPane scrollPane1 = new JScrollPane(areaContenidoTxtA1); // Para agregar scroll al área de texto
        scrollPane1.setBounds(750, 180, 200, 90); // Ajusta las dimensiones según tus necesidades
        add(scrollPane1);

        // Texto Path
        txtPathTxtA1.setBounds(550, 280, 200, 20);
        add(txtPathTxtA1);

        JScrollPane scrollPane2 = new JScrollPane(areaPathTxtA1);
        scrollPane2.setBounds(750, 280, 200, 60);
        add(scrollPane2);

        // Texto Instrucciones
        txtInstruccionesTxtA1.setBounds(550, 360, 500, 20);
        add(txtInstruccionesTxtA1);

        // Texto Instrucciones2
        txtInstruccionesTxtA2.setBounds(550, 380, 500, 20);
        add(txtInstruccionesTxtA2);


        //BOTONES
        // Botón agregar texto palabras
        bAgregarTexto.setBounds(230, 400, 200, 20);
        add(bAgregarTexto);

        // Botón agregar texto frecuencias
        bAgregarTextoFrec.setBounds(750, 400, 200, 20);
        add(bAgregarTextoFrec);

        bSeleccionarArchivoPalabras.setBounds(230, 340, 150, 20);
        add(bSeleccionarArchivoPalabras);

        // Configurar el botón Seleccionar Archivo Frecuencias
        bSeleccionarArchivoFrecuencias.setBounds(750, 340, 150, 20);
        add(bSeleccionarArchivoFrecuencias);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "//Entrega3//data//InputFiles//Textos//");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo de Texto", "txt"));

        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTexto = areanomTxtA.getText().trim();
                String contenidoTexto = areaContenidoTxtA.getText();
                String pathTexto = areaPathTxtA.getText();

                if (nombreTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTextoA.this, "Error: No Nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (contenidoTexto.isEmpty() && pathTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTextoA.this, "Error: Añade contenido o selecciona un archivo", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean agregado;
                if (contenidoTexto.isEmpty()) {
                    try {
                        agregado = CtrlPresentacion.agregarTextoPalabrasPath(nombreTexto, pathTexto);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    agregado = CtrlPresentacion.agregarTextoPalabras(nombreTexto, contenidoTexto);
                }

                if (agregado) {
                    JOptionPane.showMessageDialog(VistaTextoA.this, "Texto de palabras agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    areanomTxtA.setText("");
                    areaContenidoTxtA.setText("");
                    areaPathTxtA.setText("");
                    CtrlPresentacion.guardarConjuntos();
                } else {
                    JOptionPane.showMessageDialog(VistaTextoA.this, "Error: El texto no se pudo agregar o ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        ActionListener lAgregarFrec = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTexto = areanomTxtA1.getText().trim();
                String contenidoTexto = areaContenidoTxtA1.getText();
                String pathTexto = areaPathTxtA1.getText();

                if (nombreTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTextoA.this, "Error: No Nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (contenidoTexto.isEmpty() && pathTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTextoA.this, "Error: Añade contenido o selecciona un archivo", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                HashMap<String, Integer> frecuencias = new HashMap<>();
                boolean formatoCorrecto;

                formatoCorrecto = CtrlPresentacion.formatoCorrectoAgregarFrecuencias(contenidoTexto, pathTexto, frecuencias);

                if (formatoCorrecto) {
                    boolean agregado = CtrlPresentacion.agregarTextoFrecuencias(nombreTexto, frecuencias);
                    if (agregado) {
                        JOptionPane.showMessageDialog(VistaTextoA.this, "Texto de frecuencias agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomTxtA1.setText("");
                        areaContenidoTxtA1.setText("");
                        areaPathTxtA1.setText("");
                        CtrlPresentacion.guardarConjuntos();
                    } else {
                        JOptionPane.showMessageDialog(VistaTextoA.this, "Error: El texto no se pudo agregar o ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(VistaTextoA.this, "Error: Formato de contenido incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };



        ActionListener lSeleccionarArchivoPalabras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar el diálogo de selección de archivos
                int seleccion = fileChooser.showOpenDialog(VistaTextoA.this);
                // Manejar la selección de archivos
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();
                    areaPathTxtA.setText(archivoSeleccionado.getPath());
                }
            }
        };

        ActionListener lSeleccionarArchivoFrecuencias = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar el diálogo de selección de archivos
                int seleccion = fileChooser.showOpenDialog(VistaTextoA.this);
                // Manejar la selección de archivos
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();
                    areaPathTxtA1.setText(archivoSeleccionado.getPath());
                }
            }
        };

        ActionListener lSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        bAgregarTexto.addActionListener(lAgregar);
        bAgregarTextoFrec.addActionListener(lAgregarFrec);
        bSeleccionarArchivoFrecuencias.addActionListener(lSeleccionarArchivoFrecuencias);
        bSeleccionarArchivoPalabras.addActionListener(lSeleccionarArchivoPalabras);
        bsalir.addActionListener(lSalir);

    }

}
