package Modelo;

/**
 * Clase Liberacion que hereda de Pedido
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class Liberacion extends Pedido{
    
    private int operador;
    private String imei;
    private String codigoLiberacion;
    private String instrucciones;
    
    /**
     * Constructor que inicializa la liberación con sus datos
     * @param numeroPedido Número de pedido
     * @param fecha Fecha de pedido
     * @param cliente ID del cliente
     * @param subtotal Subtotal del pedido
     * @param total Total del pedido
     * @param tipoPago Tipo de pago del pedido (Efectivo, Tarjeta)
     * @param estadoPedido Estado del pedido ('Completado','Pagado', 'Cancelado', 'Sin pagar', 'Liberado', 'Reparado')
     * @param operador ID del gestor de tipo Operador que realiza la liberación
     * @param imei IMEI del teléfono
     * @param codigoLiberacion Código de liberación del teléfono
     * @param instrucciones Instrucciones para usar el código de liberación
     */
    public Liberacion(int numeroPedido, String fecha, int cliente, double subtotal, double total, String tipoPago, String estadoPedido, int operador, String imei, String codigoLiberacion, String instrucciones){
        super(numeroPedido, fecha, cliente, subtotal, total, tipoPago, estadoPedido);
        this.operador = operador;
        this.imei = imei;
        this.codigoLiberacion = codigoLiberacion;
        this.instrucciones = instrucciones;
    }

    /**
     * Devuelve el operador del pedido
     * @return Operador del pedido
     */
    public int getOperador() {
        return operador;
    }

    /**
     * Modifica el operador
     * @param operador Operador
     */
    public void setOperador(int operador) {
        this.operador = operador;
    }

    /**
     * Devuelve el IMEI del teléfono
     * @return 
     */
    public String getImei() {
        return imei;
    }

    /**
     * Modifica el IMEI del teléfono
     * @param imei IMEI del teléfono
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * Devuelve el código de liberación
     * @return Código de liberación
     */
    public String getCodigoLiberacion() {
        return codigoLiberacion;
    }

    /**
     * Modifica el código de liberación
     * @param codigoLiberacion Código de liberación
     */
    public void setCodigoLiberacion(String codigoLiberacion) {
        this.codigoLiberacion = codigoLiberacion;
    }

    /**
     * Devuelve las instrucciones
     * @return Instrucciones
     */
    public String getInstrucciones() {
        return instrucciones;
    }

    /**
     * Modifica las instrucciones
     * @param instrucciones Instrucciones
     */
    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
}
