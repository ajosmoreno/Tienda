 package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Cliente;
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
        System.out.println("Direccion: " + miRegistro.getjTextFieldDireccion().getText());
        String telefono = miRegistro.getjTextFieldTelefono().getText();
        System.out.println("Telefono: " + miRegistro.getjTextFieldTelefono().getText());
        ResultSet res = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO usuarios (usuario, contrasenya, nombre, apellidos, direccion, telefono, fechaNacimiento, dni, permiso) VALUES ('" + usuario +"', '" + Cliente.encriptarContrasenya(contrasenya) + "', '" + nombre + "', '" + apellidos + "', '" + direccion + "', '" + telefono + "', '" + fechaNacimiento + "', '" + dni + "', 1);");
        if(res != null)
            miRegistro.mostrarMensaje("Usuario registrado correctamente.");
        else
            miRegistro.mostrarError("Error al crear el usuario.");
    }
}
