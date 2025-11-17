package com.proyecto.prueba.Controller;
import com.proyecto.prueba.Service.FakeUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/fake")

public class FakeUsuarioController {

	
	@Autowired
	public FakeUsuarioService fakeUsuarioService;

	
	@GetMapping("generar-fake-usuarios") //generar auto users
	public void generateFake(@RequestParam int count){
		fakeUsuarioService.generarFakeUsuario(count);
	}
}
