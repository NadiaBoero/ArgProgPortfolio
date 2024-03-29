
package com.portfolioweb.portfolio.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class explaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreExp;
    private String descripcionExp;

    public explaboral() {
    }

    public explaboral(String nombreExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }
    
    
    
}
