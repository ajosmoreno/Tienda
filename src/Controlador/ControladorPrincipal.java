package Controlador;

import Modelo.Cliente;
import Modelo.Repositorio;
import Vista.Opciones;
import Vista.PanelPrincipal;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorPrincipal {
    
    private PanelPrincipal miVentana;

    public ControladorPrincipal(PanelPrincipal miVentana) {
        this.miVentana = miVentana;
    }
    
    public void inicializarDatos() throws SQLException, ClassNotFoundException{
        Repositorio.repositorio().cargarDatos();
    }
    
    public void iniciarSesion() throws SQLException, ClassNotFoundException{
        boolean encontrado = false;
        String usuario = miVentana.getjTextFieldusuario().getText();
        String contrasenya = new String(miVentana.getjPasswordFieldusuario().getPassword());
        ArrayList<Cliente> listaClientes = Repositorio.repositorio().devolverClientes();
        for(Cliente c: listaClientes){
            if(c.getNombreUsuario().equals(usuario)){
                encontrado = true;
                if(c.getContrasenya().equals(Cliente.encriptarContrasenya(contrasenya))){
                    Opciones op = new Opciones(miVentana, true);
                    miVentana.setVisible(false);
                    op.setVisible(true);
                } else{
                    miVentana.mostrarError("La contraseña introducida no es correcta.");
                }
            }
        }
        if(!encontrado) miVentana.mostrarError("El usuario introducido no existe.");
    }
}
