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
    private final JLabel tituloVistaAA = new JLabel("Agregar alfabeto");
    /** Botón para agregar un alfabeto */
    private final JButton bAgregarAlfabeto = new JButton("Agregar Alfabeto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto */
    private final JLabel txtNombreAA = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere crear */
    private final JTextArea areanomAA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del alfabeto */
    private final JLabel txtContenidoAA = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del alfabeto que se quiere crear */
    private final JTextArea areaContenidoAA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del alfabeto, para saber donde esta guardado */
    private final JLabel txtPathAA = new JLabel("PATH:");
    /** Área de texto para introducir el path del alfabeto que se quiere crear */
    private final JTextArea areaPathAA = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear un alfabeto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear un alfabeto sin contenido o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");
    /** Pantalla de error alfabeto no agregado */
    private JFrame frame = new JFrame();


    public VistaAlfabetoA(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);

        // Título ventana superior
        tituloVistaAA.setBounds(10, 5, 120, 30);
        add(tituloVistaAA);


        // Texto Nombre
        txtNombreAA.setBounds(50, 35, 200, 20);
        add(txtNombreAA);

        // Área texto Nombre
        areanomAA.setBounds(250,35, 200,20);
        add(areanomAA);

        // Texto Contenido
        txtContenidoAA.setBounds(50, 75, 200, 20);
        add(txtContenidoAA);

        // Área texto Contenido
        areaContenidoAA.setBounds(250,75, 200,60);
        add(areaContenidoAA);

        // Texto Path
        txtPathAA.setBounds(50, 175, 200, 20);
        add(txtPathAA);

        // Área texto Path
        areaPathAA.setBounds(250,175, 200,20);
        add(areaPathAA);

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
                if (areanomAA.getText().isEmpty()){
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

                } else if (areaContenidoAA.getText().isEmpty() && areaPathAA.getText().isEmpty()){
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
                    JButton bSalir1 = new JButton("Salir");
                    if(areaContenidoAA.getText().isEmpty()){
                        boolean agregado = CtrlPresentacion.agregarAlfabetoPath(areanomAA.getText(), areaPathAA.getText());
                    }
                    else if(areaPathAA.getText().isEmpty()) {
                        boolean agregado = CtrlPresentacion.agregarAlfabetoManual(areanomAA.getText(), areaContenidoAA.getText());
                        if (!agregado) {
                            JDialog alfabetoNoAgregado = new JDialog(frame, "Alfabeto no agregado");
                            alfabetoNoAgregado.setBounds(800, 300, 400, 200);
                            alfabetoNoAgregado.setLayout(null);

                            JLabel lalfabetoNoAgregado = new JLabel("Ya existe un alfabeto con el nombre " + areanomAA.getText() + " debe cambiar el nombre.");
                            lalfabetoNoAgregado.setBounds(80, 20, 400, 40);
                            bSalir1.setVisible(true);
                            bSalir1.setBounds(150, 110, 100, 30);
                            alfabetoNoAgregado.add(lalfabetoNoAgregado);
                            alfabetoNoAgregado.add(bSalir1);
                            alfabetoNoAgregado.setVisible(true);

                            ActionListener lSortirAlfabetoNoAgregado = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    alfabetoNoAgregado.dispose();
                                    alfabetoNoAgregado.setVisible(false);
                                }
                            };
                            bSalir1.addActionListener(lSortirAlfabetoNoAgregado);
                        }else {
                            //POSAR EN BLANC ELS REQUADRES DE TEXT
                        }
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

        bAgregarAlfabeto.addActionListener(lAgregar);
        bsalir.addActionListener(lSalir);
    }
}
