package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Gestor;
import Modelo.Producto;
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.InterfazCompra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT distinct marca FROM productos WHERE stock > 0;");
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        dcb.addElement("");
        while(rs.next()){
            dcb.addElement(rs.getString("marca"));
        }
        miVentana.getjComboBoxMarca().setModel(dcb);
    }

    public void mostrarModelos() throws ClassNotFoundException, Exception {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();    
        if(!miVentana.getjComboBoxMarca().getSelectedItem().equals("")){
            dcb.addElement("");
            ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT modelo FROM productos WHERE marca = '" + miVentana.getjComboBoxMarca().getSelectedItem() + "' GROUP BY modelo;");
            while(rs.next()){
                dcb.addElement(rs.getString("modelo"));
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
        miVentana.getjLabelImagen().setIcon(new ImageIcon("Imagenes/Productos/" + productoSeleccionado.getImagen()));
        
    }
    
    public void vaciarCaracteristicas(){
        miVentana.getjTextAreaCaracteristicas().setText("");
        miVentana.getjLabelPrecioTotal().setText("");
        miVentana.getjLabelImagen().setIcon(null);
    }
    
    public void habilitarBotones(){
        if(Sesion.miCliente().getCliente().getPermisos() == 1){
            miVentana.getjButtonAñadirCesta().setEnabled(true);
        }
    }
    
    public void deshabilitarBotones(){
        miVentana.getjButtonAñadirCesta().setEnabled(false);
    }
}