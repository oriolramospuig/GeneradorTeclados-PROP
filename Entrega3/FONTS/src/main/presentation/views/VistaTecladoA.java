package main.presentation.views;

import main.domain.classes.types.PairInt;
import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Constructor de la vista para agregar teclados.
 * <p>
 * Inicializa los componentes de la interfaz de usuario y configura el comportamiento de los eventos
 * para la creación de nuevos teclados. Permite seleccionar entre diferentes alfabetos y asociaciones,
 * establecer dimensiones personalizadas y elegir el método de generación del teclado (Branch & Bound o Simulated Annealing).
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class VistaTecladoA extends JFrame {
    /** Panel principal que contiene todos los componentes de la interfaz. */
    private final JPanel lamina = new JPanel();

    /** Título de la sección para agregar teclados. */
    private final JLabel tituloVistaTA = new JLabel("Agregar teclado");

    /** Botón para agregar un teclado mediante el algoritmo Branch & Bound. */
    private final JButton bAgregarTecladoBB = new JButton("Agregar teclado B&B");

    /** Botón para agregar un teclado mediante el algoritmo Simulated Annealing. */
    private final JButton bAgregarTecladoSA = new JButton("Agregar teclado SA");

    /** Desplegable con los nombres de los alfabetos disponibles. */
    private JComboBox<String> nombresAlfabetosTA = new JComboBox<>();

    /** Desplegable con los nombres de las asociaciones de texto disponibles. */
    private JComboBox<String> nombresAsociacionesTA = new JComboBox<>();

    /** Desplegable con las posibles dimensiones para los teclados. */
    private JComboBox<String> posiblesDimensiones = new JComboBox<>();

    /** Botón para regresar a la pantalla del menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Etiqueta para el campo de nombre del teclado. */
    private final JLabel txtNombreTA = new JLabel("NOMBRE:");

    /** Campo de texto para introducir el nombre del nuevo teclado. */
    private final JTextArea areanomTA = new JTextArea();

    /** Etiqueta para el campo del nombre del alfabeto. */
    private final JLabel txtNombreAlfabetoTA = new JLabel("ALFABETO:");

    /** Campo de texto para mostrar el alfabeto seleccionado. */
    private final JTextArea areaContenidoAlfabetoTA = new JTextArea();

    /** Etiqueta para el campo del nombre de la asociación de texto. */
    private final JLabel txtNombreAsociacionTA = new JLabel("ASOCIACIÓN:");

    /** Campo de texto para mostrar la asociación de texto seleccionada. */
    private final JTextArea areaContenidoAsociacionTA = new JTextArea();

    /** Etiqueta para el campo de número de filas. */
    private final JLabel txtFilasTA = new JLabel("FILAS:");

    /** Campo de texto para introducir el número de filas del teclado. */
    private final JTextField areaFilasTA = new JTextField();

    /** Etiqueta para el campo de número de columnas. */
    private final JLabel txtColumnasTA = new JLabel("COLUMNAS:");

    /** Campo de texto para introducir el número de columnas del teclado. */
    private final JTextField areaColumnasTA = new JTextField();

    /** Etiqueta explicativa para el botón de Branch and Bound. */
    private final JLabel txtbotonBB = new JLabel("Para generar el teclado mediante Branch&Bound");

    /** Etiqueta explicativa para el botón de Simulated Annealing. */
    private final JLabel txtbotonSA = new JLabel("Para generar el teclado mediante Simulated Annealing");

    /**
     * Constructor de la vista para agregar teclados.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura el comportamiento de los eventos
     * para la creación de nuevos teclados. Permite seleccionar entre diferentes alfabetos y asociaciones,
     * establecer dimensiones personalizadas y elegir el método de generación del teclado (Branch & Bound o Simulated Annealing).
     */
    public VistaTecladoA(){

        setBounds(250, 150, 1000, 600);

        ArrayList<String> nombres = CtrlPresentacion.getNombresAlfabetos();
        nombresAlfabetosTA = new JComboBox<>();
        nombresAlfabetosTA.addItem("");
        for (String nombre : nombres) {
            nombresAlfabetosTA.addItem(nombre);
        }
        ArrayList<String> nombresAT = CtrlPresentacion.getNombresAsociaciones();
        nombresAsociacionesTA = new JComboBox<>();
        nombresAsociacionesTA.addItem("");
        for (String nombre : nombresAT) {
            nombresAsociacionesTA.addItem(nombre);
        }

        posiblesDimensiones = new JComboBox<>();
        posiblesDimensiones.addItem("");

        tituloVistaTA.setBounds(10, 5, 120, 30);
        add(tituloVistaTA);

        txtNombreTA.setBounds(250, 100, 200, 20);
        add(txtNombreTA);

        areanomTA.setBounds(450,100, 200,20);
        add(areanomTA);

        txtNombreAlfabetoTA.setBounds(250, 140, 200, 20);
        add(txtNombreAlfabetoTA);

        areaContenidoAlfabetoTA.setBounds(450,140, 200,20);
        add(areaContenidoAlfabetoTA);

        txtNombreAsociacionTA.setBounds(250, 240, 200, 20);
        add(txtNombreAsociacionTA);

        areaContenidoAsociacionTA.setBounds(450,240, 200,20);
        add(areaContenidoAsociacionTA);

        txtFilasTA.setBounds(250, 320, 200, 20);
        add(txtFilasTA);

        areaFilasTA.setBounds(450, 320, 200, 20);
        add(areaFilasTA);

        txtColumnasTA.setBounds(250, 350, 200, 20);
        add(txtColumnasTA);

        areaColumnasTA.setBounds(450, 350, 200, 20);
        add(areaColumnasTA);

        posiblesDimensiones.setBounds(660, 320, 175, 20);
        add(posiblesDimensiones);

        nombresAlfabetosTA.setBounds(660, 140, 175, 20);
        add(nombresAlfabetosTA);

        nombresAsociacionesTA.setBounds(660, 240, 175, 20);
        add(nombresAsociacionesTA);

        txtbotonBB.setBounds(200,420, 300, 20);
        add(txtbotonBB);

        txtbotonSA.setBounds(650,420, 320, 20);
        add(txtbotonSA);

        bAgregarTecladoBB.setBounds(250, 450, 200, 20);
        add(bAgregarTecladoBB);

        bAgregarTecladoSA.setBounds(700, 450, 200, 20);
        add(bAgregarTecladoSA);

        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lAgregarBB = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTeclado = areanomTA.getText().trim();
                String nombreAlfabeto = areaContenidoAlfabetoTA.getText();
                String nombreAsociacion = areaContenidoAsociacionTA.getText();
                String filasStr = areaFilasTA.getText();
                String columnasStr = areaColumnasTA.getText();

                // Verificar que el nombre no esté vacío
                if (nombreTeclado.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: No Nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar que haya contenido proporcionado
                if (nombreAlfabeto.isEmpty() || nombreAsociacion.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: Debe seleccionar un alfabeto y una asociación", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (filasStr.isEmpty() || columnasStr.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: Debe seleccionar filas y columnas", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int filas = Integer.parseInt(filasStr);
                    int columnas = Integer.parseInt(columnasStr);

                    // Llamar a CtrlPresentacion para agregar el teclado
                    PairInt dimensiones = new PairInt(filas, columnas);
                    int agregado = CtrlPresentacion.agregarTeclado(nombreTeclado, nombreAlfabeto, nombreAsociacion, dimensiones, true);

                    if (agregado == 0) {
                        JOptionPane.showMessageDialog(VistaTecladoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomTA.setText("");
                        areaContenidoAlfabetoTA.setText("");
                        areaContenidoAsociacionTA.setText("");
                        areaFilasTA.setText("");
                        areaColumnasTA.setText("");
                        CtrlPresentacion.guardaTeclados();
                    } else {
                        JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: El nombre " + nombreTeclado + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: Las filas y las columnas deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        ActionListener lAgregarSA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTeclado = areanomTA.getText().trim();
                String nombreAlfabeto = areaContenidoAlfabetoTA.getText();
                String nombreAsociacion = areaContenidoAsociacionTA.getText();
                String filasStr = areaFilasTA.getText();
                String columnasStr = areaColumnasTA.getText();

                // Verificar que el nombre no esté vacío
                if (nombreTeclado.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: No Nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar que haya contenido proporcionado
                if (nombreAlfabeto.isEmpty() || nombreAsociacion.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: Debe seleccionar un alfabeto y una asociación", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (filasStr.isEmpty() || columnasStr.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: Debe seleccionar filas y columnas", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int filas = Integer.parseInt(filasStr);
                    int columnas = Integer.parseInt(columnasStr);

                    // Llamar a CtrlPresentacion para agregar el teclado
                    PairInt dimensiones = new PairInt(filas, columnas);
                    int agregado = CtrlPresentacion.agregarTeclado(nombreTeclado, nombreAlfabeto, nombreAsociacion, dimensiones, false);

                    if (agregado == 0) {
                        JOptionPane.showMessageDialog(VistaTecladoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomTA.setText("");
                        areaContenidoAlfabetoTA.setText("");
                        areaContenidoAsociacionTA.setText("");
                        areaFilasTA.setText("");
                        areaColumnasTA.setText("");
                        nombresAlfabetosTA.setSelectedItem("");
                        nombresAsociacionesTA.setSelectedItem("");
                        CtrlPresentacion.guardaTeclados();
                    } else {
                        JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: El nombre " + nombreTeclado + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VistaTecladoA.this, "Error: Las filas y las columnas deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        ActionListener lSeleccionarAlfabeto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresAlfabetosTA.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    areaContenidoAlfabetoTA.setText(selectedName);

                    ArrayList<PairInt> dimensiones = CtrlPresentacion.getPosiblesDimensiones(selectedName);
                    posiblesDimensiones.removeAllItems();
                    posiblesDimensiones.addItem("");
                    for (PairInt dim : dimensiones) {
                        posiblesDimensiones.addItem(dim.getPrimero() + "x" + dim.getSegundo());
                    }

                } else {
                    areaContenidoAlfabetoTA.setText("");
                    posiblesDimensiones.removeAllItems();
                    posiblesDimensiones.addItem("");
                    areaFilasTA.setText("");
                    areaColumnasTA.setText("");
                }
            }
        };

        ActionListener lSeleccionarAsociacion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresAsociacionesTA.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    areaContenidoAsociacionTA.setText(selectedName);
                } else {
                    areaContenidoAsociacionTA.setText("");
                }
            }
        };

        ActionListener lSeleccionarDimension = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDimension = (String) posiblesDimensiones.getSelectedItem();
                if (selectedDimension != null && !selectedDimension.isEmpty()) {
                    String[] parts = selectedDimension.split("x");
                    areaFilasTA.setText(parts[0]);
                    areaColumnasTA.setText(parts[1]);
                } else {
                    areaFilasTA.setText("");
                    areaColumnasTA.setText("");
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

        nombresAlfabetosTA.addActionListener(lSeleccionarAlfabeto);
        nombresAsociacionesTA.addActionListener(lSeleccionarAsociacion);
        posiblesDimensiones.addActionListener(lSeleccionarDimension);
        bAgregarTecladoBB.addActionListener(lAgregarBB);
        bAgregarTecladoSA.addActionListener(lAgregarSA);
        bsalir.addActionListener(lSalir);
    }
}
