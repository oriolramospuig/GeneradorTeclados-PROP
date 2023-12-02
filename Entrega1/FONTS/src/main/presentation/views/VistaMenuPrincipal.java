package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaMenuPrincipal extends JFrame {

    private final JPanel lamina = new JPanel();
    private final JLabel tituloVista = new JLabel("Generador de teclados PROP");

    private JPopupMenu popupMenuA = new JPopupMenu();
    private JPopupMenu popupMenuTxt = new JPopupMenu();
    private JPopupMenu popupMenuAT = new JPopupMenu();
    private JPopupMenu popupMenuT = new JPopupMenu();

    private JMenuItem agregar_borrarA = new JMenuItem("Agrega/Elimina");
    private JMenuItem consultar_modificarA = new JMenuItem("Consulta/Modifica");

    private JMenuItem agregar_borrarTxt = new JMenuItem("Agrega/Elimina");
    private JMenuItem consultar_modificarTxt = new JMenuItem("Consulta/Modifica");

    private JMenuItem agregar_borrarAT = new JMenuItem("Agrega/Elimina");
    private JMenuItem consultar_modificarAT = new JMenuItem("Consulta/Modifica");

    private JMenuItem agregar_borrarT = new JMenuItem("Agrega/Elimina");
    private JMenuItem consultar_modificarT = new JMenuItem("Consulta/Modifica");

    private JButton bsalir = new JButton("Salir");

    // Botones para mostrar los menús
    private JButton btnAlfabeto = new JButton("Alfabeto");
    private JButton btnTexto = new JButton("Texto");
    private JButton btnAsociacion = new JButton("Asociación de Textos");
    private JButton btnTeclado = new JButton("Teclado");

    public VistaMenuPrincipal() {
        setBounds(250, 150, 1000, 600);
        setResizable(true);
        setTitle("Generador de teclados PROP");

        popupMenuA.add(agregar_borrarA);
        popupMenuA.add(consultar_modificarA);

        popupMenuTxt.add(agregar_borrarTxt);
        popupMenuTxt.add(consultar_modificarTxt);

        popupMenuAT.add(agregar_borrarAT);
        popupMenuAT.add(consultar_modificarAT);

        popupMenuT.add(agregar_borrarT);
        popupMenuT.add(consultar_modificarT);

        // Configurar botones y sus posiciones
        btnAlfabeto.setBounds(400, 100, 200, 20);
        btnTexto.setBounds(400, 200, 200, 20);
        btnAsociacion.setBounds(400, 300, 200, 20);
        btnTeclado.setBounds(400, 400, 200, 20);

        // Añadir botones a la ventana
        add(btnAlfabeto);
        add(btnTexto);
        add(btnAsociacion);
        add(btnTeclado);

        // Título de la ventana
        tituloVista.setBounds(40, 20, 200, 30);
        add(tituloVista);

        // Botón salir
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lAgregarEliminarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAlfabetoAB();
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

        btnAlfabeto.addActionListener(e -> popupMenuA.show(btnAlfabeto, 0, btnAlfabeto.getHeight()));
        btnTexto.addActionListener(e -> popupMenuTxt.show(btnTexto, 0, btnTexto.getHeight()));
        btnAsociacion.addActionListener(e -> popupMenuAT.show(btnAsociacion, 0, btnAsociacion.getHeight()));
        btnTeclado.addActionListener(e -> popupMenuT.show(btnTeclado, 0, btnTeclado.getHeight()));

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
