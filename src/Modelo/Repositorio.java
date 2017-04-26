package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Repositorio {
    
    private ArrayList<Cliente> clientes;
    private static Repositorio miRepositorio = null;
    
    private Repositorio() throws SQLException, ClassNotFoundException{
        clientes = new ArrayList<Cliente>();
    }
    
    public void cargarDatos() throws ClassNotFoundException, SQLException{
        ResultSet rsCliente = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM usuarios;");
        while(rsCliente.next()){
            ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
            //Generamos los pedidos que son de tipo compra del cliente
            ResultSet rsIDCompras = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT numeroPedido FROM compras WHERE numeroPedido IN (SELECT numeroPedido FROM pedidos WHERE idCliente = '" + rsCliente.getString("id") + "');");
            while(rsIDCompras.next()){
                ResultSet rsCompras = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM pedidos WHERE numeroPedido = '" + rsIDCompras.getString("numeroPedido") + "';");
                ArrayList<Producto> productos = new ArrayList<Producto>();
                ResultSet rsProductosCompra = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM productosComprados WHERE numeroPedido = " + rsCompras.getString("numeroPedido"));
                while(rsProductosCompra.next()){
                    ResultSet rsProducto = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM productos WHERE id = " + rsProductosCompra.getString("idProducto"));
                    Producto p = new Producto(Integer.parseInt(rsProducto.getString("id")), rsProducto.getString("marca"), rsProducto.getString("modelo"), Double.parseDouble(rsProducto.getString("precio")), rsProducto.getString("color"), rsProducto.getString("descripcion"), Integer.parseInt(rsProducto.getString("stock")));
                    productos.add(p);
                }
                Compra c = new Compra(Integer.parseInt(rsCompras.getString("numeroPedido")), rsCompras.getString("fecha"), Integer.parseInt(rsCompras.getString("idCliente")), Double.parseDouble(rsCompras.getString("subtotal")), Double.parseDouble(rsCompras.getString("total")), rsCompras.getString("tipoPago"), rsCompras.getString("estadoPedido"), productos);
                pedidos.add(c);
            }
            //Generamos los pedidos que son de tipo reparación del cliente
            ResultSet rsIDReparaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT numeroPedido FROM reparaciones WHERE numeroPedido IN (SELECT numeroPedido FROM pedidos WHERE idCliente = '" + rsCliente.getString("id") + "');");
            while(rsIDReparaciones.next()){
                ResultSet rsPedidoReparacion = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM pedidos WHERE numeroPedido = '" + rsIDReparaciones.getString("numeroPedido") + "';");
                while(rsPedidoReparacion.next()){
                    ResultSet reparacion = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM reparaciones WHERE numeroPedido = " + rsPedidoReparacion.getString("numeroPedido"));
                    reparacion.next();
                    Reparacion r = new Reparacion(Integer.parseInt(rsPedidoReparacion.getString("numeroPedido")), rsPedidoReparacion.getString("fecha"), Integer.parseInt(rsPedidoReparacion.getString("idCliente")), Double.parseDouble(rsPedidoReparacion.getString("subtotal")), Double.parseDouble(rsPedidoReparacion.getString("total")), rsPedidoReparacion.getString("tipoPago"), rsPedidoReparacion.getString("estadoPedido"), Integer.parseInt(reparacion.getString("proveedor")), reparacion.getString("diagnostico"));
                    pedidos.add(r);
                }
            }
            //Generamos los pedidos que son de tipo liberación del cliente
            ResultSet rsIDLiberaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT numeroPedido FROM liberaciones WHERE numeroPedido IN (SELECT numeroPedido FROM pedidos WHERE idCliente = '" + rsCliente.getString("id") + "');");
            while(rsIDLiberaciones.next()){
                ResultSet rsPedidoLiberacion = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM pedidos WHERE numeroPedido = '" + rsIDLiberaciones.getString("numeroPedido") + "';");
                while(rsPedidoLiberacion.next()){
                    ResultSet liberacion = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM liberaciones WHERE numeroPedido = " + rsPedidoLiberacion.getString("numeroPedido"));
                    liberacion.next();
                    Liberacion l = new Liberacion(Integer.parseInt(rsPedidoLiberacion.getString("numeroPedido")), rsPedidoLiberacion.getString("fecha"), Integer.parseInt(rsPedidoLiberacion.getString("idCliente")), Double.parseDouble(rsPedidoLiberacion.getString("subtotal")), Double.parseDouble(rsPedidoLiberacion.getString("total")), rsPedidoLiberacion.getString("tipoPago"), rsPedidoLiberacion.getString("estadoPedido"), Integer.parseInt(liberacion.getString("operador")), liberacion.getString("imei"), liberacion.getString("codigoLiberacion"), liberacion.getString("instrucciones"));
                    pedidos.add(l);
                }
            }
            Cliente c = new Cliente(Integer.parseInt(rsCliente.getString("id")), rsCliente.getString("usuario"), rsCliente.getString("contrasenya"), rsCliente.getString("fechaRegistro"), rsCliente.getString("nombre"), rsCliente.getString("apellidos"), Integer.parseInt(rsCliente.getString("permiso")), pedidos, rsCliente.getString("direccion"), rsCliente.getString("telefono"), rsCliente.getString("fechaNacimiento"), rsCliente.getString("dni"));
            clientes.add(c);
        }
    }
    
    public static Repositorio repositorio() throws SQLException, ClassNotFoundException{
        if(miRepositorio == null) miRepositorio = new Repositorio();
        return miRepositorio;
    }
    
    public ArrayList<Cliente> devolverClientes(){
        return clientes;
    }
}
