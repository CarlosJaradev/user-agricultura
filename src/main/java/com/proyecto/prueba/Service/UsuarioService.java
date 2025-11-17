package com.proyecto.prueba.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.prueba.Model.Usuario;
import com.proyecto.prueba.Repository.UsuarioRepository;

@Service

/**
 * Clase para interactuar con el modelo usuario
 * @autor Carlos Daniel Jara Huaman
 * 2025 november 14th
 */
public class UsuarioService {
	
	@Autowired //crea instancia
	UsuarioRepository usuarioRepository;
	
	/**
	 * Método para listar todos los usuarios
	 * @param lista de usuarios
	 * @return todos los usuarios listados
	 */
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll(); //listar
		
	}
	/**
	 * Métoo para buscar usuario por id
	 * @param id
	 * @return un json del usuario si fue encontrado
	 */
	public Usuario getUserById(Long id) { // Buscar Usuario por id
		return usuarioRepository.findById(id).get();
	}
	/**
	 * Método para guardar un nuevo usuario
	 * @param usuario recibe objeto json con los campos de los usuarios
	 * @return agrega un usuario en formato json
	 */
	public Usuario saveUsuario(Usuario usuario) { // agrega usuario
		return usuarioRepository.save(usuario);
		
	}
	/**
	 * Método para eliminar un usuario
	 * @param id
	 */
	public void deleteUser(Long id) { // void por lo que solo elimina
		usuarioRepository.deleteById(id);
	} 
	/**
	 * 
	 * @param id atributo a extraer del usuario
	 * @param Newnombre atributo a modificar del usuario
	 * @return cambia el objeto json al atributo nombre
	 */
	public Usuario ChangeName(Long id ,String Newnombre) { //actualizar atributo
		Usuario u = getUserById(id);
		u.setNombres(Newnombre);
		return usuarioRepository.save(u);
		
	}
	/**
	 * 
	 * @param id atributo a extraer del usuario
	 * @param Newnombre atributo a modificar del usuario
	 * @return cambia el objeto json al atributo nombre
	 */
	public Usuario ChangeSurName(long id ,String Newsurnombre) { //actualizar atributo
		Usuario u = getUserById(id);
		u.setNombres(Newsurnombre);
		return usuarioRepository.save(u);
		
	}
	
}
