package com.portfolio.portfolio.services;

import com.portfolio.portfolio.exception.UserNotFoundException;
import com.portfolio.portfolio.models.Usuario;
import com.portfolio.portfolio.repository.UsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
        
    private final UsuarioRepo usuarioRepo;
    
    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }
    
    public Usuario addUsuario(Usuario usuario){       
        return usuarioRepo.save(usuario);
    }
    
    public List<Usuario> getUsuario(){
        return usuarioRepo.findAll();
    }
    
    public Usuario getUsuarioPorId(Long id){
        return usuarioRepo.findById(id).orElseThrow(()->new UserNotFoundException("Usuario no existe."));
    }
    
    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
    
    public void deleteUsuario(Long id){
        usuarioRepo.deleteById(id);
    }
    
        
    
}
