package com.portfolio.nico.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String urldemO;
    
    //Constructores

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreE, String descripcionE, String urldemO) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urldemO = urldemO;
        
    }
    //Getters & Setters

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
