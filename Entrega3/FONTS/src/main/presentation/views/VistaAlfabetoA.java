package main.presentation.views;

import main.domain.controllers.CtrlDominio;
import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Esta vista es la encargada de agregar un alfabeto. Se indican claramente 3 campos de texto, pero solo hay que rellenar 2 de estos 3
 * El primer campo es el del nombre del alfabeto a crear. Este es necesario ya que sin el nombre no se puede crear.
 * (el nombre será el identificador del alfabeto). De los otros dos campos hay qe escoger 1.
 * La primera opción es entrar el contenido del alfabeto manualmente, en el cuadro de texto que se proporciona.
 * La segunda opción es adjuntar el path del archivo que se quiere añadir como alfabeto.
 * Solo se puede agregar el alfabeto si: se ha añadido un nombre y si se han rellenado uno de los dos campos (contenido o path).
 * De no ser así, se muestra un mensaje de error avisando al usuario qué le falta para poder agregar de forma correcta el alfabeto deseado..
 * Hay que tener en cuenta que se comprobará que el nombre no exista en otro alfabeto ya creado,
 * por lo que el nombre que se escriba debe ser nuevo, no debe coincidir con un alfabeto ya existente.
 * Debajo de las áreas de texto se proporciona un botón para agregar el alfabeto con la información introducida.
 * Más también hay un botón con la opción de volver al menú principal.
 * @author
 */

public class VistaAlfabetoA extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana */
    private final JLabel tituloVistaAA = new JLabel("Agregar alfabeto");
    /** Botón para agregar un alfabeto */
    private final JButton bAgregarAlfabeto = new JButton("Agregar Alfabeto");
    /** Botón para agregar un archivo */
    private final JButton bSeleccionarArchivo = new JButton("Seleccionar Archivo");
    /** Botón de volver a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre del alfabeto */
    private final JLabel txtNombreAA = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre del alfabeto que se quiere crear */
    private final JTextArea areanomAA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el contenido del alfabeto */
    private final JLabel txtContenidoAA = new JLabel("CONTENIDO:");
    /** Área de texto para introducir el contenido del alfabeto que se quiere crear */
    private final JTextArea areaContenidoAA = new JTextArea();
    /** Texto indicando que la barra de texto de al lado es para introducir el path del alfabeto, para saber donde esta guardado */
    private final JLabel txtPathAA = new JLabel("PATH:");
    /** Área de texto para introducir el path del alfabeto que se quiere crear */
    private final JTextArea areaPathAA = new JTextArea();
    /** Texto explicando las instrucciones de como entrar el alfabeto correctamente */
    private final JLabel txtInstruccionesA = new JLabel("(Hay que añadir el contenido con todos los carácteres juntos y sin repetir.");
    private final JLabel txtInstruccionesA1 = new JLabel("Si desea el espacio como carácter, hay que añadirlo también en el contenido. Ej: Abdf i%67)");

    public VistaAlfabetoA(){

        System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
        setBounds(250, 150, 1000, 600);

        // Título ventana superior
        tituloVistaAA.setBounds(10, 5, 120, 30);
        add(tituloVistaAA);

        // Texto Nombre
        txtNombreAA.setBounds(250, 140 , 200, 20);
        add(txtNombreAA);

        // Área texto Nombre
        areanomAA.setBounds(450,140, 200,20);
        add(areanomAA);

        // Texto Contenido
        txtContenidoAA.setBounds(250, 180, 200, 20);
        add(txtContenidoAA);

        // Área texto Contenido
        JScrollPane scrollPaneC = new JScrollPane(areaContenidoAA);
        scrollPaneC.setBounds(450, 180, 200, 60);
        add(scrollPaneC);

        // Texto Path
        txtPathAA.setBounds(250, 280, 200, 20);
        add(txtPathAA);

        // Área texto Path
        JScrollPane scrollPane = new JScrollPane(areaPathAA);
        scrollPane.setBounds(450, 280, 200, 60);
        add(scrollPane);

        // Texto Instrucciones
        txtInstruccionesA.setBounds(30, 340, 600, 20);
        add(txtInstruccionesA);
        txtInstruccionesA1.setBounds(30, 360, 600, 20);
        add(txtInstruccionesA1);


        //BOTONES
        // Botón agregar Alfabeto
        bAgregarAlfabeto.setBounds(700, 400, 200, 20);
        add(bAgregarAlfabeto);

        bSeleccionarArchivo.setBounds(660, 280, 150, 20);
        add(bSeleccionarArchivo);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**  */
        ActionListener lAgregar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAlfabeto = areanomAA.getText().trim();
                String contenidoAlfabeto = areaContenidoAA.getText();
                String pathArchivo = areaPathAA.getText();

                // Verificar que el nombre no esté vacío
                if (nombreAlfabeto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: No Nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar que haya contenido proporcionado
                if (contenidoAlfabeto.isEmpty() && pathArchivo.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: Añade contenido o seleccione archivo que contenga un alfabeto", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if (contenidoAlfabeto.isEmpty()) {
                    boolean agregado = false;
                    try {
                        //agregado = CtrlPresentacion.agregarAlfabetoPath(nombreAlfabeto, pathArchivo);
                        agregado = CtrlDominio.agregarAlfabetoPath(nombreAlfabeto, pathArchivo);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    // Mensaje de éxito o error
                    if (agregado) {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomAA.setText("");
                        areaContenidoAA.setText("");
                        CtrlPresentacion.guardaAlfabetos();
                    } else {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: El nombre " + nombreAlfabeto + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (pathArchivo.isEmpty()){
                    // Convertimos la entrada de string en una lista de characters
                    ArrayList<Character> caracteres = new ArrayList<>();
                    for (char c : contenidoAlfabeto.toCharArray()) caracteres.add(c);
                    boolean agregado = CtrlPresentacion.agregarAlfabetoManual(nombreAlfabeto, caracteres);
                    // Mensaje de éxito o error
                    if (agregado) {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomAA.setText("");
                        areaContenidoAA.setText("");
                        CtrlPresentacion.guardaAlfabetos();
                    } else {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: El nombre " + nombreAlfabeto + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: No puede haber contenido y path a la vez, solo uno de los dos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        };

        ActionListener lSeleccionarArchivo = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un JFileChooser que se abre en la carpeta data/InputFiles/Alfabetos
                JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "//Entrega3//data//InputFiles//Alfabetos//");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo de Texto", "txt"));

                // Mostrar el diálogo de selección de archivos
                int seleccion = fileChooser.showOpenDialog(VistaAlfabetoA.this);

                // Manejar la selección de archivos
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();
                    System.out.println(archivoSeleccionado.getPath());
                    areaPathAA.setText(archivoSeleccionado.getPath());
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

        bAgregarAlfabeto.addActionListener(lAgregar);
        bSeleccionarArchivo.addActionListener(lSeleccionarArchivo);
        bsalir.addActionListener(lSalir);
    }
}
