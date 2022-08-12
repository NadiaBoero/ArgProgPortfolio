
package com.portfolioweb.portfolio.repositorio;

import com.portfolioweb.portfolio.entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazPersonaRepositorio extends JpaRepository<Persona, Long> {
    
}





