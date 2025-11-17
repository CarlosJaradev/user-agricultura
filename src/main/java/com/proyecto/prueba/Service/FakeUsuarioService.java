package com.proyecto.prueba.Service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.proyecto.prueba.Model.Usuario;
import com.proyecto.prueba.Repository.UsuarioRepository;

@Service
public class FakeUsuarioService {
		
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public void generarFakeUsuario(int numeroUsuario){
		
		Faker faker = new Faker(new Locale("es"));
		
		for(int i = 0; i <numeroUsuario; i++) {
			Usuario usuario = new Usuario();
			usuario.setDocumento(faker.idNumber().valid());
			usuario.setNombres(faker.name().firstName());
			usuario.setApellidos(faker.name().lastName());
			usuario.setEmail(faker.internet().emailAddress());
			usuario.setCargo(faker.job().toString());
			usuarioRepository.save(usuario);
		}
	}
}
