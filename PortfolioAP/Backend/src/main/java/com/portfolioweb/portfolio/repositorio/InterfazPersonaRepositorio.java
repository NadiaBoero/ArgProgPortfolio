
package com.portfolioweb.portfolio.repositorio;

import com.portfolioweb.portfolio.entidad.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazPersonaRepositorio extends JpaRepository<Persona, Integer> {
    public Optional<Persona>findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}





