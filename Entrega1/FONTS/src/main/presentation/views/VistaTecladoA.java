package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaTecladoA extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaTA = new JLabel("Agregar teclado");
    /** Botón para agregar un teclado */
    private final JButton bAgregarTeclado = new JButton("Agregar teclado");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del teclado */
    private final JLabel txtNombreTA = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del teclado que se quiere crear */
    private final JTextArea areanomTA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del teclado */
    private final JLabel txtContenidoTA = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del teclado que se quiere crear */
    private final JTextArea areaContenidoTA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del teclado, para saber donde esta guardado */
    private final JLabel txtPathTA = new JLabel("PATH:");
    /** Área de texto para introducir el path del teclado que se quiere crear */
    private final JTextArea areaPathTA = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear un teclado sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear un teclado sin contenido o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");


    public VistaTecladoA(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades teclado);

        // Título ventana superior
        tituloVistaTA.setBounds(10, 5, 120, 30);
        add(tituloVistaTA);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTA.setBounds(50, 35, 200, 20);
        add(txtNombreTA);

        // Área texto Nombre
        areanomTA.setBounds(250,35, 200,20);
        add(areanomTA);

        // Texto Contenido
        txtContenidoTA.setBounds(50, 75, 200, 20);
        add(txtContenidoTA);

        // Área texto Contenido
        areaContenidoTA.setBounds(250,75, 200,60);
        add(areaContenidoTA);

        // Texto Path
        txtPathTA.setBounds(50, 175, 200, 20);
        add(txtPathTA);

        // Área texto Path
        areaPathTA.setBounds(250,175, 200,20);
        add(areaPathTA);

        // Botón agregar teclado
        bAgregarTeclado.setBounds(700, 250, 200, 20);
        add(bAgregarTeclado);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areanomTA.getText().isEmpty()){
                    JDialog sinNombre =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre.setBounds(800, 300, 400, 200);
                    sinNombre.setLayout(null);

                    JLabel txtErrorNombre = new JLabel("Hay que agregar el teclado con un nombre nuevo");
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

                } else if (areaContenidoTA.getText().isEmpty() && areaPathTA.getText().isEmpty()){
                    JDialog sinConPath =  new JDialog(CPframe, "Error: No Contenido o No Path");
                    sinConPath.setBounds(450, 300, 700, 200);
                    sinConPath.setLayout(null);

                    JLabel txtErrorConPath = new JLabel("Hay que añadir un contenido del teclado a mano o entrar un path donde se encuentra el archivo del teclado");
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
                    if(areaContenidoTA.getText().isEmpty()){
                        // fer lo del path areaPath.getText();
                    }
                    else if(areaPathTA.getText().isEmpty()) {
                        //CtrlPresentacion.agregarAlfabeto(areanomA1.getText(), areaContenido.getText());
                        setVisible(false);
                    }
                }

                //if (areaFiles.getText().length() == 0) files = 50;
                //else files = Integer.parseInt(areaFiles.getText());


            }
        };

        ActionListener lSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        bAgregarTeclado.addActionListener(lAgregar);
        bsalir.addActionListener(lSalir);

    }

}
