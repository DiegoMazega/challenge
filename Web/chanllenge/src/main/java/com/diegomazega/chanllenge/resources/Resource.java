package com.diegomazega.chanllenge.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class Resource<T> {
	
	
	@GetMapping
	public ResponseEntity<List<T>> getAll(){
		return ResponseEntity.ok(null);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<T> getById(@PathVariable Integer id){
		
		return ResponseEntity.ok(null);
	}
	
}
