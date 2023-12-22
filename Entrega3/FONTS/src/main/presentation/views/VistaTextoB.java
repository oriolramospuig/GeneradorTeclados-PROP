package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Vista para eliminar textos existentes.
 * <p>
 * Esta vista permite al usuario seleccionar y texto un alfabeto existente en el sistema.
 * Proporciona una lista desplegable con los nombres de todos los textos disponibles y muestra el nombre seleccionado en un campo de texto.
 * Incluye validaciones para asegurar que se haya seleccionado un texto antes de intentar eliminarlo.
 * La vista también alerta al usuario sobre las consecuencias de eliminar un texto, como la devinculación de asociaciones y modificaciones de teclados asociados a estas últimas.
 * Incluye botones para realizar la eliminación y para regresar al menú principal.
 * @author Alèxia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class VistaTextoB extends JFrame{
    /** Pantalla de error para mostrar mensajes cuando falta información. */
    private JFrame frame = new JFrame();

    /** Panel donde se incluyen los elementos de la ventana. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana. */
    private final JLabel tituloVistaTxtB = new JLabel("Borrar texto");

    /** Botón para borrar un texto. */
    private final JButton bBorrarTexto = new JButton("Borrar Texto");

    /** Botón para volver a la pantalla del menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Texto indicando que el desplegable de al lado es para seleccionar el nombre del texto. */
    private final JLabel txtDesplegableTxtB = new JLabel("LISTA NOMBRES:");

    /** Lista desplegable con los nombres de los textos existentes. */
    private JComboBox<String> nombresTxtB = new JComboBox<>();

    /** Texto indicando que la barra de texto de al lado es donde aparecerá el nombre del texto seleccionado. */
    private final JLabel txtNombreTxtB = new JLabel("NOMBRE:");

    /** Área de texto donde aparecerá el nombre del texto que se quiere borrar */
    private final JTextArea areanomTxtB = new JTextArea();

    /**
     * Constructor de la clase VistaTextoB.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para la eliminación de textos. Proporciona funcionalidad para seleccionar un texto de la lista
     * y eliminarlo tras confirmar la acción.
     */
    public VistaTextoB() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades texto);
        ArrayList<String> nombres = CtrlPresentacion.getNombresTextos();
        nombresTxtB = new JComboBox<>();
        nombresTxtB.addItem("");
        for (String nombre : nombres) {
            nombresTxtB.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaTxtB.setBounds(10, 5, 120, 30);
        add(tituloVistaTxtB);

        txtDesplegableTxtB.setBounds(250, 140, 200, 20);
        add(txtDesplegableTxtB);

        nombresTxtB.setBounds(450, 140, 200, 20);
        add(nombresTxtB);

        // Texto Nombre
        txtNombreTxtB.setBounds(250, 220 , 200, 20);
        add(txtNombreTxtB);

        // Área texto Nombre
        areanomTxtB.setBounds(450,220, 200,20);
        add(areanomTxtB);

        bBorrarTexto.setBounds(700, 400, 200, 20);
        add(bBorrarTexto);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresTxtB.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomTxtB.setText(selectedName);
                } else {
                    areanomTxtB.setText("");  // Limpiar el área de texto si se selecciona el elemento vacío
                }
            }
        };

        ActionListener lBorrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTexto = areanomTxtB.getText().trim();
                // Verificar si el área de texto está vacía
                if (nombreTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecciona un texto para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int opcion = JOptionPane.showConfirmDialog(null, "Si elimina este texto, se modificarán todos los teclados creados a partir de una asociación vinculada a este texto.\n¿Está seguro de que desea continuar?", "Aviso", JOptionPane.YES_NO_OPTION);

                    // Verificar la respuesta del usuario
                    if (opcion == JOptionPane.YES_OPTION) { // El usuario eligió continuar
                        // Llamar al controlador para eliminar el texto
                        CtrlPresentacion.borrarTexto(nombreTexto);
                        // Actualizar el JComboBox eliminando el texto borrado
                        nombresTxtB.removeItem(nombreTexto);
                        nombresTxtB.setSelectedItem("");
                        JOptionPane.showMessageDialog(frame, "Texto eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        CtrlPresentacion.guardarConjuntos();
                    } else {
                        // El usuario eligió no continuar
                        areanomTxtB.setText("");
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

        nombresTxtB.addActionListener(lElementoSeleccionado);
        bBorrarTexto.addActionListener(lBorrar);
        bsalir.addActionListener(lSalir);

    }
}