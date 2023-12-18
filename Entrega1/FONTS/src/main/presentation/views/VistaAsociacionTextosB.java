package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class VistaAsociacionTextosB extends JFrame{
    private JFrame frame = new JFrame();
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana */
    private final JLabel tituloVistaATB = new JLabel("Borrar asociacion");
    /** Botón para agregar una asociación */
    private final JButton bBorrarAsociacion = new JButton("Borrar Asociacion");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación */
    private final JLabel txtDesplegableATB = new JLabel("LISTA NOMBRES:");
    private JComboBox<String> nombresATB = new JComboBox<>();
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación */
    private final JLabel txtNombreATB = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociación que se quiere crear */
    private final JTextArea areanomATB = new JTextArea();

    /** Constructora de la ventana de eliminar asociación */
    public VistaAsociacionTextosB() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades texto);
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
