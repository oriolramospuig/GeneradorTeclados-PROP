package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaAsociacionTextosB extends JFrame {

    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaAT1 = new JLabel("Agregar asociación de textos");
    /** Título de media ventana inferior */
    private final JLabel tituloVistaAT2 = new JLabel("Borrar asociación de textos");
    /** Botón para agregar un alfabeto */
    private final JButton bAgregarAsociacion = new JButton("Agregar asociación de textos");
    /** Botón para borrar un alfabeto */
    private final JButton bBorrarAsociacion = new JButton("Borrar asociación de textos");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");

    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación */
    private final JLabel txtNombre1 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociación que se quiere crear */
    private final JTextArea areanomAT1 = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el número de textos que quiere agregar a la asociación */
    private final JLabel txtNumTextos = new JLabel("NÚM DE TEXTOS A AÑADIR:");
    /** Área de texto para introducir el número de textos que quiere añadir a la asociación */
    private final JTextArea areaNumTextos = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido de la asociación */
    private final JLabel txtTextosAgregar = new JLabel("TEXTOS A AGREGAR:");
    /** Área de texto para introducir el contenido de la asociación que se quiere crear */
    private final JTextArea areaTextosAgregar = new JTextArea();

    private JPopupMenu popupMenuA = new JPopupMenu();
    private JButton showPopupButton = new JButton("Mostrar Menú Emergente");



    //VENTANA INFERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación */
    private final JLabel txtNombre2 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociación que se quiere crear */
    private final JTextArea areanomAT2 = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear una asociación sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear una asociación sin textos o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");


    public VistaAsociacionTextosB() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);

        // Título ventana superior
        tituloVistaAT1.setBounds(10, 5, 200, 30);
        add(tituloVistaAT1);

        // Título ventana inferior
        tituloVistaAT2.setBounds(10, 305, 200, 30);
        add(tituloVistaAT2);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombre1.setBounds(50, 35, 200, 20);
        add(txtNombre1);

        // Área texto Nombre
        areanomAT1.setBounds(250,35, 200,20);
        add(areanomAT1);

        // Texto núm. textos
        txtNumTextos.setBounds(50, 75, 200, 20);
        add(txtNumTextos);

        // Área texto núm. textos
        areaNumTextos.setBounds(250,75, 200,20);
        add(areaNumTextos);

        // Texto textos a agregar
        txtTextosAgregar.setBounds(50, 115, 200, 20);
        add(txtTextosAgregar);

        // Área textos a agregar
        areaTextosAgregar.setBounds(250,115, 200,60);
        add(areaTextosAgregar);


        //VENTANA INFERIOR
        // Texto Nombre
        txtNombre2.setBounds(50, 335, 200, 20);
        add(txtNombre2);

        // Área texto Nombre
        areanomAT2.setBounds(250,335, 200,20);
        add(areanomAT2);

        //
        // Botón agregar Alfabeto
        bAgregarAsociacion.setBounds(700, 250, 250, 20);
        add(bAgregarAsociacion);

        // Botón borrar Alfabeto
        bBorrarAsociacion.setBounds(700, 400, 200, 20);
        add(bBorrarAsociacion);

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
                    int x = showPopupButton.getX();
                    int y = showPopupButton.getY() + showPopupButton.getHeight();
                    //popupMenu.show(showPopupButton, x, y);
                }
            };

            frame.getContentPane().add(showPopupButton);
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
                if (areanomAT1.getText().isEmpty()){
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

                } else if (areaNumTextos.getText().isEmpty()){
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
                }else if(areaTextosAgregar.getText().isEmpty() ){
                    //&& areaNumTextos.getText() != '0'

                    if(areaTextosAgregar.getText().isEmpty()) {
                        //CtrlPresentacion.agregarTexto(areanomA1.getText(), areaContenido.getText());
                        setVisible(false);
                    }
                }else {//se han llenado todos los campos

                    //CtrlPresentacion.agregarAsociacion(areanomA1.getText(), areaContenido.getText());
                }

                //if (areaFiles.getText().length() == 0) files = 50;
                //else files = Integer.parseInt(areaFiles.getText());


            }
        };

        ActionListener lBorrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //CtrlPresentacion.getNombresAlfabetos();


                if (areanomAT2.getText().isEmpty()){
                    JDialog sinNombre2 =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre2.setBounds(800, 300, 400, 200);
                    sinNombre2.setLayout(null);

                    JLabel txtErrorNombre2 = new JLabel("Hay que entrar el nombre de una asociación de la lista de asociaciones");
                    txtErrorNombre2.setBounds(10, 20, 400, 40);
                    JButton bSalirErrorNombre2 = new JButton("Salir");
                    bSalirErrorNombre2.setVisible(true);
                    bSalirErrorNombre2.setBounds(150, 110, 100, 30);
                    sinNombre2.add(txtErrorNombre2);
                    sinNombre2.add(bSalirErrorNombre2);
                    sinNombre2.setVisible(true);

                    ActionListener lSalirErrorNombre = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            sinNombre2.dispose();
                            sinNombre2.setVisible(false);
                        }
                    };
                    bSalirErrorNombre2.addActionListener(lSalirErrorNombre);

                }else { //se han llenado todos los campos
                    CtrlPresentacion.borrarAlfabeto(areanomAT2.getText());
                    setVisible(false);
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

        showPopupButton.addActionListener(e -> popupMenuA.show(showPopupButton, 0, showPopupButton.getHeight()));


        bAgregarAsociacion.addActionListener(lAgregar);
        bBorrarAsociacion.addActionListener(lBorrar);
        bsalir.addActionListener(lSalir);

        // return null;
    }
}

