package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Cliente;
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.GestionAdministrador;
import Vista.MenuCliente;
import Vista.PanelPrincipal;
import java.sql.SQLException;

/**
 *  Clase que accederá al modelo
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorPrincipal {
    
    private PanelPrincipal miVentana;
    
    /**
     * Constructor que enlaza el controlador con la vista
     * @param miVentana Vista PanelPrincipal
     */
    public ControladorPrincipal(PanelPrincipal miVentana) {
        this.miVentana = miVentana;
    }
    
    /**
     * Inicializa los datos de la bbdd al repositorio
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void inicializarDatos() throws SQLException, ClassNotFoundException, Exception {
        Repositorio.repositorio().inicializarDatos();
    }
    
    /**
     * Inicia sesión al usuario introducido
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void iniciarSesion() throws SQLException, ClassNotFoundException, Exception {
        String usuario = miVentana.getjTextFieldUsuario().getText();
        String contrasenya = new String(miVentana.getjPasswordFieldContrasenya().getPassword());
        Cliente c = Repositorio.repositorio().clientePorUsuario(usuario);
        if (c != null) {
            if (c.getContrasenya().equals(Cliente.encriptarContrasenya(contrasenya))) {
                switch (c.getPermisos()) {
                    case 0:
                        Sesion.miCliente().setCliente(c);
                        MenuCliente opInvitado = new MenuCliente(miVentana, true);
                        opInvitado.setVisible(true);
                        break;                    
                    case 1:
                        Sesion.miCliente().setCliente(c);
                        MenuCliente op = new MenuCliente(miVentana, true);
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
    
    /**
     * Cierra la conexión con la base de datos
     * @throws SQLException Error si no se puede cerrar la conexión
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void cerrarConexionBBDD() throws SQLException, ClassNotFoundException, Exception {
        BaseDeDatos.baseDeDatos().cerrarConexion();
    }
    
    /**
     * Inicia sesión con el usuario invitado
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void entrarComoInvitado() throws ClassNotFoundException, Exception {
        Cliente c = Repositorio.repositorio().clientePorUsuario("invitado");
        if (c != null) {
            Sesion.miCliente().setCliente(c);
            MenuCliente opInvitado = new MenuCliente(miVentana, true);
            opInvitado.setVisible(true);
            Sesion.miCliente().setCliente(null);
        } else{
            miVentana.mostrarError("No se ha encontrado el usuario invitado.");
        }
    }
}
