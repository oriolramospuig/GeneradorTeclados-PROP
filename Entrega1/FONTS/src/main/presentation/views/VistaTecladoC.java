package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VistaTecladoC extends JFrame {
    /** Finestra de selecció de l'arxiu que es vol carregar al nostre full de càlcul */
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaTC = new JLabel("Consultar teclado");
    /** Título de media ventana */
    private final JLabel tituloVistaTC2 = new JLabel("Consultar lista de teclados");
    /** Botón para consultar un teclado */
    private final JButton bConsultarTeclado = new JButton("Consultar teclado");
    /** Botón para consultar la lista de teclados */
    private final JButton bConsultarListaTeclados = new JButton("Consultar lista de teclados");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del teclado a consultar*/
    private final JLabel txtNombreTC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del teclado que se quiere consultar */
    private final JTextArea areanomTC = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del teclado a consultar*/
    private final JLabel txtContenidoTC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del teclado que se quiere consultar */
    private final JTextArea areacontenidoTC = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un teclado sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");



    public VistaTecladoC() {
        // Posar els formats que ens facin falta
        chooser.setFileFilter(new FileNameExtensionFilter("PROP", "csv", "prop", "txt"));
        chooser.setDialogTitle("Selecciona fitxer");
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/subgrup-prop14.3/Entrega1/data/Teclados"));
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File arxiu = chooser.getSelectedFile();
            if (arxiu.getName().endsWith(".txt")) {
                imprimirDatos(arxiu);
                // consultarFichero(arxiu.getName().substring(0, arxiu.getName().length() - 4), true);
            }
        } else if (returnValue == JFileChooser.CANCEL_OPTION) {
            CtrlPresentacion.iniPresentacion();
        }
    }

    public void imprimirDatos(File arxiu) {
        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades teclado);

        // Título ventana superior
        tituloVistaTC.setBounds(10, 5, 120, 30);
        add(tituloVistaTC);

        // Título media ventana
        tituloVistaTC2.setBounds(10, 400, 200, 30);
        add(tituloVistaTC2);

        //VENTANA SUPERIOR
        txtNombreTC.setBounds(200, 140, 200, 20);
        add(txtNombreTC);
        // Área texto Nombre
        areanomTC.setEditable(false);
        areanomTC.setBounds(400,140, 200,20);
        add(areanomTC);

        txtContenidoTC.setBounds(200, 180, 200, 20);
        add(txtContenidoTC);

        areacontenidoTC.setEditable(false); // Opcional, si no quieres que se pueda editar el contenido
        JScrollPane scrollPane = new JScrollPane(areacontenidoTC); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 180, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        // Botón consultar lista de Alfabetos
        bConsultarListaTeclados.setBounds(700, 400, 200, 20);
        add(bConsultarListaTeclados);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        areanomTC.setText(arxiu.getName().substring(0, arxiu.getName().length() - 4));
        mostrarContenidoArchivo(arxiu);

        ActionListener lConsultarListaA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        ActionListener lSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        bConsultarListaTeclados.addActionListener(lConsultarListaA);
        bsalir.addActionListener(lSalir);

    }

    private void mostrarContenidoArchivo(File archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            areacontenidoTC.setText("");
            String linea;
            while ((linea = reader.readLine()) != null) {
                areacontenidoTC.append(linea + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
