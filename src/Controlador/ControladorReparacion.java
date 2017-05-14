package Controlador;

import Modelo.Gestor;
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.AnadirReparacion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *  Clase que accederá al modelo
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorReparacion {
    
    private AnadirReparacion miVentana;

    /**
     * Constructor que enlaza el controlador con la vista
     * @param miVentana Vista AnadirReparacion
     */
    public ControladorReparacion(AnadirReparacion miVentana) {
        this.miVentana = miVentana;
    }

    /**
     * Carga los proveedores disponibles
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
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
    
    /**
     * Añade la reparación
     * @return True si la ha añadido, false si no
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public boolean añadirReparacion() throws ClassNotFoundException, Exception {
        int idCliente = Sesion.miCliente().getCliente().getId();
        int idGestor = Repositorio.repositorio().gestorPorNombre(miVentana.getjComboBoxProveedores().getSelectedItem().toString()).getId();
        String diagnostico = "Marca: " + miVentana.getjTextFieldMarca().getText() + "\n" +
                "Modelo: " + miVentana.getjTextFieldModelo().getText() + "\n" +
                "Observaciones: " + miVentana.getjTextAreaObservaciones().getText();
        return Repositorio.repositorio().generarReparacion(idCliente, 0, 0, "Efectivo", idGestor, diagnostico) > 0;
    }
}
