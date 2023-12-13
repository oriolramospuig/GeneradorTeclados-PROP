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
public class VistaTecladoM extends JFrame{
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaTM = new JLabel("Modificar teclado");
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación */
    private final JLabel txtDesplegableTM = new JLabel("LISTA NOMBRES:");
    /** Desplegable con los nombres de las asociaciones*/
    private JComboBox<String> nombresTM = new JComboBox<>();
    private final JButton bModificarTeclado = new JButton("Modificar teclado");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtNombreTM = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areanomTM = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtContenidoTM = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areacontenidoTM = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar una asociacion sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");

    public VistaTecladoM() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
        ArrayList<String> nombres = CtrlPresentacion.getListaTeclados();
        nombresTM = new JComboBox<>();
        nombresTM.addItem("");
        for (String nombre : nombres) {
            nombresTM.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaTM.setBounds(10, 5, 120, 30);
        add(tituloVistaTM);

        txtDesplegableTM.setBounds(200, 120, 200, 20);
        add(txtDesplegableTM);

        nombresTM.setBounds(400, 120, 200, 20);
        add(nombresTM);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTM.setBounds(200, 180, 200, 20);
        add(txtNombreTM);

        // Área texto Nombre
        areanomTM.setEditable(false);
        areanomTM.setBounds(400,180, 200,20);
        add(areanomTM);

        txtContenidoTM.setBounds(200, 220, 200, 20);
        add(txtContenidoTM);

        JScrollPane scrollPane = new JScrollPane(areacontenidoTM); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 220, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        // Botón modificar alfabetos
        bModificarTeclado.setBounds(700, 420, 200, 20);
        add(bModificarTeclado);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresTM.getSelectedItem();
                ArrayList<String> textos = CtrlPresentacion.consultarCjtTextosAsociacion(selectedName);
                if (selectedName != null && !selectedName.isEmpty()) {
                    areanomTM.setText(selectedName);
                    StringBuilder contenidoStr = new StringBuilder();
                    for (String texto : textos) {
                        contenidoStr.append(texto).append("\n");
                    }
                    areacontenidoTM.setText(contenidoStr.toString());
                } else {
                    areanomTM.setText("");
                    areacontenidoTM.setText("");
                }
            }
        };

        ActionListener lModificarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAsoc = areanomTM.getText().trim();
                String contenidoStr = areacontenidoTM.getText();

                // Comprobar si se ha seleccionado un alfabeto
                if (nombreAsoc.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaTecladoM.this, "No hay ninguna asociación seleccionado.",
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
                    JOptionPane.showMessageDialog(VistaTecladoM.this, "No se han realizado cambios en el contenido.",
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
                JOptionPane.showMessageDialog(VistaTecladoM.this, "Asociación modificada con éxito.",
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

        nombresTM.addActionListener(lElementoSeleccionado);
        bModificarTeclado.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }
}
