package Controlador;

import Modelo.Cliente;
import Modelo.Gestor;
import Modelo.Liberacion;
import Modelo.Pedido;
import Modelo.Reparacion;
import Modelo.Repositorio;
import Vista.GestionAdministrador;
import Vista.GestionPedidos;
import Vista.GestionProductos;
import Vista.GestionGestores;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *  Clase que accederá al modelo
 * @author José Manuel Moreno, Carmen Barranco, Antonio Serrano
 */
public class ControladorGestionAdministrador {

    private GestionAdministrador miVentana;
    private Reparacion reparacionSeleccionada;
    private Liberacion liberacionSeleccionada;

    /**
     * Constructor que enlaza el controlador con la vista
     * @param miVentana Vista GestionAdministrador
     */
    public ControladorGestionAdministrador(GestionAdministrador miVentana) {
        this.miVentana = miVentana;
    }

    /**
     * Abre la vista de gestión de pedidos
     */
    public void abrirGestionPedidos() {
        GestionPedidos gPedidos = new GestionPedidos((Frame) miVentana.getParent(), true);
        gPedidos.setVisible(true);
    }

    /**
     * Busca el cliente introducido en la vista
     * @return True si lo ha encontrado, false si no
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     */
    public boolean buscarCliente() throws SQLException, ClassNotFoundException, Exception {
        boolean encontrado = false;
        Cliente c = Repositorio.repositorio().clientePorUsuario(miVentana.getjTextFieldBuscadorNombre().getText());
        if (c != null) {
            encontrado = true;
            miVentana.getjTextFieldNombre().setText(c.getNombre());
            miVentana.getjTextFieldApellidos().setText(c.getApellidos());
            miVentana.getjTextFieldDni().setText(c.getDni());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            miVentana.getjDateChooserNacimiento().getDateEditor().setDate(formatter.parse(c.getFechaNacimiento()));
            miVentana.getjDateChooserNacimiento().getDateEditor().setEnabled(false);
            miVentana.getjTextFieldDireccion().setText(c.getDireccion());
            miVentana.getjTextFieldTelefono().setText(c.getTelefono());
            miVentana.getjTextFieldUsuario().setText(c.getNombreUsuario());
            miVentana.getjTextFieldUsuario().setEditable(false);
            miVentana.getjTextFieldPassword().setText(null);
            switch (c.getPermisos()) {
                case 0:
                    miVentana.getjRadioButtonInvitado().setSelected(true);
                    break;
                case 1:
                    miVentana.getjRadioButtonCliente().setSelected(true);
                    break;
                case 2:
                    miVentana.getjRadioButtonAdministrador().setSelected(true);
                    break;
            }
        }
        return encontrado;
    }

    /**
     * Modifica el usuario introducido en la vista
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public void modificarUsuario() throws SQLException, Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String usuario = miVentana.getjTextFieldUsuario().getText();
        String contrasenya = new String(miVentana.getjTextFieldPassword().getText());
        String nombre = miVentana.getjTextFieldNombre().getText();
        String apellidos = miVentana.getjTextFieldApellidos().getText();
        String dni = miVentana.getjTextFieldDni().getText();
        String fechaNacimiento = df.format(miVentana.getjDateChooserNacimiento().getDate());
        String direccion = miVentana.getjTextFieldDireccion().getText();
        String telefono = miVentana.getjTextFieldTelefono().getText();
        int permisos = 0;
        if (miVentana.getjRadioButtonCliente().isSelected()) {
            permisos = 1;
        } else if (miVentana.getjRadioButtonAdministrador().isSelected()) {
            permisos = 2;
        }
        if(Repositorio.repositorio().modificarCliente(usuario, contrasenya, nombre, apellidos, dni, fechaNacimiento, direccion, telefono, permisos))
            miVentana.mostrarMensaje("¡Usuario modificado correctamente!");
        else
            miVentana.mostrarError("Ha ocurrido un error al modificar el usuario.");
    }

    /**
     * Elimina el usuario introducido en la vista
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public void eliminarUsuario() throws SQLException, Exception {
        String usuario = miVentana.getjTextFieldUsuario().getText();
        int dialogResult = JOptionPane.showConfirmDialog(miVentana, "¿Estás seguro de que quieres borrar el usuario " + usuario + "?", "¡Atención!", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) { 
            if (Repositorio.repositorio().eliminarCliente(usuario)) {
                miVentana.limpiarCampos();
                miVentana.modificarUsuarioPaneles();
                miVentana.mostrarMensaje("Usuario eliminado correctamente.");
            } else {
                miVentana.mostrarError("Ha ocurrido un error al modificar el usuario.");
            }
        }
    }

    /**
     * Genera un código de liberación aleatorio
     */
    public void asignarCodigoLiberacion() {
        int codigo = (int) (Math.random() * 999999999);
        String codigoliberacion = String.valueOf(codigo);
        miVentana.getjTextFieldCodigoLiberacion().setText(codigoliberacion);
    }

    /**
     * Registra un usuario con los datos de la vista
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public void registrarUsuario() throws ClassNotFoundException, SQLException, Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String usuario = miVentana.getjTextFieldUsuario().getText();
        String contrasenya = miVentana.getjTextFieldPassword().getText();
        String nombre = miVentana.getjTextFieldNombre().getText();
        String apellidos = miVentana.getjTextFieldApellidos().getText();
        String dni = miVentana.getjTextFieldDni().getText();
        String fechaNacimiento = df.format(miVentana.getjDateChooserNacimiento().getDate());
        String direccion = miVentana.getjTextFieldDireccion().getText();
        String telefono = miVentana.getjTextFieldTelefono().getText();
        int permiso = 0;
        if (miVentana.getjRadioButtonCliente().isSelected()) {
            permiso = 1;
        } else if (miVentana.getjRadioButtonAdministrador().isSelected()) {
            permiso = 2;
        }
        if (Repositorio.repositorio().registrarCliente(usuario, contrasenya, nombre, apellidos, dni, fechaNacimiento, direccion, telefono, permiso)) {
            miVentana.mostrarMensaje("Usuario registrado correctamente.");
            miVentana.limpiarCampos();
        } else {
            miVentana.mostrarError("Error al crear el usuario.");
        }
    }

    /**
     * Abre la vista de gestión de productos
     */
    public void abrirGestionProductos() {
        GestionProductos gProductos = new GestionProductos((Frame) miVentana.getParent(), true);
        gProductos.setVisible(true);
    }

    /**
     * Carga las reparaciones pendientes
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa 
     */
    public void cargarReparacionesPendientes() throws ClassNotFoundException, Exception {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        ArrayList<Pedido> listaPedidos = Repositorio.repositorio().devolverPedidos();
        dcb.addElement("");
        for (Pedido p : listaPedidos) {
            if (p instanceof Reparacion && !p.getEstadoPedido().equals("Completado") && !p.getEstadoPedido().equals("Reparado")) {
                dcb.addElement(p.getNumeroPedido());
            }
        }
        miVentana.getjComboBoxPedidosPendientes().setModel(dcb);
    }

    /**
     * Carga las liberaciones pendientes
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void cargarLiberacionesPendientes() throws ClassNotFoundException, Exception {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        ArrayList<Pedido> listaPedidos = Repositorio.repositorio().devolverPedidos();
        dcb.addElement("");
        for (Pedido p : listaPedidos) {
            if (p instanceof Liberacion && !p.getEstadoPedido().equals("Completado")) {
                dcb.addElement(p.getNumeroPedido());
            }
        }
        miVentana.getjComboBoxPedidosPendientes().setModel(dcb);
    }

    /**
     * Repara el pedido seleccionado en la vista
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa 
     */
    public void repararPedido() throws SQLException, Exception {
        if (mostrarAvisoPedido(reparacionSeleccionada)) {
            if(Repositorio.repositorio().repararPedido(reparacionSeleccionada.getNumeroPedido(), miVentana.getjTextAreaDiagnostico().getText(), Double.parseDouble(miVentana.getjTextFieldPrecio().getText().replace(",", ".")), reparacionSeleccionada.getEstadoPedido())){
                miVentana.mostrarMensaje("Pedido completado.");
                miVentana.limpiarReparacion();
            } else{
                miVentana.mostrarError("Ha ocurrido un error mientras se procesaba el pedido.");
            }
        }
    }

    /**
     * Libera el pedido seleccionado en la vista
     * @throws SQLException Error al ejecutar alguna consulta SQL
     * @throws Exception Error cuando falla otra cosa
     */
    public void liberarPedido() throws SQLException, Exception {
        if (mostrarAvisoPedido(liberacionSeleccionada)) {
            if(Repositorio.repositorio().liberarPedido(liberacionSeleccionada.getNumeroPedido(), miVentana.getjTextFieldCodigoLiberacion().getText(), miVentana.getjTextAreaDiagnostico().getText(), liberacionSeleccionada.getEstadoPedido())){
                miVentana.mostrarMensaje("Pedido completado.");
                miVentana.limpiarLiberacion();
            } else{
                miVentana.mostrarError("Ha ocurrido un error mientras se procesaba el pedido.");
            }
        }
    }

    /**
     * Abre la reparación seleccionada en la vista
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void abrirReparacion() throws ClassNotFoundException, Exception {
        boolean encontrado = false;
        int contador = 0;
        ArrayList<Pedido> listaPedidos = Repositorio.repositorio().devolverPedidos();
        while (!encontrado && contador < listaPedidos.size()) {
            Pedido p = listaPedidos.get(contador);
            if (p.getNumeroPedido() == Integer.parseInt(miVentana.getjComboBoxPedidosPendientes().getSelectedItem().toString())) {
                encontrado = true;
                reparacionSeleccionada = (Reparacion) p;
            }
            contador++;
        }
        ArrayList<Gestor> listaGestores = Repositorio.repositorio().devolverGestores();
        boolean gEncontrado = false;
        int gContador = 0;
        while (!gEncontrado && gContador < listaGestores.size()) {
            Gestor g = listaGestores.get(gContador);
            if (reparacionSeleccionada.getProveedor() == g.getId()) {
                gEncontrado = true;
                miVentana.getjButtonFinalizarPedido().setEnabled(true);
                miVentana.getjTextFieldProveedor().setText(g.getNombre());
                miVentana.getjTextAreaDiagnostico().setText("---- Mensaje inicial ----\n" + reparacionSeleccionada.getDiagnostico() + "\n\n---- Informe de resultado ----\n");
            }
            gContador++;
        }
        
    }

    /**
     * Abre la reparación seleccionada en la vista
     * @throws ClassNotFoundException Error cuando no se encuentra el driver
     * @throws Exception Error cuando falla otra cosa
     */
    public void abrirLiberacion() throws ClassNotFoundException, Exception {
        boolean encontrado = false;
        int contador = 0;
        ArrayList<Pedido> listaPedidos = Repositorio.repositorio().devolverPedidos();
        while (!encontrado && contador < listaPedidos.size()) {
            Pedido p = listaPedidos.get(contador);
            if (p.getNumeroPedido() == Integer.parseInt(miVentana.getjComboBoxPedidosPendientes().getSelectedItem().toString())) {
                encontrado = true;
                liberacionSeleccionada = (Liberacion) p;
            }
            contador++;
        }
        ArrayList<Gestor> listaGestores = Repositorio.repositorio().devolverGestores();
        boolean gEncontrado = false;
        int gContador = 0;
        while (!gEncontrado && gContador < listaGestores.size()) {
            Gestor g = listaGestores.get(gContador);
            if (liberacionSeleccionada.getOperador() == g.getId()) {
                gEncontrado = true;
                miVentana.getjTextFieldImei().setText(liberacionSeleccionada.getImei());
                DefaultComboBoxModel dcb = new DefaultComboBoxModel();
                dcb.addElement(g.getNombre());
                miVentana.getjComboBoxOperadores().setModel(dcb);
                miVentana.getjButtonSolicitarCodigo().setEnabled(true);
            }
            gContador++;
        }
        
    }

    /**
     * Muestra un aviso de que se va a completar un pedido
     * @param tipo Tipo de pedido que se va a finalizar
     * @return True si ha aceptado el aviso, false si no
     */
    public boolean mostrarAvisoPedido(Object tipo) {
        boolean respuesta;
        if (tipo instanceof Reparacion) {
            int reply = JOptionPane.showConfirmDialog(miVentana, "Se va a finalizar el pedido " + reparacionSeleccionada.getNumeroPedido() + ". ¿Es correcto?", "Confirma los datos", JOptionPane.YES_NO_OPTION);
            respuesta = reply == JOptionPane.YES_OPTION;
        } else {
            int reply = JOptionPane.showConfirmDialog(miVentana, "Se va a finalizar el pedido " + liberacionSeleccionada.getNumeroPedido() + ". ¿Es correcto?", "Confirma los datos", JOptionPane.YES_NO_OPTION);
            respuesta = reply == JOptionPane.YES_OPTION;
        }
        return respuesta;
    }
    
    /**
     * Abre la vista de gestión de gestores
     */
    public void abrirGestionGestores(){
        GestionGestores gProveedores = new GestionGestores((Frame)miVentana.getParent(), true);
        gProveedores.setVisible(true);
    }
}
