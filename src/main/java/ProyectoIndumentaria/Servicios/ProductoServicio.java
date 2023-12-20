
package ProyectoIndumentaria.Servicios;

import ProyectoIndumentaria.Entidades.Categoria;
import ProyectoIndumentaria.Entidades.Producto;
import ProyectoIndumentaria.Excepciones.MiException;
import ProyectoIndumentaria.Repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ProductoServicio{
    
    
    @Autowired
    private ProductoRepositorio productoRepositorio;
    
    
    @Transactional
    public void crearProducto(String nombre, Double precio, Categoria categoria, Boolean altaBaja, String talle, Integer cantidad ) throws MiException{
        
        
        validarProducto(nombre, precio, categoria, talle, cantidad);
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setCategoria(categoria);
        producto.setTalle(talle);
        
        producto.setAltaBaja(true);
        
        
        productoRepositorio.save(producto);
        
        
    }
    
    
    private void validarProducto(String nombre, Double precio, Categoria categoria, String talle, Integer cantidad ) throws MiException{
        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("Debes completar tu nombre");
        }
        if (precio == null) {
            throw new MiException("Debes completar el precio");
        }
        if (talle == null || talle.isEmpty()) {
            throw new MiException("Debes completar el talle");
        }
        if (cantidad == null ) {
            throw new MiException("Debes completar la cantidad de productos: " + nombre);
        }
    }
    
    
    
    
}
