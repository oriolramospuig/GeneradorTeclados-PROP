package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;


public class VistaAsociacionTextosA extends JFrame {
    /** Finestra de selecció de l'arxiu que es vol carregar al nostre full de càlcul */
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaATA = new JLabel("Agregar asociación de textos");
    /** Botón para agregar una asociación */
    private final JButton bAgregarAsociacion = new JButton("Agregar asociación");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");

    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación */
    private final JLabel txtNombreATA = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociación que se quiere crear */
    private final JTextArea areanomATA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido de la asociación */
    private final JLabel txtTextosAgregarATA = new JLabel("POSIBLES TEXTOS A AGREGAR:");
    /** Área de texto donde se introducirá el nombre del texto que se haya seleccionado de la lista de textos */
    private final JTextArea areaTextosAgregarATA = new JTextArea();
    /** Desplegable con los nombres de los textos creados en el sistema */
    private JComboBox<String> nombresTxt = new JComboBox<>();
    /** Texto indicando que la barra de texto de al lado es para mostrar la lista de textos que contiene esa asociación */
    private final JLabel txtTextosAgregadosATA = new JLabel("LISTA TEXTOS SELECCIONADOS:");
    /** Desplegable con los nombres de los textos agregados a esa asociación*/
    private JComboBox<String> nombresTxtagregados = new JComboBox<>();

    //MENSAJES DE ERROR
    /** Pantalla de error */
    private final JFrame frame = new JFrame ("JFrame");


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
        ActionListener lElementoSeleccionadoListosAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*String selectedName = (String) nombresTxt.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    areaTextosAgregarATA.setText(selectedName);
                } else {
                    areaTextosAgregarATA.setText("");  // Limpiar el área de texto si se selecciona el elemento vacío
                }*/
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
                    if(agregada) JOptionPane.showMessageDialog(VistaAsociacionTextosA.this, "Agregada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    else JOptionPane.showMessageDialog(VistaAsociacionTextosA.this, "No Agregada, el nombre " + areanomATA.getText() + " ya existe.", "Error", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        };


        ActionListener lSeleccionarTexto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areanomATA.getText().isEmpty()){
                    JDialog sinNombre =  new JDialog(frame, "Error: No Nombre");
                    sinNombre.setBounds(800, 300, 400, 200);
                    sinNombre.setLayout(null);

                    JLabel txtErrorNombre = new JLabel("No hay nombre de asociación donde añadir texto");
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

                } else {
                    chooser.setDialogTitle("Selecciona fichero texto a agregar");
                    chooser.setFileFilter(new FileNameExtensionFilter("PROP", "csv", "prop", "txt"));
                    /*Revisar el tema del path, depende de cómo se ejecute no hará falta subgrup-prop14.3*/
                    chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/Entrega1/data/Textos"));
                    int returnValue = chooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File archivo = chooser.getSelectedFile();
                        CtrlPresentacion.agregarTextoAsociacion(areanomATA.getText(), chooser.getName(archivo));
                        JOptionPane.showMessageDialog(VistaAsociacionTextosA.this, "Agregada con éxito! Ya puede añadir textos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } //else if (returnValue == JFileChooser.CANCEL_OPTION)
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
        nombresTxtagregados.addActionListener(lElementoSeleccionadoListosAgregar);
        bAgregarAsociacion.addActionListener(lAgregar);

        bsalir.addActionListener(lSalir);


    }

}


