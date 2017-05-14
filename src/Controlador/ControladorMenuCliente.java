package Controlador;

import Modelo.Sesion;
import Vista.InterfazCompra;
import Vista.AnadirLiberacion;
import Vista.MenuCliente;
import Vista.AnadirReparacion;
import Vista.GestionPedidosClientes;
import java.awt.Frame;

/**
 *  Clase que accederá al modelo
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorMenuCliente {
    
    private MenuCliente miVentana;

    /**
     * Constructor que enlaza el controlador con la vista
     * @param miVentana Vista MenuCliente
     */
    public ControladorMenuCliente(MenuCliente miVentana) {
        this.miVentana = miVentana;
    }
    
    /**
     * Abre el catálogo
     */
    public void abrirCatalogo(){
        InterfazCompra interfazCompra = new InterfazCompra((Frame)miVentana.getParent(), true);
        interfazCompra.setVisible(true);
    }
    
    /**
     * Abre la gestión de pedidos
     */
    public void abrirGestionPedidos(){
        GestionPedidosClientes gPedidos = new GestionPedidosClientes((Frame)miVentana.getParent(), true);
        gPedidos.setVisible(true);
    }
    
    /**
     * Abre la vista para añadir reparaciones
     */
    public void abrirReparacion(){
        AnadirReparacion reparacion = new AnadirReparacion((Frame)miVentana.getParent(),true);
        reparacion.setVisible(true);
    }
    
    /**
     * Abre la vista para añadir liberaciones
     */
    public void abrirLiberacion(){
        AnadirLiberacion liberacion = new AnadirLiberacion((Frame)miVentana.getParent(),true);
        liberacion.setVisible(true);
    }
    
    /**
     * Devuelve si el cliente es invitado o no
     * @return True si es invitado, false si no
     */
    public boolean esInvitado(){
        return Sesion.miCliente().getCliente().getPermisos() == 0;
    }
}
