
package com.portfolioweb.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {
    
    @NotBlank
     private  String nombre;
    @NotBlank
     private String apellido;
     @NotBlank
     private String descripcion;
     @NotBlank
     private String img;

    public DtoPersona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
     
     
     
    
}
