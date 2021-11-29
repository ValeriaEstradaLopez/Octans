package com.prueba.usuarios.service;

import java.util.List;

import com.prueba.usuarios.persistence.RolRepository;
import com.prueba.usuarios.persistence.entity.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    @Autowired
   private RolRepository rolRepository;

   public List<Rol> getAll(){
    return (List<Rol>) rolRepository.getAll();
}
}
