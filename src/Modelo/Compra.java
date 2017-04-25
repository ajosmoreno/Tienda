package Modelo;

import java.util.Date;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Compra extends Pedido{
    
    private Producto[] productos;
    
    public Compra(int numeroPedido, Date fecha, Cliente cliente, double subtotal, double total, String tipoPago, String estadoPedido, Producto[] productos){
        super(numeroPedido, fecha, cliente, subtotal, total, tipoPago, estadoPedido);
        this.productos = productos;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }    
}
