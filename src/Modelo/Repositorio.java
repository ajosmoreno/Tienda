package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class Repositorio {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Pedido> listaPedidos;
    private static Repositorio miRepositorio = null;

    private Repositorio() throws SQLException, ClassNotFoundException {
        listaClientes = new ArrayList<Cliente>();
        listaProductos = new ArrayList<Producto>();
        listaPedidos = new ArrayList<Pedido>();
    }

    public void cargarProductos() throws ClassNotFoundException, SQLException {
        ResultSet rsProducto = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM productos;");
        while (rsProducto.next()) {
            Producto p = new Producto(Integer.parseInt(rsProducto.getString("id")), rsProducto.getString("marca"), rsProducto.getString("modelo"), Double.parseDouble(rsProducto.getString("precio")), rsProducto.getString("color"), rsProducto.getString("descripcion"), Integer.parseInt(rsProducto.getString("stock")), rsProducto.getString("imagen"));
            listaProductos.add(p);
        }
    }

    public void cargarPedidos() throws ClassNotFoundException, SQLException {
        //Añadimos los pedidos que son compra al repositorio
        ResultSet rsCompras = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM compras;");
        while(rsCompras.next()){
            ResultSet rsPedidosCompras = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM pedidos WHERE numeroPedido = '" + rsCompras.getString("numeroPedido") + "';");
            ArrayList<Producto> productos = new ArrayList<Producto>();
            rsPedidosCompras.next();
            ResultSet rsProductosCompra = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM productosComprados WHERE numeroPedido = " + rsCompras.getString("numeroPedido"));
            while(rsProductosCompra.next()){
                boolean productoEncontrado = false;
                int contadorProductos = 0;
                while(!productoEncontrado && contadorProductos < listaProductos.size()){
                    Producto p = listaProductos.get(contadorProductos);
                    if(p.getId() ==  Integer.parseInt(rsProductosCompra.getString("idProducto"))){
                        productos.add(p);
                        productoEncontrado = true;
                    }
                    contadorProductos++;
                }
            }
            Compra c = new Compra(Integer.parseInt(rsPedidosCompras.getString("numeroPedido")), rsPedidosCompras.getString("fecha"), Integer.parseInt(rsPedidosCompras.getString("idCliente")), Double.parseDouble(rsPedidosCompras.getString("subtotal")), Double.parseDouble(rsPedidosCompras.getString("total")), rsPedidosCompras.getString("tipoPago"), rsPedidosCompras.getString("estadoPedido"), productos);
            listaPedidos.add(c);
        }
        //Añadimos los pedidos que son liberaciones al repositorio
        ResultSet rsLiberaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM liberaciones");
        while(rsLiberaciones.next()){
            ResultSet rsPedidosLiberaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM pedidos WHERE numeroPedido = " + rsLiberaciones.getString("numeroPedido"));
            rsPedidosLiberaciones.next();
            Liberacion l = new Liberacion(Integer.parseInt(rsPedidosLiberaciones.getString("numeroPedido")), rsPedidosLiberaciones.getString("fecha"), Integer.parseInt(rsPedidosLiberaciones.getString("idCliente")), Double.parseDouble(rsPedidosLiberaciones.getString("subtotal")), Double.parseDouble(rsPedidosLiberaciones.getString("total")), rsPedidosLiberaciones.getString("tipoPago"), rsPedidosLiberaciones.getString("estadoPedido"), Integer.parseInt(rsLiberaciones.getString("operador")), rsLiberaciones.getString("imei"), rsLiberaciones.getString("codigoLiberacion"), rsLiberaciones.getString("instrucciones"));
            listaPedidos.add(l);
        }        
        //Añadimos los pedidos que son reparaciones al repositorio
        ResultSet rsReparaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM reparaciones");
        while(rsReparaciones.next()){
            ResultSet rsPedidosReparaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM pedidos WHERE numeroPedido = " + rsReparaciones.getString("numeroPedido"));
            rsPedidosReparaciones.next();
            Reparacion r = new Reparacion(Integer.parseInt(rsPedidosReparaciones.getString("numeroPedido")), rsPedidosReparaciones.getString("fecha"), Integer.parseInt(rsPedidosReparaciones.getString("idCliente")), Double.parseDouble(rsPedidosReparaciones.getString("subtotal")), Double.parseDouble(rsPedidosReparaciones.getString("total")), rsPedidosReparaciones.getString("tipoPago"), rsPedidosReparaciones.getString("estadoPedido"), Integer.parseInt(rsReparaciones.getString("proveedor")), rsReparaciones.getString("diagnostico"));
            listaPedidos.add(r);
        }
    }

    public void cargarClientes() throws SQLException, ClassNotFoundException{
        ResultSet rsClientes = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM usuarios;");
        while(rsClientes.next()){
            ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
            for(Pedido p: listaPedidos){
                if(p.getCliente() == Integer.parseInt(rsClientes.getString("id")))
                    pedidos.add(p);
            }
            Cliente c = new Cliente(Integer.parseInt(rsClientes.getString("id")), rsClientes.getString("usuario"), rsClientes.getString("contrasenya"), rsClientes.getString("fechaRegistro"), rsClientes.getString("nombre"), rsClientes.getString("apellidos"), Integer.parseInt(rsClientes.getString("permiso")), pedidos, rsClientes.getString("direccion"), rsClientes.getString("telefono"), rsClientes.getString("fechaNacimiento"), rsClientes.getString("dni"));
            listaClientes.add(c);
        }
    }
    
    public void inicializarDatos() throws ClassNotFoundException, SQLException {
        cargarProductos();
        cargarPedidos();
        cargarClientes();
    }

    public static Repositorio repositorio() throws SQLException, ClassNotFoundException {
        if (miRepositorio == null) {
            miRepositorio = new Repositorio();
        }
        return miRepositorio;
    }

    public ArrayList<Cliente> devolverClientes() {
        return listaClientes;
    }
}
