/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPrincipal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Antonio
 */
public class PanelPrincipal extends javax.swing.JFrame {

    private ControladorPrincipal miControlador;
    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        miControlador = new ControladorPrincipal(this);
       /* try {
            miControlador.inicializarDatos();
        } catch (SQLException | ClassNotFoundException ex) {
            mostrarError("Error al inicializar base de datos.");
            mostrarError(ex.getMessage());
            System.exit(0);
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBienvenido = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldUsuario = new javax.swing.JPasswordField();
        jLabelPassword = new javax.swing.JLabel();
        jLabelRegistro = new javax.swing.JLabel();
        jButtonRegistro = new javax.swing.JButton();
        jButtonEntrar = new javax.swing.JButton();
        jButtonInvitado = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBienvenido.setFont(new java.awt.Font("Tahoma", 3, 22)); // NOI18N
        jLabelBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBienvenido.setText("Bienvenido");
        getContentPane().add(jLabelBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 138, 54));

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario :");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 60, 40));
        getContentPane().add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 210, -1));
        getContentPane().add(jPasswordFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 210, -1));

        jLabelPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("Contraseña :");
        getContentPane().add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 90, 30));

        jLabelRegistro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegistro.setText("¿Aun no estas registrado?");
        getContentPane().add(jLabelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 170, 20));

        jButtonRegistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonRegistro.setText("Registrar");
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 110, 40));

        jButtonEntrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 100, 40));

        jButtonInvitado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonInvitado.setText("Entrar como invitado");
        jButtonInvitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInvitadoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInvitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 160, 40));

        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 80, 40));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoprincipal.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        try {
            miControlador.cerrarConexionBBDD();
        } catch (SQLException | ClassNotFoundException ex) {
            mostrarError("Error al cerrar la base de datos.");
        }
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonInvitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInvitadoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonInvitadoActionPerformed

    private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed
        RegistroUsuarios registro = new RegistroUsuarios(this,true);
        registro.setVisible(true);
    }//GEN-LAST:event_jButtonRegistroActionPerformed

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        if(jTextFieldUsuario.getText().equals("") || new String(jPasswordFieldUsuario.getPassword()).equals(""))
            mostrarError("Rellena todos los campos.");
        else{
            try {
                miControlador.iniciarSesion();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger("Ha ocurrido un error al iniciar sesión.");
            }
        } 
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            miControlador.cerrarConexionBBDD();
        } catch (SQLException | ClassNotFoundException ex) {
            mostrarError("Error al cerrar la base de datos.");
        }
    }//GEN-LAST:event_formWindowClosing

    public void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonInvitado;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelBienvenido;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelRegistro;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldUsuario;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

    public JPasswordField getjPasswordFieldusuario() {
        return jPasswordFieldUsuario;
    }

    public JTextField getjTextFieldusuario() {
        return jTextFieldUsuario;
    }

    
}
