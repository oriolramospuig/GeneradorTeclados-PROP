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
public class VistaAlfabetoC extends JFrame{
    /** Finestra de selecció de l'arxiu que es vol carregar al nostre full de càlcul */
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaAC = new JLabel("Consultar alfabeto");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto */
    private final JLabel txtDesplegableAC = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de los alfabetos*/
    private JComboBox<String> nombresAC = new JComboBox<>();
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtNombreAC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areanomAC = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtContenido = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areacontenidoAC = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un alfabeto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");

    public VistaAlfabetoC() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
        ArrayList<String> nombres = CtrlPresentacion.getNombresAlfabetos();
        nombresAC = new JComboBox<>();
        nombresAC.addItem("");
        for (String nombre : nombres) {
            nombresAC.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaAC.setBounds(10, 5, 120, 30);
        add(tituloVistaAC);

        txtDesplegableAC.setBounds(200, 120, 200, 20);
        add(txtDesplegableAC);

        nombresAC.setBounds(400, 120, 200, 20);
        add(nombresAC);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreAC.setBounds(200, 180, 200, 20);
        add(txtNombreAC);

        // Área texto Nombre
        areanomAC.setEditable(false);
        areanomAC.setBounds(400,180, 200,20);
        add(areanomAC);

        txtContenido.setBounds(200, 220, 200, 20);
        add(txtContenido);

        areacontenidoAC.setEditable(false); // Opcional, si no quieres que se pueda editar el contenido
        JScrollPane scrollPane = new JScrollPane(areacontenidoAC); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 220, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresAC.getSelectedItem();
                ArrayList<Character> contenido = CtrlPresentacion.consultarContenidoAlfabeto(selectedName);
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomAC.setText(selectedName);
                    // Convertir ArrayList<Character> a String
                    StringBuilder contenidoStr = new StringBuilder();
                    for (Character c : contenido) {
                        contenidoStr.append(c);
                    }
                    areacontenidoAC.setText(contenidoStr.toString());
                } else {
                    areanomAC.setText("");
                    areacontenidoAC.setText("");
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

        nombresAC.addActionListener(lElementoSeleccionado);
        bsalir.addActionListener(lSalir);
    }
}
