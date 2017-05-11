package Controlador;

import Modelo.Gestor;
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.AnadirLiberacion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorLiberacion {
    
    private AnadirLiberacion miVentana;

    public ControladorLiberacion(AnadirLiberacion miVentana) {
        this.miVentana = miVentana;
    }

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
