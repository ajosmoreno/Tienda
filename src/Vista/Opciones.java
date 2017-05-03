/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Antonio
 */
public class Opciones extends javax.swing.JDialog {

    /**
     * Creates new form Opciones
     */
    public Opciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public Opciones(java.awt.Frame parent, boolean modal, boolean invitado) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jButtonLiberacion.setEnabled(false);
        jButtonGestion.setEnabled(false);
        jButtonVerCatalogo.setEnabled(false);
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVerCatalogo.setText("Ver Catalogo");
        getContentPane().add(jButtonVerCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 123, 41));

        jButtonGestion.setText("Gestion de Pedidos");
        getContentPane().add(jButtonGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, 41));

        jButtonReparacion.setText("Reparación");
        jButtonReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReparacionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 123, 41));

        jButtonLiberacion.setText("Liberación");
        getContentPane().add(jButtonLiberacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 123, 41));

        jButtonVolver.setText("Volver al menú principal");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, 41));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReparacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReparacionActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

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
