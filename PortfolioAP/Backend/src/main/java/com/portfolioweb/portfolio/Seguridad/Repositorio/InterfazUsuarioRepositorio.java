package com.portfolioweb.portfolio.Seguridad.Repositorio;

import com.portfolioweb.portfolio.Seguridad.Entidad.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazUsuarioRepositorio extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
   boolean existsByNombreUsuario(String nombreUsuario);
   boolean existsByEmail(String email);
   
    
}
