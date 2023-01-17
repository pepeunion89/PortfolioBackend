package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.models.User;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Serializable>{
    
    public List<User> findByCorreoAndPassword(String correo, String password);
    
}
