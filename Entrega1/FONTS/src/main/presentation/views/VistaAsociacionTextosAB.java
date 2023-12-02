package main.presentation.views;

import javax.swing.*;

public class VistaAsociacionTextosAB extends JFrame {

    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();


    /** Botó de tornar a la pantalla del menú principal */
    private final JButton salir = new JButton("ATRÁS");

    public VistaAsociacionTextosAB() {
        setBounds(250, 150, 1000, 600);
    }
}
