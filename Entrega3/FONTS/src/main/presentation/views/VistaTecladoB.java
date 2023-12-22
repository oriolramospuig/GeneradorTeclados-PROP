package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class VistaTecladoB extends JFrame{
    private JFrame frame = new JFrame();
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana */
    private final JLabel tituloVistaTB = new JLabel("Borrar teclado");
    /** Botón para agregar un teclado */
    private final JButton bBorrarTeclado = new JButton("Borrar teclado");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del teclado */
    private final JLabel txtDesplegableTB = new JLabel("LISTA NOMBRES:");
    private JComboBox<String> nombresTB = new JComboBox<>();
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del teclado */
    private final JLabel txtNombreTB = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del teclado que se quiere crear */
    private final JTextArea areanomTB = new JTextArea();

    /** Constructora de la ventana de eliminar teclado */
    public VistaTecladoB() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades texto);
        ArrayList<String> nombres = CtrlPresentacion.getListaTeclados();
        nombresTB = new JComboBox<>();
        nombresTB.addItem("");
        for (String nombre : nombres) {
            nombresTB.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaTB.setBounds(10, 5, 120, 30);
        add(tituloVistaTB);

        txtDesplegableTB.setBounds(250, 140, 200, 20);
        add(txtDesplegableTB);

        nombresTB.setBounds(450, 140, 200, 20);
        add(nombresTB);

        // Texto Nombre
        txtNombreTB.setBounds(250, 220 , 200, 20);
        add(txtNombreTB);

        // Área texto Nombre
        areanomTB.setBounds(450,220, 200,20);
        add(areanomTB);

        bBorrarTeclado.setBounds(700, 400, 200, 20);
        add(bBorrarTeclado);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresTB.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomTB.setText(selectedName);
                } else {
                    areanomTB.setText("");  // Limpiar el área de texto si se selecciona el elemento vacío
                }
            }
        };

        ActionListener lBorrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTec = areanomTB.getText().trim();
                // Verificar si el área de texto está vacía
                if (nombreTec.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecciona un teclado para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Llamar al controlador para eliminar el texto
                    CtrlPresentacion.borrarTeclado(nombreTec);
                    // Actualizar el JComboBox eliminando el texto borrado
                    nombresTB.removeItem(nombreTec);
                    nombresTB.setSelectedItem("");
                    JOptionPane.showMessageDialog(frame, "Teclado eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    CtrlPresentacion.guardarConjuntos();
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

        nombresTB.addActionListener(lElementoSeleccionado);
        bBorrarTeclado.addActionListener(lBorrar);
        bsalir.addActionListener(lSalir);

    }
}
