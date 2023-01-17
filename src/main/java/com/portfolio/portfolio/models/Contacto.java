package com.portfolio.portfolio.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name="contacto")
public class Contacto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="idcontacto")
    private Integer idcontacto;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    @Lob
    @Column(name="fotografia")
    private String fotografia;
    
    @Column(name="user_correo")
    private String usercorreo;
    
    @OneToMany(mappedBy = "contactoidcontacto")
    private List<Correo> listCorreo;
    
    @OneToMany(mappedBy = "contactoidcontacto")
    private List<Telefono> listTelefono;
    
    @OneToMany(mappedBy = "contactoidcontacto")
    private List<Direccion> listDireccion;
    
}
