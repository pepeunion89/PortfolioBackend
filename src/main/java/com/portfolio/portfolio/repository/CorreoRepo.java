package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.models.Correo;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("correoRepo")
public interface CorreoRepo extends JpaRepository<Correo, Serializable>{
    
}
