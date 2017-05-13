package Modelo;

import java.util.ArrayList;

/**
 *
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
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
