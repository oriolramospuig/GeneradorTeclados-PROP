package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaAsociacionTextosB extends JFrame {

    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaATB = new JLabel("Borrar asociación de textos");
    /** Botón para borrar un alfabeto */
    private final JButton bBorrarAsociacion = new JButton("Borrar asociación de textos");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");

    //VENTANA INFERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación */
    private final JLabel txtNombreATB = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociación que se quiere crear */
    private final JTextArea areanomATB = new JTextArea();

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

        // Título ventana inferior
        tituloVistaATB.setBounds(10, 305, 200, 30);
        add(tituloVistaATB);

        //VENTANA INFERIOR
        // Texto Nombre
        txtNombreATB.setBounds(50, 335, 200, 20);
        add(txtNombreATB);

        // Área texto Nombre
        areanomATB.setBounds(250,335, 200,20);
        add(areanomATB);

        // Botón borrar Alfabeto
        bBorrarAsociacion.setBounds(700, 400, 200, 20);
        add(bBorrarAsociacion);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lBorrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //CtrlPresentacion.getNombresAlfabetos();


                if (areanomATB.getText().isEmpty()){
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
                    CtrlPresentacion.borrarAlfabeto(areanomATB.getText());
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

        bBorrarAsociacion.addActionListener(lBorrar);
        bsalir.addActionListener(lSalir);

    }
}

