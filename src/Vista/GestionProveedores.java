/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.ImageIcon;

/**
 *
 * @author Antonio
 */
public class GestionProveedores extends javax.swing.JDialog {

    /**
     * Creates new form GestionProveedores
     */
    public GestionProveedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jButtonVolverAtras.setIcon(new ImageIcon("Imagenes/icon/botonvolver.png"));
        jButtonVolverAtras.setPressedIcon(new ImageIcon("Imagenes/icon/botonvolver80%.png"));
        jButtonVolverAtras.setRolloverIcon(new ImageIcon("Imagenes/icon/botonvolver120%.png"));
        jButtonAceptar.setIcon(new ImageIcon("Imagenes/icon/botonaceptar2.png"));
        jButtonAceptar.setPressedIcon(new ImageIcon("Imagenes/icon/botonaceptar4.png"));
        jButtonAceptar.setRolloverIcon(new ImageIcon("Imagenes/icon/botonaceptar3.png"));
        setLocationRelativeTo(null);
        jLabelTipoProveedor.setVisible(false);
        jLabelNombreProveedor.setVisible(false);
        jLabelDireccionProveedor.setVisible(false);
        jLabelTelefonoProveedor.setVisible(false);
        jLabelEmailProveedor.setVisible(false);
        jComboBoxProveedores.setVisible(false);
        jTextFieldNombreProveedor.setVisible(false);
        jTextFieldDireccionProveedor.setVisible(false);
        jTextFieldTelefonoProveedor.setVisible(false);
        jTextFieldEmailProveedor.setVisible(false);
        jButtonAceptar.setVisible(false);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonInsertarProveedor = new javax.swing.JButton();
        jButtonModificarProveedor = new javax.swing.JButton();
        jButtonEliminarProveedor = new javax.swing.JButton();
        jComboBoxProveedores = new javax.swing.JComboBox<>();
        jLabelTipoProveedor = new javax.swing.JLabel();
        jLabelNombreProveedor = new javax.swing.JLabel();
        jTextFieldNombreProveedor = new javax.swing.JTextField();
        jTextFieldDireccionProveedor = new javax.swing.JTextField();
        jLabelDireccionProveedor = new javax.swing.JLabel();
        jLabelTelefonoProveedor = new javax.swing.JLabel();
        jTextFieldTelefonoProveedor = new javax.swing.JTextField();
        jLabelEmailProveedor = new javax.swing.JLabel();
        jTextFieldEmailProveedor = new javax.swing.JTextField();
        jButtonVolverAtras = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonInsertarProveedor.setText("Añadir proveedor");
        getContentPane().add(jButtonInsertarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 160, 50));

        jButtonModificarProveedor.setText("Modificar proveedor");
        getContentPane().add(jButtonModificarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 160, 50));

        jButtonEliminarProveedor.setText("Eliminar proveedor");
        getContentPane().add(jButtonEliminarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 160, 50));

        jComboBoxProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marca", "Proveedor" }));
        getContentPane().add(jComboBoxProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 53, 173, -1));

        jLabelTipoProveedor.setText("Tipo Proveedor: ");
        getContentPane().add(jLabelTipoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jLabelNombreProveedor.setText("Nombre: ");
        getContentPane().add(jLabelNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, 20));
        getContentPane().add(jTextFieldNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 170, -1));
        getContentPane().add(jTextFieldDireccionProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 170, -1));

        jLabelDireccionProveedor.setText("Direccion: ");
        getContentPane().add(jLabelDireccionProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, 20));

        jLabelTelefonoProveedor.setText("Telefono: ");
        getContentPane().add(jLabelTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, 20));
        getContentPane().add(jTextFieldTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 170, -1));

        jLabelEmailProveedor.setText("Email: ");
        getContentPane().add(jLabelEmailProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, 20));
        getContentPane().add(jTextFieldEmailProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 170, -1));

        jButtonVolverAtras.setToolTipText("Volver atras");
        getContentPane().add(jButtonVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 90, 90));

        jButtonAceptar.setToolTipText("Volver atras");
        getContentPane().add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 90, 90));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GestionProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionProveedores dialog = new GestionProveedores(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonEliminarProveedor;
    private javax.swing.JButton jButtonInsertarProveedor;
    private javax.swing.JButton jButtonModificarProveedor;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JComboBox<String> jComboBoxProveedores;
    private javax.swing.JLabel jLabelDireccionProveedor;
    private javax.swing.JLabel jLabelEmailProveedor;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelNombreProveedor;
    private javax.swing.JLabel jLabelTelefonoProveedor;
    private javax.swing.JLabel jLabelTipoProveedor;
    private javax.swing.JTextField jTextFieldDireccionProveedor;
    private javax.swing.JTextField jTextFieldEmailProveedor;
    private javax.swing.JTextField jTextFieldNombreProveedor;
    private javax.swing.JTextField jTextFieldTelefonoProveedor;
    // End of variables declaration//GEN-END:variables
}
