
package ProyectoIndumentaria.Servicios;

import ProyectoIndumentaria.Entidades.Vendedor;
import ProyectoIndumentaria.Excepciones.MiException;
import ProyectoIndumentaria.Repositorios.VendedorRepositorio;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendedorServicio {
    
    @Autowired
    private VendedorRepositorio vendedorRepositorio;
    
    @Transactional
    public void crearVendedor(String email, String password, String password2) throws MiException{
        
        validarEmail(email);
        validarPassword(password, password2);
        
        Vendedor vendedor = new Vendedor();
        
        vendedor.setEmail(email);
        vendedor.setPassword(password);
        
        vendedorRepositorio.save(vendedor);
        
    }
    
    @Transactional
    public void modificarVendedor(String id, String email, String password, String password2) throws MiException{
        
        Optional<Vendedor> respuesta = vendedorRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            
            Vendedor vendedor = new Vendedor();
            
            validarEmail(email);
            validarPassword(password, password2);
            
            vendedor.setEmail(email);
            vendedor.setPassword(password);
            
            vendedorRepositorio.save(vendedor);   
        }
    }
    
    @Transactional
    public void eliminar(Vendedor vendedor) {
        
        Optional<Vendedor> respuesta = vendedorRepositorio.findById(vendedor.getId());
        
        if(respuesta.isPresent()) {
            vendedorRepositorio.delete(vendedor);
        }
    }
    
    private void validarEmail(String email) throws MiException {

        if (email == null || email.isEmpty()) {
            throw new MiException("Debes completar tu correo electrónico");
        }

        String emailRegex = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$";
        Pattern patron = Pattern.compile(emailRegex);

        Matcher match = patron.matcher(email);
        if (!match.find()) {
            throw new MiException("Correo electrónico invalido");
        }
    }

    private void validarPassword(String password, String password2) throws MiException {

        if (password.isEmpty()) {
            throw new MiException("La contraseña no debe estar vacía");
        }
        if (password.length() < 8) {
            throw new MiException("La contraseña debe tener al menos 8 caracteres");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new MiException("La contraseña debe contener al menos una letra mayúscula");
        }
        if (!password.matches(".*\\d.*")) {
            throw new MiException("La contraseña debe contener al menos un número");
        }
        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas deben coincidir");
        }
    }
    
    
}
