package main.presentation.views;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaAlfabeto {

    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de la ventana */
    private final JLabel tituloVistaA = new JLabel("Generador de teclados PROP");
    /** Botón para agregar un alfabeto por .... */
    private final JButton bNuevoAlfabetoPor = new JButton("Nuevo alfabeto por");
    /** Botón para agregar un alfabeto por archivo */
    private final JButton bNuevoAlfabetoPorArchivo = new JButton("Nuevo alfabeto por archivo");



    //ANAR AFEGINT TOTES LES FUNCIONALITATS
    /** Botó per anar a la finestra de documents recentment oberts */
    private final JButton bDocRecents = new JButton("Documents recents");
    /** Botó per anar a la finestra de carregar un document */
    private final JButton bCarregarDoc = new JButton("Carregar Document");
    /** Botó per anar a la finestra d'eliminar un document */
    private final JButton bEliminarDoc = new JButton("Eliminar Document");

    /** Botó de tornar a la pantalla del menú principal */
    private final JButton salir = new JButton("ATRÁS");


}
