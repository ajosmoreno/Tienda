/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorRegistro;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Antonio
 */
public class RegistroUsuarios extends javax.swing.JDialog {

    private ControladorRegistro miControlador;
    /**
     * Creates new form RegistroUsuarios
     */
    public RegistroUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        miControlador = new ControladorRegistro(this);
        setLocationRelativeTo(null);
        jLabelFondo.setIcon(new ImageIcon("Imagenes/fondoregistro.png"));
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGrouppermisos = new javax.swing.ButtonGroup();
        jLabelRegistro = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelContraseña = new javax.swing.JLabel();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jPasswordFieldUsuario = new javax.swing.JPasswordField();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonBorrarTodo = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabelFechaNacimiento = new javax.swing.JLabel();
        jDateChooserNacimiento = new com.toedter.calendar.JDateChooser();
        jLabelDni = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Usuarios");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelRegistro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegistro.setText("REGISTRO DE USUARIOS");
        getContentPane().add(jLabelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, 33));

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario:");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 98, -1, -1));

        jLabelContraseña.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContraseña.setText("Contraseña:");
        getContentPane().add(jLabelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 136, -1, -1));
        getContentPane().add(jTextFieldNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 95, 157, -1));
        getContentPane().add(jPasswordFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 133, 157, -1));

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre: ");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 174, -1, -1));

        jLabelApellidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelApellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellidos.setText("Apellidos:");
        getContentPane().add(jLabelApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 212, -1, -1));

        jLabelDireccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDireccion.setText("Dirección:");
        getContentPane().add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 322, -1, -1));

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("Telefono:");
        getContentPane().add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 363, -1, -1));
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 171, 157, -1));
        getContentPane().add(jTextFieldApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 209, 157, -1));
        getContentPane().add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 360, 157, -1));
        getContentPane().add(jTextFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 322, 157, -1));

        jButtonAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 100, 40));

        jButtonBorrarTodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonBorrarTodo.setText("Borrar todo");
        jButtonBorrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarTodoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBorrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 110, 40));

        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 70, 40));

        jLabelFechaNacimiento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelFechaNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFechaNacimiento.setText("Fecha de nacimiento: ");
        getContentPane().add(jLabelFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 284, -1, -1));

        jDateChooserNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserNacimientoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooserNacimientoKeyTyped(evt);
            }
        });
        getContentPane().add(jDateChooserNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 284, 160, -1));

        jLabelDni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelDni.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDni.setText("DNI:");
        getContentPane().add(jLabelDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));
        getContentPane().add(jTextFieldDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 247, 157, -1));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBorrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarTodoActionPerformed
        jTextFieldNombreUsuario.setText("");
        jPasswordFieldUsuario.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellidos.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldDireccion.setText("");
        jDateChooserNacimiento.setDate(null);
        jTextFieldDni.setText("");
    }//GEN-LAST:event_jButtonBorrarTodoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jDateChooserNacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserNacimientoKeyPressed

    }//GEN-LAST:event_jDateChooserNacimientoKeyPressed

    private void jDateChooserNacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserNacimientoKeyTyped

    }//GEN-LAST:event_jDateChooserNacimientoKeyTyped

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        try {
            if(jTextFieldNombreUsuario.getText().equals("") || jTextFieldNombre.getText().equals("") || jTextFieldApellidos.getText().equals("") || new String(jPasswordFieldUsuario.getPassword()).equals("") || jTextFieldDireccion.getText().equals("") || jTextFieldDni.getText().equals("") || jDateChooserNacimiento.getDate() == null){
                mostrarError("Rellena todos los campos.");
            } else{
                miControlador.registrar();
                this.dispose();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            if(ex.getMessage().contains("Duplicate entry") && ex.getMessage().contains("for key 'usuario'"))
                mostrarError("El usuario elegido no está disponible.");
            else if(ex.getMessage().contains("Duplicate entry") && ex.getMessage().contains("for key 'dni'"))
                mostrarError("El DNI introducido ya pertenece a un usuario.");
            else
                mostrarError("Ha ocurrido un error desconocido.\n"+ex.getMessage());
        } catch(Exception ex){
            mostrarError(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    public JDateChooser getjDateChooserNacimiento() {
        return jDateChooserNacimiento;
    }

    public JPasswordField getjPasswordFieldUsuario() {
        return jPasswordFieldUsuario;
    }

    public JTextField getjTextFieldApellidos() {
        return jTextFieldApellidos;
    }

    public JTextField getjTextFieldTelefono() {
        return jTextFieldTelefono;
    }

    public JTextField getjTextFieldDni() {
        return jTextFieldDni;
    }

    public JTextField getjTextFieldNombre() {
        return jTextFieldNombre;
    }

    public JTextField getjTextFieldNombreUsuario() {
        return jTextFieldNombreUsuario;
    }

    public JTextField getjTextFieldDireccion() {
        return jTextFieldDireccion;
    }
    
    public void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.DEFAULT_OPTION);
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
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistroUsuarios dialog = new RegistroUsuarios(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGrouppermisos;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonBorrarTodo;
    private javax.swing.JButton jButtonSalir;
    private com.toedter.calendar.JDateChooser jDateChooserNacimiento;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelRegistro;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldUsuario;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables

}
