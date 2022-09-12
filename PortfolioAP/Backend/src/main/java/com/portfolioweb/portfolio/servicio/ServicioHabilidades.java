
package com.portfolioweb.portfolio.servicio;

import com.portfolioweb.portfolio.entidad.Habilidades;
import com.portfolioweb.portfolio.repositorio.RepositorioHabilidades;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioHabilidades {
    @Autowired
    RepositorioHabilidades repositorioHabilidades;
    
    public List<Habilidades>list(){
        return repositorioHabilidades.findAll();
    }
    
     public Optional<Habilidades> getByNombre(String nombre){
        return repositorioHabilidades.findByNombre(nombre);
        
    }
    
    public Optional<Habilidades> getOne(int id){
        return repositorioHabilidades.findById(id);
        
    }
    
    public void save(Habilidades skill){
        repositorioHabilidades.save(skill);
    }
    
    public void delete(int id){
        repositorioHabilidades.deleteById(id);
    }
    public boolean existsById(int id){
        return repositorioHabilidades.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return repositorioHabilidades.existsByNombre(nombre);
    }
}
