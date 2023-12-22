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
 * Vista para modificar los detalles de un alfabeto existente.
 * <p>
 * Esta vista ofrece al usuario una lista desplegable para seleccionar un alfabeto existente y modificar su contenido.
 * Al seleccionar un alfabeto de la lista, se muestra su nombre y su contenido en campos de texto, permitiendo la modificación del contenido.
 * El nombre del alfabeto, siendo el identificador, no es modificable.
 * La interfaz proporciona una manera sencilla y directa para que los usuarios puedan actualizar los caracteres que componen un alfabeto específico.
 * Incluye un botón para confirmar las modificaciones y otro para regresar al menú principal.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class VistaAlfabetoM extends JFrame {
    /** Panel principal que contiene todos los componentes de la interfaz. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana. */
    private final JLabel tituloVistaAM = new JLabel("Modificar alfabeto");

    /** Etiqueta para la lista desplegable de nombres de alfabetos. */
    private final JLabel txtDesplegableAM = new JLabel("LISTA NOMBRES:");

    /** Lista desplegable con los nombres de los alfabetos existentes. */
    private JComboBox<String> nombresAM = new JComboBox<>();

    /** Botón para realizar las modificaciones en el alfabeto seleccionado. */
    private final JButton bModificarAlfabeto = new JButton("Modificar alfabeto");

    /** Botón para regresar al menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Etiqueta para el campo de nombre del alfabeto. */
    private final JLabel txtNombreAM = new JLabel("NOMBRE:");

    /** Campo de texto que muestra el nombre del alfabeto seleccionado. */
    private final JTextArea areanomAM = new JTextArea();

    /** Etiqueta para el campo de contenido del alfabeto. */
    private final JLabel txtContenidoAM = new JLabel("CONTENIDO:");

    /** Campo de texto que permite modificar el contenido del alfabeto seleccionado. */
    private final JTextArea areacontenidoAM = new JTextArea();

    /**
     * Constructor de la clase VistaAlfabetoM.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para la modificación de alfabetos. Permite actualizar el contenido de un alfabeto seleccionado
     * desde una lista desplegable, manteniendo el mismo nombre identificador.
     */
    public VistaAlfabetoM() {
        setBounds(250, 150, 1000, 600);

        ArrayList<String> nombres = CtrlPresentacion.getNombresAlfabetos();
        nombresAM = new JComboBox<>();
        nombresAM.addItem("");
        for (String nombre : nombres) {
            nombresAM.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaAM.setBounds(10, 5, 120, 30);
        add(tituloVistaAM);

        txtDesplegableAM.setBounds(200, 120, 200, 20);
        add(txtDesplegableAM);

        nombresAM.setBounds(400, 120, 200, 20);
        add(nombresAM);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreAM.setBounds(200, 180, 200, 20);
        add(txtNombreAM);

        // Área texto Nombre
        areanomAM.setEditable(false);
        areanomAM.setBounds(400,180, 200,20);
        add(areanomAM);

        txtContenidoAM.setBounds(200, 220, 200, 20);
        add(txtContenidoAM);

        JScrollPane scrollPane = new JScrollPane(areacontenidoAM); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 220, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        // Botón modificar alfabetos
        bModificarAlfabeto.setBounds(700, 420, 200, 20);
        add(bModificarAlfabeto);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresAM.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    ArrayList<Character> contenido = CtrlPresentacion.consultarContenidoAlfabeto(selectedName);
                    areanomAM.setText(selectedName);
                    // Convertir ArrayList<Character> a String
                    StringBuilder contenidoStr = new StringBuilder();
                    for (Character c : contenido) {
                        contenidoStr.append(c);
                    }
                    areacontenidoAM.setText(contenidoStr.toString());
                } else {
                    areanomAM.setText("");
                    areacontenidoAM.setText("");
                }
            }
        };

        ActionListener lModificarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAlfabeto = areanomAM.getText().trim();
                String contenidoStr = areacontenidoAM.getText();

                // Comprobar si se ha seleccionado un alfabeto
                if (nombreAlfabeto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaAlfabetoM.this, "No hay ningún alfabeto seleccionado.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int opcion = JOptionPane.showConfirmDialog(null, "Si modifica este alfabeto, se modificarán todos los teclados creados a partir de este alfabeto.\n¿Está seguro de que desea continuar?", "Aviso", JOptionPane.YES_NO_OPTION);

                // Verificar la respuesta del usuario
                if (opcion == JOptionPane.YES_OPTION) { // El usuario eligió continuar
                    // Comprobar si el contenido ha sido modificado
                    ArrayList<Character> contenidoActual = CtrlPresentacion.consultarContenidoAlfabeto(nombreAlfabeto);
                    StringBuilder contenidoActualStr = new StringBuilder();
                    for (Character c : contenidoActual) {
                        contenidoActualStr.append(c);
                    }
                    if (contenidoActualStr.toString().equals(contenidoStr)) {
                        JOptionPane.showMessageDialog(VistaAlfabetoM.this, "No se han realizado cambios en el contenido.",
                                "Información", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    // Convertir el contenido del área de texto a ArrayList<Character>
                    ArrayList<Character> nuevoContenido = new ArrayList<>();
                    for (char c : contenidoStr.toCharArray()) {
                        nuevoContenido.add(c);
                    }

                    // Llamar a la función de control para modificar el alfabeto
                    CtrlPresentacion.modificarContenidoAlfabeto(nombreAlfabeto, nuevoContenido);
                    JOptionPane.showMessageDialog(VistaAlfabetoM.this, "Alfabeto modificado con éxito.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    CtrlPresentacion.guardarConjuntos();
                }
                // El usuario eligió no continuar
                areanomAM.setText("");
                areacontenidoAM.setText("");
                nombresAM.setSelectedItem("");

            }
        };

        ActionListener lSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        nombresAM.addActionListener(lElementoSeleccionado);
        bModificarAlfabeto.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }
}
