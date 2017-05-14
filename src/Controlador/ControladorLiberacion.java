package Controlador;

import Modelo.Gestor;
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.AnadirLiberacion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *  Clase que accederá al modelo
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorLiberacion {
    
    private AnadirLiberacion miVentana;

    /**
     * Constructor que enlaza el controlador con la vista
     * @param miVentana Vista AnadirLiberacion
     */
    public ControladorLiberacion(AnadirLiberacion miVentana) {
        this.miVentana = miVentana;
    }

    /**
     * Carga los operadores disponibles
     * @throws ClassNotFoundException Error cuando no se encuentran 
     * @throws Exception Error cuando falla otra cosa 
     */
    public void cargarOperadores() throws ClassNotFoundException, Exception {
        ArrayList<Gestor> listaGestores = Repositorio.repositorio().devolverGestores();
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        dcm.addElement("");
        for(Gestor g: listaGestores){
            if(g.getTipo().equals("Operador"))
                dcm.addElement(g.getNombre());
        }
        miVentana.getjComboBoxOperadores().setModel(dcm);
    }

    /**
     * Añade la liberación
     * @return True si se ha añadido, false si no
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public boolean añadirLiberacion() throws ClassNotFoundException, Exception {
        miVentana.mostrarMensaje("Introduzca su tarjeta de crédito/débito en el lector y pulse aceptar.");
        JOptionPane.showInputDialog("Introduzca el pin de la tarjeta");
        int idCliente = Sesion.miCliente().getCliente().getId();
        double total = Double.parseDouble(miVentana.getjLabelPrecioTotal().getText().replace(" €", ""));
        double subtotal = total * 0.79;
        int idGestor = Repositorio.repositorio().gestorPorNombre(miVentana.getjComboBoxOperadores().getSelectedItem().toString()).getId();
        String imei = miVentana.getjTextFieldImei().getText();
        return Repositorio.repositorio().generarLiberacion(idCliente, subtotal, total, "Tarjeta", idGestor, imei) > 0;
    }
}
