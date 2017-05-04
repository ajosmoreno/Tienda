package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Gestor;
import Modelo.Producto;
import Modelo.Repositorio;
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

    public ControladorInterfazCompra(InterfazCompra miVentana) {
        this.miVentana = miVentana;
    }
    
    public void mostrarMarcas() throws SQLException, Exception{
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT distinct marca FROM productos;");
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
            ArrayList<Producto> listaProductos = Repositorio.repositorio().devolverProductos();
            for(Producto p: listaProductos){
                if(p.getMarca().equals(miVentana.getjComboBoxMarca().getSelectedItem())){
                    dcb.addElement(p.getModelo());
                }
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

    public void mostrarCaracteristicas() throws ClassNotFoundException, Exception {
        ArrayList<Producto> listaProductos = Repositorio.repositorio().devolverProductos();
        boolean encontrado = false;
        int contador = 0;
        while(!encontrado && contador < listaProductos.size()){
            Producto p = listaProductos.get(contador);
            if(p.getMarca().equals(miVentana.getjComboBoxMarca().getSelectedItem()) && p.getModelo().equals(miVentana.getjComboBoxModelo().getSelectedItem()) && p.getColor().equals(miVentana.getjComboBoxColor().getSelectedItem())){
                encontrado = true;
                miVentana.getjTextAreaCaracteristicas().setText(p.getDescripcion());
                miVentana.getjLabelPrecioTotal().setText("" + p.getPrecio() + "€");
                miVentana.getjLabelImagen().setHorizontalTextPosition(JLabel.LEFT);
                miVentana.getjLabelImagen().setIcon(new ImageIcon("Imagenes/Productos/" + p.getImagen()));
            }
            contador++;
        }
    }
    
    public void vaciarCaracteristicas(){
        miVentana.getjTextAreaCaracteristicas().setText("");
        miVentana.getjLabelPrecioTotal().setText("");
        miVentana.getjLabelImagen().setIcon(null);
    }
}
