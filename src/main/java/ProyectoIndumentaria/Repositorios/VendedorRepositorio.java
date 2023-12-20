package ProyectoIndumentaria.Repositorios;

import ProyectoIndumentaria.Entidades.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepositorio extends JpaRepository<Vendedor, String> {
    
    @Query("SELECT v FROM Vendedor v WHERE v.id= :id")
    public Vendedor buscarPorId(@Param ("id")String id);
    
}
