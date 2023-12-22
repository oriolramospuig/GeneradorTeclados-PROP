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
 * Vista para consultar los detalles de un alfabeto existente.
 * <p>
 * Esta vista ofrece al usuario una lista desplegable para seleccionar un alfabeto existente y consultar su contenido.
 * Al seleccionar un alfabeto de la lista, se muestra su nombre y su contenido en campos de texto.
 * La interfaz proporciona una manera sencilla y directa para que los usuarios puedan ver los caracteres que componen un alfabeto específico.
 * Incluye un botón para regresar al menú principal.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class VistaAlfabetoC extends JFrame {
    /** Panel principal que contiene todos los componentes de la interfaz. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana. */
    private final JLabel tituloVistaAC = new JLabel("Consultar alfabeto");

    /** Etiqueta para la lista desplegable de nombres de alfabetos. */
    private final JLabel txtDesplegableAC = new JLabel("LISTA NOMBRES:");

    /** Lista desplegable con los nombres de los alfabetos existentes. */
    private JComboBox<String> nombresAC = new JComboBox<>();

    /** Botón para regresar al menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Etiqueta para el campo de nombre del alfabeto. */
    private final JLabel txtNombreAC = new JLabel("NOMBRE:");

    /** Campo de texto que muestra el nombre del alfabeto seleccionado. */
    private final JTextArea areanomAC = new JTextArea();

    /** Etiqueta para el campo de contenido del alfabeto. */
    private final JLabel txtContenido = new JLabel("CONTENIDO:");

    /** Campo de texto que muestra el contenido del alfabeto seleccionado. */
    private final JTextArea areacontenidoAC = new JTextArea();

    /**
     * Constructor de la clase VistaAlfabetoC.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para la consulta de alfabetos. Facilita la visualización del contenido de un alfabeto seleccionado
     * desde una lista desplegable.
     */
    public VistaAlfabetoC() {
        setBounds(250, 150, 1000, 600);

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
                if (selectedName != null && !selectedName.isEmpty()) {
                    ArrayList<Character> contenido = CtrlPresentacion.consultarContenidoAlfabeto(selectedName);
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
