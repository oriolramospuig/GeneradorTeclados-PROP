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
    /** Botón para agregar un texto */
    private final JButton bAgregarTexto = new JButton("Agregar texto");
    /** Botón para agregar una asociación */
    private final JButton bAgregarAsociacion = new JButton("Agregar asociación de textos");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");

    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación */
    private final JLabel txtNombreATA = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociación que se quiere crear */
    private final JTextArea areanomATA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el número de textos que quiere agregar a la asociación */
    private final JLabel txtNumTextosATA = new JLabel("NÚM DE TEXTOS A AÑADIR:");
    /** Área de texto para introducir el número de textos que quiere añadir a la asociación */
    private final JTextArea areaNumTextosATA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido de la asociación */
    private final JLabel txtTextosAgregarATA = new JLabel("TEXTOS A AGREGAR:");
    /** Área de texto para introducir el contenido de la asociación que se quiere crear */
    private final JTextArea areaTextosAgregarATA = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear una asociación sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear una asociación sin textos o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");
    /** Pantalla de error asociacion no agregada */
    private JFrame frame = new JFrame();

    public VistaAsociacionTextosA() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);

        // Título ventana superior
        tituloVistaATA.setBounds(10, 5, 200, 30);
        add(tituloVistaATA);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreATA.setBounds(50, 35, 200, 20);
        add(txtNombreATA);

        // Área texto Nombre
        areanomATA.setBounds(250, 35, 200, 20);
        add(areanomATA);

        // Texto textos a agregar
        txtTextosAgregarATA.setBounds(50, 115, 200, 20);
        add(txtTextosAgregarATA);

        // Área textos a agregar
        areaTextosAgregarATA.setBounds(250,115, 200,60);
        add(areaTextosAgregarATA);

        // Botón agregar Texto
        bAgregarTexto.setBounds(700, 250, 250, 20);
        add(bAgregarTexto);

        // Botón agregar Asociación
        bAgregarAsociacion.setBounds(700, 50, 250, 20);
        add(bAgregarAsociacion);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areanomATA.getText().isEmpty()){
                    JDialog sinNombre =  new JDialog(Nomframe, "Error: No Nombre");
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

                } else{
                    boolean agregada = CtrlPresentacion.agregarAsociacionNombre(areanomATA.getText());
                    JOptionPane.showMessageDialog(VistaAsociacionTextosA.this, "Agregada con éxito! Ya puede añadir textos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        };

        ActionListener lSeleccionarTexto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areanomATA.getText().isEmpty()){
                    JDialog sinNombre =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre.setBounds(800, 300, 400, 200);
                    sinNombre.setLayout(null);

                    JLabel txtErrorNombre = new JLabel("No hay nombre de asociación donde añadir texos");
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
                    chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/subgrup-prop14.3/Entrega1/data/Textos"));
                    int returnValue = chooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File archivo = chooser.getSelectedFile();
                        boolean agregada = CtrlPresentacion.agregarTextoAsociacion(areanomATA.getText(), chooser.getName(archivo));
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

        bAgregarTexto.addActionListener(lSeleccionarTexto);
        bAgregarAsociacion.addActionListener(lAgregar);
        bsalir.addActionListener(lSalir);


    }

}


