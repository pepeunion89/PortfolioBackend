package com.portfolio.portfolio.services;

import com.portfolio.portfolio.models.Skills;
import com.portfolio.portfolio.repository.SkillsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsService {
    
    private final SkillsRepo skillsRepo;
    
    @Autowired
    public SkillsService(SkillsRepo skillsRepo){
        this.skillsRepo = skillsRepo;
    }
    
    public Skills addSkills(Skills skills){       
        return skillsRepo.save(skills);
    }
    
    public List<Skills> getSkills(){
        return skillsRepo.findAll();
    }
    
    public Skills updateSkills(Skills skills){
        Skills skillsId = skillsRepo.findById(skills.getIdSkills()).get();
        skillsId.setImagenSkills(skills.getImagenSkills());
        skillsId.setNombreSkills(skills.getNombreSkills());
        skillsId.setPorcentajeSkills(skills.getPorcentajeSkills()); 
                
        return skillsRepo.save(skills);
    }
    
    public void deleteSkills(Long id){
        skillsRepo.deleteById(id);
    }
    
}
