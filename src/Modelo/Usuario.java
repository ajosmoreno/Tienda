package Modelo;

import java.util.Date;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Usuario {
    
    private int id;
    private String nombreUsuario;
    private String contrasenya;
    private String fechaRegistro;
    private String nombre;
    private String apellidos;
    private int permisos;

    public Usuario(int id, String nombreUsuario, String contrasenya, String fechaRegistro, String nombre, String apellidos, int permisos) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasenya = contrasenya;
        this.fechaRegistro = fechaRegistro;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.permisos = permisos;
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
}
