package com.biblioteca.biblioteca_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaBackendApplication.class, args);
	}
	spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_db
	spring.datasource.username=tu_usuario
	spring.datasource.password=tu_contraseña
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.show-sql=true
}


