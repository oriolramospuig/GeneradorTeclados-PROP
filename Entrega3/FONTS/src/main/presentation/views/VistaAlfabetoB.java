package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Esta vista es la encargada de eliminar un alfabeto. Se indican claramente 2 campos de texto, pero solo hay que rellenar 1 de estos 2.
 * El primer campo es una lista de desplegable de los nombres de los alfabetos existentes en el sistema.
 * De manera que el usuario debe seleccionar uno de estos para eliminar.
 * El segundo campo se llenará automáticamente con el nombre que el usuario haya seleccionado de la lista del campo anterior.
 * Solo se puede eliminar un alfabeto si se selecciona algún nombre de la lista.
 * De no ser así, se muestra un mensaje de error avisando al usuario qué le falta para poder borrar de forma correcta el alfabeto deseado.
 * Debajo de las áreas de texto se proporciona un botón para borrar el alfabeto con la información introducida.
 * Más también hay un botón con la opción de volver al menú principal.
 * @author
 */

public class VistaAlfabetoB extends JFrame{
    /** Pantalla de error que aparece cuando falta información por introducir */
    private JFrame frame = new JFrame();
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana */
    private final JLabel tituloVistaAB = new JLabel("Borrar alfabeto");
    /** Botón para agregar un alfabeto */
    private final JButton bBorrarAlfabeto = new JButton("Borrar Alfabeto");
    /** Botón para volver a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto */
    private final JLabel txtDesplegableAB = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de los alfabetos*/
    private JComboBox<String> nombresAB = new JComboBox<>();
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto */
    private final JLabel txtNombreAB = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere crear */
    private final JTextArea areanomAB = new JTextArea();

    /** Constructora de la ventana de eliminar alfabeto */
    public VistaAlfabetoB() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
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
                        CtrlPresentacion.guardarConjuntos();
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
