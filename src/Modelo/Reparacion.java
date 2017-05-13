package Modelo;

/**
 * Clase información que almacenará reparaciones
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class Reparacion extends Pedido{
    
    private int proveedor;
    private String diagnostico;
    
    /**
     * Constructor que inicializa reparaciones por sus datos
     * @param numeroPedido Número del pedido
     * @param fecha Fecha del pedido
     * @param cliente ID del cliente
     * @param subtotal Subtotal del pedido
     * @param total Total del pedido
     * @param tipoPago Tipo de pago del pedido (Efectivo, Tarjeta)
     * @param estadoPedido Estado del pedido ('Completado','Pagado', 'Cancelado', 'Sin pagar', 'Liberado', 'Reparado')
     * @param proveedor Gestor de tipo proveedor del pedido
     * @param diagnostico Diagnóstico de la reparación
     */
    public Reparacion(int numeroPedido, String fecha, int cliente, double subtotal, double total, String tipoPago, String estadoPedido, int proveedor, String diagnostico){
        super(numeroPedido, fecha, cliente, subtotal, total, tipoPago, estadoPedido);
        this.proveedor = proveedor;
        this.diagnostico = diagnostico;
    }

    /**
     * Devuelve el proveedor
     * @return Proveedor
     */
    public int getProveedor() {
        return proveedor;
    }

    /**
     * Modifica el proveedor
     * @param proveedor Gestor de tipo proveedor
     */
    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Devuelve el diagnóstico
     * @return Diagnóstico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Modifica el diagnóstico
     * @param diagnostico Diagnóstico
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
