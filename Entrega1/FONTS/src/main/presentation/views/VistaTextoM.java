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
public class VistaTextoM extends JFrame{
    /** Finestra de selecció de l'arxiu que es vol carregar al nostre full de càlcul */
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana inferior */
    private final JLabel tituloVistaTxtM = new JLabel("Modificar texto");
    private final JButton bModificarTexto = new JButton("Modificar texto");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtNombreTxtM = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areanomTxtM = new JTextArea();

    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto a consultar*/
    private final JLabel txtContenidoTxtM = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere consultar */
    private final JTextArea areacontenidoTxtM = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar un alfabeto sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");


    /** Constructora de la finestra de carregar document */
    public VistaTextoM() {
        // Posar els formats que ens facin falta
        chooser.setFileFilter(new FileNameExtensionFilter("PROP", "csv", "prop", "txt"));
        chooser.setDialogTitle("Selecciona fitxer");
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/Entrega1/data/Textos"));
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
        tituloVistaTxtM.setBounds(10, 5, 120, 30);
        add(tituloVistaTxtM);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTxtM.setBounds(200, 140, 200, 20);
        add(txtNombreTxtM);

        // Área texto Nombre
        areanomTxtM.setBounds(400,140, 200,20);
        add(areanomTxtM);

        txtContenidoTxtM.setBounds(200, 180, 200, 20);
        add(txtContenidoTxtM);

        JScrollPane scrollPane = new JScrollPane(areacontenidoTxtM); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 180, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        // Botón modificar alfabetos
        bModificarTexto.setBounds(700, 400, 200, 20);
        add(bModificarTexto);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        areanomTxtM.setText(arxiu.getName().substring(0, arxiu.getName().length() - 4));
        mostrarContenidoArchivo(arxiu);

        ActionListener lModificarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoNombre = areanomTxtM.getText().trim() + ".txt";
                String nuevoContenido = areacontenidoTxtM.getText();

                File archivoAntiguo = chooser.getSelectedFile();
                File archivoNuevo = new File(archivoAntiguo.getParent(), nuevoNombre);

                // Cambiar el nombre del archivo si es necesario
                if (!archivoAntiguo.getName().equals(nuevoNombre)) {
                    if (!archivoAntiguo.renameTo(archivoNuevo)) {
                        JOptionPane.showMessageDialog(VistaTextoM.this, "No se pudo cambiar el nombre del archivo.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Escribir el nuevo contenido en el archivo
                try (PrintWriter out = new PrintWriter(new FileWriter(archivoNuevo))) {
                    out.print(nuevoContenido);
                    JOptionPane.showMessageDialog(VistaTextoM.this, "Texto modificado con éxito.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(VistaTextoM.this, "Error al escribir en el archivo.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };



        ActionListener lSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        bModificarTexto.addActionListener(lModificarA);
        bsalir.addActionListener(lSalir);

    }

    private void mostrarContenidoArchivo(File archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            areacontenidoTxtM.setText("");
            String linea;
            while ((linea = reader.readLine()) != null) {
                areacontenidoTxtM.append(linea + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
