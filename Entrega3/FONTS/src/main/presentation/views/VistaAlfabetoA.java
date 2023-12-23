package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Vista para agregar un nuevo alfabeto.
 * <p>
 * Esta vista permite al usuario agregar un nuevo alfabeto al sistema, especificando su nombre y su contenido.
 * El usuario puede introducir el contenido del alfabeto manualmente o cargarlo desde un archivo.
 * La vista incluye validaciones para asegurar que el nombre del alfabeto sea único y que se haya proporcionado el contenido adecuadamente.
 * Incluye botones para agregar el alfabeto, seleccionar un archivo y volver al menú principal.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class VistaAlfabetoA extends JFrame {

    /** Panel principal que contiene todos los componentes de la interfaz. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana. */
    private final JLabel tituloVistaAA = new JLabel("Agregar alfabeto");

    /** Botón para agregar un nuevo alfabeto. */
    private final JButton bAgregarAlfabeto = new JButton("Agregar Alfabeto");

    /** Botón para seleccionar un archivo que contiene el contenido del alfabeto. */
    private final JButton bSeleccionarArchivo = new JButton("Seleccionar Archivo");

    /** Botón para regresar al menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Etiqueta para el campo de nombre del alfabeto. */
    private final JLabel txtNombreAA = new JLabel("NOMBRE:");

    /** Campo de texto para introducir el nombre del nuevo alfabeto. */
    private final JTextArea areanomAA = new JTextArea();

    /** Etiqueta para el campo del contenido del alfabeto. */
    private final JLabel txtContenidoAA = new JLabel("CONTENIDO:");

    /** Campo de texto para introducir el contenido del alfabeto. */
    private final JTextArea areaContenidoAA = new JTextArea();

    /** Etiqueta para el campo del path del archivo del alfabeto. */
    private final JLabel txtPathAA = new JLabel("PATH:");

    /** Campo de texto para mostrar el path del archivo seleccionado. */
    private final JTextArea areaPathAA = new JTextArea();

    /** Etiqueta con instrucciones para introducir el contenido del alfabeto. */
    private final JLabel txtInstruccionesA = new JLabel("(Hay que añadir el contenido con todos los caracteres juntos y sin repetir...");
    private final JLabel txtInstruccionesA1 = new JLabel("Si desea el espacio como carácter, hay que añadirlo también en el contenido. Ej: Abdf i%67)");

    /**
     * Constructor de la clase VistaAlfabetoA.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para la adición de un nuevo alfabeto, ya sea manualmente o mediante un archivo.
     */
    public VistaAlfabetoA(){

        // System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
        setBounds(250, 150, 1000, 600);

        // Título ventana superior
        tituloVistaAA.setBounds(10, 5, 120, 30);
        add(tituloVistaAA);

        // Texto Nombre
        txtNombreAA.setBounds(250, 140 , 200, 20);
        add(txtNombreAA);

        areanomAA.setBounds(450,140, 200,20);
        add(areanomAA);

        // Texto Contenido
        txtContenidoAA.setBounds(250, 180, 200, 20);
        add(txtContenidoAA);

        // Area texto Contenido
        JScrollPane scrollPaneC = new JScrollPane(areaContenidoAA);
        scrollPaneC.setBounds(450, 180, 200, 60);
        add(scrollPaneC);

        // Texto Path
        txtPathAA.setBounds(250, 280, 200, 20);
        add(txtPathAA);

        // Area texto Path
        areaPathAA.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaPathAA);
        scrollPane.setBounds(450, 280, 200, 60);
        add(scrollPane);

        // Texto Instrucciones
        txtInstruccionesA.setBounds(30, 340, 600, 20);
        add(txtInstruccionesA);
        txtInstruccionesA1.setBounds(30, 360, 600, 20);
        add(txtInstruccionesA1);


        //BOTONES
        // Botón agregar Alfabeto
        bAgregarAlfabeto.setBounds(700, 400, 200, 20);
        add(bAgregarAlfabeto);

        bSeleccionarArchivo.setBounds(660, 280, 150, 20);
        add(bSeleccionarArchivo);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAlfabeto = areanomAA.getText().trim();
                String contenidoAlfabeto = areaContenidoAA.getText();
                String pathArchivo = areaPathAA.getText();

                // Verificar que el nombre no esté vacío
                if (nombreAlfabeto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: No Nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar que haya contenido proporcionado
                if (contenidoAlfabeto.isEmpty() && pathArchivo.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: Añade contenido o seleccione archivo que contenga un alfabeto", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if (contenidoAlfabeto.isEmpty()) {
                    boolean agregado = false;
                    try {
                        agregado = CtrlPresentacion.agregarAlfabetoPath(nombreAlfabeto, pathArchivo);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    // Mensaje de éxito o error
                    if (agregado) {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomAA.setText("");
                        areaContenidoAA.setText("");
                        areaPathAA.setText("");
                        CtrlPresentacion.guardaAlfabetos();
                    } else {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: El nombre " + nombreAlfabeto + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (pathArchivo.isEmpty()){
                    // Convertimos la entrada de string en una lista de characters
                    ArrayList<Character> caracteres = new ArrayList<>();
                    for (char c : contenidoAlfabeto.toCharArray()) caracteres.add(c);
                    boolean agregado = CtrlPresentacion.agregarAlfabetoManual(nombreAlfabeto, caracteres);
                    // Mensaje de éxito o error
                    if (agregado) {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomAA.setText("");
                        areaContenidoAA.setText("");
                        areaPathAA.setText("");
                        CtrlPresentacion.guardaAlfabetos();
                    } else {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: El nombre " + nombreAlfabeto + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: No puede haber contenido y path a la vez, solo uno de los dos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        };

        ActionListener lSeleccionarArchivo = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un JFileChooser que se abre en la carpeta data/InputFiles/Alfabetos
                JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "//Entrega3//data//InputFiles//Alfabetos//");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo de Texto", "txt"));

                // Mostrar el diálogo de selección de archivos
                int seleccion = fileChooser.showOpenDialog(VistaAlfabetoA.this);

                // Manejar la selección de archivos
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();
                    areaPathAA.setText(archivoSeleccionado.getPath());
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

        bAgregarAlfabeto.addActionListener(lAgregar);
        bSeleccionarArchivo.addActionListener(lSeleccionarArchivo);
        bsalir.addActionListener(lSalir);
    }
}
