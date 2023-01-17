package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.models.Rol;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("rolRepo")
public interface RolRepo extends JpaRepository<Rol, Serializable>{
    
}
