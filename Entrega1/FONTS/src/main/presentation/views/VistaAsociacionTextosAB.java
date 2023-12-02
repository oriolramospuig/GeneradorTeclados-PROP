package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAsociacionTextosAB extends JFrame {

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
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido de la asociación */
    private final JLabel txtContenido = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido de la asociación que se quiere crear */
    private final JTextArea areaContenido = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path de la asociación, para saber donde esta guardado */
    private final JLabel txtPath = new JLabel("PATH:");
    /** Área de texto para introducir el path de la asociación que se quiere crear */
    private final JTextArea areaPath = new JTextArea();

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


    public VistaAsociacionTextosAB() {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);

        // Título ventana superior
        tituloVistaAT1.setBounds(10, 5, 120, 30);
        add(tituloVistaAT1);

        // Título ventana inferior
        tituloVistaAT2.setBounds(10, 305, 120, 30);
        add(tituloVistaAT2);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombre1.setBounds(50, 35, 200, 20);
        add(txtNombre1);

        // Área texto Nombre
        areanomAT1.setBounds(250,35, 200,20);
        add(areanomAT1);

        // Texto Contenido
        txtContenido.setBounds(50, 75, 200, 20);
        add(txtContenido);

        // Área texto Contenido
        areaContenido.setBounds(250,75, 200,60);
        add(areaContenido);

        // Texto Path
        txtPath.setBounds(50, 175, 200, 20);
        add(txtPath);

        // Área texto Path
        areaPath.setBounds(250,175, 200,20);
        add(areaPath);

        //VENTANA INFERIOR
        // Texto Nombre
        txtNombre2.setBounds(50, 335, 200, 20);
        add(txtNombre2);

        // Área texto Nombre
        areanomAT2.setBounds(250,335, 200,20);
        add(areanomAT2);

        //
        // Botón agregar Alfabeto
        bAgregarAsociacion.setBounds(700, 250, 200, 20);
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

                } else if (areaContenido.getText().isEmpty() && areaPath.getText().isEmpty()){
                    JDialog sinConPath =  new JDialog(CPframe, "Error: No Contenido o No Path");
                    sinConPath.setBounds(450, 300, 700, 200);
                    sinConPath.setLayout(null);

                    JLabel txtErrorConPath = new JLabel("Hay que añadir un contenido de la asociación a mano o entrar un path donde se encuentra el archivo de la asociación");
                    txtErrorConPath.setBounds(20, 20, 700, 40);
                    JButton bSalirErrorConPath = new JButton("Salir");
                    bSalirErrorConPath.setVisible(true);
                    bSalirErrorConPath.setBounds(150, 110, 100, 30);
                    sinConPath.add(txtErrorConPath);
                    sinConPath.add(bSalirErrorConPath);
                    sinConPath.setVisible(true);

                    ActionListener lSalirErrorConPath = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            sinConPath.dispose();
                            sinConPath.setVisible(false);
                        }
                    };
                    bSalirErrorConPath.addActionListener(lSalirErrorConPath);
                }else { //se han llenado todos los campos
                    if(areaContenido.getText().isEmpty()){
                        // fer lo del path areaPath.getText();
                    }
                    else if(areaPath.getText().isEmpty()) {
                        //CtrlPresentacion.agregarAlfabeto(areanomA1.getText(), areaContenido.getText());
                        setVisible(false);
                    }
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

        bAgregarAsociacion.addActionListener(lAgregar);
        bBorrarAsociacion.addActionListener(lBorrar);
        bsalir.addActionListener(lSalir);

    }
}
