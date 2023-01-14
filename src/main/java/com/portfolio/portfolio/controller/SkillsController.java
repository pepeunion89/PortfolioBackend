package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.models.Skills;
import com.portfolio.portfolio.services.SkillsService;
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
@RequestMapping("/skills")
//@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {
    
     private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }
            
    @PutMapping("/update")
    public ResponseEntity<Skills> editarSkills(@RequestBody Skills skills){
        
        Skills skillsActualizado = skillsService.updateSkills(skills);
        
        return new ResponseEntity<>(skillsActualizado, HttpStatus.OK);
        
    }
    
    @GetMapping("/listado")
    public ResponseEntity<List<Skills>> obtenerSkills(){
        
        List<Skills> listSkills = skillsService.getSkills();
        
        return new ResponseEntity<>(listSkills, HttpStatus.OK);
        
    }
    
    @PostMapping("/add")
    public ResponseEntity<Skills> crearSkills(@RequestBody Skills skills){
        
        Skills nuevoSkills = skillsService.addSkills(skills);
        
        return new ResponseEntity<>(nuevoSkills, HttpStatus.CREATED);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarSkills(@PathVariable ("id") Long id){
        
        skillsService.deleteSkills(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
}
