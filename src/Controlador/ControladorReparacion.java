package Controlador;

import Modelo.Gestor;
import Modelo.Repositorio;
import Vista.AnadirReparacion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorReparacion {
    
    private AnadirReparacion miVentana;

    public ControladorReparacion(AnadirReparacion miVentana) {
        this.miVentana = miVentana;
    }

    public void cargarProveedores() throws ClassNotFoundException, Exception {
        ArrayList<Gestor> listaGestores = Repositorio.repositorio().devolverGestores();
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        dcm.addElement("");
        for(Gestor g: listaGestores){
            if(g.getTipo().equals("Proveedor"))
                dcm.addElement(g.getNombre());
        }
        miVentana.getjComboBoxProveedores().setModel(dcm);
    }
    
    
}
