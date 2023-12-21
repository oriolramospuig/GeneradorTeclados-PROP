package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Vista para eliminar alfabetos existentes.
 * <p>
 * Esta vista permite al usuario seleccionar y eliminar un alfabeto existente en el sistema.
 * Proporciona una lista desplegable con los nombres de todos los alfabetos disponibles y muestra el nombre seleccionado en un campo de texto.
 * Incluye validaciones para asegurar que se haya seleccionado un alfabeto antes de intentar eliminarlo.
 * La vista también alerta al usuario sobre las consecuencias de eliminar un alfabeto, como la eliminación de teclados asociados.
 * Incluye botones para realizar la eliminación y para regresar al menú principal.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class VistaAlfabetoB extends JFrame {
    /** Pantalla de error para mostrar mensajes cuando falta información. */
    private JFrame frame = new JFrame();

    /** Panel principal que contiene todos los componentes de la interfaz. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana. */
    private final JLabel tituloVistaAB = new JLabel("Borrar alfabeto");

    /** Botón para eliminar el alfabeto seleccionado. */
    private final JButton bBorrarAlfabeto = new JButton("Borrar Alfabeto");

    /** Botón para regresar al menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Etiqueta para la lista desplegable de nombres de alfabetos. */
    private final JLabel txtDesplegableAB = new JLabel("LISTA NOMBRES:");

    /** Lista desplegable con los nombres de los alfabetos existentes. */
    private JComboBox<String> nombresAB = new JComboBox<>();

    /** Etiqueta para el campo de nombre del alfabeto. */
    private final JLabel txtNombreAB = new JLabel("NOMBRE:");

    /** Campo de texto que muestra el nombre del alfabeto seleccionado. */
    private final JTextArea areanomAB = new JTextArea();

    /**
     * Constructor de la clase VistaAlfabetoB.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para la eliminación de alfabetos. Proporciona funcionalidad para seleccionar un alfabeto de la lista
     * y eliminarlo tras confirmar la acción.
    */
    public VistaAlfabetoB() {
        setBounds(250, 150, 1000, 600);

        ArrayList<String> nombres = CtrlPresentacion.getNombresAlfabetos();
        nombresAB = new JComboBox<>();
        nombresAB.addItem("");
        for (String nombre : nombres) {
            nombresAB.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaAB.setBounds(10, 5, 120, 30);
        add(tituloVistaAB);

        txtDesplegableAB.setBounds(250, 140, 200, 20);
        add(txtDesplegableAB);

        nombresAB.setBounds(450, 140, 200, 20);
        add(nombresAB);

        // Texto Nombre
        txtNombreAB.setBounds(250, 220 , 200, 20);
        add(txtNombreAB);

        // Área texto Nombre
        areanomAB.setBounds(450,220, 200,20);
        add(areanomAB);

        // Botón para borrar un alfabeto
        bBorrarAlfabeto.setBounds(700, 400, 200, 20);
        add(bBorrarAlfabeto);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresAB.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomAB.setText(selectedName);
                } else {
                    areanomAB.setText("");
                }
            }
        };
        
        ActionListener lBorrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAlfabeto = areanomAB.getText().trim();
                // Verificar si el área de texto está vacía
                if (nombreAlfabeto.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecciona un alfabeto para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int opcion = JOptionPane.showConfirmDialog(null, "Si elimina este alfabeto, se eliminarán todos los teclados creados a partir de este alfabeto.\n¿Está seguro de que desea continuar?", "Aviso", JOptionPane.YES_NO_OPTION);

                    // Verificar la respuesta del usuario
                    if (opcion == JOptionPane.YES_OPTION) { // El usuario eligió continuar
                        // Llamar al controlador para eliminar el alfabeto
                        CtrlPresentacion.borrarAlfabeto(nombreAlfabeto);
                        // Actualizar el JComboBox eliminando el alfabeto borrado
                        nombresAB.removeItem(nombreAlfabeto);
                        nombresAB.setSelectedItem("");
                        JOptionPane.showMessageDialog(frame, "Alfabeto eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        CtrlPresentacion.guardaAlfabetos();
                    } else {
                        // El usuario eligió no continuar
                        areanomAB.setText("");
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

        nombresAB.addActionListener(lElementoSeleccionado);
        bBorrarAlfabeto.addActionListener(lBorrar);
        bsalir.addActionListener(lSalir);
    }
}
