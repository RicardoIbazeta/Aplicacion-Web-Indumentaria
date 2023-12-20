package ProyectoIndumentaria.Servicios;

import ProyectoIndumentaria.Entidades.Categoria;
import ProyectoIndumentaria.Repositorios.CategoriaRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServicio {

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    // Metodo para crear categorias
    @Transactional
    public void crearCategoria(String nombre) {

        Categoria categoria = new Categoria();

        categoria.setNombre(nombre);
        categoria.setAltaBaja(Boolean.TRUE);

        categoriaRepositorio.save(categoria);

    }

    // Metodo para modificar la categoria
    @Transactional
    public void modificarCategoria(String id, String nombre) {

        Optional<Categoria> respuesta = categoriaRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Categoria categoria = new Categoria();

            categoria.setNombre(nombre);

            categoriaRepositorio.save(categoria);
        }
    }

    // Metodo que permite eliminar una categoria
    @Transactional
    public void eliminarCategoria(Categoria categoria) {

        Optional<Categoria> respuestaCategoria = categoriaRepositorio.findById(categoria.getId());

        if (respuestaCategoria.isPresent()) {

            categoriaRepositorio.delete(categoria);
        }

    }

    // Metodo para listar las categorias
    public List<Categoria> listarCategorias() {

        List<Categoria> categorias = new ArrayList();

        categorias = categoriaRepositorio.findAll();

        return categorias;

    }

    public List<Categoria> buscarPorCategoria(String query) {
        return (List<Categoria>) categoriaRepositorio.buscarPorCategoria(query);
    }

}


