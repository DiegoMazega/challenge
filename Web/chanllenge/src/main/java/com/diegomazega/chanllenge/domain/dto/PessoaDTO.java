package com.diegomazega.chanllenge.domain.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.diegomazega.chanllenge.services.validation.PessoaInsert;

@PessoaInsert
public class PessoaDTO {
	
	@NotEmpty(message = "Preennchimmento Obrigatório")
	@Length(min = 1, max = 50, message = "O tamanho tem que ser entre 5 e 80 caracteres")
	private String nome;
	
	@NotNull(message = "Preennchimmento Obrigatório")
	private Integer idade;
	
	@NotEmpty(message = "Preennchimmento Obrigatório")
	private Set<String> telefones = new HashSet<>();

	@NotEmpty(message = "Preennchimmento Obrigatório")
	@Length(min = 1, max = 50, message = "O tamanho tem que ser entre 5 e 80 caracteres")
	private String cidadeNome;
	
	@NotEmpty(message = "Preennchimmento Obrigatório")
	@Length(min = 1, max = 50, message = "O tamanho tem que ser entre 5 e 80 caracteres")
	private String cidadeBairro;
	
	@NotEmpty(message = "Preennchimmento Obrigatório")
	@Length(min = 1, max = 8, message = "O tamanho tem que ser entre 5 e 80 caracteres")
	private String cep;
	
	@NotEmpty(message = "Preennchimmento Obrigatório")
	@Length(min = 1, max = 50, message = "O tamanho tem que ser entre 5 e 80 caracteres")
	private String cargo;
	
	@NotEmpty(message = "Preennchimmento Obrigatório")
	@Length(min = 1, max = 50, message = "O tamanho tem que ser entre 5 e 80 caracteres")
	private String funcionarioNome;
	
	@NotEmpty(message = "Preennchimmento Obrigatório")
	@Length(min = 1, max = 50, message = "O tamanho tem que ser entre 5 e 80 caracteres")
	private String empresa;
	
	public PessoaDTO() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public String getCidadeNome() {
		return cidadeNome;
	}

	public void setCidadeNome(String cidadeNome) {
		this.cidadeNome = cidadeNome;
	}

	public String getCidadeBairro() {
		return cidadeBairro;
	}

	public void setCidadeBairro(String cidadeBairro) {
		this.cidadeBairro = cidadeBairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFuncionarioNome() {
		return funcionarioNome;
	}

	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

		
	
}
