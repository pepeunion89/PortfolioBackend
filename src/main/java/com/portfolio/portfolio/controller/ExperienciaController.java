package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.models.Experiencia;
import com.portfolio.portfolio.services.ExperienciaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "https://portfoliofrontend-716b2.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    
     private final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }
            
    @PutMapping("/update")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia experiencia){
        
        Experiencia experienciaActualizado = experienciaService.updateExperiencia(experiencia);
        
        return new ResponseEntity<>(experienciaActualizado, HttpStatus.OK);
        
    }
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> obtenerExperiencia(){
        
        List<Experiencia> listExperiencia = experienciaService.getExperiencias();
        
        return new ResponseEntity<>(listExperiencia, HttpStatus.OK);
        
    }
    
    @PostMapping("/add")
    public ResponseEntity<Experiencia> crearExperiencia(@RequestBody Experiencia experiencia){
        
        Experiencia nuevaExperiencia = experienciaService.addExperiencia(experiencia);
        
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarExperiencia(@PathVariable ("id") Long id){
        
        experienciaService.deleteExperiencia(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
}
