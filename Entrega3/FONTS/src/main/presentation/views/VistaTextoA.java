package main.presentation.views;

import main.domain.controllers.CtrlDominio;
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

public class VistaTextoA extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaTxtA = new JLabel("Agregar texto de palabras");
    /** Título de media ventana superior */
    private final JLabel tituloVistaTxtA1 = new JLabel("Agregar texto de frecuencias");
    /** Botón para agregar un texto */
    private final JButton bAgregarTexto = new JButton("Agregar texto de palabras");
    /** Botón para agregar un texto */
    private final JButton bAgregarTextoFrec = new JButton("Agregar texto de frecuencias");
    private final JButton bSeleccionarArchivoPalabras = new JButton("Seleccionar Archivo");
    private final JButton bSeleccionarArchivoFrecuencias = new JButton("Seleccionar Archivo");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtNombreTxtA = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere crear */
    private final JTextArea areanomTxtA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del texto */
    private final JLabel txtContenidoTxtA = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del texto que se quiere crear */
    private final JTextArea areaContenidoTxtA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del texto, para saber donde esta guardado */
    private final JLabel txtPathTxtA = new JLabel("PATH:");
    /** Área de texto para introducir el path del texto que se quiere crear */
    private final JTextArea areaPathTxtA = new JTextArea();
    /** Texto explicando las instrucciones de como entrar el texto en caso de palabras */
    private final JLabel txtInstruccionesTxtA = new JLabel("(Hay que añadir un texto del formato palabras en frases. Ej: Hola que tal)");


    //VENTANA SUPERIOR2
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtNombreTxtA1 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere crear */
    private final JTextArea areanomTxtA1 = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del texto */
    private final JLabel txtContenidoTxtA1 = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del texto que se quiere crear */
    private final JTextArea areaContenidoTxtA1 = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del texto, para saber donde esta guardado */
    private final JLabel txtPathTxtA1 = new JLabel("PATH:");
    /** Área de texto para introducir el path del texto que se quiere crear */
    private final JTextArea areaPathTxtA1 = new JTextArea();
    /** Texto explicando las instrucciones de como entrar el texto en caso de palabras */
    private final JLabel txtInstruccionesTxtA1 = new JLabel("(Hay que añadir un texto del formato palabras con sus rescpectivas");
    /** Texto explicando las instrucciones de como entrar el texto en caso de palabras */
    private final JLabel txtInstruccionesTxtA2 = new JLabel("frecuencias separadas por un espacio. Ej: hola 5)");

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear un texto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear un texto sin contenido o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");

    /** Pantalla de error texto no agregado */
    private JFrame frame = new JFrame();


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

        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "\\Entrega3\\data\\InputFiles\\Textos\\");
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
                        //agregado = CtrlPresentacion.agregarTextoPalabrasPath(nombreTexto, pathTexto);
                        agregado = CtrlDominio.agregarTextoPalabrasPath(nombreTexto, pathTexto);
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
                    CtrlPresentacion.guardaTextos();
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
                boolean formatoCorrecto = true;

                if (!contenidoTexto.isEmpty()) {
                    String[] lineas = contenidoTexto.split("\n");
                    for (String linea : lineas) {
                        linea = linea.trim();
                        if (!linea.matches("\\S+\\s+\\d+")) {
                            formatoCorrecto = false;
                            break;
                        }
                        String[] partes = linea.split("\\s+");
                        frecuencias.put(partes[0], Integer.parseInt(partes[1]));
                    }
                } else {
                    try {
                        File archivo = new File(pathTexto);
                        Scanner scanner = new Scanner(archivo);
                        while (scanner.hasNextLine()) {
                            String linea = scanner.nextLine().trim();
                            if (!linea.matches("\\S+\\s+\\d+")) {
                                formatoCorrecto = false;
                                break;
                            }
                            String[] partes = linea.split("\\s+");
                            frecuencias.put(partes[0], Integer.parseInt(partes[1]));
                        }
                        scanner.close();
                    } catch (FileNotFoundException ex) {
                        formatoCorrecto = false;
                    }
                }

                if (formatoCorrecto) {
                    boolean agregado = CtrlPresentacion.agregarTextoFrecuencias(nombreTexto, frecuencias);
                    if (agregado) {
                        JOptionPane.showMessageDialog(VistaTextoA.this, "Texto de frecuencias agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomTxtA1.setText("");
                        areaContenidoTxtA1.setText("");
                        areaPathTxtA1.setText("");
                        CtrlPresentacion.guardaTextos();
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
