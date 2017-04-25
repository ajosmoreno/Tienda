package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Cliente;
import Vista.RegistroUsuarios;
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
        miRegistro.getjDateChoosernacimiento().getDateEditor().setEnabled(false);
    }
    
    public void registrar() throws ClassNotFoundException, SQLException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String usuario = miRegistro.getjTextFieldnombreusuario().getText();
        String contrasenya = new String(miRegistro.getjPasswordFieldusuario().getPassword());
        String nombre = miRegistro.getjTextFieldnombre().getText();
        String apellidos = miRegistro.getjTextFieldapellidos().getText();
        String dni = miRegistro.getjTextFielddni().getText();
        String fechaNacimiento = df.format(miRegistro.getjDateChoosernacimiento().getDate());
        String direccion = miRegistro.getjTextFielddireccion().getText();
        String telefono = miRegistro.getjTextFieldtelefono().getText();
        int resultado = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO usuarios (usuario, contrasenya, nombre, apellidos, direccion, telefono, fechaNacimiento, dni, permiso) VALUES ('" + usuario +"', '" + Cliente.encriptarContrasenya(contrasenya) + "', '" + nombre + "', '" + apellidos + "', '" + direccion + "', '" + telefono + "', '" + fechaNacimiento + "', '" + dni + "', 1);");
        if(resultado > 0){ 
            miRegistro.mostrarMensaje("Usuario registrado correctamente.");
            miRegistro.dispose();
        }
    }
}
