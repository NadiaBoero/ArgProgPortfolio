
package com.portfolioweb.portfolio.servicio;

import com.portfolioweb.portfolio.entidad.explaboral;
import com.portfolioweb.portfolio.repositorio.RepositorioExp;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioExperiencia {
    @Autowired
    RepositorioExp repositorioExp;
    
    public List <explaboral> list(){
        return repositorioExp.findAll();
        
    }
    
    public Optional <explaboral> getOne(int id){
        return repositorioExp.findById(id);
    }
    
    public Optional <explaboral> getByNombreExp(String nombreExp){
        return repositorioExp.findByNombreExp(nombreExp);
    }
    
    public void save(explaboral exp){
        repositorioExp.save(exp);
        
    }
    
       public void delete(int id){
        repositorioExp.deleteById(id);
        
    }
       
       public boolean existsById(int id){
           return repositorioExp.existsById(id);
       }
    
    public boolean existsByNombreExp(String nombreExp){
           return repositorioExp.existsByNombreExp(nombreExp);
       }
    
    
    
}
 