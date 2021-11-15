package com.diegomazega.chanllenge.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diegomazega.chanllenge.domain.Pessoa;
import com.diegomazega.chanllenge.domain.dto.PessoaDTO;
import com.diegomazega.chanllenge.domain.dto.PessoaUpdateDTO;
import com.diegomazega.chanllenge.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
		
	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAll(){
		List<Pessoa> pessoas = service.getAll();
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable Long id){
		Pessoa pessoa = service.getById(id);
		return ResponseEntity.ok(pessoa);
	}
	
	@PostMapping(value = "/insert")
	public ResponseEntity<Void> insert(@Valid @RequestBody PessoaDTO obj){
		Pessoa pessoa = service.fromDTO(obj);
		pessoa = service.insert(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody PessoaUpdateDTO objDto, @PathVariable Long id){
		Pessoa obj = service.toUpadate(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
