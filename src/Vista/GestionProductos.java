/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.ImageIcon;

/**
 *
 * @author Antonio
 */
public class GestionProductos extends javax.swing.JDialog {

    /**
     * Creates new form GestionProductos
     */
    public GestionProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jButtonVolverAtras.setIcon(new ImageIcon("Imagenes/botonvolver.png"));
        jButtonCancelar.setIcon(new ImageIcon("Imagenes/iconocancelar.jpg"));
        jButtonAceptar.setIcon(new ImageIcon("Imagenes/iconook.jpg"));
        jLabelBuscador.setVisible(false);
        jTextFieldBuscadorProductos.setVisible(false);
        jButtonBuscar.setVisible(false);
        jLabelMarca.setVisible(false);
        jLabelModelo.setVisible(false);
        jLabelPrecio.setVisible(false);
        jLabelFoto.setVisible(false);
        jLabelCaracteristicas.setVisible(false);
        jTextAreaCarateristicas.setVisible(false);
        jScrollPane1.setVisible(false);
        jTextFieldMarca.setVisible(false);
        jTextFieldModelo.setVisible(false);
        jTextFieldFoto.setVisible(false);
        jTextFieldPrecio.setVisible(false);
        jButtonCancelar.setVisible(false);
        jButtonAceptar.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonModificarProducto = new javax.swing.JButton();
        jButtonEliminarProducto = new javax.swing.JButton();
        jButtonInsertarProducto = new javax.swing.JButton();
        jButtonVolverAtras = new javax.swing.JButton();
        jLabelBuscador = new javax.swing.JLabel();
        jTextFieldBuscadorProductos = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabelModelo = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelCaracteristicas = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldFoto = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCarateristicas = new javax.swing.JTextArea();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonModificarProducto.setText("Modificar producto");
        jButtonModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 157, 139, 69));

        jButtonEliminarProducto.setText("Eliminar producto");
        jButtonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 261, 139, 69));

        jButtonInsertarProducto.setText("Añadir producto");
        jButtonInsertarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInsertarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 56, 139, 69));

        jButtonVolverAtras.setToolTipText("Volver atras");
        jButtonVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 370, 90, 90));

        jLabelBuscador.setText("Id producto: ");
        getContentPane().add(jLabelBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));
        getContentPane().add(jTextFieldBuscadorProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 150, -1));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, -1, -1));

        jLabelModelo.setText("Modelo: ");
        getContentPane().add(jLabelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        jLabelMarca.setText("Marca: ");
        getContentPane().add(jLabelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        jLabelCaracteristicas.setText("Caracteristicas: ");
        getContentPane().add(jLabelCaracteristicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        jLabelPrecio.setText("Precio: ");
        getContentPane().add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, -1));

        jLabelFoto.setText("Foto: ");
        getContentPane().add(jLabelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));
        getContentPane().add(jTextFieldMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 270, -1));
        getContentPane().add(jTextFieldModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 270, -1));
        getContentPane().add(jTextFieldFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 270, -1));
        getContentPane().add(jTextFieldPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 270, -1));

        jTextAreaCarateristicas.setColumns(20);
        jTextAreaCarateristicas.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCarateristicas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 490, 250));

        jButtonCancelar.setToolTipText("Aceptar");
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 570, 90, 90));

        jButtonAceptar.setToolTipText("Aceptar");
        getContentPane().add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, 90, 90));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonInsertarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarProductoActionPerformed
        // TODO add your handling code here:
        jButtonCancelar.setVisible(false);
        jButtonAceptar.setVisible(false);
        jTextAreaCarateristicas.setVisible(false);
        jButtonCancelar.setVisible(true);
        jButtonAceptar.setVisible(true);
        jTextAreaCarateristicas.setVisible(true);
        jScrollPane1.setVisible(true);
        jTextFieldMarca.setVisible(true);
        jTextFieldModelo.setVisible(true);
        jTextFieldFoto.setVisible(true);
        jTextFieldPrecio.setVisible(true);
        jLabelMarca.setVisible(true);
        jLabelModelo.setVisible(true);
        jLabelPrecio.setVisible(true);
        jLabelFoto.setVisible(true);
        jLabelCaracteristicas.setVisible(true);
    }//GEN-LAST:event_jButtonInsertarProductoActionPerformed

    private void jButtonModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarProductoActionPerformed
        // TODO add your handling code here:
        jLabelBuscador.setVisible(true);
        jTextFieldBuscadorProductos.setVisible(true);
        jButtonBuscar.setVisible(true);
        jLabelMarca.setVisible(false);
        jLabelModelo.setVisible(false);
        jLabelPrecio.setVisible(false);
        jLabelFoto.setVisible(false);
        jLabelCaracteristicas.setVisible(false);
        jTextAreaCarateristicas.setVisible(false);
        jScrollPane1.setVisible(false);
        jTextFieldMarca.setVisible(false);
        jTextFieldModelo.setVisible(false);
        jTextFieldFoto.setVisible(false);
        jTextFieldPrecio.setVisible(false);
        jButtonCancelar.setVisible(false);
        jButtonAceptar.setVisible(false);
    }//GEN-LAST:event_jButtonModificarProductoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        jButtonCancelar.setVisible(true);
        jButtonAceptar.setVisible(true);
        jTextAreaCarateristicas.setVisible(true);
        jScrollPane1.setVisible(true);
        jTextFieldMarca.setVisible(true);
        jTextFieldModelo.setVisible(true);
        jTextFieldFoto.setVisible(true);
        jTextFieldPrecio.setVisible(true);
        jLabelMarca.setVisible(true);
        jLabelModelo.setVisible(true);
        jLabelPrecio.setVisible(true);
        jLabelFoto.setVisible(true);
        jLabelCaracteristicas.setVisible(true);
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProductoActionPerformed
        // TODO add your handling code here:
        jLabelBuscador.setVisible(true);
        jTextFieldBuscadorProductos.setVisible(true);
        jButtonBuscar.setVisible(true);
        jLabelMarca.setVisible(false);
        jLabelModelo.setVisible(false);
        jLabelPrecio.setVisible(false);
        jLabelFoto.setVisible(false);
        jLabelCaracteristicas.setVisible(false);
        jTextAreaCarateristicas.setVisible(false);
        jScrollPane1.setVisible(false);
        jTextFieldMarca.setVisible(false);
        jTextFieldModelo.setVisible(false);
        jTextFieldFoto.setVisible(false);
        jTextFieldPrecio.setVisible(false);
        jButtonCancelar.setVisible(false);
        jButtonAceptar.setVisible(false);
    }//GEN-LAST:event_jButtonEliminarProductoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionProductos dialog = new GestionProductos(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminarProducto;
    private javax.swing.JButton jButtonInsertarProducto;
    private javax.swing.JButton jButtonModificarProducto;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabelBuscador;
    private javax.swing.JLabel jLabelCaracteristicas;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCarateristicas;
    private javax.swing.JTextField jTextFieldBuscadorProductos;
    private javax.swing.JTextField jTextFieldFoto;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldPrecio;
    // End of variables declaration//GEN-END:variables
}
