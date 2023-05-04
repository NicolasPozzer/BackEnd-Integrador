package com.portfolio.nico.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String iniciO;
    private String fiN;
    private String marcA;
    private String descripcionE;

    //Constructores
    public Experiencia() {
    }

    public Experiencia(String nombreE, String iniciO, String fiN, String marcA, String descripcionE) {
        this.nombreE = nombreE;
        this.iniciO = iniciO;
        this.fiN = fiN;
        this.marcA = marcA;
        this.descripcionE = descripcionE;
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
