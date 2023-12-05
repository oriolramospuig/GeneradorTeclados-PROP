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
    private final JLabel tituloVistaTxtC = new JLabel("Consultar texto");
    /** Título de media ventana */
    private final JLabel tituloVistaTxtC2 = new JLabel("Consultar lista de textos");
    /** Botón para consultar un texto */
    private final JButton bConsultarTexto = new JButton("Consultar texto");
    /** Botón para consultar la lista de textos */
    private final JButton bConsultarListaTextos = new JButton("Consultar lista de textos");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto a consultar*/
    private final JLabel txtNombreTxtC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere consultar */
    private final JTextArea areanomTxtC = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un texto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");



    public VistaTextoC(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades texto);

        // Título ventana superior
        tituloVistaTxtC.setBounds(10, 5, 120, 30);
        add(tituloVistaTxtC);

        // Título media ventana
        tituloVistaTxtC2.setBounds(10, 205, 200, 30);
        add(tituloVistaTxtC2);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTxtC.setBounds(50, 35, 200, 20);
        add(txtNombreTxtC);

        // Área texto Nombre
        areanomTxtC.setBounds(250,35, 200,20);
        add(areanomTxtC);

        // Botón consultar texto
        bConsultarTexto.setBounds(700, 150, 200, 20);
        add(bConsultarTexto);

        // Botón consultar lista de textos
        bConsultarListaTextos.setBounds(700, 250, 200, 20);
        add(bConsultarListaTextos);

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

                if (areanomTxtC.getText().isEmpty()){
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
                    CtrlPresentacion.consultarContenidoTexto(areanomTxtC.getText());
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

        bConsultarTexto.addActionListener(lConsultarA);
        bConsultarListaTextos.addActionListener(lConsultarListaA);
        bsalir.addActionListener(lSalir);

    }

}
