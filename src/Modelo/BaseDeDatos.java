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
 * Clase BaseDeDatos de la que se creará un objeto para la conexión a esta
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class BaseDeDatos {
    
    private static BaseDeDatos miBBDD = null;
    private Connection conn;
    
    
    private BaseDeDatos() throws ClassNotFoundException, SQLException, Exception{
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mariadb://" + leerConfig("servidor") + ":" + leerConfig("puerto") + "/" + leerConfig("bd") + "?user=" + leerConfig("usuario") + "&password=" + leerConfig("contraseña"));
    }
    
    /**
     * Método que devuelve el objeto de BaseDeDatos
     * @return Objeto de BaseDeDatos
     * @throws ClassNotFoundException Cuando no se encuentra el Driver de la BBDD
     * @throws SQLException Cuando ocurre un error con alguna consulta
     * @throws Exception Cuando el archivo de configuración no está completo
     */
    public static BaseDeDatos baseDeDatos() throws ClassNotFoundException, SQLException, Exception{
        if(miBBDD == null) miBBDD = new BaseDeDatos();
        return miBBDD;
    }
    
    /**
     * Cierra la conexión a la BBDD
     * @throws SQLException Error si no se puede cerrar la conexión
     */
    public void cerrarConexion() throws SQLException{
        conn.close();
    }
    
    /**
     * Método que ejecuta una consulta SELECT a la BBDD
     * @param consulta Consulta a ejecutar
     * @return Resultado de la consulta
     * @throws SQLException Error cuando no se puede ejecutar la consulta
     */
    public ResultSet ejecutarConsultaSelect(String consulta) throws SQLException{
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(consulta);
        stm.close();
        return rs;
    }
    
    /**
     * Método que ejecuta una consulta que no es SELECT a la BBDD
     * @param consulta Consulta a ejecutar
     * @return Resultado de la consulta
     * @throws SQLException Error cuando no se puede ejecutar la consulta
     */
    public ResultSet ejecutarConsulta(String consulta) throws SQLException {
        Statement stm = conn.createStatement();
        int resultado = stm.executeUpdate(consulta);
        ResultSet rs = stm.getGeneratedKeys();
        stm.close();
        if(resultado > 0) return rs;
        else return null;
    }
    
    /**
     * Método para leer los campos de la configuración de la BBDD desde el archivo config.ini
     * @param campo Campo a leer del archivo
     * @return Valor del campo
     * @throws IOException Error cuando no se puede leer el archivo o escribir en él
     * @throws Exception Error cuando el archivo no está completo
     */
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
