package Controlador;

import Modelo.Cliente;
import Modelo.Repositorio;
import Vista.GestionAdministrador;
import Vista.GestionPedidos;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorGestionAdministrador {
    
    private GestionAdministrador miVentana;

    public ControladorGestionAdministrador(GestionAdministrador miVentana) {
        this.miVentana = miVentana;
    }

    public void abrirGestionPedidos() {
        GestionPedidos gPedidos = new GestionPedidos((Frame)miVentana.getParent(), true);
        gPedidos.setVisible(true);
    }

    public void buscarCliente() throws SQLException, ClassNotFoundException {
        ArrayList<Cliente> listaClientes = Repositorio.repositorio().devolverClientes();
        boolean encontrado = false;
        int contador = 0;
        while(!encontrado && contador < listaClientes.size()){
            Cliente c = listaClientes.get(contador);
            if(c.getNombreUsuario().equals(miVentana.getjTextFieldBuscadorNombre().getText())){
                encontrado = true;
                miVentana.mostrarError(c.getNombre());
                miVentana.getjTextFieldNombre().setText(c.getNombre());
                miVentana.getjTextFieldApellidos().setText(c.getApellidos());
                miVentana.getjTextFieldDni().setText(c.getDni());
                
                //miVentana.getjDateChooserNacimiento().getDateEditor().setDate(new )
            }
            contador++;
        }
        if(!encontrado){
            miVentana.mostrarError("El usuario introducido no existe.");
        }
    }
}
