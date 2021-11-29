package com.prueba.usuarios.service;

import java.util.List;
import java.util.Optional;

import com.prueba.usuarios.persistence.UserRepository;
import com.prueba.usuarios.persistence.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UserRepository userRepository;

    public List<Usuario> getByName(String nombre){
        return  userRepository.getByName(nombre);

    }

    public List<Usuario> getAll(){
        return  userRepository.getAll();

    }
    public Optional<Usuario> getUser(int id){
        return userRepository.getById(id);

    }
    public Usuario save(Usuario usuario){
        return userRepository.save(usuario);
    }
    public boolean delete(int id){
        return getUser(id).map(usuario->{
            userRepository.delete(id);
            return true;
        }).orElse(false);
    }
   /*  public Usuario update(Usuario nuevUsuario, int id){
        userRepository.findById(id)
        .map(
            usuario ->{
                usuario.setNombre(nuevUsuario.getNombre());
                usuario.setRol(nuevUsuario.getRol());
                usuario.setActivo(nuevUsuario.getActivo());
                Usuario user;
                return userRepository.save(user);
            }
            );
        return nuevUsuario;
       */  
    
}
