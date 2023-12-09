package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.*;

public class VistaAlfabetoA extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana */
    private final JLabel tituloVistaAA = new JLabel("Agregar alfabeto");
    /** Botón para agregar un alfabeto */
    private final JButton bAgregarAlfabeto = new JButton("Agregar Alfabeto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto */
    private final JLabel txtNombreAA = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere crear */
    private final JTextArea areanomAA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del alfabeto */
    private final JLabel txtContenidoAA = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del alfabeto que se quiere crear */
    private final JTextArea areaContenidoAA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del alfabeto, para saber donde esta guardado */
    private final JLabel txtPathAA = new JLabel("PATH:");
    /** Área de texto para introducir el path del alfabeto que se quiere crear */
    private final JTextArea areaPathAA = new JTextArea();


    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear un alfabeto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear un alfabeto sin contenido o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");
    /** Pantalla de error alfabeto no agregado */
    private JFrame frame = new JFrame();


    public VistaAlfabetoA(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);

        // Título ventana superior
        tituloVistaAA.setBounds(10, 5, 120, 30);
        add(tituloVistaAA);


        // Texto Nombre
        txtNombreAA.setBounds(250, 140 , 200, 20);
        add(txtNombreAA);

        // Área texto Nombre
        areanomAA.setBounds(450,140, 200,20);
        add(areanomAA);

        // Texto Contenido
        txtContenidoAA.setBounds(250, 180, 200, 20);
        add(txtContenidoAA);

        // Área texto Contenido
        areaContenidoAA.setBounds(450,180, 200,60);
        add(areaContenidoAA);

        // Texto Path
        txtPathAA.setBounds(250, 280, 200, 20);
        add(txtPathAA);

        // Área texto Path
        areaPathAA.setBounds(450,280, 200,20);
        add(areaPathAA);


        //BOTONES
        // Botón agregar Alfabeto
        bAgregarAlfabeto.setBounds(700, 340, 200, 20);
        add(bAgregarAlfabeto);

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
                String path = System.getProperty("user.dir") + "/subgrup-prop14.3/Entrega1/data/Alfabetos";

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
                    boolean agregado = CtrlPresentacion.agregarAlfabetoPath(nombreAlfabeto, path);
                    // Mensaje de éxito o error
                    if (agregado) {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomAA.setText("");
                        areaContenidoAA.setText("");
                    } else {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: El nombre " + nombreAlfabeto + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    boolean agregado = CtrlPresentacion.agregarAlfabetoManual(nombreAlfabeto, contenidoAlfabeto, path);
                    // Mensaje de éxito o error
                    if (agregado) {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomAA.setText("");
                        areaContenidoAA.setText("");
                    } else {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: El nombre " + nombreAlfabeto + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
        bsalir.addActionListener(lSalir);
    }
}
