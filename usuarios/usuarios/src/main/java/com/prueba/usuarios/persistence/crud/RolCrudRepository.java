package com.prueba.usuarios.persistence.crud;

import java.util.List;

import com.prueba.usuarios.persistence.entity.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolCrudRepository extends JpaRepository<Rol,Integer>{
    List<Rol> findAll();
}
