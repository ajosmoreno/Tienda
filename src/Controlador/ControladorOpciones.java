package Controlador;

import Modelo.Sesion;
import Vista.GestionPedidos;
import Vista.InterfazCompra;
import Vista.AnadirLiberacion;
import Vista.Opciones;
import Vista.AnadirReparacion;
import java.awt.Frame;

/**
 *
 * @author José Manuel Moreno Córdoba
 */
public class ControladorOpciones {
    
    private Opciones miVentana;

    public ControladorOpciones(Opciones miVentana) {
        this.miVentana = miVentana;
    }
    
    public void abrirCatalogo(){
        InterfazCompra interfazCompra = new InterfazCompra((Frame)miVentana.getParent(), true);
        interfazCompra.setVisible(true);
    }
    
    public void abrirGestionPedidos(){
        GestionPedidos gestionPedidos = new GestionPedidos((Frame)miVentana.getParent(), true);
        gestionPedidos.setVisible(true);
    }
    
    public void abrirReparacion(){
        AnadirReparacion reparacion = new AnadirReparacion((Frame)miVentana.getParent(),true);
        reparacion.setVisible(true);
    }
    
    public void abrirLiberacion(){
        AnadirLiberacion liberacion = new AnadirLiberacion((Frame)miVentana.getParent(),true);
        liberacion.setVisible(true);
    }
    
    public boolean esInvitado(){
        return Sesion.miCliente().getCliente().getPermisos() == 0;
    }
}
