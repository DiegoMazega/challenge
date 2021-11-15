package com.diegomazega.chanllenge.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.diegomazega.chanllenge.domain.Endereco;
import com.diegomazega.chanllenge.domain.Funcionario;
import com.diegomazega.chanllenge.domain.Pessoa;
import com.diegomazega.chanllenge.domain.dto.PessoaDTO;
import com.diegomazega.chanllenge.domain.dto.PessoaUpdateDTO;
import com.diegomazega.chanllenge.repositories.EnderecoRepository;
import com.diegomazega.chanllenge.repositories.FuncionarioRepository;
import com.diegomazega.chanllenge.repositories.PessoaRepository;
import com.diegomazega.chanllenge.service.exceptions.DataIntegrityException;
import com.diegomazega.chanllenge.service.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repoPessoa;
	@Autowired
	private FuncionarioRepository repoFuncionario;
	@Autowired
	private EnderecoRepository repoEndereco;

	public List<Pessoa> getAll() {
		return repoPessoa.findAll();
	}

	public Pessoa getById(Long id) {
		Optional<Pessoa> pessoa = repoPessoa.findById(id);
		return pessoa.orElseThrow(() -> new ObjectNotFoundException(
				"Pessoa não encontranda. ID: " + id + ". tipo: " + Pessoa.class.getSimpleName()));
	}

	@Transactional
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		obj = repoPessoa.save(obj);
		repoEndereco.saveAll(obj.getEnderecos());
		repoFuncionario.save(obj.getFuncionario());
		return obj;
	}

	public Pessoa update(Pessoa obj) {
		Pessoa newObj = getById(obj.getId());
		updateData(newObj, obj);
		return repoPessoa.save(newObj);
	}

	public void delete(Long id) {
		getById(id);
		try {
			repoPessoa.deleteById(id);
		} catch (DataIntegrityViolationException event) {
			throw new DataIntegrityException("Erro ao tentar Excluir A Pessoa do Sistema");
		}
	}

	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setEnderecos(obj.getEnderecos());
		newObj.setFuncionario(obj.getFuncionario());
		newObj.setTelefones(obj.getTelefones());
	}

	public Pessoa fromDTO(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa(null, dto.getNome(), dto.getIdade(), null);
		Funcionario func = new Funcionario(null, dto.getCargo(), dto.getEmpresa(),
				dto.getFuncionarioNome(), pessoa);
		pessoa.setFuncionario(func);
		Endereco end = new Endereco(null, dto.getCidadeNome(), dto.getCidadeBairro(), dto.getCep(), pessoa);
		pessoa.getEnderecos().add(end);
		pessoa.setTelefones(dto.getTelefones());

		return pessoa;
	}
	
	public Pessoa toUpadate(PessoaUpdateDTO dto) {
		return new Pessoa(null, null, dto.getIdade(), dto.getTelefones());
	}
}
