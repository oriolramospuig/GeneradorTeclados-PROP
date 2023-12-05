package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaAlfabetoA extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana */
    private final JLabel tituloVistaA = new JLabel("Agregar alfabeto");
    /** Botón para agregar un alfabeto */
    private final JButton bAgregarAlfabeto = new JButton("Agregar Alfabeto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto */
    private final JLabel txtNombre = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere crear */
    private final JTextArea areanomA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del alfabeto */
    private final JLabel txtContenido = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del alfabeto que se quiere crear */
    private final JTextArea areaContenido = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del alfabeto, para saber donde esta guardado */
    private final JLabel txtPath = new JLabel("PATH:");
    /** Área de texto para introducir el path del alfabeto que se quiere crear */
    private final JTextArea areaPath = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear un alfabeto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear un alfabeto sin contenido o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");


    public VistaAlfabetoA(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);

        // Título ventana superior
        tituloVistaA.setBounds(10, 5, 120, 30);
        add(tituloVistaA);


        // Texto Nombre
        txtNombre.setBounds(50, 35, 200, 20);
        add(txtNombre);

        // Área texto Nombre
        areanomA.setBounds(250,35, 200,20);
        add(areanomA);

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

        //BOTONES
        // Botón agregar Alfabeto
        bAgregarAlfabeto.setBounds(700, 250, 200, 20);
        add(bAgregarAlfabeto);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areanomA.getText().isEmpty()){
                    JDialog sinNombre =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre.setBounds(800, 300, 400, 200);
                    sinNombre.setLayout(null);

                    JLabel txtErrorNombre = new JLabel("Hay que agregar el alfabeto con un nombre nuevo");
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

                    JLabel txtErrorConPath = new JLabel("Hay que añadir un contenido del alfabeto a mano o entrar un path donde se encuentra el archivo del alfabeto");
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

        ActionListener lSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        bAgregarAlfabeto.addActionListener(lAgregar);
        bsalir.addActionListener(lSalir);

    }

}
