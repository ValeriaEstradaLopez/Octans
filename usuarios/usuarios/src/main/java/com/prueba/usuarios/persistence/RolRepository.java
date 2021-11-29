package com.prueba.usuarios.persistence;

import java.util.List;

import com.prueba.usuarios.persistence.crud.RolCrudRepository;
import com.prueba.usuarios.persistence.entity.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolRepository {
    @Autowired
    private RolCrudRepository rolCrudRepository;

    public List<Rol> getAll(){
        return (List<Rol>) rolCrudRepository.findAll();
    }
}
