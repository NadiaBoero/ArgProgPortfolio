
package com.portfolioweb.portfolio.Seguridad.Repositorio;

import com.portfolioweb.portfolio.Seguridad.Entidad.Rol;
import com.portfolioweb.portfolio.Seguridad.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazRolRepositorio extends JpaRepository<Rol,Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
