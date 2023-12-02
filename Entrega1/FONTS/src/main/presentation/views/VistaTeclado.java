package main.presentation.views;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;


public class VistaTeclado {

    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de la ventana */
    private final JLabel tituloVistaT = new JLabel("Editar teclados");
    /** Botón para agregar un teclado por QAP o Algoritmo 2 */
    private final JButton bNuevoTecladoPor = new JButton("Nuevo Teclado por");
    /** Botón para crear un teclado por QAP */
    private final JButton bNuevoTecladoPorQAP = new JButton("Nuevo teclado mediante QAP");
    /** Área de texto para introducir el nombre del teclado que se quiere crear */
    private final JTextArea areanomT = new JTextArea();


    //FUNCIONALIDADES
    /** Botón para ir a la ventana de documentos recientemente abiertos */
    private final JButton bDocRecents = new JButton("Documentos recientes");
    /** Botón para ir a la ventana de cargar un documento */
    private final JButton bCarregarDoc = new JButton("Cargar Documento");
    /** Botón para ir a la ventana de eliminar un documento */
    private final JButton bEliminarDoc = new JButton("Eliminar Document");

    /** Botón de volver a la pantalla del menú principal */
    private final JButton salir = new JButton("ATRÁS");


    public VistaTeclado(){

        lamina.setBounds(500, 300, 500, 300);

        // Título
        tituloVistaT.setBounds(10, 5, 120, 30);
        lamina.add(tituloVistaT);

        // Botón agregarAlfabetoPorTerminal
        bNuevoTecladoPor.setBounds(150, 200, 200, 20);
        lamina.add(bNuevoTecladoPor);

        // Área texto Nombre Alfabeto
        areanomT.setBounds(175,75, 200,20);
        lamina.add(areanomT);
    }
}
