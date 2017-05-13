package Modelo;

/**
 * Clase producto con información sobre él
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class Producto {
    
    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private String color;
    private String descripcion;
    private int stock;
    private String imagen;

    /**
     * Constructor que crea el objeto con sus datos
     * @param id ID del producto
     * @param marca Marca del producto
     * @param modelo Modelo del producto
     * @param precio Precio del producto
     * @param color Color del producto
     * @param descripcion Descripción del producto
     * @param stock Stock del producto
     * @param imagen Nombre del archivo de imagen en la carpeta Imagenes/Productos/
     */
    public Producto(int id, String marca, String modelo, double precio, String color, String descripcion, int stock, String imagen) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.color = color;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
    }

    /**
     * Devuelve la ID del producto
     * @return ID del producto
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica la ID del producto
     * @param id ID del producto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve la marca del producto
     * @return Marca del producto
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Modifica la marca del producto
     * @param marca Marca del producto
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve el modelo del producto
     * @return Modelo del producto
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Modifica el modelo del producto
     * @param modelo Modelo del producto
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve el precio del producto
     * @return Precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Modifica el precio del producto
     * @param precio Precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve el color del producto
     * @return Color del producto
     */
    public String getColor() {
        return color;
    }

    /**
     * Modifica el color del producto
     * @param color Color del producto
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve la descripción del producto
     * @return Descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modifica la descripción del producto
     * @param descripcion Descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el stock del producto
     * @return Stock del producto
     */
    public int getStock() {
        return stock;
    }

    /**
     * Modifica el stock del producto
     * @param stock Stock del producto
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve el nombre de la imagen del producto
     * @return Nombre de la imagen del producto
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Modifica el nombre de la imagen del producto
     * @param imagen Nombre de la imagen del producto en la carpeta Imagenes/Productos/
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
