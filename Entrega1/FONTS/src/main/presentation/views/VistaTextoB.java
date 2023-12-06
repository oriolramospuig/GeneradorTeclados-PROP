package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;

public class VistaTextoB {
    private JFrame frame = new JFrame();

    /** Constructora de la ventana de eliminar alfabeto */
    public VistaTextoB() {
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        chooser.setDialogTitle("Selecciona fichero a borrar");
        chooser.setFileFilter(new FileNameExtensionFilter("PROP", "csv", "prop", "txt"));
        /*Revisar el tema del path, depende de cómo se ejecute no hará falta subgrup-prop14.3*/
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/subgrup-prop14.3/Entrega1/INPUT_FILES"));
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            CtrlPresentacion.borrarTexto(chooser.getName(archivo));
            eliminarFichero(archivo);
        } else if (returnValue == JFileChooser.CANCEL_OPTION) {
            CtrlPresentacion.iniPresentacion();
        }
    }

    /**
     * Se borra del sistema el fichero pasado por parámetro i aparece un mensaje conforme se ha realizado correctamente.
     * Sale un mensaje de error en caso que el fichero no exista
     * @param fichero
     */
    private void eliminarFichero(File fichero) {
        JButton bSalir = new JButton("Salir");
        boolean status = fichero.delete();
        if (!status) {
            JDialog fitxerNoExisteix =  new JDialog(frame, "El fichero no existe");
            fitxerNoExisteix.setBounds(800, 300, 400, 200);
            fitxerNoExisteix.setLayout(null);

            JLabel txtFitxerNoExisteix = new JLabel("El fichero " + fichero.getName() + " no existe");
            txtFitxerNoExisteix.setBounds(80, 20, 400, 40);
            bSalir.setVisible(true);
            bSalir.setBounds(150, 110, 100, 30);
            fitxerNoExisteix.add(txtFitxerNoExisteix);
            fitxerNoExisteix.add(bSalir);
            fitxerNoExisteix.setVisible(true);

            ActionListener lSortirFitxerNoExisteix = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fitxerNoExisteix.dispose();
                    fitxerNoExisteix.setVisible(false);
                }
            };
            bSalir.addActionListener(lSortirFitxerNoExisteix);

        } else {
            JDialog fitxerEsborrat =  new JDialog(frame, "Fichero borrado correctamente");
            fitxerEsborrat.setBounds(800, 300, 400, 200);
            fitxerEsborrat.setLayout(null);

            JLabel txtFitxerEsborrat = new JLabel("El fichero " + fichero.getName() + " se ha borrado correctamente");
            txtFitxerEsborrat.setBounds(80, 20, 400, 40);
            bSalir.setVisible(true);
            bSalir.setBounds(150, 110, 100, 30);
            fitxerEsborrat.add(txtFitxerEsborrat);
            fitxerEsborrat.add(bSalir);
            fitxerEsborrat.setVisible(true);

            ActionListener lSortirFitxerEsborrat = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fitxerEsborrat.dispose();
                    fitxerEsborrat.setVisible(false);
                }
            };
            bSalir.addActionListener(lSortirFitxerEsborrat);
        }
    }
}
