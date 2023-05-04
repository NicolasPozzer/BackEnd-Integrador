package com.portfolio.nico.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String urldemO;
    
    //Constructores

    public Proyecto() {
    }

    public Proyecto(String nombreE, String descripcionE, String urldemO) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urldemO = urldemO;
    }
    
    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    public String getUrldemO() {
        return urldemO;
    }

    public void setUrldemO(String urldemO) {
        this.urldemO = urldemO;
    }
    
}
