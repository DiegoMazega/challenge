package com.diegomazega.chanllenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegomazega.chanllenge.domain.Funcionario;
import com.diegomazega.chanllenge.domain.Pessoa;
import com.diegomazega.chanllenge.repositories.FuncionarioRepository;
import com.diegomazega.chanllenge.service.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repoFuncionario;
	
	public List<Funcionario> getAll(){
		return repoFuncionario.findAll();
	}
	
	public Funcionario getById(Long id) {
		Optional<Funcionario> pessoa = repoFuncionario.findById(id);
		return pessoa.orElseThrow(()-> new ObjectNotFoundException("Funcionario não encontrando. ID: "+ id
				+". tipo: "+ Pessoa.class.getSimpleName()));
	}
	
}
