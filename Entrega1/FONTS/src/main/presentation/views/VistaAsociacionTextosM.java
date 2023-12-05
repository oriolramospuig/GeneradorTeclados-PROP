package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAsociacionTextosM extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaATM = new JLabel("Modificar asociación de textos");
    /** Botón para modificar una asociación */
    private final JButton bModificarAsociacion = new JButton("Modificar asociación de textos");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA INFERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación a modificar */
    private final JLabel txtNombreATM = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociación que se quiere modificar */
    private final JTextArea areanomATM = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar una asociación sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");



    public VistaAsociacionTextosM(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);

        // Título ventana inferior
        tituloVistaATM.setBounds(10, 305, 200, 30);
        add(tituloVistaATM);

        //VENTANA INFERIOR
        // Texto Nombre
        txtNombreATM.setBounds(50, 335, 200, 20);
        add(txtNombreATM);

        // Área texto Nombre
        areanomATM.setBounds(250,335, 200,20);
        add(areanomATM);

        // Botón borrar Alfabeto
        bModificarAsociacion.setBounds(700, 400, 200, 20);
        add(bModificarAsociacion);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lModificarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //CtrlPresentacion.getNombresAlfabetos();

                if (areanomATM.getText().isEmpty()){
                    JDialog sinNombre2 =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre2.setBounds(800, 300, 400, 200);
                    sinNombre2.setLayout(null);

                    JLabel txtErrorNombre2 = new JLabel("Hay que entrar el nombre de una asociación de textos de la lista de asociaciones de textos");
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
                    CtrlPresentacion.consultarContenidoAlfabeto(areanomATM.getText());
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

        bModificarAsociacion.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }

}