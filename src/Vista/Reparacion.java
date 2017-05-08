package Vista;

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
public class Reparacion extends javax.swing.JDialog {

    /**
     * Creates new form Reparacion
     */
    public Reparacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jLabel7Icon.setIcon(new ImageIcon("Imagenes/Reparacion-iloveimg-resized.jpg"));
        jButtonAceptar.setIcon(new ImageIcon("Imagenes/icon/botonaceptar2.png"));
        jButtonAceptar.setRolloverIcon(new ImageIcon("Imagenes/icon/botonaceptar3.png"));
        jButtonAceptar.setPressedIcon(new ImageIcon("Imagenes/icon/botonaceptar4.png"));
        jButtonBorrar.setIcon(new ImageIcon("Imagenes/icon/borrar1.png"));
        jButtonBorrar.setRolloverIcon(new ImageIcon("Imagenes/icon/borrar2.png"));
        jButtonBorrar.setPressedIcon(new ImageIcon("Imagenes/icon/borrar3.png"));
        jButton3Salir.setIcon(new ImageIcon("Imagenes/icon/close2.png"));
        jButton3Salir.setRolloverIcon(new ImageIcon("Imagenes/icon/close3.png"));
        jButton3Salir.setPressedIcon(new ImageIcon("Imagenes/icon/close4.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelRegistroReparacion = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelObservaciones = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jScrollPaneObservaciones = new javax.swing.JScrollPane();
        jTextAreaObservaciones = new javax.swing.JTextArea();
        jButtonAceptar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButton3Salir = new javax.swing.JButton();
        jLabel7Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelRegistroReparacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelRegistroReparacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegistroReparacion.setText("    Registro Reparación");
        getContentPane().add(jLabelRegistroReparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 11, 267, -1));

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre:");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 71, -1, -1));

        jLabelApellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelApellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellidos.setText("Apellidos:");
        getContentPane().add(jLabelApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 109, -1, -1));

        jLabelDireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDireccion.setText("Dirección:");
        getContentPane().add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 151, -1, -1));

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("Teléfono:");
        getContentPane().add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 193, -1, -1));

        jLabelObservaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelObservaciones.setForeground(new java.awt.Color(255, 255, 255));
        jLabelObservaciones.setText("Observaciones:");
        getContentPane().add(jLabelObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 244, -1, -1));

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 65, 241, -1));
        getContentPane().add(jTextFieldApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 106, 241, -1));
        getContentPane().add(jTextFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 148, 241, -1));
        getContentPane().add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 187, 241, -1));

        jTextAreaObservaciones.setColumns(20);
        jTextAreaObservaciones.setRows(5);
        jScrollPaneObservaciones.setViewportView(jTextAreaObservaciones);

        getContentPane().add(jScrollPaneObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 244, 241, -1));

        jButtonAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAceptar.setToolTipText("Aceptar");
        jButtonAceptar.setBorder(null);
        jButtonAceptar.setBorderPainted(false);
        jButtonAceptar.setContentAreaFilled(false);
        jButtonAceptar.setMaximumSize(new java.awt.Dimension(50, 50));
        jButtonAceptar.setMinimumSize(new java.awt.Dimension(50, 50));
        jButtonAceptar.setPreferredSize(new java.awt.Dimension(50, 50));
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 347, 98, 60));

        jButtonBorrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonBorrar.setToolTipText("Borrar Todo");
        jButtonBorrar.setBorder(null);
        jButtonBorrar.setBorderPainted(false);
        jButtonBorrar.setContentAreaFilled(false);
        jButtonBorrar.setMaximumSize(new java.awt.Dimension(50, 50));
        jButtonBorrar.setMinimumSize(new java.awt.Dimension(50, 50));
        jButtonBorrar.setPreferredSize(new java.awt.Dimension(50, 50));
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 98, 60));

        jButton3Salir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3Salir.setToolTipText("Salir");
        jButton3Salir.setBorder(null);
        jButton3Salir.setBorderPainted(false);
        jButton3Salir.setContentAreaFilled(false);
        jButton3Salir.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton3Salir.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton3Salir.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton3Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3SalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 347, 98, 60));
        getContentPane().add(jLabel7Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButton3SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3SalirActionPerformed
        
          this.dispose();
    }//GEN-LAST:event_jButton3SalirActionPerformed

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
            java.util.logging.Logger.getLogger(Reparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reparacion dialog = new Reparacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3Salir;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JLabel jLabel7Icon;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelObservaciones;
    private javax.swing.JLabel jLabelRegistroReparacion;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JScrollPane jScrollPaneObservaciones;
    private javax.swing.JTextArea jTextAreaObservaciones;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
