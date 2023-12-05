package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaTecladoC extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaTC = new JLabel("Consultar teclado");
    /** Título de media ventana */
    private final JLabel tituloVistaTC2 = new JLabel("Consultar lista de teclados");
    /** Botón para consultar un teclado */
    private final JButton bConsultarTeclado = new JButton("Consultar teclado");
    /** Botón para consultar la lista de teclados */
    private final JButton bConsultarListaTeclados = new JButton("Consultar lista de teclados");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del teclado a consultar*/
    private final JLabel txtNombreTC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del teclado que se quiere consultar */
    private final JTextArea areanomTC = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un teclado sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");



    public VistaTecladoC(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades teclado);

        // Título ventana superior
        tituloVistaTC.setBounds(10, 5, 120, 30);
        add(tituloVistaTC);

        // Título media ventana
        tituloVistaTC2.setBounds(10, 205, 200, 30);
        add(tituloVistaTC2);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTC.setBounds(50, 35, 200, 20);
        add(txtNombreTC);

        // Área texto Nombre
        areanomTC.setBounds(250,35, 200,20);
        add(areanomTC);

        // Botón consultar teclado
        bConsultarTeclado.setBounds(700, 150, 200, 20);
        add(bConsultarTeclado);

        // Botón consultar lista de teclados
        bConsultarListaTeclados.setBounds(700, 250, 200, 20);
        add(bConsultarListaTeclados);

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

                if (areanomTC.getText().isEmpty()){
                    JDialog sinNombre2 =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre2.setBounds(800, 300, 400, 200);
                    sinNombre2.setLayout(null);

                    JLabel txtErrorNombre2 = new JLabel("Hay que entrar el nombre de un teclado de la lista de teclados");
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
                    // CtrlPresentacion.consultarContenidoTeclado(areanomCMT1.getText());
                    setVisible(false);
                }

            }
        };

        ActionListener lConsultarListaA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        ActionListener lSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        bConsultarTeclado.addActionListener(lConsultarA);
        bConsultarListaTeclados.addActionListener(lConsultarListaA);
        bsalir.addActionListener(lSalir);

    }

}