
package ProyectoIndumentaria.servicios;

import ProyectoIndumentaria.entidades.Cliente;
import ProyectoIndumentaria.entidades.Compra;
import ProyectoIndumentaria.entidades.Producto;
import ProyectoIndumentaria.repositorios.CompraRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;


public class CompraServicio {
    
    private CompraRepositorio compraRepositorio;
    
    @Transactional
    public void crearCompra(Cliente cliente, Producto producto ){
        Compra compra= new Compra();
        compra.setCliente(cliente);
        compra.setMonto(producto.getPrecio());
        compra.setFechaCompra(new Date());
        compra.setProducto(producto);
        compraRepositorio.save(compra);
    }
    
    
    
    
    public void cancelarCompra(String id){
        Optional <Compra> respuesta= compraRepositorio.findById(id);
        if (respuesta.isPresent()){
            Compra compra = respuesta.get();
            compraRepositorio.delete(compra);
        }
    }
    
    
    
}
