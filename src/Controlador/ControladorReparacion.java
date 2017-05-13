package Controlador;

import Modelo.Gestor;
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.AnadirReparacion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
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
    
    public boolean añadirReparacion() throws ClassNotFoundException, Exception {
        int idCliente = Sesion.miCliente().getCliente().getId();
        int idGestor = Repositorio.repositorio().gestorPorNombre(miVentana.getjComboBoxProveedores().getSelectedItem().toString()).getId();
        String diagnostico = "Marca: " + miVentana.getjTextFieldMarca().getText() + "\n" +
                "Modelo: " + miVentana.getjTextFieldModelo().getText() + "\n" +
                "Observaciones: " + miVentana.getjTextAreaObservaciones().getText();
        return Repositorio.repositorio().generarReparacion(idCliente, 0, 0, "Efectivo", idGestor, diagnostico) > 0;
    }
}
