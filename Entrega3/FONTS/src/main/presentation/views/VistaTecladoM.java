package main.presentation.views;

import main.domain.classes.types.PairInt;
import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Vista de la interfaz de usuario para la modificación de teclados.
 * Esta vista permite al usuario modificar teclados existentes en el sistema. Proporciona una interfaz gráfica
 * para seleccionar un teclado existente, visualizar y editar sus detalles, como el nombre, el alfabeto asociado,
 * la asociación de textos, y las dimensiones del teclado.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class VistaTecladoM extends JFrame {

    /** Panel donde se incluyen los elementos de la ventana. */
    private final JPanel lamina = new JPanel();

    /** Título de media ventana. */
    private final JLabel tituloVistaTM = new JLabel("Modificar teclado");

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación. */
    private final JLabel txtDesplegableTM = new JLabel("LISTA NOMBRES:");

    /** Desplegable con los nombres de los teclados.*/
    private JComboBox<String> nombresTM = new JComboBox<>();

    /** Desplegable con los nombres de los alfabetos.*/
    private JComboBox<String> nombresAlfabetosTM = new JComboBox<>();

    /** Desplegable con los nombres de las asociaciones.*/
    private JComboBox<String> nombresAsociacionesTM = new JComboBox<>();

    /** Desplegable con las posibles dimensiones del teclado.*/
    private JComboBox<String> posiblesDimensiones = new JComboBox<>();

    /** Botón para iniciar el proceso de modificación del teclado seleccionado.*/
    private final JButton bModificarTeclado = new JButton("Modificar teclado");

    /** Botó de tornar a la pantalla del menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Etiqueta para indicar el campo donde se introduce el nombre del teclado a consultar o modificar.*/
    private final JLabel txtNombreTM = new JLabel("NOMBRE:");

    /** Área de texto para ingresar o mostrar el nombre del teclado que se está consultando o modificando. */
    private final JTextArea areanomTM = new JTextArea();

    /** Etiqueta para indicar el campo relacionado con la elección del alfabeto para el teclado. */
    private final JLabel txtNombreAlfabetoTM = new JLabel("ALFABETO:");

    /** Área de texto para ingresar o mostrar el nombre del alfabeto asociado al teclado. */
    private final JTextArea areaContenidoAlfabetoTM = new JTextArea();

    /** Etiqueta para indicar el campo relacionado con la elección de la asociación de textos para el teclado. */
    private final JLabel txtNombreAsociacionTM = new JLabel("ASOCIACIÓN:");

    /** Área de texto para ingresar o mostrar el nombre de la asociación de textos asociada al teclado. */
    private final JTextArea areaContenidoAsociacionTM = new JTextArea();

    /** Etiqueta para indicar el campo donde se introduce el número de filas del teclado.*/
    private final JLabel txtFilasTM = new JLabel("FILAS:");

    /** Campo de texto para ingresar o mostrar el número de filas del teclado.*/
    private final JTextField areaFilasTM = new JTextField();

    /** Etiqueta para indicar el campo donde se introduce el número de columnas del teclado.*/
    private final JLabel txtColumnasTM = new JLabel("COLUMNAS:");

    /** Campo de texto para ingresar o mostrar el número de columnas del teclado.*/
    private final JTextField areaColumnasTM = new JTextField();

    /** Etiqueta para indicar el área donde se muestra el contenido actual del teclado.*/
    private final JLabel txtContenidoTM = new JLabel("CONTENIDO:");

    /** Área de texto para mostrar el contenido actual del teclado. */
    private final JTextArea areacontenidoTM = new JTextArea();

    /**
     * Constructor de la vista para modificar teclados.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura el comportamiento de los eventos,
     * como la selección de teclados, alfabetos, asociaciones y dimensiones.
     */
    public VistaTecladoM() {
        setBounds(250, 150, 1000, 600);

        ArrayList<String> nombres = CtrlPresentacion.getListaTeclados();
        nombresTM = new JComboBox<>();
        nombresTM.addItem("");
        for (String nombre : nombres) {
            nombresTM.addItem(nombre);
        }
        ArrayList<String> nombresA = CtrlPresentacion.getNombresAlfabetos();
        nombresAlfabetosTM = new JComboBox<>();
        nombresAlfabetosTM.addItem("");
        for (String nombre : nombresA) {
            nombresAlfabetosTM.addItem(nombre);
        }
        ArrayList<String> nombresAT = CtrlPresentacion.getNombresAsociaciones();
        nombresAsociacionesTM = new JComboBox<>();
        nombresAsociacionesTM.addItem("");
        for (String nombre : nombresAT) {
            nombresAsociacionesTM.addItem(nombre);
        }

        posiblesDimensiones = new JComboBox<>();
        posiblesDimensiones.addItem("");

        tituloVistaTM.setBounds(10, 5, 120, 30);
        add(tituloVistaTM);

        txtDesplegableTM.setBounds(200, 80, 200, 20);
        add(txtDesplegableTM);

        nombresTM.setBounds(400, 80, 200, 20);
        add(nombresTM);

        txtNombreTM.setBounds(200, 120, 200, 20);
        add(txtNombreTM);

        areanomTM.setEditable(false);
        areanomTM.setBounds(400,120, 200,20);
        add(areanomTM);

        txtContenidoTM.setBounds(200, 150, 200, 20);
        add(txtContenidoTM);

        JScrollPane scrollPane = new JScrollPane(areacontenidoTM); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 150, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        txtNombreAlfabetoTM.setBounds(200, 320, 200, 20);
        add(txtNombreAlfabetoTM);

        areaContenidoAlfabetoTM.setEditable(false);
        areaContenidoAlfabetoTM.setBounds(400,320, 200,20);
        add(areaContenidoAlfabetoTM);

        txtNombreAsociacionTM.setBounds(200, 350, 200, 20);
        add(txtNombreAsociacionTM);

        areaContenidoAsociacionTM.setEditable(false);
        areaContenidoAsociacionTM.setBounds(400,350, 200,20);
        add(areaContenidoAsociacionTM);

        txtFilasTM.setBounds(200, 380, 200, 20);
        add(txtFilasTM);

        areaFilasTM.setEditable(false);
        areaFilasTM.setBounds(400, 380, 200, 20);
        add(areaFilasTM);

        txtColumnasTM.setBounds(200, 410, 200, 20);
        add(txtColumnasTM);

        areaColumnasTM.setEditable(false);
        areaColumnasTM.setBounds(400, 410, 200, 20);
        add(areaColumnasTM);

        posiblesDimensiones.setBounds(610, 380, 175, 20);
        add(posiblesDimensiones);

        nombresAlfabetosTM.setBounds(610, 320, 175, 20);
        add(nombresAlfabetosTM);

        nombresAsociacionesTM.setBounds(610, 350, 175, 20);
        add(nombresAsociacionesTM);

        bModificarTeclado.setBounds(700, 450, 200, 20);
        add(bModificarTeclado);

        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresTM.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    char[][] contenido = CtrlPresentacion.consultarContenidoTeclado(selectedName);
                    String alf = CtrlPresentacion.consultarAlfabetoAsociadoTeclado(selectedName);
                    String asoc = CtrlPresentacion.consultarAsociacionAsociadoTeclado(selectedName);
                    PairInt dim = CtrlPresentacion.consultarDimensionesTeclado(selectedName);

                    areanomTM.setText(selectedName);
                    seleccionarItemEnComboBox(nombresAlfabetosTM, alf);
                    seleccionarItemEnComboBox(nombresAsociacionesTM, asoc);
                    areaContenidoAlfabetoTM.setText(alf);
                    areaContenidoAsociacionTM.setText(asoc);
                    if (dim != null) {
                        areaFilasTM.setText(Integer.toString(dim.getPrimero()));
                        areaColumnasTM.setText(Integer.toString(dim.getSegundo()));
                        seleccionarDimensiones(dim);
                    }
                    areacontenidoTM.setText(convertirContenidoAString(contenido));
                } else {
                    areanomTM.setText("");
                    areacontenidoTM.setText("");
                    areaContenidoAsociacionTM.setText("");
                    areaContenidoAlfabetoTM.setText("");
                    areaFilasTM.setText("");
                    areaColumnasTM.setText("");
                    nombresAlfabetosTM.setSelectedIndex(0);
                    nombresAsociacionesTM.setSelectedIndex(0);
                    posiblesDimensiones.setSelectedIndex(0);
                }
            }
        };


        ActionListener lModificarT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTeclado = areanomTM.getText().trim();
                String nombreAlfabeto = areaContenidoAlfabetoTM.getText();
                String nombreAsociacion = areaContenidoAsociacionTM.getText();
                String filasStr = areaFilasTM.getText();
                String columnasStr = areaColumnasTM.getText();

                // Verificar que el nombre no esté vacío
                if (nombreTeclado.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoM.this, "Error: No Nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar que haya contenido proporcionado
                if (nombreAlfabeto.isEmpty() || nombreAsociacion.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoM.this, "Error: Debe seleccionar un alfabeto y una asociación", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (filasStr.isEmpty() || columnasStr.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoM.this, "Error: Debe seleccionar filas y columnas", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int opcion = JOptionPane.showConfirmDialog(null, "Si modifica este teclado perderá el teclado anterior.\n¿Está seguro de que desea continuar?", "Aviso", JOptionPane.YES_NO_OPTION);

                // Verificar la respuesta del usuario
                if (opcion == JOptionPane.YES_OPTION) { // El usuario eligió continuar
                    try {
                        int filas = Integer.parseInt(filasStr);
                        int columnas = Integer.parseInt(columnasStr);

                        // Llamar a CtrlPresentacion para agregar el teclado
                        PairInt dimensiones = new PairInt(filas, columnas);
                        CtrlPresentacion.borrarTeclado(nombreTeclado);
                        int modificado = CtrlPresentacion.agregarTeclado(nombreTeclado, nombreAlfabeto, nombreAsociacion, dimensiones, false);

                        // Mensaje de éxito o error
                        if (modificado == 0) {
                            JOptionPane.showMessageDialog(VistaTecladoM.this, "Modificado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            areanomTM.setText("");
                            areaContenidoAlfabetoTM.setText("");
                            areaContenidoAsociacionTM.setText("");
                            areaFilasTM.setText("");
                            areaColumnasTM.setText("");
                            areacontenidoTM.setText("");
                            nombresAlfabetosTM.setSelectedItem("");
                            nombresAsociacionesTM.setSelectedItem("");
                            nombresTM.setSelectedItem("");
                            CtrlPresentacion.guardarConjuntos();
                        } else {
                            JOptionPane.showMessageDialog(VistaTecladoM.this, "Error: No se ha podido modificar", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(VistaTecladoM.this, "Error: Las filas y las columnas deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // El usuario eligió no continuar
                    areanomTM.setText("");
                    areaContenidoAlfabetoTM.setText("");
                    areaContenidoAsociacionTM.setText("");
                    areaFilasTM.setText("");
                    areaColumnasTM.setText("");
                    areacontenidoTM.setText("");
                    nombresAlfabetosTM.setSelectedItem("");
                    nombresAsociacionesTM.setSelectedItem("");
                    nombresTM.setSelectedItem("");
                }
            }
        };

        ActionListener lSeleccionarAlfabeto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresAlfabetosTM.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    areaContenidoAlfabetoTM.setText(selectedName);

                    ArrayList<PairInt> dimensiones = CtrlPresentacion.getPosiblesDimensiones(selectedName);
                    posiblesDimensiones.removeAllItems();
                    posiblesDimensiones.addItem("");
                    for (PairInt dim : dimensiones) {
                        posiblesDimensiones.addItem(dim.getPrimero() + "x" + dim.getSegundo());
                    }

                } else {
                    areaContenidoAlfabetoTM.setText("");
                    posiblesDimensiones.removeAllItems();
                    posiblesDimensiones.addItem("");
                }
            }
        };

        ActionListener lSeleccionarAsociacion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresAsociacionesTM.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    areaContenidoAsociacionTM.setText(selectedName);
                } else {
                    areaContenidoAsociacionTM.setText("");
                }
            }
        };

        ActionListener lSeleccionarDimension = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDimension = (String) posiblesDimensiones.getSelectedItem();
                if (selectedDimension != null && !selectedDimension.isEmpty()) {
                    String[] parts = selectedDimension.split("x");
                    areaFilasTM.setText(parts[0]);
                    areaColumnasTM.setText(parts[1]);
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

        nombresTM.addActionListener(lElementoSeleccionado);
        nombresAlfabetosTM.addActionListener(lSeleccionarAlfabeto);
        nombresAsociacionesTM.addActionListener(lSeleccionarAsociacion);
        posiblesDimensiones.addActionListener(lSeleccionarDimension);
        bModificarTeclado.addActionListener(lModificarT);
        bsalir.addActionListener(lSalir);

    }

    /**
     * Convierte el contenido de un teclado a una representación en String.
     * <p>
     * Este método se utiliza para mostrar el contenido del teclado en la interfaz gráfica.
     *
     * @param contenido Matriz de caracteres representando el contenido del teclado.
     * @return String que representa el contenido del teclado.
     */
    private String convertirContenidoAString(char[][] contenido) {
        StringBuilder contenidoEnTexto = new StringBuilder();
        for (char[] fila : contenido) {
            for (char c : fila) {
                contenidoEnTexto.append(c).append(" ");
            }
            contenidoEnTexto.append("\n"); // Para una nueva línea después de cada fila
        }
        return contenidoEnTexto.toString();
    }

    /**
     * Selecciona un item específico en un JComboBox.
     * <p>
     * Este método se utiliza para seleccionar automáticamente un item en los JComboBox
     * basado en un valor dado.
     *
     * @param comboBox JComboBox en el que se realizará la selección.
     * @param item El item a seleccionar en el JComboBox.
     */
    private void seleccionarItemEnComboBox(JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                comboBox.setSelectedIndex(i);
                return;
            }
        }
        comboBox.setSelectedIndex(0);
    }

    /**
     * Selecciona las dimensiones en el JComboBox correspondiente.
     * <p>
     * Este método se utiliza para seleccionar automáticamente las dimensiones de un teclado
     * en el JComboBox de dimensiones.
     *
     * @param dimensiones Objeto PairInt representando las dimensiones del teclado.
     */
    private void seleccionarDimensiones(PairInt dimensiones) {
        String dimensionStr = dimensiones.getPrimero() + "x" + dimensiones.getSegundo();
        seleccionarItemEnComboBox(posiblesDimensiones, dimensionStr);
    }
}
