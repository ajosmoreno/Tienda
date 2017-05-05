package Vista;

import Controlador.ControladorGestionPedidos;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Antonio
 */
public class GestionPedidos extends javax.swing.JDialog {

    /**
     * Creates new form GestionPedidos
     */
    public GestionPedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
       
        initComponents();
        jButtonBuscar.setIcon(new ImageIcon("Imagenes/icon/buscar2.png"));
        jButtonBuscar.setRolloverIcon(new ImageIcon("Imagenes/icon/buscar4.png"));
        jButtonBuscar.setPressedIcon(new ImageIcon("Imagenes/icon/buscar3.png"));
        jTextFieldNombreCliente.setVisible(false);
        jLabelNombreCliente.setVisible(false);
        jButtonBuscar.setVisible(false);
        jTablePedidos.setVisible(false);
        jButtonCancelarPedido.setVisible(false);
        jButtonRealizar.setVisible(false);
        jScrollPanePedidos.setVisible(false);
        setLocationRelativeTo(null);
        jButtonVolverAtras.setIcon(new ImageIcon("Imagenes/icon/botonvolver.png"));
        jButtonVolverAtras.setIcon(new ImageIcon("Imagenes/icon/botonvolver.png"));
        jButtonVolverAtras.setPressedIcon(new ImageIcon("Imagenes/icon/botonvolver80%.png"));
        jButtonVolverAtras.setRolloverIcon(new ImageIcon("Imagenes/icon/botonvolver120%.png"));
        
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonComprobarPedido = new javax.swing.JButton();
        jButtonCancelarPedido = new javax.swing.JButton();
        jButtonListarPedidos = new javax.swing.JButton();
        jButtonVolverAtras = new javax.swing.JButton();
        jLabelNombreCliente = new javax.swing.JLabel();
        jTextFieldNombreCliente = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPanePedidos = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jButtonRealizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Gestion de Pedidos"); // NOI18N
        setSize(new java.awt.Dimension(920, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonComprobarPedido.setText("Comprobar Pedidos Pendientes");
        jButtonComprobarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComprobarPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonComprobarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 107, 230, 40));

        jButtonCancelarPedido.setText("Cancelar Pedido");
        getContentPane().add(jButtonCancelarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 158, 39));

        jButtonListarPedidos.setText("Listar Pedidos");
        jButtonListarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonListarPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 176, 230, 39));

        jButtonVolverAtras.setToolTipText("Volver atras");
        jButtonVolverAtras.setBorder(null);
        jButtonVolverAtras.setBorderPainted(false);
        jButtonVolverAtras.setContentAreaFilled(false);
        jButtonVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 90, 90));

        jLabelNombreCliente.setText("Nombre Cliente: ");
        getContentPane().add(jLabelNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));
        getContentPane().add(jTextFieldNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 169, -1));

        jButtonBuscar.setBorder(null);
        jButtonBuscar.setBorderPainted(false);
        jButtonBuscar.setContentAreaFilled(false);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 40, 40));

        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "Nº Pedido", "Marca", "Modelo", "Fecha Pedido", "Pedido Realizado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPanePedidos.setViewportView(jTablePedidos);
        if (jTablePedidos.getColumnModel().getColumnCount() > 0) {
            jTablePedidos.getColumnModel().getColumn(0).setResizable(false);
            jTablePedidos.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTablePedidos.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPanePedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 620, 270));

        jButtonRealizar.setText("Realizar Pedido");
        getContentPane().add(jButtonRealizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 149, 39));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonComprobarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComprobarPedidoActionPerformed
        // TODO add your handling code here:
        jTextFieldNombreCliente.setVisible(true);
        jLabelNombreCliente.setVisible(true);
        jButtonBuscar.setVisible(true);
        //jTablePedidos.setVisible(false);
        //jScrollPanePedidos.setVisible(false);
        jButtonCancelarPedido.setVisible(true);
        jButtonRealizar.setVisible(true);
        
    }//GEN-LAST:event_jButtonComprobarPedidoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        jScrollPanePedidos.setVisible(true);
        jTablePedidos.setVisible(true);
        
     
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonListarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarPedidosActionPerformed
        // TODO add your handling code here:
        jTextFieldNombreCliente.setVisible(true);
        jLabelNombreCliente.setVisible(true);
        jButtonBuscar.setVisible(true);
        jTablePedidos.setVisible(false);
        jScrollPanePedidos.setVisible(false);
        jButtonRealizar.setVisible(false);
        jButtonCancelarPedido.setVisible(false);
        
    }//GEN-LAST:event_jButtonListarPedidosActionPerformed

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
            java.util.logging.Logger.getLogger(GestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionPedidos dialog = new GestionPedidos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelarPedido;
    private javax.swing.JButton jButtonComprobarPedido;
    private javax.swing.JButton jButtonListarPedidos;
    private javax.swing.JButton jButtonRealizar;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabelNombreCliente;
    private javax.swing.JScrollPane jScrollPanePedidos;
    private javax.swing.JTable jTablePedidos;
    private javax.swing.JTextField jTextFieldNombreCliente;
    // End of variables declaration//GEN-END:variables
}
