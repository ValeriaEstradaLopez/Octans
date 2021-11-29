package com.prueba.usuarios.controller;

import java.util.List;

import com.prueba.usuarios.persistence.entity.Rol;
import com.prueba.usuarios.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/rol")
public class RolControlller {
	@Autowired
private RolService rolService;

	@GetMapping("/all")
	public List<Rol> getAll() {
		return  rolService.getAll();
	}

}

