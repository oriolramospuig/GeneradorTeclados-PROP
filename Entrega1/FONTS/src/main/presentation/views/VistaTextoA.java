package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaTextoA extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaTxtA = new JLabel("Agregar texto de palabras");
    /** Título de media ventana superior */
    private final JLabel tituloVistaTxtA1 = new JLabel("Agregar texto de frecuencias");
    /** Botón para agregar un texto */
    private final JButton bAgregarTexto = new JButton("Agregar texto de palabras");
    /** Botón para agregar un texto */
    private final JButton bAgregarTextoFrec = new JButton("Agregar texto de frecuencias");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtNombreTxtA = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere crear */
    private final JTextArea areanomTxtA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del texto */
    private final JLabel txtContenidoTxtA = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del texto que se quiere crear */
    private final JTextArea areaContenidoTxtA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del texto, para saber donde esta guardado */
    private final JLabel txtPathTxtA = new JLabel("PATH:");
    /** Área de texto para introducir el path del texto que se quiere crear */
    private final JTextArea areaPathTxtA = new JTextArea();
    /** Texto explicando las instrucciones de como entrar el texto en caso de palabras */
    private final JLabel txtInstruccionesTxtA = new JLabel("(Hay que añadir un texto del formato palabras en frases. Ej: Hola que tal)");


    //VENTANA SUPERIOR2
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtNombreTxtA1 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere crear */
    private final JTextArea areanomTxtA1 = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del texto */
    private final JLabel txtContenidoTxtA1 = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del texto que se quiere crear */
    private final JTextArea areaContenidoTxtA1 = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del texto, para saber donde esta guardado */
    private final JLabel txtPathTxtA1 = new JLabel("PATH:");
    /** Área de texto para introducir el path del texto que se quiere crear */
    private final JTextArea areaPathTxtA1 = new JTextArea();
    /** Texto explicando las instrucciones de como entrar el texto en caso de palabras */
    private final JLabel txtInstruccionesTxtA1 = new JLabel("(Hay que añadir un texto del formato palabras con sus rescpectivas");
    /** Texto explicando las instrucciones de como entrar el texto en caso de palabras */
    private final JLabel txtInstruccionesTxtA2 = new JLabel("frecuencias separadas por un espacio. Ej: hola 5)");

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear un texto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear un texto sin contenido o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");

    /** Pantalla de error texto no agregado */
    private JFrame frame = new JFrame();


    public VistaTextoA(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades texto);

        // Título ventana superior
        tituloVistaTxtA.setBounds(10, 5, 200, 30);
        add(tituloVistaTxtA);

        // Título ventana superior2
        tituloVistaTxtA1.setBounds(510, 5, 200, 30);
        add(tituloVistaTxtA1);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTxtA.setBounds(30, 35, 200, 20);
        add(txtNombreTxtA);

        // Área texto Nombre
        areanomTxtA1.setBounds(230,35, 200,20);
        add(areanomTxtA1);

        // Texto Contenido
        txtContenidoTxtA.setBounds(30, 75, 200, 20);
        add(txtContenidoTxtA);

        // Área texto Contenido
        areaContenidoTxtA.setBounds(230,75, 200,60);
        add(areaContenidoTxtA);

        // Texto Path
        txtPathTxtA.setBounds(30, 175, 200, 20);
        add(txtPathTxtA);

        // Área texto Path
        areaPathTxtA.setBounds(230,175, 200,20);
        add(areaPathTxtA);

        // Texto Instrucciones
        txtInstruccionesTxtA.setBounds(30, 260, 500, 20);
        add(txtInstruccionesTxtA);


        //VENTANA SUPERIOR2
        // Texto Nombre
        txtNombreTxtA1.setBounds(550, 35, 200, 20);
        add(txtNombreTxtA1);

        // Área texto Nombre
        areanomTxtA1.setBounds(750,35, 200,20);
        add(areanomTxtA1);

        // Texto Contenido
        txtContenidoTxtA1.setBounds(550, 75, 200, 20);
        add(txtContenidoTxtA1);

        // Área texto Contenido
        areaContenidoTxtA1.setBounds(750,75, 200,60);
        add(areaContenidoTxtA1);

        // Texto Path
        txtPathTxtA1.setBounds(550, 175, 200, 20);
        add(txtPathTxtA1);

        // Área texto Path
        areaPathTxtA1.setBounds(750,175, 200,20);
        add(areaPathTxtA1);

        // Texto Instrucciones
        txtInstruccionesTxtA1.setBounds(550, 260, 500, 20);
        add(txtInstruccionesTxtA1);
        // Texto Instrucciones2
        txtInstruccionesTxtA2.setBounds(550, 280, 500, 20);
        add(txtInstruccionesTxtA2);


        //BOTONES
        // Botón agregar texto palabras
        bAgregarTexto.setBounds(200, 240, 200, 20);
        add(bAgregarTexto);

        // Botón agregar texto frecuencias
        bAgregarTextoFrec.setBounds(700, 240, 200, 20);
        add(bAgregarTextoFrec);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areanomTxtA1.getText().isEmpty()){
                    JDialog sinNombre =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre.setBounds(800, 300, 400, 200);
                    sinNombre.setLayout(null);

                    JLabel txtErrorNombre = new JLabel("Hay que agregar el texto con un nombre nuevo");
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

                } else if (areaContenidoTxtA.getText().isEmpty() && areaPathTxtA.getText().isEmpty()){
                    JDialog sinConPath =  new JDialog(CPframe, "Error: No Contenido o No Path");
                    sinConPath.setBounds(450, 300, 700, 200);
                    sinConPath.setLayout(null);

                    JLabel txtErrorConPath = new JLabel("Hay que añadir un contenido del texto a mano o entrar un path donde se encuentra el archivo del texto");
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
                    if(areaContenidoTxtA.getText().isEmpty()){
                        // fer lo del path areaPath.getText();
                    }
                    else if(areaPathTxtA.getText().isEmpty()) {
                        boolean agregado = CtrlPresentacion.agregarTextoPalabras(areanomTxtA1.getText(), areaContenidoTxtA.getText());
                        if (!agregado) {
                            JDialog textoNoAgregado = new JDialog(frame, "Texto no agregado");
                            textoNoAgregado.setBounds(800, 300, 400, 200);
                            textoNoAgregado.setLayout(null);

                            JLabel ltextoNoAgregado = new JLabel("Ya existe un texto con el nombre " + areanomTxtA1.getText());
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
                            setVisible(false);
                        }
                    }
                }
            }
        };

        ActionListener lAgregarFrec = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areanomTxtA1.getText().isEmpty()){
                    JDialog sinNombre =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre.setBounds(800, 300, 400, 200);
                    sinNombre.setLayout(null);

                    JLabel txtErrorNombre = new JLabel("Hay que agregar el texto con un nombre nuevo");
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

                } else if (areaContenidoTxtA1.getText().isEmpty() && areaPathTxtA1.getText().isEmpty()){
                    JDialog sinConPath =  new JDialog(CPframe, "Error: No Contenido o No Path");
                    sinConPath.setBounds(450, 300, 700, 200);
                    sinConPath.setLayout(null);

                    JLabel txtErrorConPath = new JLabel("Hay que añadir un contenido del texto a mano o entrar un path donde se encuentra el archivo del texto");
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
                    if(areaContenidoTxtA1.getText().isEmpty()){
                        // fer lo del path areaPath.getText();
                    }
                    else if(areaPathTxtA1.getText().isEmpty()) {
                        //CtrlPresentacion.agregarTexto(areanomA1.getText(), areaContenido.getText());
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

        bAgregarTexto.addActionListener(lAgregar);
        bAgregarTextoFrec.addActionListener(lAgregarFrec);
        bsalir.addActionListener(lSalir);

    }

}
