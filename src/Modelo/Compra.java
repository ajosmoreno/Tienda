package Modelo;

import java.util.ArrayList;

/**
 * Clase compra que hereda de Pedido
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class Compra extends Pedido{
    
    private ArrayList<Producto> productos;
    
    /**
     * Constructor que inicializa la compra con sus atributos
     * @param numeroPedido Número de pedido
     * @param fecha Fecha del pedido
     * @param cliente ID del cliente
     * @param subtotal Subtotal del pedido
     * @param total Total del pedido
     * @param tipoPago Tipo de pago del pedido (Efectivo, Tarjeta)
     * @param estadoPedido Estado del pedido ('Completado','Pagado', 'Cancelado', 'Sin pagar', 'Liberado', 'Reparado')
     * @param productos Lista de productos del pedido
     */
    public Compra(int numeroPedido, String fecha, int cliente, double subtotal, double total, String tipoPago, String estadoPedido, ArrayList<Producto> productos){
        super(numeroPedido, fecha, cliente, subtotal, total, tipoPago, estadoPedido);
        this.productos = productos;
    }

    /**
     * Devuelve la lista de productos del pedido
     * @return Lista de productos del pedido
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * Modifica la lista de productos del pedido
     * @param productos Lista de productos del pedido
     */
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }    
}
