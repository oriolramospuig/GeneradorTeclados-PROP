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

public class VistaTecladoC extends JFrame {
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaTC = new JLabel("Consultar teclados");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion */
    private final JLabel txtDesplegableTC = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de la asociacion*/
    private JComboBox<String> nombresTC = new JComboBox<>();
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtNombreTC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areanomTC = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtContenidoTC = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areacontenidoTC = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar una asociacion sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");

    public VistaTecladoC() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
        ArrayList<String> nombres = CtrlPresentacion.getListaTeclados();
        nombresTC = new JComboBox<>();
        nombresTC.addItem("");
        for (String nombre : nombres) {
            nombresTC.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaTC.setBounds(10, 5, 120, 30);
        add(tituloVistaTC);

        txtDesplegableTC.setBounds(200, 120, 200, 20);
        add(txtDesplegableTC);

        nombresTC.setBounds(400, 120, 200, 20);
        add(nombresTC);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTC.setBounds(200, 180, 200, 20);
        add(txtNombreTC);

        // Área texto Nombre
        areanomTC.setEditable(false);
        areanomTC.setBounds(400,180, 200,20);
        add(areanomTC);

        txtContenidoTC.setBounds(200, 220, 200, 20);
        add(txtContenidoTC);

        areacontenidoTC.setEditable(false); // Opcional, si no quieres que se pueda editar el contenido
        JScrollPane scrollPane = new JScrollPane(areacontenidoTC); // Para agregar scroll al área de texto
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
                String selectedName = (String) nombresTC.getSelectedItem();
                ArrayList<String> contenido = CtrlPresentacion.consultarCjtTextosAsociacion(selectedName);
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomTC.setText(selectedName);
                    // Convertir ArrayList<Character> a String
                    StringBuilder contenidoStr = new StringBuilder();
                    for (String c : contenido) {
                        contenidoStr.append(c).append("\n");
                    }
                    areacontenidoTC.setText(contenidoStr.toString());
                } else {
                    areanomTC.setText("");
                    areacontenidoTC.setText("");
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

        nombresTC.addActionListener(lElementoSeleccionado);
        bsalir.addActionListener(lSalir);
    }
}
