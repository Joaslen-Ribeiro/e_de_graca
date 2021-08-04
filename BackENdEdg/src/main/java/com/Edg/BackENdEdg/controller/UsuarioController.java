package com.Edg.BackENdEdg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Edg.BackENdEdg.model.Usuario;
import com.Edg.BackENdEdg.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	@Autowired
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
	@PostMapping
	public ResponseEntity<Usuario> post(@RequestBody Usuario post){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}
	@PutMapping
	public ResponseEntity<Usuario> put(@RequestBody Usuario put){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(put));
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		repository.deleteById(id);
		return "Deletado";
	}
	







}
