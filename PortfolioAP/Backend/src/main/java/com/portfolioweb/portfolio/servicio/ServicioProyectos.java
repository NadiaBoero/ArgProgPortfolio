
package com.portfolioweb.portfolio.servicio;

import com.portfolioweb.portfolio.entidad.Proyectos;
import com.portfolioweb.portfolio.repositorio.RepositorioProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioProyectos {
    @Autowired RepositorioProyectos repositorioProyectos;
    
    public List<Proyectos> list(){
    return repositorioProyectos.findAll();
    
}
    
    public Optional<Proyectos> getOne(int id){
        return repositorioProyectos.findById(id);
    }
    
    public Optional<Proyectos> getByNombreProyecto(String nombreProyecto){
        return repositorioProyectos.findByNombreProyecto(nombreProyecto);
    }
    
    public void save(Proyectos proyectos){
        repositorioProyectos.save(proyectos);
    }
    
    public void delete(int id){
        repositorioProyectos.deleteById(id);
    }
    
    public boolean existsById(int id){
          return repositorioProyectos.existsById(id);
      }
    
    public boolean existsByNombreProyecto(String nombreProyecto){
        return repositorioProyectos.existsByNombreProyecto(nombreProyecto);
        
      }
    
}
