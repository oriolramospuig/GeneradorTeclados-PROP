package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaAsociacionTextosA extends JFrame {

    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaATA = new JLabel("Agregar asociación de textos");
    /** Botón para agregar un alfabeto */
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

    private JPopupMenu popupMenuATA = new JPopupMenu();
    private JButton showPopupButtonATA = new JButton("Mostrar Menú Emergente");

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
        areanomATA.setBounds(250,35, 200,20);
        add(areanomATA);

        // Texto núm. textos
        txtNumTextosATA.setBounds(50, 75, 200, 20);
        add(txtNumTextosATA);

        // Área texto núm. textos
        areaNumTextosATA.setBounds(250,75, 200,20);
        add(areaNumTextosATA);

        // Texto textos a agregar
        txtTextosAgregarATA.setBounds(50, 115, 200, 20);
        add(txtTextosAgregarATA);

        // Área textos a agregar
        areaTextosAgregarATA.setBounds(250,115, 200,60);
        add(areaTextosAgregarATA);

        // Botón agregar Alfabeto
        bAgregarAsociacion.setBounds(700, 250, 250, 20);
        add(bAgregarAsociacion);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dynamic Popup Menu Example");
            //JButton showPopupButton = new JButton("Mostrar Menú Emergente");
            ActionListener lPopup = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Crear el menú emergente
                    //JPopupMenu popupMenu = createPopupMenu();

                    // Obtener la posición del botón y mostrar el menú emergente
                    int x = showPopupButtonATA.getX();
                    int y = showPopupButtonATA.getY() + showPopupButtonATA.getHeight();
                    //popupMenu.show(showPopupButton, x, y);
                }
            };

            frame.getContentPane().add(showPopupButtonATA);
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        // Método para crear el menú emergente con elementos dinámicos
        /*private static JPopupMenu createPopupMenu() {
            JPopupMenu popupMenu = new JPopupMenu();
            //Pedir a ctrlPresentacion la lista de nombres de los textos existentes
            ArrayList<String> nombresTextos = CtrlPresentacion.getNombresTextos();

            // Agregar elementos al menú emergente
            for (int i = 0; i < nombresTextos.size(); ++i) {
                JMenuItem menuItem = new JMenuItem(nombresTextos.get(i));
                menuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JMenuItem source = (JMenuItem) e.getSource();
                        JOptionPane.showMessageDialog(null, "Seleccionaste: " + source.getText());
                    }
                });
                popupMenu.add(menuItem);
            }
            return popupMenu;
        };*/
        //showPopupButton.lPopup();


        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areanomATA.getText().isEmpty()){
                    JDialog sinNombre =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre.setBounds(800, 300, 400, 200);
                    sinNombre.setLayout(null);

                    JLabel txtErrorNombre = new JLabel("Hay que agregar la asociación con un nombre nuevo");
                    txtErrorNombre.setBounds(80, 20, 400, 40);
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

                } else if (areaNumTextosATA.getText().isEmpty()){
                    JDialog sinNumTextos =  new JDialog(CPframe, "Error: No núm textos");
                    sinNumTextos.setBounds(450, 300, 700, 200);
                    sinNumTextos.setLayout(null);

                    JLabel txtErrorSinNum = new JLabel("Hay que entrar un número de textos que se querrán agregar a la asociación");
                    txtErrorSinNum.setBounds(20, 20, 700, 40);
                    JButton bSalirErrorNumTextos = new JButton("Salir");
                    bSalirErrorNumTextos.setVisible(true);
                    bSalirErrorNumTextos.setBounds(150, 110, 100, 30);
                    sinNumTextos.add(txtErrorSinNum);
                    sinNumTextos.add(bSalirErrorNumTextos);
                    sinNumTextos.setVisible(true);

                    ActionListener lSalirErrorConPath = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            sinNumTextos.dispose();
                            sinNumTextos.setVisible(false);
                        }
                    };
                    bSalirErrorNumTextos.addActionListener(lSalirErrorConPath);
                }else if(areaTextosAgregarATA.getText().isEmpty() ){
                    //&& areaNumTextos.getText() != '0'

                    if(areaTextosAgregarATA.getText().isEmpty()) {
                        //CtrlPresentacion.agregarTexto(areanomA1.getText(), areaContenido.getText());
                        setVisible(false);
                    }
                }else {//se han llenado todos los campos
                    /*JButton bSalir1 = new JButton("Salir");
                    boolean agregado = CtrlPresentacion.agregarAsociacion(areanomATA.getText(), areaContenido.getText());
                    if (!agregado) {
                        JDialog textoNoAgregado = new JDialog(frame, "Asociacion no agregada");
                        textoNoAgregado.setBounds(800, 300, 400, 200);
                        textoNoAgregado.setLayout(null);

                        JLabel ltextoNoAgregado = new JLabel("Ya existe una asociacion con el nombre " + areanomATA.getText() + " debe cambiar el nombre.");
                        ltextoNoAgregado.setBounds(80, 20, 400, 40);
                        bSalir1.setVisible(true);
                        bSalir1.setBounds(150, 110, 100, 30);
                        textoNoAgregado.add(ltextoNoAgregado);
                        textoNoAgregado.add(bSalir1);
                        textoNoAgregado.setVisible(true);

                        ActionListener lSortirTextoNoAgregado = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                textoNoAgregado.dispose();
                                textoNoAgregado.setVisible(false);
                            }
                        };
                        bSalir1.addActionListener(lSortirTextoNoAgregado);
                    }else {
                        //POSAR EN BLANC ELS REQUADRES DE TEXT
                    }*/
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

        showPopupButtonATA.addActionListener(e -> popupMenuATA.show(showPopupButtonATA, 0, showPopupButtonATA.getHeight()));


        bAgregarAsociacion.addActionListener(lAgregar);
        bsalir.addActionListener(lSalir);
    }
}

