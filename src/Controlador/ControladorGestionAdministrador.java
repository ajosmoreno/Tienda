package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Cliente;
import Modelo.Repositorio;
import Vista.GestionAdministrador;
import Vista.GestionPedidos;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

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
        GestionPedidos gPedidos = new GestionPedidos((Frame) miVentana.getParent(), true);
        gPedidos.setVisible(true);
    }

    public void buscarCliente() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<Cliente> listaClientes = Repositorio.repositorio().devolverClientes();
        boolean encontrado = false;
        int contador = 0;
        while (!encontrado && contador < listaClientes.size()) {
            Cliente c = listaClientes.get(contador);
            if (c.getNombreUsuario().equals(miVentana.getjTextFieldBuscadorNombre().getText())) {
                encontrado = true;
                miVentana.getjTextFieldNombre().setText(c.getNombre());
                miVentana.getjTextFieldApellidos().setText(c.getApellidos());
                miVentana.getjTextFieldDni().setText(c.getDni());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                miVentana.getjDateChooserNacimiento().getDateEditor().setDate(formatter.parse(c.getFechaNacimiento()));
                miVentana.getjDateChooserNacimiento().getDateEditor().setEnabled(false);
                miVentana.getjTextFieldDireccion().setText(c.getDireccion());
                miVentana.getjTextFieldTelefono().setText(c.getTelefono());
                miVentana.getjTextFieldUsuario().setText(c.getNombreUsuario());
                miVentana.getjTextFieldUsuario().setEditable(false);
                miVentana.getjTextFieldPassword().setText(null);
                switch (c.getPermisos()) {
                    case 0:
                        miVentana.getjRadioButtonInvitado().setSelected(true);
                        break;
                    case 1:
                        miVentana.getjRadioButtonCliente().setSelected(true);
                        break;
                    case 2:
                        miVentana.getjRadioButtonAdministrador().setSelected(true);
                        break;
                }
            }
            contador++;
        }
    }

    public void modificarUsuario() throws SQLException, Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String nombre = miVentana.getjTextFieldNombre().getText();
        String apellidos = miVentana.getjTextFieldApellidos().getText();
        String dni = miVentana.getjTextFieldDni().getText();
        String fechaNacimiento = df.format(miVentana.getjDateChooserNacimiento().getDate());
        String direccion = miVentana.getjTextFieldDireccion().getText();
        String telefono = miVentana.getjTextFieldTelefono().getText();
        int permisos = 0;
        if (miVentana.getjRadioButtonCliente().isSelected()) {
            permisos = 1;
        } else if (miVentana.getjRadioButtonAdministrador().isSelected()) {
            permisos = 2;
        }
        ResultSet rs;
        if (miVentana.getjTextFieldPassword().getText().equals("")) {
            rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE usuarios SET nombre = '" + nombre + "', apellidos = '" + apellidos + "', direccion = '" + direccion + "', telefono = '" + telefono + "', fechaNacimiento = '" + fechaNacimiento + "', dni = '" + dni + "', permiso = " + permisos + " WHERE usuario = '" + miVentana.getjTextFieldUsuario().getText() + "';");
        } else {
            String contrasenya = Cliente.encriptarContrasenya(miVentana.getjTextFieldPassword().getText());
            rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE usuarios SET contrasenya = '" + contrasenya + "', nombre = '" + nombre + "', apellidos = '" + apellidos + "', direccion = '" + direccion + "', telefono = '" + telefono + "', fechaNacimiento = '" + fechaNacimiento + "', dni = '" + dni + "', permiso = " + permisos + " WHERE usuario = '" + miVentana.getjTextFieldUsuario().getText() + "';");
        }
        if(rs != null){
            Repositorio.repositorio().cargarClientes();
            miVentana.mostrarMensaje("¡Usuario modificado correctamente!");  
        }
        else miVentana.mostrarError("Ha ocurrido un error al modificar el usuario.");
    }

    public void eliminarUsuario() throws SQLException, Exception {
        String usuario = miVentana.getjTextFieldUsuario().getText();
        int dialogResult = JOptionPane.showConfirmDialog(miVentana, "¿Estás seguro de que quieres borrar el usuario " + usuario + "?", "¡Atención!", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM usuarios WHERE usuario = '" + usuario + "';");
            if(rs != null){
                Repositorio.repositorio().cargarClientes();
                miVentana.limpiarCampos();
                miVentana.modificarUsuarioPaneles();
                miVentana.mostrarMensaje("Usuario eliminado correctamente.");
            } else miVentana.mostrarError("Ha ocurrido un error al modificar el usuario.");
        }
    }
}
