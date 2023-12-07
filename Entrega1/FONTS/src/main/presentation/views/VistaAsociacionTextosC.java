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

public class VistaAsociacionTextosC extends JFrame {
    /** Finestra de selecció de l'arxiu que es vol carregar al nostre full de càlcul */
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaATC = new JLabel("Consultar asociación de textos");
    /** Título de media ventana */
    private final JLabel tituloVistaATC2 = new JLabel("Consultar lista de asociaciones de textos");
    /** Botón para consultar la lista de asociaciones */
    private final JButton bConsultarListaAsociaciones = new JButton("Consultar lista de asociaciones de textos");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación a consultar*/
    private final JLabel txtNombreATC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociación que se quiere consultar */
    private final JTextArea areanomATC = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación a consultar*/
    private final JLabel txtContenidoATC = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre de la asociación que se quiere consultar */
    private final JTextArea areacontenidoATC = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar una asociación sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");



    public VistaAsociacionTextosC() {
        // Posar els formats que ens facin falta
        chooser.setFileFilter(new FileNameExtensionFilter("PROP", "csv", "prop", "txt"));
        chooser.setDialogTitle("Selecciona fitxer");
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/subgrup-prop14.3/Entrega1/data/Asociaciones"));
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

        // Título ventana superior
        tituloVistaATC.setBounds(10, 5, 200, 30);
        add(tituloVistaATC);

        // Título media ventana
        tituloVistaATC2.setBounds(10, 205, 200, 30);
        add(tituloVistaATC2);

        //VENTANA SUPERIOR
        // Área texto Nombre
        areanomATC.setEditable(false);
        areanomATC.setBounds(250,35, 200,20);
        add(areanomATC);

        txtContenidoATC.setBounds(50, 75, 200, 20);
        add(txtContenidoATC);

        areacontenidoATC.setEditable(false); // Opcional, si no quieres que se pueda editar el contenido
        JScrollPane scrollPane = new JScrollPane(areacontenidoATC); // Para agregar scroll al área de texto
        scrollPane.setBounds(250, 75, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        // Botón consultar lista de Alfabetos
        bConsultarListaAsociaciones.setBounds(700, 250, 200, 20);
        add(bConsultarListaAsociaciones);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        areanomATC.setText(arxiu.getName().substring(0, arxiu.getName().length() - 4));
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

        bConsultarListaAsociaciones.addActionListener(lConsultarListaA);
        bsalir.addActionListener(lSalir);

    }

    private void mostrarContenidoArchivo(File archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            areacontenidoATC.setText("");
            String linea;
            while ((linea = reader.readLine()) != null) {
                areacontenidoATC.append(linea + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
