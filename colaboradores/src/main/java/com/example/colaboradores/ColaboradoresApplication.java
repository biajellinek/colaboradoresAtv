package com.example.colaboradores;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.colaboradores.entities.AdminEntity;
import com.example.colaboradores.repositories.AdminRepository;

@SpringBootApplication
public class ColaboradoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColaboradoresApplication.class, args);
	}

}
