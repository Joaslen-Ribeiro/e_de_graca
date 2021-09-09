package com.Edg.BackENdEdg.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Edg.BackENdEdg.model.Usuario;
import com.Edg.BackENdEdg.model.UsuarioLogin;

import com.Edg.BackENdEdg.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin>loginUsuario(@RequestBody Optional<UsuarioLogin> usuarioLogin){
		return usuarioService.loginUsuario(usuarioLogin)
				.map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	@PostMapping ("/cadastrar")
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
		return usuarioService.cadastrarUsuario(usuario)
				.map(resp-> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario){
		return usuarioService.atualizarUsuario(usuario)
				.map(resp-> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	/*@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
	return ResponseEntity.ok(repository.findAll());
    }
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id ){
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity <List<Usuario>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		repository.deleteById(id);
		return "Deletado";
	}
	*/

}
