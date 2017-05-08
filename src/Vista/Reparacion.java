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
        jButton1Aceptar.setIcon(new ImageIcon("Imagenes/icon/botonaceptar2.png"));
        jButton1Aceptar.setRolloverIcon(new ImageIcon("Imagenes/icon/botonaceptar3.png"));
        jButton1Aceptar.setPressedIcon(new ImageIcon("Imagenes/icon/botonaceptar4.png"));
        jButton2Borrar.setIcon(new ImageIcon("Imagenes/icon/borrar1.png"));
        jButton2Borrar.setRolloverIcon(new ImageIcon("Imagenes/icon/borrar2.png"));
        jButton2Borrar.setPressedIcon(new ImageIcon("Imagenes/icon/borrar3.png"));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1Nombre = new javax.swing.JTextField();
        jTextField2Apellidos = new javax.swing.JTextField();
        jTextField3Direccion = new javax.swing.JTextField();
        jTextField4Telefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1Observaciones = new javax.swing.JTextArea();
        jButton1Aceptar = new javax.swing.JButton();
        jButton2Borrar = new javax.swing.JButton();
        jButton3Salir = new javax.swing.JButton();
        jLabel7Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("    Registro Reparación");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 11, 267, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 71, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 109, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 151, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Teléfono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 193, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Observaciones:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 244, -1, -1));

        jTextField1Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1NombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 65, 241, -1));
        getContentPane().add(jTextField2Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 106, 241, -1));
        getContentPane().add(jTextField3Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 148, 241, -1));
        getContentPane().add(jTextField4Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 187, 241, -1));

        jTextArea1Observaciones.setColumns(20);
        jTextArea1Observaciones.setRows(5);
        jScrollPane1.setViewportView(jTextArea1Observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 244, 241, -1));

        jButton1Aceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1Aceptar.setBorder(null);
        jButton1Aceptar.setBorderPainted(false);
        jButton1Aceptar.setContentAreaFilled(false);
        jButton1Aceptar.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton1Aceptar.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton1Aceptar.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton1Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 347, 98, 60));

        jButton2Borrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2Borrar.setBorder(null);
        jButton2Borrar.setBorderPainted(false);
        jButton2Borrar.setContentAreaFilled(false);
        jButton2Borrar.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton2Borrar.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton2Borrar.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton2Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2BorrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 98, 60));

        jButton3Salir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

    private void jTextField1NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1NombreActionPerformed

    private void jButton1AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1AceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1AceptarActionPerformed

    private void jButton2BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2BorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2BorrarActionPerformed

    private void jButton3SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3SalirActionPerformed
        
          System.exit(0);
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
    private javax.swing.JButton jButton1Aceptar;
    private javax.swing.JButton jButton2Borrar;
    private javax.swing.JButton jButton3Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7Icon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1Observaciones;
    private javax.swing.JTextField jTextField1Nombre;
    private javax.swing.JTextField jTextField2Apellidos;
    private javax.swing.JTextField jTextField3Direccion;
    private javax.swing.JTextField jTextField4Telefono;
    // End of variables declaration//GEN-END:variables
}
