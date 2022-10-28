
package com.portfolioweb.portfolio.repositorio;

import com.portfolioweb.portfolio.entidad.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProyectos extends JpaRepository<Proyectos, Integer> {
    public Optional<Proyectos>findByNombreProyecto(String nombreProyecto);
    public boolean existsByNombreProyecto(String nombreProyecto);
    
}
