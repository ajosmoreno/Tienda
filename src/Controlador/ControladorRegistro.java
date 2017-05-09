 package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Cliente;
import Modelo.Repositorio;
import Vista.RegistroUsuarios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorRegistro {
    
    private RegistroUsuarios miRegistro;
    
    public ControladorRegistro(RegistroUsuarios miRegistro){
        this.miRegistro = miRegistro;
        miRegistro.getjDateChooserNacimiento().getDateEditor().setEnabled(false);
    }
    
    public void registrar() throws ClassNotFoundException, SQLException, Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String usuario = miRegistro.getjTextFieldNombreUsuario().getText();
        String contrasenya = new String(miRegistro.getjPasswordFieldUsuario().getPassword());
        String nombre = miRegistro.getjTextFieldNombre().getText();
        String apellidos = miRegistro.getjTextFieldApellidos().getText();
        String dni = miRegistro.getjTextFieldDni().getText();
        String fechaNacimiento = df.format(miRegistro.getjDateChooserNacimiento().getDate());
        String direccion = miRegistro.getjTextFieldDireccion().getText();
        String telefono = miRegistro.getjTextFieldTelefono().getText();
        if(Repositorio.repositorio().registrarUsuario(usuario, contrasenya, nombre, apellidos, dni, fechaNacimiento, direccion, telefono, 1))
            miRegistro.mostrarMensaje("Usuario registrado correctamente.");
        else
            miRegistro.mostrarError("No se ha podido registrar el usuario.");
    }
}
