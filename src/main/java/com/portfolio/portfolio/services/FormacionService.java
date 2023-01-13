package com.portfolio.portfolio.services;

import com.portfolio.portfolio.models.Formacion;
import com.portfolio.portfolio.repository.FormacionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FormacionService {
    
    private final FormacionRepo formacionRepo;
    
    @Autowired
    public FormacionService(FormacionRepo formacionRepo){
        this.formacionRepo = formacionRepo;
    }
    
    public Formacion addFormacion(Formacion formacion){ 
        return formacionRepo.save(formacion);
    }
    
    public List<Formacion> getFormacion(){
        return formacionRepo.findAll();
    }
    
    public Formacion updateFormacion(Formacion formacion){        
        Formacion forId = formacionRepo.findById(formacion.getIdFormacion()).get();
        forId.setDescripcionFormacion(formacion.getDescripcionFormacion());
        forId.setFechaFormacion(formacion.getFechaFormacion());
        forId.setImagenFormacion(formacion.getImagenFormacion());
        forId.setTituloFormacion(formacion.getTituloFormacion());
                
        return formacionRepo.save(forId);
    }
    
    public void deleteFormacion(Long id){
        formacionRepo.deleteById(id);
    }
    
}
