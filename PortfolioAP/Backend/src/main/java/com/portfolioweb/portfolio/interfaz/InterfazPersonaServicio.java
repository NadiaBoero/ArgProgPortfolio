
package com.portfolioweb.portfolio.interfaz;

import com.portfolioweb.portfolio.entidad.Persona;
import java.util.List;


public interface InterfazPersonaServicio {
    //traer lista personas
    
    public List<Persona> GetPersona();
    
    //guardar objeto persona
    public void savePersona(Persona persona);
    
    //eliminar objeto persona por ID
    
    public void deletePersona(Long id);
    
    //buscar objeto persona por ID
    public Persona findPersona(Long id);
}
