package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaTecladoA extends JFrame {

    /** Finestra de selecció de l'arxiu que es vol carregar al nostre full de càlcul */
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaTA = new JLabel("Agregar teclado");
    /** Botón para agregar un teclado */
    private final JButton bAgregarTeclado = new JButton("Agregar teclado");
    /** Botón para agregar un teclado */
    private final JButton bSeleccionarAlfabeto = new JButton("Selecciona alfabeto");
    /** Botón para agregar un teclado */
    private final JButton bSeleccionaAsociacion = new JButton("Selecciona asociación");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del teclado */
    private final JLabel txtNombreTA = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del teclado que se quiere crear */
    private final JTextArea areanomTA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del teclado */
    private final JLabel txtNombreAlfabetoTA = new JLabel("ALFABETO:");
    /** Área de texto para introducir el contenido del teclado que se quiere crear */
    private final JTextArea areaContenidoAlfabetoTA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del teclado */
    private final JLabel txtNombreAsociacionTA = new JLabel("ASOCIACIÓN:");
    /** Área de texto para introducir el contenido del teclado que se quiere crear */
    private final JTextArea areaContenidoAsociacionTA = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear un teclado sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear un teclado sin contenido o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");


    public VistaTecladoA(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades teclado);

        // Título ventana superior
        tituloVistaTA.setBounds(10, 5, 120, 30);
        add(tituloVistaTA);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTA.setBounds(50, 35, 200, 20);
        add(txtNombreTA);

        // Área texto Nombre
        areanomTA.setBounds(250,35, 200,20);
        add(areanomTA);

        // Texto Contenido
        txtNombreAlfabetoTA.setBounds(50, 75, 200, 20);
        add(txtNombreAlfabetoTA);

        // Área texto Contenido
        areaContenidoAlfabetoTA.setBounds(250,75, 200,60);
        add(areaContenidoAlfabetoTA);

        txtNombreAsociacionTA.setBounds(50, 175, 200, 20);
        add(txtNombreAsociacionTA);

        areaContenidoAsociacionTA.setBounds(250,175, 200,60);
        add(areaContenidoAsociacionTA);

        bSeleccionarAlfabeto.setBounds(550, 75, 200, 20);
        add(bSeleccionarAlfabeto);

        bSeleccionaAsociacion.setBounds(550, 175, 200, 20);
        add(bSeleccionaAsociacion);

        // Botón agregar teclado
        bAgregarTeclado.setBounds(700, 250, 200, 20);
        add(bAgregarTeclado);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTeclado = areanomTA.getText().trim();
                String nombreAlfabeto = areaContenidoAlfabetoTA.getText();
                String nombreAsociacion = areaContenidoAsociacionTA.getText();
                String path = System.getProperty("user.dir") + "/subgrup-prop14.3/Entrega1/data/Teclados";

                // Verificar que el nombre no esté vacío
                if (nombreTeclado.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: No Nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar que haya contenido proporcionado
                if (nombreAlfabeto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: Debe seleccionar un alfabeto con el que crear el teclado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (nombreAsociacion.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: Debe seleccionar una asociación con la que crear el teclado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //boolean agregado = CtrlPresentacion.crearTeclado(nombreTeclado, nombreAlfabeto, nombreAsociacion, path);
                boolean agregado = false;
                // Mensaje de éxito o error
                if (agregado) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    areanomTA.setText("");
                    areaContenidoAlfabetoTA.setText("");
                    areaContenidoAsociacionTA.setText("");
                } else {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: El nombre " + nombreTeclado + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        ActionListener lSeleccionarAlfabeto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooser.setDialogTitle("Selecciona alfabeto");
                chooser.setFileFilter(new FileNameExtensionFilter("PROP", "csv", "prop", "txt"));
                chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/subgrup-prop14.3/Entrega1/data/Alfabetos"));
                int returnValue = chooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File archivo = chooser.getSelectedFile();
                    areaContenidoAlfabetoTA.setText(archivo.getName().substring(0, archivo.getName().length() - 4));
                } else if (returnValue == JFileChooser.CANCEL_OPTION) {
                    CtrlPresentacion.vistaTecladoA();
                }
            }
        };

        ActionListener lSeleccionarAsociacion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooser.setDialogTitle("Selecciona asociación de textos");
                chooser.setFileFilter(new FileNameExtensionFilter("PROP", "csv", "prop", "txt"));
                chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/subgrup-prop14.3/Entrega1/data/Asociaciones"));
                int returnValue = chooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File archivo = chooser.getSelectedFile();
                    areaContenidoAsociacionTA.setText(archivo.getName());
                } else if (returnValue == JFileChooser.CANCEL_OPTION) {
                    CtrlPresentacion.vistaTecladoA();
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

        bSeleccionarAlfabeto.addActionListener(lSeleccionarAlfabeto);
        bSeleccionaAsociacion.addActionListener(lSeleccionarAsociacion);
        bAgregarTeclado.addActionListener(lAgregar);
        bsalir.addActionListener(lSalir);

    }

}
