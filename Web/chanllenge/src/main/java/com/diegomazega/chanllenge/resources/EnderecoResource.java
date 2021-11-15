package com.diegomazega.chanllenge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegomazega.chanllenge.domain.Endereco;
import com.diegomazega.chanllenge.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource  {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> getAll(){
		List<Endereco> end = service.getAll();
		return ResponseEntity.ok(end);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> getById(@PathVariable Long id){
		Endereco end = service.getById(id);
		return ResponseEntity.ok(end);
	}
}
