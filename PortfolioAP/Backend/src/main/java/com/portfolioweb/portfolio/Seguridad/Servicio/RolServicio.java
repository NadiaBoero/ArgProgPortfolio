package com.portfolioweb.portfolio.Seguridad.Servicio;

import com.portfolioweb.portfolio.Seguridad.Entidad.Rol;
import com.portfolioweb.portfolio.Seguridad.Enums.RolNombre;
import com.portfolioweb.portfolio.Seguridad.Repositorio.InterfazRolRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolServicio {
    @Autowired
    InterfazRolRepositorio InterfazRolRepositorio;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return InterfazRolRepositorio.findByRolNombre(rolNombre);
        
    }
    
    public void  save (Rol rol){
        InterfazRolRepositorio.save(rol);
        
    }
}
