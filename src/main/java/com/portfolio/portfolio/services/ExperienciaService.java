package com.portfolio.portfolio.services;

import com.portfolio.portfolio.models.Experiencia;
import com.portfolio.portfolio.repository.ExperienciaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {
    
    private final ExperienciaRepo experienciaRepo;
    
    @Autowired
    public ExperienciaService(ExperienciaRepo experienciaRepo){
        this.experienciaRepo = experienciaRepo;
    }
    
    public Experiencia addExperiencia(Experiencia experiencia){       
        return experienciaRepo.save(experiencia);
    }
    
    public List<Experiencia> getExperiencias(){
        return experienciaRepo.findAll();
    }
    
    public Experiencia updateExperiencia(Experiencia experiencia){
        Experiencia expeId = experienciaRepo.findById(experiencia.getIdExperiencia()).get();
        expeId.setDescripcionExperiencia(experiencia.getDescripcionExperiencia());
        expeId.setFechaExperiencia(experiencia.getFechaExperiencia());
        expeId.setImagenExperiencia(experiencia.getImagenExperiencia());
        expeId.setTituloExperiencia(experiencia.getTituloExperiencia());
                
        return experienciaRepo.save(expeId);
    }
    
    public void deleteExperiencia(Long id){
        experienciaRepo.deleteById(id);
    }
    
}
