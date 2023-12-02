package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAlfabetoCM extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaACM1 = new JLabel("Consultar alfabeto");
    /** Título de media ventana */
    private final JLabel tituloVistaACM2 = new JLabel("Consultar lista de alfabetos");
    /** Título de media ventana inferior */
    private final JLabel tituloVistaACM3 = new JLabel("Modificar alfabeto");
    /** Botón para consultar un alfabeto */
    private final JButton bConsultarAlfabeto = new JButton("Consultar alfabeto");
    /** Botón para consultar la lista de alfabetos */
    private final JButton bConsultarListaAlfabetos = new JButton("Consultar lista de alfabetos");
    /** Botón para modificar un alfabeto */
    private final JButton bModificarAlfabeto = new JButton("Modificar alfabeto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("ATRÁS");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtNombreCM1 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areanomCMA1 = new JTextArea();

    //VENTANA INFERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a modificar */
    private final JLabel txtNombreCM2 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere modificar */
    private final JTextArea areanomCMA2 = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un alfabeto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");



    public VistaAlfabetoCM(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);

        // Título ventana superior
        tituloVistaACM1.setBounds(10, 5, 120, 30);
        add(tituloVistaACM1);

        // Título media ventana
        tituloVistaACM2.setBounds(10, 205, 200, 30);
        add(tituloVistaACM2);

        // Título ventana inferior
        tituloVistaACM3.setBounds(10, 305, 120, 30);
        add(tituloVistaACM3);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreCM1.setBounds(50, 35, 200, 20);
        add(txtNombreCM1);

        // Área texto Nombre
        areanomCMA1.setBounds(250,35, 200,20);
        add(areanomCMA1);

        //VENTANA INFERIOR
        // Texto Nombre
        txtNombreCM2.setBounds(50, 335, 200, 20);
        add(txtNombreCM2);

        // Área texto Nombre
        areanomCMA2.setBounds(250,335, 200,20);
        add(areanomCMA2);

        // Botón consultar Alfabeto
        bConsultarAlfabeto.setBounds(700, 150, 200, 20);
        add(bConsultarAlfabeto);

        // Botón consultar lista de Alfabetos
        bConsultarListaAlfabetos.setBounds(700, 250, 200, 20);
        add(bConsultarListaAlfabetos);

        // Botón borrar Alfabeto
        bModificarAlfabeto.setBounds(700, 400, 200, 20);
        add(bModificarAlfabeto);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lConsultarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //CtrlPresentacion.getNombresAlfabetos();

                if (areanomCMA1.getText().isEmpty()){
                    JDialog sinNombre2 =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre2.setBounds(800, 300, 400, 200);
                    sinNombre2.setLayout(null);

                    JLabel txtErrorNombre2 = new JLabel("Hay que entrar el nombre de un alfabeto de la lista de alfabetos");
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
                    CtrlPresentacion.consultarContenidoAlfabeto(areanomCMA1.getText());
                    setVisible(false);
                }

            }
        };

        ActionListener lConsultarListaA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        ActionListener lModificarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //CtrlPresentacion.getNombresAlfabetos();

                if (areanomCMA2.getText().isEmpty()){
                    JDialog sinNombre2 =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre2.setBounds(800, 300, 400, 200);
                    sinNombre2.setLayout(null);

                    JLabel txtErrorNombre2 = new JLabel("Hay que entrar el nombre de un alfabeto de la lista de alfabetos");
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
                    CtrlPresentacion.consultarContenidoAlfabeto(areanomCMA2.getText());
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

        bConsultarAlfabeto.addActionListener(lConsultarA);
        bConsultarListaAlfabetos.addActionListener(lConsultarListaA);
        bModificarAlfabeto.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }

}

