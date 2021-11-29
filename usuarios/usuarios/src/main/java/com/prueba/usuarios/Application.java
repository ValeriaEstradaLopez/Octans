package com.prueba.usuarios;

//import com.prueba.usuarios.persistence.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
	/* private UserRepository userRepository; */

/* 	public UsuariosApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	} */

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
