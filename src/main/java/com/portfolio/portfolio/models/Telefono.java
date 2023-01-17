package com.portfolio.portfolio.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name="telefono")
public class Telefono implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="idtelefono")
    private Integer idtelefono;
    
    @Column(name="numero")
    private String numero;
    
    @Column(name="contacto_idcontacto")
    private Integer contactoidcontacto;
    
}
