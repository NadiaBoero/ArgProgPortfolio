
package com.portfolioweb.portfolio.servicio;

import com.portfolioweb.portfolio.entidad.Persona;
import com.portfolioweb.portfolio.interfaz.InterfazPersonaServicio;
import com.portfolioweb.portfolio.repositorio.InterfazPersonaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicio implements InterfazPersonaServicio {
    @Autowired InterfazPersonaRepositorio interfazPersonaRepositorio;

    @Override
    public List<Persona> GetPersona() {
        List<Persona> persona = interfazPersonaRepositorio.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        interfazPersonaRepositorio.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        interfazPersonaRepositorio.deleteById(id);
        
    }

    
    @Override
    public Persona findPersona(Long id) {
      Persona persona = interfazPersonaRepositorio.findById(id).orElse(null);
      return persona;
        
   }
    
}
