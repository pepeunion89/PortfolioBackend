package com.portfolio.portfolio.services;

import com.portfolio.portfolio.models.Rol;
import com.portfolio.portfolio.repository.RolRepo;
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
@RequestMapping("/rol")
@CrossOrigin(origins = "https://portfoliofrontend-716b2.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class RolService {
    
    @Autowired
    RolRepo rolRepo;
    
    @GetMapping(path="/buscar")
    public List<Rol> getAllRol(){
        return rolRepo.findAll();
    }
    
    @PostMapping(path="/add")
    public Rol createRol(@RequestBody Rol rol){
        return rolRepo.save(rol);
    }
    
    @DeleteMapping(path="/delete/{idrol}")
    public void deleteRol(@PathVariable ("idrol") Integer idrol){
        
        Optional<Rol> rol;
        rol= rolRepo.findById(idrol);
        
        if(rol.isPresent()){
            rolRepo.delete(rol.get());
        }
    }
    
    
}
