package com.portfolio.portfolio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String titulo;
    private String descripcion;
    private String foroPerfil;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="idExperiencia")
    private List<Experiencia> listExperiencia;
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="idFormacion")
    private List<Formacion> listFormacion;
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="idSkills")
    private List<Skills> listSkills;
    
    public Usuario(){
        
    }

    public Usuario(Long idUsuario, String nombre, String apellido, String titulo, String descripcion, String foroPerfil) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foroPerfil = foroPerfil;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getForoPerfil() {
        return foroPerfil;
    }

    public void setForoPerfil(String foroPerfil) {
        this.foroPerfil = foroPerfil;
    }
    
    
    
    
}
