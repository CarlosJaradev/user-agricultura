package com.proyecto.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.prueba.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
