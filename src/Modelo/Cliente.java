package Modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public final class Cliente{
    
    private int id;
    private String nombreUsuario;
    private String contrasenya;
    private String fechaRegistro;
    private String nombre;
    private String apellidos;
    private int permisos;
    private ArrayList<Pedido> pedidosRealizados;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private String dni;
    private ArrayList<Producto> cesta;

    public Cliente(int id, String nombreUsuario, String contrasenya, String fechaRegistro, String nombre, String apellidos, int permisos, ArrayList<Pedido> pedidosRealizados, String direccion, String telefono, String fechaNacimiento, String dni, ArrayList<Producto> cesta) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasenya = contrasenya;
        this.fechaRegistro = fechaRegistro;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.permisos = permisos;
        this.pedidosRealizados = pedidosRealizados;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.cesta = cesta;
    }

    public ArrayList<Pedido> getPedidosRealizados() {
        return pedidosRealizados;
    }

    public void setPedidosRealizados(ArrayList<Pedido> pedidosRealizados) {
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

    public ArrayList<Producto> getCesta() {
        return cesta;
    }

    public void setCesta(ArrayList<Producto> cesta) {
        this.cesta = cesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getPermisos() {
        return permisos;
    }

    public void setPermisos(int permisos) {
        this.permisos = permisos;
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
    
    public static boolean comprobarDNI(String dni) {
        dni = dni.replace("-", "").replace(" ", "");
        boolean valido = false;
        int numeroDNI = -1;
        if (dni.length() == 9) {
            numeroDNI = Integer.parseInt(dni.substring(0, 8));
            if(calcularLetraDNI(numeroDNI).toUpperCase().equals(dni.substring(8).toUpperCase()))
                valido = true;
        }
        return valido;
    }

    private static String calcularLetraDNI(int numeroDNI) {
        int resto = numeroDNI % 23;
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE", letra = null;
        try{
            letra = letrasDNI.substring(resto, resto + 1);
        } catch (IndexOutOfBoundsException ex){
            letra = null;
        }
        return letra;
    }
}
