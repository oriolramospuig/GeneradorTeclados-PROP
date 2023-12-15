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
 * Esta vista es la encargada de modificar un alfabeto. Se indican claramente 3 campos de texto, pero solo hay que rellenar 1 de estos 3.
 * El primer campo es una lista de desplegable de los nombres de los alfabetos existentes en el sistema.
 * De manera que el usuario debe seleccionar uno de estos para modificar.
 * El segundo campo se llenará automáticamente con el nombre que el usuario haya seleccionado de la lista del campo anterior.
 * El tercer campo se llenará automáticamente con el contenido del alfabeto que el usuario haya seleccionado en el primer campo.
 * El usuario tendrá acceso a modificar el contenido del alfabeto pero no el nombre, ya que este último es el identificador.
 * Solo se puede modificar un alfabeto si se selecciona algún nombre de la lista.
 * De no ser así, se muestra un mensaje de error avisando al usuario qué le falta para poder modificar de forma correcta el alfabeto deseado.
 * Debajo de las áreas de texto se proporciona un botón para modificar el alfabeto con la información introducida.
 * Más también hay un botón con la opción de volver al menú principal.
 * @author
 */
public class VistaAlfabetoM extends JFrame{
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaAM = new JLabel("Modificar alfabeto");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto */
    private final JLabel txtDesplegableAM = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de los alfabetos*/
    private JComboBox<String> nombresAM = new JComboBox<>();
    private final JButton bModificarAlfabeto = new JButton("Modificar alfabeto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtNombreAM = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areanomAM = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtContenidoAM = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areacontenidoAM = new JTextArea();

    public VistaAlfabetoM() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
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
                ArrayList<Character> contenido = CtrlPresentacion.consultarContenidoAlfabeto(selectedName);
                if (selectedName != null && !selectedName.isEmpty()) {
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
                //CtrlPresentacion.modificarAlfabeto(nombreAlfabeto, nuevoContenido);
                JOptionPane.showMessageDialog(VistaAlfabetoM.this, "Alfabeto modificado con éxito.",
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

        nombresAM.addActionListener(lElementoSeleccionado);
        bModificarAlfabeto.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }
}
