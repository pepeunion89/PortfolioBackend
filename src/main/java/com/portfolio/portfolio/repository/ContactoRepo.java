package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.models.Contacto;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contactoRepo")
public interface ContactoRepo extends JpaRepository<Contacto, Serializable>{
    
    public List<Contacto> findByUsercorreo(String usercorreo);
    
}
