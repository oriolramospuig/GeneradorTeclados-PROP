package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaTecladoB extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaTB = new JLabel("Borrar teclado");
    /** Botón para borrar un teclado */
    private final JButton bBorrarTeclado = new JButton("Borrar teclado");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA INFERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del teclado */
    private final JLabel txtNombreTB = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del teclado que se quiere crear */
    private final JTextArea areanomTB = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear un teclado sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear un teclado sin contenido o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");


    public VistaTecladoB(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades teclado);

        // Título ventana inferior
        tituloVistaTB.setBounds(10, 305, 120, 30);
        add(tituloVistaTB);

        //VENTANA INFERIOR
        // Texto Nombre
        txtNombreTB.setBounds(50, 335, 200, 20);
        add(txtNombreTB);

        // Área texto Nombre
        areanomTB.setBounds(250,335, 200,20);
        add(areanomTB);

        // Botón borrar teclado
        bBorrarTeclado.setBounds(700, 400, 200, 20);
        add(bBorrarTeclado);

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


                if (areanomTB.getText().isEmpty()){
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
                    // CtrlPresentacion.borrarTeclado(areanomT2.getText());
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

        bBorrarTeclado.addActionListener(lBorrar);
        bsalir.addActionListener(lSalir);

    }

}
