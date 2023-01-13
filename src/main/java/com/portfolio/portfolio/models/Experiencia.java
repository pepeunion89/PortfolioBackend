package com.portfolio.portfolio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExperiencia;
    private String tituloExperiencia;
    private int fechaExperiencia;
    private String descripcionExperiencia;
    private String imagenExperiencia;

    public Experiencia() {
    }

    public Experiencia(Long idExperiencia, String tituloExperiencia, int fechaExperiencia, String descripcionExperiencia, String imagenExperiencia) {
        this.idExperiencia = idExperiencia;
        this.tituloExperiencia = tituloExperiencia;
        this.fechaExperiencia = fechaExperiencia;
        this.descripcionExperiencia = descripcionExperiencia;
        this.imagenExperiencia = imagenExperiencia;
    }
    
    
    
    
}
