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

public class VistaTextoC extends JFrame {
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaTxtC = new JLabel("Consultar texto");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtDesplegableTxtC = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de los textos*/
    private JComboBox<String> nombresTxtC = new JComboBox<>();
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto a consultar*/
    private final JLabel txtNombreATxtC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere consultar */
    private final JTextArea areanomTxtC = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto a consultar*/
    private final JLabel txtContenidoTxtC = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre del texto que se quiere consultar */
    private final JTextArea areacontenidoTxtC = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un texto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");

    public VistaTextoC() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
        ArrayList<String> nombres = CtrlPresentacion.getNombresTextos();
        nombresTxtC = new JComboBox<>();
        nombresTxtC.addItem("");
        for (String nombre : nombres) {
            nombresTxtC.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaTxtC.setBounds(10, 5, 120, 30);
        add(tituloVistaTxtC);

        txtDesplegableTxtC.setBounds(200, 120, 200, 20);
        add(txtDesplegableTxtC);

        nombresTxtC.setBounds(400, 120, 200, 20);
        add(nombresTxtC);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreATxtC.setBounds(200, 180, 200, 20);
        add(txtNombreATxtC);

        // Área texto Nombre
        areanomTxtC.setEditable(false);
        areanomTxtC.setBounds(400,180, 200,20);
        add(areanomTxtC);

        txtContenidoTxtC.setBounds(200, 220, 200, 20);
        add(txtContenidoTxtC);

        areacontenidoTxtC.setEditable(false); // Opcional, si no quieres que se pueda editar el contenido
        JScrollPane scrollPane = new JScrollPane(areacontenidoTxtC); // Para agregar scroll al área de texto
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
                String selectedName = (String) nombresTxtC.getSelectedItem();
                String contenido = CtrlPresentacion.consultarContenidoTexto(selectedName);
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomTxtC.setText(selectedName);
                    areacontenidoTxtC.setText(contenido);
                } else {
                    areanomTxtC.setText("");
                    areacontenidoTxtC.setText("");
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

        nombresTxtC.addActionListener(lElementoSeleccionado);
        bsalir.addActionListener(lSalir);
    }
}
