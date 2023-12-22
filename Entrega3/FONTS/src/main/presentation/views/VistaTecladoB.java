package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Constructor de la vista para borrar teclados.
 * <p>
 * Esta vista permite al usuario seleccionar y eliminar un teclado existente del sistema.
 * Incluye un JComboBox para seleccionar el teclado a eliminar y un botón para confirmar la eliminación.
 * También proporciona la opción de regresar al menú principal.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class VistaTecladoB extends JFrame {
    /** Pantalla de error que aparece cuando falta información por introducir. */
    private JFrame frame = new JFrame();

    /** Panel principal que contiene todos los componentes de la interfaz. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana de eliminación de teclados. */
    private final JLabel tituloVistaTB = new JLabel("Borrar teclado");

    /** Botón para confirmar la eliminación del teclado seleccionado. */
    private final JButton bBorrarTeclado = new JButton("Borrar teclado");

    /** Botón para regresar a la pantalla del menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Etiqueta para el campo de selección de teclados. */
    private final JLabel txtDesplegableTB = new JLabel("LISTA NOMBRES:");

    /** Desplegable con los nombres de los teclados existentes. */
    private JComboBox<String> nombresTB = new JComboBox<>();

    /** Etiqueta para el campo de nombre del teclado. */
    private final JLabel txtNombreTB = new JLabel("NOMBRE:");

    /** Campo de texto para mostrar el nombre del teclado seleccionado para eliminar. */
    private final JTextArea areanomTB = new JTextArea();

    /**
     * Constructor de la vista para borrar teclados.
     * <p>
     * Esta vista se encarga de proporcionar una interfaz para la eliminación de teclados existentes en el sistema.
     * Incluye un JComboBox para listar y seleccionar un teclado y un botón para confirmar su eliminación.
     * La vista también ofrece un botón para regresar al menú principal. La eliminación de un teclado
     * se realiza tras la confirmación del usuario, garantizando así una interacción segura y controlada.
     */
    public VistaTecladoB() {
        setBounds(250, 150, 1000, 600);

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

        // Area texto Nombre
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
