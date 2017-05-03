package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Cliente;
import Modelo.Repositorio;
import Vista.GestionAdministrador;
import Vista.GestionPedidos;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public void buscarCliente() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<Cliente> listaClientes = Repositorio.repositorio().devolverClientes();
        boolean encontrado = false;
        int contador = 0;
        while(!encontrado && contador < listaClientes.size()){
            Cliente c = listaClientes.get(contador);
            if(c.getNombreUsuario().equals(miVentana.getjTextFieldBuscadorNombre().getText())){
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
                switch(c.getPermisos()){
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
    
    public void modificarUsuario() throws SQLException, Exception{
        if(miVentana.getjTextFieldPassword().getText().equals("")){
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String nombre = miVentana.getjTextFieldNombre().getText();
            String apellidos = miVentana.getjTextFieldApellidos().getText();
            String dni = miVentana.getjTextFieldDni().getText();
            String fechaNacimiento = df.format(miVentana.getjDateChooserNacimiento().getDate());
            String direccion = miVentana.getjTextFieldDireccion().getText();
            String telefono = miVentana.getjTextFieldTelefono().getText();
            int permisos = 0;
            if(miVentana.getjRadioButtonInvitado().isSelected()){
                permisos = 0;
            } else if(miVentana.getjRadioButtonCliente().isSelected()){
                permisos = 1;
            } else if(miVentana.getjRadioButtonAdministrador().isSelected()){
                permisos = 2;
            }
            BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE usuarios SET nombre = '" + nombre + "', apellidos = '" + apellidos + "', direccion = '" + direccion + "', telefono = '" + telefono + "', fechaNacimiento = '" + fechaNacimiento + "', dni = '" + dni + "', permisos = " + permisos + " WHERE usuario = '" + miVentana.getjTextFieldUsuario() + "';");
        } else{
            
        }
    }

    public void eliminarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
