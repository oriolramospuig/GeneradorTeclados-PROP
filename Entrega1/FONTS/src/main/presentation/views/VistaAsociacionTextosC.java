package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VistaAsociacionTextosC extends JFrame {
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaATC = new JLabel("Consultar asociacion");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion */
    private final JLabel txtDesplegableATC = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de las asociaciones*/
    private JComboBox<String> nombresATC = new JComboBox<>();
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtNombreATC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areanomATC = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtContenidoATC = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areacontenidoATC = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar una asociacion sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");

    public VistaAsociacionTextosC() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
        ArrayList<String> nombres = CtrlPresentacion.getNombresAsociaciones();
        nombresATC = new JComboBox<>();
        nombresATC.addItem("");
        for (String nombre : nombres) {
            nombresATC.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaATC.setBounds(10, 5, 200, 30);
        add(tituloVistaATC);

        txtDesplegableATC.setBounds(200, 120, 200, 20);
        add(txtDesplegableATC);

        nombresATC.setBounds(400, 120, 200, 20);
        add(nombresATC);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreATC.setBounds(200, 180, 200, 20);
        add(txtNombreATC);

        // Área texto Nombre
        areanomATC.setEditable(false);
        areanomATC.setBounds(400,180, 200,20);
        add(areanomATC);

        txtContenidoATC.setBounds(200, 220, 200, 20);
        add(txtContenidoATC);

        areacontenidoATC.setEditable(false); // Opcional, si no quieres que se pueda editar el contenido
        JScrollPane scrollPane = new JScrollPane(areacontenidoATC); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 220, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresATC.getSelectedItem();
                ArrayList<String> contenido = CtrlPresentacion.consultarCjtTextosAsociacion(selectedName);
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomATC.setText(selectedName);
                    // Convertir ArrayList<Character> a String
                    StringBuilder contenidoStr = new StringBuilder();
                    for (String c : contenido) {
                        contenidoStr.append(c).append("\n");
                    }
                    areacontenidoATC.setText(contenidoStr.toString());
                } else {
                    areanomATC.setText("");
                    areacontenidoATC.setText("");
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

        nombresATC.addActionListener(lElementoSeleccionado);
        bsalir.addActionListener(lSalir);
    }
}
