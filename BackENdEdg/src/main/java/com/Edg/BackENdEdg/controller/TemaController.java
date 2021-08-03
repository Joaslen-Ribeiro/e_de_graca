package com.Edg.BackENdEdg.controller;

import java.time.LocalDate;
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

import com.Edg.BackENdEdg.model.modelTema;
import com.Edg.BackENdEdg.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {

	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity <List<modelTema>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity <modelTema> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/area/{area}")
	public ResponseEntity <List<modelTema>> getByArea(@PathVariable String area){
		return ResponseEntity.ok(repository.findAllByAreaContainingIgnoreCase(area));
	}
	
	@GetMapping("/tipoDeAcao/{tipoDeAcao}")
	public ResponseEntity <List<modelTema>> getByTipoDeAcao(@PathVariable String tipoDeAcao){
		return ResponseEntity.ok(repository.findAllByTipoDeAcaoContainingIgnoreCase(tipoDeAcao));
	}
	@GetMapping("/publico/{publico}")
	public ResponseEntity <List<modelTema>> getByPublico(@PathVariable String publico){
		return ResponseEntity.ok(repository.findAllByPublicoContainingIgnoreCase(publico));
		}
	@GetMapping("/cidade/{cidade}")
	public ResponseEntity <List<modelTema>> getByCidade(@PathVariable String cidade){
		return ResponseEntity.ok(repository.findAllByCidadeContainingIgnoreCase(cidade));
		}
	@GetMapping("/area/{area}")
	public ResponseEntity <List<modelTema>> getByData(@PathVariable LocalDate data){
		return ResponseEntity.ok(repository.findAllByData(data));
		}
	
	@PostMapping
	public ResponseEntity <modelTema> post(@RequestBody modelTema post ){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}
	@PutMapping
	public ResponseEntity <modelTema> put (@RequestBody modelTema put){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(put));
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		repository.deleteById(id);
		return "Deletado";
	}
	
	
	
	
	
	
	
}
