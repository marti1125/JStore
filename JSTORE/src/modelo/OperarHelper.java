/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import almacen.Ingreso;
import almacen.Producto;
import almacen.Salida;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import servicios.HibernateUtil;
import almacen.Usuario;

/**
 *
 * @author Willy Aguirre
 */
public class OperarHelper {

    Session ayudar;
    Transaction operacion = null;
    Query consulta;
    List lista;

    public OperarHelper() {
        ayudar = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //validar usuario
    public boolean validarUsuario(String usuario, String clave) {
        boolean hecho = false;
        Usuario user = null;
        String sentencia = "from Usuario where usuario='" + usuario
                + "' and clave='" + clave + "'";
        try {

            operacion = ayudar.beginTransaction();
            List<Usuario> listaUsuarios = (List<Usuario>) ayudar.createQuery(sentencia).list();
            if (!listaUsuarios.isEmpty()) {
                user = listaUsuarios.get(0);
                hecho = true;
            } else {
                System.out.println("fracaso");
            }

        } catch (Exception e) {
            System.out.println("error");
        }
        return hecho;
    }

    //tabla usuario actualizar
    public boolean actualizarUsuario(Usuario u) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Usuario xp = (Usuario) ayudar.load(Usuario.class, u.getIdUsuario());
            xp.setClave(u.getClave());
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }

    //lista de productos
    public List ListaUsuarios() {
        List productos = null;
        String sentencia = "from Usuario";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            productos = consulta.list();
        } catch (Exception e) {
            System.out.println(e);
        }
        return productos;
    }

    //tabla usuario verdatos
    public Usuario verDatosUsuarios(String codigo) {
        Usuario xcod = null;
        String sentencia = "from Usuario where idUsuario='" + codigo + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xcod = (Usuario) consulta.uniqueResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return xcod;
    }

    //tabla producto
    //agregar Producto
    boolean agregarProducto(Producto p) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(p);
            operacion.commit();
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }

    //lista de productos
    public List ListaProductos() {
        List productos = null;
        String sentencia = "from Producto";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            productos = consulta.list();
        } catch (Exception e) {
            System.out.println(e);
        }
        return productos;
    }

    //tabla producto verdatos
    public Producto verDatosProductos(String codigo) {
        Producto xcod = null;
        String sentencia = "from Producto where idProducto='" + codigo + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xcod = (Producto) consulta.uniqueResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return xcod;
    }

    //tabla producto actualizar
    public boolean actualizarProducto(Producto p) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Producto xp = (Producto) ayudar.load(Producto.class, p.getIdProducto());
            xp.setCodProducto(p.getCodProducto());
            xp.setPresentacion(p.getPresentacion());
            xp.setCantidad(p.getCantidad());
            xp.setFecha(p.getFecha());
            ayudar.update(xp);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }

    //tabla producto actualizar
    public boolean actualizarCantidadProducto(Producto p) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Producto xp = (Producto) ayudar.load(Producto.class, p.getIdProducto());            
            xp.setCantidad(p.getCantidad());            
            ayudar.update(xp);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }

    //buscar productos
    public List buscarProductos(String presentacion) {
        List productos = null;
        String sentencia = "from Producto where codProducto=" + presentacion + "";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            productos = consulta.list();
        } catch (Exception e) {
            System.out.println(e);
        }
        return productos;
    }

    //tabla Salida
    //agregar Salida
    boolean agregarSalida(Salida s) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(s);
            operacion.commit();
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }

    //lista de salidas
    public List ListaSalidas() {
        List salidas = null;
        String sentencia = "from Salida";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            salidas = consulta.list();
        } catch (Exception e) {
            System.out.println(e);
        }
        return salidas;
    }

    //tabla Ingreso
    //agregar Ingreso
    boolean agregarIngreso(Ingreso i) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(i);
            operacion.commit();
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }

    //lista de Ingresos
    public List ListaIngresos() {
        List ingresos = null;
        String sentencia = "from Ingreso";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            ingresos = consulta.list();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ingresos;
    }
}
