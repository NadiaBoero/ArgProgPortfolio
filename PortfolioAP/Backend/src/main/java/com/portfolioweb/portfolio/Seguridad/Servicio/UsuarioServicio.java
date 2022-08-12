
package com.portfolioweb.portfolio.Seguridad.Servicio;

import com.portfolioweb.portfolio.Seguridad.Entidad.Usuario;
import com.portfolioweb.portfolio.Seguridad.Repositorio.InterfazUsuarioRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioServicio {
    @Autowired
    InterfazUsuarioRepositorio InterfazUsuarioRepositorio;
    
    public Optional <Usuario> getByNombreUsuario(String nombreUsuario){
        return InterfazUsuarioRepositorio.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return InterfazUsuarioRepositorio.existsByNombreUsuario(nombreUsuario);
    }
    
     public boolean existsByEmail(String email){
        return InterfazUsuarioRepositorio.existsByEmail(email);
    }
     
     public void  save (Usuario usuario){
        InterfazUsuarioRepositorio.save(usuario);
    }
      
      
}
