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
import java.util.HashMap;

/**
 * Aquesta vista s’encarrega de carregar un fitxer guardat a l’ordinador i obrir-lo. La vista obre l’explorador d’arxius
 * on es podran seleccionar únicament fitxers que el nostre sistema és capaç d’obrir. Es proporciona un botó de
 * cancel·lar que tornarà a la VistaMenuPrincipal i un botó d’obrir que farà que s’obri a la VistaSpreadsheet el fitxer
 * seleccionat.
 * @author Marc Clapés Marana (marc.clapes.marana@estudiantat.upc.edu)
 */
public class VistaTextoM extends JFrame{
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaTxtM = new JLabel("Modificar texto");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtDesplegableTxtM = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de los textos*/
    private JComboBox<String> nombresTxtM = new JComboBox<>();
    private final JButton bModificarTexto = new JButton("Modificar texto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto a consultar*/
    private final JLabel txtNombreTxtM = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere consultar */
    private final JTextArea areanomTxtM = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto a consultar*/
    private final JLabel txtContenidoTxtM = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre del texto que se quiere consultar */
    private final JTextArea areacontenidoTxtM = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un texto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");

    public VistaTextoM() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
        ArrayList<String> nombres = CtrlPresentacion.getNombresTextos();
        nombresTxtM = new JComboBox<>();
        nombresTxtM.addItem("");
        for (String nombre : nombres) {
            nombresTxtM.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaTxtM.setBounds(10, 5, 120, 30);
        add(tituloVistaTxtM);

        txtDesplegableTxtM.setBounds(200, 120, 200, 20);
        add(txtDesplegableTxtM);

        nombresTxtM.setBounds(400, 120, 200, 20);
        add(nombresTxtM);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTxtM.setBounds(200, 180, 200, 20);
        add(txtNombreTxtM);

        // Área texto Nombre
        areanomTxtM.setEditable(false);
        areanomTxtM.setBounds(400,180, 200,20);
        add(areanomTxtM);

        txtContenidoTxtM.setBounds(200, 220, 200, 20);
        add(txtContenidoTxtM);

        JScrollPane scrollPane = new JScrollPane(areacontenidoTxtM); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 220, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        // Botón modificar alfabetos
        bModificarTexto.setBounds(700, 420, 200, 20);
        add(bModificarTexto);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresTxtM.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    String contenido = CtrlPresentacion.consultarContenidoTexto(selectedName);
                    areanomTxtM.setText(selectedName);
                    areacontenidoTxtM.setText(contenido);
                } else {
                    areanomTxtM.setText("");
                    areacontenidoTxtM.setText("");
                }
            }
        };

        ActionListener lModificarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTexto = areanomTxtM.getText().trim();
                String contenidoModificado = areacontenidoTxtM.getText();

                if (nombreTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTextoM.this, "No hay ningún texto seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int opcion = JOptionPane.showConfirmDialog(null, "Si modifica este texto, se modificarán todos los teclados creados a partir de una asociación vinculada a este texto.\n¿Está seguro de que desea continuar?", "Aviso", JOptionPane.YES_NO_OPTION);

                // Verificar la respuesta del usuario
                if (opcion == JOptionPane.YES_OPTION) { // El usuario eligió continuar
                    boolean esTextoPalabras = CtrlPresentacion.esTextoDePalabras(nombreTexto);
                    if (esTextoPalabras) {
                        // Modificar texto de palabras
                        CtrlPresentacion.modificarContenidoTexto(nombreTexto, contenidoModificado);
                    } else {
                        // Modificar texto de frecuencias
                        HashMap<String, Integer> frecuencias = new HashMap<>();
                        boolean formatoCorrecto = true;

                        String[] lineas = contenidoModificado.split("\n");
                        for (String linea : lineas) {
                            if (!linea.matches("\\S+\\s+\\d+")) {
                                formatoCorrecto = false;
                                break;
                            }
                            String[] partes = linea.trim().split("\\s+");
                            frecuencias.put(partes[0], Integer.parseInt(partes[1]));
                        }

                        if (formatoCorrecto) {
                            CtrlPresentacion.modificarContenidoTextoFrecuencias(nombreTexto, frecuencias);
                        } else {
                            JOptionPane.showMessageDialog(VistaTextoM.this, "Formato de contenido incorrecto para el tipo de texto.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    JOptionPane.showMessageDialog(VistaTextoM.this, "Texto modificado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    CtrlPresentacion.guardaTextos();
                } else {
                    // El usuario eligió no continuar
                    areanomTxtM.setText("");
                    areacontenidoTxtM.setText("");
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

        nombresTxtM.addActionListener(lElementoSeleccionado);
        bModificarTexto.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }
}
