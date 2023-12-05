package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaTextoB extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaTxtB = new JLabel("Borrar texto");
    private final JButton bBorrarTexto = new JButton("Borrar texto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA INFERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del texto */
    private final JLabel txtNombreB = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del texto que se quiere crear */
    private final JTextArea areanomTxtB = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere crear un texto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");
    /** Pantalla de error que aparece cuando se quiere crear un texto sin contenido o sin path */
    private final JFrame CPframe = new JFrame ("JFrame");


    public VistaTextoB(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades texto);

        // Título ventana inferior
        tituloVistaTxtB.setBounds(10, 305, 120, 30);
        add(tituloVistaTxtB);

        //VENTANA INFERIOR
        // Texto Nombre
        txtNombreB.setBounds(50, 335, 200, 20);
        add(txtNombreB);

        // Área texto Nombre
        areanomTxtB.setBounds(250,335, 200,20);
        add(areanomTxtB);

        //BOTONES
        // Botón borrar texto
        bBorrarTexto.setBounds(700, 400, 200, 20);
        add(bBorrarTexto);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lBorrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //CtrlPresentacion.getNombresTextos();


                if (areanomTxtB.getText().isEmpty()){
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
                    CtrlPresentacion.borrarTexto(areanomTxtB.getText());
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
        bBorrarTexto.addActionListener(lBorrar);
        bsalir.addActionListener(lSalir);

    }

}
