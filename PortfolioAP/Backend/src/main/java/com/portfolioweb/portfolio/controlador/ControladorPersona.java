
package com.portfolioweb.portfolio.controlador;

import com.portfolioweb.portfolio.Dto.DtoPersona;
import com.portfolioweb.portfolio.Seguridad.Controlador.Mensaje;
import com.portfolioweb.portfolio.entidad.Persona;
import com.portfolioweb.portfolio.servicio.PersonaServicio;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorPersona {
    @Autowired
    PersonaServicio personaServicio;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list=personaServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaServicio.existsById(id)){
         return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);    
        }
        
        Persona persona = personaServicio.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
            
            
     }       
            
            
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody DtoPersona dtopersona){
        if(!personaServicio.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
 
       }
        if(personaServicio.existsByNombre(dtopersona.getNombre())&&personaServicio
                .getByNombre(dtopersona.getNombre()).get().getId() !=id){
            
             return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);    
        }
        
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Campos Obligatorios"),HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaServicio.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        
        personaServicio.save(persona);
        return new ResponseEntity(new Mensaje("Persona Actualizada Correctamente"),HttpStatus.OK);
      
       
        
    }
}
