package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

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

    /** Botón de salida para cerrar el programa */
    private final JButton bsalir = new JButton("Salir");

    public VistaMenuPrincipal() {
        setBounds(500, 300, 500, 300);
        setResizable(true);
        setTitle("Generador de teclados PROP");

        // Títol finestra
        tituloVista.setBounds(10, 5, 200, 30);
        add(tituloVista);

        // Botón alfabeto
        balfabeto.setBounds(150, 50, 200, 20);
        add(balfabeto);

        // Botón texto
        btexto.setBounds(150, 90, 200, 20);
        add(btexto);

        // Botón asociación textos
        basociacionTextos.setBounds(150, 130, 200, 20);
        add(basociacionTextos);

        // Botón teclado
        bteclado.setBounds(150, 170, 200, 20);
        add(bteclado);

        // Botón salir
        bsalir.setBounds(150, 235, 200, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener alfabeto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //UIManager.put("FileChooser.openButtonText", "Obrir");
                //UIManager.put("FileChooser.chooseButtonText", "Triar");
                //UIManager.put("FileChooser.cancelButtonText", "Cancel·lar");
                CtrlPresentacion.vistaAlfabeto();
                setVisible(false);
            }
        };

        ActionListener texto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //UIManager.put("FileChooser.openButtonText", "Obrir");
                //UIManager.put("FileChooser.chooseButtonText", "Triar");
                //UIManager.put("FileChooser.cancelButtonText", "Cancel·lar");
                CtrlPresentacion.vistaTexto();
                setVisible(false);
            }
        };

        ActionListener asocTextos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //UIManager.put("FileChooser.openButtonText", "Obrir");
                //UIManager.put("FileChooser.chooseButtonText", "Triar");
                //UIManager.put("FileChooser.cancelButtonText", "Cancel·lar");
                CtrlPresentacion.vistaAsociacionTextos();
                setVisible(false);
            }
        };

        ActionListener teclado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //UIManager.put("FileChooser.openButtonText", "Obrir");
                //UIManager.put("FileChooser.chooseButtonText", "Triar");
                //UIManager.put("FileChooser.cancelButtonText", "Cancel·lar");
                CtrlPresentacion.vistaTeclado();
                setVisible(false);
            }
        };

        ActionListener salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        balfabeto.addActionListener(alfabeto);
        btexto.addActionListener(texto);
        basociacionTextos.addActionListener(asocTextos);
        bteclado.addActionListener(teclado);
        bsalir.addActionListener(salir);
    }


}
