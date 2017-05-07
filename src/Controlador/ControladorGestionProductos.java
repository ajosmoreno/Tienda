package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Producto;
import Modelo.Repositorio;
import Vista.GestionProductos;
import Vista.VisorImagen;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorGestionProductos {
    
    private GestionProductos miVentana;
    private Producto productoSeleccionado;
    
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
    
    public void añadirProducto() throws SQLException, Exception{
        String marca = miVentana.getjTextFieldMarca().getText();
        String modelo = miVentana.getjTextFieldModelo().getText();
        Double precio = Double.parseDouble(miVentana.getjTextFieldPrecio().getText().replace(",", "."));
        int stock = Integer.parseInt(miVentana.getjTextFieldStock().getText());
        String imagen = miVentana.getjTextFieldFoto().getText();
        String caracteristicas = miVentana.getjTextAreaCarateristicas().getText();
        String color = miVentana.getjTextFieldColor().getText();
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO productos (marca, modelo, precio, color, descripcion, stock, imagen) VALUES ('" + marca + "', '" + modelo + "', " + precio + " , '" + color + "', '" + caracteristicas + "', " + stock +", '" + imagen + "');");
        if(rs != null){
            Repositorio.repositorio().cargarProductos();
            miVentana.mostrarMensaje("Producto añadido al catálogo correctamente.");
            miVentana.limpiarCampos();
        } else{
            miVentana.mostrarError("Ha ocurrido un error al añadir el producto.");
        }
    }
    
    public void cargarProductos() throws ClassNotFoundException, Exception{
        ArrayList<Producto> productos = Repositorio.repositorio().devolverProductos();
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        dcb.addElement("");
        for(Producto p: productos){
            dcb.addElement(p.getId());
        }
        miVentana.getjComboBoxListaProductos().setModel(dcb);
    }
    
    public void mostrarDatosProducto(){
        if(productoSeleccionado != null){
            miVentana.getjTextFieldMarca().setText(productoSeleccionado.getMarca());
            miVentana.getjTextFieldModelo().setText(productoSeleccionado.getModelo());
            miVentana.getjTextFieldColor().setText(productoSeleccionado.getColor());
            miVentana.getjTextFieldFoto().setText(productoSeleccionado.getImagen());
            miVentana.getjTextFieldPrecio().setText(""+productoSeleccionado.getPrecio());
            miVentana.getjTextFieldStock().setText(""+productoSeleccionado.getStock());
            miVentana.getjTextAreaCarateristicas().setText(productoSeleccionado.getDescripcion());
        } else{
            miVentana.mostrarError("No hay ningún producto seleccionado.");
        }
    }
    
    public void seleccionarProducto() throws ClassNotFoundException, Exception{
        ArrayList<Producto> productos = Repositorio.repositorio().devolverProductos();
        boolean encontrado = false;
        int contador = 0;
        productoSeleccionado = Repositorio.repositorio().productoPorID(Integer.parseInt(miVentana.getjComboBoxListaProductos().getSelectedItem().toString()));
    }

    public void modificarProducto() throws SQLException, Exception {
        String marca = miVentana.getjTextFieldMarca().getText();
        String modelo = miVentana.getjTextFieldModelo().getText();
        Double precio = Double.parseDouble(miVentana.getjTextFieldPrecio().getText().replace(",", "."));
        int stock = Integer.parseInt(miVentana.getjTextFieldStock().getText());
        String imagen = miVentana.getjTextFieldFoto().getText();
        String caracteristicas = miVentana.getjTextAreaCarateristicas().getText();
        String color = miVentana.getjTextFieldColor().getText();
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE productos SET marca = '" + marca + "', modelo = '" + modelo + "', precio = " + precio + ", stock = " + stock + ", imagen = '" + imagen + "', descripcion = '" + caracteristicas + "', color = '" + color + "' WHERE id = " + productoSeleccionado.getId());
        if(rs != null){
            Repositorio.repositorio().cargarProductos();
            miVentana.mostrarMensaje("Producto modificado correctamente.");
        } else{
            miVentana.mostrarError("No se ha podido modificar el producto.");
        }
    }

    public void eliminarProducto() throws SQLException, Exception {
        if(mostrarAviso()){
            ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM productos WHERE id = " + productoSeleccionado.getId());
            if(rs != null){
                Repositorio.repositorio().cargarProductos();
                miVentana.mostrarMensaje("Producto eliminado correctamente.");
                miVentana.limpiarCampos();
                cargarProductos();
                miVentana.modificarCampos();
            } else{
                miVentana.mostrarError("No se ha podido eliminar el producto.");
            }
        }
    }
    
    public boolean mostrarAviso(){
        int opcion = JOptionPane.showConfirmDialog(miVentana, "Se va a eliminar el producto " + productoSeleccionado.getId() + ", ¿es correcto?", "Atención", JOptionPane.OK_CANCEL_OPTION);
        return opcion == JOptionPane.OK_OPTION;
    }
}
