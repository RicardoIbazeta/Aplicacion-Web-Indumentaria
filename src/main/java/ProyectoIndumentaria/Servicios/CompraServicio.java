
package ProyectoIndumentaria.Servicios;

import ProyectoIndumentaria.Entidades.Cliente;
import ProyectoIndumentaria.Entidades.Compra;
import ProyectoIndumentaria.Entidades.Producto;
import ProyectoIndumentaria.Repositorios.CompraRepositorio;
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
    
}
