
package com.portfolioweb.portfolio.servicio;

import com.portfolioweb.portfolio.entidad.Persona;
import com.portfolioweb.portfolio.repositorio.InterfazPersonaRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaServicio{
    @Autowired InterfazPersonaRepositorio interfazPersonaRepositorio;
    
    public List <Persona> list(){
        return interfazPersonaRepositorio.findAll();
        
    }
    
    public Optional <Persona> getOne(int id){
        return interfazPersonaRepositorio.findById(id);
    }
    
    public Optional <Persona> getByNombre(String nombre){
        return interfazPersonaRepositorio.findByNombre(nombre);
    }
    
    public void save(Persona persona){
        interfazPersonaRepositorio.save(persona);
        
    }
    
       public void delete(int id){
        interfazPersonaRepositorio.deleteById(id);
        
    }
       
       public boolean existsById(int id){
           return interfazPersonaRepositorio.existsById(id);
       }
    
    public boolean existsByNombre(String nombre){
           return interfazPersonaRepositorio.existsByNombre(nombre);
       }
   
        
   
    
}
