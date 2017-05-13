package Modelo;

/**
 * Clase pedido de la cual no se pueden crear objetos pero si de sus descendientes
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public abstract class Pedido {
    
    private int numeroPedido;
    private String fecha;
    private int cliente;
    private double subtotal;
    private double total;
    private String tipoPago;
    private String estadoPedido;

    /**
     * Constructor que inicializa el pedido con sus datos
     * @param numeroPedido Número del pedido
     * @param fecha Fecha del pedido
     * @param cliente ID del cliente
     * @param subtotal Subtotal del pedido
     * @param total Total del pedido
     * @param tipoPago Tipo de pago del pedido (Efectivo, Tarjeta)
     * @param estadoPedido Estado del pedido ('Completado','Pagado', 'Cancelado', 'Sin pagar', 'Liberado', 'Reparado')
     */
    public Pedido(int numeroPedido, String fecha, int cliente, double subtotal, double total, String tipoPago, String estadoPedido) {
        this.numeroPedido = numeroPedido;
        this.fecha = fecha;
        this.cliente = cliente;
        this.subtotal = subtotal;
        this.total = total;
        this.tipoPago = tipoPago;
        this.estadoPedido = estadoPedido;
    }

    /**
     * Devuelve el número de pedido
     * @return Número de pedido
     */
    public int getNumeroPedido() {
        return numeroPedido;
    }

    /**
     * Modifica el número de pedido
     * @param numeroPedido Número de pedido
     */
    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    /**
     * Devuelve la fecha del pedido
     * @return Fecha del pedido
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Modifica la fecha del pedido
     * @param fecha Fecha del pedido
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve la ID del cliente
     * @return ID del cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * Modifica la ID del cliente
     * @param cliente ID del cliente
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve el subtotal del pedido
     * @return Subtotal del pedido
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Modifica el subtotal del pedido
     * @param subtotal Subtotal del pedido
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Devuelve el total del pedido
     * @return Total del pedido
     */
    public double getTotal() {
        return total;
    }

    /**
     * Modifica el total del pedido
     * @param total Total del pedido
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Devuelve el tipo de pago
     * @return Tipo de pago
     */
    public String getTipoPago() {
        return tipoPago;
    }

    /**
     * Modifica el tipo de pago 
     * @param tipoPago Tipo de pago (Efectivo, TarjetA)
     */
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    /**
     * Devuelve el estado del pedido
     * @return Estado del pedido
     */
    public String getEstadoPedido() {
        return estadoPedido;
    }

    /**
     * Modifica el estado del pedido
     * @param estadoPedido Estado del pedido ('Completado','Pagado', 'Cancelado', 'Sin pagar', 'Liberado', 'Reparado')
     */
    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}
