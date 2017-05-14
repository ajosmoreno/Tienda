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
import Modelo.Repositorio;
import Modelo.Sesion;
import Vista.GestionPedidosClientes;
import Vista.VisorPedido;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *  Clase que accederá al modelo
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorGestionPedidosClientes {
    
    
    private GestionPedidosClientes miVentana; 
    
    /**
     * Constructor que enlaza el controlador con la vista
     * @param miVentana Vista GestionPedidosClientes
     */
    public ControladorGestionPedidosClientes (GestionPedidosClientes miVentana) {
        this.miVentana = miVentana;
    }
    
    /**
     * Carga todos los pedidos del cliente
     */
    public void cargarTodosPedidos(){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        dtm.addColumn("ID");
        dtm.addColumn("Fecha");
        dtm.addColumn("Tipo de pago");
        dtm.addColumn("Tipo de pedido");
        dtm.addColumn("Estado del pedido");
        dtm.addColumn("Precio");
        dtm.addColumn("Detalles del pedido");
        ArrayList<Pedido> listaPedidos = Sesion.miCliente().getCliente().getPedidosRealizados();
        for(Pedido p: listaPedidos){
            String tipo = "";
            if(p instanceof Compra) tipo = "Compra";
            else if(p instanceof Liberacion) tipo = "Liberación";
            else if(p instanceof Reparacion) tipo = "Reparación";
            String[] fila = {String.valueOf(p.getNumeroPedido()), p.getFecha(), p.getTipoPago(), tipo, p.getEstadoPedido(), String.valueOf(p.getTotal()) + "€", "Clic para ver"};
            dtm.addRow(fila);
        }
        miVentana.getjTablePedidos().setModel(dtm);
        miVentana.getjTablePedidos().getColumn("ID").setMaxWidth(30);
    }

    /**
     * Carga los pedidos completados del cliente
     */
    public void cargarPedidosCompletados() {
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        dtm.addColumn("ID");
        dtm.addColumn("Fecha");
        dtm.addColumn("Tipo de pago");
        dtm.addColumn("Tipo de pedido");
        dtm.addColumn("Estado del pedido");
        dtm.addColumn("Precio");
        dtm.addColumn("Detalles del pedido");
        ArrayList<Pedido> listaPedidos = Sesion.miCliente().getCliente().getPedidosRealizados();
        for(Pedido p: listaPedidos){
            if(p.getEstadoPedido().equals("Completado")){
                String tipo = "";
                if(p instanceof Compra) tipo = "Compra";
                else if(p instanceof Liberacion) tipo = "Liberación";
                else if(p instanceof Reparacion) tipo = "Reparación";
                String[] fila = {String.valueOf(p.getNumeroPedido()), p.getFecha(), p.getTipoPago(), tipo, p.getEstadoPedido(), String.valueOf(p.getTotal()) + "€", "Clic para ver"};
                dtm.addRow(fila);
            }
        }
        miVentana.getjTablePedidos().setModel(dtm);
        miVentana.getjTablePedidos().getColumn("ID").setMaxWidth(30);
    }

    /**
     * Carga los pedidos no completados del cliente
     */
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
        dtm.addColumn("Precio");
        dtm.addColumn("Detalles del pedido");
        ArrayList<Pedido> listaPedidos = Sesion.miCliente().getCliente().getPedidosRealizados();
        for(Pedido p: listaPedidos){
            if(!p.getEstadoPedido().equals("Completado") && !p.getEstadoPedido().equals("Cancelado")){
                String tipo = "";
                if(p instanceof Compra) tipo = "Compra";
                else if(p instanceof Liberacion) tipo = "Liberación";
                else if(p instanceof Reparacion) tipo = "Reparación";
                Object[] fila = {false, String.valueOf(p.getNumeroPedido()), p.getFecha(), p.getTipoPago(), tipo, p.getEstadoPedido(), String.valueOf(p.getTotal()) + "€", "Clic para ver"};
                dtm.addRow(fila);
            }
        }
        miVentana.getjTablePedidos().setModel(dtm);
        miVentana.getjTablePedidos().getColumn("").setMaxWidth(25);
        miVentana.getjTablePedidos().getColumn("ID").setMaxWidth(25);
        miVentana.getjTablePedidos().getColumn("Precio").setMaxWidth(65);
    }
    
    /**
     * Carga los pedidos cancelados del cliente
     */
    public void cargarPedidosCancelados() {
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        dtm.addColumn("ID");
        dtm.addColumn("Fecha");
        dtm.addColumn("Tipo de pago");
        dtm.addColumn("Tipo de pedido");
        dtm.addColumn("Estado del pedido");
        dtm.addColumn("Precio");
        dtm.addColumn("Detalles del pedido");
        ArrayList<Pedido> listaPedidos = Sesion.miCliente().getCliente().getPedidosRealizados();
        for(Pedido p: listaPedidos){
            if(p.getEstadoPedido().equals("Cancelado")){
                String tipo = "";
                if(p instanceof Compra) tipo = "Compra";
                else if(p instanceof Liberacion) tipo = "Liberación";
                else if(p instanceof Reparacion) tipo = "Reparación";
                String[] fila = {String.valueOf(p.getNumeroPedido()), p.getFecha(), p.getTipoPago(), tipo, p.getEstadoPedido(), String.valueOf(p.getTotal()) + "€", "Clic para ver"};
                dtm.addRow(fila);
            }
        }
        miVentana.getjTablePedidos().setModel(dtm);
        miVentana.getjTablePedidos().getColumn("ID").setMaxWidth(30);
    }

    /**
     * Cancela los pedidos seleccionados en la vista
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void cancelarPedidos() throws ClassNotFoundException, Exception {
        boolean cancelado = false;
        if(mostrarAviso()){
            for(int i = 0; i < miVentana.getjTablePedidos().getRowCount(); i++){
                boolean seleccionado = (Boolean)miVentana.getjTablePedidos().getValueAt(i, 0);
                if(seleccionado){
                    cancelado = Repositorio.repositorio().cancelarPedido(Integer.parseInt(miVentana.getjTablePedidos().getValueAt(i, 1).toString()));
                }
            }
        }
        if(cancelado){
            Sesion.miCliente().setCliente(Repositorio.repositorio().clientePorUsuario(Sesion.miCliente().getCliente().getNombreUsuario()));
            miVentana.mostrarMensaje("Pedidos cancelados.");
            cargarPedidosNoCompletados();
        }
    }
    
    /**
     * Muestra un aviso de que se cancelarán los productos seleccionados
     * @return True si acepta el aviso, false si no
     */
    public boolean mostrarAviso(){
        int opcion = JOptionPane.showConfirmDialog(miVentana, "Se cancelarán los productos SELECCIONADOS.\n\n¿Desea continuar?", "Información", JOptionPane.OK_CANCEL_OPTION);
        return opcion == JOptionPane.OK_OPTION;
    }
    
    /**
     * Muestra los detalles del pedido
     * @param numeroPedido Número de pedido seleccionado
     * @param tipoPedido Tipo de pedido seleccionado
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void mostrarDetalles(int numeroPedido, String tipoPedido) throws ClassNotFoundException, Exception{
        switch(tipoPedido){
            case "Liberación":
                Liberacion l = (Liberacion)Repositorio.repositorio().pedidoPorID(numeroPedido);
                miVentana.mostrarMensaje("Codigo de liberación: " + l.getCodigoLiberacion() +".\n\nInstrucciones:\n" + l.getInstrucciones());
                break;
            case "Reparación":
                Reparacion r = (Reparacion)Repositorio.repositorio().pedidoPorID(numeroPedido);
                miVentana.mostrarMensaje("Diagnóstico:\n" + r.getDiagnostico());
                break;
            case "Compra":
                VisorPedido visorPedido = new VisorPedido((Frame)miVentana.getParent(), true, numeroPedido);
                visorPedido.setVisible(true);
                break;
        }
    }
}
