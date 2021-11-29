package com.prueba.usuarios.controller;
import java.util.List;
import java.util.Optional;

import com.prueba.usuarios.persistence.UserRepository;
import com.prueba.usuarios.persistence.entity.Usuario;
import com.prueba.usuarios.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UserRepository userRepository;
    
  
    
   
    @GetMapping("/all")
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }
@GetMapping("/{id}")
    public Optional<Usuario> getUser(@PathVariable("id") int id ){
        return usuarioService.getUser(id);
    }

    @GetMapping("/name/{name}")
    public List<Usuario> getByName(@PathVariable("name") String nombre){
        return usuarioService.getByName(nombre);
    }
    @PostMapping("/create")
  public Usuario save(Usuario usuario){
      return usuarioService.save(usuario);
  }
  @DeleteMapping("/delete/{id}")
  public boolean delete(int id){
      return usuarioService.delete(id);
  }
  @PutMapping("/update/{id}")
  Usuario replaceUser(@RequestBody Usuario newusuario, @PathVariable int id){
    return userRepository.findById(id)
    .map(usuario -> {
      usuario.setNombre(newusuario.getNombre());
      usuario.setRol(newusuario.getRol());
      return userRepository.save(usuario);
    })
    .orElseGet(() -> {
      //newusuario.setId(id);
      return userRepository.save(newusuario);
    });
  }
  /* public Usuario update(@PathVariable("id") int id){
return usuarioService.upddate()
  } */

}
