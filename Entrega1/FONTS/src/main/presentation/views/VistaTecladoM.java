package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaTecladoM extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaTM = new JLabel("Modificar teclado");
    /** Botón para modificar un teclado */
    private final JButton bModificarTeclado = new JButton("Modificar teclado");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA INFERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del teclado a modificar */
    private final JLabel txtNombreTM = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del teclado que se quiere modificar */
    private final JTextArea areanomTM = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un teclado sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");



    public VistaTecladoM(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades teclado);

        // Título ventana inferior
        tituloVistaTM.setBounds(10, 305, 120, 30);
        add(tituloVistaTM);

        //VENTANA INFERIOR
        // Texto Nombre
        txtNombreTM.setBounds(50, 335, 200, 20);
        add(txtNombreTM);

        // Área texto Nombre
        areanomTM.setBounds(250,335, 200,20);
        add(areanomTM);

        // Botón borrar teclado
        bModificarTeclado.setBounds(700, 400, 200, 20);
        add(bModificarTeclado);

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

                if (areanomTM.getText().isEmpty()){
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
                    // CtrlPresentacion.consultarContenidoTeclado(areanomCMT2.getText());
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

        bModificarTeclado.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }

}
