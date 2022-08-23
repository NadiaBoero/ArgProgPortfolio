
package com.portfolioweb.portfolio.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AcercaDe {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombreAcerca;
    private String descripcionAcerca;

    public AcercaDe() {
    }

    public AcercaDe(String nombreAcerca, String descripcionAcerca) {
        this.nombreAcerca = nombreAcerca;
        this.descripcionAcerca = descripcionAcerca;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
