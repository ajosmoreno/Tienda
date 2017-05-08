package Controlador;

import Modelo.Gestor;
import Modelo.Repositorio;
import Vista.GestionGestores;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorGestionGestores {
    
    private GestionGestores miVentana;

    public ControladorGestionGestores(GestionGestores miVentana) {
        this.miVentana = miVentana;
    }
    
    public void añadirGestor() throws ClassNotFoundException, Exception{
        String nombre = miVentana.getjTextFieldNombreGestor().getText();
        String direccion = miVentana.getjTextFieldDireccionGestor().getText();
        String telefono = miVentana.getjTextFieldTelefonoGestor().getText();
        String email = miVentana.getjTextFieldEmailGestor().getText();
        String tipo = miVentana.getjComboBoxTipoGestor().getSelectedItem().toString();
        if(Repositorio.repositorio().añadirGestor(nombre, direccion, telefono, email, tipo)){
            miVentana.mostrarMensaje("Gestor añadido correctamente.");
        } else{
            miVentana.mostrarError("No se ha podido añadir el gestor.");
        }
    }

    public void borrarGestor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cargarGestores() throws ClassNotFoundException, Exception {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        ArrayList<Gestor> listaGestores = Repositorio.repositorio().devolverGestores();
        dcb.addElement("");
        for(Gestor g: listaGestores){
            dcb.addElement(g.getNombre());
        }
        miVentana.getjComboBoxGestores().setModel(dcb);
    }

    public boolean mostrarGestor() throws ClassNotFoundException, Exception {
        boolean mostrado = false;
        Gestor g = Repositorio.repositorio().gestorPorNombre(miVentana.getjComboBoxGestores().getSelectedItem().toString());
        if(g != null){
            mostrado = true;
            miVentana.getjTextFieldNombreGestor().setText(g.getNombre());
            miVentana.getjTextFieldDireccionGestor().setText(g.getDireccion());
            miVentana.getjTextFieldEmailGestor().setText(g.getEmail());
            miVentana.getjTextFieldTelefonoGestor().setText(g.getTelefono());
            if(g.getTipo().equals("Proveedor")) miVentana.getjComboBoxTipoGestor().setSelectedIndex(0);
            else miVentana.getjComboBoxTipoGestor().setSelectedIndex(1);
        }
        return mostrado;
    }
}
