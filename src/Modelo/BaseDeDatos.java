package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    private BaseDeDatos() throws ClassNotFoundException, SQLException, Exception{
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mariadb://" + leerConfig("servidor") + ":" + leerConfig("puerto") + "/" + leerConfig("bd") + "?user=" + leerConfig("usuario") + "&password=" + leerConfig("contraseña"));
    }
    
    public static BaseDeDatos baseDeDatos() throws ClassNotFoundException, SQLException, Exception{
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
    
    public ResultSet ejecutarConsulta(String consulta) throws SQLException {
        Statement stm = conn.createStatement();
        int resultado = stm.executeUpdate(consulta);
        ResultSet rs = stm.getGeneratedKeys();
        stm.close();
        if(resultado > 0) return rs;
        else return null;
    }
    
    public String leerConfig(String campo) throws IOException, Exception{
        String valor = null;
        File archivo = new File("config.ini");
        if(!archivo.exists()){
            archivo.createNewFile();
            PrintWriter pw = new PrintWriter(new FileWriter(archivo));
            pw.println("#Configuración Base de Datos");
            pw.println("servidor=");
            pw.println("puerto=");
            pw.println("usuario=");
            pw.println("contraseña=");
            pw.println("bd=");
            pw.close();
            throw new Exception("El archivo de configuración no está completo.");
        } else{
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            boolean encontrado = false;
            while(linea != null && !encontrado){
                if(linea.startsWith(campo)){
                    try{
                        encontrado = true;
                        valor = linea.split("=")[1];
                    } catch(IndexOutOfBoundsException ex){
                        throw new Exception("El archivo de configuración no está completo.");
                    }
                }
                linea = br.readLine();
            }
            br.close();
        }
        return valor;
    }
}
