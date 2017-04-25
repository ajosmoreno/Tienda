package Modelo;

import java.util.Date;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Liberacion extends Pedido{
    
    private Operador operador;
    private String imei;
    private String codigoLiberacion;
    private String instrucciones;
    
    public Liberacion(int numeroPedido, Date fecha, Cliente cliente, double subtotal, double total, String tipoPago, String estadoPedido, Operador operador, String imei, String codigoLiberacion, String instrucciones){
        super(numeroPedido, fecha, cliente, subtotal, total, tipoPago, estadoPedido);
        this.operador = operador;
        this.imei = imei;
        this.codigoLiberacion = codigoLiberacion;
        this.instrucciones = instrucciones;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getCodigoLiberacion() {
        return codigoLiberacion;
    }

    public void setCodigoLiberacion(String codigoLiberacion) {
        this.codigoLiberacion = codigoLiberacion;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    
}
