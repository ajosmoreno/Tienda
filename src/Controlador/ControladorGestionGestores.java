package Controlador;

import Modelo.Gestor;
import Modelo.Repositorio;
import Vista.GestionGestores;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *  Clase que accederá al modelo
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorGestionGestores {
    
    private GestionGestores miVentana;

    /**
     * Constructor que enlaza el controlador con la vista
     * @param miVentana Vista GestionGestores
     */
    public ControladorGestionGestores(GestionGestores miVentana) {
        this.miVentana = miVentana;
    }
    
    /**
     * Añade un gestor al repositorio y bbdd
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
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

    /**
     * Borra el gestor seleccionado en la vista
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void borrarGestor() throws ClassNotFoundException, Exception {
        if(Repositorio.repositorio().eliminarGestor(miVentana.getjComboBoxGestores().getSelectedItem().toString())){
            miVentana.mostrarMensaje("Gestor eliminado correctamente");
            miVentana.limpiarCampos();
        } else{
            miVentana.mostrarError("No se ha podido eliminar el gestor.");
        }
    }

    /**
     * Carga los gestores
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa 
     */
    public void cargarGestores() throws ClassNotFoundException, Exception {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        ArrayList<Gestor> listaGestores = Repositorio.repositorio().devolverGestores();
        dcb.addElement("");
        for(Gestor g: listaGestores){
            dcb.addElement(g.getNombre());
        }
        miVentana.getjComboBoxGestores().setModel(dcb);
    }

    /**
     * Muestra el gestor seleccionado
     * @return True si lo ha mostrado, false si no lo encuentra
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
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

    /**
     * Modifica el gestor seleccionado en la vista
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void modificarGestor() throws ClassNotFoundException, Exception {
        String nombre = miVentana.getjTextFieldNombreGestor().getText();
        String direccion = miVentana.getjTextFieldDireccionGestor().getText();
        String telefono = miVentana.getjTextFieldTelefonoGestor().getText();
        String email = miVentana.getjTextFieldEmailGestor().getText();
        String tipo = miVentana.getjComboBoxTipoGestor().getSelectedItem().toString();
        if(Repositorio.repositorio().modificarGestor(Repositorio.repositorio().gestorPorNombre(miVentana.getjComboBoxGestores().getSelectedItem().toString()).getId(), nombre, direccion, telefono, email, tipo)){
            cargarGestores();
            miVentana.getjComboBoxGestores().setSelectedItem(nombre);
        } else{
            miVentana.mostrarError("No se ha podido modificar el gestor.");
        }
        
    }
}
