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
    private final JLabel txtDesplegableAgregarATM = new JLabel("NOMBRES DE TEXTOS PARA AGREGAR A LA ASOCIACIÓN:");
    private JComboBox<String> nombreAgregarATM = new JComboBox<>();
    private final JLabel txtDesplegableBorrarATM = new JLabel("NOMBRES DE TEXTOS PARA BORRAR DE LA ASOCIACIÓN:");
    private JComboBox<String> nombreBorrarATM = new JComboBox<>();
    private final JButton bModificarAsociacion = new JButton("Modificar asociación");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtNombreATM = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areanomATM = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociacion a consultar*/
    private final JLabel txtContenidoATM = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre de la asociacion que se quiere consultar */
    private final JTextArea areacontenidoATM = new JTextArea();
    private final JTextArea areanomAgregarATM = new JTextArea();
    private final JTextArea areanomBorrarATM = new JTextArea();

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

        // Título ventana
        tituloVistaATM.setBounds(10, 5, 120, 30);
        add(tituloVistaATM);

        txtDesplegableATM.setBounds(100, 80, 200, 20);
        add(txtDesplegableATM);

        nombresATM.setBounds(300, 80, 200, 20);
        add(nombresATM);

        // Texto Nombre
        txtNombreATM.setBounds(100, 140, 200, 20);
        add(txtNombreATM);

        // Área texto Nombre
        areanomATM.setEditable(false);
        areanomATM.setBounds(300,140, 200,20);
        add(areanomATM);

        txtContenidoATM.setBounds(100, 200, 200, 20);
        add(txtContenidoATM);

        JScrollPane scrollPane = new JScrollPane(areacontenidoATM); // Para agregar scroll al área de texto
        scrollPane.setBounds(300, 200, 200, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        txtDesplegableAgregarATM.setBounds(600, 80, 400, 20);
        add(txtDesplegableAgregarATM);

        nombreAgregarATM.setBounds(600, 120, 200, 20);
        add(nombreAgregarATM);

        areanomAgregarATM.setBounds(600,180, 200,20);
        add(areanomAgregarATM);

        txtDesplegableBorrarATM.setBounds(600, 240, 400, 20);
        add(txtDesplegableBorrarATM);

        nombreBorrarATM.setBounds(600, 280, 200, 20);
        add(nombreBorrarATM);

        areanomBorrarATM.setBounds(600,320, 200,20);
        add(areanomBorrarATM);

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
                ArrayList<String> nombresTextosBorrar = CtrlPresentacion.consultarCjtTextosAsociacion(selectedName);
                nombreBorrarATM = new JComboBox<>();
                nombreBorrarATM.addItem("");
                for (String nombre : nombresTextosBorrar) {
                    nombreBorrarATM.addItem(nombre);
                }
                ArrayList<String> nombresTextosAgregar = CtrlPresentacion.getNombresTextos();
                nombreAgregarATM = new JComboBox<>();
                nombreAgregarATM.addItem("");
                for (String nombre : nombresTextosAgregar) {
                    nombreAgregarATM.addItem(nombre);
                }
            }
        };
        ActionListener lElementoSeleccionadoA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedNameAgregar = (String) nombreAgregarATM.getSelectedItem();
                if (selectedNameAgregar != null && !selectedNameAgregar.isEmpty()) {
                    areanomAgregarATM.setText(selectedNameAgregar);
                }
            }
        };
        ActionListener lElementoSeleccionadoB = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedNameBorrar = (String) nombreBorrarATM.getSelectedItem();
                if (selectedNameBorrar != null && !selectedNameBorrar.isEmpty()) {
                    areanomAgregarATM.setText(selectedNameBorrar);
                }
            }
        };

        ActionListener lModificarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAsoc = areanomATM.getText().trim();
                String contenidoStr = areacontenidoATM.getText();
                String nombreTextoAgregar = areanomAgregarATM.getText().trim();
                String nombreTextoBorrar = areanomBorrarATM.getText().trim();

                // Comprobar si se ha seleccionado un alfabeto
                if (nombreAsoc.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaAsociacionTextosM.this, "No hay ninguna asociación seleccionada.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                } else if(nombreTextoAgregar.isEmpty() && nombreTextoBorrar.isEmpty()){
                    JOptionPane.showMessageDialog(VistaAsociacionTextosM.this, "No hay ningún texto a agregar o a borrar.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                } else {
                    if (!nombreTextoAgregar.isEmpty()) { // se quiere agregar un texto
                        CtrlPresentacion.agregarTextoAsociacion(nombreAsoc,nombreTextoAgregar);
                    }
                    if(!nombreTextoBorrar.isEmpty()){ // se quiere borrar un texto
                        CtrlPresentacion.borrarTextoAsociacion(nombreAsoc,nombreTextoBorrar);
                    }
                    JOptionPane.showMessageDialog(VistaAsociacionTextosM.this, "Asociación modificada con éxito.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    CtrlPresentacion.guardaAsociaciones();
                    areanomATM.setText("");
                    areacontenidoATM.setText("");
                    areanomAgregarATM.setText("");
                    areanomBorrarATM.setText("");
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

        nombresATM.addActionListener(lElementoSeleccionado);
        nombreAgregarATM.addActionListener(lElementoSeleccionadoA);
        nombreBorrarATM.addActionListener(lElementoSeleccionadoB);
        bModificarAsociacion.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }
}
