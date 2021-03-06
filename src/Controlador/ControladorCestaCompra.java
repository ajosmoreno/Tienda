package Controlador;

import Modelo.Producto;
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.CestaCompra;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que accederá al modelo
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorCestaCompra {
    
    private CestaCompra miVentana;
    
    /**
     * Constructor del controlador que enlaza el controlador con la vista
     * @param miVentana Vista CestaCompra
     */
    public ControladorCestaCompra(CestaCompra miVentana){
        this.miVentana = miVentana;
    }

    /**
     * Carga los productos de la cesta en la tabla
     */
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
            Image image = getScaledImage(imageIcon.getImage(), 115, 115);
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
        miVentana.getjTableCesta().setRowHeight(115);
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

    /**
     * Borra productos de la cesta
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa 
     */
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
    
    /**
     * Muestra un aviso informando de que productos se van a borrar
     * @return True si acepta el aviso, false si no
     */
    public boolean mostrarAviso(){
        int opcion = JOptionPane.showConfirmDialog(miVentana, "Se borrarán los productos de la cesta que NO están seleccionados.\n\n¿Deseas continuar?", "ATENCIÓN", JOptionPane.OK_CANCEL_OPTION);
        return opcion == JOptionPane.OK_OPTION;
    }

    /**
     * Paga el pedido en Efectivo
     * @throws Exception Error cuando no se puede pagar
     */
    public void pagarEfectivo() throws Exception {
        generarPedido("Efectivo");
    }

    /**
     * Paga el pedido con Tarjeta
     * @throws Exception 
     */
    public void pagarTarjeta() throws Exception {
        generarPedido("Tarjeta");
    }
    
    /**
     * Genera el pedido dependiendo del tipo de pago
     * @param tipoPago Tipo de pago (Efectivo, Tarjeta)
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public void generarPedido(String tipoPago) throws SQLException, Exception{
        int idCliente = Sesion.miCliente().getCliente().getId();
        double total = Double.parseDouble(miVentana.getjLabelPrecioTotal().getText().replace("€", ""));
        double subtotal = total * 0.79;
        int pedidoGenerado = Repositorio.repositorio().generarCompra(idCliente, subtotal, total, tipoPago);
        if(pedidoGenerado > 0){
            if(tipoPago.equals("Efectivo")){
                miVentana.mostrarMensaje("El pedido ha sido procesado, puede pasar a recogerlo en la caja dando este número " + pedidoGenerado + ".");
            } else if(tipoPago.equals("Tarjeta")){
                miVentana.mostrarMensaje("Introduzca su tarjeta de crédito/débito en el lector y pulse aceptar.");
                JOptionPane.showInputDialog("Introduzca el pin de la tarjeta");
                if(Repositorio.repositorio().pagarPedido(pedidoGenerado)){
                    miVentana.mostrarMensaje("El pedido ha sido procesado y pagado, puede pasar a recogerlo en la caja dando este número " + pedidoGenerado + ".");
                } else
                    miVentana.mostrarError("No se ha podido validar la tarjeta, puede pasar a recogerlo en la caja dando este número " + pedidoGenerado + " y pagarlo en caja.");
            }
            Sesion.miCliente().setCliente(Repositorio.repositorio().clientePorUsuario(Sesion.miCliente().getCliente().getNombreUsuario()));
            cargarCesta();
        } else{
            miVentana.mostrarError("No se ha podido generar el pedido.");
        }
    }
}
