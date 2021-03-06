/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCestaCompra;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class CestaCompra extends javax.swing.JDialog {

    private ControladorCestaCompra miControlador;
    /**
     * Muestra los iconos y lo que se tiene que ver
     */
    public CestaCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        miControlador = new ControladorCestaCompra(this);
        miControlador.cargarCesta();
        setLocationRelativeTo(null);
        jButtonVolver.setIcon(new ImageIcon("Imagenes/icon/backnormal.png"));
        jButtonVolver.setPressedIcon(new ImageIcon("Imagenes/icon/backpressed.png"));
        jButtonVolver.setRolloverIcon(new ImageIcon("Imagenes/icon/backrollover.png"));
        jLabelFondo.setIcon(new ImageIcon("Imagenes/pedidoscliente.jpg"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPagoEfectivo = new javax.swing.JButton();
        jButtonPagarTarjeta = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jButtonBorrarProducto = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jLabelPrecioTotal = new javax.swing.JLabel();
        jScrollPaneCesta = new javax.swing.JScrollPane();
        jTableCesta = new javax.swing.JTable();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cesta de Compra");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonPagoEfectivo.setText("Realizar pago en efectivo");
        jButtonPagoEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagoEfectivoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPagoEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, 50));

        jButtonPagarTarjeta.setText("Realizar pago con tarjeta");
        jButtonPagarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagarTarjetaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPagarTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, 50));

        jButtonVolver.setToolTipText("Volver atras");
        jButtonVolver.setBorder(null);
        jButtonVolver.setBorderPainted(false);
        jButtonVolver.setContentAreaFilled(false);
        jButtonVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonVolverMouseEntered(evt);
            }
        });
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 90, 90));

        jButtonBorrarProducto.setText("Borrar producto");
        jButtonBorrarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonBorrarProductoMouseEntered(evt);
            }
        });
        jButtonBorrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBorrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, -1, 50));

        jLabelTotal.setText("TOTAL:");
        getContentPane().add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, 20));
        getContentPane().add(jLabelPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 100, 20));

        jTableCesta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "Marca", "Modelo", "", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneCesta.setViewportView(jTableCesta);
        if (jTableCesta.getColumnModel().getColumnCount() > 0) {
            jTableCesta.getColumnModel().getColumn(0).setMinWidth(10);
            jTableCesta.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTableCesta.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        getContentPane().add(jScrollPaneCesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 777, 360));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonPagoEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagoEfectivoActionPerformed
        try {
            miControlador.pagarEfectivo();
        } catch (Exception ex) {
            mostrarError("Error al procesar el pedido");
        }
    }//GEN-LAST:event_jButtonPagoEfectivoActionPerformed

    private void jButtonBorrarProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBorrarProductoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBorrarProductoMouseEntered

    private void jButtonBorrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarProductoActionPerformed
        try {
            miControlador.borrarProductos();
        } catch (Exception ex) {
            mostrarError("Error al borrar los productos de la cesta.");
        }
    }//GEN-LAST:event_jButtonBorrarProductoActionPerformed

    private void jButtonPagarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagarTarjetaActionPerformed
        try {
            miControlador.pagarTarjeta();
        } catch (Exception ex) {
            mostrarError("Error al pagar con tarjeta.");
        }
    }//GEN-LAST:event_jButtonPagarTarjetaActionPerformed

    private void jButtonVolverMouseEntered(java.awt.event.MouseEvent evt) {                                                   
        // TODO add your handling code here:
    }  
   
    /**
     * Muestra un mensaje de error al usuario
     * @param mensaje Mensaje de error
     */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje de información al usuario
     * @param mensaje Mensaje de información
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.DEFAULT_OPTION);
    }
    
    /**
     * Devuelve la tabla de la cesta
     * @return Tabla de la cesta
     */
    public JTable getjTableCesta() {
        return jTableCesta;
    }

    /**
     * Devuelve el botón de borrar producto
     * @return Botón de borrar producto
     */
    public JButton getjButtonBorrarProducto() {
        return jButtonBorrarProducto;
    }

    /**
     * Devuelve el botón de pagar con tarjeta
     * @return Botón pagar con tarjeta
     */
    public JButton getjButtonPagarTarjeta() {
        return jButtonPagarTarjeta;
    }

    /**
     * Devuelve el botón de pagar en efectivo
     * @return Botón pagar en efectivo
     */
    public JButton getjButtonPagoEfectivo() {
        return jButtonPagoEfectivo;
    }

    /**
     * Devueve el label del precio total
     * @return Label del precio total
     */
    public JLabel getjLabelPrecioTotal() {
        return jLabelPrecioTotal;
    }
    
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
            java.util.logging.Logger.getLogger(CestaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CestaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CestaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CestaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CestaCompra dialog = new CestaCompra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonBorrarProducto;
    private javax.swing.JButton jButtonPagarTarjeta;
    private javax.swing.JButton jButtonPagoEfectivo;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelPrecioTotal;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPaneCesta;
    private javax.swing.JTable jTableCesta;
    // End of variables declaration//GEN-END:variables
}
