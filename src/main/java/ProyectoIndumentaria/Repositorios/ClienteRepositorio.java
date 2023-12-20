
package ProyectoIndumentaria.Repositorios;

import ProyectoIndumentaria.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {

    @Query("SELECT c FROM Cliente c WHERE c.id= :id")
    public Cliente buscarPorId(@Param("id") String id);

    // Metodo para buscar usuario por email
    @Query("SELECT c FROM Cliente c WHERE c.email = :email")
    public Cliente buscarPorEmail(@Param("email") String email);

}
