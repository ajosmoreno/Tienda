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

  /*  java.awt.Frame ventana;*/
    /**
     * Creates new form Opciones
     */
    public Opciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        /*ventana = parent;*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonvercatalogo = new javax.swing.JButton();
        jButtongestion = new javax.swing.JButton();
        jButtonreparacion = new javax.swing.JButton();
        jButtonLiberacion = new javax.swing.JButton();
        jButtonvolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonvercatalogo.setText("Ver Catalogo");
        getContentPane().add(jButtonvercatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 123, 41));

        jButtongestion.setText("Gestion de Pedidos");
        getContentPane().add(jButtongestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, 41));

        jButtonreparacion.setText("Reparación");
        jButtonreparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonreparacionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonreparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 123, 41));

        jButtonLiberacion.setText("Liberación");
        getContentPane().add(jButtonLiberacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 123, 41));

        jButtonvolver.setText("Volver al menú principal");
        jButtonvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonvolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonvolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, 41));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\alumno\\Documents\\NetBeansProjects\\Tienda\\Imagenes\\fondocatalogo-iloveimg-resized.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonreparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonreparacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonreparacionActionPerformed

    private void jButtonvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonvolverActionPerformed
        // TODO add your handling code here:
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        this.dispose();
       /* ventana.setVisible(true);*/
        
    }//GEN-LAST:event_jButtonvolverActionPerformed

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
    private javax.swing.JButton jButtonLiberacion;
    private javax.swing.JButton jButtongestion;
    private javax.swing.JButton jButtonreparacion;
    private javax.swing.JButton jButtonvercatalogo;
    private javax.swing.JButton jButtonvolver;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
