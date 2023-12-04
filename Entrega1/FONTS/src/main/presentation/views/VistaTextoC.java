package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaTextoC extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaTxtCM1 = new JLabel("Consultar texto");
    /** Título de media ventana */
    private final JLabel tituloVistaTxtCM2 = new JLabel("Consultar lista de textos");
    /** Título de media ventana inferior */
    private final JLabel tituloVistaTxtCM3 = new JLabel("Modificar texto");
    /** Botón para consultar un texto */
    private final JButton bConsultarTexto = new JButton("Consultar texto");
    /** Botón para consultar la lista de textos */
    private final JButton bConsultarListaTextos = new JButton("Consultar lista de textos");
    /** Botón para modificar un texto */
    private final JButton bModificarTextos = new JButton("Modificar texto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto a consultar*/
    private final JLabel txtNombreCM1 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere consultar */
    private final JTextArea areanomCMTxt1 = new JTextArea();

    //VENTANA INFERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto a modificar */
    private final JLabel txtNombreCM2 = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere modificar */
    private final JTextArea areanomCMTxt2 = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un texto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");



    public VistaTextoC(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades texto);

        // Título ventana superior
        tituloVistaTxtCM1.setBounds(10, 5, 120, 30);
        add(tituloVistaTxtCM1);

        // Título media ventana
        tituloVistaTxtCM2.setBounds(10, 205, 200, 30);
        add(tituloVistaTxtCM2);

        // Título ventana inferior
        tituloVistaTxtCM3.setBounds(10, 305, 120, 30);
        add(tituloVistaTxtCM3);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreCM1.setBounds(50, 35, 200, 20);
        add(txtNombreCM1);

        // Área texto Nombre
        areanomCMTxt1.setBounds(250,35, 200,20);
        add(areanomCMTxt1);

        //VENTANA INFERIOR
        // Texto Nombre
        txtNombreCM2.setBounds(50, 335, 200, 20);
        add(txtNombreCM2);

        // Área texto Nombre
        areanomCMTxt2.setBounds(250,335, 200,20);
        add(areanomCMTxt2);

        // Botón consultar texto
        bConsultarTexto.setBounds(700, 150, 200, 20);
        add(bConsultarTexto);

        // Botón consultar lista de textos
        bConsultarListaTextos.setBounds(700, 250, 200, 20);
        add(bConsultarListaTextos);

        // Botón borrar texto
        bModificarTextos.setBounds(700, 400, 200, 20);
        add(bModificarTextos);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lConsultarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //CtrlPresentacion.getNombresTextos();

                if (areanomCMTxt1.getText().isEmpty()){
                    JDialog sinNombre2 =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre2.setBounds(800, 300, 400, 200);
                    sinNombre2.setLayout(null);

                    JLabel txtErrorNombre2 = new JLabel("Hay que entrar el nombre de un texto de la lista de textos");
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
                    CtrlPresentacion.consultarContenidoTexto(areanomCMTxt1.getText());
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

                //CtrlPresentacion.getNombresTextos();

                if (areanomCMTxt2.getText().isEmpty()){
                    JDialog sinNombre2 =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre2.setBounds(800, 300, 400, 200);
                    sinNombre2.setLayout(null);

                    JLabel txtErrorNombre2 = new JLabel("Hay que entrar el nombre de un texto de la lista de textos");
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
                    CtrlPresentacion.consultarContenidoTexto(areanomCMTxt2.getText());
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

        bConsultarTexto.addActionListener(lConsultarA);
        bConsultarListaTextos.addActionListener(lConsultarListaA);
        bModificarTextos.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }

}
