package Modelo;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Sesion {
    
    private Cliente cliente;
    private static Sesion miSesion = null;
    
    private Sesion(){
    }
    
    public static Sesion miCliente(){
        if(miSesion == null) miSesion = new Sesion();
        return miSesion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
