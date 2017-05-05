package Controlador;

import Vista.GestionProductos;
import Vista.VisorImagen;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorGestionProductos {
    
    private GestionProductos miVentana;
    
    public ControladorGestionProductos(GestionProductos miVentana){
        this.miVentana = miVentana;
    }

    public void buscarImagen() throws IOException {
        boolean elegida = true;
        String userDir = System.getProperty("user.home");
        JFileChooser fileChooser = new JFileChooser(userDir + "/Desktop");
        if(JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(miVentana)){
            File archivoElegido = fileChooser.getSelectedFile();
            File archivoEnImagenes = new File("Imagenes/Productos/" + archivoElegido.getName());
            if(!archivoElegido.getAbsolutePath().equals(archivoEnImagenes.getAbsolutePath())){
                if(archivoEnImagenes.exists()){
                    int opcion = JOptionPane.showConfirmDialog(miVentana, "El archivo ya existe en la carpeta de imágenes.\n\n¿Quiere sobreescribirlo?", "Atención", JOptionPane.OK_CANCEL_OPTION);
                    if(opcion == JOptionPane.OK_OPTION){
                        archivoEnImagenes.delete();
                        Files.copy(archivoElegido.toPath(), archivoEnImagenes.toPath());
                    } else{
                        elegida = false;
                        miVentana.mostrarMensaje("Cambia el nombre del fichero y vuelva a intentarlo.");
                    }
                } else{
                    Files.copy(archivoElegido.toPath(), archivoEnImagenes.toPath());
                }
            }
            if(elegida){
                miVentana.getjTextFieldFoto().setText(archivoEnImagenes.getName());
                VisorImagen visor = new VisorImagen((Frame)miVentana.getParent(), true, archivoEnImagenes.getName());
                visor.setVisible(true);
            }
        }
    }
}
