package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Esta vista es la encargada de consultar un alfabeto. Se indican claramente 3 campos de texto, pero solo hay que rellenar 1 de estos 3.
 * El primer campo es una lista de desplegable de los nombres de los alfabetos existentes en el sistema.
 * De manera que el usuario debe seleccionar uno de estos para consultar.
 * El segundo campo se llenará automáticamente con el nombre que el usuario haya seleccionado de la lista del campo anterior.
 * El tercer campo se llenará automáticamente con el contenido del alfabeto que el usuario haya seleccionado en el primer campo.
 * Solo se puede consultar un alfabeto si se selecciona algún nombre de la lista.
 * De no ser así, se muestra un mensaje de error avisando al usuario qué le falta para poder consultar de forma correcta el alfabeto deseado.
 * Debajo de las áreas de texto se proporciona un botón para consultar el alfabeto con la información introducida.
 * Más también hay un botón con la opción de volver al menú principal.
 * @author
 */

public class VistaAlfabetoC extends JFrame{
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título ventana */
    private final JLabel tituloVistaAC = new JLabel("Consultar alfabeto");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto */
    private final JLabel txtDesplegableAC = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de los alfabetos*/
    private JComboBox<String> nombresAC = new JComboBox<>();
    /** Botón para volver a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtNombreAC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areanomAC = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtContenido = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areacontenidoAC = new JTextArea();

    public VistaAlfabetoC() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
        ArrayList<String> nombres = CtrlPresentacion.getNombresAlfabetos();
        nombresAC = new JComboBox<>();
        nombresAC.addItem("");
        for (String nombre : nombres) {
            nombresAC.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaAC.setBounds(10, 5, 120, 30);
        add(tituloVistaAC);

        txtDesplegableAC.setBounds(200, 120, 200, 20);
        add(txtDesplegableAC);

        nombresAC.setBounds(400, 120, 200, 20);
        add(nombresAC);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreAC.setBounds(200, 180, 200, 20);
        add(txtNombreAC);

        // Área texto Nombre
        areanomAC.setEditable(false);
        areanomAC.setBounds(400,180, 200,20);
        add(areanomAC);

        txtContenido.setBounds(200, 220, 200, 20);
        add(txtContenido);

        areacontenidoAC.setEditable(false); // Opcional, si no quieres que se pueda editar el contenido
        JScrollPane scrollPane = new JScrollPane(areacontenidoAC); // Para agregar scroll al área de texto
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
                String selectedName = (String) nombresAC.getSelectedItem();
                ArrayList<Character> contenido = CtrlPresentacion.consultarContenidoAlfabeto(selectedName);
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomAC.setText(selectedName);
                    // Convertir ArrayList<Character> a String
                    StringBuilder contenidoStr = new StringBuilder();
                    for (Character c : contenido) {
                        contenidoStr.append(c);
                    }
                    areacontenidoAC.setText(contenidoStr.toString());
                } else {
                    areanomAC.setText("");
                    areacontenidoAC.setText("");
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

        nombresAC.addActionListener(lElementoSeleccionado);
        bsalir.addActionListener(lSalir);
    }
}
