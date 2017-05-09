/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Compra;
import Modelo.Liberacion;
import Modelo.Pedido;
import Modelo.Reparacion;
import Modelo.Repositorio;
import Vista.GestionPedidos;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio
 */
public class ControladorGestionPedidos {

    private GestionPedidos miVentana;

    public ControladorGestionPedidos(GestionPedidos miVentana) {
        this.miVentana = miVentana;
    }

    public boolean mostarPendientes() throws ClassNotFoundException, Exception {
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if(columnIndex == 0 || columnIndex == 6) return Boolean.class;
                else return super.getColumnClass(columnIndex);
            }
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 0 || col == 6;
            }
        };
        dtm.addColumn("");
        dtm.addColumn("ID");
        dtm.addColumn("Fecha");
        dtm.addColumn("Forma de pago");
        dtm.addColumn("Estado de pedido");
        dtm.addColumn("Total");
        dtm.addColumn("Completar pedido");
        Cliente c = Repositorio.repositorio().clientePorUsuario(miVentana.getjTextFieldNombreCliente().getText());
        if(c != null){
            for(Pedido p: Repositorio.repositorio().devolverPedidos()){

                    if(!p.getEstadoPedido().equals("Completado") && !p.getEstadoPedido().equals("Cancelado") && p instanceof Compra && p.getCliente() == c.getId()){
                        Object[] fila = {false, p.getNumeroPedido(), p.getFecha(), p.getTipoPago(), p.getEstadoPedido(), p.getTotal(), false};
                        dtm.addRow(fila);
                    }
            }
        } else{
            miVentana.mostrarError("El usuario introducido no existe.");
        }
        miVentana.getjTablePedidos().setModel(dtm);
        miVentana.getjTablePedidos().getColumn("").setPreferredWidth(25);
        miVentana.getjTablePedidos().getColumn("ID").setPreferredWidth(35);
        miVentana.getjTablePedidos().getColumn("Fecha").setPreferredWidth(115);
        miVentana.getjTablePedidos().getColumn("Forma de pago").setPreferredWidth(100);
        miVentana.getjTablePedidos().getColumn("Estado de pedido").setPreferredWidth(100);
        miVentana.getjTablePedidos().getColumn("Completar pedido").setPreferredWidth(100);
        return c != null;
    }

    public void completarPedidos() throws SQLException, Exception {
        boolean correcto = false;
        for(int i = 0; i < miVentana.getjTablePedidos().getRowCount(); i++){
            boolean seleccionado = (Boolean)miVentana.getjTablePedidos().getValueAt(i, 0);
            boolean completar = (Boolean)miVentana.getjTablePedidos().getValueAt(i, 6);
            int pedido = (Integer)miVentana.getjTablePedidos().getValueAt(i, 1);
            if(seleccionado && completar){
                if(Repositorio.repositorio().completarPedido(pedido)){
                    correcto = true;
                } else{
                    miVentana.mostrarError("Error al completar pedido " + pedido);
                }
            }
        }
        if(correcto){
            miVentana.mostrarMensaje("Los pedidos seleccionados han sido completados.");
            mostarPendientes();
        } else{
            miVentana.mostrarError("No se ha completado ningún pedido.");
        }
    }
    
    public void cancelarPedidos() throws SQLException, Exception{
        boolean correcto = false;
        for(int i = 0; i < miVentana.getjTablePedidos().getRowCount(); i++){
            boolean seleccionado = (Boolean)miVentana.getjTablePedidos().getValueAt(i, 0);
            boolean completar = (Boolean)miVentana.getjTablePedidos().getValueAt(i, 6);
            int pedido = (Integer)miVentana.getjTablePedidos().getValueAt(i, 1);
            if(seleccionado && !completar){
                if(Repositorio.repositorio().cancelarPedido(pedido)){
                    correcto = true;
                } else{
                    miVentana.mostrarError("Error al cancelar pedido " + pedido);
                }
            }
        }
        if(correcto){
            miVentana.mostrarMensaje("Los pedidos seleccionados han sido cancelados.");
            mostarPendientes();
        } else{
            miVentana.mostrarError("No se ha cancelado ningún pedido.");
        }
    }

    public boolean mostrarPedidos() throws ClassNotFoundException, Exception {
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        dtm.addColumn("ID");
        dtm.addColumn("Fecha");
        dtm.addColumn("Forma de pago");
        dtm.addColumn("Estado de pedido");
        dtm.addColumn("Tipo");
        dtm.addColumn("Total");
        Cliente c = Repositorio.repositorio().clientePorUsuario(miVentana.getjTextFieldNombreCliente().getText());
        if(c != null){
            for(Pedido p: Repositorio.repositorio().devolverPedidos()){
                String tipo = "";
                if(p instanceof Compra) tipo = "Compra";
                else if(p instanceof Reparacion) tipo = "Reparación";
                else if(p instanceof Liberacion) tipo = "Liberación";
                if(p.getCliente() == c.getId()){
                    Object[] fila = {p.getNumeroPedido(), p.getFecha(), p.getTipoPago(), p.getEstadoPedido(), tipo, p.getTotal()};
                    dtm.addRow(fila);
                }
            }
        } else{
            miVentana.mostrarError("El usuario introducido no existe.");
        }
        miVentana.getjTablePedidos().setModel(dtm);
        miVentana.getjTablePedidos().getColumn("ID").setPreferredWidth(35);
        miVentana.getjTablePedidos().getColumn("Fecha").setPreferredWidth(115);
        miVentana.getjTablePedidos().getColumn("Forma de pago").setPreferredWidth(100);
        miVentana.getjTablePedidos().getColumn("Estado de pedido").setPreferredWidth(100);
        return c != null;
    }
}
