package com.diegomazega.chanllenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegomazega.chanllenge.domain.Endereco;
import com.diegomazega.chanllenge.domain.Pessoa;
import com.diegomazega.chanllenge.repositories.EnderecoRepository;
import com.diegomazega.chanllenge.service.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repoEndereco;
	
	public List<Endereco> getAll(){
		return repoEndereco.findAll();
	}
	
	public Endereco getById(Long id) {
		Optional<Endereco> pessoa = repoEndereco.findById(id);
		return pessoa.orElseThrow(()-> new ObjectNotFoundException("Endereço não encontrando. ID: "+ id
				+". tipo: "+ Pessoa.class.getSimpleName()));
	}
	
	
}
