
package com.portfolioweb.portfolio.controlador;

import com.portfolioweb.portfolio.Dto.DtoAcercaDe;
import com.portfolioweb.portfolio.Seguridad.Controlador.Mensaje;
import com.portfolioweb.portfolio.entidad.AcercaDe;
import com.portfolioweb.portfolio.servicio.ServicioAcercaDe;
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
@RequestMapping("acercade")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorAcercaDe {
    
    @Autowired
    ServicioAcercaDe servicioAcercaDe;

    @GetMapping("/lista")
    public ResponseEntity<List<AcercaDe>> list() {
        List<AcercaDe> list = servicioAcercaDe.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDe> getById(@PathVariable("id")int id){
        if(!servicioAcercaDe.existsById(id)){
         return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);    
        }
        
        AcercaDe acercaDe = servicioAcercaDe.getOne(id).get();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
            
            
     }   
    
     @DeleteMapping("delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        if(!servicioAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
        }
        servicioAcercaDe.delete(id);
        return new ResponseEntity(new Mensaje("Informacion Acerca De eliminada correctamente"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoAcercaDe dtoAcercaDe) {
        if (StringUtils.isBlank(dtoAcercaDe.getNombreAcerca())) {
            return new ResponseEntity(new Mensaje("Completar nombre"), HttpStatus.BAD_REQUEST);
        }
        if (servicioAcercaDe.existsByNombreAcerca(dtoAcercaDe.getNombreAcerca())) {
            return new ResponseEntity(new Mensaje("Informacion Acerca De ya existente"), HttpStatus.BAD_REQUEST);
        }

       AcercaDe acercaDe= new AcercaDe (dtoAcercaDe.getNombreAcerca(), dtoAcercaDe.getDescripcionAcerca());
        servicioAcercaDe.save(acercaDe);
        return new ResponseEntity(new Mensaje("Informacion Acerca De Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody DtoAcercaDe dtoAcercaDe){
        if(!servicioAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);
 
       }
        if(servicioAcercaDe.existsByNombreAcerca(dtoAcercaDe.getNombreAcerca())&&servicioAcercaDe
                .getByNombreAcerca(dtoAcercaDe.getNombreAcerca()).get().getId() !=id){
            
             return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);    
        }
        
        if(StringUtils.isBlank(dtoAcercaDe.getNombreAcerca())){
            return new ResponseEntity(new Mensaje("Campos Obligatorios"),HttpStatus.BAD_REQUEST);
        }
        AcercaDe acercaDe = servicioAcercaDe.getOne(id).get();
        acercaDe.setNombreAcerca(dtoAcercaDe.getNombreAcerca());
        acercaDe.setDescripcionAcerca(dtoAcercaDe.getDescripcionAcerca());
        
        servicioAcercaDe.save(acercaDe);
        return new ResponseEntity(new Mensaje("Informacion Acerca De Actualizada Correctamente"),HttpStatus.OK);
      
       
        
    }
    
}
