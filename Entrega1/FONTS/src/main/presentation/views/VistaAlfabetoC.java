package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Aquesta vista s’encarrega de carregar un fitxer guardat a l’ordinador i obrir-lo. La vista obre l’explorador d’arxius
 * on es podran seleccionar únicament fitxers que el nostre sistema és capaç d’obrir. Es proporciona un botó de
 * cancel·lar que tornarà a la VistaMenuPrincipal i un botó d’obrir que farà que s’obri a la VistaSpreadsheet el fitxer
 * seleccionat.
 * @author Marc Clapés Marana (marc.clapes.marana@estudiantat.upc.edu)
 */
public class VistaAlfabetoC extends JFrame{
    /** Finestra de selecció de l'arxiu que es vol carregar al nostre full de càlcul */
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaAC = new JLabel("Consultar alfabeto");
    /** Título de media ventana */
    private final JLabel tituloVistaAC2 = new JLabel("Consultar lista de alfabetos");
    /** Botón para consultar la lista de alfabetos */
    private final JButton bConsultarListaAlfabetos = new JButton("Consultar lista de alfabetos");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtNombreAC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areanomAC = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtContenido = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areacontenidoAC = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un alfabeto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");


    /** Constructora de la finestra de carregar document */
    public VistaAlfabetoC() {
        // Posar els formats que ens facin falta
        chooser.setFileFilter(new FileNameExtensionFilter("PROP", "csv", "prop", "txt"));
        chooser.setDialogTitle("Selecciona fitxer");
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/subgrup-prop14.3/Entrega1/data/Alfabetos"));
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
        //setTitle("Funcionalidades alfabeto);

        // Título ventana superior
        tituloVistaAC.setBounds(10, 5, 120, 30);
        add(tituloVistaAC);

        // Título media ventana
        tituloVistaAC2.setBounds(10, 400, 200, 30);
        add(tituloVistaAC2);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreAC.setBounds(200, 140, 200, 20);
        add(txtNombreAC);

        // Área texto Nombre
        areanomAC.setEditable(false);
        areanomAC.setBounds(400,140, 200,20);
        add(areanomAC);

        txtContenido.setBounds(200, 180, 200, 20);
        add(txtContenido);

        areacontenidoAC.setEditable(false); // Opcional, si no quieres que se pueda editar el contenido
        JScrollPane scrollPane = new JScrollPane(areacontenidoAC); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 180, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        // Botón consultar lista de Alfabetos
        bConsultarListaAlfabetos.setBounds(700, 400, 200, 20);
        add(bConsultarListaAlfabetos);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        areanomAC.setText(arxiu.getName().substring(0, arxiu.getName().length() - 4));
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

        bConsultarListaAlfabetos.addActionListener(lConsultarListaA);
        bsalir.addActionListener(lSalir);

    }

    private void mostrarContenidoArchivo(File archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            areacontenidoAC.setText("");
            String linea;
            while ((linea = reader.readLine()) != null) {
                areacontenidoAC.append(linea + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
