 package Controlador;

import Modelo.Repositorio;
import Vista.RegistroUsuarios;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *  Clase que accederá al modelo
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorRegistro {
    
    private RegistroUsuarios miRegistro;
    
    /**
     * Constructor que enlaza el controlador con la vista
     * @param miRegistro Vista RegistroUsuarios
     */
    public ControladorRegistro(RegistroUsuarios miRegistro){
        this.miRegistro = miRegistro;
        miRegistro.getjDateChooserNacimiento().getDateEditor().setEnabled(false);
    }
    
    /**
     * Registra el usuario 
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     * @throws Error al ejecutar alguna consulta SQL
     */
    public void registrar() throws ClassNotFoundException, SQLException, Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String usuario = miRegistro.getjTextFieldNombreUsuario().getText();
        String contrasenya = new String(miRegistro.getjPasswordFieldContrasenya().getPassword());
        String nombre = miRegistro.getjTextFieldNombre().getText();
        String apellidos = miRegistro.getjTextFieldApellidos().getText();
        String dni = miRegistro.getjTextFieldDni().getText();
        String fechaNacimiento = df.format(miRegistro.getjDateChooserNacimiento().getDate());
        String direccion = miRegistro.getjTextFieldDireccion().getText();
        String telefono = miRegistro.getjTextFieldTelefono().getText();
        if(Repositorio.repositorio().registrarCliente(usuario, contrasenya, nombre, apellidos, dni, fechaNacimiento, direccion, telefono, 1))
            miRegistro.mostrarMensaje("Usuario registrado correctamente.");
        else
            miRegistro.mostrarError("No se ha podido registrar el usuario.");
    }
}
