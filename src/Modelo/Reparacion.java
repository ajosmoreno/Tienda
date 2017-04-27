package Modelo;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Reparacion extends Pedido{
    
    private int proveedor;
    private String diagnostico;
    
    public Reparacion(int numeroPedido, String fecha, int cliente, double subtotal, double total, String tipoPago, String estadoPedido, int proveedor, String diagnostico){
        super(numeroPedido, fecha, cliente, subtotal, total, tipoPago, estadoPedido);
        this.proveedor = proveedor;
        this.diagnostico = diagnostico;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
