package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Compra extends Pedido{
    
    private ArrayList<Producto> productos;
    
    public Compra(int numeroPedido, String fecha, int cliente, double subtotal, double total, String tipoPago, String estadoPedido, ArrayList<Producto> productos){
        super(numeroPedido, fecha, cliente, subtotal, total, tipoPago, estadoPedido);
        this.productos = productos;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }    
}
