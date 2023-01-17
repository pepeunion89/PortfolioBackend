package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.models.Direccion;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("direccionRepo")
public interface DireccionRepo extends JpaRepository<Direccion, Serializable>{
    
}
