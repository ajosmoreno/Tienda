/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorInterfazCompra;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class InterfazCompra extends javax.swing.JDialog {

    private ControladorInterfazCompra miControlador;
    /**
     * Muestra los iconos y lo que se debe de ver al principio
     */
    public InterfazCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jLabelFondo.setIcon(new ImageIcon("Imagenes/catalogo.jpg"));
        jButtonAñadirCesta.setIcon(new ImageIcon("Imagenes/icon/cestaañadirnormal.png"));
        jButtonAñadirCesta.setPressedIcon(new ImageIcon("Imagenes/icon/cestaañadirpressed.png"));
        jButtonAñadirCesta.setRolloverIcon(new ImageIcon("Imagenes/icon/cestaañadirrollover.png"));
        jButtonCestaCompra.setIcon(new ImageIcon("Imagenes/icon/cesta.png"));
        jButtonCestaCompra.setPressedIcon(new ImageIcon("Imagenes/icon/cestapressed.png"));
        jButtonCestaCompra.setRolloverIcon(new ImageIcon("Imagenes/icon/cestarollover.png"));
        jButtonVolver.setIcon(new ImageIcon("Imagenes/icon/backnormal.png"));
        jButtonVolver.setPressedIcon(new ImageIcon("Imagenes/icon/backpressed.png"));
        jButtonVolver.setRolloverIcon(new ImageIcon("Imagenes/icon/backrollover.png"));
        miControlador = new ControladorInterfazCompra(this);
        try {
            miControlador.mostrarMarcas();
        } catch (Exception ex) {
            mostrarError("Ha ocurrido un error al cargar los productos.");
        }
    }

    /**
     * Devuelve el campo de texto de las características
     * @return Campo de texto de las características
     */
    public JTextArea getjTextAreaCaracteristicas() {
        return jTextAreaCaracteristicas;
    }

    /**
     * Devuelve el label del precio total
     * @return Label precio total
     */
    public JLabel getjLabelPrecioTotal() {
        return jLabelPrecioTotal;
    }

    /**
     * Devuelve el label de la imagen
     * @return Label imagen
     */
    public JLabel getjLabelImagen() {
        return jLabelImagen;
    }

    /**
     * Muestra un mensaje de información al usuario
     * @param mensaje Mensaje de información
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.DEFAULT_OPTION);
    }
    
    /**
     * Muestra un mensaje de error al usuario
     * @param mensaje Mensaje de error
     */
    public void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabelCatalogo = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelColor = new javax.swing.JLabel();
        jButtonAñadirCesta = new javax.swing.JButton();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        jComboBoxColor = new javax.swing.JComboBox<>();
        jLabelCaracteristicas = new javax.swing.JLabel();
        jLabelImagen = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelPrecioTotal = new javax.swing.JLabel();
        jScrollPaneCaracteristicas = new javax.swing.JScrollPane();
        jTextAreaCaracteristicas = new javax.swing.JTextArea();
        jButtonVolver = new javax.swing.JButton();
        jButtonCestaCompra = new javax.swing.JButton();
        jLabelModelo = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCatalogo.setFont(new java.awt.Font("Comic Sans MS", 1, 39)); // NOI18N
        jLabelCatalogo.setForeground(new java.awt.Color(204, 204, 204));
        jLabelCatalogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCatalogo.setText("Catálogo");
        getContentPane().add(jLabelCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 280, 60));

        jLabelMarca.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabelMarca.setText("Marca: ");
        getContentPane().add(jLabelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 70, 20));

        jLabelColor.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabelColor.setText("Color:");
        getContentPane().add(jLabelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 70, 24));

        jButtonAñadirCesta.setToolTipText("Añadir producto a la cesta de compra");
        jButtonAñadirCesta.setBorder(null);
        jButtonAñadirCesta.setBorderPainted(false);
        jButtonAñadirCesta.setContentAreaFilled(false);
        jButtonAñadirCesta.setEnabled(false);
        jButtonAñadirCesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirCestaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAñadirCesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 110, 90));

        jComboBoxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 120, -1));

        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 120, -1));

        jComboBoxColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxColorActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 118, -1));

        jLabelCaracteristicas.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabelCaracteristicas.setText("Caracteristicas: ");
        getContentPane().add(jLabelCaracteristicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));
        getContentPane().add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 380, 380));

        jLabelPrecio.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabelPrecio.setText("Precio: ");
        getContentPane().add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, -1, -1));

        jLabelPrecioTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jLabelPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 160, 30));

        jTextAreaCaracteristicas.setEditable(false);
        jTextAreaCaracteristicas.setColumns(20);
        jTextAreaCaracteristicas.setRows(5);
        jScrollPaneCaracteristicas.setViewportView(jTextAreaCaracteristicas);

        getContentPane().add(jScrollPaneCaracteristicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 290, 290));

        jButtonVolver.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVolver.setToolTipText("Volver atras");
        jButtonVolver.setBorder(null);
        jButtonVolver.setBorderPainted(false);
        jButtonVolver.setContentAreaFilled(false);
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 100, 100));

        jButtonCestaCompra.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCestaCompra.setToolTipText("Ir a la cesta de la compra");
        jButtonCestaCompra.setBorder(null);
        jButtonCestaCompra.setBorderPainted(false);
        jButtonCestaCompra.setContentAreaFilled(false);
        jButtonCestaCompra.setEnabled(false);
        jButtonCestaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCestaCompraActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCestaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 110, 90));

        jLabelModelo.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabelModelo.setText("Modelo:");
        getContentPane().add(jLabelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 70, 24));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
        try {
            jComboBoxColor.setModel(new DefaultComboBoxModel());
            miControlador.vaciarCaracteristicas();
            miControlador.deshabilitarBotones();
            if(jComboBoxModelo.getSelectedIndex() > 0)
                miControlador.mostrarColores();
        } catch (Exception ex) {
            mostrarError("Error al cargar los colores del producto.");
        }
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonCestaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCestaCompraActionPerformed
        miControlador.abrirCesta();
    }//GEN-LAST:event_jButtonCestaCompraActionPerformed

    private void jComboBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcaActionPerformed
        try {
            jComboBoxModelo.setModel(new DefaultComboBoxModel());
                jComboBoxColor.setModel(new DefaultComboBoxModel());
                miControlador.vaciarCaracteristicas();
                miControlador.deshabilitarBotones();
            if(jComboBoxMarca.getSelectedIndex() > 0)
                miControlador.mostrarModelos();
            else{
                /*jComboBoxModelo.setModel(new DefaultComboBoxModel());
                jComboBoxColor.setModel(new DefaultComboBoxModel());
                miControlador.vaciarCaracteristicas();
                miControlador.deshabilitarBotones();*/
            }
        } catch (Exception ex) {
            mostrarError("Ha ocurrido un error al cargar los modelos.");
        }
    }//GEN-LAST:event_jComboBoxMarcaActionPerformed

    private void jComboBoxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxColorActionPerformed
        try {
            if(jComboBoxColor.getSelectedIndex() > 0){
                miControlador.seleccionarProducto();
                miControlador.mostrarCaracteristicas();
                miControlador.habilitarBotones();
            }
            else{
                miControlador.vaciarCaracteristicas();
                miControlador.deshabilitarBotones();
            }
        } catch (Exception ex) {
            mostrarError("Error al cargar operadores.");
        }
    }//GEN-LAST:event_jComboBoxColorActionPerformed

    private void jButtonAñadirCestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirCestaActionPerformed
        try {
            miControlador.añadirCesta();
        } catch (Exception ex) {
            if(ex.getMessage().contains("Duplicate") && ex.getMessage().contains("for key 'PRIMARY'"))
                mostrarError("Ya has añadido este producto a la cesta.");
            else mostrarError(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonAñadirCestaActionPerformed

    /**
     * Devuelve el combobox del modelo
     * @return Combobox modelo
     */
    public JComboBox<String> getjComboBoxModelo() {
        return jComboBoxModelo;
    }

    /**
     * Devuelve el combobox del color
     * @return Combobox color
     */
    public JComboBox<String> getjComboBoxColor() {
        return jComboBoxColor;
    }

    /**
     * Devuelve el botón de añadir a la cesta
     * @return Botón añadir a la cesta
     */
    public JButton getjButtonAñadirCesta() {
        return jButtonAñadirCesta;
    }

    /**
     * Devuelve el botón de ir a la cesta
     * @return Botón de ir a la cesta
     */
    public JButton getjButtonCestaCompra() {
        return jButtonCestaCompra;
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
            java.util.logging.Logger.getLogger(InterfazCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfazCompra dialog = new InterfazCompra(new javax.swing.JFrame(), true);
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

    public JComboBox<String> getjComboBoxMarca() {
        return jComboBoxMarca;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadirCesta;
    private javax.swing.JButton jButtonCestaCompra;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxColor;
    private javax.swing.JComboBox<String> jComboBoxMarca;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JLabel jLabelCaracteristicas;
    private javax.swing.JLabel jLabelCatalogo;
    private javax.swing.JLabel jLabelColor;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelPrecioTotal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPaneCaracteristicas;
    private javax.swing.JTextArea jTextAreaCaracteristicas;
    // End of variables declaration//GEN-END:variables
 }
