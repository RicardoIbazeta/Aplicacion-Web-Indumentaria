package ProyectoIndumentaria.Repositorios;

import ProyectoIndumentaria.Entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, String>{
    @Query("SELECT c FROM Categoria c WHERE c.id= :id")
    public Categoria buscarPorId(@Param ("id")String id);
    
    @Query("SELECT c FROM Categoria c WHERE c.nombre = :nombre")
    public Categoria buscarPorCategoria(@Param ("nombre")String nombre);
    
}

