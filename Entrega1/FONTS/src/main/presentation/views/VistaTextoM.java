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
                String contenido = CtrlPresentacion.consultarContenidoTexto(selectedName);
                if (selectedName != null && !selectedName.isEmpty()) {
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
                String nombreAlfabeto = areanomTxtM.getText().trim();
                String contenidoStr = areacontenidoTxtM.getText();

                // Comprobar si se ha seleccionado un alfabeto
                if (nombreAlfabeto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTextoM.this, "No hay ningún texto seleccionado.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Comprobar si el contenido ha sido modificado
                String contenidoActual = CtrlPresentacion.consultarContenidoTexto(nombreAlfabeto);
                if (contenidoActual.equals(contenidoStr)) {
                    JOptionPane.showMessageDialog(VistaTextoM.this, "No se han realizado cambios en el contenido.",
                            "Información", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                // Llamar a la función de control para modificar el texto
                CtrlPresentacion.modificarContenidoTexto(nombreAlfabeto, areacontenidoTxtM.getText());
                JOptionPane.showMessageDialog(VistaTextoM.this, "Alfabeto modificado con éxito.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
