/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import almacen.Ingreso;
import almacen.Producto;
import almacen.Salida;
import almacen.Usuario;
import java.beans.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Willy Aguirre
 */
public class Controlador implements Serializable {

    OperarHelper operar;
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private String sampleProperty;
    private PropertyChangeSupport propertySupport;

    public Controlador() {
        propertySupport = new PropertyChangeSupport(this);
        operar = new OperarHelper();
    }

    public String getSampleProperty() {
        return sampleProperty;
    }

    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    //Tabla Usuario
    //Validad Usuario
    public boolean verificarUsusario(String usuario, String clave) {
        return operar.validarUsuario(usuario, clave);
    }

    //actualizar ususario
    public boolean modificarClave(Usuario u){
        return operar.actualizarUsuario(u);
    }

     //lista de usuarios
    public List mostrarUsuarios(){
        return operar.ListaUsuarios();
    }

    //traer segun codigo
    public Usuario datosUsuarios(String codigo){
        return operar.verDatosUsuarios(codigo);
    }

    //Tabla Producto
    //añadir producto
    public boolean insertarProducto(Producto p) {
        return operar.agregarProducto(p);
    }

    //lista de productos
    public List mostrarProductos(){
        return operar.ListaProductos();
    }
    //traer segun codigo
    public Producto datosProducto(String codigo){
        return operar.verDatosProductos(codigo);
    }
    //actualizar producto
    public boolean modificarProducto(Producto p){
        return operar.actualizarProducto(p);
    }

    //actualizar producto
    public boolean modificarCantidadProducto(Producto p){
        return operar.actualizarCantidadProducto(p);
    }

    //lista de productos
    public List buscarProductos(String presentacion){
        return operar.buscarProductos(presentacion);
    }

    //Tabla Salida
    //añadir salida
    public boolean insertarSalida(Salida s) {
        return operar.agregarSalida(s);
    }

    //lista de productos
    public List mostrarSalidas(){
        return operar.ListaSalidas();
    }
    
    //Tabla Ingreso
    //añadir ingreso
    public boolean insertarIngreso(Ingreso i) {
        return operar.agregarIngreso(i);
    }

    //lista de productos
    public List mostrarIngresos(){
        return operar.ListaIngresos();
    }
}
