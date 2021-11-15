package com.diegomazega.chanllenge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegomazega.chanllenge.domain.Funcionario;
import com.diegomazega.chanllenge.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAll(){
		List<Funcionario> func = service.getAll();
		return ResponseEntity.ok(func);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable Long id){
		Funcionario func = service.getById(id);
		return ResponseEntity.ok(func);
	}
	
}
