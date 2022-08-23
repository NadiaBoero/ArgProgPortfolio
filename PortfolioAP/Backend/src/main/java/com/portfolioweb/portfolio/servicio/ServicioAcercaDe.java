
package com.portfolioweb.portfolio.servicio;

import com.portfolioweb.portfolio.entidad.AcercaDe;
import com.portfolioweb.portfolio.repositorio.RepositorioAcercaDe;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioAcercaDe {
    
    @Autowired
    RepositorioAcercaDe repositorioAcercaDe;
    
    public List<AcercaDe> list(){
    return repositorioAcercaDe.findAll();
    
}
    
    public Optional<AcercaDe> getOne(int id){
        return repositorioAcercaDe.findById(id);
    }
    
    public Optional<AcercaDe> getByNombreAcerca(String nombreAcerca){
        return repositorioAcercaDe.findByNombreAcerca(nombreAcerca);
    }
    
    public void save(AcercaDe acercaDe){
        repositorioAcercaDe.save(acercaDe);
    }
    
    public void delete(int id){
        repositorioAcercaDe.deleteById(id);
    }
    
    public boolean existsById(int id){
          return repositorioAcercaDe.existsById(id);
      }
    
    public boolean existsByNombreAcerca(String nombreAcerca){
        return repositorioAcercaDe.existsByNombreAcerca(nombreAcerca);
        
      }
      
    
}
