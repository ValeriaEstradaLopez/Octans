package com.prueba.usuarios.persistence.crud;

import java.util.List;

import com.prueba.usuarios.persistence.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;


@Component
public interface UserCrudRepository extends JpaRepository<Usuario, Integer>{
    
    List<Usuario> findAll();
    List<Usuario> findByNombre(String nombre);
   
}
