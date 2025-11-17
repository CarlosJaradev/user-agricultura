package com.proyecto.prueba.Model;

import com.github.javafaker.Job;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Table(name="USUARIO")
@Data //Notacion de lombo, ahorramos getters y setters
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	private String documento;
	
	private String nombres;
	
	private String apellidos;
	
	private String email;
	
	private String cargo;

	
}