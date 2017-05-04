package Controlador;

import Modelo.Sesion;
import Vista.InterfazCompra;
import Vista.Opciones;
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
    
    public boolean esInvitado(){
        return Sesion.miCliente().getCliente().getPermisos() == 0;
    }
}
