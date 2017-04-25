package Modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public final class Cliente extends Usuario{
    
    private int[] pedidosRealizados;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private String dni;
    
    public Cliente(int id, String nombreUsuario, String contrasenya, String fechaRegistro, String nombre, String apellidos, int permisos, int[] pedidosRealizados, String direccion, String telefono, String fechaNacimiento, String dni){
        super(id, nombreUsuario, contrasenya, fechaRegistro, nombre, apellidos, permisos);
        this.pedidosRealizados = pedidosRealizados;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }

    public int[] getPedidosRealizados() {
        return pedidosRealizados;
    }

    public void setPedidosRealizados(int[] pedidosRealizados) {
        this.pedidosRealizados = pedidosRealizados;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public static String encriptarContrasenya(String contrasenya){
        String hashText = "";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(contrasenya.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            hashText = number.toString(16);
            while(hashText.length() < 32) hashText = "0" + hashText;
            
        } catch (NoSuchAlgorithmException ex){
            
        }
        return hashText;
    }
}
