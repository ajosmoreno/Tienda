package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class BaseDeDatos {
    
    private static BaseDeDatos miBBDD = null;
    private Connection conn;
    
    private BaseDeDatos() throws ClassNotFoundException, SQLException{
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tienda?user=tienda&password=tienda123");
    }
    
    public static BaseDeDatos baseDeDatos() throws ClassNotFoundException, SQLException{
        if(miBBDD == null) miBBDD = new BaseDeDatos();
        return miBBDD;
    }
    
    public void cerrarConexion() throws SQLException{
        conn.close();
    }
    
    public ResultSet ejecutarConsultaSelect(String consulta) throws SQLException{
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(consulta);
        stm.close();
        return rs;
    }
    
    public int ejecutarConsulta(String consulta) throws SQLException{
        Statement stm = conn.createStatement();
        int resultado = stm.executeUpdate(consulta);
        stm.close();
        return resultado;
    }
}
