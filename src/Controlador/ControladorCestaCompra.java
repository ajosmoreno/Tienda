package Controlador;

import Modelo.BaseDeDatos;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.CestaCompra;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorCestaCompra {
    
    private CestaCompra miVentana;
    
    public ControladorCestaCompra(CestaCompra miVentana){
        this.miVentana = miVentana;
    }

    public void cargarCesta() {
        DefaultTableModel dtm;
        dtm = new DefaultTableModel(){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return Boolean.class;
                    case 4:
                        return ImageIcon.class;
                    default:
                        return super.getColumnClass(columnIndex);
                }
            }
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 0;
            }
        };
        dtm.addColumn("");
        dtm.addColumn("Marca");
        dtm.addColumn("Modelo");
        dtm.addColumn("Color");
        dtm.addColumn("Imagen");
        dtm.addColumn("Precio");
        ArrayList<Producto> cesta = Sesion.miCliente().getCliente().getCesta();
        double total = 0;
        for(Producto p: cesta){
            total += p.getPrecio();
            ImageIcon imageIcon = new ImageIcon("Imagenes/Productos/" + p.getImagen());
            Image image = getScaledImage(imageIcon.getImage(), 190, 95);
            imageIcon = new ImageIcon(image);
            Object[] fila = { true, p.getMarca(), p.getModelo(), p.getColor(), imageIcon, p.getPrecio()};
            dtm.addRow(fila);
        }
        miVentana.getjTableCesta().setModel(dtm);
        miVentana.getjTableCesta().getColumn("").setMaxWidth(50);
        miVentana.getjTableCesta().getColumn("Marca").setMaxWidth(150);
        miVentana.getjTableCesta().getColumn("Modelo").setMaxWidth(150);
        miVentana.getjTableCesta().getColumn("Color").setMaxWidth(150);
        miVentana.getjTableCesta().getColumn("Imagen").setMaxWidth(190);
        miVentana.getjTableCesta().getColumn("Precio").setMaxWidth(100);
        miVentana.getjTableCesta().setRowHeight(95);
        miVentana.getjLabelPrecioTotal().setText(total + "€");
        if(dtm.getRowCount() > 0){ 
            miVentana.getjButtonBorrarProducto().setEnabled(true);
            miVentana.getjButtonPagarTarjeta().setEnabled(true);
            miVentana.getjButtonPagoEfectivo().setEnabled(true);
        } else{
            miVentana.getjButtonBorrarProducto().setEnabled(false);
            miVentana.getjButtonPagarTarjeta().setEnabled(false);
            miVentana.getjButtonPagoEfectivo().setEnabled(false);
        }
        
    }
    
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public void borrarProductos() throws SQLException, Exception {
        if(mostrarAviso()){
            boolean borrado = false;
            for(int i = 0; i < miVentana.getjTableCesta().getRowCount(); i++){
                boolean seleccionado = (Boolean)miVentana.getjTableCesta().getValueAt(i, 0);
                if(!seleccionado){
                    Producto p = Sesion.miCliente().getCliente().getCesta().get(i);
                    if(Repositorio.repositorio().eliminarProductoCesta(Sesion.miCliente().getCliente(), p)) borrado = true;
                    else
                        miVentana.mostrarError("No se ha podido eliminar un producto " + i + " de la cesta.");
                }
            }
            if(borrado){
                Repositorio.repositorio().cargarClientes();
                Sesion.miCliente().setCliente(Repositorio.repositorio().clientePorUsuario(Sesion.miCliente().getCliente().getNombreUsuario()));
                cargarCesta();
            }
        }
    }
    
    public boolean mostrarAviso(){
        int opcion = JOptionPane.showConfirmDialog(miVentana, "Se borrarán los productos de la cesta que NO están seleccionados.\n\n¿Deseas continuar?", "ATENCIÓN", JOptionPane.OK_CANCEL_OPTION);
        return opcion == JOptionPane.OK_OPTION;
    }

    public void pagarEfectivo() throws Exception {
        generarPedido("Efectivo");
    }

    public void pagarTarjeta() throws Exception {
        generarPedido("Tarjeta");
    }
    
    public void generarPedido(String tipoPago) throws SQLException, Exception{
        int idCliente = Sesion.miCliente().getCliente().getId();
        double total = Double.parseDouble(miVentana.getjLabelPrecioTotal().getText().replace("€", ""));
        double subtotal = total * 0.79;
        ResultSet rsPedido = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO pedidos (idCliente, subtotal, total, tipoPago, estadoPedido) VALUES (" + idCliente + ", " + subtotal + ", " + total + ", '" + tipoPago + "', 'Procesando');");
        if(rsPedido != null){
            rsPedido.next();
            ResultSet rsCompra = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO compras VALUES (" + rsPedido.getString("numeroPedido") + ");");
            if(rsCompra != null){
                ArrayList<Producto> cesta = Sesion.miCliente().getCliente().getCesta();
                boolean correcto = false;
                for(Producto p: cesta){
                    ResultSet stockProducto = BaseDeDatos.baseDeDatos().ejecutarConsultaSelect("SELECT stock FROM productos WHERE id = " + p.getId());
                    stockProducto.next();
                    if(Integer.parseInt(stockProducto.getString("stock")) > 0){
                        ResultSet productoComprado = BaseDeDatos.baseDeDatos().ejecutarConsulta("INSERT INTO productoscomprados (numeroPedido, idProducto) VALUES (" + rsPedido.getString("numeroPedido") + ", " + p.getId() + ");");
                        if(productoComprado != null){
                            BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE productos SET stock = stock - 1 WHERE id = " + p.getId());
                            ResultSet eliminarProductoCesta = BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM cesta WHERE idCliente = " + idCliente + " AND idProducto = " + p.getId());
                            if(eliminarProductoCesta == null){
                                miVentana.mostrarError("No se ha podido eliminar el producto " + p.getMarca() + " " + p.getModelo() + " " + p.getColor() + " de la cesta.\n\nEl pedido de ese producto si se ha procesado, solo que volverá a aparecer en la cesta.");
                            } else{
                                correcto = true;
                            }
                        } else{
                            miVentana.mostrarError("No se ha podido procesar el producto " + p.getMarca() + " " + p.getModelo() + " " + p.getColor() + " de la cesta.\n\nInténtelo de nuevo en otro pedido.");
                        }
                    }else{
                        BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM cesta WHERE idCliente = " + idCliente + " AND idProducto = " + p.getId());
                        miVentana.mostrarError("Mientras añadias otros productos, el producto " + p.getMarca() + " " + p.getModelo() + " " + p.getColor() + " se ha agotado.\n\nEste producto no se procesará.");
                    }
                }
                if(tipoPago.equals("Efectivo") && correcto)
                    miVentana.mostrarMensaje("El pedido ha sido procesado, puede pasar a recogerlo en la caja dando este número " + rsPedido.getString("numeroPedido") + ".");
                else if(tipoPago.equals("Tarjeta") && correcto){
                    miVentana.mostrarMensaje("Introduzca su tarjeta de crédito/débito en el lector y pulse aceptar.");
                    JOptionPane.showInputDialog("Introduzca el pin de la tarjeta");
                    ResultSet pagado = BaseDeDatos.baseDeDatos().ejecutarConsulta("UPDATE pedidos SET estadoPedido = 'Pagado' WHERE numeroPedido = " + rsPedido.getString("numeroPedido") + ";");
                    if(pagado != null){
                        miVentana.mostrarMensaje("El pedido ha sido procesado y pagado, puede pasar a recogerlo en la caja dando este número " + rsPedido.getString("numeroPedido") + ".");
                    } else
                        miVentana.mostrarError("No se ha podido validar la tarjeta, puede pasar a recogerlo en la caja dando este número " + rsPedido.getString("numeroPedido") + " y pagarlo en caja.");
                } else{
                    BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM compras WHERE numeroPedido = " + rsPedido.getString("numeroPedido"));
                    BaseDeDatos.baseDeDatos().ejecutarConsulta("DELETE FROM pedidos WHERE numeroPedido = " + rsPedido.getString("numeroPedido"));
                    miVentana.mostrarMensaje("No se ha comprado ningún producto.");
                }
                Sesion.miCliente().getCliente().setCesta(Repositorio.repositorio().cestaPorCliente(Sesion.miCliente().getCliente().getId()));
                cargarCesta();
                Repositorio.repositorio().cargarProductos();
                Repositorio.repositorio().cargarPedidos();
                Repositorio.repositorio().cargarClientes();
                Sesion.miCliente().getCliente().setPedidosRealizados(new ArrayList<Pedido>());
                for(Pedido p: Repositorio.repositorio().devolverPedidos()){
                    if(p.getCliente() == Sesion.miCliente().getCliente().getId()){
                        Sesion.miCliente().getCliente().getPedidosRealizados().add(p);
                    }
                }
            } else{
                miVentana.mostrarError("No se ha podigo generar la compra.");
            }
        } else{
            miVentana.mostrarMensaje("No se ha podido generar el pedido.");
        }
    }
}
