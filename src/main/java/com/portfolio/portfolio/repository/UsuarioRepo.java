package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Long>{
    
}
