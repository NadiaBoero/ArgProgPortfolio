
package com.portfolioweb.portfolio.repositorio;

import com.portfolioweb.portfolio.entidad.AcercaDe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAcercaDe extends JpaRepository<AcercaDe, Integer> {
    public Optional<AcercaDe>findByNombreAcerca(String nombreAcerca);
    public boolean existsByNombreAcerca(String nombreAcerca);
    
}
