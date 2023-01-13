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
public class Formacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFormacion;
    private String tituloFormacion;
    private int fechaFormacion;
    private String descripcionFormacion;
    private String imagenFormacion;

    public Formacion() {
    }

    public Formacion(Long idFormacion, String tituloFormacion, int fechaFormacion, String descripcionFormacion, String imagenFormacion) {
        this.idFormacion = idFormacion;
        this.tituloFormacion = tituloFormacion;
        this.fechaFormacion = fechaFormacion;
        this.descripcionFormacion = descripcionFormacion;
        this.imagenFormacion = imagenFormacion;
    }
    
    
    
}
