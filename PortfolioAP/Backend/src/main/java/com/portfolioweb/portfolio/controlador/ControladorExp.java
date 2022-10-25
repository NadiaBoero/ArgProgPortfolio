package com.portfolioweb.portfolio.controlador;

import com.portfolioweb.portfolio.Dto.DtoExp;
import com.portfolioweb.portfolio.Seguridad.Controlador.Mensaje;
import com.portfolioweb.portfolio.entidad.explaboral;
import com.portfolioweb.portfolio.servicio.ServicioExperiencia;
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
@RequestMapping("explaboral")
@CrossOrigin(origins = {"https://frontend-portfolio-nadia.web.app", "http://localhost:4200"})
public class ControladorExp {

    @Autowired
    ServicioExperiencia servicioExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<explaboral>> list() {
        List<explaboral> list = servicioExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<explaboral> getById(@PathVariable("id")int id){
        if(!servicioExperiencia.existsById(id)){
         return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.NOT_FOUND);    
        }
        
        explaboral explaboral = servicioExperiencia.getOne(id).get();
        return new ResponseEntity(explaboral, HttpStatus.OK);
            
            
     }   

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExp dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Completar nombre"), HttpStatus.BAD_REQUEST);
        }
        if (servicioExperiencia.existsByNombreExp(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Experiencia Laboral ya existente"), HttpStatus.BAD_REQUEST);
        }

        explaboral explaboral = new explaboral(dtoExp.getNombreExp(), dtoExp.getDescripcionExp());
        servicioExperiencia.save(explaboral);
        return new ResponseEntity(new Mensaje("Experiencia Laboral agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExp dtoExp) {
        if (!servicioExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        }

        if (servicioExperiencia.existsByNombreExp(dtoExp.getNombreExp()) && servicioExperiencia.getByNombreExp(dtoExp.getNombreExp()).get().
                getId() != id) {
            return new ResponseEntity(new Mensaje("Experiencia Laboral existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        explaboral explaboral = servicioExperiencia.getOne(id).get();
        explaboral.setNombreExp(dtoExp.getNombreExp());
        explaboral.setDescripcionExp((dtoExp.getDescripcionExp()));

        servicioExperiencia.save(explaboral);
        return new ResponseEntity(new Mensaje("Experiencia Laboral actualizada correctamente"), HttpStatus.OK);

    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!servicioExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        servicioExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia Laboral borrada correctamente"), HttpStatus.OK);

    }

}
