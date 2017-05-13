package Modelo;

/**
 * Clase Gestor del que se guardará información
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class Gestor {
    
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String tipo;

    /**
     * Constructor que recibe los datos del gestor
     * @param id ID del gestor
     * @param nombre Nombre del gestor
     * @param direccion Dirección del gestor
     * @param telefono Teléfono del gestor
     * @param email Email del gestor
     * @param tipo Tipo de gestor (Operador, Proveedor)
     */
    public Gestor(int id, String nombre, String direccion, String telefono, String email, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;
    }

    /**
     * Devuelve la ID del gestor
     * @return ID del gestor
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica la ID del gestor
     * @param id ID del gestor
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del gestor
     * @return Nombre del gestor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del gestor
     * @param nombre Nombre del gestor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la direcicón del gestor
     * @return Dirección del gestor
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Modifica la dirección del gestor
     * @param direccion Dirección del gestor
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el teléfono del gestor
     * @return Teléfono del gestor
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Modifica el teléfono del gestor
     * @param telefono Teléfono del gestor
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el email del gestor
     * @return Email del gestor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica el email del gestor
     * @param email Email del gestor
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el tipo de gestor
     * @return Tipo de gestor
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo de gestor
     * @param tipo Tipo de gestor (Operador, Proveedor)
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
