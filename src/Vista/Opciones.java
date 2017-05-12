/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorOpciones;
import javax.swing.ImageIcon;

/**
 *
 * @author Antonio
 */
public class Opciones extends javax.swing.JDialog {

    private ControladorOpciones miControlador;
    /**
     * Creates new form Opciones
     */
    public Opciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jLabelFondo.setIcon(new ImageIcon("Imagenes/robot.jpg"));
        setLocationRelativeTo(null);
        miControlador = new ControladorOpciones(this);
        if(miControlador.esInvitado()){
            jButtonLiberacion.setEnabled(false);
            jButtonGestion.setEnabled(false);
            jButtonReparacion.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonVerCatalogo = new javax.swing.JButton();
        jButtonGestion = new javax.swing.JButton();
        jButtonReparacion = new javax.swing.JButton();
        jButtonLiberacion = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(841, 483));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVerCatalogo.setText("Ver Catalogo");
        jButtonVerCatalogo.setBorderPainted(false);
        jButtonVerCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerCatalogoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVerCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 140, 41));

        jButtonGestion.setText("Gestion de Pedidos");
        jButtonGestion.setBorderPainted(false);
        jButtonGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 140, 41));

        jButtonReparacion.setText("Reparación");
        jButtonReparacion.setBorderPainted(false);
        jButtonReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReparacionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 140, 41));

        jButtonLiberacion.setText("Liberación");
        jButtonLiberacion.setBorderPainted(false);
        jButtonLiberacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLiberacionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLiberacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 140, 41));

        jButtonVolver.setText("Volver al menú principal");
        jButtonVolver.setBorderPainted(false);
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 170, 41));

        jLabelFondo.setMinimumSize(new java.awt.Dimension(841, 483));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 841, 483));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReparacionActionPerformed
        // TODO add your handling code here:
        miControlador.abrirReparacion();
        
    }//GEN-LAST:event_jButtonReparacionActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonVerCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerCatalogoActionPerformed
        miControlador.abrirCatalogo();
    }//GEN-LAST:event_jButtonVerCatalogoActionPerformed

    private void jButtonGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionActionPerformed
        // TODO add your handling code here:
        miControlador.abrirGestionPedidos();
    }//GEN-LAST:event_jButtonGestionActionPerformed

    private void jButtonLiberacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLiberacionActionPerformed
        // TODO add your handling code here:
        miControlador.abrirLiberacion();
    }//GEN-LAST:event_jButtonLiberacionActionPerformed

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
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Opciones dialog = new Opciones(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonGestion;
    private javax.swing.JButton jButtonLiberacion;
    private javax.swing.JButton jButtonReparacion;
    private javax.swing.JButton jButtonVerCatalogo;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelFondo;
    // End of variables declaration//GEN-END:variables
}
