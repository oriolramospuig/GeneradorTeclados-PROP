package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.*;


public class VistaTecladoAB extends JFrame{

    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de la ventana */
    private final JLabel tituloVistaT = new JLabel("Teclados");
    /** Botón para agregar un teclado por QAP o Algoritmo 2 */
    private final JButton bNuevoTecladoPor = new JButton("Crear Teclado");
    /** Área de texto para introducir el nombre del teclado que se quiere crear */
    private final JButton bConsultarTeclado = new JButton("Consultar Teclado");
    private final JButton bModificarTeclado = new JButton("Modificar Teclado");
    private final JButton bEliminarTeclado = new JButton("Eliminar Teclado");
    private final JButton bAtras = new JButton("Atrás");


    //FUNCIONALIDADES
    /** Botón para ir a la ventana de documentos recientemente abiertos */
    private final JButton bDocRecents = new JButton("Documentos recientes");
    /** Botón para ir a la ventana de cargar un documento */
    private final JButton bCarregarDoc = new JButton("Cargar Documento");
    /** Botón para ir a la ventana de eliminar un documento */
    private final JButton bEliminarDoc = new JButton("Eliminar Document");

    /** Botón de volver a la pantalla del menú principal */
    private final JButton salir = new JButton("ATRÁS");


    public VistaTecladoAB(){

        setBounds(250, 150, 1000, 600);

        // Título
        tituloVistaT.setBounds(10, 5, 120, 30);
        add(tituloVistaT);

        // Botón agregarAlfabetoPorTerminal
        bNuevoTecladoPor.setBounds(150, 50, 200, 20);
        add(bNuevoTecladoPor);

        bConsultarTeclado.setBounds(150, 90, 200, 20);
        add(bConsultarTeclado);

        bModificarTeclado.setBounds(150, 130, 200, 20);
        add(bModificarTeclado);

        bEliminarTeclado.setBounds(150, 170, 200, 20);
        add(bEliminarTeclado);

        bAtras.setBounds(250, 235, 200, 20);
        add(bAtras);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener crear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        bNuevoTecladoPor.addActionListener(crear);
        bConsultarTeclado.addActionListener(crear);
        bModificarTeclado.addActionListener(crear);
        bEliminarTeclado.addActionListener(crear);
        bAtras.addActionListener(crear);
    }
}
