package com.portfolioweb.portfolio.repositorio;

import com.portfolioweb.portfolio.entidad.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion>findByNombreEdu(String nombreEdu);
    public boolean existsByNombreEdu(String nombreEdu);
    
    
}
