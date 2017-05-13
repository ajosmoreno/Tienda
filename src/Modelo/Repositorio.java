package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class Repositorio {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Gestor> listaGestores;
    private static Repositorio miRepositorio = null;

    private Repositorio() throws SQLException, ClassNotFoundException {
        listaClientes = new ArrayList<Cliente>();
        listaProductos = new ArrayList<Producto>();
        listaPedidos = new ArrayList<Pedido>();
        listaGestores = new ArrayList<Gestor>();
    }

    public void cargarProductos() throws ClassNotFoundException, SQLException, Exception {
        listaProductos = new ArrayList<Producto>();
        ResultSet rsProducto = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM productos;");
        while (rsProducto.next()) {
            Producto p = new Producto(Integer.parseInt(rsProducto.getString("id")), rsProducto.getString("marca"), rsProducto.getString("modelo"), Double.parseDouble(rsProducto.getString("precio")), rsProducto.getString("color"), rsProducto.getString("descripcion"), Integer.parseInt(rsProducto.getString("stock")), rsProducto.getString("imagen"));
            listaProductos.add(p);
        }
    }

    public void cargarPedidos() throws ClassNotFoundException, SQLException, Exception {
        listaPedidos = new ArrayList<Pedido>();
        //Añadimos los pedidos que son compra al repositorio
        ResultSet rsCompras = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM compras;");
        while (rsCompras.next()) {
            ResultSet rsPedidosCompras = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM pedidos WHERE numeroPedido = '" + rsCompras.getString("numeroPedido") + "';");
            ArrayList<Producto> productos = new ArrayList<Producto>();
            rsPedidosCompras.next();
            ResultSet rsProductosCompra = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM productosComprados WHERE numeroPedido = " + rsCompras.getString("numeroPedido"));
            while (rsProductosCompra.next()) {
                productos.add(productoPorID(Integer.parseInt(rsProductosCompra.getString("idProducto"))));
            }
            Compra c = new Compra(Integer.parseInt(rsPedidosCompras.getString("numeroPedido")), rsPedidosCompras.getString("fecha"), Integer.parseInt(rsPedidosCompras.getString("idCliente")), Double.parseDouble(rsPedidosCompras.getString("subtotal")), Double.parseDouble(rsPedidosCompras.getString("total")), rsPedidosCompras.getString("tipoPago"), rsPedidosCompras.getString("estadoPedido"), productos);
            listaPedidos.add(c);
        }
        //Añadimos los pedidos que son liberaciones al repositorio
        ResultSet rsLiberaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM liberaciones");
        while (rsLiberaciones.next()) {
            ResultSet rsPedidosLiberaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM pedidos WHERE numeroPedido = " + rsLiberaciones.getString("numeroPedido"));
            rsPedidosLiberaciones.next();
            Liberacion l = new Liberacion(Integer.parseInt(rsPedidosLiberaciones.getString("numeroPedido")), rsPedidosLiberaciones.getString("fecha"), Integer.parseInt(rsPedidosLiberaciones.getString("idCliente")), Double.parseDouble(rsPedidosLiberaciones.getString("subtotal")), Double.parseDouble(rsPedidosLiberaciones.getString("total")), rsPedidosLiberaciones.getString("tipoPago"), rsPedidosLiberaciones.getString("estadoPedido"), Integer.parseInt(rsLiberaciones.getString("operador")), rsLiberaciones.getString("imei"), rsLiberaciones.getString("codigoLiberacion"), rsLiberaciones.getString("instrucciones"));
            listaPedidos.add(l);
        }
        //Añadimos los pedidos que son reparaciones al repositorio
        ResultSet rsReparaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM reparaciones");
        while (rsReparaciones.next()) {
            ResultSet rsPedidosReparaciones = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM pedidos WHERE numeroPedido = " + rsReparaciones.getString("numeroPedido"));
            rsPedidosReparaciones.next();
            Reparacion r = new Reparacion(Integer.parseInt(rsPedidosReparaciones.getString("numeroPedido")), rsPedidosReparaciones.getString("fecha"), Integer.parseInt(rsPedidosReparaciones.getString("idCliente")), Double.parseDouble(rsPedidosReparaciones.getString("subtotal")), Double.parseDouble(rsPedidosReparaciones.getString("total")), rsPedidosReparaciones.getString("tipoPago"), rsPedidosReparaciones.getString("estadoPedido"), Integer.parseInt(rsReparaciones.getString("proveedor")), rsReparaciones.getString("diagnostico"));
            listaPedidos.add(r);
        }
    }

    public void cargarClientes() throws SQLException, ClassNotFoundException, Exception {
        listaClientes = new ArrayList<Cliente>();
        ResultSet rsClientes = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM usuarios;");
        while (rsClientes.next()) {
            ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
            for (Pedido p : listaPedidos) {
                if (p.getCliente() == Integer.parseInt(rsClientes.getString("id"))) {
                    pedidos.add(p);
                }
            }
            Cliente c = new Cliente(Integer.parseInt(rsClientes.getString("id")), rsClientes.getString("usuario"), rsClientes.getString("contrasenya"), rsClientes.getString("fechaRegistro"), rsClientes.getString("nombre"), rsClientes.getString("apellidos"), Integer.parseInt(rsClientes.getString("permiso")), pedidos, rsClientes.getString("direccion"), rsClientes.getString("telefono"), rsClientes.getString("fechaNacimiento"), rsClientes.getString("dni"), cestaPorCliente(Integer.parseInt(rsClientes.getString("id"))));
            listaClientes.add(c);
        }
    }

    public void cargarGestores() throws SQLException, Exception {
        listaGestores = new ArrayList<Gestor>();
        ResultSet rsGestores = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM gestores;");
        while (rsGestores.next()) {
            Gestor g = new Gestor(Integer.parseInt(rsGestores.getString("id")), rsGestores.getString("nombre"), rsGestores.getString("direccion"), rsGestores.getString("telefono"), rsGestores.getString("email"), rsGestores.getString("tipo"));
            listaGestores.add(g);
        }
    }

    public ArrayList<Producto> cestaPorCliente(int idCliente) throws SQLException, Exception {
        ArrayList<Producto> cesta = new ArrayList<Producto>();
        ResultSet rsCesta = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM cesta WHERE idCliente = " + idCliente);
        while (rsCesta.next()) {
            cesta.add(productoPorID(Integer.parseInt(rsCesta.getString("idProducto"))));
        }
        return cesta;
    }

    public Producto productoPorID(int idProducto) {
        Producto producto = null;
        boolean encontrado = false;
        int contador = 0;
        while (!encontrado && contador < listaProductos.size()) {
            Producto p = listaProductos.get(contador);
            if (p.getId() == idProducto) {
                producto = p;
                encontrado = true;
            }
            contador++;
        }
        return producto;
    }

    public Cliente clientePorUsuario(String usuario) {
        Cliente cliente = null;
        boolean encontrado = false;
        int contador = 0;
        while (!encontrado && contador < listaClientes.size()) {
            Cliente c = listaClientes.get(contador);
            if (c.getNombreUsuario().equals(usuario)) {
                encontrado = true;
                cliente = c;
            }
            contador++;
        }
        return cliente;
    }

    public Gestor gestorPorNombre(String nombre) {
        Gestor gestor = null;
        boolean encontrado = false;
        int contador = 0;
        while (!encontrado && contador < listaGestores.size()) {
            Gestor g = listaGestores.get(contador);
            if (g.getNombre().equals(nombre)) {
                encontrado = true;
                gestor = g;
            }
            contador++;
        }
        return gestor;
    }

    public int posicionClienteEnLista(Cliente c) {
        int pos = -1;
        boolean encontrado = false;
        int contador = 0;
        while (!encontrado && contador < listaClientes.size()) {
            Cliente cl = listaClientes.get(contador);
            if (c.getId() == cl.getId()) {
                pos = contador;
            }
            contador++;
        }
        return pos;
    }

    public boolean eliminarProductoCesta(Cliente c, Producto p) throws SQLException, Exception {
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM cesta WHERE idCliente = " + c.getId() + " AND idProducto = " + p.getId());
        return rs != null;
    }

    public void inicializarDatos() throws ClassNotFoundException, SQLException, Exception {
        cargarProductos();
        cargarPedidos();
        cargarClientes();
        cargarGestores();
    }

    public static Repositorio repositorio() throws SQLException, ClassNotFoundException, Exception {
        if (miRepositorio == null) {
            miRepositorio = new Repositorio();
        }
        return miRepositorio;
    }

    public ArrayList<Cliente> devolverClientes() {
        return listaClientes;
    }

    public ArrayList<Producto> devolverProductos() {
        return listaProductos;
    }

    public ArrayList<Pedido> devolverPedidos() {
        return listaPedidos;
    }

    public ArrayList<Gestor> devolverGestores() {
        return listaGestores;
    }

    public boolean añadirGestor(String nombre, String direccion, String telefono, String email, String tipo) throws SQLException, Exception {
        boolean añadido = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO gestores (nombre, direccion, telefono, email, tipo) VALUES ('" + nombre + "', '" + direccion + "', '" + telefono + "', '" + email + "', '" + tipo + "');");
        if (rs != null) {
            rs.next();
            Gestor g = new Gestor(Integer.parseInt(rs.getString("id")), nombre, direccion, telefono, email, tipo);
            listaGestores.add(g);
            añadido = true;
        }
        return añadido;
    }

    public boolean modificarGestor(int id, String nombre, String direccion, String telefono, String email, String tipo) throws SQLException, Exception {
        boolean añadido = false;
        ResultSet rsModificar = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE gestores SET nombre = '" + nombre + "', direccion = '" + direccion + "', telefono = '" + telefono + "', email = '" + email + "', tipo = '" + tipo + "' WHERE id = " + id);
        if (rsModificar != null) {
            añadido = true;
            cargarGestores();
        }
        return añadido;
    }

    public boolean eliminarGestor(String nombre) throws SQLException, Exception {
        boolean eliminado = false;
        ResultSet rsEliminar = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM gestores WHERE nombre = '" + nombre + "';");
        if (rsEliminar != null) {
            eliminado = true;
            cargarGestores();
        }
        return eliminado;
    }

    public boolean registrarUsuario(String usuario, String contrasenya, String nombre, String apellidos, String dni, String fechaNacimiento, String direccion, String telefono, int permisos) throws SQLException, Exception {
        boolean registrado = false;
        if(Cliente.comprobarDNI(dni)){
            ResultSet res = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO usuarios (usuario, contrasenya, nombre, apellidos, direccion, telefono, fechaNacimiento, dni, permiso) VALUES ('" + usuario + "', '" + Cliente.encriptarContrasenya(contrasenya) + "', '" + nombre + "', '" + apellidos + "', '" + direccion + "', '" + telefono + "', '" + fechaNacimiento + "', '" + dni + "', " + permisos + ");");
            if (res != null) {
                cargarClientes();
                registrado = true;
            }
        } else throw new IllegalArgumentException("El DNI introducido no es correcto.");
        return registrado;
    }

    public int generarCompra(int idCliente, double subtotal, double total, String tipoPago) throws SQLException, Exception {
        int pedidoGenerado = 0;
        ResultSet rsPedido = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO pedidos (idCliente, subtotal, total, tipoPago, estadoPedido) VALUES (" + idCliente + ", " + subtotal + ", " + total + ", '" + tipoPago + "', 'Sin pagar');");
        if(rsPedido != null){
            rsPedido.next();
            ResultSet rsCompra = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO compras VALUES (" + rsPedido.getString("numeroPedido") + ");");
            if(rsCompra != null){
                ArrayList<Producto> cestaCliente = Sesion.miCliente().getCliente().getCesta();
                for(Producto p: cestaCliente){
                    ResultSet stockProducto = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT stock FROM productos WHERE id = " + p.getId());
                    stockProducto.next();
                    if(Integer.parseInt(stockProducto.getString("stock")) > 0){
                        ResultSet productoComprado = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO productoscomprados (numeroPedido, idProducto) VALUES (" + rsPedido.getString("numeroPedido") + ", " + p.getId() + ");");
                        if(productoComprado != null){
                            BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE productos SET stock = stock - 1 WHERE id = " + p.getId());
                            ResultSet eliminarProductoCesta = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM cesta WHERE idCliente = " + idCliente + " AND idProducto = " + p.getId());
                            if(eliminarProductoCesta == null){
                                throw new Exception("No se ha podido eliminar el producto " + p.getMarca() + " " + p.getModelo() + " " + p.getColor() + " de la cesta.\n\nEl pedido de ese producto si se ha procesado, solo que volverá a aparecer en la cesta.");
                            } else{
                                pedidoGenerado = Integer.parseInt(rsPedido.getString("numeroPedido"));
                            }
                        } else{
                            throw new Exception("No se ha podido procesar el producto " + p.getMarca() + " " + p.getModelo() + " " + p.getColor() + " de la cesta.\n\nInténtelo de nuevo en otro pedido.");
                        }
                    } else{
                        throw new Exception("El producto se ha agotado mientras gestionabas la cesta.");
                    }
                }
            } else{
                throw new Exception("No se ha podido generar la compra.");
            }
        }
        if(pedidoGenerado > 0){
            cargarProductos();
            cargarPedidos();
            cargarClientes();
        }
        return pedidoGenerado;
    }
    
    public boolean pagarPedido(int numeroPedido) throws SQLException, Exception{
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE pedidos SET estadoPedido = 'Pagado' WHERE numeroPedido = " + numeroPedido + ";");
        return rs != null;
    }

    public boolean modificarUsuario(String usuario, String contrasenya, String nombre, String apellidos, String dni, String fechaNacimiento, String direccion, String telefono, int permisos) throws SQLException, Exception {
        boolean modificado = false;
        ResultSet rs;
        if(contrasenya.equals(""))
            rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE usuarios SET nombre = '" + nombre + "', apellidos = '" + apellidos + "', direccion = '" + direccion + "', telefono = '" + telefono + "', fechaNacimiento = '" + fechaNacimiento + "', dni = '" + dni + "', permiso = " + permisos + " WHERE usuario = '" + usuario + "';");
        else
            rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE usuarios SET contrasenya = '" + Cliente.encriptarContrasenya(contrasenya) + "', nombre = '" + nombre + "', apellidos = '" + apellidos + "', direccion = '" + direccion + "', telefono = '" + telefono + "', fechaNacimiento = '" + fechaNacimiento + "', dni = '" + dni + "', permiso = " + permisos + " WHERE usuario = '" + usuario + "';");
        if(rs != null){
            modificado = true;
            cargarClientes();
        }
        return modificado;
    }

    public boolean eliminarUsuario(String usuario) throws SQLException, Exception {
        boolean eliminado = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM usuarios WHERE usuario = '" + usuario + "';");
        if(rs != null){
            eliminado = true;
            cargarClientes();
        }
        return eliminado;
    }
    
    public boolean repararPedido(int numeroPedido, String diagnostico, Double precio, String estadoAnterior) throws SQLException, Exception{
        boolean reparado = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE pedidos SET estadoPedido = 'Reparado', subtotal = " + (precio * 0.79) + ", total = " + precio + " WHERE numeroPedido = " + numeroPedido);
        if(rs != null){
            ResultSet rsReparacion = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE reparaciones SET diagnostico = '" + diagnostico + "' WHERE numeroPedido = " + numeroPedido);
            if(rsReparacion != null){
                cargarPedidos();
                cargarClientes();
                reparado = true;
            } else{
                ResultSet rsError = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE pedidos SET estadoPedido = '" + estadoAnterior + "' WHERE numeroPedido = " + numeroPedido);
                if(rsError == null) throw new Exception("No se ha podido completar el pedido, si aparece como completado, no lo está.");
            }
        }
        return reparado;
    }
    
    public boolean liberarPedido(int numeroPedido, String codigoLiberacion, String instrucciones, String estadoAnterior) throws SQLException, Exception{
        boolean liberado = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE pedidos SET estadoPedido = 'Completado' WHERE numeroPedido = " + numeroPedido);
        if(rs != null){
            ResultSet rsLiberacion = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE liberaciones SET instrucciones = '" + instrucciones + "', codigoLiberacion = '" + codigoLiberacion + "' WHERE numeroPedido = " + numeroPedido);
            if(rsLiberacion != null){
                cargarPedidos();
                cargarClientes();
                liberado = true;
            } else{
                ResultSet rsError = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE pedidos SET estadoPedido = '" + estadoAnterior + "' WHERE numeroPedido = " + numeroPedido);
                if(rsError == null) throw new Exception("No se ha podido completar el pedido, si aparece como completado, no lo está.");
            }
        }
        return liberado;
    }
    
    public boolean completarPedido(int numeroPedido) throws SQLException, Exception{
        boolean completado = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE pedidos SET estadoPedido = 'Completado' WHERE numeroPedido = " + numeroPedido);
        if(rs != null){
            completado = true;
            Repositorio.repositorio().cargarProductos();
            Repositorio.repositorio().cargarPedidos();
            Repositorio.repositorio().cargarClientes();
        }   
        return completado;
    }
    
    public boolean cancelarPedido(int numerPedido) throws SQLException, Exception{
        boolean eliminado = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE pedidos SET estadoPedido = 'Cancelado' WHERE numeroPedido = " + numerPedido);
        if(rs != null){
            eliminado = true;
            Repositorio.repositorio().cargarProductos();
            Repositorio.repositorio().cargarPedidos();
            Repositorio.repositorio().cargarClientes();
        }
        return eliminado;
    }
    
    public boolean modificarProducto(int id, String marca, String modelo, Double precio, int stock, String imagen, String caracteristicas, String color) throws SQLException, Exception{
        boolean modificado = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE productos SET marca = '" + marca + "', modelo = '" + modelo + "', precio = " + precio + ", stock = " + stock + ", imagen = '" + imagen + "', descripcion = '" + caracteristicas + "', color = '" + color + "' WHERE id = " + id);
        if(rs != null){
            modificado = true;
            cargarProductos();
            cargarPedidos();
            cargarClientes();
        }
        return modificado;
    }
    
    public boolean eliminarProducto(int id) throws SQLException, Exception{
        boolean eliminado = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM productos WHERE id = " + id);
        if(rs != null){
            eliminado = true;
            cargarProductos();
        }
        return eliminado;
    }
    
    public boolean añadirProducto(String marca, String modelo, Double precio, String color, String caracteristicas, int stock, String imagen) throws SQLException, Exception{
        boolean añadido = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO productos (marca, modelo, precio, color, descripcion, stock, imagen) VALUES ('" + marca + "', '" + modelo + "', " + precio + " , '" + color + "', '" + caracteristicas + "', " + stock +", '" + imagen + "');");
        if(rs != null){
            añadido = true;
            cargarProductos();
        }
        return añadido;
    }
    
    public ArrayList<String> obtenerMarcasProductos() throws SQLException, Exception{
        ArrayList<String> lista = new ArrayList<String>();
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT distinct marca FROM productos;");
        while(rs.next()){
            lista.add(rs.getString("marca"));
        }
        return lista;
    }
    
    public ArrayList<String> obtenerModelosProductos(String marca) throws SQLException, Exception{
        ArrayList<String> lista = new ArrayList<String>();
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT modelo FROM productos WHERE marca = '" + marca + "' GROUP BY modelo;");
        while(rs.next()){
            lista.add(rs.getString("modelo"));
        }
        return lista;
    }
    
    public boolean productoDisponible(int id) throws SQLException, Exception{
        ResultSet consultaStock = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT stock FROM productos WHERE id = " + id);
        consultaStock.next();
        return Integer.parseInt(consultaStock.getString("stock")) > 0;
    }
    
    public boolean añadirProductoCesta(int idCliente, Producto producto) throws SQLException, Exception{
        boolean añadido = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO cesta VALUES (" + idCliente + ", " + producto.getId() + ");");
        if(rs != null){
            añadido = true;
            Sesion.miCliente().getCliente().getCesta().add(producto);
        }
        return añadido;
    }
    
    public int generarLiberacion(int idCliente, double subtotal, double total, String tipoPago, int operador, String imei) throws SQLException, Exception{
        int numeroPedido = 0;
        ResultSet rsPedido = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO pedidos (idCliente, subtotal, total, tipoPago, estadoPedido) VALUES (" + idCliente + ", " + subtotal + ", " + total + " , '" + tipoPago + "', 'Pagado');");
        if(rsPedido != null){
            rsPedido.next();
            numeroPedido = Integer.parseInt(rsPedido.getString("numeroPedido"));
            ResultSet rsLiberacion = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO liberaciones (numeroPedido, operador, imei) VALUES (" + numeroPedido + ", " + operador + ", '" + imei + "')");
            if(rsLiberacion == null){
                BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM pedidos WHERE numeroPedido = " + numeroPedido);
                throw new Exception("No se ha podido generar la liberación.");
            } else{
                cargarPedidos();
            }
        } else{
            throw new Exception("No se ha podido generar el pedido de la liberación.");
        }
        return numeroPedido;
    }

    public int generarReparacion(int idCliente, int subtotal, int total, String tipoPago, int proveedor, String diagnostico) throws SQLException, Exception {
        int numeroPedido = 0;
        ResultSet rsPedido = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO pedidos (idCliente, subtotal, total, tipoPago, estadoPedido) VALUES (" + idCliente + ", " + subtotal + ", " + total + " , '" + tipoPago + "', 'Sin pagar');");
        if(rsPedido != null){
            rsPedido.next();
            numeroPedido = Integer.parseInt(rsPedido.getString("numeroPedido"));
            ResultSet rsReparacion = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO reparaciones VALUES (" + numeroPedido + ", " + proveedor + ", '" + diagnostico + "');");
            if(rsReparacion == null){
                BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM pedidos WHERE numeroPedido = " + numeroPedido);
                throw new Exception("No se ha podido generar la reparación.");
            } else{
                cargarPedidos();
            }
        }
        return numeroPedido;
    }

    public Pedido pedidoPorID(int numeroPedido) {
        Pedido pedido = null;
        boolean encontrado = false;
        int contador = 0;
        while(!encontrado && contador < listaPedidos.size()){
            Pedido p = listaPedidos.get(contador);
            if(p.getNumeroPedido() == numeroPedido){
                encontrado = true;
                pedido = p;
            }
            contador++;
        }
        return pedido;
    }
}
