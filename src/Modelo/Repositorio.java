package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Repositorio {
    
    private ArrayList<Cliente> clientes;
    private static Repositorio miRepositorio = null;
    
    private Repositorio() throws SQLException, ClassNotFoundException{
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM usuarios;");
        while(rs.next()){
            ResultSet rsCompras = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM compras WHERE cliente = " + rs.getString("id"));
            ResultSet rsReparaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM reparaciones WHERE cliente = " + rs.getString("id"));
            ResultSet rsLiberaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM reparaciones WHERE cliente = " + rs.getString("id"));
            Cliente c = new Cliente(Integer.parseInt(rs.getString("id")), rs.getString("usuario"), rs.getString("contrasenya"), rs.getString("fechaRegistro"), rs.getString("nombre"), rs.getString("apellidos"), Integer.parseInt(rs.getString("permiso")), "PEDIDOOOOOSSSSSSSSSSSS", rs.getString("direccion"), rs.getString("telefono"), rs.getString("fechaNacimiento"), rs.getString("dni"));
        }
    }
    
    public static Repositorio repositorio() throws SQLException, ClassNotFoundException{
        if(miRepositorio == null) miRepositorio = new Repositorio();
        return miRepositorio;
    }
}
