package com.portfolio.portfolio.services;

import com.portfolio.portfolio.models.Contacto;
import com.portfolio.portfolio.models.Correo;
import com.portfolio.portfolio.models.Direccion;
import com.portfolio.portfolio.models.Telefono;
import com.portfolio.portfolio.repository.ContactoRepo;
import com.portfolio.portfolio.repository.CorreoRepo;
import com.portfolio.portfolio.repository.DireccionRepo;
import com.portfolio.portfolio.repository.TelefonoRepo;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "https://portfoliofrontend-716b2.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ContactoService {
    
    @Autowired
    CorreoRepo correoRepo;
    
    @Autowired
    TelefonoRepo telefonoRepo;
    
    @Autowired
    DireccionRepo direccionRepo;
    
    @Autowired
    ContactoRepo contactoRepo;
    
    @GetMapping(path="/buscar")
    public List<Contacto> getAllContacto(){
        return contactoRepo.findAll();
    }
    
    @PostMapping(path="/add")
    public Contacto createContacto(@RequestBody Contacto contacto){
        
        List<Correo> correos = contacto.getListCorreo();
        List<Direccion> direcciones = contacto.getListDireccion();
        List<Telefono> telefonos = contacto.getListTelefono();
        
        contacto.setListCorreo(null);
        contacto.setListDireccion(null);
        contacto.setListTelefono(null);
        
        contacto = contactoRepo.save(contacto);
        
        contacto.setListTelefono(new LinkedList<>());
        contacto.setListCorreo(new LinkedList<>());
        contacto.setListDireccion(new LinkedList<>());
        
        if(correos!=null){
            for(Correo c : correos){
                c.setContactoidcontacto(contacto.getIdcontacto());
                correoRepo.save(c);
                contacto.getListCorreo().add(c);
            }
        }
        
        if(direcciones!=null){
            for(Direccion d : direcciones){
                d.setContactoidcontacto(contacto.getIdcontacto());
                direccionRepo.save(d);
                contacto.getListDireccion().add(d);
            }
        }
        
        if(telefonos!=null){
            for(Telefono t : telefonos){
                t.setContactoidcontacto(contacto.getIdcontacto());
                telefonoRepo.save(t);
                contacto.getListTelefono().add(t);
            }
        }        
        
        
        return contacto;
    }
    
    @DeleteMapping(path="/delete/{idcontacto}")
    public void deleteContacto(@PathVariable ("idcontacto") Integer idcontacto){
        
        Optional<Contacto> contacto;
        contacto= contactoRepo.findById(idcontacto);
        
        if(contacto.isPresent()){
            
            Contacto borrar = contacto.get();
            for(Telefono t: borrar.getListTelefono()){
                telefonoRepo.delete(t);
            }
            
            for(Direccion d: borrar.getListDireccion()){
                direccionRepo.delete(d);
            }
             
            for(Correo c: borrar.getListCorreo()){
                correoRepo.delete(c);
            }
            
            contactoRepo.delete(contacto.get());
        }
    }
    
    @GetMapping("/buscar/correo/{correo}")
    public List<Contacto> findByCorreo(@PathVariable ("correo") String correo){
        
        return contactoRepo.findByUsercorreo(correo);
        
    }
    
}
