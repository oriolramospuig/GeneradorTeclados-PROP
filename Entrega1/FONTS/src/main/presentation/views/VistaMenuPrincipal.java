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

    /** Menú desplegable amb les opcions de crear o obrir un nou document, o guardar el document que s'està editant */
    private JMenu alfabeto = new JMenu("Alfabeto");

    /** Ítem del menú desplegable de Fitxer per a crear un nou document */
    private JMenuItem agregar_borrarA = new JMenuItem("Agrega/Elimina");

    /** Ítem del menú desplegable de Fitxer per a crear un nou document */
    private JMenuItem consultar_modificarA = new JMenuItem("Consulta/Modifica");

    /** Menú desplegable amb les opcions de crear o obrir un nou document, o guardar el document que s'està editant */
    private JMenu texto = new JMenu("Texto");

    /** Ítem del menú desplegable de Fitxer per a crear un nou document */
    private JMenuItem agregar_borrarTxt = new JMenuItem("Agrega/Elimina");

    /** Ítem del menú desplegable de Fitxer per a crear un nou document */
    private JMenuItem consultar_modificarTxt = new JMenuItem("Consulta/Modifica");

    /** Menú desplegable amb les opcions de crear o obrir un nou document, o guardar el document que s'està editant */
    private JMenu asociacion = new JMenu("Asociación de Textos");

    /** Ítem del menú desplegable de Fitxer per a crear un nou document */
    private JMenuItem agregar_borrarAT = new JMenuItem("Agrega/Elimina");

    /** Ítem del menú desplegable de Fitxer per a crear un nou document */
    private JMenuItem consultar_modificarAT = new JMenuItem("Consulta/Modifica");

    /** Menú desplegable amb les opcions de crear o obrir un nou document, o guardar el document que s'està editant */
    private JMenu teclado = new JMenu("Teclado");

    /** Ítem del menú desplegable de Fitxer per a crear un nou document */
    private JMenuItem agregar_borrarT = new JMenuItem("Agrega/Elimina");

    /** Ítem del menú desplegable de Fitxer per a crear un nou document */
    private JMenuItem consultar_modificarT = new JMenuItem("Consulta/Modifica");

    /** Botón de salida para cerrar el programa */
    private final JButton bsalir = new JButton("Salir");

    public VistaMenuPrincipal() {
        setBounds(250, 150, 1000, 600);
        setResizable(true);
        setTitle("Generador de teclados PROP");

        alfabeto.add(agregar_borrarA);
        alfabeto.add(consultar_modificarA);
        texto.add(agregar_borrarTxt);
        texto.add(consultar_modificarTxt);
        asociacion.add(agregar_borrarAT);
        asociacion.add(consultar_modificarAT);
        teclado.add(agregar_borrarT);
        teclado.add(consultar_modificarT);

        // Títol finestra
        tituloVista.setBounds(40, 20, 200, 30);
        add(tituloVista);

        // Botón alfabeto
        alfabeto.setBounds(400, 100, 200, 20);
        add(alfabeto);

        // Botón texto
        texto.setBounds(400, 200, 200, 20);
        add(texto);

        // Botón asociación textos
        asociacion.setBounds(400, 300, 200, 20);
        add(asociacion);

        // Botón teclado
        teclado.setBounds(400, 400, 200, 20);
        add(teclado);

        // Botón salir
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lAgregarEliminarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAsociacionTextosAB();
                setVisible(false);
            }
        };

        ActionListener lAgregarEliminarTxt = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTextoAB();
                setVisible(false);
            }
        };

        ActionListener lAgregarEliminarAT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAsociacionTextosAB();
                setVisible(false);
            }
        };

        ActionListener lAgregarEliminarT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTecladoAB();
                setVisible(false);
            }
        };

        ActionListener lConsultarModificarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAlfabetoCM();
                setVisible(false);
            }
        };

        ActionListener lConsultarModificarTxt = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTextoCM();
                setVisible(false);
            }
        };

        ActionListener lConsultarModificarAT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAsociacionTextosCM();
                setVisible(false);
            }
        };

        ActionListener lConsultarModificarT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTecladoCM();
                setVisible(false);
            }
        };

        ActionListener salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        bsalir.addActionListener(salir);

        agregar_borrarA.addActionListener(lAgregarEliminarA);
        consultar_modificarA.addActionListener(lConsultarModificarA);
        agregar_borrarTxt.addActionListener(lAgregarEliminarTxt);
        consultar_modificarTxt.addActionListener(lConsultarModificarTxt);
        agregar_borrarAT.addActionListener(lAgregarEliminarAT);
        consultar_modificarAT.addActionListener(lConsultarModificarAT);
        agregar_borrarT.addActionListener(lAgregarEliminarT);
        consultar_modificarT.addActionListener(lConsultarModificarT);
    }


}
