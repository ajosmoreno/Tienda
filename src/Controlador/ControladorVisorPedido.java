package Controlador;

import Modelo.Compra;
import Modelo.Producto;
import Modelo.Repositorio;
import Vista.VisorPedido;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *  Clase que accederá al modelo
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorVisorPedido {
    
    private VisorPedido miVentana;

    /**
     * Constructor que enlaza el controlador con la vista
     * @param miVentana Vista VisorPedido
     */
    public ControladorVisorPedido(VisorPedido miVentana) {
        this.miVentana = miVentana;
    }
    
    /**
     * Muestra el pedido
     * @param numeroPedido Número de pedido
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void mostrarPedido(int numeroPedido) throws ClassNotFoundException, Exception{
        DefaultTableModel dtm;
        dtm = new DefaultTableModel(){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if(columnIndex == 3) return ImageIcon.class;
                else return super.getColumnClass(columnIndex);
            }
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 0;
            }
        };
        dtm.addColumn("Marca");
        dtm.addColumn("Modelo");
        dtm.addColumn("Color");
        dtm.addColumn("Imagen");
        dtm.addColumn("Precio");
        Compra c = (Compra)Repositorio.repositorio().pedidoPorID(numeroPedido);
        ArrayList<Producto> listaProductos = c.getProductos();
        double total = 0;
        for(Producto p: listaProductos){
            total += p.getPrecio();
            ImageIcon imageIcon = new ImageIcon("Imagenes/Productos/" + p.getImagen());
            Image image = getScaledImage(imageIcon.getImage(), 115, 115);
            imageIcon = new ImageIcon(image);
            Object[] fila = {p.getMarca(), p.getModelo(), p.getColor(), imageIcon, p.getPrecio()};
            dtm.addRow(fila);
        }
        miVentana.getjTableProductos().setModel(dtm);
        miVentana.getjTableProductos().getColumn("Marca").setMaxWidth(150);
        miVentana.getjTableProductos().getColumn("Modelo").setMaxWidth(150);
        miVentana.getjTableProductos().getColumn("Color").setMaxWidth(150);
        miVentana.getjTableProductos().getColumn("Imagen").setMaxWidth(190);
        miVentana.getjTableProductos().getColumn("Precio").setMaxWidth(100);
        miVentana.getjTableProductos().setRowHeight(115);
    }
    
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
