package Controlador;

import Modelo.Producto;
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.CestaCompra;
import Vista.InterfazCompra;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorInterfazCompra {
    
    private InterfazCompra miVentana;
    private Producto productoSeleccionado;

    public ControladorInterfazCompra(InterfazCompra miVentana) {
        this.miVentana = miVentana;
        if(Sesion.miCliente().getCliente().getPermisos() == 1){
            miVentana.getjButtonCestaCompra().setEnabled(true);
        }
    }
    
    public void mostrarMarcas() throws SQLException, Exception{
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        dcb.addElement("");
        for(String marca: Repositorio.repositorio().obtenerMarcasProductos()){
            dcb.addElement(marca);
        }
        miVentana.getjComboBoxMarca().setModel(dcb);
    }

    public void mostrarModelos() throws ClassNotFoundException, Exception {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();    
        if(!miVentana.getjComboBoxMarca().getSelectedItem().equals("")){
            dcb.addElement("");
            for(String modelo: Repositorio.repositorio().obtenerModelosProductos(miVentana.getjComboBoxMarca().getSelectedItem().toString())){
                dcb.addElement(modelo);
            }
        }
        miVentana.getjComboBoxModelo().setModel(dcb);
    }
    
    public void mostrarColores() throws ClassNotFoundException, Exception{
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        if(!miVentana.getjComboBoxMarca().getSelectedItem().equals("") && !miVentana.getjComboBoxModelo().getSelectedItem().equals("")){
            dcb.addElement("");
            ArrayList<Producto> listaProductos = Repositorio.repositorio().devolverProductos();
            for(Producto p: listaProductos){
                if(p.getMarca().equals(miVentana.getjComboBoxMarca().getSelectedItem()) && p.getModelo().equals(miVentana.getjComboBoxModelo().getSelectedItem())){
                    dcb.addElement(p.getColor());
                }
            }
        }
        miVentana.getjComboBoxColor().setModel(dcb);
    }

    public void seleccionarProducto() throws ClassNotFoundException, Exception{
        ArrayList<Producto> listaProductos = Repositorio.repositorio().devolverProductos();
        productoSeleccionado = null;
        boolean encontrado = false;
        int contador = 0;
        while(!encontrado && contador < listaProductos.size()){
            Producto p = listaProductos.get(contador);
            if(p.getMarca().equals(miVentana.getjComboBoxMarca().getSelectedItem()) && p.getModelo().equals(miVentana.getjComboBoxModelo().getSelectedItem()) && p.getColor().equals(miVentana.getjComboBoxColor().getSelectedItem())){
                productoSeleccionado = p;
            }
            contador++;
        }
    }
    
    public void mostrarCaracteristicas() throws ClassNotFoundException, Exception { 
        miVentana.getjTextAreaCaracteristicas().setText(productoSeleccionado.getDescripcion());
        miVentana.getjLabelPrecioTotal().setText("" + productoSeleccionado.getPrecio() + "€");
        ImageIcon imageIcon = new ImageIcon("Imagenes/Productos/" + productoSeleccionado.getImagen());
        Image image = getScaledImage(imageIcon.getImage(), 380, 380);
        imageIcon = new ImageIcon(image);
        miVentana.getjLabelImagen().setIcon(imageIcon);
        if(productoSeleccionado.getStock() < 1)
            miVentana.getjButtonAñadirCesta().setToolTipText("No hay stock de este producto.");
    }
    
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
    
    public void vaciarCaracteristicas(){
        miVentana.getjTextAreaCaracteristicas().setText("");
        miVentana.getjLabelPrecioTotal().setText("");
        miVentana.getjLabelImagen().setIcon(null);
        miVentana.getjButtonAñadirCesta().setToolTipText("Añadir producto a la cesta de compra.");
    }
    
    public void habilitarBotones(){
        if(Sesion.miCliente().getCliente().getPermisos() == 1 && productoSeleccionado.getStock() > 0){
            miVentana.getjButtonAñadirCesta().setEnabled(true);
        } else{
            deshabilitarBotones();
        }
        
    }
    
    public void deshabilitarBotones(){
        miVentana.getjButtonAñadirCesta().setEnabled(false);
    }
    
    public void añadirCesta() throws SQLException, Exception{
        if(Sesion.miCliente().getCliente().getPermisos() == 1 && Repositorio.repositorio().productoDisponible(productoSeleccionado.getId())){
            if(Repositorio.repositorio().añadirProductoCesta(Sesion.miCliente().getCliente().getId(), productoSeleccionado)){
                miVentana.mostrarMensaje("Producto añadido correctamente a la cesta.");
            } else{
                miVentana.mostrarError("No se ha podido añadir el producto a la cesta.");
            }
            
        } else{
            miVentana.mostrarError("No puedes comprar el producto porque no eres cliente o se ha agotado.");
        }
    }

    public void abrirCesta() {
        if(Sesion.miCliente().getCliente().getPermisos() == 1){
            CestaCompra cesta = new CestaCompra((Frame)miVentana.getParent(), true);
            cesta.setVisible(true);
        } else{
            miVentana.mostrarError("No puedes ir a la cesta porque no eres cliente.");
        }
    }
}
