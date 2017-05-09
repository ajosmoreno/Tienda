/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorGestionProductos;
import java.awt.Frame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Antonio
 */
public class GestionProductos extends javax.swing.JDialog {

    private ControladorGestionProductos miControlador;
    private boolean añadiendo;
    private boolean borrando;
    /**
     * Creates new form GestionProductos
     */
    public GestionProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        miControlador = new ControladorGestionProductos(this);
        setLocationRelativeTo(null);
        jButtonBuscarFoto.setIcon(new ImageIcon("Imagenes/icon/buscar2.png"));
        jButtonBuscarFoto.setRolloverIcon(new ImageIcon("Imagenes/icon/buscar4.png"));
        jButtonBuscarFoto.setPressedIcon(new ImageIcon("Imagenes/icon/buscar3.png"));
        jButtonBuscar.setIcon(new ImageIcon("Imagenes/icon/buscar2.png"));
        jButtonBuscar.setRolloverIcon(new ImageIcon("Imagenes/icon/buscar4.png"));
        jButtonBuscar.setPressedIcon(new ImageIcon("Imagenes/icon/buscar3.png"));
        jButtonVolverAtras.setIcon(new ImageIcon("Imagenes/icon/botonvolver.png"));
        jButtonCancelar.setIcon(new ImageIcon("Imagenes/icon/close.png"));
        jButtonCancelar.setRolloverIcon(new ImageIcon("Imagenes/icon/2close.png"));
        jButtonCancelar.setPressedIcon(new ImageIcon("Imagenes/icon/1close.png"));
        jButtonAceptar.setIcon(new ImageIcon("Imagenes/icon/botonaceptar.png"));
        jButtonAceptar.setRolloverIcon(new ImageIcon("Imagenes/icon/2botonaceptar.png"));
        jButtonAceptar.setPressedIcon(new ImageIcon("Imagenes/icon/1botonaceptar.png"));
        jLabelFondo.setIcon(new ImageIcon("Imagenes/fondoregistroproductos.jpg"));
        jButtonVolverAtras.setIcon(new ImageIcon("Imagenes/icon/botonvolver.png"));
        jButtonVolverAtras.setPressedIcon(new ImageIcon("Imagenes/icon/botonvolver80%.png"));
        jButtonVolverAtras.setRolloverIcon(new ImageIcon("Imagenes/icon/botonvolver120%.png"));
        jLabelBuscador.setVisible(false);
        jComboBoxListaProductos.setVisible(false);
        jButtonBuscar.setVisible(false);
        jLabelMarca.setVisible(false);
        jLabelModelo.setVisible(false);
        jLabelPrecio.setVisible(false);
        jLabelFoto.setVisible(false);
        jLabelCaracteristicas.setVisible(false);
        jTextAreaCarateristicas.setVisible(false);
        jScrollPaneCaracteristicas.setVisible(false);
        jTextFieldMarca.setVisible(false);
        jTextFieldModelo.setVisible(false);
        jTextFieldFoto.setVisible(false);
        jTextFieldPrecio.setVisible(false);
        jButtonCancelar.setVisible(false);
        jButtonAceptar.setVisible(false);
        jButtonBuscarFoto.setVisible(false);
        jTextFieldStock.setVisible(false);
        jLabeStock.setVisible(false);
        jTextFieldColor.setVisible(false);
        jLabelColor.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonModificarProducto = new javax.swing.JButton();
        jButtonEliminarProducto = new javax.swing.JButton();
        jButtonInsertarProducto = new javax.swing.JButton();
        jButtonVolverAtras = new javax.swing.JButton();
        jLabelBuscador = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jLabelModelo = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelCaracteristicas = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldFoto = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jScrollPaneCaracteristicas = new javax.swing.JScrollPane();
        jTextAreaCarateristicas = new javax.swing.JTextArea();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jButtonBuscarFoto = new javax.swing.JButton();
        jLabeStock = new javax.swing.JLabel();
        jTextFieldStock = new javax.swing.JTextField();
        jLabelColor = new javax.swing.JLabel();
        jTextFieldColor = new javax.swing.JTextField();
        jComboBoxListaProductos = new javax.swing.JComboBox<>();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de productos");
        setMinimumSize(new java.awt.Dimension(989, 586));
        setUndecorated(true);
        setSize(new java.awt.Dimension(989, 586));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonModificarProducto.setText("Modificar producto");
        jButtonModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 157, 139, 69));

        jButtonEliminarProducto.setText("Eliminar producto");
        jButtonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 261, 139, 69));

        jButtonInsertarProducto.setText("Añadir producto");
        jButtonInsertarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInsertarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 56, 139, 69));

        jButtonVolverAtras.setToolTipText("Volver atras");
        jButtonVolverAtras.setBorder(null);
        jButtonVolverAtras.setBorderPainted(false);
        jButtonVolverAtras.setContentAreaFilled(false);
        jButtonVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 370, 90, 90));

        jLabelBuscador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelBuscador.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBuscador.setText("Id producto: ");
        getContentPane().add(jLabelBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, 20));

        jButtonBuscar.setBorder(null);
        jButtonBuscar.setBorderPainted(false);
        jButtonBuscar.setContentAreaFilled(false);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 40, 40));

        jLabelModelo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelModelo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelModelo.setText("Modelo: ");
        getContentPane().add(jLabelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabelMarca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelMarca.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMarca.setText("Marca: ");
        getContentPane().add(jLabelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jLabelCaracteristicas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCaracteristicas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCaracteristicas.setText("Caracteristicas: ");
        getContentPane().add(jLabelCaracteristicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        jLabelPrecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPrecio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPrecio.setText("Precio: ");
        getContentPane().add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabelFoto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelFoto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFoto.setText("Foto: ");
        getContentPane().add(jLabelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));
        getContentPane().add(jTextFieldMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 270, -1));
        getContentPane().add(jTextFieldModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 270, -1));

        jTextFieldFoto.setEditable(false);
        jTextFieldFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldFotoMouseClicked(evt);
            }
        });
        jTextFieldFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFotoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 270, -1));
        getContentPane().add(jTextFieldPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 270, -1));

        jTextAreaCarateristicas.setColumns(20);
        jTextAreaCarateristicas.setRows(5);
        jScrollPaneCaracteristicas.setViewportView(jTextAreaCarateristicas);

        getContentPane().add(jScrollPaneCaracteristicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 450, 220));

        jButtonCancelar.setToolTipText("Cancelar");
        jButtonCancelar.setBorder(null);
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setContentAreaFilled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 90, 90));

        jButtonAceptar.setToolTipText("Aceptar");
        jButtonAceptar.setBorder(null);
        jButtonAceptar.setBorderPainted(false);
        jButtonAceptar.setContentAreaFilled(false);
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, 90, 90));

        jButtonBuscarFoto.setBorder(null);
        jButtonBuscarFoto.setBorderPainted(false);
        jButtonBuscarFoto.setContentAreaFilled(false);
        jButtonBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarFotoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 50, 40));

        jLabeStock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabeStock.setForeground(new java.awt.Color(255, 255, 255));
        jLabeStock.setText("Stock:");
        getContentPane().add(jLabeStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, 20));
        getContentPane().add(jTextFieldStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 70, -1));

        jLabelColor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelColor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelColor.setText("Color:");
        getContentPane().add(jLabelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, 20));
        getContentPane().add(jTextFieldColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 140, -1));

        jComboBoxListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxListaProductosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxListaProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 170, -1));

        jLabelFondo.setMinimumSize(new java.awt.Dimension(989, 586));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 989, 586));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonInsertarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarProductoActionPerformed
        limpiarCampos();
        añadiendo = true;
        borrando = false;
        jLabelBuscador.setVisible(false);
        jComboBoxListaProductos.setVisible(false);
        jButtonBuscar.setVisible(false);
        jButtonCancelar.setVisible(false);
        jButtonAceptar.setVisible(false);
        jTextAreaCarateristicas.setVisible(false);
        jButtonCancelar.setVisible(true);
        jButtonAceptar.setVisible(true);
        jTextAreaCarateristicas.setVisible(true);
        jScrollPaneCaracteristicas.setVisible(true);
        jTextFieldMarca.setVisible(true);
        jTextFieldModelo.setVisible(true);
        jTextFieldFoto.setVisible(true);
        jTextFieldPrecio.setVisible(true);
        jLabelMarca.setVisible(true);
        jLabelModelo.setVisible(true);
        jLabelPrecio.setVisible(true);
        jLabelFoto.setVisible(true);
        jLabelCaracteristicas.setVisible(true);
        jButtonBuscarFoto.setVisible(true);
        jTextFieldStock.setVisible(true);
        jLabeStock.setVisible(true);
        jTextFieldColor.setVisible(true);
        jLabelColor.setVisible(true);
    }//GEN-LAST:event_jButtonInsertarProductoActionPerformed

    private void jButtonModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarProductoActionPerformed
        try {
            limpiarCampos();
            miControlador.cargarProductos();
            añadiendo = false;
            borrando = false;
            modificarCampos();
        } catch (Exception ex) {
            mostrarError("Error al cargar productos.");
        }
    }//GEN-LAST:event_jButtonModificarProductoActionPerformed

    private void jButtonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProductoActionPerformed
        try {
            añadiendo = false;
            borrando = true;
            limpiarCampos();
            miControlador.cargarProductos();
            modificarCampos();
        } catch (Exception ex) {
            mostrarError("Error al cargar productos.");
        }
    }//GEN-LAST:event_jButtonEliminarProductoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limpiarCampos();
        jComboBoxListaProductos.setModel(new DefaultComboBoxModel());
        jLabelBuscador.setVisible(false);
        jComboBoxListaProductos.setVisible(false);
        jButtonBuscar.setVisible(false);
        jLabelMarca.setVisible(false);
        jLabelModelo.setVisible(false);
        jLabelPrecio.setVisible(false);
        jLabelFoto.setVisible(false);
        jLabelCaracteristicas.setVisible(false);
        jTextAreaCarateristicas.setVisible(false);
        jScrollPaneCaracteristicas.setVisible(false);
        jTextFieldMarca.setVisible(false);
        jTextFieldModelo.setVisible(false);
        jTextFieldFoto.setVisible(false);
        jTextFieldPrecio.setVisible(false);
        jButtonCancelar.setVisible(false);
        jButtonAceptar.setVisible(false);
        jButtonBuscarFoto.setVisible(false);
        jTextFieldStock.setVisible(false);
        jLabeStock.setVisible(false);
        jTextFieldColor.setVisible(false);
        jLabelColor.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        if(jTextFieldMarca.getText().equals("") || jTextFieldModelo.getText().equals("") || jTextFieldColor.getText().equals("") ||  jTextFieldFoto.getText().equals("") || jTextFieldPrecio.getText().equals("") || jTextFieldStock.getText().equals("") ||jTextAreaCarateristicas.getText().equals("")){
            mostrarError("Rellena todos los campos.");
        } else{
            if(añadiendo){
                try {
                    miControlador.añadirProducto();
                } catch(NumberFormatException ex)
                {
                    mostrarError("Introduce un stock o precio correcto.");
                } catch (Exception ex) {
                    mostrarError("Ha ocurrido un error al agregar producto.");
                }
            } else{
                if(!borrando){
                    try {
                        miControlador.modificarProducto();
                    } catch (Exception ex) {
                        mostrarError("Error al modificar el producto");
                        mostrarError(ex.getMessage());
                    }
                } else{
                    try {
                        miControlador.eliminarProducto();
                    } catch (Exception ex) {
                        if(ex.getMessage().contains("foreign key constraint")) mostrarError("No puedes eliminar un producto que ha comprado un cliente.\n\nPon el stock a 0 para que no se pueda comprar.");
                        else mostrarError("Error al eliminar el producto.");
                    }
                }
            }
        }
        
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarFotoActionPerformed
        try {
            miControlador.buscarImagen();
        } catch (IOException ex) {
            mostrarError("Error al elegir la foto.");
        }
    }//GEN-LAST:event_jButtonBuscarFotoActionPerformed

    private void jComboBoxListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxListaProductosActionPerformed
        
    }//GEN-LAST:event_jComboBoxListaProductosActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        if(!jComboBoxListaProductos.getSelectedItem().equals("")){
            try {
                if(!borrando) jButtonBuscarFoto.setVisible(true);
                miControlador.seleccionarProducto();
                miControlador.mostrarDatosProducto();
                jButtonCancelar.setVisible(true);
                jButtonAceptar.setVisible(true);
                jTextAreaCarateristicas.setVisible(true);
                jScrollPaneCaracteristicas.setVisible(true);
                jTextFieldMarca.setVisible(true);
                jTextFieldModelo.setVisible(true);
                jTextFieldFoto.setVisible(true);
                jTextFieldPrecio.setVisible(true);
                jLabelMarca.setVisible(true);
                jLabelModelo.setVisible(true);
                jLabelPrecio.setVisible(true);
                jLabelFoto.setVisible(true);
                jLabelCaracteristicas.setVisible(true);
                
                jTextFieldStock.setVisible(true);
                jLabeStock.setVisible(true);
                jTextFieldColor.setVisible(true);
                jLabelColor.setVisible(true);
            } catch (Exception ex) {
                mostrarError("Error al cargar producto.");
            }
        } else{
            limpiarCampos();
            modificarCampos();
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTextFieldFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFotoActionPerformed
        
    }//GEN-LAST:event_jTextFieldFotoActionPerformed

    private void jTextFieldFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldFotoMouseClicked
        if(!jTextFieldFoto.getText().equals("")){
            System.out.println("aaaa");
            new VisorImagen((Frame)this.getParent(), true, jTextFieldFoto.getText()).setVisible(true);
        }
    }//GEN-LAST:event_jTextFieldFotoMouseClicked

    public void limpiarCampos(){
        jTextAreaCarateristicas.setText("");
        jTextFieldColor.setText("");
        jTextFieldFoto.setText("");
        jTextFieldMarca.setText("");
        jTextFieldModelo.setText("");
        jTextFieldPrecio.setText("");
        jTextFieldStock.setText("");
    }
    
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.DEFAULT_OPTION);
    }

    public JTextField getjTextFieldFoto() {
        return jTextFieldFoto;
    }

    public JTextArea getjTextAreaCarateristicas() {
        return jTextAreaCarateristicas;
    }

    public JTextField getjTextFieldColor() {
        return jTextFieldColor;
    }

    public JTextField getjTextFieldMarca() {
        return jTextFieldMarca;
    }

    public JTextField getjTextFieldModelo() {
        return jTextFieldModelo;
    }

    public JTextField getjTextFieldPrecio() {
        return jTextFieldPrecio;
    }

    public JTextField getjTextFieldStock() {
        return jTextFieldStock;
    }

    public JComboBox<String> getjComboBoxListaProductos() {
        return jComboBoxListaProductos;
    }
    
    public void modificarCampos(){
        jLabelBuscador.setVisible(true);
            jComboBoxListaProductos.setVisible(true);
            jButtonBuscar.setVisible(true);
            jLabelMarca.setVisible(false);
            jLabelModelo.setVisible(false);
            jLabelPrecio.setVisible(false);
            jLabelFoto.setVisible(false);
            jLabelCaracteristicas.setVisible(false);
            jTextAreaCarateristicas.setVisible(false);
            jScrollPaneCaracteristicas.setVisible(false);
            jTextFieldMarca.setVisible(false);
            jTextFieldModelo.setVisible(false);
            jTextFieldFoto.setVisible(false);
            jTextFieldPrecio.setVisible(false);
            jButtonCancelar.setVisible(false);
            jButtonAceptar.setVisible(false);
            jButtonBuscarFoto.setVisible(false);
            jTextFieldStock.setVisible(false);
            jLabeStock.setVisible(false);
            jTextFieldColor.setVisible(false);
            jLabelColor.setVisible(false);
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
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionProductos dialog = new GestionProductos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscarFoto;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminarProducto;
    private javax.swing.JButton jButtonInsertarProducto;
    private javax.swing.JButton jButtonModificarProducto;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JComboBox<String> jComboBoxListaProductos;
    private javax.swing.JLabel jLabeStock;
    private javax.swing.JLabel jLabelBuscador;
    private javax.swing.JLabel jLabelCaracteristicas;
    private javax.swing.JLabel jLabelColor;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JScrollPane jScrollPaneCaracteristicas;
    private javax.swing.JTextArea jTextAreaCarateristicas;
    private javax.swing.JTextField jTextFieldColor;
    private javax.swing.JTextField jTextFieldFoto;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldStock;
    // End of variables declaration//GEN-END:variables
}
