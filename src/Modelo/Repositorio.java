package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase repositorio que gestionará toda la manipulación de los datos
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
    
    /**
     * Devuelve el repositorio del sistema
     * @return Objeto repositorio
     * @throws SQLException Error cuando alguna consulta falla
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando ocurre otro error
     */
    public static Repositorio repositorio() throws SQLException, ClassNotFoundException, Exception {
        if (miRepositorio == null) {
            miRepositorio = new Repositorio();
        }
        return miRepositorio;
    }

    /**
     * Devuelve la lista de clientes del repositorio
     * @return Lista de clientes del repositorio
     */
    public ArrayList<Cliente> devolverClientes() {
        return listaClientes;
    }

    /**
     * Devuelve la lista de productos del repositorio
     * @return Lista de productos del repositorio
     */
    public ArrayList<Producto> devolverProductos() {
        return listaProductos;
    }

    /**
     * Devuelve la lista de pedidos del repositorio
     * @return Lista de pedidos del repositorio
     */
    public ArrayList<Pedido> devolverPedidos() {
        return listaPedidos;
    }

    /**
     * Devuelve la lista de gestores del repositorio
     * @return Lista de gestores del repositorio
     */
    public ArrayList<Gestor> devolverGestores() {
        return listaGestores;
    }
    
    /**
     * Inicializa todo el repositorio
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public void inicializarDatos() throws ClassNotFoundException, SQLException, Exception {
        cargarProductos();
        cargarPedidos();
        cargarClientes();
        cargarGestores();
    }

    /**
     * Obtiene los productos de la base de datos y los carga en el repositorio
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public void cargarProductos() throws ClassNotFoundException, SQLException, Exception {
        listaProductos = new ArrayList<Producto>();
        ResultSet rsProducto = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM productos;");
        while (rsProducto.next()) {
            Producto p = new Producto(Integer.parseInt(rsProducto.getString("id")), rsProducto.getString("marca"), rsProducto.getString("modelo"), Double.parseDouble(rsProducto.getString("precio")), rsProducto.getString("color"), rsProducto.getString("descripcion"), Integer.parseInt(rsProducto.getString("stock")), rsProducto.getString("imagen"));
            listaProductos.add(p);
        }
    }

    /**
     * Obtiene los pedidos de la base de datos y los carga en el repositorio
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
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

    /**
     * Obtiene los clientes de la base de datos y los carga en el repositorio
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
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

    /**
     * Obtiene los gestores de la base de datos y los carga en el repositorio
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public void cargarGestores() throws SQLException, Exception {
        listaGestores = new ArrayList<Gestor>();
        ResultSet rsGestores = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM gestores;");
        while (rsGestores.next()) {
            Gestor g = new Gestor(Integer.parseInt(rsGestores.getString("id")), rsGestores.getString("nombre"), rsGestores.getString("direccion"), rsGestores.getString("telefono"), rsGestores.getString("email"), rsGestores.getString("tipo"));
            listaGestores.add(g);
        }
    }

    /**
     * Devuele la cesta del cliente introducido
     * @param idCliente ID del cliente
     * @return Lista de productos
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public ArrayList<Producto> cestaPorCliente(int idCliente) throws SQLException, Exception {
        ArrayList<Producto> cesta = new ArrayList<Producto>();
        ResultSet rsCesta = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT * FROM cesta WHERE idCliente = " + idCliente);
        while (rsCesta.next()) {
            cesta.add(productoPorID(Integer.parseInt(rsCesta.getString("idProducto"))));
        }
        return cesta;
    }

    /**
     * Devuelve el producto que tiene la ID introducida
     * @param idProducto ID del producto
     * @return Objeto de la clase Producto o null si no lo encuentra
     */
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

    /**
     * Devuelve el cliente con el nombre de usuario introducido
     * @param usuario Nombre de usuario
     * @return Objeto de la clase cliente o null si no lo encuentra
     */
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

    /**
     * Devuelve el gestor con el nombre introducido
     * @param nombre Nombre del gestor
     * @return Objeto de la clase gestor o null si no lo encuentra
     */
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

    /**
     * Devuelve la posición del cliente en la lista de clientes del repositorio
     * @param c Objeto cliente
     * @return Posición en la lista o -1 si no lo encuentra
     */
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

    /**
     * Elimina un producto de la cesta del cliente
     * @param c Objeto de la clase cliente
     * @param p Objeto de la clase producto
     * @return True si lo ha eliminado o false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa 
     */
    public boolean eliminarProductoCesta(Cliente c, Producto p) throws SQLException, Exception {
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM cesta WHERE idCliente = " + c.getId() + " AND idProducto = " + p.getId());
        return rs != null;
    }

    /**
     * Añade un gestor a la base de datos y al repositorio
     * @param nombre Nombre del gestor
     * @param direccion Dirección del gestor
     * @param telefono Telefono del gestor
     * @param email Email del gestor
     * @param tipo Tipo de gestor (Proveedor, Operador)
     * @return True si lo ha añadido, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
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

    /**
     * Modifica el gestor en la bbdd y repositorio
     * @param id ID del gestor
     * @param nombre Nombre del gestor
     * @param direccion Dirección del gestor
     * @param telefono Teléfono del gestor
     * @param email Email del gestor
     * @param tipo Tipo de gestor (Operador, Proveedor)
     * @return True si lo ha modificado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa 
     */
    public boolean modificarGestor(int id, String nombre, String direccion, String telefono, String email, String tipo) throws SQLException, Exception {
        boolean añadido = false;
        ResultSet rsModificar = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE gestores SET nombre = '" + nombre + "', direccion = '" + direccion + "', telefono = '" + telefono + "', email = '" + email + "', tipo = '" + tipo + "' WHERE id = " + id);
        if (rsModificar != null) {
            añadido = true;
            cargarGestores();
        }
        return añadido;
    }

    /**
     * Elimina el gestor introducido
     * @param nombre Nombre del gestor
     * @return True si lo ha borrado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public boolean eliminarGestor(String nombre) throws SQLException, Exception {
        boolean eliminado = false;
        ResultSet rsEliminar = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM gestores WHERE nombre = '" + nombre + "';");
        if (rsEliminar != null) {
            eliminado = true;
            cargarGestores();
        }
        return eliminado;
    }

    /**
     * Registra un cliente en la bbdd y repositorio
     * @param usuario Nombre de cliente
     * @param contrasenya Contraseña
     * @param nombre Nombre
     * @param apellidos Apellidos
     * @param dni DNI
     * @param fechaNacimiento Fecha de nacimiento
     * @param direccion Dirección
     * @param telefono Teléfono
     * @param permisos Permisos
     * @return True si lo ha registrado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     * @throws IllegalArgumentException Cuando el DNI no es válido
     */
    public boolean registrarCliente(String usuario, String contrasenya, String nombre, String apellidos, String dni, String fechaNacimiento, String direccion, String telefono, int permisos) throws SQLException, Exception, IllegalArgumentException {
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

    /**
     * Genera la compra del cliente
     * @param idCliente ID del cliente
     * @param subtotal Subtotal del pedido
     * @param total Total del pedido
     * @param tipoPago Tipo de pago (Efectivo, Tarjeta)
     * @return Número de pedido o 0 si no se ha podido generar
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
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
    
    /**
     * Paga un pedido
     * @param numeroPedido Número del pedido
     * @return True si se ha pagado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public boolean pagarPedido(int numeroPedido) throws SQLException, Exception{
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE pedidos SET estadoPedido = 'Pagado' WHERE numeroPedido = " + numeroPedido + ";");
        return rs != null;
    }

    /**
     * Modifica un cliente
     * @param usuario Nombre de usuario del cliente
     * @param contrasenya Contraseña del cliente
     * @param nombre Nombre
     * @param apellidos Apellidos
     * @param dni DNI 
     * @param fechaNacimiento Fecha de nacimiento
     * @param direccion Dirección
     * @param telefono Teléfono
     * @param permisos Permisos
     * @return True si lo ha modificado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa 
     */
    public boolean modificarCliente(String usuario, String contrasenya, String nombre, String apellidos, String dni, String fechaNacimiento, String direccion, String telefono, int permisos) throws SQLException, Exception {
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

    /**
     * Elimina el cliente con el nombre de usuario introducido
     * @param usuario Nombre de usuario
     * @return True si lo ha borrado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public boolean eliminarCliente(String usuario) throws SQLException, Exception {
        boolean eliminado = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM usuarios WHERE usuario = '" + usuario + "';");
        if(rs != null){
            eliminado = true;
            cargarClientes();
        }
        return eliminado;
    }
    
    /**
     * Repara el pedido
     * @param numeroPedido Número de pedido
     * @param diagnostico Diagnóstico del pedido
     * @param precio Precio del pedido
     * @param estadoAnterior Estado anterior del pedido por si falla
     * @return True si lo ha reparado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
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
    
    /**
     * Libera el pedido
     * @param numeroPedido Número de pedido
     * @param codigoLiberacion Código de liberación
     * @param instrucciones Instrucciones de liberación
     * @param estadoAnterior Estado anterior del pedido por si falla
     * @return True si lo ha liberado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
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
    
    /**
     * Completa un pedido
     * @param numeroPedido Número de pedido
     * @return True si lo ha completado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
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
    
    /**
     * Cancela un pedido
     * @param numerPedido Número pedido
     * @return True si lo ha cancelado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
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
    
    /**
     * Modifica un producto
     * @param id ID del producto
     * @param marca Marca del producto
     * @param modelo Modelo del producto
     * @param precio Precio del producto
     * @param stock Stock del producto
     * @param imagen Nombre de la imagen en Imagenes/Productos/
     * @param caracteristicas Características del producto
     * @param color Color del producto
     * @return True si lo ha modificado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
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
    
    /**
     * Elimina un producto por su ID
     * @param id ID del producto
     * @return True si lo ha eliminado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public boolean eliminarProducto(int id) throws SQLException, Exception{
        boolean eliminado = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM productos WHERE id = " + id);
        if(rs != null){
            eliminado = true;
            cargarProductos();
        }
        return eliminado;
    }
    
    /**
     * Añade un producto
     * @param marca Marca del producto
     * @param modelo Modelo del producto
     * @param precio Precio del producto
     * @param color Color del producto
     * @param caracteristicas Características del producto
     * @param stock Stock del producto
     * @param imagen Nombre de la imagen en Imagenes/Productos/
     * @return True si lo ha añadido, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public boolean añadirProducto(String marca, String modelo, Double precio, String color, String caracteristicas, int stock, String imagen) throws SQLException, Exception{
        boolean añadido = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO productos (marca, modelo, precio, color, descripcion, stock, imagen) VALUES ('" + marca + "', '" + modelo + "', " + precio + " , '" + color + "', '" + caracteristicas + "', " + stock +", '" + imagen + "');");
        if(rs != null){
            añadido = true;
            cargarProductos();
        }
        return añadido;
    }
    
    /**
     * Devuelve una lista con las marcas de productos disponibles
     * @return Lista con las marcas de productos disponibles
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public ArrayList<String> obtenerMarcasProductos() throws SQLException, Exception{
        ArrayList<String> lista = new ArrayList<String>();
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT distinct marca FROM productos;");
        while(rs.next()){
            lista.add(rs.getString("marca"));
        }
        return lista;
    }
    
    /**
     * Obtiene los modelos disponibles de la marca
     * @param marca Marca del producto
     * @return Lista con los modelos de esa marca
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public ArrayList<String> obtenerModelosProductos(String marca) throws SQLException, Exception{
        ArrayList<String> lista = new ArrayList<String>();
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT modelo FROM productos WHERE marca = '" + marca + "' GROUP BY modelo;");
        while(rs.next()){
            lista.add(rs.getString("modelo"));
        }
        return lista;
    }
    
    /**
     * Comprueba si un producto está disponible
     * @param id ID del producto
     * @return True si está disponible, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public boolean productoDisponible(int id) throws SQLException, Exception{
        ResultSet consultaStock = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT stock FROM productos WHERE id = " + id);
        consultaStock.next();
        return Integer.parseInt(consultaStock.getString("stock")) > 0;
    }
    
    /**
     * Añade un producto a la cesta del cliente
     * @param idCliente ID del cliente
     * @param producto Objeto producto
     * @return True si lo ha añadido, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa 
     */
    public boolean añadirProductoCesta(int idCliente, Producto producto) throws SQLException, Exception{
        boolean añadido = false;
        ResultSet rs = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO cesta VALUES (" + idCliente + ", " + producto.getId() + ");");
        if(rs != null){
            añadido = true;
            Sesion.miCliente().getCliente().getCesta().add(producto);
        }
        return añadido;
    }
    
    /**
     * Genera una liberación
     * @param idCliente ID del cliente
     * @param subtotal Subtotal del pedido
     * @param total Total del pedido
     * @param tipoPago Tipo de pago (Tarjeta)
     * @param operador Operador
     * @param imei IMEI del telñefono
     * @return Devuelve el número de pedido de la liberación o 0 si no se ha podido realizar
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa 
     */
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
                cargarClientes();
                Sesion.miCliente().setCliente(clientePorUsuario(Sesion.miCliente().getCliente().getNombreUsuario()));
            }
        } else{
            throw new Exception("No se ha podido generar el pedido de la liberación.");
        }
        return numeroPedido;
    }

    /**
     * Genera una reparación
     * @param idCliente ID del cliente
     * @param subtotal Subtotal del pedido
     * @param total Total del pedido
     * @param tipoPago Tipo de pago del pedido (Efectivo)
     * @param proveedor Proveedor
     * @param diagnostico Diagnóstico de la reparación
     * @return Número de pedido de la reparación o 0 si no se ha podido generar
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
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
                cargarClientes();
                Sesion.miCliente().setCliente(clientePorUsuario(Sesion.miCliente().getCliente().getNombreUsuario()));
            }
        }
        return numeroPedido;
    }

    /**
     * Devuelve un pedido por su ID
     * @param numeroPedido ID de pedido
     * @return Objeto de la clase pedido
     */
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
