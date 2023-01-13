package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.models.Formacion;
import com.portfolio.portfolio.services.FormacionService;
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
@RequestMapping("/formacion")
@CrossOrigin(origins = "http://localhost:4200")
public class FormacionController {
    
    private final FormacionService formacionService;

    public FormacionController(FormacionService formacionService) {
        this.formacionService = formacionService;
    }
            
    @PutMapping("/update")
    public ResponseEntity<Formacion> editarFormacion(@RequestBody Formacion formacion){
        
        Formacion formacionActualizado = formacionService.updateFormacion(formacion);
        
        return new ResponseEntity<>(formacionActualizado, HttpStatus.OK);
        
    }
    
    @GetMapping("/lista")
    public ResponseEntity<List<Formacion>> obtenerFormacion(){
        
        List<Formacion> listFormacion = formacionService.getFormacion();
        
        return new ResponseEntity<>(listFormacion, HttpStatus.OK);
        
    }
    
    @PostMapping("/add")
    public ResponseEntity<Formacion> crearFormacion(@RequestBody Formacion formacion){
        
        Formacion nuevaFormacion = formacionService.addFormacion(formacion);
        
        return new ResponseEntity<>(nuevaFormacion, HttpStatus.CREATED);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarFormacion(@PathVariable ("id") Long id){
        
        formacionService.deleteFormacion(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
}
