package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.models.Telefono;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("telefonoRepo")
public interface TelefonoRepo extends JpaRepository<Telefono, Serializable>{
    
}
