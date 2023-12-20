package ProyectoIndumentaria.Servicios;

import ProyectoIndumentaria.Entidades.Cliente;
import ProyectoIndumentaria.Excepciones.MiException;
import ProyectoIndumentaria.Repositorios.ClienteRepositorio;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServicio implements UserDetailsService {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Transactional
    public void crearCliente(String nombre, String apellido, String documento, String email, String password, String password2,
            String telefono, String pais, String provincia, String localidad, String calle, Integer numero) throws MiException {

        validarCliente(nombre, apellido, documento, telefono, pais, provincia, localidad, calle, numero);
        validarEmail(email);
        validarPassword(password, password2);

        Cliente cliente = new Cliente();

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDocumento(documento);
        cliente.setEmail(email);
        cliente.setPassword(password);
        cliente.setTelefono(telefono);
        cliente.setPais(pais);
        cliente.setProvincia(provincia);
        cliente.setLocalidad(localidad);
        cliente.setCalle(calle);
        cliente.setNumero(numero);
        cliente.setAltaBaja(true);

        clienteRepositorio.save(cliente);

    }
    
    @Transactional
    public void modificarCliente(String id, String nombre, String apellido, String documento, String email, String password, String password2,
            String telefono, String pais, String provincia, String localidad, String calle, Integer numero) throws MiException{
        
        Optional<Cliente> respuesta = clienteRepositorio.findById(id);
        
        if(respuesta.isPresent()) {
            
            Cliente cliente = new Cliente();
            
            validarCliente(nombre, apellido, documento, telefono, pais, provincia, localidad, calle, numero);
            validarEmail(email);
            validarPassword(password, password2);
            
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDocumento(documento);
            cliente.setTelefono(telefono);
            cliente.setPais(pais);
            cliente.setProvincia(provincia);
            cliente.setLocalidad(localidad);
            cliente.setCalle(calle);
            cliente.setNumero(numero);
            
            clienteRepositorio.save(cliente);
            
        }
    }
    
    @Transactional
    public void darAltaBaja(Cliente cliente){
        
        if (cliente.getAltaBaja()) {
            cliente.setAltaBaja(Boolean.FALSE);
        } else {
            cliente.setAltaBaja(Boolean.TRUE);
        }
        
    }
    
    @Transactional
    public void eliminar(Cliente cliente) {
        
        Optional<Cliente> respuesta = clienteRepositorio.findById(cliente.getId());
        
        if(respuesta.isPresent()) {
            clienteRepositorio.delete(cliente);
        }
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void validarCliente(String nombre, String apellido, String documento, String telefono, String pais, String provincia, String localidad, String calle, Integer numero) throws MiException {

        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("Debes completar tu nombre");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new MiException("Debes completar tu apellido");
        }
        if (documento == null || documento.isEmpty()) {
            throw new MiException("Debes completar tu DNI");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new MiException("Debes completar tu número de telefono");
        }
        if (pais == null || pais.isEmpty()) {
            throw new MiException("Debes completar tu pais");
        }
        if (provincia == null || provincia.isEmpty()) {
            throw new MiException("Debes completar tu provincia");
        }
        if (localidad == null || localidad.isEmpty()) {
            throw new MiException("Debes completar tu localidad");
        }
        if (calle == null || calle.isEmpty()) {
            throw new MiException("Debes completar tu calle");
        }
        if (numero == null) {
            throw new MiException("Debes completar tu numero");
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
