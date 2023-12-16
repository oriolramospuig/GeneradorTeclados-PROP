package main.presentation.views;

import main.domain.classes.types.PairInt;
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
 * Aquesta vista s’encarrega de carregar un fitxer guardat a l’ordinador i obrir-lo. La vista obre l’explorador d’arxius
 * on es podran seleccionar únicament fitxers que el nostre sistema és capaç d’obrir. Es proporciona un botó de
 * cancel·lar que tornarà a la VistaMenuPrincipal i un botó d’obrir que farà que s’obri a la VistaSpreadsheet el fitxer
 * seleccionat.
 * @author Marc Clapés Marana (marc.clapes.marana@estudiantat.upc.edu)
 */
public class VistaTecladoM extends JFrame{
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaTM = new JLabel("Modificar teclado");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación */
    private final JLabel txtDesplegableTM = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de los teclados*/
    private JComboBox<String> nombresTM = new JComboBox<>();
    /** Desplegable con los nombres de los alfabetos*/
    private JComboBox<String> nombresAlfabetosTM = new JComboBox<>();
    /** Desplegable con los nombres de las asociaciones*/
    private JComboBox<String> nombresAsociacionesTM = new JComboBox<>();
    /** Desplegable con las posibles dimensiones del teclado*/
    private JComboBox<String> posiblesDimensiones = new JComboBox<>();
    private final JButton bModificarTeclado = new JButton("Modificar teclado");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtNombreTM = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areanomTM = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del teclado */
    private final JLabel txtNombreAlfabetoTM = new JLabel("ALFABETO:");
    /** Área de texto para introducir el contenido del teclado que se quiere crear */
    private final JTextArea areaContenidoAlfabetoTM = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del teclado */
    private final JLabel txtNombreAsociacionTM = new JLabel("ASOCIACIÓN:");
    /** Área de texto para introducir el contenido del teclado que se quiere crear */
    private final JTextArea areaContenidoAsociacionTM = new JTextArea();
    private final JLabel txtFilasTM = new JLabel("FILAS:");
    private final JTextField areaFilasTM = new JTextField();
    private final JLabel txtColumnasTM = new JLabel("COLUMNAS:");
    private final JTextField areaColumnasTM = new JTextField();
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtContenidoTM = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areacontenidoTM = new JTextArea();

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

        areaContenidoAlfabetoTM.setBounds(400,320, 200,20);
        add(areaContenidoAlfabetoTM);

        txtNombreAsociacionTM.setBounds(200, 350, 200, 20);
        add(txtNombreAsociacionTM);

        areaContenidoAsociacionTM.setBounds(400,350, 200,20);
        add(areaContenidoAsociacionTM);

        txtFilasTM.setBounds(200, 380, 200, 20);
        add(txtFilasTM);

        areaFilasTM.setBounds(400, 380, 200, 20);
        add(areaFilasTM);

        txtColumnasTM.setBounds(200, 410, 200, 20);
        add(txtColumnasTM);

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
                String path = System.getProperty("user.dir") + "/Entrega1/data/Teclados";

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
                        CtrlPresentacion.guardaTeclados();
                    } else {
                        JOptionPane.showMessageDialog(VistaTecladoM.this, "Error: No se ha podido modificar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VistaTecladoM.this, "Error: Las filas y las columnas deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
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

    private void seleccionarItemEnComboBox(JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                comboBox.setSelectedIndex(i);
                return;
            }
        }
        comboBox.setSelectedIndex(0);
    }

    private void seleccionarDimensiones(PairInt dimensiones) {
        String dimensionStr = dimensiones.getPrimero() + "x" + dimensiones.getSegundo();
        seleccionarItemEnComboBox(posiblesDimensiones, dimensionStr);
    }
}
