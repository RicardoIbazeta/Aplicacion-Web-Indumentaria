package ProyectoIndumentaria.repositorios;

import ProyectoIndumentaria.entidades.Categoria;
import ProyectoIndumentaria.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String> {
    
    @Query("SELECT p FROM Producto p WHERE p.id= :id")
    public Producto buscarPorId(@Param ("id")String id);
    
}
