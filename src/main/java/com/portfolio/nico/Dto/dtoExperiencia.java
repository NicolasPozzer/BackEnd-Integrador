package com.portfolio.nico.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String iniciO;
    @NotBlank
    private String fiN;
    @NotBlank
    private String marcA;
    @NotBlank
    private String descripcionE;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String iniciO, String fiN, String marcA, String descripcionE) {
        this.nombreE = nombreE;
        this.iniciO = iniciO;
        this.fiN = fiN;
        this.marcA = marcA;
        this.descripcionE = descripcionE;
    }
    //Getters & Setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }
    
    public String getIniciO() {
        return iniciO;
    }

    public void setIniciO(String iniciO) {
        this.iniciO = iniciO;
    }
    
    public String getFiN() {
        return fiN;
    }

    public void setFiN(String fiN) {
        this.fiN = fiN;
    }
    
    public String getMarcA() {
        return marcA;
    }

    public void setMarcA(String marcA) {
        this.marcA = marcA;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
}
