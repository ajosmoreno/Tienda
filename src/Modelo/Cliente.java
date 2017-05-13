package Modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Clase Cliente de los que se crearán objetos para identificarlos en el sistema
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

    /**
     * Constructor que recibe los datos del cliente
     * @param id ID del cliente
     * @param nombreUsuario Nombre de usuario del cliente
     * @param contrasenya Contraseña del cliente
     * @param fechaRegistro Fecha de registro del cliente
     * @param nombre Nombre del cliente
     * @param apellidos Apellidos del cliente
     * @param permisos Permisos del cliente
     * @param pedidosRealizados Pedidos del cliente
     * @param direccion Dirección del cliente
     * @param telefono Teléfono del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     * @param dni DNI del cliente
     * @param cesta Cesta del cliente
     */
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

    /**
     * Devuelve los pedidos realizados por el cliente
     * @return Lista de pedidos del cliente
     */
    public ArrayList<Pedido> getPedidosRealizados() {
        return pedidosRealizados;
    }

    /**
     * Modifica los pedidos realizados del cliente
     * @param pedidosRealizados Lista de pedidos del cliente
     */
    public void setPedidosRealizados(ArrayList<Pedido> pedidosRealizados) {
        this.pedidosRealizados = pedidosRealizados;
    }

    /**
     * Devuelve la dirección del cliente
     * @return Dirección del cliente
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Modifica la dirección del cliente
     * @param direccion Dirección del cliente
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el teléfono del cliente
     * @return Teléfono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Modifica el teléfono del cliente
     * @param telefono Teléfono del cliente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve la fecha de nacimiento del cliente
     * @return Fecha de nacimiento del cliente
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Modifica la fecha de nacimiento del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve el DNI del cliente
     * @return DNI del cliente
     */
    public String getDni() {
        return dni;
    }

    /**
     * Modifica el DNI del cliente
     * @param dni DNI del cliente
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve la cesta del cliente
     * @return Lista de productos de la cesta del cliente
     */
    public ArrayList<Producto> getCesta() {
        return cesta;
    }

    /**
     * Modifica la cesta del cliente
     * @param cesta Lista de productos de la cesta del cliente
     */
    public void setCesta(ArrayList<Producto> cesta) {
        this.cesta = cesta;
    }

    /**
     * Devuelve la ID del cliente
     * @return ID del cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica la ID del cliente
     * @param id ID del cliente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre de usuario del cliente
     * @return Nombre de usuario del cliente
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Modifica el nombre de usuario del cliente
     * @param nombreUsuario Nombre de usuario del cliente
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Devuelve la contraseña encriptada en MD5 del cliente
     * @return Contraseña del cliente
     */
    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * Modifica la contraseña del cliente
     * @param contrasenya Contraseña del cliente
     */
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    /**
     * Devuelve la fecha de registro del cliente
     * @return Fecha de registro del cliente
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Modifica la fecha de registro del cliente
     * @param fechaRegistro Fecha de registro del cliente
     */
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Devuelve el nombre del cliente
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del cliente
     * @param nombre Nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve los apellidos del cliente
     * @return Apellidos del cliente
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Modifica los apellidos del cliente
     * @param apellidos Apellidos del cliente
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Devuelve los permisos del cliente
     * @return Permisos del cliente
     */
    public int getPermisos() {
        return permisos;
    }

    /**
     * Modifica los permisos del cliente
     * @param permisos Permisos del cliente
     */
    public void setPermisos(int permisos) {
        this.permisos = permisos;
    }
    
    /**
     * Método para encriptar una contraeña en MD5
     * @param contrasenya Contraseña sin encriptar
     * @return Contraseña encriptada en MD5
     */
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
    
    /**
     * Método para comprobar el DNI
     * @param dni DNI con la letra en formato XXXXXXXXY
     * @return Devuelve true si el DNI es válido, false si es inválido
     */
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

    /**
     * Método para calcular la letra del DNI
     * @param numeroDNI Número de DNI
     * @return Letra del DNI
     */
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
