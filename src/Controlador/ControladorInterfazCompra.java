package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Producto;
import Modelo.Repositorio;
import Vista.InterfazCompra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorInterfazCompra {
    
    private InterfazCompra miVentana;

    public ControladorInterfazCompra(InterfazCompra miVentana) {
        this.miVentana = miVentana;
    }
    
    public void cargarMarcas() throws SQLException, Exception{
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
            ArrayList<Producto> listaProductos = Repositorio.repositorio().devolverProductos();
            for(Producto p: listaProductos){
                if(p.getMarca().equals(miVentana.getjComboBoxMarca().getSelectedItem())){
                    System.out.println(p.getImagen());
                    dcb.addElement(p.getModelo());
                }
            }
        }
        miVentana.getjComboBoxModelo().setModel(dcb);
    }
}
