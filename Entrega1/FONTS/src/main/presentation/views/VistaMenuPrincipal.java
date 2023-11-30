package main.presentation.views;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaMenuPrincipal extends JFrame {

    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();

    /** Ventana de selección del directori on es vol crear el document creat */
    //private JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); // el getHomeDirectory ns si va aqui

    /** Título de la ventana */
    private final JLabel tituloVista = new JLabel("Generador de teclados PROP");

    /** Botón para ir a la ventana de alfabeto */
    private final JButton balfabeto = new JButton("ALFABETO");

    /** Botón para ir a la ventana de texto */
    private final JButton btexto = new JButton("TEXTO");

    /** Botón para ir a la ventana de asociacion de textos */
    private final JButton basociacionTextos = new JButton("ASOCIACIÓN DE TEXTOS");

    /** Botón para ir a la ventana de teclado */
    private final JButton bteclado = new JButton("TECLADO");


}
