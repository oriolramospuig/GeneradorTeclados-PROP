package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Esta vista es la encargada de agregar un alfabeto. Se indican claramente 3 campos de texto, pero solo hay que rellenar 2 de estos 3
 * El primer campo es el del nombre del alfabeto a crear. Este es necesario ya que sin el nombre no se puede crear.
 * (el nombre será el identificador del alfabeto). De los otros dos campos hay qe escoger 1.
 * La primera opción es entrar el contenido del alfabeto manualmente, en el cuadro de texto que se proporciona.
 * La segunda opción es adjuntar el path del archivo que se quiere añadir como alfabeto.
 * Solo se puede agregar el alfabeto si: se ha añadido un nombre y si se han rellenado
 * Només es pot crear document si no s’indica almenys la localització on estarà guardat, si no és així salta un
 * missatge d’error conforme no s’ha indicat el path. La localització del document es pot indicar manualment escrita
 * a la barra de text o es pot seleccionar el directori fent clic al botó triar directori, on s’obre l’explorador de
 * documents i es pot seleccionar el directori a guardar el document. A sota de la vista s’hi proporciona també un botó
 * per a tornar al menú principal.
 * @author Andreu Orensanz Bargalló (andreu.orensanz@estudiantat.upc.edu)
 */

public class VistaAlfabetoA extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana */
    private final JLabel tituloVistaAA = new JLabel("Agregar alfabeto");
    /** Botón para agregar un alfabeto */
    private final JButton bAgregarAlfabeto = new JButton("Agregar Alfabeto");
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


    public VistaAlfabetoA(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);
        //setTitle("Funcionalidades alfabeto);

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
        areaContenidoAA.setBounds(450,180, 200,60);
        add(areaContenidoAA);

        // Texto Path
        txtPathAA.setBounds(250, 280, 200, 20);
        add(txtPathAA);

        // Área texto Path
        areaPathAA.setBounds(450,280, 200,20);
        add(areaPathAA);


        //BOTONES
        // Botón agregar Alfabeto
        bAgregarAlfabeto.setBounds(700, 400, 200, 20);
        add(bAgregarAlfabeto);

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
                String path = System.getProperty("user.dir") + "/Entrega1/data/Alfabetos";

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
                    boolean agregado = CtrlPresentacion.agregarAlfabetoPath(nombreAlfabeto, path);
                    // Mensaje de éxito o error
                    if (agregado) {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomAA.setText("");
                        areaContenidoAA.setText("");
                    } else {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: El nombre " + nombreAlfabeto + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    // Convertimos la entrada de string en una lista de characters
                    ArrayList<Character> caracteres = new ArrayList<>();
                    for (char c : contenidoAlfabeto.toCharArray()) caracteres.add(c);

                    boolean agregado = CtrlPresentacion.agregarAlfabetoManual(nombreAlfabeto, caracteres, path);
                    // Mensaje de éxito o error
                    if (agregado) {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        areanomAA.setText("");
                        areaContenidoAA.setText("");
                    } else {
                        JOptionPane.showMessageDialog(VistaAlfabetoA.this, "Error: El nombre " + nombreAlfabeto + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
        bsalir.addActionListener(lSalir);
    }
}
