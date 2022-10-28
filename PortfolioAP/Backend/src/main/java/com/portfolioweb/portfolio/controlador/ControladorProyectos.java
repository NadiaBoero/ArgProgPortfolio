package com.portfolioweb.portfolio.controlador;

import com.portfolioweb.portfolio.Dto.DtoProyectos;
import com.portfolioweb.portfolio.Seguridad.Controlador.Mensaje;
import com.portfolioweb.portfolio.entidad.Proyectos;
import com.portfolioweb.portfolio.servicio.ServicioProyectos;
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
@RequestMapping("/proyectos")
@CrossOrigin (origins = {"https://frontend-portfolio-nadia.web.app", "http://localhost:4200"})


public class ControladorProyectos {
    @Autowired ServicioProyectos servicioProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = servicioProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")int id){
        if(!servicioProyectos.existsById(id)){
         return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);    
        }
        
        Proyectos proyectos = servicioProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
            
            
     }   
    
     @DeleteMapping("delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        if(!servicioProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
        }
        servicioProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado correctamente"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyectos) {
        if (StringUtils.isBlank(dtoProyectos.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("Completar nombre"), HttpStatus.BAD_REQUEST);
        }
        if (servicioProyectos.existsByNombreProyecto(dtoProyectos.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("Informacion de Proyecto ya existente"), HttpStatus.BAD_REQUEST);
        }

       Proyectos proyectos= new Proyectos (dtoProyectos.getNombreProyecto(), dtoProyectos.getDescripcionProyecto(),dtoProyectos.getUrlProyecto(),dtoProyectos.getImgProyecto());
        servicioProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Informacion de Proyecto Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoProyectos){
        if(!servicioProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
 
       }
        if(servicioProyectos.existsByNombreProyecto(dtoProyectos.getNombreProyecto()) && servicioProyectos
                .getByNombreProyecto(dtoProyectos.getNombreProyecto()).get().getId() !=id){
            
             return new ResponseEntity(new Mensaje("Ese proyecto ya existe"),HttpStatus.BAD_REQUEST);    
        }
        
        if(StringUtils.isBlank(dtoProyectos.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("Campos Obligatorios"),HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = servicioProyectos.getOne(id).get();
        proyectos.setNombreProyecto(dtoProyectos.getNombreProyecto());
        proyectos.setDescripcionProyecto(dtoProyectos.getDescripcionProyecto());
        proyectos.setUrlProyecto(dtoProyectos.getUrlProyecto());
        proyectos.setImgProyecto(dtoProyectos.getImgProyecto());
        
        servicioProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Informacion de Proyectos Actualizada Correctamente"),HttpStatus.OK);
      
       
        
    }
    
}
