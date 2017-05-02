package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Cliente;
import Modelo.Repositorio;
import Vista.GestionAdministrador;
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
        Repositorio.repositorio().inicializarDatos();
    }
    
    public void iniciarSesion() throws SQLException, ClassNotFoundException{
        boolean encontrado = false;
        String usuario = miVentana.getjTextFieldusuario().getText();
        String contrasenya = new String(miVentana.getjPasswordFieldusuario().getPassword());
        ArrayList<Cliente> listaClientes = Repositorio.repositorio().devolverClientes();
        int contador = 0;
        while(!encontrado && contador < listaClientes.size()){
            Cliente c = listaClientes.get(contador);
            if(c.getNombreUsuario().equals(usuario)){
                encontrado = true;
                if(c.getContrasenya().equals(Cliente.encriptarContrasenya(contrasenya))){
                    switch(c.getPermisos()){
                        case 0:
                            break; 
                        case 1:
                            
                            break;
                        case 2:
                            GestionAdministrador gAdmin = new GestionAdministrador(miVentana, true);
                            miVentana.setVisible(false);
                            gAdmin.setVisible(true);
                            miVentana.setVisible(true);
                            break;
                    }
                } else{
                    miVentana.mostrarError("La contraseña introducida no es correcta.");
                }
            }
            contador++;
        }
        if(!encontrado) miVentana.mostrarError("El usuario introducido no existe.");
    }
    
    public void cerrarConexionBBDD() throws SQLException, ClassNotFoundException{
        BaseDeDatos.baseDeDatos().cerrarConexion();
    }
    
}
