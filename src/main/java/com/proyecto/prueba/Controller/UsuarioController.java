package com.proyecto.prueba.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.proyecto.prueba.Model.Usuario;
import com.proyecto.prueba.Service.UsuarioService;


@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listar(){
		try {
			return ResponseEntity.ok(usuarioService.getAllUsuarios());
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();// TODO: handle exception
		}
	}
	@GetMapping("/{id}") //buscar por id
	public ResponseEntity<Usuario> GetUsuarioId(@PathVariable Long id){
		try {
			return ResponseEntity.ok(usuarioService.getUserById(id));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();// TODO: handle exception
		}
	}
	@PostMapping("/guardar")
	public ResponseEntity<Usuario>guardar(@RequestBody Usuario usuario){
		try {
			return ResponseEntity.ok(usuarioService.saveUsuario(usuario));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();// TODO: handle exception
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> DeleteUsuario(@PathVariable Long id){
		try {
			usuarioService.deleteUser(id);
			return ResponseEntity.notFound().build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();// TODO: handle exception
		}
	} 
	@PutMapping("/editname/{id}")
	public ResponseEntity<Usuario> EditName(@RequestParam Long id, @RequestParam String newname){
		try {
			Usuario actualizadoUsuario = usuarioService.ChangeName(id, newname);
			return ResponseEntity.ok(actualizadoUsuario);
		}
		catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();// TODO: handle exception
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();// TODO: handle exception
		}
	}
	@PutMapping("/editsurname/{id}")
	public ResponseEntity<Usuario> EditSurName(@RequestParam Long id, @RequestParam String newsurname){
		try {
			Usuario actualizadoUsuario = usuarioService.ChangeSurName(id, newsurname);
			return ResponseEntity.ok(actualizadoUsuario);
		}
		catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();// TODO: handle exception
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();// TODO: handle exception
		}
	}
}
