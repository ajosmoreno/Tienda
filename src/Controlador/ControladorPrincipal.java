package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Cliente;
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.GestionAdministrador;
import Vista.Opciones;
import Vista.PanelPrincipal;
import java.sql.SQLException;

/**
 *
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorPrincipal {
    
    private PanelPrincipal miVentana;
    
    public ControladorPrincipal(PanelPrincipal miVentana) {
        this.miVentana = miVentana;
    }
    
    public void inicializarDatos() throws SQLException, ClassNotFoundException, Exception {
        Repositorio.repositorio().inicializarDatos();
    }
    
    public void iniciarSesion() throws SQLException, ClassNotFoundException, Exception {
        String usuario = miVentana.getjTextFieldUsuario().getText();
        String contrasenya = new String(miVentana.getjPasswordFieldContrasenya().getPassword());
        Cliente c = Repositorio.repositorio().clientePorUsuario(usuario);
        if (c != null) {
            if (c.getContrasenya().equals(Cliente.encriptarContrasenya(contrasenya))) {
                switch (c.getPermisos()) {
                    case 0:
                        Sesion.miCliente().setCliente(c);
                        Opciones opInvitado = new Opciones(miVentana, true);
                        opInvitado.setVisible(true);
                        break;                    
                    case 1:
                        Sesion.miCliente().setCliente(c);
                        Opciones op = new Opciones(miVentana, true);
                        op.setVisible(true);
                        break;
                    case 2:
                        Sesion.miCliente().setCliente(c);
                        GestionAdministrador gAdmin = new GestionAdministrador(miVentana, true);
                        gAdmin.setVisible(true);
                        break;
                }
                miVentana.getjTextFieldUsuario().setText("");
                miVentana.getjPasswordFieldContrasenya().setText("");
                Sesion.miCliente().setCliente(null);
            } else {
                miVentana.mostrarError("La contraseña introducida no es correcta.");
            }
        } else{
            miVentana.mostrarError("El usuario introducido no existe.");
        }
    }
    
    public void cerrarConexionBBDD() throws SQLException, ClassNotFoundException, Exception {
        BaseDeDatos.baseDeDatos().cerrarConexion();
    }
    
    public void entrarComoInvitado() throws ClassNotFoundException, Exception {
        Cliente c = Repositorio.repositorio().clientePorUsuario("invitado");
        if (c != null) {
            Sesion.miCliente().setCliente(c);
            Opciones opInvitado = new Opciones(miVentana, true);
            opInvitado.setVisible(true);
            Sesion.miCliente().setCliente(null);
        } else{
            miVentana.mostrarError("No se ha encontrado el usuario invitado.");
        }
    }
}
