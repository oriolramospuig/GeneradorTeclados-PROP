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
 * Vista para modificar los textos vinculados a una asociación existente.
 * <p>
 * Esta vista ofrece al usuario una lista desplegable para seleccionar una asociación existente y modificar su contenido.
 * Al seleccionar una asociación de la lista, se muestra su nombre y su contenido en campos de texto.
 * También se proporcionan dos deplegables, uno para agregar nuevos textos a la asociación y otro para borrar textos vinculados a ella.
 * El primer desplegable contiene los textos posibles a vincular a la asociación y otro los textos vinculados.
 * El nombre de la asociación, siendo el identificador, no es modificable.
 * La interfaz proporciona una manera sencilla y directa para que los usuarios puedan actualizar la lista de textos que componen una asociación específica.
 * Incluye un botón para confirmar las modificaciones y otro para regresar al menú principal.
 * @author Alèxia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class VistaAsociacionTextosM extends JFrame{
    /** Panel donde se incluyen los elementos de la ventana. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana. */
    private final JLabel tituloVistaATM = new JLabel("Modificar asociación");

    /** Texto indicando que la barra de texto de al lado es para seleccionar el nombre de la asociación. */
    private final JLabel txtDesplegableATM = new JLabel("LISTA NOMBRES:");

    /** Desplegable con los nombres de las asociaciones existentes. */
    private JComboBox<String> nombresATM = new JComboBox<>();

    /** Texto indicando que la barra de texto de al lado es para seleccionar el nombre del texto a agregar a la asociación. */
    private final JLabel txtDesplegableAgregarATM = new JLabel("NOMBRES DE TEXTOS PARA AGREGAR A LA ASOCIACIÓN:");

    /** Desplegable con los nombres de los textos que no pertenecen a esa asociación, pero que pueden ser agregados a ella. */
    private JComboBox<String> nombreAgregarATM = new JComboBox<>();

    /** Texto indicando que la barra de texto de al lado es para seleccionar el nombre del texto a borrar de la asociación. */
    private final JLabel txtDesplegableBorrarATM = new JLabel("NOMBRES DE TEXTOS PARA BORRAR DE LA ASOCIACIÓN:");

    /** Desplegable con los nombres de los textos que pertenecen a esa asociación y por lo tanto, pueden ser borrados de esta. */
    private JComboBox<String> nombreBorrarATM = new JComboBox<>();

    /** Botón para realizar las modificaciones en la asociación seleccionada. */
    private final JButton bModificarAsociacion = new JButton("Modificar asociación");

    /** Botón para volver a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    /** Texto indicando que la barra de texto de al lado es donde aparecerá el nombre de la asociacion seleccionada para modificar. */
    private final JLabel txtNombreATM = new JLabel("NOMBRE:");

    /** Área de texto donde aparecerá el nombre de la asociacion seleccionada para modificar. */
    private final JTextArea areanomATM = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es donde aparecerá la lista de textos vinculados a la asociacion a modificar. */
    private final JLabel txtContenidoATM = new JLabel("CONTENIDO:");

    /** Área de texto donde aparecerá la lista de textos vinculados a la asociación que se quiere modificar. */
    private final JTextArea areacontenidoATM = new JTextArea();

    /** Área de texto donde aparecerá el nombre del texto seleccionado en el desplegable que corresponde. Es un texto no vinculado, que se quiere vincular a esa asociación. */
    private final JTextArea areanomAgregarATM = new JTextArea();

    /** Área de texto donde aparecerá el nombre del texto vinculado que se quiere desvincular de la asociación. */
    private final JTextArea areanomBorrarATM = new JTextArea();

    /**
     * Constructor de la clase VistaAsociaciónM.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para la modificación de asociaciones de texto. Permite actualizar el contenido de una asociación seleccionada
     * desde una lista desplegable, manteniendo el mismo nombre identificador.
     */
    public VistaAsociacionTextosM() {
        setBounds(250, 150, 1000, 600);

        ArrayList<String> nombres = CtrlPresentacion.getNombresAsociaciones();
        nombresATM = new JComboBox<>();
        nombresATM.addItem("");
        for (String nombre : nombres) {
            nombresATM.addItem(nombre);
        }

        nombreAgregarATM = new JComboBox<>();
        nombreBorrarATM = new JComboBox<>();

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
                if (selectedName != null && !selectedName.isEmpty()) {
                    ArrayList<String> textos = CtrlPresentacion.consultarCjtTextosAsociacion(selectedName);
                    areanomATM.setText(selectedName);
                    StringBuilder contenidoStr = new StringBuilder();
                    for (String texto : textos) {
                        contenidoStr.append(texto).append("\n");
                    }
                    areacontenidoATM.setText(contenidoStr.toString());

                    nombreBorrarATM.removeAllItems();
                    nombreBorrarATM.addItem("");
                    for (String nombre : textos) {
                        nombreBorrarATM.addItem(nombre);
                    }

                    ArrayList<String> nombresTextosAgregar = CtrlPresentacion.getNombresTextos();
                    nombreAgregarATM.removeAllItems();
                    nombreAgregarATM.addItem("");
                    for (String nombre : nombresTextosAgregar) {
                        if (!textos.contains(nombre)) nombreAgregarATM.addItem(nombre);
                    }
                } else {
                    areanomATM.setText("");
                    areacontenidoATM.setText("");
                    nombreAgregarATM.removeAllItems();
                    nombreBorrarATM.removeAllItems();
                }
            }
        };

        ActionListener lElementoSeleccionadoA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedNameAgregar = (String) nombreAgregarATM.getSelectedItem();
                if (selectedNameAgregar != null && !selectedNameAgregar.isEmpty()) {
                    areanomAgregarATM.setText(selectedNameAgregar);
                } else {
                    areanomAgregarATM.setText("");
                }
            }
        };

        ActionListener lElementoSeleccionadoB = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedNameBorrar = (String) nombreBorrarATM.getSelectedItem();
                if (selectedNameBorrar != null && !selectedNameBorrar.isEmpty()) {
                    areanomBorrarATM.setText(selectedNameBorrar);
                } else {
                    areanomBorrarATM.setText("");
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
                    int opcion = JOptionPane.showConfirmDialog(null, "Si modifica esta asociación, se modificarán todos los teclados creados a partir de esta asociación.\n¿Está seguro de que desea continuar?", "Aviso", JOptionPane.YES_NO_OPTION);

                    // Verificar la respuesta del usuario
                    if (opcion == JOptionPane.YES_OPTION) { // El usuario eligió continuar
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
                    } else {
                        // El usuario eligió no continuar
                        areanomATM.setText("");
                        areacontenidoATM.setText("");
                        areanomAgregarATM.setText("");
                        areanomBorrarATM.setText("");
                    }
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
