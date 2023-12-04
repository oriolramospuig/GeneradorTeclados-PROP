package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaTextoAB extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaTxt1 = new JLabel("Agregar texto de palabras");
    /** Título de media ventana superior */
    private final JLabel tituloVistaTxt11 = new JLabel("Agregar texto de frecuencias");
    /** Título de media ventana inferior */
    private final JLabel tituloVistaTxt2 = new JLabel("Borrar texto");

    /** Botón para agregar un texto */
    private final JButton bAgregarTexto = new JButton("Agregar texto de palabras");
    /** Botón para agregar un texto */
    private final JButton bAgregarTextoFrec = new JButton("Agregar texto de frecuencias");
    /** Botón para borrar un texto */
    private final JButton bBorrarTexto = new JButton("Borrar texto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtNombre1 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere crear */
    private final JTextArea areanomTxt1 = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del texto */
    private final JLabel txtContenido = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del texto que se quiere crear */
    private final JTextArea areaContenido = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del texto, para saber donde esta guardado */
    private final JLabel txtPath = new JLabel("PATH:");
    /** Área de texto para introducir el path del texto que se quiere crear */
    private final JTextArea areaPath = new JTextArea();


    //VENTANA SUPERIOR2
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtNombre11 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere crear */
    private final JTextArea areanomTxt11 = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del texto */
    private final JLabel txtContenido1 = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del texto que se quiere crear */
    private final JTextArea areaContenido1 = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del texto, para saber donde esta guardado */
    private final JLabel txtPath1 = new JLabel("PATH:");
    /** Área de texto para introducir el path del texto que se quiere crear */
    private final JTextArea areaPath1 = new JTextArea();


    //VENTANA INFERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtNombre2 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere crear */
    private final JTextArea areanomTxt2 = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear un texto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear un texto sin contenido o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");


    public VistaTextoAB(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades texto);

        // Título ventana superior
        tituloVistaTxt1.setBounds(10, 5, 120, 30);
        add(tituloVistaTxt1);

        // Título ventana superior2
        tituloVistaTxt11.setBounds(310, 5, 120, 30);
        add(tituloVistaTxt11);

        // Título ventana inferior
        tituloVistaTxt2.setBounds(10, 305, 120, 30);
        add(tituloVistaTxt2);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombre1.setBounds(50, 35, 200, 20);
        add(txtNombre1);

        // Área texto Nombre
        areanomTxt1.setBounds(250,35, 200,20);
        add(areanomTxt1);

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

        add(tituloVistaTxt2);

        //VENTANA SUPERIOR2
        // Texto Nombre
        txtNombre11.setBounds(350, 35, 200, 20);
        add(txtNombre11);

        // Área texto Nombre
        areanomTxt11.setBounds(550,35, 200,20);
        add(areanomTxt11);

        // Texto Contenido
        txtContenido1.setBounds(350, 75, 200, 20);
        add(txtContenido1);

        // Área texto Contenido
        areaContenido1.setBounds(550,75, 200,60);
        add(areaContenido1);

        // Texto Path
        txtPath1.setBounds(350, 175, 200, 20);
        add(txtPath1);

        // Área texto Path
        areaPath1.setBounds(550,175, 200,20);
        add(areaPath1);

        //VENTANA INFERIOR
        // Texto Nombre
        txtNombre2.setBounds(50, 335, 200, 20);
        add(txtNombre2);

        // Área texto Nombre
        areanomTxt2.setBounds(250,335, 200,20);
        add(areanomTxt2);

        //BOTONES
        // Botón agregar texto palabras
        bAgregarTexto.setBounds(400, 250, 200, 20);
        add(bAgregarTexto);

        // Botón agregar texto frecuencias
        bAgregarTexto.setBounds(700, 250, 200, 20);
        add(bAgregarTexto);

        // Botón borrar texto
        bBorrarTexto.setBounds(700, 400, 200, 20);
        add(bBorrarTexto);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areanomTxt1.getText().isEmpty()){
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

                } else if (areaContenido.getText().isEmpty() && areaPath.getText().isEmpty()){
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
                    if(areaContenido.getText().isEmpty()){
                        // fer lo del path areaPath.getText();
                    }
                    else if(areaPath.getText().isEmpty()) {
                        //CtrlPresentacion.agregarTexto(areanomA1.getText(), areaContenido.getText());
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

                //CtrlPresentacion.getNombresTextos();


                if (areanomTxt2.getText().isEmpty()){
                    JDialog sinNombre2 =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre2.setBounds(800, 300, 400, 200);
                    sinNombre2.setLayout(null);

                    JLabel txtErrorNombre2 = new JLabel("Hay que entrar el nombre de un texto de la lista de texto");
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
                    CtrlPresentacion.borrarTexto(areanomTxt2.getText());
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

        bAgregarTexto.addActionListener(lAgregar);
        bBorrarTexto.addActionListener(lBorrar);
        bsalir.addActionListener(lSalir);

    }

}
