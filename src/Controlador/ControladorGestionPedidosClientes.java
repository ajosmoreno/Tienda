/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Compra;
import Modelo.Liberacion;
import Modelo.Pedido;
import Modelo.Reparacion;
import Modelo.Sesion;
import Vista.GestionPedidosClientes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio
 */
public class ControladorGestionPedidosClientes {
    
    
    private GestionPedidosClientes miVentana; 
    
    
    public ControladorGestionPedidosClientes (GestionPedidosClientes miVentana) {
        this.miVentana = miVentana;
    }
    
    public void cargarTodosPedidos(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Fecha");
        dtm.addColumn("Tipo de pago");
        dtm.addColumn("Tipo de pedido");
        dtm.addColumn("Estado del pedido");
        dtm.addColumn("Detalles del pedido");
        ArrayList<Pedido> listaPedidos = Sesion.miCliente().getCliente().getPedidosRealizados();
        for(Pedido p: listaPedidos){
            String tipo = "";
            if(p instanceof Compra) tipo = "Compra";
            else if(p instanceof Liberacion) tipo = "Liberación";
            else if(p instanceof Reparacion) tipo = "Reparación";
            String[] fila = {String.valueOf(p.getNumeroPedido()), p.getFecha(), p.getTipoPago(), tipo, p.getEstadoPedido(), "Clic para ver"};
            dtm.addRow(fila);
        }
        miVentana.getjTablePedidos().setModel(dtm);
    }

    public void cargarPedidosCompletados() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Fecha");
        dtm.addColumn("Tipo de pago");
        dtm.addColumn("Tipo de pedido");
        dtm.addColumn("Estado del pedido");
        dtm.addColumn("Detalles del pedido");
        ArrayList<Pedido> listaPedidos = Sesion.miCliente().getCliente().getPedidosRealizados();
        for(Pedido p: listaPedidos){
            if(p.getEstadoPedido().equals("Completado")){
                String tipo = "";
                if(p instanceof Compra) tipo = "Compra";
                else if(p instanceof Liberacion) tipo = "Liberación";
                else if(p instanceof Reparacion) tipo = "Reparación";
                String[] fila = {String.valueOf(p.getNumeroPedido()), p.getFecha(), p.getTipoPago(), tipo, p.getEstadoPedido(), "Clic para ver"};
                dtm.addRow(fila);
            }
        }
        miVentana.getjTablePedidos().setModel(dtm);
    }

    public void cargarPedidosNoCompletados() {
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if(columnIndex == 0) return Boolean.class;
                else return super.getColumnClass(columnIndex);
            }
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 0;
            }
        };
        dtm.addColumn("");
        dtm.addColumn("ID");
        dtm.addColumn("Fecha");
        dtm.addColumn("Tipo de pago");
        dtm.addColumn("Tipo de pedido");
        dtm.addColumn("Estado del pedido");
        dtm.addColumn("Detalles del pedido");
        ArrayList<Pedido> listaPedidos = Sesion.miCliente().getCliente().getPedidosRealizados();
        for(Pedido p: listaPedidos){
            if(!p.getEstadoPedido().equals("Completado") && !p.getEstadoPedido().equals("Cancelado")){
                String tipo = "";
                if(p instanceof Compra) tipo = "Compra";
                else if(p instanceof Liberacion) tipo = "Liberación";
                else if(p instanceof Reparacion) tipo = "Reparación";
                Object[] fila = {false, String.valueOf(p.getNumeroPedido()), p.getFecha(), p.getTipoPago(), tipo, p.getEstadoPedido(), "Clic para ver"};
                dtm.addRow(fila);
            }
        }
        miVentana.getjTablePedidos().setModel(dtm);
    }
    
    public void cargarPedidosCancelados() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Fecha");
        dtm.addColumn("Tipo de pago");
        dtm.addColumn("Tipo de pedido");
        dtm.addColumn("Estado del pedido");
        dtm.addColumn("Detalles del pedido");
        ArrayList<Pedido> listaPedidos = Sesion.miCliente().getCliente().getPedidosRealizados();
        for(Pedido p: listaPedidos){
            if(p.getEstadoPedido().equals("Cancelado")){
                String tipo = "";
                if(p instanceof Compra) tipo = "Compra";
                else if(p instanceof Liberacion) tipo = "Liberación";
                else if(p instanceof Reparacion) tipo = "Reparación";
                String[] fila = {String.valueOf(p.getNumeroPedido()), p.getFecha(), p.getTipoPago(), tipo, p.getEstadoPedido(), "Clic para ver"};
                dtm.addRow(fila);
            }
        }
        miVentana.getjTablePedidos().setModel(dtm);
    }

    public void cancelarPedidos() {
        
    }
    
    public boolean mostrarAviso(){
        int opcion = JOptionPane.showConfirmDialog(miVentana, "Se cancelarán los productos SELECCIONADOS.\n\n¿Desea continuar?", "Información", JOptionPane.OK_CANCEL_OPTION);
        return opcion == JOptionPane.OK_OPTION;
    }
}
