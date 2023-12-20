
package ProyectoIndumentaria.Servicios;

import ProyectoIndumentaria.Entidades.Cliente;
import ProyectoIndumentaria.Entidades.Compra;
import ProyectoIndumentaria.Entidades.Producto;
import ProyectoIndumentaria.Repositorios.CompraRepositorio;
import java.util.Date;
import java.util.List;


public class CompraServicio {
    
    private CompraRepositorio compraRepositorio;
    
    
    public void crearCompra(Cliente cliente, List<Producto> productos ){
        
        Compra compra= new Compra();
        compra.setCliente(cliente);
        double montoTotal=0.0;
        
        for (Producto producto : productos) {
            double precio=producto.getPrecio();
            montoTotal+=precio;
        }
        
        compra.setMonto(montoTotal);
        compra.setFechaCompra(new Date());
        compraRepositorio.save(compra);
    }
    
    public 
    
}
