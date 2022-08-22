
package com.portfolioweb.portfolio.repositorio;

import com.portfolioweb.portfolio.entidad.explaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioExp extends JpaRepository<explaboral, Integer> {
    public Optional<explaboral> findByNombreExp(String nombreExp);
    public boolean existsByNombreExp(String nombreExp);
}
