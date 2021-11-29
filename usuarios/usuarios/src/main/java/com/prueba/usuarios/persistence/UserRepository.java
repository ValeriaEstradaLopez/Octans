package com.prueba.usuarios.persistence;

import java.util.List;
import java.util.Optional;

import com.prueba.usuarios.persistence.crud.UserCrudRepository;
import com.prueba.usuarios.persistence.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
 @Autowired
    private UserCrudRepository userCrudRepository;

    public List<Usuario> getAll(){
        return (List<Usuario>) userCrudRepository.findAll();
    }
    
    public List<Usuario> getByName(String nombre){
        return userCrudRepository.findByNombre(nombre);
    }
    public Optional <Usuario> getById(Integer id){
        return userCrudRepository.findById(id);
    }

    public Usuario save(Usuario usuario){
        return userCrudRepository.save(usuario);
    }
    public Optional<Usuario> findById(int id){
        return userCrudRepository.findById(id);
    }

    public void delete(Integer id){
        userCrudRepository.deleteById(id);
    }
}

