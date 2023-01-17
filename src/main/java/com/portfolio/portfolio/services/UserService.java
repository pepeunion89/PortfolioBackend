package com.portfolio.portfolio.services;

import com.portfolio.portfolio.models.User;
import com.portfolio.portfolio.repository.UserRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "https://portfoliofrontend-716b2.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserService {
    
    @Autowired
    UserRepo userRepo;
    
    @GetMapping(path="/buscar")
    public List<User> getAllUser(){
        return userRepo.findAll();
    }
    
    @PostMapping(path="/add")
    public User createUser(@RequestBody User user){
        return userRepo.save(user);
    }
    
    @DeleteMapping(path="/delete/{correo}")
    public void deleteUser(@PathVariable ("correo") String correo){
        
        Optional<User> user;
        user= userRepo.findById(correo);
        
        if(user.isPresent()){
            userRepo.delete(user.get());
        }
    }
    
    @PostMapping(path = "/login")
    public User login(@RequestBody User user){
                
        List<User> userList = userRepo.findByCorreoAndPassword(user.getCorreo(), user.getPassword());
        
        if(!userList.isEmpty()){
            return userList.get(0);
        }
        
        return null;
        
    }
    
}
