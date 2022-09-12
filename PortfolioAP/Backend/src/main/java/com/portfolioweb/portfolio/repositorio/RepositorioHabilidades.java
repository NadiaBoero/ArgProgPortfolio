
package com.portfolioweb.portfolio.repositorio;


import com.portfolioweb.portfolio.entidad.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioHabilidades extends JpaRepository<Habilidades,Integer>{
    Optional<Habilidades> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
