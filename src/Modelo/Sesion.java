package Modelo;

/**
 * Clase Sesion en la que se almacenará el usuario que ha iniciado sesión
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class Sesion {
    
    private Cliente cliente;
    private static Sesion miSesion = null;
    
    private Sesion(){
    }
    
    /**
     * Devuelve el objeto Sesion
     * @return Objeto Sesion
     */
    public static Sesion miCliente(){
        if(miSesion == null) miSesion = new Sesion();
        return miSesion;
    }

    /**
     * Devuelve el objeto cliente que ha iniciado sesión
     * @return Objeto cliente que ha iniciado sesión
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Modifica el objeto cliente que ha iniciado sesión
     * @param cliente Objeto cliente que ha iniciado sesión
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
