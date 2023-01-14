package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.models.Usuario;
import com.portfolio.portfolio.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
//@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Long id){
        
        Usuario usuario = usuarioService.getUsuarioPorId(id);
        
        return new ResponseEntity<>(usuario, HttpStatus.OK);
        
    }
    
    @PutMapping("/update")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        
        Usuario usuarioActualizado = usuarioService.updateUsuario(usuario);
        
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        
    }
    
}
