
package com.portfolioweb.portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class DtoAcercaDe {
    @NotBlank
    private String nombreAcerca;
    @NotBlank
    private String descripcionAcerca;

    public DtoAcercaDe() {
    }

    public DtoAcercaDe(String nombreAcerca, String descripcionAcerca) {
        this.nombreAcerca = nombreAcerca;
        this.descripcionAcerca = descripcionAcerca;
    }

    public String getNombreAcerca() {
        return nombreAcerca;
    }

    public void setNombreAcerca(String nombreAcerca) {
        this.nombreAcerca = nombreAcerca;
    }

    public String getDescripcionAcerca() {
        return descripcionAcerca;
    }

    public void setDescripcionAcerca(String descripcionAcerca) {
        this.descripcionAcerca = descripcionAcerca;
    }
    
    

   
    
}
