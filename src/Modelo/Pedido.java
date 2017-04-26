package Modelo;

import java.util.Date;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Pedido {
    
    private int numeroPedido;
    private String fecha;
    private int cliente;
    private double subtotal;
    private double total;
    private String tipoPago;
    private String estadoPedido;

    public Pedido(int numeroPedido, String fecha, int cliente, double subtotal, double total, String tipoPago, String estadoPedido) {
        this.numeroPedido = numeroPedido;
        this.fecha = fecha;
        this.cliente = cliente;
        this.subtotal = subtotal;
        this.total = total;
        this.tipoPago = tipoPago;
        this.estadoPedido = estadoPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void realizarPago(){
        
    }
    
    public void devolverPedido(){
        
    }
    
    public void cancelarPedido(){
        
    }
}
