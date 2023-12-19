package ProyectoIndumentaria.Repositorios;

import ProyectoIndumentaria.Entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, String>{
    
}
