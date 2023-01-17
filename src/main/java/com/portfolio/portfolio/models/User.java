package com.portfolio.portfolio.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="user")
public class User implements Serializable{
    
    @Id
    @Basic(optional = false)
    @Column(name="correo")
    private String correo;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    @Lob
    @Column(name="forografia")
    private String fotografia;    
    
    @Column(name="password")
    private String password;
    
    @Column(name="rol_idrol")
    private Integer rolidrol;
    
    
    
    
    
}
