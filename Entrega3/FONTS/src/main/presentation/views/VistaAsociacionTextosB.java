package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Vista para eliminar asociaciones existentes.
 * <p>
 * Esta vista permite al usuario seleccionar y eliminar una asociación existente en el sistema.
 * Proporciona una lista desplegable con los nombres de todas las asociaciones disponibles y muestra el nombre seleccionado en un campo de texto.
 * Incluye validaciones para asegurar que se haya seleccionado una asociación antes de intentar eliminarla.
 * La vista también alerta al usuario sobre las consecuencias de eliminar una asociación, como la eliminación de teclados asociados.
 * Incluye botones para realizar la eliminación y para regresar al menú principal.
 * @author Alèxia Mayor (alexia.mayor@estudiantat.upc.edu)
 */

public class VistaAsociacionTextosB extends JFrame{
    /** Pantalla de error para mostrar mensajes cuando falta información. */
    private JFrame frame = new JFrame();

    /** Panel donde se incluyen los elementos de la ventana. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana. */
    private final JLabel tituloVistaATB = new JLabel("Borrar asociacion");

    /** Botón para borrar una asociación. */
    private final JButton bBorrarAsociacion = new JButton("Borrar Asociacion");

    /** Botón para volver a la pantalla del menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Texto indicando que el desplegable de al lado es para seleccionar el nombre de una asociación existente que se quiera borrar. */
    private final JLabel txtDesplegableATB = new JLabel("LISTA NOMBRES:");

    /** Desplegable con los nombres de las asociaciones existentes. */
    private JComboBox<String> nombresATB = new JComboBox<>();

    /** Texto indicando que la barra de texto de al lado es donde se introducirá automáticamente el nombre de la asociación seleccionada en el desplegable. */
    private final JLabel txtNombreATB = new JLabel("NOMBRE:");

    /** Área de texto donde aparecerá el nombre de la asociación seleccionda en el desplegable. */
    private final JTextArea areanomATB = new JTextArea();

    /**
     * Constructor de la clase VistaAsociacionB.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para la eliminación de una asociación. Proporciona funcionalidad para seleccionar una asociación de la lista
     * y eliminarla tras confirmar la acción.
     */
    public VistaAsociacionTextosB() {
        setBounds(250, 150, 1000, 600);

        ArrayList<String> nombres = CtrlPresentacion.getNombresAsociaciones();
        nombresATB = new JComboBox<>();
        nombresATB.addItem("");
        for (String nombre : nombres) {
            nombresATB.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaATB.setBounds(10, 5, 120, 30);
        add(tituloVistaATB);

        txtDesplegableATB.setBounds(250, 140, 200, 20);
        add(txtDesplegableATB);

        nombresATB.setBounds(450, 140, 200, 20);
        add(nombresATB);

        // Texto Nombre
        txtNombreATB.setBounds(250, 220 , 200, 20);
        add(txtNombreATB);

        // Área texto Nombre
        areanomATB.setBounds(450,220, 200,20);
        add(areanomATB);

        bBorrarAsociacion.setBounds(700, 400, 200, 20);
        add(bBorrarAsociacion);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresATB.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomATB.setText(selectedName);
                } else {
                    areanomATB.setText("");  // Limpiar el área de texto si se selecciona el elemento vacío
                }
            }
        };

        ActionListener lBorrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAsociacion = areanomATB.getText().trim();
                // Verificar si el área de texto está vacía
                if (nombreAsociacion.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecciona una asociación para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int opcion = JOptionPane.showConfirmDialog(null, "Si elimina esta asociación, se eliminarán todos los teclados creados a partir de esta asociación.\n¿Está seguro de que desea continuar?", "Aviso", JOptionPane.YES_NO_OPTION);

                    // Verificar la respuesta del usuario
                    if (opcion == JOptionPane.YES_OPTION) { // El usuario eligió continuar
                        // Llamar al controlador para eliminar la asociación
                        CtrlPresentacion.borrarAsociacionTextos(nombreAsociacion);
                        // Actualizar el JComboBox eliminando la asociación borrada
                        nombresATB.removeItem(nombreAsociacion);
                        nombresATB.setSelectedItem("");
                        JOptionPane.showMessageDialog(frame, "Asociación eliminada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        CtrlPresentacion.guardaAsociaciones();
                    } else {
                        // El usuario eligió no continuar
                        areanomATB.setText("");
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

        nombresATB.addActionListener(lElementoSeleccionado);
        bBorrarAsociacion.addActionListener(lBorrar);
        bsalir.addActionListener(lSalir);
    }
}
