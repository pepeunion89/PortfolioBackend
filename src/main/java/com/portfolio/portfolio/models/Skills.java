/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkills;
    private String nombreSkills;
    private String imagenSkills;
    private int porcentajeSkills;

    public Skills() {
    }

    public Skills(Long idSkills, String nombreSkills, String imagenSkills, int porcentajeSkills) {
        this.idSkills = idSkills;
        this.nombreSkills = nombreSkills;
        this.imagenSkills = imagenSkills;
        this.porcentajeSkills = porcentajeSkills;
    }
    
    
    
}
