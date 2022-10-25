
package com.portfolioweb.portfolio.controlador;

import com.portfolioweb.portfolio.Dto.DtoHabilidades;
import com.portfolioweb.portfolio.Seguridad.Controlador.Mensaje;
import com.portfolioweb.portfolio.entidad.Habilidades;
import com.portfolioweb.portfolio.servicio.ServicioHabilidades;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidades")
@CrossOrigin(origins = {"https://frontend-portfolio-nadia.web.app", "http://localhost:4200"})
public class ControladorHabilidades {
     @Autowired
     ServicioHabilidades servicioHabilidades;
     
     @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> list = servicioHabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id")int id){
        if(!servicioHabilidades.existsById(id)){
         return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);    
        }
        
        Habilidades habilidades = servicioHabilidades.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
            
            
     }   
    
     @DeleteMapping("delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        if(!servicioHabilidades.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
        }
        servicioHabilidades.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada correctamente"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHabilidades dtoHabilidades) {
        if (StringUtils.isBlank(dtoHabilidades.getNombre())) {
            return new ResponseEntity(new Mensaje("Completar nombre"), HttpStatus.BAD_REQUEST);
        }
        if (servicioHabilidades.existsByNombre(dtoHabilidades.getNombre())) {
            return new ResponseEntity(new Mensaje("Informacion de Habilidades ya existente"), HttpStatus.BAD_REQUEST);
        }

       Habilidades habilidades= new Habilidades (dtoHabilidades.getNombre(), dtoHabilidades.getPorcentaje());
        servicioHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje("Informacion de Habilidades Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody DtoHabilidades dtoHabilidades){
        if(!servicioHabilidades.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
 
       }
        if(servicioHabilidades.existsByNombre(dtoHabilidades.getNombre()) && servicioHabilidades
                .getByNombre(dtoHabilidades.getNombre()).get().getId() !=id){
            
             return new ResponseEntity(new Mensaje("Esa habilidad ya existe"),HttpStatus.BAD_REQUEST);    
        }
        
        if(StringUtils.isBlank(dtoHabilidades.getNombre())){
            return new ResponseEntity(new Mensaje("Campos Obligatorios"),HttpStatus.BAD_REQUEST);
        }
        Habilidades habilidades = servicioHabilidades.getOne(id).get();
        habilidades.setNombre(dtoHabilidades.getNombre());
        habilidades.setPorcentaje(dtoHabilidades.getPorcentaje());
        
        servicioHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje("Informacion Habilidades Actualizada Correctamente"),HttpStatus.OK);
      
       
        
    }
    
}
