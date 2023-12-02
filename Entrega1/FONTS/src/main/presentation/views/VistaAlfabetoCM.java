package main.presentation.views;

import javax.swing.*;

public class VistaAlfabetoCM extends JFrame {

    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de la ventana */
    private final JLabel tituloVistaA = new JLabel("Editar alfabetos");
    /** Botón para agregar un alfabeto por .... */
    private final JButton bNuevoAlfabetoPor = new JButton("Nuevo alfabeto por");
    /** Botón para agregar un alfabeto por archivo */
    private final JButton bNuevoAlfabetoPorArchivo = new JButton("Nuevo alfabeto por archivo");


    /** Área de texto para introducir el nombre del documento que se quiere crear */
    private final JTextArea areanomA = new JTextArea();


    //ANAR AFEGINT TOTES LES FUNCIONALITATS
    /** Botó per anar a la finestra de documents recentment oberts */
    private final JButton bDocRecents = new JButton("Documents recents");
    /** Botó per anar a la finestra de carregar un document */
    private final JButton bCarregarDoc = new JButton("Carregar Document");
    /** Botó per anar a la finestra d'eliminar un document */
    private final JButton bEliminarDoc = new JButton("Eliminar Document");

    /** Botó de tornar a la pantalla del menú principal */
    private final JButton salir = new JButton("ATRÁS");


    public VistaAlfabetoCM(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);

        // Título ventana
        tituloVistaA.setBounds(10, 5, 120, 30);
        add(tituloVistaA);

        // Botón agregarAlfabetoPorTerminal
        bNuevoAlfabetoPor.setBounds(150, 200, 200, 20);
        add(bNuevoAlfabetoPor);


        // Área texto Nombre Alfabeto
        areanomA.setBounds(175,75, 200,20);
        add(areanomA);

    }

}

