/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorInterfazCompra;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 *
 * @author Antonio
 */
public class InterfazCompra extends javax.swing.JDialog {

    private ControladorInterfazCompra miControlador;
    /**
     * Creates new form InterfazCompra
     */
    public InterfazCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jTextPaneCaracteristicas.setVisible(false);
        jLabelFondo.setIcon(new ImageIcon("Imagenes/fondocatalogo.jpg"));
        jButtonAñadirCesta.setIcon(new ImageIcon("Imagenes/botonañadirproducto.png"));
        jButtonCestaCompra.setIcon(new ImageIcon("Imagenes/botonircesta.png"));
        jButtonVolver.setIcon(new ImageIcon("Imagenes/botonvolver.png"));
        miControlador = new ControladorInterfazCompra(this);
        try {
            miControlador.cargarMarcas();
        } catch (Exception ex) {
            mostrarError("Ha ocurrido un error al cargar los productos.");
        }
    }

    public void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabelCatalogo = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jButtonAñadirCesta = new javax.swing.JButton();
        jLabelOperador = new javax.swing.JLabel();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        jComboBoxOperador = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabelCaracteristicas = new javax.swing.JLabel();
        jLabelImagen = new javax.swing.JLabel();
        jScrollPanecaracteristicas = new javax.swing.JScrollPane();
        jTextPaneCaracteristicas = new javax.swing.JTextPane();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelPrecioTotal = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();
        jButtonCestaCompra = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCatalogo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelCatalogo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCatalogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCatalogo.setText("Catalogo");
        getContentPane().add(jLabelCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 260, 53));

        jLabelMarca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelMarca.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMarca.setText("Marca: ");
        getContentPane().add(jLabelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 70, 20));

        jLabelModelo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelModelo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelModelo.setText("Modelo:");
        getContentPane().add(jLabelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 70, 24));

        jButtonAñadirCesta.setToolTipText("Añadir producto a la cesta de compra");
        getContentPane().add(jButtonAñadirCesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 90, 90));

        jLabelOperador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelOperador.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOperador.setText("Operador:");
        getContentPane().add(jLabelOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 80, 24));

        jComboBoxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 120, -1));

        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 120, -1));

        getContentPane().add(jComboBoxOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 118, -1));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCaracteristicas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCaracteristicas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCaracteristicas.setText("Caracteristicas: ");
        jPanel2.add(jLabelCaracteristicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 27, -1, -1));
        jPanel2.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 260, 240));

        jTextPaneCaracteristicas.setFocusable(false);
        jScrollPanecaracteristicas.setViewportView(jTextPaneCaracteristicas);

        jPanel2.add(jScrollPanecaracteristicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 53, 285, 282));

        jLabelPrecio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPrecio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPrecio.setText("Precio: ");
        jPanel2.add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabelPrecioTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPrecioTotal.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabelPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 58, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 600, 410));

        jButtonVolver.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVolver.setToolTipText("Volver atras");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, 90, 90));

        jButtonCestaCompra.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCestaCompra.setToolTipText("Ir a la cesta de la compra");
        jButtonCestaCompra.setOpaque(false);
        jButtonCestaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCestaCompraActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCestaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 90, 90));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
       jScrollPanecaracteristicas.setVisible(true);
       jTextPaneCaracteristicas.setVisible(true); 
       establecerCaracteristicas();
       jLabelPrecioTotal.setText("500 €");
       establecerImagen();
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonCestaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCestaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCestaCompraActionPerformed

    private void jComboBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcaActionPerformed
        try {
            miControlador.mostrarModelos();
        } catch (Exception ex) {
            mostrarError("Ha ocurrido un error al cargar los modelos.");
        }
    }//GEN-LAST:event_jComboBoxMarcaActionPerformed

    /**
     * @param args the command line arguments
     */
    public JComboBox getjComboBoxModelo() {
        return jComboBoxModelo;
    }

    public void establecerCaracteristicas() {
        jTextPaneCaracteristicas.setText(caracteristicasIphone6s);
    }

    public void establecerImagen() {
        jLabelImagen.setIcon(icon);
    }

    
    
    String path = "Imagenes/Productos/iphone6s.jpg";
    //URL url = this.getClass().getResource(path);
    ImageIcon icon = new ImageIcon(path);


    String caracteristicasIphone6s = new String("Procesador: Chip A9 con arquitectura de 64 bits\n"
            + "Capacidad: 32GB" 
            + "Pantalla panorámica de 4,7 pulgadas (en diagonal) retroiluminada por LED\n"
            + "Pantalla Multi-Touch con tecnología IPS\n"
            + "Resolución de 1.334 por 750 a 326 p/p\n"
            + "Contraste de 1.400:1 (típico)");

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /**
         *
         * @return
         */
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfazCompra dialog = new InterfazCompra(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JComboBox<String> getjComboBoxMarca() {
        return jComboBoxMarca;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadirCesta;
    private javax.swing.JButton jButtonCestaCompra;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxMarca;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JComboBox<String> jComboBoxOperador;
    private javax.swing.JLabel jLabelCaracteristicas;
    private javax.swing.JLabel jLabelCatalogo;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelOperador;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelPrecioTotal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPanecaracteristicas;
    private javax.swing.JTextPane jTextPaneCaracteristicas;
    // End of variables declaration//GEN-END:variables

    
}
