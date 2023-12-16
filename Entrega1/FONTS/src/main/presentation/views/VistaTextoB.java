package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class VistaTextoB extends JFrame{
    private JFrame frame = new JFrame();
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana */
    private final JLabel tituloVistaTxtB = new JLabel("Borrar texto");
    /** Botón para agregar un texto */
    private final JButton bBorrarTexto = new JButton("Borrar Texto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtDesplegableTxtB = new JLabel("LISTA NOMBRES:");
    private JComboBox<String> nombresTxtB = new JComboBox<>();
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtNombreTxtB = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere crear */
    private final JTextArea areanomTxtB = new JTextArea();

    /** Constructora de la ventana de eliminar texto */
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
                    // Llamar al controlador para eliminar el texto
                    CtrlPresentacion.borrarTexto(nombreTexto);
                    // Actualizar el JComboBox eliminando el texto borrado
                    nombresTxtB.removeItem(nombreTexto);
                    nombresTxtB.setSelectedItem("");
                    JOptionPane.showMessageDialog(frame, "Texto eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    CtrlPresentacion.guardaTextos();
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