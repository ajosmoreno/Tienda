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
import Vista.GestionPedidosClientes;
import java.sql.SQLException;
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

   
}
