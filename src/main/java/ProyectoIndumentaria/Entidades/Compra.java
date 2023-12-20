package ProyectoIndumentaria.Entidades;
       

import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

    
public class Compra {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
<<<<<<< HEAD
    
    private Double monto;
    
    private Cliente cliente;
    
    private List<Producto> productos;
    
=======
    private Double monto;
    private Cliente cliente;
    private List<Producto> productos;
>>>>>>> 845405022b0863b2c12fbc347a9267d598633bbd
    private Date fechaCompra;

    
    
    public Compra() {
    }

    public Compra(String id, Double monto, Cliente cliente, List<Producto> productos, Date fechaCompra) {
        this.id = id;
        this.monto = monto;
        this.cliente = cliente;
        this.productos = productos;
        this.fechaCompra = fechaCompra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    
            
    
}
