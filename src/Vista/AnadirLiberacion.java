package Vista;

import Controlador.ControladorLiberacion;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class AnadirLiberacion extends javax.swing.JDialog {

    private ControladorLiberacion miControlador;
    /**
     * Constructor que cambia los iconos y muestra lo que se debe de ver al iniciarlo
     */
    public AnadirLiberacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        miControlador = new ControladorLiberacion(this);
        jLabelFondo.setIcon(new javax.swing.ImageIcon("Imagenes/liberacion.jpg"));
        this.setLocationRelativeTo(null);
        jButtonAceptar.setIcon(new ImageIcon("Imagenes/icon/aceptarnormal.png"));
        jButtonAceptar.setRolloverIcon(new ImageIcon("Imagenes/icon/aceptarrollover.png"));
        jButtonAceptar.setPressedIcon(new ImageIcon("Imagenes/icon/aceptarpressed.png"));
        jButtonBorrar.setIcon(new ImageIcon("Imagenes/icon/eliminarnormal.png"));
        jButtonBorrar.setRolloverIcon(new ImageIcon("Imagenes/icon/eliminarrollover.png"));
        jButtonBorrar.setPressedIcon(new ImageIcon("Imagenes/icon/eliminarpressed.png"));
        jButtonVolverAtras.setIcon(new ImageIcon("Imagenes/icon/backnormal.png"));
        jButtonVolverAtras.setRolloverIcon(new ImageIcon("Imagenes/icon/backrollover.png"));
        jButtonVolverAtras.setPressedIcon(new ImageIcon("Imagenes/icon/backpressed.png"));
        jLabelPrecio.setVisible(false);
        jLabelPrecioTotal.setVisible(false);
        try {
            miControlador.cargarOperadores();
        } catch (Exception ex) {
            mostrarError("Ha ocurrido un error al mostrar los operadores.");
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

        jLabelOperador = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jLabelImei = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldImei = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jLabelRegistro = new javax.swing.JLabel();
        jButtonVolverAtras = new javax.swing.JButton();
        jComboBoxOperadores = new javax.swing.JComboBox<>();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelPrecioTotal = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOperador.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabelOperador.setForeground(new java.awt.Color(0, 0, 51));
        jLabelOperador.setText("Operador:");
        getContentPane().add(jLabelOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, 20));

        jLabelMarca.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabelMarca.setForeground(new java.awt.Color(0, 0, 51));
        jLabelMarca.setText("Marca:");
        getContentPane().add(jLabelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, -1));

        jLabelModelo.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabelModelo.setForeground(new java.awt.Color(0, 0, 51));
        jLabelModelo.setText("Modelo:");
        getContentPane().add(jLabelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        jLabelImei.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabelImei.setForeground(new java.awt.Color(0, 0, 51));
        jLabelImei.setText("Imei:");
        getContentPane().add(jLabelImei, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        jTextFieldMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 201, -1));

        jTextFieldModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldModeloActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 201, -1));
        getContentPane().add(jTextFieldImei, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 201, -1));

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
        getContentPane().add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 90, 80));

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
        getContentPane().add(jButtonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 100, 80));

        jLabelRegistro.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabelRegistro.setForeground(new java.awt.Color(0, 0, 51));
        jLabelRegistro.setText(" Registro Liberación");
        getContentPane().add(jLabelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 260, 50));

        jButtonVolverAtras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonVolverAtras.setToolTipText("Salir");
        jButtonVolverAtras.setBorder(null);
        jButtonVolverAtras.setBorderPainted(false);
        jButtonVolverAtras.setContentAreaFilled(false);
        jButtonVolverAtras.setMaximumSize(new java.awt.Dimension(50, 50));
        jButtonVolverAtras.setMinimumSize(new java.awt.Dimension(50, 50));
        jButtonVolverAtras.setPreferredSize(new java.awt.Dimension(50, 50));
        jButtonVolverAtras.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButtonVolverAtrasMouseMoved(evt);
            }
        });
        jButtonVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 90, 80));

        jComboBoxOperadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOperadoresActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxOperadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 200, -1));

        jLabelPrecio.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabelPrecio.setForeground(new java.awt.Color(0, 0, 51));
        jLabelPrecio.setText("Precio:");
        getContentPane().add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, 20));

        jLabelPrecioTotal.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabelPrecioTotal.setText("10 €");
        getContentPane().add(jLabelPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 40, 20));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldModeloActionPerformed

    private void jTextFieldMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMarcaActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        if(jComboBoxOperadores.getSelectedIndex() == 0 || jTextFieldMarca.getText().equals("") || jTextFieldModelo.getText().equals("") || jTextFieldImei.getText().equals(""))
            mostrarError("Rellena todos los campos.");
        else{
            int opcion = JOptionPane.showConfirmDialog(this, "Este pedido solo se puede pagar por Tarjeta.\n\n¿Desea continuar?", "Información", JOptionPane.OK_CANCEL_OPTION);
            if(opcion == JOptionPane.OK_OPTION){
                try {
                    if(miControlador.añadirLiberacion())
                        mostrarMensaje("Liberación generada correctamente.\n\nEl código de liberación aparecerá en sus pedidos cuando esté disponible.");
                    else
                        mostrarError("No se ha podido generar la liberación.");
                } catch (Exception ex) {
                    mostrarError("Ha ocurrido un error al generar la liberación.");
                }
            }
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        // TODO add your handling code here:
        
        jTextFieldMarca.setText("");
        jTextFieldModelo.setText("");
        jTextFieldImei.setText("");
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed
          this.dispose();
    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonVolverAtrasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVolverAtrasMouseMoved

    private void jComboBoxOperadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOperadoresActionPerformed
         jLabelPrecio.setVisible(true);
        jLabelPrecioTotal.setVisible(true);
    }//GEN-LAST:event_jComboBoxOperadoresActionPerformed

    /**
     * Método que muestra un mensaje de error al usuario
     * @param mensaje Mensaje de error
     */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método que muestra un mensaje de información al usuario
     * @param mensaje Mensaje de información
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.DEFAULT_OPTION);
    }
    
    /**
     * Devuelve el combobox de operadores
     * @return Combobox de operadores
     */
    public JComboBox<String> getjComboBoxOperadores() {
        return jComboBoxOperadores;
    }

    /**
     * Devuelve el campo de texto del imei
     * @return Campo de texto del imei
     */
    public JTextField getjTextFieldImei() {
        return jTextFieldImei;
    }

    /**
     * Devuelve el campo de texto de la marca
     * @return Campo de texto de la marca
     */
    public JTextField getjTextFieldMarca() {
        return jTextFieldMarca;
    }

    /**
     * Devuelve el campo de texto del modelo
     * @return Campo de texto del modelo
     */
    public JTextField getjTextFieldModelo() {
        return jTextFieldModelo;
    }

    /**
     * Devuelve el label del precio total
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
            java.util.logging.Logger.getLogger(AnadirLiberacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirLiberacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirLiberacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirLiberacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnadirLiberacion dialog = new AnadirLiberacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JComboBox<String> jComboBoxOperadores;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelImei;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelOperador;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelPrecioTotal;
    private javax.swing.JLabel jLabelRegistro;
    private javax.swing.JTextField jTextFieldImei;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldModelo;
    // End of variables declaration//GEN-END:variables
}
