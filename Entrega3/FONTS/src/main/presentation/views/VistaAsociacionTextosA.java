package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Vista para agregar una nueva asociación.
 * <p>
 * Esta vista permite al usuario agregar una nueva asociación al sistema, especificando su nombre y la lista de textos a vincular.
 * El usuario puede seleccionar de la lista de textos existentes, aquellos que quiera añadir a la asociación que está creando.
 * La vista incluye validaciones para asegurar que el nombre de la asociación sea única y que se haya proporcionado algún texto a añadir.
 * Incluye botones para agregar la asociación y volver al menú principal.
 * @author Alèxia Mayor (alexia.mayor@estudiantat.upc.edu)
 */

public class VistaAsociacionTextosA extends JFrame {
    /** Pantalla de error para mostrar mensajes cuando falta información. */
    private final JFrame frame = new JFrame ("JFrame");

    /** Panel donde se incluyen los elementos de la ventana. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana. */
    private final JLabel tituloVistaATA = new JLabel("Agregar asociación de textos");

    /** Botón para agregar una asociación. */
    private final JButton bAgregarAsociacion = new JButton("Agregar asociación");

    /** Botón para volver a la pantalla del menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación. */
    private final JLabel txtNombreATA = new JLabel("NOMBRE:");

    /** Área de texto para introducir el nombre de la asociación que se quiere crear. */
    private final JTextArea areanomATA = new JTextArea();

    /** Texto indicando que el desplegable de al lado es donde se muestran los posibles textos a vincular a esa asociación. */
    private final JLabel txtTextosAgregarATA = new JLabel("POSIBLES TEXTOS A AGREGAR:");

    /** Área de texto donde se introducirá automáticamente el nombre del texto que se haya seleccionado de la lista de textos. */
    private final JTextArea areaTextosAgregarATA = new JTextArea();

    /** Desplegable con los nombres de los posibles textos a agregar a esa asociación. */
    private JComboBox<String> nombresTxt = new JComboBox<>();

    /** Texto indicando que el desplegable de al lado es para mostrar la lista de textos seleccionados para agregar a esa asociación. */
    private final JLabel txtTextosAgregadosATA = new JLabel("LISTA TEXTOS SELECCIONADOS:");

    /** Desplegable con los nombres de los textos seleccionados para agregar a esa asociación. */
    private JComboBox<String> nombresTxtagregados = new JComboBox<>();


    /**
     * Constructor de la clase VistaAsociacionA.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para la adición de una nueva asociación y la selección de los textos vinculados a ella.
     */
    public VistaAsociacionTextosA() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);
        ArrayList<String> nombres = CtrlPresentacion.getNombresTextos();
        nombresTxt = new JComboBox<>();
        nombresTxt.addItem("");
        for (String nombre : nombres) {
            nombresTxt.addItem(nombre);
        }
        nombresTxtagregados = new JComboBox<>();

        // Título ventana superior
        tituloVistaATA.setBounds(10, 5, 200, 30);
        add(tituloVistaATA);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreATA.setBounds(150, 140, 200, 20);
        add(txtNombreATA);

        // Área texto Nombre
        areanomATA.setBounds(400, 140, 200, 20);
        add(areanomATA);

        // Texto textos a agregar
        txtTextosAgregarATA.setBounds(150, 220, 200, 20);
        add(txtTextosAgregarATA);

        // Área de desplegable de textos a agregar
        nombresTxt.setBounds(400, 220, 200, 20);
        add(nombresTxt);

        // Área de desplegable de textos a agregar
        areaTextosAgregarATA.setBounds(700, 220, 200, 20);
        add(areaTextosAgregarATA);

        // Texto textos a agregar
        txtTextosAgregadosATA.setBounds(150, 300, 200, 20);
        add(txtTextosAgregadosATA);

        // Área de desplegable de textos a agregar
        nombresTxtagregados.setBounds(400, 300, 200, 20);
        add(nombresTxtagregados);

        // Botón agregar Asociación
        bAgregarAsociacion.setBounds(620, 400, 300, 20);
        add(bAgregarAsociacion);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresTxt.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    areaTextosAgregarATA.setText(selectedName);
                    nombresTxtagregados.addItem(selectedName);
                } else {
                    areaTextosAgregarATA.setText("");  // Limpiar el área de texto si se selecciona el elemento vacío
                }
            }
        };

        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areanomATA.getText().isEmpty()) {
                    JDialog sinNombre = new JDialog(frame, "Error: No Nombre");
                    sinNombre.setBounds(800, 300, 400, 200);
                    sinNombre.setLayout(null);

                    JLabel txtErrorNombre = new JLabel("Hay que agregar la asociación con un nombre nuevo");
                    txtErrorNombre.setBounds(40, 20, 400, 40);
                    JButton bSalirErrorNombre = new JButton("Salir");
                    bSalirErrorNombre.setVisible(true);
                    bSalirErrorNombre.setBounds(150, 110, 100, 30);
                    sinNombre.add(txtErrorNombre);
                    sinNombre.add(bSalirErrorNombre);
                    sinNombre.setVisible(true);

                    ActionListener lSalirErrorNombre = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            sinNombre.dispose();
                            sinNombre.setVisible(false);
                        }
                    };
                    bSalirErrorNombre.addActionListener(lSalirErrorNombre);

                } else if(nombresTxtagregados.getItemCount() == 0){
                    JDialog sinTexto = new JDialog(frame, "Error: No Texto a Agregar");
                    sinTexto.setBounds(700, 300, 500, 200);
                    sinTexto.setLayout(null);

                    JLabel txtErrorTexto = new JLabel("Hay que seleccionar un texto de la lista de posibles textos a agregar");
                    txtErrorTexto.setBounds(40, 20, 400, 40);
                    JButton bSalirErrorTexto = new JButton("Salir");
                    bSalirErrorTexto.setVisible(true);
                    bSalirErrorTexto.setBounds(150, 110, 100, 30);
                    sinTexto.add(txtErrorTexto);
                    sinTexto.add(bSalirErrorTexto);
                    sinTexto.setVisible(true);

                    ActionListener lSalirErrorTexto = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            sinTexto.dispose();
                            sinTexto.setVisible(false);
                        }
                    };
                    bSalirErrorTexto.addActionListener(lSalirErrorTexto);


                }else{
                    ArrayList<String> nombresTextosAgregar = new ArrayList<>();
                    for(int i = 0; i < nombresTxtagregados.getItemCount(); ++i){
                        String elemento = (String) nombresTxtagregados.getItemAt(i);
                        nombresTextosAgregar.add(elemento);
                    }
                    boolean agregada = CtrlPresentacion.agregarAsociacion(areanomATA.getText(),nombresTextosAgregar);
                    if(agregada) {
                        JOptionPane.showMessageDialog(VistaAsociacionTextosA.this, "Agregada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        CtrlPresentacion.guardaAsociaciones();
                    }
                    else JOptionPane.showMessageDialog(VistaAsociacionTextosA.this, "No Agregada, el nombre " + areanomATA.getText() + " ya existe.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    areanomATA.setText("");
                    nombresTxt.setSelectedItem("");
                    nombresTxtagregados.removeAllItems();

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

        nombresTxt.addActionListener(lElementoSeleccionado);
        bAgregarAsociacion.addActionListener(lAgregar);

        bsalir.addActionListener(lSalir);


    }

}


