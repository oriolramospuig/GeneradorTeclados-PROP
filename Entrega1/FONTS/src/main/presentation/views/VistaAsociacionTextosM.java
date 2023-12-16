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
public class VistaAsociacionTextosM extends JFrame{
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaATM = new JLabel("Modificar asociación");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación */
    private final JLabel txtDesplegableATM = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de las asociaciones*/
    private JComboBox<String> nombresATM = new JComboBox<>();
    private final JButton bModificarAsociacion = new JButton("Modificar asociación");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtNombreATM = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areanomATM = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtContenidoATM = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areacontenidoATM = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar una asociacion sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");

    public VistaAsociacionTextosM() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
        ArrayList<String> nombres = CtrlPresentacion.getNombresAsociaciones();
        nombresATM = new JComboBox<>();
        nombresATM.addItem("");
        for (String nombre : nombres) {
            nombresATM.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaATM.setBounds(10, 5, 120, 30);
        add(tituloVistaATM);

        txtDesplegableATM.setBounds(200, 120, 200, 20);
        add(txtDesplegableATM);

        nombresATM.setBounds(400, 120, 200, 20);
        add(nombresATM);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreATM.setBounds(200, 180, 200, 20);
        add(txtNombreATM);

        // Área texto Nombre
        areanomATM.setEditable(false);
        areanomATM.setBounds(400,180, 200,20);
        add(areanomATM);

        txtContenidoATM.setBounds(200, 220, 200, 20);
        add(txtContenidoATM);

        JScrollPane scrollPane = new JScrollPane(areacontenidoATM); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 220, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        // Botón modificar alfabetos
        bModificarAsociacion.setBounds(700, 420, 200, 20);
        add(bModificarAsociacion);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresATM.getSelectedItem();
                ArrayList<String> textos = CtrlPresentacion.consultarCjtTextosAsociacion(selectedName);
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomATM.setText(selectedName);
                    StringBuilder contenidoStr = new StringBuilder();
                    for (String texto : textos) {
                        contenidoStr.append(texto).append("\n");
                    }
                    areacontenidoATM.setText(contenidoStr.toString());
                } else {
                    areanomATM.setText("");
                    areacontenidoATM.setText("");
                }
            }
        };

        ActionListener lModificarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAsoc = areanomATM.getText().trim();
                String contenidoStr = areacontenidoATM.getText();

                // Comprobar si se ha seleccionado un alfabeto
                if (nombreAsoc.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaAsociacionTextosM.this, "No hay ninguna asociación seleccionado.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Comprobar si el contenido ha sido modificado
                //s'ha de canviar
                ArrayList<String> contenidoActual = CtrlPresentacion.consultarCjtTextosAsociacion(nombreAsoc);
                StringBuilder contenidoActualStr = new StringBuilder();
                for (String c : contenidoActual) {
                    contenidoActualStr.append(c).append("\n");
                }
                if (contenidoActualStr.toString().equals(contenidoStr)) {
                    JOptionPane.showMessageDialog(VistaAsociacionTextosM.this, "No se han realizado cambios en el contenido.",
                            "Información", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // Convertir el contenido del área de texto a ArrayList<Character>
                ArrayList<String> nuevoContenido = new ArrayList<>();
                String[] lineas = contenidoStr.split("\n");  // Divide el texto en líneas usando "\n" como delimitador

                for (String linea : lineas) {
                    nuevoContenido.add(linea);  // Agrega cada línea al ArrayList
                }

                // Llamar a la función de control para modificar el alfabeto
                //CtrlPresentacion.modificarAlfabeto(nombreAlfabeto, nuevoContenido);
                JOptionPane.showMessageDialog(VistaAsociacionTextosM.this, "Asociación modificada con éxito.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                CtrlPresentacion.guardaAsociaciones();
            }
        };




        ActionListener lSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        nombresATM.addActionListener(lElementoSeleccionado);
        bModificarAsociacion.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }
}
