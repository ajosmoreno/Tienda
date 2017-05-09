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
        jLabelFondo.setIcon(new ImageIcon("Imagenes/registroUsuario2.jpg"));
        jButtonAceptar.setIcon(new ImageIcon("Imagenes/icon/aceptarnormal.png"));
        jButtonAceptar.setRolloverIcon(new ImageIcon("Imagenes/icon/aceptarrollover.png"));
        jButtonAceptar.setPressedIcon(new ImageIcon("Imagenes/icon/aceptarpressed.png"));
        jButtonBorrarTodo.setIcon(new ImageIcon("Imagenes/icon/eliminarnormal.png"));
        jButtonBorrarTodo.setRolloverIcon(new ImageIcon("Imagenes/icon/eliminarrollover.png"));
        jButtonBorrarTodo.setPressedIcon(new ImageIcon("Imagenes/icon/eliminarpressed.png"));
        jButtonSalir.setIcon(new ImageIcon("Imagenes/icon/cancelarnormal.png"));
        jButtonSalir.setRolloverIcon(new ImageIcon("Imagenes/icon/cancelarrollover.png"));
        jButtonSalir.setPressedIcon(new ImageIcon("Imagenes/icon/cancelarpressed.png"));
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
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jPasswordFieldUsuario = new javax.swing.JPasswordField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldDni = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonBorrarTodo = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabelFechaNacimiento = new javax.swing.JLabel();
        jDateChooserNacimiento = new com.toedter.calendar.JDateChooser();
        jLabelDni = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Usuarios");
        setMinimumSize(new java.awt.Dimension(841, 483));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(841, 483));
        setResizable(false);
        setSize(new java.awt.Dimension(841, 483));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelRegistro.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabelRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRegistro.setText("REGISTRO DE USUARIOS");
        getContentPane().add(jLabelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 330, 33));

        jLabelUsuario.setBackground(new java.awt.Color(0, 0, 0));
        jLabelUsuario.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelUsuario.setText("Usuario");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 50, 30));

        jLabelContraseña.setBackground(new java.awt.Color(0, 0, 255));
        jLabelContraseña.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelContraseña.setText("Contraseña");
        getContentPane().add(jLabelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 70, 20));

        jLabelNombre.setBackground(new java.awt.Color(0, 0, 255));
        jLabelNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelNombre.setText("Nombre");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 50, 20));

        jLabelApellidos.setBackground(new java.awt.Color(0, 0, 255));
        jLabelApellidos.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelApellidos.setText("Apellidos");
        getContentPane().add(jLabelApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 60, 20));

        jLabelDireccion.setBackground(new java.awt.Color(0, 0, 255));
        jLabelDireccion.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelDireccion.setText("Dirección");
        getContentPane().add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 70, 20));

        jLabelTelefono.setBackground(new java.awt.Color(0, 0, 255));
        jLabelTelefono.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelTelefono.setText("Telefono");
        getContentPane().add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 60, 30));
        getContentPane().add(jTextFieldNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 170, -1));
        getContentPane().add(jPasswordFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 170, -1));
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 170, -1));
        getContentPane().add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 170, -1));
        getContentPane().add(jTextFieldApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 170, -1));
        getContentPane().add(jTextFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 170, -1));
        getContentPane().add(jTextFieldDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 170, -1));

        jButtonAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAceptar.setBorder(null);
        jButtonAceptar.setBorderPainted(false);
        jButtonAceptar.setContentAreaFilled(false);
        jButtonAceptar.setMaximumSize(new java.awt.Dimension(70, 70));
        jButtonAceptar.setMinimumSize(new java.awt.Dimension(70, 70));
        jButtonAceptar.setPreferredSize(new java.awt.Dimension(70, 70));
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 100, 80));

        jButtonBorrarTodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonBorrarTodo.setBorder(null);
        jButtonBorrarTodo.setBorderPainted(false);
        jButtonBorrarTodo.setContentAreaFilled(false);
        jButtonBorrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarTodoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBorrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 100, 80));

        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSalir.setBorder(null);
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 100, 80));

        jLabelFechaNacimiento.setBackground(new java.awt.Color(0, 0, 255));
        jLabelFechaNacimiento.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelFechaNacimiento.setText("Fecha de nacimiento ");
        getContentPane().add(jLabelFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, 30));

        jDateChooserNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserNacimientoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooserNacimientoKeyTyped(evt);
            }
        });
        getContentPane().add(jDateChooserNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 170, -1));

        jLabelDni.setBackground(new java.awt.Color(0, 0, 255));
        jLabelDni.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelDni.setText("DNI");
        getContentPane().add(jLabelDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 30, 30));

        jLabelFondo.setBackground(new java.awt.Color(0, 0, 255));
        jLabelFondo.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelFondo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFondo.setMinimumSize(new java.awt.Dimension(841, 483));
        jLabelFondo.setPreferredSize(new java.awt.Dimension(841, 483));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 841, 483));

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
