package main.presentation.views;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaAlfabetoAB extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaA1 = new JLabel("Agregar alfabeto");
    /** Título de media ventana inferior */
    private final JLabel tituloVistaA2 = new JLabel("Borrar alfabeto");
    /** Botón para agregar un alfabeto */
    private final JButton bAgregarAlfabeto = new JButton("Agregar Alfabeto");
    /** Botón para borrar un alfabeto */
    private final JButton bBorrarAlfabeto = new JButton("Borrar Alfabeto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton salir = new JButton("ATRÁS");


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


    public VistaAlfabetoAB(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);

        // Título ventana superior
        tituloVistaA1.setBounds(10, 5, 120, 30);
        add(tituloVistaA1);

        // Título ventana inferior
        tituloVistaA2.setBounds(310, 5, 120, 30);
        add(tituloVistaA2);


        // Texto Nombre
        txtNombre.setBounds(50, 35, 200, 20);
        add(txtNombre);

        // Área texto Nombre
        areanomA.setBounds(175,35, 200,20);
        add(areanomA);

        // Texto Contenido
        txtContenido.setBounds(50, 75, 200, 20);
        add(txtContenido);

        // Área texto Contenido
        areaContenido.setBounds(175,75, 200,60);
        add(areaContenido);

        // Texto Path
        txtPath.setBounds(50, 135, 200, 20);
        add(txtPath);

        // Área texto Path
        areaPath.setBounds(175,135, 200,20);
        add(areaPath);

        // Botón agregar Alfabeto
        bAgregarAlfabeto.setBounds(150, 250, 100, 20);
        add(bAgregarAlfabeto);

        // Botón borrar Alfabeto
        bBorrarAlfabeto.setBounds(150, 550, 100, 20);
        add(bBorrarAlfabeto);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreA = null;
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
                }
                else nombreA = areanomA.getText();

                String contenido = null;
                if (areaContenido.getText().isEmpty() && areaPath.getText().isEmpty()){
                    JDialog sinConPath =  new JDialog(Nomframe, "Error: No Contenido o No Path");
                    sinConPath.setBounds(800, 300, 400, 200);
                    sinConPath.setLayout(null);

                    JLabel txtErrorConPath = new JLabel("Hay que añadir un contenido del alfabeto a mano o entrar un path donde se encuentra el archivo del alfabeto");
                    txtErrorConPath.setBounds(80, 20, 400, 40);
                    JButton bSalirErrorConPath = new JButton("Salir");
                    bSalirErrorConPath.setVisible(true);
                    bSalirErrorConPath.setBounds(150, 110, 100, 30);
                    sinConPath.add(txtErrorConPath);
                    sinConPath.add(bSalirErrorConPath);
                    sinConPath.setVisible(true);
                }
                else {
                    if(areaContenido.getText().isEmpty()){
                        // fer lo del path areaPath.getText();
                    }
                    else if(areaPath.getText().isEmpty()) {
                        contenido = areaContenido.getText();
                    }
                }

                //if (areaFiles.getText().length() == 0) files = 50;
                //else files = Integer.parseInt(areaFiles.getText());


                /*if (areaPath.getText().length() == 0){
                    JDialog senseLoc =  new JDialog(frame, "Error: no Path");
                    senseLoc.setBounds(800, 300, 400, 200);
                    senseLoc.setLayout(null);

                    JLabel txtErrorPath = new JLabel("S'ha d'especificar el path del Document");
                    txtErrorPath.setBounds(80, 20, 400, 40);
                    JButton botoSortirErrorPath = new JButton("Sortir");
                    botoSortirErrorPath.setVisible(true);
                    botoSortirErrorPath.setBounds(150, 110, 100, 30);
                    senseLoc.add(txtErrorPath);
                    senseLoc.add(botoSortirErrorPath);
                    senseLoc.setVisible(true);

                    ActionListener lSortirErrorPath = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            senseLoc.dispose();
                            senseLoc.setVisible(false);
                        }
                    };

                    botoSortirErrorPath.addActionListener(lSortirErrorPath);

                } else if (areaNom.getText().length() == 0) {
                    CtrlPresentacion.crearDocument(areaPath.getText(), "Sense_titol");
                    CtrlPresentacio.crearFull("Full 1", columnes , files);
                    CtrlPresentacio.vistaSpreadsheet("Sense_titol", false);
                    setVisible(false);

                } else { // s'ha introduït un nom
                    CtrlPresentacio.crearDocument(areaPath.getText(), areaNom.getText());
                    CtrlPresentacio.crearFull(columnes , files);
                    CtrlPresentacio.vistaSpreadsheet(CtrlPresentacio.getNomDocument(), false);
                    setVisible(false);
                }*/


            }
        };



    }

}
