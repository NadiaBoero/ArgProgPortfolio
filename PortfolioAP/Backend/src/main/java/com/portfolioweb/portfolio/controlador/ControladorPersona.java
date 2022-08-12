
package com.portfolioweb.portfolio.controlador;

import com.portfolioweb.portfolio.entidad.Persona;
import com.portfolioweb.portfolio.interfaz.InterfazPersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorPersona {
    @Autowired InterfazPersonaServicio interfazPersonaServicio;
    
    @GetMapping("personas/traer")
    public List<Persona> GetPersona(){
        return interfazPersonaServicio.GetPersona();
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
            interfazPersonaServicio.savePersona(persona);
           return "El usuario fue creado correctamente";}
    
    @PreAuthorize("hasRole ('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        interfazPersonaServicio.deletePersona(id);
               return"El usuario fue eliminado correctamente";
    }
    
    
    ///personas/editar/nroId?nombre=nuevoNombre&apellido=nuevoApellido&img=nuevoIMG
    @PreAuthorize("hasRole ('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id, 
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg){
        Persona persona = interfazPersonaServicio.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        interfazPersonaServicio.savePersona(persona);
        return persona;
    }
    
    @GetMapping("personas/traer/perfil")
    public Persona findPersona(){
        return interfazPersonaServicio.findPersona((long) 1);
    }
}
