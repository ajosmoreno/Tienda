package Modelo;

import java.util.Date;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Reparacion extends Pedido{
    
    private Proveedor proveedor;
    private String diagnostico;
    
    public Reparacion(int numeroPedido, Date fecha, Cliente cliente, double subtotal, double total, String tipoPago, String estadoPedido, Proveedor proveedor, String diagnostico){
        super(numeroPedido, fecha, cliente, subtotal, total, tipoPago, estadoPedido);
        this.proveedor = proveedor;
        this.diagnostico = diagnostico;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
