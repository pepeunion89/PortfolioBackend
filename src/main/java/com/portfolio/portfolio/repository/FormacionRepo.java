package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.models.Formacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FormacionRepo extends JpaRepository<Formacion, Long> {
    
}
