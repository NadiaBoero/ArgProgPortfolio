/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioweb.portfolio.servicio;

import com.portfolioweb.portfolio.entidad.Educacion;
import com.portfolioweb.portfolio.repositorio.RepositorioEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioEducacion {
    @Autowired
    RepositorioEducacion repositorioEducacion;
    
    public List<Educacion> list(){
    return repositorioEducacion.findAll();
    
}
    
    public Optional<Educacion> getOne(int id){
        return repositorioEducacion.findById(id);
    }
    
    public Optional<Educacion> getByNombreEdu(String nombreEdu){
        return repositorioEducacion.findByNombreEdu(nombreEdu);
    }
    
    public void save(Educacion educacion){
        repositorioEducacion.save(educacion);
    }
    
    public void delete(int id){
        repositorioEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
          return repositorioEducacion.existsById(id);
      }
    
    public boolean existsByNombreEdu(String nombreEdu){
        return repositorioEducacion.existsByNombreEdu(nombreEdu);
        
      }
      
      
}
